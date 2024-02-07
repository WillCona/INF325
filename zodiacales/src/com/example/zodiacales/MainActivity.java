package com.example.zodiacales;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	int [] signo = {R.drawable.aries,R.drawable.tauro,R.drawable.geminis,R.drawable.cancer,R.drawable.leo,R.drawable.virgo,R.drawable.libra,R.drawable.escorpion,R.drawable.sagitario,R.drawable.capricornio,R.drawable.acuario,R.drawable.piscis};
	String [] titulo = {"ARIES","TAURO","GEMINIS","CANCER","LEO","VIRGO","LIBRA","ESCORPIO","SAGITARIO","CAPRICORNIO","ACUARIO","PISCIS"};
	int c = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void siguiente(View vista){
		
		ImageView pi = (ImageView) findViewById(R.id.imageView1);
		pi.setImageResource(R.drawable.tauro);
	}
	
	
	public void siguiente2(View vista){
		if (c <= 11) {
			ImageView pi = (ImageView) findViewById(R.id.imageView1);
			TextView n = (TextView) findViewById(R.id.textView2);
			pi.setImageResource(signo[c]);
			n.setText(titulo[c]);
		} else {
			c = 0;
			ImageView pi = (ImageView) findViewById(R.id.imageView1);
			TextView n = (TextView) findViewById(R.id.textView2);
			pi.setImageResource(signo[c]);
			n.setText(titulo[c]);
		}
		c++;
	}
	
	 public void anterior (View vista){
		  c--;
		  if(c<0) c=11;
		  TextView tv = (TextView) findViewById(R.id.textView2);
		  ImageView im = (ImageView) findViewById(R.id.imageView1);
		  tv.setText(titulo[c]);
		  im.setImageResource(signo[c]);
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
