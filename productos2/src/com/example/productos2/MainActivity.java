package com.example.productos2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	String cadenas = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    TextView tv = (TextView)findViewById(R.id.textView2);
	    String estado = Environment.getExternalStorageState();
	    if (!estado.equals(Environment.MEDIA_MOUNTED)) {
	        Toast.makeText(this, "No hay acceso a memoria interna", Toast.LENGTH_LONG).show();
	        finish();
	    }
	    try {
	        File dir = Environment.getExternalStorageDirectory();
	        File pt = new File(dir.getAbsolutePath() + File.separator + "lineas.txt");
	        BufferedReader lee = new BufferedReader(new FileReader(pt));
	        StringBuilder texto = new StringBuilder();
	        String registro;
	        boolean sw = true;
	        while ((registro = lee.readLine()) != null) {
	        	cadenas = cadenas + registro +"\n";
	            texto.append(registro);
	            texto.append("\n");
	        }
	        lee.close();
	        tv.setText(texto);
	    } catch (IOException e) {
	        e.printStackTrace(); // Maneja la excepción o muestra un mensaje de error aquí
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void buscar(View vista){
		Button b = (Button) findViewById(R.id.button2);
		b.setVisibility(View.VISIBLE);
		int items = 0,existencia=0;
		EditText et = (EditText) findViewById(R.id.editText1);
		TextView tv = (TextView) findViewById(R.id.textView2);
		String cod = et.getText().toString();
		StringBuilder cadena = new StringBuilder();
		String estado = Environment.getExternalStorageState();
		if(!estado.equals(Environment.MEDIA_MOUNTED)){
			Toast.makeText(this, "No hay acceso a memoria interna", Toast.LENGTH_LONG).show();
			finish();
		}
		try {
			File dir = Environment.getExternalStorageDirectory();
			File pt = new File(dir.getAbsolutePath()+File.separator+"productos.txt");
			BufferedReader lee = new BufferedReader(new FileReader(pt));
			StringBuilder texto = new StringBuilder();
			String registro;
			boolean sw = false;
			while ((registro=lee.readLine()) != null) {
				String [] sep = registro.split(";");
				if(sep[4].equals(cod)){
					items++;
					existencia = existencia + Integer.parseInt(sep[5]);
					
				}
			}
			lee.close();
			String [] lista = cadenas.split("\n");
			
			for(int i = 0; i < lista.length;i++){
				if(lista[i].indexOf(cod) != -1){
					texto.append(lista[i].split(",")[1]);
					texto.append("\n");
					break;
				}
			}
			
			texto.append("Items: "+items);
			texto.append("\n");
			texto.append("Existencia: "+existencia);
			
			TextView tv2 = (TextView) findViewById(R.id.textView2);
			tv2.setText(texto);
				
//				EditText et2 = (EditText) findViewById(R.id.editText2);
//				et2.setText(res);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void limpiar(View vista){
		TextView tv = (TextView) findViewById(R.id.textView2);
		tv.setText(cadenas);
		Button b = (Button) findViewById(R.id.button2);
		b.setVisibility(View.GONE);
	}
	
}
