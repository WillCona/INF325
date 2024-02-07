package com.example.archivo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//lectura del archivo
		
		
		try {
			AssetManager p = getAssets();
			InputStream lee = p.open("manual.txt");
			
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			byte[] cont = new byte[1024]; /*tamanio de bytes*/
			int largo = 0 , contador = 0;
			while ((largo = lee.read(cont)) > 0) {
				bs.write(cont,0, largo);
				contador++;
			}
			lee.close();
			
			String resultado = new String(bs.toByteArray(),"UTF-8");
			
			TextView t1 = (TextView) findViewById(R.id.textView1);
			Toast.makeText(this, "vamos "+contador, Toast.LENGTH_LONG).show();
			t1.setText(resultado);
			//p.close();
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
	
	public void botoncito1(View vista){
		
		
		String nm = bo 
		
		
		
		
	}

}
