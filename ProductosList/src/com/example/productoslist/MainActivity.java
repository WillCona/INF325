package com.example.productoslist;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ArrayList<String> cadenas = new ArrayList<String>();
	ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listview = (ListView) findViewById(R.id.listView1);
		
		String estado = Environment.getExternalStorageState();
	    if (!estado.equals(Environment.MEDIA_MOUNTED)) {
	        Toast.makeText(this, "No hay acceso a memoria interna", Toast.LENGTH_LONG).show();
	        finish();
	    }
	    try {
	        File dir = Environment.getExternalStorageDirectory();
	        File pt = new File(dir.getAbsolutePath() + File.separator + "lineas.txt");
	        BufferedReader lee = new BufferedReader(new FileReader(pt));
	        String registro;
	        boolean sw = false;
	        while ((registro = lee.readLine()) != null) {
	        			if (sw) {
							cadenas.add(registro);
						}
	        			sw = true;
	        }
	        lee.close();
	        
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, cadenas);
	        
	        listview.setAdapter(adapter);
	        
	        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	        	
	        	@Override
	        	public void onItemClick(AdapterView<?> adapterView, View view, int position,long id){
	        		
	        		String [] scadena = cadenas.get(position).split(",");
	        		
	        		int items = 0, existencia = 0;
	        		
	        		TextView tv = (TextView) findViewById(R.id.textView3);
	        		EditText et = (EditText) findViewById(R.id.editText1);
	        		Button b = (Button) findViewById(R.id.button2);
	        		b.setVisibility(View.VISIBLE);
	        		
	        		ListView listView = (ListView) findViewById(R.id.listView1);
	        		listview.setVisibility(View.GONE);
	        		
	        		try {
	        			File dir = Environment.getExternalStorageDirectory();
	        			File pt = new File(dir.getAbsolutePath()+File.separator+"productos.txt");
	        			BufferedReader lee = new BufferedReader(new FileReader(pt));
	        			StringBuilder texto = new StringBuilder();
	        			String registro;
	        			boolean sw = false;
	        			while ((registro=lee.readLine()) != null) {
	        				String [] sep = registro.split(";");
	        				if(sep[4].equals(scadena[0])){
	        					items++;
	        					existencia = existencia + Integer.parseInt(sep[5]);
	        					
	        				}
	        			}
	        			lee.close();
	        			
	        			texto.append(scadena[1]);
	        			texto.append("\n");
	        			texto.append("Items: "+items);
	        			texto.append("\n");
	        			texto.append("Existencia: "+existencia);
	        			
	        			tv.setText(texto);
	        			tv.setVisibility(View.VISIBLE);
	        			et.setText(scadena[0]);
	        				
	        		} catch (IOException e) {
	        			e.printStackTrace();
	        		}
	        	}
			});
	    } catch (Exception e) {
	        e.printStackTrace(); // Maneja la excepción o muestra un mensaje de error aquí
	    }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void volver(View vista){
		Button b = (Button) findViewById(R.id.button2);
		b.setVisibility(View.GONE);
		listview.setVisibility(View.VISIBLE);
		TextView tv = (TextView) findViewById(R.id.textView3);
		EditText et = (EditText) findViewById(R.id.editText1);
		et.setText("");
		tv.setVisibility(View.GONE);
		
	}

}
