package com.example.basedatos2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
	
//	public void Cargar(View vista){
//		Button b = (Button) findViewById(R.id.button1);
//		
//		try {
//			File dir = Environment.getExternalStorageDirectory();
//			File pt = new File(dir.getAbsolutePath()+File.separator+"productos.txt");
//			BufferedReader lee = new BufferedReader(new FileReader(pt));
//			StringBuilder texto = new StringBuilder();
//			String registro;
//			registro=lee.readLine();
//			Productos p = new Productos(MainActivity.this);
//			p.apertura();
//			while ((registro=lee.readLine()) != null ) {
//				
//				String [] div = registro.split(";");
//				
//				long c = p.Insertar(Integer.parseInt(div[0]),div[1] , div[2], Integer.parseInt(div[3]),div[4], Integer.parseInt(div[3]));
//				
//				//Toast.makeText(this, "Cod =1"+c, Toast.LENGTH_LONG).show();
//			}
//			lee.close();
//			p.cerrar();
//			b.setVisibility(View.GONE);
//			Toast.makeText(this, "Datos Agregados", Toast.LENGTH_LONG).show();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
//	public void Listar(View vista) throws Exception{
//		Productos p = new Productos(MainActivity.this);
//		p.apertura();
//		String v = p.Listar();
//		p.cerrar();
//		
//		TextView tv = (TextView) findViewById(R.id.textView1);
//		tv.setText(v);
//		
//	}
	
	public void buscarx(View vista) throws Exception{
		EditText et = (EditText) findViewById(R.id.editText1);
		TextView tv = (TextView) findViewById(R.id.textView2);
		Productos p = new Productos(MainActivity.this);
		p.apertura();
		String v = p.buscar(et.getText().toString());
		
		tv.setText(v);
		
		p.cerrar();
		
		
	}

}
