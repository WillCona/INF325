package com.example.cooperativabd2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	ArrayList<String> lista = new ArrayList<String>();

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
//			Cooperativa db = new Cooperativa(MainActivity.this);
//			db.apertura();
//			long c;
//			
//			File dir = Environment.getExternalStorageDirectory();
//			File pt = new File(dir.getAbsolutePath()+File.separator+"cpclientes.csv");
//			BufferedReader lee = new BufferedReader(new FileReader(pt));
//			StringBuilder texto = new StringBuilder();
//			String registro;
//			registro=lee.readLine();
//			while ((registro=lee.readLine()) != null) {
//				String [] div = registro.split(";");
//				c = db.CLins(Integer.parseInt(div[0]), div[1], Integer.parseInt(div[2]), Integer.parseInt(div[3]));
//			}
//			lee.close();
//			
//			File dir2 = Environment.getExternalStorageDirectory();
//			File pt2 = new File(dir2.getAbsolutePath()+File.separator+"cpcuentas.csv");
//			lee = new BufferedReader(new FileReader(pt2));
//			registro=lee.readLine();
//			//registro="";
//			while ((registro=lee.readLine()) != null) {
//				String [] div = registro.split(";");
//				c = db.CTins(div[0], Integer.parseInt(div[1]), div[2]);
//			}
//			lee.close();
//			
//			
//			File dir3 = Environment.getExternalStorageDirectory();
//			File pt3 = new File(dir3.getAbsolutePath()+File.separator+"cpdeptos.csv");
//			lee = new BufferedReader(new FileReader(pt3));
//			registro=lee.readLine();
//			//registro="";
//			while ((registro=lee.readLine()) != null) {
//				String [] div = registro.split(";");
//				c = db.DPins(Integer.parseInt(div[0]), div[1]);
//			}
//			lee.close();
//			
//			
//			File dir4 = Environment.getExternalStorageDirectory();
//			File pt4 = new File(dir4.getAbsolutePath()+File.separator+"cpmovimientos.csv");
//			lee = new BufferedReader(new FileReader(pt4));
//			registro=lee.readLine();
//			//registro="";
//			while ((registro=lee.readLine()) != null) {
//				String [] div = registro.split(";");
//				c = db.MVins(Integer.parseInt(div[0]), div[1], Integer.parseInt(div[2]), div[3], Integer.parseInt(div[4]));
//			}
//			lee.close();
//			
//			
//			File dir5 = Environment.getExternalStorageDirectory();
//			File pt5 = new File(dir5.getAbsolutePath()+File.separator+"cpprofesiones.csv");
//			lee = new BufferedReader(new FileReader(pt5));
//			//registro="";
//			registro=lee.readLine();
//			while ((registro=lee.readLine()) != null) {
//				String [] div = registro.split(";");
//				c = db.PFins(Integer.parseInt(div[0]), div[1]);
//			}
//			lee.close();
//			
//			
//			Toast.makeText(this, "Todo OK", 1).show();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			Toast.makeText(this, e.getMessage(), 1).show();
//		}
		
		
		
		final Cooperativa db = new Cooperativa(MainActivity.this);
		try {
			db.apertura();
			
			final ListView lv = (ListView) findViewById(R.id.listView1);
			
			String[] valores = db.CLRep2().split("\n");
			 for (int i = 0; i < valores.length; i++) {
				lista.add(valores[i]);
			}
			 
			db.cerrar();
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
			lv.setAdapter(adapter);
			final Button b = (Button) findViewById(R.id.button2);
	    	final TextView tv = (TextView) findViewById(R.id.textView3);
	    	final LinearLayout p = (LinearLayout) findViewById(R.id.LinearLayout3);
			final TextView tv2 = (TextView) findViewById(R.id.textView4);
			final TextView tv3 = (TextView) findViewById(R.id.textView5);
			final TextView tv4 = (TextView) findViewById(R.id.textView6);
			final TextView tv5 = (TextView) findViewById(R.id.textView7);
			final TextView tv6 = (TextView) findViewById(R.id.textView8);
			lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			    @Override
			    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
			        
			    	
			    	p.setVisibility(View.GONE);
			    	
			    	lv.setVisibility(View.GONE);
			    	tv2.setVisibility(View.GONE);
			    	tv3.setVisibility(View.VISIBLE);
			    	b.setVisibility(View.VISIBLE);
			    	
			    	try {
						db.apertura();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String []res = db.repNombre2(lista.get(position).split(" ")[0]).split("##");
					db.cerrar();
					tv.setText(res[0]);
					tv.setVisibility(View.VISIBLE);
			    	tv4.setVisibility(View.VISIBLE);
			    	tv4.setText(res[1]);
			    	tv5.setVisibility(View.VISIBLE);
			    	tv6.setVisibility(View.VISIBLE);
			    	tv6.setText(res[2]);
			    	
			    	
			      }
			   });	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		TextView tv = (TextView) findViewById(R.id.textView3);
//		Cooperativa cp = new Cooperativa(MainActivity.this);
//		try {
//			cp.apertura();
//			tv.setText(cp.CLRep2());
//			cp.cerrar();
//			tv.setVisibility(View.VISIBLE);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void buscar(View vista) throws Exception{
		final ListView lv = (ListView) findViewById(R.id.listView1);
		final Button b = (Button) findViewById(R.id.button2);
    	final TextView tv = (TextView) findViewById(R.id.textView3);
    	final LinearLayout p = (LinearLayout) findViewById(R.id.LinearLayout3);
		final TextView tv2 = (TextView) findViewById(R.id.textView4);
		final TextView tv3 = (TextView) findViewById(R.id.textView5);
		final TextView tv4 = (TextView) findViewById(R.id.textView6);
		final TextView tv5 = (TextView) findViewById(R.id.textView7);
		final TextView tv6 = (TextView) findViewById(R.id.textView8);
		
		EditText et = (EditText) findViewById(R.id.editText1);
		
		Cooperativa db = new Cooperativa(MainActivity.this);
		
		p.setVisibility(View.GONE);
    	
    	lv.setVisibility(View.GONE);
    	tv2.setVisibility(View.GONE);
    	tv3.setVisibility(View.VISIBLE);
    	b.setVisibility(View.VISIBLE);
    	
    	try {
			db.apertura();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String []res = db.repNombre2(et.getText().toString()).split("##");
		db.cerrar();
		tv.setText(res[0]);
		tv.setVisibility(View.VISIBLE);
    	tv4.setVisibility(View.VISIBLE);
    	tv4.setText(res[1]);
    	tv5.setVisibility(View.VISIBLE);
    	tv6.setVisibility(View.VISIBLE);
    	tv6.setText(res[2]);
    	
    	
		
	}
	
	public void limpiar(View vista){
		LinearLayout ll = (LinearLayout) findViewById(R.id.LinearLayout3);
		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setVisibility(View.VISIBLE);
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
		//lv.setAdapter(adapter);
		Button b = (Button) findViewById(R.id.button2);
		TextView tv = (TextView) findViewById(R.id.textView3);
		EditText et =(EditText) findViewById(R.id.editText1);
		et.setText("");
		ll.setVisibility(View.VISIBLE);
		b.setVisibility(View.GONE);
		tv.setVisibility(View.GONE);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}



