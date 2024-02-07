package com.example.cacho2;



import java.util.Arrays;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int dados[] = {R.drawable.juegodados,R.drawable.and_uno,R.drawable.and_dos,R.drawable.and_tres,
			R.drawable.and_cuatro,R.drawable.and_cinco,R.drawable.and_seis};
	int b=0;
	int cach=0;
	int pos[] = new int[5];
	int ori[] = new int[5];
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
	
	public void lanzar(View vista){
		b = 0;

		ImageButton gd1 = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton gd2 = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton gd3 = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton gd4 = (ImageButton) findViewById(R.id.imageButton4);
		ImageButton gd5 = (ImageButton) findViewById(R.id.ImageButton01);
		gd1.setEnabled(true);
		gd2.setEnabled(true);
		gd3.setEnabled(true);
		gd4.setEnabled(true);
		gd5.setEnabled(true);
		
		int d1 = (int)(Math.random()*6)+1;
		int d2 = (int)(Math.random()*6)+1;
		int d3 = (int)(Math.random()*6)+1;
		int d4 = (int)(Math.random()*6)+1;
		int d5 = (int)(Math.random()*6)+1;
		ori[0]= pos[0]=d1;
		ori[1]= pos[1]=d2;
		ori[2]= pos[2]=d3;
		ori[3]= pos[3]=d4;
		ori[4]= pos[4]=d5;

		//ori=pos;
		
		gd5.setImageResource(dados[d1]);
		gd1.setImageResource(dados[d2]);
		gd2.setImageResource(dados[d3]);
		gd3.setImageResource(dados[d4]);
		gd4.setImageResource(dados[d5]);


		TextView ptit= (TextView)findViewById(R.id.textView1);
		Button pbl = (Button) findViewById(R.id.button1);
		jugada(vista);

		//pos=ori;
	}
	
	public void jugada(View vista){
		pos=ori.clone();
		//ori=pos;
		int sw=0;
		Arrays.sort(pos);

		int esc[] = new int[5];
		esc[0]=1;
		esc[1]=2;
		esc[2]=3;
		esc[3]=4;
		esc[4]=5;

		int esc2[] = new int[5];
		esc2[0]=2;
		esc2[1]=3;
		esc2[2]=4;
		esc2[3]=5;
		esc2[4]=6;

		int esc3[] = new int[5];
		esc3[0]=1;
		esc3[1]=3;
		esc3[2]=4;
		esc3[3]=5;
		esc3[4]=6;


		TextView ptit= (TextView)findViewById(R.id.textView1);


		//ESCALERA
		if (pos[0]==esc[0] && pos[1]==esc[1] && pos[2]==esc[2] &&
				pos[3]==esc[3] && pos[4]==esc[4]) {
			ptit.setText("ESCALERA...");
			sw=1;
		}

		if (pos[0]==esc2[0] && pos[1]==esc2[1] && pos[2]==esc2[2] &&
				pos[3]==esc2[3] && pos[4]==esc2[4]) {
			ptit.setText("ESCALERA...");
			sw=1;
		}

		if (pos[0]==esc3[0] && pos[1]==esc3[1] && pos[2]==esc3[2] &&
				pos[3]==esc3[3] && pos[4]==esc3[4]) {
			ptit.setText("ESCALERA...");
			sw=1;
		}

		//POKER
		if ((pos[0]==pos[1] && pos[0]==pos[2] && pos[0]==pos[3]) ||
				(pos[1]==pos[4] && pos[1]==pos[2] && pos[1]==pos[3])) {
			ptit.setText("POKER...");
			sw=1;
		}

		//FULL
		if ((pos[0]==pos[1] && pos[0]==pos[2] && pos[3]==pos[4] ) ||
				(pos[0]==pos[1] && pos[2]==pos[3] && pos[2]==pos[4])) {
			ptit.setText("FULL...");
			sw=1;
		}

		//GRANDE
		if (pos[0]==pos[1] && pos[0]==pos[2] && pos[0]==pos[3] && pos[0]==pos[4]) {
			ptit.setText("...GRANDE...");
			sw=1;
		}

		//NADA
		if (sw==0) {
			ptit.setText("NADA...!");
		}
	}
	
	public void voltear(View vista){
		ImageButton gd1 = (ImageButton) findViewById(R.id.ImageButton01);
		ImageButton gd2 = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton gd3 = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton gd4 = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton gd5 = (ImageButton) findViewById(R.id.imageButton4);
		
		ImageButton[] btns = new ImageButton[5];
		btns[0]=(ImageButton) findViewById(R.id.ImageButton01);
		btns[1]=(ImageButton) findViewById(R.id.imageButton1);
		btns[2]=(ImageButton) findViewById(R.id.imageButton2);
		btns[3]=(ImageButton) findViewById(R.id.imageButton3);
		btns[4]=(ImageButton) findViewById(R.id.imageButton4);
		
		int t = 7 - ori[0];
		gd1.setImageResource(dados[t]);
		gd1.setEnabled(false);
		
		
	}
	

	public void baja1(View vista){
		ImageButton gd1 = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton gd2 = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton gd3 = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton gd4 = (ImageButton) findViewById(R.id.imageButton4);
		ImageButton gd5 = (ImageButton) findViewById(R.id.ImageButton01);
		if (b<2){
			if(ori[0] == 1){
				
				ori[0] = 6;
				gd5.setImageResource(dados[6]);
				gd5.setEnabled(false);
				jugada(vista);
				b++;
			}else if(ori[0] == 2){
					
					ori[0] = 5;
					gd5.setImageResource(dados[5]);
					gd5.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[0] == 3){
					ori[0] = 4;
					gd5.setImageResource(dados[4]);
					gd5.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[0] == 4){
					
					ori[0] = 3;
					gd5.setImageResource(dados[3]);
					gd5.setEnabled(false);
					jugada(vista);
					b++;
			}else if(ori[0] == 5){
					ori[0] = 2;
					gd5.setImageResource(dados[2]);
					gd5.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[0] == 6){
					ori[0] = 1;
					gd5.setImageResource(dados[1]);
					gd5.setEnabled(false);
					jugada(vista);
					b++;
			}else
				Toast.makeText(this, "Juega de nuevo...", 1).show(); 
			
		}else{
			Toast.makeText(this, "Bajas echas...", 1).show(); 
		}
	}
	
	public void baja2(View vista){
		ImageButton gd1 = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton gd2 = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton gd3 = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton gd4 = (ImageButton) findViewById(R.id.imageButton4);
		ImageButton gd5 = (ImageButton) findViewById(R.id.ImageButton01);
		if (b<2){
			if(ori[1] == 1){
				
				ori[1] = 6;
				gd1.setImageResource(dados[6]);
				gd1.setEnabled(false);
				jugada(vista);
				b++;
			}else if(ori[1] == 2){
					
					ori[1] = 5;
					gd1.setImageResource(dados[5]);
					gd1.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[1] == 3){
					ori[1] = 4;
					gd1.setImageResource(dados[4]);
					gd1.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[1] == 4){
					
					ori[1] = 3;
					gd1.setImageResource(dados[3]);
					gd1.setEnabled(false);
					jugada(vista);
					b++;
			}else if(ori[1] == 5){
					ori[1] = 2;
					gd1.setImageResource(dados[2]);
					gd1.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[1] == 6){
					ori[1] = 1;
					gd1.setImageResource(dados[1]);
					gd1.setEnabled(false);
					jugada(vista);
					b++;
			}else
				Toast.makeText(this, "Juega de nuevo...", 1).show(); 
			
		}else{
			Toast.makeText(this, "Bajas echas...", 1).show(); 
		}
	}
	
	public void baja3(View vista){
		ImageButton gd2 = (ImageButton) findViewById(R.id.imageButton2);
		if (b<2){
			if(ori[2] == 1){
				
				ori[2] = 6;
				gd2.setImageResource(dados[6]);
				gd2.setEnabled(false);
				jugada(vista);
				b++;
			}else if(ori[2] == 2){
					
					ori[2] = 5;
					gd2.setImageResource(dados[5]);
					gd2.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[2] == 3){
					ori[2] = 4;
					gd2.setImageResource(dados[4]);
					gd2.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[2] == 4){
					
					ori[2] = 3;
					gd2.setImageResource(dados[3]);
					gd2.setEnabled(false);
					jugada(vista);
					b++;
			}else if(ori[2] == 5){
					ori[2] = 2;
					gd2.setImageResource(dados[2]);
					gd2.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[2] == 6){
					ori[2] = 1;
					gd2.setImageResource(dados[1]);
					gd2.setEnabled(false);
					jugada(vista);
					b++;
			}else
				Toast.makeText(this, "Juega de nuevo...", 1).show(); 
			
		}else{
			Toast.makeText(this, "Bajas echas...", 1).show(); 
		}
		
	}
	
	public void baja4(View vista){
		ImageButton gd3 = (ImageButton) findViewById(R.id.imageButton3);
		if (b<2){
			if(ori[3] == 1){
				
				ori[3] = 6;
				gd3.setImageResource(dados[6]);
				gd3.setEnabled(false);
				jugada(vista);
				b++;
			}else if(ori[3] == 2){
					
					ori[3] = 5;
					gd3.setImageResource(dados[5]);
					gd3.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[3] == 3){
					ori[3] = 4;
					gd3.setImageResource(dados[4]);
					gd3.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[3] == 4){
					
					ori[3] = 3;
					gd3.setImageResource(dados[3]);
					gd3.setEnabled(false);
					jugada(vista);
					b++;
			}else if(ori[3] == 5){
					ori[3] = 2;
					gd3.setImageResource(dados[2]);
					gd3.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[3] == 6){
					ori[3] = 1;
					gd3.setImageResource(dados[1]);
					gd3.setEnabled(false);
					jugada(vista);
					b++;
			}else
				Toast.makeText(this, "Juega de nuevo...", 1).show(); 
			
		}else{
			Toast.makeText(this, "Bajas echas...", 1).show(); 
		}
		
	}
	public void baja5(View vista){
		ImageButton gd4 = (ImageButton) findViewById(R.id.imageButton4);
		if (b<2){
			if(ori[4] == 1){
				
				ori[4] = 6;
				gd4.setImageResource(dados[6]);
				gd4.setEnabled(false);
				jugada(vista);
				b++;
			}else if(ori[4] == 2){
					
					ori[4] = 5;
					gd4.setImageResource(dados[5]);
					gd4.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[4] == 3){
					ori[4] = 4;
					gd4.setImageResource(dados[4]);
					gd4.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[4] == 4){
					
					ori[4] = 3;
					gd4.setImageResource(dados[3]);
					gd4.setEnabled(false);
					jugada(vista);
					b++;
			}else if(ori[4] == 5){
					ori[4] = 2;
					gd4.setImageResource(dados[2]);
					gd4.setEnabled(false);
					jugada(vista);
					b++;
				
			}else if(ori[4] == 6){
					ori[4] = 1;
					gd4.setImageResource(dados[1]);
					gd4.setEnabled(false);
					jugada(vista);
					b++;
			}else
				Toast.makeText(this, "Juega de nuevo...", 1).show(); 
			
		}else{
			Toast.makeText(this, "Bajas echas...", 1).show(); 
		}	
	}

	public void finalizar(View vista){
		finish();
	}
}
	

