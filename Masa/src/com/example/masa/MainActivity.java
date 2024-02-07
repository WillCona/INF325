package com.example.masa;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	public void convertir(View vista){
		try {
			EditText k = (EditText) findViewById(R.id.editText1);
			
			double kl = Double.parseDouble(k.getText().toString());
			
			EditText t1 = (EditText) findViewById(R.id.editText2);
			
			t1.setText(String.valueOf(kl*2.20));
			
			EditText t2 = (EditText) findViewById(R.id.editText3);
			
			t2.setText(String.valueOf(kl*1000));
			
			EditText t3 = (EditText) findViewById(R.id.editText4);
			
			t3.setText(String.valueOf(kl*0.09));
			
			EditText t4 = (EditText) findViewById(R.id.editText5);
			
			t4.setText(String.valueOf(kl*0.01));
			
			EditText t5 = (EditText) findViewById(R.id.editText6);
			
			t5.setText(String.valueOf(kl*35.27));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void limpiar(View vista){
		EditText k = (EditText) findViewById(R.id.editText1);
		
		k.setText("");
		
		EditText t1 = (EditText) findViewById(R.id.editText2);
		
		t1.setText("");
		
		EditText t2 = (EditText) findViewById(R.id.editText3);
		
		t2.setText("");
		
		EditText t3 = (EditText) findViewById(R.id.editText4);
		
		t3.setText("");
		
		EditText t4 = (EditText) findViewById(R.id.editText5);
		
		t4.setText("");
		
		EditText t5 = (EditText) findViewById(R.id.editText6);
		
		t5.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
