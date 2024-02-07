package com.example.miscelanea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

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
	
	public void platos(View vista){
		Intent vPlatos = new Intent(this, PlatosActivity.class);
		startActivity(vPlatos);
	}
	
	public void postres(View vista){
		Intent vPostres = new Intent(this, PostresActivity.class);
		startActivity(vPostres);
	}
	
	public void refrescos(View vista){
		Intent vRefrescos = new Intent(this, RefrescosActivity.class);
		startActivity(vRefrescos);
	}
	
	public void tragos(View vista){
		Intent vTragos = new Intent(this, TragosActivity.class);
		startActivity(vTragos);
	}
	
	
	public void salir(View vista){
		finish();
	}
}
