package com.example.webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	public static String miUrl="http://clasespersonales.com/android/listazon.php";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new CargaZonas().doInBackground(arg0);
		
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
			String fin = "Codigo\tZona\n";
			TextView tv = (TextView) findViewById(R.id.textView1);
			
//			String jsonString = resultado;
			
			
			try {
				
				JSONObject objeto = new JSONObject(resultado);
				JSONArray zonasArray = objeto.getJSONArray("zonas");
				for (int i = 0; i < zonasArray.length(); i++) {
		            JSONObject zona = zonasArray.getJSONObject(i);
		            String codZon = zona.getString("codzon");
		            String descZon = zona.getString("deszon");

		            fin = fin + codZon +"\t\t\t\t"+descZon+"\n";
		        }
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
