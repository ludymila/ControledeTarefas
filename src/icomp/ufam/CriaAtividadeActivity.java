package icomp.ufam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CriaAtividadeActivity extends Activity {
	
	private AtividadeDAO atividadeDao;
	private Bundle extras;
	private Atividade atividade;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cria_atividade);
		
		EditText edtPrioridade = (EditText) findViewById(R.id.inputNovoPrioridade);
		EditText edtDescricao = (EditText) findViewById(R.id.inputNovoDescricao);
		EditText edtDataEntrega = (EditText) findViewById(R.id.inputNovaDataEntrega);
		EditText edtDataRealizacao = (EditText) findViewById(R.id.inputNovaDataRealizacao );
		EditText edtDisciplina = (EditText) findViewById(R.id.inputNovaDisciplina);
		EditText edtNota = (EditText) findViewById(R.id.inputNovaNota);
		
		extras = getIntent().getExtras();
		
		if (extras != null) {
			atividade = (Atividade) extras.get("atividade");
			
			edtPrioridade.setText(String.valueOf(atividade.getPrioridade()));
			edtDescricao.setText(String.valueOf(atividade.getDescricao()));
			edtDataEntrega.setText(String.valueOf(atividade.getDataEntrega()));
			edtDataRealizacao.setText(String.valueOf(atividade.getDataRealizacao()));
			edtDisciplina.setText(String.valueOf(atividade.getDisciplina()));
			edtNota.setText(String.valueOf(atividade.getNota()));
			
			//TODO chamada pela alterar, preencher o formulario com as informacoes da atividade
		}
		atividadeDao = new AtividadeDAO(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cria_atividade, menu);
		return true;
	}
	
	public void cadastrarAtividades(View v){
		Intent intent = getIntent();
		String tipo = intent.getStringExtra("tipo");
		//So pode apagar se nao for do tipo Pais
		
				
			
			EditText edtPrioridade = (EditText) findViewById(R.id.inputNovoPrioridade);
			EditText edtDescricao = (EditText) findViewById(R.id.inputNovoDescricao);
			EditText edtDataEntrega = (EditText) findViewById(R.id.inputNovaDataEntrega);
			EditText edtDataRealizacao = (EditText) findViewById(R.id.inputNovaDataRealizacao );
			EditText edtDisciplina = (EditText) findViewById(R.id.inputNovaDisciplina);
			EditText edtNota = (EditText) findViewById(R.id.inputNovaNota);
			
			//ALTERAR
			if (atividade != null) {
				atividade.setPrioridade(Integer.parseInt(edtPrioridade.getText().toString()));
				atividade.setDescricao(edtDescricao.getText().toString());
				atividade.setDataEntrega(edtDataEntrega.getText().toString());
				atividade.setDataRealizacao(edtDataRealizacao.getText().toString());
				atividade.setDisciplina(edtDisciplina.getText().toString());
				atividade.setNota(edtNota.getText().toString());
				
				atividadeDao.updateAtividade(atividade);
				Toast.makeText(this, "Recadastrado com sucesso", Toast.LENGTH_SHORT).show();
			}
			else {// Cadastrar
				atividade = new Atividade();
				atividade.setPrioridade(Integer.parseInt(edtPrioridade.getText().toString()));
				atividade.setDescricao(edtDescricao.getText().toString());
				atividade.setDataEntrega(edtDataEntrega.getText().toString());
				atividade.setDataRealizacao(edtDataRealizacao.getText().toString());
				atividade.setDisciplina(edtDisciplina.getText().toString());
				atividade.setNota(edtNota.getText().toString());
				
				atividadeDao.addAtividade(atividade);
				Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
			}
			
			finish();
		}
		
	
}
