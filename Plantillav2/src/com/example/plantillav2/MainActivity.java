package com.example.plantillav2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	ArrayList<String> personal = new ArrayList<String>();
	ArrayList<String> planilla = new ArrayList<String>();
	ArrayList<String> cargos = new ArrayList<String>();
	ArrayList<String> bonos = new ArrayList<String>();
	ArrayList<String> descuentos = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
			File dir = Environment.getExternalStorageDirectory();
			File pt = new File(dir.getAbsolutePath()+File.separator+"bdpersonal.csv");
			BufferedReader lee = new BufferedReader(new FileReader(pt));
			StringBuilder texto = new StringBuilder();
			String registro;
			while ((registro=lee.readLine()) != null ) {
				personal.add(registro);
			}
			lee.close();
			
			File dir2 = Environment.getExternalStorageDirectory();
			File pt2 = new File(dir.getAbsolutePath()+File.separator+"bdplanilla.csv");
			BufferedReader lee2 = new BufferedReader(new FileReader(pt2));
			StringBuilder texto2 = new StringBuilder();
			String registro2;
			while ((registro2=lee2.readLine()) != null) {
				planilla.add(registro2);
			}
			lee2.close();
			

			File dir3 = Environment.getExternalStorageDirectory();
			File pt3 = new File(dir.getAbsolutePath()+File.separator+"bdcargos.csv");
			BufferedReader lee3 = new BufferedReader(new FileReader(pt3));
			StringBuilder texto3 = new StringBuilder();
			String registro3;
			while ((registro3=lee3.readLine()) != null) {
				cargos.add(registro3);
			}
			lee3.close();
			
			File dir4 = Environment.getExternalStorageDirectory();
			File pt4 = new File(dir.getAbsolutePath()+File.separator+"bdbonos.csv");
			BufferedReader lee4 = new BufferedReader(new FileReader(pt4));
			StringBuilder texto4 = new StringBuilder();
			String registro4;
			while ((registro4=lee4.readLine()) != null) {
				bonos.add(registro4);
			}
			lee4.close();
			
			File dir5 = Environment.getExternalStorageDirectory();
			File pt5 = new File(dir.getAbsolutePath()+File.separator+"bddescuentos.csv");
			BufferedReader lee5 = new BufferedReader(new FileReader(pt5));
			StringBuilder texto5 = new StringBuilder();
			String registro5;
			while ((registro5=lee5.readLine()) != null) {
				descuentos.add(registro5);
			}
			lee5.close();
			
			planilla.remove(0);
			descuentos.remove(0);
			bonos.remove(0);
			personal.remove(0);
			cargos.remove(0);
			
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

	public void buscar(View vista){
		StringBuilder texto = new StringBuilder();
		TextView t = (TextView) findViewById(R.id.textView3);
		String nombre="",cargo="no tiene", cx = "",codCargo="";
		boolean sw = true;
		int basico = 0,bono = 0,descuento = 0, total=0;
		for (int i = 0; i < personal.size(); i++) {
			String [] nom = personal.get(i).split(";");
			nombre = nom[1]+" "+nom[2]+" "+nom[3];
			cx = nom[0];
			
			for (int j = 0; j < planilla.size(); j++) {
				String [] pl = planilla.get(j).split(";");
				if(cx.equals(pl[1])){
					codCargo = pl[2];
					break;
				}
			}
			
			for (int j = 0; j < cargos.size(); j++) {
				String [] cr = cargos.get(j).split(";");
				if (codCargo.equals(cr[0])) {
					cargo = cr[1];
					basico = Integer.parseInt(cr[2]);
					break;
				}
			}
			
			for (int j = 0; j < bonos.size(); j++) {
				String [] bb = bonos.get(j).split(";");
				
				if (bb[1].equals(cx)) {
					bono = bono + Integer.parseInt(bb[2]);
				}
			}
			
			for (int j = 0; j < descuentos.size(); j++) {
				String [] dd = descuentos.get(j).split(";");
				if (dd[1].equals(cx)) {
					descuento = descuento + Integer.parseInt(dd[2]);
				}
			}
			
			total = basico + bono - descuento;
			
			texto.append(nombre + " " +cargo+ " "+ total+"\n");
			nombre="";
			cargo="no tiene";
			cx = "";
			codCargo="";
			sw = true;
			basico = 0;bono = 0;descuento = 0;total=0;
			
		}
		
		t.setText(texto);
	}
	
}
