package com.example.archivom;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ArrayList<String> titulos = new ArrayList<String>();
	
	ArrayList<String> stitulos = new ArrayList<String>();

		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		
		try {
			AssetManager p = getAssets();
			InputStream lee = p.open("ttatu.txt");
			
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			byte[] cont = new byte[1024]; /*tamanio de bytes*/
			int largo = 0;
			while ((largo = lee.read(cont)) > 0) {
				bs.write(cont,0, largo);
			}
			lee.close();
			
			String resultado = new String(bs.toByteArray(),"UTF-8");
			
			String[] t = resultado.split("\n");
			
			int tx = 0, cb = 0;
			
			while ( cb < botones.length-1) {
				
				if (t[tx].indexOf("XYZ") != -1) {
					titulos.add(t[tx]);
					botones[cb].setText(t[tx]);
					cb++;
				}else{
					stitulos.add(t[tx]);
				}
				
				tx++;
				
			}
			
			while( tx < t.length){
				stitulos.add(t[tx]);				
				tx++;
			}
			
			
	

			//p.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void volver(){
		this.onCreate(new Bundle());
	}
	
	public void boton1(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[0].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
	}
	
	public void boton2(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[1].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}
	
	public void boton3(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[2].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}

	public void boton4(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[3].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}

	public void boton5(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[4].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}

	public void boton6(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[5].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}
	
	public void boton7(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[6].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}

	public void boton8(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[7].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}

	public void boton9(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[8].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}

	public void boton10(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[9].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}

	public void boton11(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[10].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}

	public void boton12(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		botones[12].setVisibility(View.VISIBLE);
		int cb  = 1, st = 0;
		String titulo = botones[11].getText().toString();
		
		botones[0].setText(titulo);
		
		botones[0].setEnabled(false);
		
		String [] div = titulo.split(" ");
		
		String sub = "";
		if(div[0].length()== 5){
			sub = div[0].substring(3,4);
		}else{
			sub = div[0].substring(3,5);
		}
		
		while(cb < botones.length-1 && st < stitulos.size()-1){
			if(stitulos.get(st).indexOf("YYY"+sub+".") != -1){
				botones[cb].setText(stitulos.get(st));
				cb++;
			}
			st++;
		}
		
		botones[cb].setText(stitulos.get(st));
		
		cb++;
		
		while (cb < botones.length-1) {
			botones[cb].setVisibility(View.GONE);
			cb++;
		}
		
		
	}

	
	public void volvemos(View vista){
		Button [] botones = {
				(Button) (findViewById(R.id.button1)),
				(Button) (findViewById(R.id.button2)),
				(Button) (findViewById(R.id.button3)),
				(Button) (findViewById(R.id.button4)),
				(Button) (findViewById(R.id.button5)),
				(Button) (findViewById(R.id.button6)),
				(Button) (findViewById(R.id.button7)),
				(Button) (findViewById(R.id.button8)),
				(Button) (findViewById(R.id.button9)),
				(Button) (findViewById(R.id.button10)),
				(Button) (findViewById(R.id.button11)),
				(Button) (findViewById(R.id.button12)),
				(Button) (findViewById(R.id.button13)),
				
		};
		
		for (int i = 0; i < botones.length-1; i++) {
			botones[i].setVisibility(View.VISIBLE);
			botones[i].setText(titulos.get(i));
		}
		botones[0].setEnabled(true);
		botones[botones.length-1].setVisibility(View.GONE);
	}
}
