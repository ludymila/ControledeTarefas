package icomp.ufam;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Novo_usuario extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_novo_usuario);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.novo_usuario, menu);
		return true;
	}

}
