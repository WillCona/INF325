package com.example.busqueda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
//		if(!estado.equals(Environment.MEDIA_MOUNTED)){
//			Toast.makeText(this, "No hay acceso a memoria interna", Toast.LENGTH_LONG).show();
//			finish();
//		}
//		try {
//			File dir = Environment.getExternalStorageDirectory();
//			File pt = new File(dir.getAbsolutePath()+File.separator+"productos.txt");
//			BufferedReader lee = new BufferedReader(new FileReader(pt));
//			StringBuilder texto = new StringBuilder();
//			String registro;
//			while ((registro=lee.readLine()) != null) {
//				texto.append(registro);
//				texto.append("\n");
//			}
//			lee.close();
//			TextView tv = (TextView) findViewById(R.id.textView1);
//			tv.setText(texto);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void buscar(View vista){
		EditText et = (EditText) findViewById(R.id.editText1);
		String cod = et.getText().toString(), linea="";
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
			boolean sw = true;
			while ((registro=lee.readLine()) != null && sw) {
				if(registro.indexOf(cod) != -1){
					linea = registro;
					sw = false;
				}
			}
			lee.close();
			if (linea.length()>0) {

				String [] cont = linea.split(";");
				
				StringBuilder res = new StringBuilder();
				
				res.append("DESCRIPCION:\n");
				res.append("\n");
				res.append(cont[1]);
				res.append("UNIDAD: ");
				res.append(cont[2]);
				res.append("\n");
				res.append("UNDXENV: ");
				res.append(cont[3]);
				res.append("\n");
				res.append("LINEA: ");
				res.append(cont[4]);
				res.append("\n");
				res.append("eXISTENCIA: ");
				res.append(cont[5]);
				res.append("\n");
				
				
				EditText et2 = (EditText) findViewById(R.id.editText2);
				et2.setText(res);
			}else{
				Toast.makeText(this, "No existe", Toast.LENGTH_SHORT).show();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void limpiar(View vista){
		EditText et2 = (EditText) findViewById(R.id.editText2);
		et2.setText("");
		EditText et = (EditText) findViewById(R.id.editText1);
		et.setText("");
	}
}
