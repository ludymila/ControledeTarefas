package icomp.ufam;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class UsuarioDAO {
	
		  private SQLiteDatabase bancoDeDados;
		
		  public UsuarioDAO(Context context) {
		    this.bancoDeDados = (new BancoDeDados(context)).getWritableDatabase();
		  }
		
		  public Usuario getUsuario(String login, String senha, String tipo) {
		    Usuario usuario = null;
		   
		    if (!(tipo.equals("1")) && (!(tipo.equals("2"))) && (!(tipo.equals("3"))) ) {
				if (tipo.equals("Aluno")) tipo= "1";
				else if (tipo.equals("Professor")) tipo="2";
				else tipo= "3";
			    }
			  
		    String sqlQuery = "SELECT * FROM Usuarios WHERE " +
		                      "login='" + login + "' AND tipo=" + tipo  + " AND senha='" + senha + "'";
		    Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);
		    
		    if (cursor.moveToNext()) {
		
		        usuario = new Usuario(login, cursor.getString(1), 
		                              cursor.getString(2), cursor.getInt(3));
		    }
		    cursor.close();
		    return usuario;
		  }
//---------------------------------------------------------------------------------------------------------
		  public boolean addUsuario(Usuario u) {
			  
			      try {
			        String sqlCmd = "INSERT INTO Usuarios VALUES ('" + 
			                          u.getLogin() + "'," + " '" + u.getNome() + "', '" + 
			                           u.getSenha()+ "', " + u.getTipo() + ")";
			        this.bancoDeDados.execSQL(sqlCmd);
			 
			        return true;
			  
			      } catch (SQLException e) {
			        Log.e("HelloAppBD", e.getMessage());
			        return false;
			      }
		}
		  
//---------------------------------------------------------------------------------------------------------	
		  public boolean updateUsuario(CharSequence charSequence, CharSequence charSequence2) {
			  
		      try {
		        String sqlCmd = ("UPDATE Usuarios SET " + 
		        				
		        				"nome='"   + charSequence + "', " +
		        				"WHERE login='" + charSequence2 + "'");
		                          
		        this.bancoDeDados.execSQL(sqlCmd);
		 
		        return true;
		  
		      } catch (SQLException e) {
		        Log.e("HelloAppBD", e.getMessage());
		        return false;
		      }
	}	
		  
		  
		  
		  
//---------------------------------------------------------------------------------------------------------
		  public Cursor getUsuarios() {
			      return this.bancoDeDados.rawQuery("SELECT rowid AS _id, " +  
			             "login, nome, " + 
			             "CASE WHEN tipo=1 THEN 'Aluno' WHEN tipo=2 THEN 'Professor' ELSE 'Pais' END AS tipo " + 
			             "FROM Usuarios ORDER BY login", null);
			    }



}
