package com.example.miscelanea;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TragosActivity extends Activity{
	
	int [] imagen = {R.drawable.tr1,R.drawable.tr2,R.drawable.tr3,R.drawable.tr4,R.drawable.tr5,R.drawable.tr6,R.drawable.tr7,
			R.drawable.tr8,R.drawable.tr9};
	String [] plato = {"Chuflay","Sucumbé","Chicha de maiz","Garapiña","Yungueñito","Mojito Valluno","Singani Sour",
			"Licor de coca","Supay"};
	
	int c = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tragos);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void siguiente(View vista){
		c++;
		if (c>8) {
			c=0;
		}
		ImageView pi = (ImageView) findViewById(R.id.imageView1);
		//TextView d = (TextView) findViewById(R.id.textView2);
		TextView p = (TextView) findViewById(R.id.textView3);
		pi.setImageResource(imagen[c]);
		//d.setText(dpto[c]);
		p.setText(plato[c]);
/*	
		if (c < 9) {
			ImageView pi = (ImageView) findViewById(R.id.imageView1);
			TextView d = (TextView) findViewById(R.id.textView2);
			TextView p = (TextView) findViewById(R.id.textView3);
			pi.setImageResource(imagen[c]);
			d.setText(dpto[c]);
			p.setText(plato[c]);
		} else {
			c = 0;
			ImageView pi = (ImageView) findViewById(R.id.imageView1);
			TextView d = (TextView) findViewById(R.id.textView2);
			TextView p = (TextView) findViewById(R.id.textView3);
			pi.setImageResource(imagen[c]);
			d.setText(dpto[c]);
			p.setText(plato[c]);
		}
		c++;
*/	
	}
	
	public void anterior(View vista){
		c--;
		if(c<0){ 
			c=8;
		}
		ImageView pi = (ImageView) findViewById(R.id.imageView1);
		//TextView d = (TextView) findViewById(R.id.textView2);
		TextView p = (TextView) findViewById(R.id.textView3);
		pi.setImageResource(imagen[c]);
		//d.setText(dpto[c]);
		p.setText(plato[c]);  	
	}
	
	public void aleatorio(View vista){
		
		c = nAleatorio(plato.length);
		ImageView pi = (ImageView) findViewById(R.id.imageView1);
		//TextView d = (TextView) findViewById(R.id.textView2);
		TextView p = (TextView) findViewById(R.id.textView3);
		pi.setImageResource(imagen[c]);
		//d.setText(dpto[c]);
		p.setText(plato[c]);
	}
	
	
	public int nAleatorio(int rango){
		int r;
		do {
			r = (int) (Math.floor(Math.random()*((rango-1)-0+1)+0)); 
		} while (!(r > -1) && !(r < rango));
		
		return r;
	} 
	
	public void retornar(View vista){
		finish();
	}
	

}
