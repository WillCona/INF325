package com.example.cooperativa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
	
	ArrayList<String> cuentas = new ArrayList<String>(); 
	ArrayList<String> movimientos = new ArrayList<String>(); 
	

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
	
	
	public void buscar(View vista){
		////
		EditText et = (EditText) findViewById(R.id.editText1);
		String cod = et.getText().toString(), linea="";
		String estado = Environment.getExternalStorageState();
		if(!estado.equals(Environment.MEDIA_MOUNTED)){
			Toast.makeText(this, "No hay acceso a memoria interna", Toast.LENGTH_LONG).show();
			finish();
		}
		try {
			File dir = Environment.getExternalStorageDirectory();
			File pt = new File(dir.getAbsolutePath()+File.separator+"cpcuentas.csv");
			BufferedReader lee = new BufferedReader(new FileReader(pt));
			StringBuilder texto = new StringBuilder();
			String registro;
			boolean sw = true;
			while ((registro=lee.readLine()) != null && sw) {
				String [] div = registro.split(";");
				if(div[1].equals(cod)){
					linea = registro;
					sw = false;
				}
			}
			lee.close();
		}catch(Exception e){
			
		}
	////	
	}
	
	
	public void buscar2(View vista){
		
		String nombre = "No existe";
		
		cuentas.clear();
		movimientos.clear();
		StringBuilder res = new StringBuilder();
		String estado = Environment.getExternalStorageState();
		EditText et = (EditText) findViewById(R.id.editText1);
		String v = et.getText().toString();
		int c = 0, sumat = 0, sumat2=0;

		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
		    Toast.makeText(this, "No hay memoria SD", Toast.LENGTH_LONG).show();
		    finish();
		}

		File dir = Environment.getExternalStorageDirectory();
		File p = new File(dir.getAbsolutePath() + File.separator + "cpcuentas.csv");
		
		File dir2 = Environment.getExternalStorageDirectory();
		File p2 = new File(dir.getAbsolutePath() + File.separator + "cpmovimientos.csv");
		
		File dir7 = Environment.getExternalStorageDirectory();
		File p7 = new File(dir.getAbsolutePath() + File.separator + "cpclientes.csv");
		
		try {
		    Scanner lector = new Scanner(new FileReader(p));
		    Scanner lector2 = new Scanner(new FileReader(p2));
		    Scanner lector7 = new Scanner(new FileReader(p7));
		    
		    StringBuilder texto = new StringBuilder(); // Corregí los dos puntos (:) por el signo igual (=).

		    String linea;
		    
		    while(lector7.hasNext()){
		    	linea = lector7.nextLine();
		    	String div []  = linea.split(";");
		    	if (div[0].equals(v)) {
					nombre = div[1];
					break;
				}
		    }
		    
		    lector7.close();
		    
		    
		    int startTime = (int) System.currentTimeMillis();
		    while (lector.hasNext()) {
		    	 linea = lector.nextLine();
		    	 String [] div = linea.split(";");
			        if (div[1].equals(v)) {
						cuentas.add(div[0]);
					}
		    }
		    
		    while (lector2.hasNext()) {
		    	 linea = lector2.nextLine();
		    	 movimientos.add(linea);
		    	 
		    }
		    
		    for (int i = 0; i < cuentas.size(); i++) {
				for (int j = 0; j < movimientos.size(); j++) {
					String [] div = movimientos.get(j).split(";");
					if(cuentas.get(i).equals(div[1])){
						sumat = sumat + Integer.parseInt(div[2]);
					}
				}
			}
		    

		    lector.close();
		    lector2.close();
		    
		    int endTime = (int) System.currentTimeMillis();
		    
		    int elapsedTime = endTime - startTime;
		    
		    startTime = (int) System.currentTimeMillis();
		    
		    TextView tv = (TextView) findViewById(R.id.textView2);
		    
		    

		    res.append(nombre+"\n"+v+"\nTotal: "+sumat+"\nNro cuentas: "+cuentas.size()+"\nT0: "+elapsedTime);
		    tv.setText(res);
		    tv.setVisibility(View.VISIBLE);
		    
		    
		    
		    cuentas.clear();
		    movimientos.clear();
		    File dir3 = Environment.getExternalStorageDirectory();
		    File pt3 = new File(dir.getAbsolutePath()+File.separator+"cpcuentas.csv");
		    
		    File dir4 = Environment.getExternalStorageDirectory();
		    File pt4 = new File(dir.getAbsolutePath()+File.separator+"cpmovimientos.csv");
		    
		    BufferedReader lee2 = new BufferedReader(new FileReader(pt3));
		    BufferedReader lee3 = new BufferedReader(new FileReader(pt4));
		    
		    String registro2;
		    while ((registro2 = lee2.readLine()) != null) {
				String [] div2 = registro2.split(";");
				if(div2[1].equals(v)){
					cuentas.add(div2[0]);
				}
				
			}
		    
		    while((registro2 = lee3.readLine())!= null){
		    	movimientos.add(registro2);
		    }
		    
		    lee2.close();
		    lee3.close();
		    
		    for (int i = 0; i < cuentas.size(); i++) {
				for (int j = 0; j < movimientos.size(); j++) {
					String [] div3 = movimientos.get(j).split(";");
					if(cuentas.get(i).equals(div3[1])){
						sumat2 = sumat2 + Integer.parseInt(div3[2]);
					}
				}
			}
		    
		    
			endTime = (int) System.currentTimeMillis();			
			elapsedTime = endTime - startTime;
		    
			
		    res.append("\n\n"+nombre+"\n"+v+"\nTotal: "+sumat2+"\nNro cuentas: "+cuentas.size()+"\nT0: "+elapsedTime);
		    tv.setText(res);
		    tv.setVisibility(View.VISIBLE);
		      
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	

}
