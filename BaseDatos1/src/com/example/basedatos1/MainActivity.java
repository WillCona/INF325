 package com.example.basedatos1;

import java.io.PrintWriter;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView tv = (TextView) findViewById(R.id.textView1);
		
		try {
			Productos p = new Productos(MainActivity.this);
			p.apertura();
			long c = p.Insertar(9121, "fanta", "UND", 6, "6060", 350);
			Toast.makeText(this, "Cbytes: "+c, Toast.LENGTH_SHORT).show();
			
			String salida = p.Listar();
			tv.setText(salida);
			p.cerrar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
