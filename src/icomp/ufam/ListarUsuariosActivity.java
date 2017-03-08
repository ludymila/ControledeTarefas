package icomp.ufam;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ListarUsuariosActivity extends ListActivity {

	private UsuarioDAO usuarioDAO;
	  private CursorAdapter dados;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.usuarioDAO = new UsuarioDAO(this);

		dados = new SimpleCursorAdapter(this, 
			      R.layout.usuario_linha,
			      usuarioDAO.getUsuarios(), 
			      new String[] { "login", "nome", "tipo" },
			      new int[] { R.id.usuario_linha_login,
			      R.id.usuario_linha_nome,
			      R.id.usuario_linha_tipo }, 0);
			 
		
		setListAdapter(dados);

	}


	public void onListItemClick(ListView l, View v, int pos, long id) {
	    TextView textLogin = 
	                   (TextView) v.findViewById(R.id.usuario_linha_login);
	    Toast.makeText(this, "Usuario " + textLogin.getText().toString(),  
	                   Toast.LENGTH_SHORT).show();
	  }
	
	public void alterarUsuario(View v){
		Intent intent = getIntent();
		String tipo = intent.getStringExtra("tipo");
		//So pode alterar se nao for do tipo Pais
		if (!(tipo.equals("Pais"))){	
			this.usuarioDAO = new UsuarioDAO(this);
			String textLogin = 
	        v.findViewById(R.id.usuario_linha_login).toString();
			String textNome =  v.findViewById(R.id.usuario_linha_nome).toString();
			usuarioDAO.updateUsuario(textNome,textLogin); 
		}
		
		else{
			Toast.makeText(this, "Desculpe, voce nao tem permissao para modificar usuarios ",  Toast.LENGTH_SHORT).show();
		}
			 
		
		
	}


}
