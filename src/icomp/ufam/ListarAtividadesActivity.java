package icomp.ufam;
import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


	public class ListarAtividadesActivity extends ListActivity {

		

		

		private AtividadeDAO atividadeDAO;
		private ListAdapter adapter;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			this.atividadeDAO = new AtividadeDAO(this);

			adapter = new ListAdapter(this); 
			
			setListAdapter(adapter);

		}
		
		@Override
		protected void onResume() {
			super.onResume();
			adapter.update();
			
		}

		private class ListAdapter extends BaseAdapter {
			
			private ArrayList<Atividade> atividades = new ArrayList<Atividade>();
			private LayoutInflater inflater; 
			public ListAdapter (Context c) {
				this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			}
			
			@Override
			public int getCount() {
				return atividades.size();
			}

			@Override
			public Atividade getItem(int posicao) {
				return atividades.get(posicao);
			}

			@Override
			public long getItemId(int posicao) {
				// TODO Auto-generated method stub
				return  (long) posicao;
			}

			@Override
			public View getView(final int pos, View v, ViewGroup parent) {
				if (v == null)
					v = inflater.inflate(R.layout.atividade_linha, null);
				
				TextView textDescricao = (TextView) v.findViewById(R.id.atividade_linha_descricao);
				TextView textPrioridade = (TextView) v.findViewById(R.id.atividade_linha_prioridade);
				TextView textDataEntrega = (TextView) v.findViewById(R.id.atividade_linha_dataEntrega);
				TextView textDataRalizacao = (TextView) v.findViewById(R.id.atividade_linha_dataRealizacao);
				TextView textNota = (TextView) v.findViewById(R.id.atividade_linha_nota);
				TextView textDisciplina = (TextView) v.findViewById(R.id.atividade_linha_disciplina);
				Button btnApagar = (Button) v.findViewById(R.id.button2);
				
				final Atividade at = getItem(pos);
				
				textDescricao.setText(at.getDescricao());
				textPrioridade.setText(String.valueOf(at.getPrioridade()));
				textDataEntrega.setText(at.getDataEntrega());
				textDataRalizacao.setText(at.getDataRealizacao());
				textDisciplina.setText(at.getDisciplina());
				textNota.setText(at.getNota());
				
				btnApagar.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						

							atividadeDAO.deleteAtividade(at);
							atividades.remove(pos);
							notifyDataSetChanged();
						
					}
				});
				
				v.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						Intent it = new Intent(ListarAtividadesActivity.this, CriaAtividadeActivity.class);
						it.putExtra("atividade", at);
						ListarAtividadesActivity.this.startActivity(it);
					}
				});
				return v;
			}
			
			public void update(){
				atividades = atividadeDAO.getAtividadesArrayList();
				notifyDataSetChanged();
			}
			
		}
		
		
//		@Override
//		protected void onListItemClick(ListView l, View v, int position, long id) {
//			// TODO Auto-generated method stub
//			Intent it = new Intent(this, CriaAtividadeActivity.class);
//			it.putExtra("atividade", adapter.getItem(position));
//			super.onListItemClick(l, v, position, id);
//			
//		}
//	public void onListItemClick(ListView l, View v, int pos, long id) {
		
//	}
		
		/*public void alterarAtividade(View v){
			
			this.atividadeDAO = new AtividadeDAO(this);
			String textLogin = 
	               v.findViewById(R.id.atividade_linha_login).toString();
			String textNome = 
		               v.findViewById(R.id.atividade_linha_nome).toString();
		
				      atividadeDAO.updateAtividade(textNome,textLogin); 
				      
				 
			
			
		}*/


	}



