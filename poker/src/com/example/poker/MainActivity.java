package com.example.poker;

import java.util.ArrayList;
import java.util.Queue;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	ArrayList<Integer> imcora2 = new ArrayList<Integer>();
	
	
	
	
	
	int [] imcora = {R.drawable.cor1,R.drawable.cor2,R.drawable.cor3,R.drawable.cor4,R.drawable.cor5,R.drawable.cor6,R.drawable.cor7,R.drawable.cor8,R.drawable.cor9,R.drawable.cor10,R.drawable.cor11,R.drawable.cor12,R.drawable.cor13};
	int [] imesp = {R.drawable.esp1,R.drawable.esp2,R.drawable.esp3,R.drawable.esp4,R.drawable.esp5,R.drawable.cor6,R.drawable.cor7,R.drawable.cor8,R.drawable.cor9,R.drawable.cor10,R.drawable.cor11,R.drawable.cor12,R.drawable.cor13};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	
	public void iniciar(View vista){
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
