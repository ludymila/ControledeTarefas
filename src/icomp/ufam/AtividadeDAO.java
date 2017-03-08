package icomp.ufam;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class AtividadeDAO {

	  private SQLiteDatabase bancoDeDados;
		
	
	  public AtividadeDAO(Context context) {
	    this.bancoDeDados = (new BancoDeDados(context)).getWritableDatabase();
	  }
	
	  public Atividade getAtividade(String descricao) {
	    Atividade atividade = null;
	
	    String sqlQuery = "SELECT * FROM Atividades WHERE " +
	                      "descricao='" + descricao + "'";
	    Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);
	    
	    if (cursor.moveToNext()) {
	
	        atividade = new Atividade(cursor.getInt(1), cursor.getInt(2),descricao, cursor.getString(4), 
	                              cursor.getString(5), cursor.getString(6),cursor.getString(7));
	        
	        
	    }
	    cursor.close();
	    return atividade;
	  }
//---------------------------------------------------------------------------------------------------------
	  public boolean addAtividade(Atividade u) {
		  
		      try {
		        String sqlCmd = "INSERT INTO Atividades VALUES (0,'" + 
		                          u.getPrioridade() + "'," + " '" + u.getDescricao() + "', '" + 
		                          u.getDataEntrega() + "'," + " '" + u.getDataRealizacao() + "', '" +
		                          u.getDisciplina() + "'," + " '" +
		                           u.getNota()+"')";
		        
		        this.bancoDeDados.execSQL(sqlCmd);
		 
		        return true;
		  
		      } catch (SQLException e) {
		        Log.e("HelloAppBD", e.getMessage());
		        return false;
		      }
	}
	  
//---------------------------------------------------------------------------------------------------------	
	  public boolean updateAtividade(Atividade at) {
		  
	      try {
	        String sqlCmd = ("UPDATE Atividades SET " + 
	        				"prioridade="   + at.getPrioridade() + ", " +
	        				"descricao='"   + at.getDescricao() + "', " +
	        				"dataEntrega='"   + at.getDataEntrega() + "', " +
	        				"dataRealizacao='"   + at.getDataRealizacao() + "', " +
	        				"disciplina='"   + at.getDisciplina() + "', " +
	        				"nota='"   + at.getNota() + "' " +
	        				"WHERE id = " + at.getId());
	                          
	        this.bancoDeDados.execSQL(sqlCmd);
	 
	        return true;
	  
	      } catch (SQLException e) {
	        Log.e("HelloAppBD", e.getMessage());
	        return false;
	      }
}	
	  
	  
	  
	  
//---------------------------------------------------------------------------------------------------------
 public boolean deleteAtividade(Atividade at) {
		  
	      try {
	        String sqlCmd = ("DELETE FROM Atividades " + 
	        				"WHERE id = " + at.getId());
	                          
	        this.bancoDeDados.execSQL(sqlCmd);
	 
	        return true;
	  
	      } catch (SQLException e) {
	        Log.e("HelloAppBD", e.getMessage());
	        return false;
	      }
}	
	  
	  
	  
	  
//---------------------------------------------------------------------------------------------------------
	public Cursor getAtividades() {
		return this.bancoDeDados.rawQuery("SELECT * " +

		"FROM Atividades ORDER BY prioridade", null);
	}
	
	public ArrayList<Atividade> getAtividadesArrayList() {
		ArrayList<Atividade> atividades = null;
		Cursor cursor = this.bancoDeDados.rawQuery("SELECT * " +
				"FROM Atividades ORDER BY prioridade", null);
		
		if (cursor != null) {
			atividades = new ArrayList<Atividade>();
			while (cursor.moveToNext()) {
				Atividade atividade = new Atividade(cursor.getLong(cursor.getColumnIndex("id")),cursor.getInt(cursor.getColumnIndex("prioridade")),cursor.getString(cursor.getColumnIndex("descricao")),
						cursor.getString(cursor.getColumnIndex("dataEntrega")), 
		                cursor.getString(cursor.getColumnIndex("dataRealizacao")), cursor.getString(cursor.getColumnIndex("disciplina")),
		                cursor.getString(cursor.getColumnIndex("nota")));
				atividades.add(atividade);
			}
		}
		return atividades;
	}



}


