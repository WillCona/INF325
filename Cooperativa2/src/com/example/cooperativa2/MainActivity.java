package com.example.cooperativa2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	
	ArrayList<String> clientes = new ArrayList<String>();
	ArrayList<String> cuentas = new ArrayList<String>();
	ArrayList<String> movimientos = new ArrayList<String>();
	ArrayList<String> filtradocl = new ArrayList<String>();
	ArrayList<String> filtradocu = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String estado = Environment.getExternalStorageState();
		if(!estado.equals(Environment.MEDIA_MOUNTED)){
			Toast.makeText(this, "No hay acceso a memoria interna", Toast.LENGTH_LONG).show();
			finish();
		}
		try {
			File dir = Environment.getExternalStorageDirectory();
			File pt = new File(dir.getAbsolutePath()+File.separator+"cpcuentas.csv");
			BufferedReader lee = new BufferedReader(new FileReader(pt));
			String registro;
			while ((registro=lee.readLine()) != null) {
				cuentas.add(registro);
			}
			lee.close();
			
			File dir2 = Environment.getExternalStorageDirectory();
			File pt2 = new File(dir2.getAbsolutePath()+File.separator+"cpmovimientos.csv");
			BufferedReader lee2 = new BufferedReader(new FileReader(pt2));
			while ((registro=lee2.readLine()) != null) {
				movimientos.add(registro);
			}
			lee2.close();
			
			
			cuentas.remove(0);
			movimientos.remove(0);
			
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
	
	
	public void limpiar(View vista){
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		
		
		
		tv2.setVisibility(View.INVISIBLE);
		
		Button b2 = (Button) findViewById(R.id.button2);
		b2.setVisibility(View.INVISIBLE);
	}
	
	public void filtrar(View vista){
		
		EditText et = (EditText) findViewById(R.id.editText1);
		String cod = et.getText().toString();
		String estado = Environment.getExternalStorageState();
		
		int total = 0;
		if(!estado.equals(Environment.MEDIA_MOUNTED)){
			Toast.makeText(this, "No hay acceso a memoria interna", Toast.LENGTH_LONG).show();
			finish();
		}
		try {
			File dir = Environment.getExternalStorageDirectory();
			File pt = new File(dir.getAbsolutePath()+File.separator+"cpclientes.csv");
			BufferedReader lee = new BufferedReader(new FileReader(pt));
			String registro;
			while ((registro=lee.readLine()) != null) {
				String sep [] = registro.split(";");
				if (sep[3].equals(cod)) {
					filtradocl.add(sep[0]);
				}
			}
			lee.close();
			
			for (int i = 0; i < filtradocl.size(); i++) {
				for (int j = 0; j < cuentas.size(); j++) {
					String[] sep = cuentas.get(j).split(";");
					if(filtradocl.get(i).equals(sep[1])){
						filtradocu.add(sep[0]);
					}
				}
			}
			boolean sw = true;
			
			for (int i = 0; i < filtradocu.size(); i++) {
				for (int j = 0; j < movimientos.size(); j++) {
					String [] sep = movimientos.get(j).split(";");
					if(sep[1].equals(filtradocu.get(i))){
						total = total + Integer.parseInt(sep[2]);
						sw= false;
					}
				}
			}
			
			
			TextView tv2 = (TextView) findViewById(R.id.textView2);
			
			tv2.setText("\nNro Clientes: "+filtradocl.size()+"\nSaldo Total: "+total);
			
			tv2.setVisibility(View.VISIBLE);
			
			Button b2 = (Button) findViewById(R.id.button2);
			b2.setVisibility(View.VISIBLE);
			
			filtradocl.clear();
			filtradocu.clear();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
