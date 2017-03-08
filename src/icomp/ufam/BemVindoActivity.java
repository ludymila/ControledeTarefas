package icomp.ufam;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BemVindoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bem_vindo);
		
		Intent intent = getIntent();
		
		  Bundle parametros = intent.getExtras();
		  
		  
		  String login = parametros.getString("login");;
		  String senha = intent.getStringExtra("senha");
		  String tipo = intent.getStringExtra("tipo");
		  
		  TextView textBemVindo = 
		    (TextView) findViewById(R.id.textBemVindo);

		  textBemVindo.setText(Html.fromHtml(
		    "Olá <b>" + login +  
		    "</b>! Você é <i>" + tipo + 
		    "</i>.<br><br> Bem Vindo!"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bem_vindo, menu);
		return true;
	}

	public void abrirListarUsuarios(View view) {
		Intent intent = new Intent(this, ListarUsuariosActivity.class);
		String tipo = intent.getStringExtra("tipo");
		 intent.putExtra("tipo", tipo);
		startActivity(intent);
	}

	public void abrirListarAtividades(View view) {
		Intent intent = new Intent(this, ListarAtividadesActivity.class);
		String tipo = intent.getStringExtra("tipo");
		 intent.putExtra("tipo", tipo);
		startActivity(intent);
	}

	public void criaTarefa(View view) {
		Intent intent = getIntent();
		String tipo = intent.getStringExtra("tipo");
		if (!(tipo.equals("Pais"))){
			intent = new Intent(this, CriaAtividadeActivity.class);
			startActivity(intent);
		}
		else {
			Toast.makeText(this, "Desculpe, voce nao tem permissao para criar novas Atividades ",  Toast.LENGTH_SHORT).show();
		}
	}

}
