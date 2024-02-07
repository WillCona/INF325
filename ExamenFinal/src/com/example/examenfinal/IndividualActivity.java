package com.example.examenfinal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class IndividualActivity extends Activity{
	
	TreeMap<String, Integer> notasT = new TreeMap<String, Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reporteindividual);
		
		
	}
	public void retornar(View vista){
		finish();
	}
	
	class CargaZonas extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			return BajarDatos(arg0[0]);
		}
		
		@Override
		protected void onPostExecute(String resultado) {
			// TODO Auto-generated method stub
			String fin = "";
			TextView tv = (TextView) findViewById(R.id.textView2N);
			
			
			//TextView tv = (TextView) findViewById(R.id.textView1);
			
			//String jsonString = resultado;
			try {
				
				JSONObject objeto = new JSONObject(resultado);
				JSONArray zonasArray = objeto.getJSONArray("notas");
				for (int i = 0; i < zonasArray.length(); i++) {
		            JSONObject zona = zonasArray.getJSONObject(i);
		            String codE = zona.getString("cod");
		            String notaE = zona.getString("puntos");
		            String tipoE = zona.getString("tipo");
		            
		            if(notasT.containsKey(tipoE)){
						int valor = notasT.get(tipoE)+Integer.parseInt(notaE);
						notasT.put(tipoE, valor);
					}else{
						notasT.put(tipoE, Integer.parseInt(notaE));
					}
		        }
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int totalR = 0;
			
			
			fin = fin + "1er Parcial: "+ notasT.get("1")+"\n";
			
			fin = fin + "2do Parcial: "+ notasT.get("2")+"\n";
			fin = fin + "Acumulados"+ notasT.get("9")+"\n";
			fin = fin + "Ex final: "+ notasT.get("3")+"\n";
			
			totalR = totalR + notasT.get("2")+ notasT.get("1")+ notasT.get("3")+ notasT.get("9");
			
			fin = fin + "Nota Final: "+totalR+"\n\n";
			
			if (totalR < 51) {
				fin += "Reprobado";
			}else{
				fin += "Aprobado";
			}
			
			
			
//			for (String clave : notasT.keySet()) {
//	            int valor = notasT.get(clave);
//	            totalR = totalR + valor;
//	            if(clave.equals("1")){
//	            	fin = fin + "1er Parcial." + valor+"\n";
//	            }
//	            
//	            if(clave.equals("2")){
//	            	fin = fin + "2do Parcial." + valor+"\n";
//	            }
//	            
//	            if(clave.equals("3")){
//	            	fin = fin + "Ex. Final Parcial." + valor+"\n";
//	            }
//	            
//	            if(clave.equals("9")){
//	            	fin = fin + "Acumulados" + valor+"\n";
//	            }
//	            
//	            fin = fin + "Nota: "+totalR+"\n";
//	                
//	            if (totalR<51) {
//					fin = fin + "reprobado\n";
//				}else{
//					fin = fin + "aprobado\n";
//				}
//	            
//	        }
			
			tv.setText(fin);
	       
		}
		
	}
	
	
	
	public String BajarDatos(String url){
		InputStream pt = null;
		String r = "";
		try {
			URL sitio = new URL(url);
			HttpURLConnection uc = (HttpURLConnection) sitio.openConnection();
			
			pt = uc.getInputStream();
			if (pt!=null) {
				r = convierteString(pt);
			}else{
				r = "No hay conexion";
			}
		} catch (Exception e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		return r;	
	
	}

	public String convierteString(InputStream bloque) throws IOException{
		String res="";
		BufferedReader br = new BufferedReader(new InputStreamReader(bloque));
		String linea;
		while ((linea = br.readLine()) != null) {
			res = res + linea;
		}
		return res;
	}
	
	
	public void buscarx(View vista){
		
		EditText et = (EditText) findViewById(R.id.editText1);
		
		String url = "http://clasespersonales.com/notas/listanotas.php?qcod="+et.getText().toString();
		
		new CargaZonas().execute(url);
		
		notasT.clear();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
