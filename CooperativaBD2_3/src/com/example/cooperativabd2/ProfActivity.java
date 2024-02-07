package com.example.cooperativabd2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_profesion);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void retornar(View vista){
		finish();
	}
	
	
	public void buscarProf(View vista){
		
		EditText et = (EditText) findViewById(R.id.editTextProf1);
		TextView tv = (TextView) findViewById(R.id.textViewProf2);
		String xdepto = et.getText().toString();
		
		Cooperativa bd = new Cooperativa(ProfActivity.this);
		
		
		try {
			bd.apertura();
			String resultado = bd.buscarprof(xdepto);
			tv.setText(resultado);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
