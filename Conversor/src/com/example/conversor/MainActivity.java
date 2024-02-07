package com.example.conversor;

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
			double [] moneda = {1.04, 0.04732,0.008,0.02388,0.00173,1.8614,1.39986,0.00094};
			
			EditText pbs = (EditText) findViewById(R.id.editText1);
			
			String sbs = pbs.getText().toString();
			double vbs = Double.parseDouble(sbs);
			
			EditText ps1 = (EditText) findViewById(R.id.editText2);
			ps1.setText(String.valueOf(vbs/moneda[0]));
			
			EditText ps2 = (EditText) findViewById(R.id.editText3);
			ps2.setText(String.valueOf(vbs/moneda[1]));
			
			EditText ps3 = (EditText) findViewById(R.id.editText4);
			ps3.setText(String.valueOf(vbs/moneda[2]));
			
			EditText ps4 = (EditText) findViewById(R.id.editText5);
			ps4.setText(String.valueOf(vbs/moneda[3]));
			
			EditText ps5 = (EditText) findViewById(R.id.editText6);
			ps5.setText(String.valueOf(vbs/moneda[4]));
			
			EditText ps6 = (EditText) findViewById(R.id.editText7);
			ps6.setText(String.valueOf(vbs/moneda[5]));
			
			EditText ps7 = (EditText) findViewById(R.id.editText8);
			ps7.setText(String.valueOf(vbs/moneda[6]));

			EditText ps8 = (EditText) findViewById(R.id.editText9);
			ps8.setText(String.valueOf(vbs/moneda[7]));
					
		} catch (Exception e) {
			System.out.println("Hola mundo");
		}	
	}
	
	public void borrar(View vista){
		

		EditText ps0 = (EditText) findViewById(R.id.editText1);
		ps0.setText("");
		
		
		EditText ps1 = (EditText) findViewById(R.id.editText2);
		ps1.setText("");
		
		EditText ps2 = (EditText) findViewById(R.id.editText3);
		ps2.setText("");
		
		EditText ps3 = (EditText) findViewById(R.id.editText4);
		ps3.setText("");
		
		EditText ps4 = (EditText) findViewById(R.id.editText5);
		ps4.setText("");
		
		EditText ps5 = (EditText) findViewById(R.id.editText6);
		ps5.setText("");
		
		EditText ps6 = (EditText) findViewById(R.id.editText7);
		ps6.setText("");
		
		EditText ps7 = (EditText) findViewById(R.id.editText8);
		ps7.setText("");

		EditText ps8 = (EditText) findViewById(R.id.editText9);
		ps8.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
