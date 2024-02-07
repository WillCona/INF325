package com.example.hand;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

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
	
	public void voltear(View vista){
		
		
		//manejador
		final Handler fig = new Handler();
		final ImageButton memoria = (ImageButton) findViewById(R.id.imageButton1);
		memoria.setImageResource(R.drawable.memocharlie);
		
		fig.postDelayed(new Runnable(){
			@Override
			public void run(){
				memoria.setImageResource(R.drawable.jmemoria);
			}
		},1000);
		
	}
	
	public void iniciar(View vista){
		
		
		//manejador
		final Handler fig = new Handler();
		final ImageButton memoria = (ImageButton) findViewById(R.id.imageButton1);
		memoria.setImageResource(R.drawable.memomarcia);
		final Handler fig2 = new Handler();
		final ImageButton memoria2 = (ImageButton) findViewById(R.id.imageButton2);
		memoria2.setImageResource(R.drawable.memocharlie);
		
		final Handler fig3 = new Handler();
		final ImageButton memoria3 = (ImageButton) findViewById(R.id.imageButton3);
		memoria3.setImageResource(R.drawable.memosally);
		
		final Handler fig4 = new Handler();
		final ImageButton memoria4 = (ImageButton) findViewById(R.id.imageButton4);
		memoria4.setImageResource(R.drawable.memocharlie);
		
		final Handler fig5 = new Handler();
		final ImageButton memoria5 = (ImageButton) findViewById(R.id.imageButton5);
		memoria5.setImageResource(R.drawable.memosally);
		
		final Handler fig6 = new Handler();
		final ImageButton memoria6 = (ImageButton) findViewById(R.id.imageButton6);
		memoria6.setImageResource(R.drawable.memomarcia);
		
		fig.postDelayed(new Runnable(){
			@Override
			public void run(){
				memoria.setImageResource(R.drawable.jmemoria);
			}
		},1000);
		
		fig2.postDelayed(new Runnable(){
			@Override
			public void run(){
				memoria2.setImageResource(R.drawable.jmemoria);
			}
		},1000);
		
		fig3.postDelayed(new Runnable(){
			@Override
			public void run(){
				memoria3.setImageResource(R.drawable.jmemoria);
			}
		},1000);
		
		fig4.postDelayed(new Runnable(){
			@Override
			public void run(){
				memoria4.setImageResource(R.drawable.jmemoria);
			}
		},1000);
		
		
		fig5.postDelayed(new Runnable(){
			@Override
			public void run(){
				memoria5.setImageResource(R.drawable.jmemoria);
			}
		},1000);
		
		fig6.postDelayed(new Runnable(){
			@Override
			public void run(){
				memoria6.setImageResource(R.drawable.jmemoria);
			}
		},1000);
		
	}
}
