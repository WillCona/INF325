package com.example.planilla;

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
			
			personal.remove(0);
			planilla.remove(0);
			cargos.remove(0);
			bonos.remove(0);
			descuentos.remove(0);
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
		TextView tv = (TextView) findViewById(R.id.textView3);
		EditText et = (EditText) findViewById(R.id.editText1);
		Button b = (Button) findViewById(R.id.button2);
		b.setVisibility(View.GONE);
		tv.setText("");
		et.setText("");
		
	}
	
	
	public void buscar(View vista){
		int basico = 0, descuento = 0, total = 0, bono = 0;
		String nombre = "",codCargo = "no existe", desCargo ="sin cargo";
		EditText et = (EditText) findViewById(R.id.editText1);
		String cx = et.getText().toString();
		
		boolean sw1 = false, sw2 = true, sw3 = true;
		
		for (int i = 0; i < personal.size(); i++) {
			if(personal.get(i).split(";")[0].equals(cx)){
				nombre = personal.get(i).split(";")[1]+" "+personal.get(i).split(";")[2]+" "+personal.get(i).split(";")[3];
				break;
			}
		}
		
		for (int i = 0; i < planilla.size(); i++) {
			if(planilla.get(i).split(";")[1].equals(cx)){
				codCargo = planilla.get(i).split(";")[2];
				sw1 = true;
				break;
			}
		}		
		
		for (int i = 0; i < cargos.size(); i++) {
			String  [] ca = cargos.get(i).split(";"); 
			if(ca[0].equals(codCargo)){
				desCargo = ca[1];
				basico = Integer.parseInt(ca[2]);
				break;
			}
		}
		
		for (int i = 0; i < bonos.size(); i++) {
			if (bonos.get(i).split(";")[1].equals(cx)) {
				bono = bono + Integer.parseInt(bonos.get(i).split(";")[2]);
			}
		}
		
		for (int i = 0; i < descuentos.size(); i++) {
			if (descuentos.get(i).split(";")[1].equals(cx)) {
				descuento = descuento + Integer.parseInt(descuentos.get(i).split(";")[2]);
			}
		}
		
		total = basico + bono - descuento;
		
		TextView tv = (TextView) findViewById(R.id.textView3);
		Button b = (Button) findViewById(R.id.button2);
		b.setVisibility(View.VISIBLE);
		tv.setText("Nombre: "+nombre + "\nCod. Cargo: " + codCargo+"\nDesc. Cargo: "+ desCargo + "\nBasico: "+basico+"\nBonos: "+bono+"\ndescuentos: "+
		descuento+"\n Total: "+total);
		tv.setVisibility(View.VISIBLE);
	}

	public void buscar2(View vista){
//		int basico = 0, descuento = 0, total = 0, bono = 0;
//		String nombre = "",codCargo = "no existe", desCargo ="sin cargo";
//		EditText et = (EditText) findViewById(R.id.editText1);
//		String cx = et.getText().toString();
		StringBuilder texto = new StringBuilder();
		
		boolean sw1 = false, sw2 = true, sw3 = true;
		
		for (int i = 0; i < personal.size(); i++) {
			int basico = 0, descuento = 0, total = 0, bono = 0;
			String nombre = "",codCargo = "no existe", desCargo ="sin cargo";
			String cx = personal.get(i).split(";")[0];
			nombre = personal.get(i).split(";")[1]+" "+personal.get(i).split(";")[2]+" "+personal.get(i).split(";")[3];	
			
			for (int i1 = 0; i1 < planilla.size(); i1++) {
				if(planilla.get(i1).split(";")[1].equals(cx)){
					codCargo = planilla.get(i1).split(";")[2];
					sw1 = true;
					break;
				}
			}		
			
			for (int i1 = 0; i1 < cargos.size(); i1++) {
				String  [] ca = cargos.get(i1).split(";"); 
				if(ca[0].equals(codCargo)){
					desCargo = ca[1];
					basico = Integer.parseInt(ca[2]);
					break;
				}
			}
			
			for (int i1 = 0; i1 < bonos.size(); i1++) {
				if (bonos.get(i1).split(";")[1].equals(cx)) {
					bono = bono + Integer.parseInt(bonos.get(i1).split(";")[2]);
				}
			}
			
			for (int i1 = 0; i1 < descuentos.size(); i1++) {
				if (descuentos.get(i1).split(";")[1].equals(cx)) {
					descuento = descuento + Integer.parseInt(descuentos.get(i1).split(";")[2]);
				}
			}
			
			total = basico + bono - descuento;
			
			texto.append(nombre+" "+desCargo+" "+total+"\n");
			
		}
		
		
		
		TextView tv = (TextView) findViewById(R.id.textView3);
		Button b = (Button) findViewById(R.id.button2);
		b.setVisibility(View.VISIBLE);
		tv.setText(texto);
		tv.setVisibility(View.VISIBLE);
	}
	
	
	public void busc(View vista){
		StringBuilder cad = new StringBuilder();
			
		for (int i = 0; i < cargos.size(); i++) {
			String[] dc = cargos.get(i).split(";");
			int nc = 0, totalp =0, sueldo = 0, bonoss=0;
			cad.append(dc[1]);
			cad.append("\n");
			sueldo = Integer.parseInt(dc[2]);
			for (int j = 0; j < planilla.size();j++) {
				String [] dp = planilla.get(j).split(";");
				
				if(dp[2].equals(dc[0])){
					nc++;
					
					for (int k = 0; k < bonos.size() ; k++) {
						String [] db = bonos.get(k).split(";");
						if(dp[1].equals(db[1])){
							bonoss = bonoss + Integer.parseInt(db[2]);
						}
					}
					
					for (int k = 0; k < descuentos.size() ; k++) {
						String [] db = descuentos.get(k).split(";");
						if(dp[1].equals(db[1])){
							bonoss = bonoss - Integer.parseInt(db[2]);
						}
					}
				}
			}
			cad.append(nc+"\n");
			cad.append("Total: "+((nc*sueldo)+bonoss));
			cad.append("\n\n");
		}
		
		TextView et = (TextView) findViewById(R.id.textView4);
		et.setText(cad);
	}
	

	public void buscaCargo(View vista){
		EditText et = (EditText) findViewById(R.id.editText1);
		String cx = et.getText().toString();
		int nc = 0, totalp =0, sueldo = 0, bonoss=0;
		String ncargo = "";
		StringBuilder plantillass = new StringBuilder();
		for (int i = 0; i < cargos.size(); i++){
			
			String [] div = cargos.get(i).split(";");
			if (div[0].equals(cx)) {
				ncargo = div[1];
				sueldo = Integer.parseInt(div[2]);
				break;
			}
		}
		
		for (int i = 0; i < planilla.size(); i++) {
			String [] div = planilla.get(i).split(";");
			if(div[2].equals(cx)){
				nc++;
				for (int j = 0; j < bonos.size() ; j++) {
					String [] db = bonos.get(j).split(";");
					if(div[1].equals(db[1])){
						bonoss = bonoss + Integer.parseInt(db[2]);
					}
				}
				
				for (int j = 0; j < descuentos.size() ; j++) {
					String [] db2 = descuentos.get(j).split(";");
					if(div[1].equals(db2[1])){
						bonoss = bonoss - Integer.parseInt(db2[2]);
					}
				}
			}
		}
		
		for (int i = 0; i < planilla.size(); i++) {
			String[] divp = planilla.get(i).split(";");
			if(divp[2].equals(cx)){
				
			}
		}
		
		
		TextView tx = (TextView) findViewById(R.id.textView3);
		
		tx.setText(ncargo+"\n"+nc+"\n"+"Total Pagado: "+ ((sueldo*nc)+bonoss));
		
		tx.setVisibility(View.VISIBLE);
		
		Button bt = (Button) findViewById(R.id.button2);
		
		bt.setVisibility(View.VISIBLE);
		
	}
}
