package com.example.coopertivasbd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

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
			Cooperativa db = new Cooperativa(MainActivity.this);
			db.apertura();
			long c;
			
			File dir = Environment.getExternalStorageDirectory();
			File pt = new File(dir.getAbsolutePath()+File.separator+"cpclientes.csv");
			BufferedReader lee = new BufferedReader(new FileReader(pt));
			StringBuilder texto = new StringBuilder();
			String registro;
			registro=lee.readLine();
			while ((registro=lee.readLine()) != null) {
				String [] div = registro.split(";");
				c = db.CLins(Integer.parseInt(div[0]), div[1], Integer.parseInt(div[2]), Integer.parseInt(div[3]));
			}
			lee.close();
			
			File dir2 = Environment.getExternalStorageDirectory();
			File pt2 = new File(dir2.getAbsolutePath()+File.separator+"cpcuentas.csv");
			lee = new BufferedReader(new FileReader(pt2));
			registro=lee.readLine();
			//registro="";
			while ((registro=lee.readLine()) != null) {
				String [] div = registro.split(";");
				c = db.CTins(div[0], Integer.parseInt(div[1]), div[2]);
			}
			lee.close();
			
			
			File dir3 = Environment.getExternalStorageDirectory();
			File pt3 = new File(dir3.getAbsolutePath()+File.separator+"cpdeptos.csv");
			lee = new BufferedReader(new FileReader(pt3));
			registro=lee.readLine();
			//registro="";
			while ((registro=lee.readLine()) != null) {
				String [] div = registro.split(";");
				c = db.DPins(Integer.parseInt(div[0]), div[1]);
			}
			lee.close();
			
			
			File dir4 = Environment.getExternalStorageDirectory();
			File pt4 = new File(dir4.getAbsolutePath()+File.separator+"cpmovimientos.csv");
			lee = new BufferedReader(new FileReader(pt4));
			registro=lee.readLine();
			//registro="";
			while ((registro=lee.readLine()) != null) {
				String [] div = registro.split(";");
				c = db.MVins(Integer.parseInt(div[0]), div[1], Integer.parseInt(div[2]), div[3], Integer.parseInt(div[4]));
			}
			lee.close();
			
			
			File dir5 = Environment.getExternalStorageDirectory();
			File pt5 = new File(dir5.getAbsolutePath()+File.separator+"cpprofesiones.csv");
			lee = new BufferedReader(new FileReader(pt5));
			//registro="";
			registro=lee.readLine();
			while ((registro=lee.readLine()) != null) {
				String [] div = registro.split(";");
				c = db.PFins(Integer.parseInt(div[0]), div[1]);
			}
			lee.close();
			
			
//			c = db.CLins(111, "Hugo", 1, 2);
//			c = db.CLins(222, "Paco", 3, 4);
//			c = db.CLins(333, "Luis", 5, 6);
//			c = db.CLins(444, "Deysi", 7, 8);
//			c = db.DPins(1, "Chuquisaca");
//			c = db.DPins(2, "La Paz");
//			c = db.DPins(3, "Cochabamba");
//			c = db.DPins(4, "Oruro");
//			c = db.DPins(5, "Ptosi");
//			c = db.DPins(6, "Tarija");
//			c = db.DPins(7, "Santa Cruz");
//			c = db.DPins(8, "Beni");
//			c = db.DPins(9, "Pando");
			Toast.makeText(this, "Todo OK", 1).show();
			
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(this, e.getMessage(), 1).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
