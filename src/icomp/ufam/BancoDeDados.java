package icomp.ufam;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BancoDeDados extends SQLiteOpenHelper{

		  public static final int DATABASE_VERSION = 2;
		  public static final String DATABASE_NAME = "HelloWorldApp.db";
		  
		  private static final String SQL_CREATE_TABLES = "CREATE TABLE Usuarios(" +
			      "login TEXT PRIMARY KEY, nome TEXT, senha TEXT, tipo INT)";
			private static final String SQL_CREATE_TABLES2 = "CREATE TABLE Atividades(" +
			      "id INTEGER PRIMARY KEY AUTOINCREMENT, prioridade INTEGER, descricao TEXT, dataEntrega TEXT, dataRealizacao TEXT, disciplina TEXT, nota TEXT)";
		  
			  private static final String SQL_POPULATE_TABLES = "INSERT INTO Usuarios " +
			      "VALUES ('oi', 'oi', 'oi', 1)";
			      private static final String SQL_POPULATE_TABLES2 = "INSERT INTO Atividades " +
				      "VALUES (1, 'trabalho', 'hoje', 'abril', 'materia', '10')";
			  private static final String SQL_DELETE_TABLES = "DROP TABLE IF EXISTS Usuarios";
			  
			  public BancoDeDados(Context context) {
				  
				      super(context, DATABASE_NAME, null, DATABASE_VERSION);
				    }
			  public void onCreate(SQLiteDatabase db) {
				  
				  db.beginTransaction();
				          try
				          {
				        	  db.execSQL(SQL_CREATE_TABLES);
				        	  db.execSQL(SQL_CREATE_TABLES2);
				        	  db.execSQL(SQL_POPULATE_TABLES);
				              // Cria a tabela e testa os dados
				              db.setTransactionSuccessful();
				          }
				          catch (SQLException e)
				          {
				              Log.e("Erro ao criar as tabelas e testar os dados", e.toString());
				          }
				          finally
				          {
				              db.endTransaction();
				          }

				  
				  
			  }
			  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
				   
				  db.beginTransaction();
		          try
		          {
		        	  db.execSQL(SQL_DELETE_TABLES);
		              // Cria a tabela e testa os dados
		              db.setTransactionSuccessful();
		          }
		          catch (SQLException e)
		          {
		              Log.e("Erro ao criar as tabelas e testar os dados", e.toString());
		          }
		          finally
		          {
		              db.endTransaction();
		          }
				  
				  
				    onCreate(db);		
				  }



}
