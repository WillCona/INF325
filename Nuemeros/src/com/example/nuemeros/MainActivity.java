package com.example.nuemeros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		String estado = Environment.getExternalStorageState();
//
//		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
//		    Toast.makeText(this, "No hay memoria SD", Toast.LENGTH_LONG).show();
//		    finish();
//		}
//
//		File dir = Environment.getExternalStorageDirectory();
//		File p = new File(dir.getAbsolutePath() + File.separator + "entel.csv");
//
//		try {
//		    Scanner lector = new Scanner(new FileReader(p));
//		    StringBuilder texto = new StringBuilder(); // Corregí los dos puntos (:) por el signo igual (=).
//
//		    String linea;
//
//		    while (lector.hasNext()) {
//		        linea = lector.nextLine();
//		        texto.append(linea);
//		        texto.append("\n");
//		    }
//
//		    lector.close();
//
//		    TextView tv = (TextView) findViewById(R.id.textView1);
//
//		    tv.setText(texto);
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}

		
	}

	
	public void buscar(View vista){
		StringBuilder res = new StringBuilder();
		String estado = Environment.getExternalStorageState();
		EditText et = (EditText) findViewById(R.id.editText1);
		String v = et.getText().toString();
		int c = 0;

		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
		    Toast.makeText(this, "No hay memoria SD", Toast.LENGTH_LONG).show();
		    finish();
		}

		File dir = Environment.getExternalStorageDirectory();
		File p = new File(dir.getAbsolutePath() + File.separator + "entel.csv");
		
		
		
		try {
		    Scanner lector = new Scanner(new FileReader(p));
		    StringBuilder texto = new StringBuilder(); // Corregí los dos puntos (:) por el signo igual (=).

		    String linea;
		    int startTime = (int) System.currentTimeMillis();
		    while (lector.hasNext()) {
		    	 linea = lector.nextLine();
			        if (linea.indexOf(v) != -1) {
						c++;
					}
		    }

		    lector.close();
		    
		    int endTime = (int) System.currentTimeMillis();
		    
		    int elapsedTime = endTime - startTime;
		    
		    startTime = (int) System.currentTimeMillis();
		    
		    TextView tv = (TextView) findViewById(R.id.textView2);

		    res.append("T0: "+ elapsedTime+"\nTotal: "+c+"\n");
		    c= 0;
		    File dir2 = Environment.getExternalStorageDirectory();
			File pt2 = new File(dir.getAbsolutePath()+File.separator+"entel.csv");
		    
		    BufferedReader lee2 = new BufferedReader(new FileReader(pt2));
			StringBuilder texto2 = new StringBuilder();
			String registro2;
			while ((registro2=lee2.readLine()) != null ) {
				if(registro2.indexOf(v) != -1){
					c++;
				}
			}
			lee2.close();
			endTime = (int) System.currentTimeMillis();
			
			elapsedTime = endTime - startTime;
		    
			res.append("T1: "+ elapsedTime+"\nTotal: "+c+"\n" );
			tv.setText(res );
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}


	}
	
	
	public void busca2(View vista){
		StringBuilder res = new StringBuilder();
		String estado = Environment.getExternalStorageState();
		EditText et = (EditText) findViewById(R.id.editText1);
		String v = et.getText().toString();
		
		int c = 0;

		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
		    Toast.makeText(this, "No hay memoria SD", Toast.LENGTH_LONG).show();
		    finish();
		}

		File dir = Environment.getExternalStorageDirectory();
		File p = new File(dir.getAbsolutePath() + File.separator + "entel.csv");
		
		
		
		try {
		    Scanner lector = new Scanner(new FileReader(p));
		    StringBuilder texto = new StringBuilder(); // Corregí los dos puntos (:) por el signo igual (=).

		    String linea;
		    int startTime = (int) System.currentTimeMillis();
		    while (lector.hasNext()) {
		    	 linea = lector.nextLine();
		    	 String [] separado = linea.split(";");
			        if (v.equals(separado[2]) ) {
						c++;
					}
		    }

		    lector.close();
		    
		    int endTime = (int) System.currentTimeMillis();
		    
		    int elapsedTime = endTime - startTime;
		    
		    startTime = (int) System.currentTimeMillis();
		    
		    TextView tv = (TextView) findViewById(R.id.textView2);

		    res.append("Numero de veces: " +c+"\nT0: "+ elapsedTime+"\n");
		    c= 0;
		    File dir2 = Environment.getExternalStorageDirectory();
			File pt2 = new File(dir.getAbsolutePath()+File.separator+"entel.csv");
		    
		    BufferedReader lee2 = new BufferedReader(new FileReader(pt2));
			StringBuilder texto2 = new StringBuilder();
			String registro2;
			while ((registro2=lee2.readLine()) != null ) {
				String []sep = registro2.split(";");
				if(sep[2].equals(v)){
					c++;
				}
			}
			lee2.close();
			endTime = (int) System.currentTimeMillis();
			
			elapsedTime = endTime - startTime;
		    
			res.append("Numero de veces: " +c+"\nT1: "+ elapsedTime);
			tv.setText(res );
		    
		} catch (IOException e) {
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
