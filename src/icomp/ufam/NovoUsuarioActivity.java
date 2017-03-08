package icomp.ufam;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.RadioGroup;

	public class NovoUsuarioActivity extends Activity {
		  @Override
		  protected void onCreate(Bundle savedInstanceState) {
		    super.onCreate(savedInstanceState);
		    setContentView(R.layout.activity_novo_usuario);
		  }
		
		
		  public void cadastrarUsuarios(View view) {
		    EditText inputLogin = (EditText) findViewById(R.id.inputNovoPrioridade);
		    EditText inputNome  = (EditText) findViewById(R.id.inputNovoDescricao);
		    EditText inputSenha = (EditText) findViewById(R.id.inputNovaDataEntrega);
		    RadioGroup groupTipo = (RadioGroup) findViewById(R.id.radioGroupNovoTipo); 
		   // int tipo = groupTipo.getCheckedRadioButtonId() == R.id.novoTipoAluno ? 1:2;
		    int aux=1;
		    if ( groupTipo.getCheckedRadioButtonId() == R.id.novoTipoAluno) aux=1;
		    if ( groupTipo.getCheckedRadioButtonId() == R.id.novoTipoProfessor) aux=2;
		    if ( groupTipo.getCheckedRadioButtonId() == R.id.novoTipoPais) aux=3;
		  
		    int tipo = aux;
		    Usuario usuario = new Usuario(inputLogin.getText().toString(),  
		        inputNome.getText().toString(), inputSenha.getText().toString(), tipo);
		
		    UsuarioDAO usuarioDAO = new UsuarioDAO(this);
		    if (usuarioDAO.addUsuario(usuario))
		      Toast.makeText(this, "Usuário criado!", Toast.LENGTH_SHORT).show();
		    else
		      Toast.makeText(this, "Erro ao criar usuário!", Toast.LENGTH_SHORT).show();
		    finish();
		
		}

}



