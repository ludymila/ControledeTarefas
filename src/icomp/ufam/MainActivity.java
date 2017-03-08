package icomp.ufam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 public void entrarClicando(View view) {
		    Intent intent = new Intent(this, BemVindoActivity.class);
		    EditText inputLogin = (EditText) findViewById(R.id.edtlogin);
		    EditText inputSenha = (EditText) findViewById(R.id.edtSenha);
		    
		    RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup1);
		    RadioButton radioSelected = (RadioButton) findViewById(group.getCheckedRadioButtonId());
		    String tipo = radioSelected.getText().toString();
		    // Verifica a senha
		
		    UsuarioDAO usuarioDAO = new UsuarioDAO(this);
		    
		    
		    Usuario usuario = usuarioDAO.getUsuario(inputSenha.getText().toString(),
		                                            inputLogin.getText().toString(), tipo); 
		    if (usuario != null) {
		      intent.putExtra("login", usuario.getLogin());
		      intent.putExtra("senha", usuario.getSenha());
		      intent.putExtra("tipo", tipo);
		      startActivity(intent);
		
		    } else {
		      Toast.makeText(this, "Usuario , Senha ou Tipo invalidos!", 
		                       Toast.LENGTH_SHORT).show();
	}

}
	 
	 public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		
		
		        case R.id.novo_usuario:
		        	Intent intent = new Intent(this, NovoUsuarioActivity.class);
		           startActivity(intent);
		           return true;
		       
		        case R.id.sobre:
		        	AlertDialog.Builder alert = new AlertDialog.Builder(this);
		            alert.setMessage("Controle de Tarefas v1.0")
		                 .setNeutralButton("Ok", null).show();
		            return true;
		        
		    
		        default:
		            return super.onOptionsItemSelected(item);
		   
	 }

}
}
	 
