package com.example.cacho;

import java.util.Arrays;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	SensorManager sm;
	Sensor sensor;
	SensorEventListener sel;
	int b=0;
	int cach=0;
	int pos[] = new int[5];
	int ori[] = new int[5];
	@Override

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView ptit= (TextView)findViewById(R.id.textView4);
		ptit.setText("CACHITO");
		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		if (sensor==null) {
			Toast.makeText(this, "No Tienes acelerometro...", 1).show();
			finish();
		}
		sel =new SensorEventListener() {

			@Override
			public void onSensorChanged(SensorEvent arg0) {
				// TODO Auto-generated method stub
				float x=arg0.values[0];
				if (x<=50 && cach==0) {
					cach=cach+1;
				} else {
					if (x==50 && cach ==1) {
						cach=cach+1;
					} 
				}
				if (cach==2) {
					sonido();
					cach=0;
				}

			}

			@Override
			public void onAccuracyChanged(Sensor arg0, int arg1) {
				// TODO Auto-generated method stub

			}
		};
		start();
	}


	private void sonido() {
		// TODO Auto-generated method stub
		MediaPlayer mp;
		mp= MediaPlayer.create(this, R.raw.dados);
		mp.start();
	}
	private void start() {
		// TODO Auto-generated method stub
		sm.registerListener(sel, sensor, SensorManager.SENSOR_DELAY_NORMAL);
	}

	private void stop() {
		// TODO Auto-generated method stub
		sm.unregisterListener(sel);
	}

	public void lanzar(View vista){
		b=0;
		int dados[] = {R.drawable.juegodados,R.drawable.and_uno,R.drawable.and_dos,R.drawable.and_tres,
				R.drawable.and_cuatro,R.drawable.and_cinco,R.drawable.and_seis};
		TextView pd1 = (TextView) findViewById(R.id.textView2);
		TextView pd2 = (TextView) findViewById(R.id.textView3);
		ImageView gd1 = (ImageView) findViewById(R.id.imageView1);
		ImageView gd2 = (ImageView) findViewById(R.id.imageView2);
		ImageView gd3 = (ImageView) findViewById(R.id.imageView3);
		ImageView gd4 = (ImageView) findViewById(R.id.imageView4);
		ImageView gd5 = (ImageView) findViewById(R.id.imageView5);

		int d1 = (int)(Math.random()*6)+1;
		int d2 = (int)(Math.random()*6)+1;
		int d3 = (int)(Math.random()*6)+1;
		int d4 = (int)(Math.random()*6)+1;
		int d5 = (int)(Math.random()*6)+1;
		pos[0]=d1;
		pos[1]=d2;
		pos[2]=d3;
		pos[3]=d4;
		pos[4]=d5;

		ori=pos;

		gd1.setImageResource(dados[d1]);
		gd2.setImageResource(dados[d2]);
		gd3.setImageResource(dados[d3]);
		gd4.setImageResource(dados[d4]);
		gd5.setImageResource(dados[d5]);


		TextView ptit= (TextView)findViewById(R.id.textView4);
		Button pbl = (Button) findViewById(R.id.button1);
		jugada(vista);

		pos=ori;
		
	}


	public void baja1(View vista){
		
		if (pos[0]!=0) {
			if (b==0) {
				if (pos[0]==1) {
					ImageView gd1 = (ImageView) findViewById(R.id.imageView1);
					gd1.setImageResource(R.drawable.and_seis);
					pos[0]=6;
					Toast.makeText(this, "Baja...", 1).show();
					b=1;
					jugada(vista);
				}
				else {
					if (pos[0]==2) {
						ImageView gd1 = (ImageView) findViewById(R.id.imageView1);
						gd1.setImageResource(R.drawable.and_cinco);
						pos[0]=5;
						Toast.makeText(this, "Baja...", 1).show();
						b=1;
						jugada(vista);
					}
					else {
						if (pos[0]==3) {
							ImageView gd1 = (ImageView) findViewById(R.id.imageView1);
							gd1.setImageResource(R.drawable.and_cuatro);
							pos[0]=4;
							Toast.makeText(this, "Baja...", 1).show();
							b=1;
							jugada(vista);
						}
						else Toast.makeText(this, "Movimiento Invalido...", 1).show();	
					}
				}

			}
			else Toast.makeText(this, "Movimiento Invalido...", 1).show();	
		}
		else 	Toast.makeText(this, "Lance los dados...", 1).show();

	}
	public void baja2(View vista){
		if (pos[1]!=0) {
			if (b==0) {
				if (pos[1]==1) {
					ImageView gd1 = (ImageView) findViewById(R.id.imageView2);
					gd1.setImageResource(R.drawable.and_seis);
					pos[1]=6;
					Toast.makeText(this, "Baja...", 1).show();
					b=1;
					jugada(vista);
				}
				else {
					if (pos[1]==2) {
						ImageView gd1 = (ImageView) findViewById(R.id.imageView2);
						gd1.setImageResource(R.drawable.and_cinco);
						pos[1]=5;
						Toast.makeText(this, "Baja...", 1).show();
						b=1;
						jugada(vista);
					}
					else {
						if (pos[1]==3) {
							ImageView gd1 = (ImageView) findViewById(R.id.imageView2);
							gd1.setImageResource(R.drawable.and_cuatro);
							pos[1]=4;
							Toast.makeText(this, "Baja...", 1).show();
							b=1;
							jugada(vista);
						}
						else Toast.makeText(this, "Movimiento Invalido...", 1).show();	
					}
				}

			}
			else Toast.makeText(this, "Movimiento Invalido...", 1).show();	
		}
		else 	Toast.makeText(this, "Lance los dados...", 1).show();

	}
	public void baja3(View vista){
	
		if (pos[2]!=0) {
			if (b==0) {
				if (pos[2]==1) {
					ImageView gd1 = (ImageView) findViewById(R.id.imageView3);
					gd1.setImageResource(R.drawable.and_seis);
					pos[2]=6;
					Toast.makeText(this, "Baja...", 1).show();
					b=1;
					jugada(vista);
				}
				else {
					if (pos[2]==2) {
						ImageView gd1 = (ImageView) findViewById(R.id.imageView3);
						gd1.setImageResource(R.drawable.and_cinco);
						pos[2]=5;
						Toast.makeText(this, "Baja...", 1).show();
						b=1;
						jugada(vista);
					}
					else {
						if (pos[2]==3) {
							ImageView gd1 = (ImageView) findViewById(R.id.imageView3);
							gd1.setImageResource(R.drawable.and_cuatro);
							pos[2]=4;
							Toast.makeText(this, "Baja...", 1).show();
							b=1;
							jugada(vista);
						}
						else Toast.makeText(this, "Movimiento Invalido...", 1).show();	
					}
				}

			}
			else Toast.makeText(this, "Movimiento Invalido...", 1).show();	
		}
		else 	Toast.makeText(this, "Lance los dados...", 1).show();

	}
	public void baja4(View vista){
		if (pos[3]!=0) {
			if (b==0) {
				if (pos[3]==1) {
					ImageView gd1 = (ImageView) findViewById(R.id.imageView4);
					gd1.setImageResource(R.drawable.and_seis);
					pos[3]=6;
					Toast.makeText(this, "Baja...", 1).show();
					b=1;
					jugada(vista);
				}
				else {
					if (pos[3]==2) {
						ImageView gd1 = (ImageView) findViewById(R.id.imageView4);
						gd1.setImageResource(R.drawable.and_cinco);
						pos[3]=5;
						Toast.makeText(this, "Baja...", 1).show();
						b=1;
						jugada(vista);
					}
					else {
						if (pos[3]==3) {
							ImageView gd1 = (ImageView) findViewById(R.id.imageView4);
							gd1.setImageResource(R.drawable.and_cuatro);
							pos[3]=4;
							Toast.makeText(this, "Baja...", 1).show();
							b=1;
							jugada(vista);
						}
						else Toast.makeText(this, "Movimiento Invalido...", 1).show();	
					}
				}

			}
			else Toast.makeText(this, "Movimiento Invalido...", 1).show();	
		}
		else 	Toast.makeText(this, "Lance los dados...", 1).show();

	}
	public void baja5(View vista){
		if (ori[4]!=0) {
			if (b==0) {
				if (ori[4]==1) {
					ImageView gd1 = (ImageView) findViewById(R.id.imageView5);
					gd1.setImageResource(R.drawable.and_seis);
					pos[4]=6;
					Toast.makeText(this, "Baja...", 1).show();
					b=1;
					jugada(vista);
				}
				else {
					if (ori[4]==2) {
						ImageView gd1 = (ImageView) findViewById(R.id.imageView5);
						gd1.setImageResource(R.drawable.and_cinco);
						pos[4]=5;
						Toast.makeText(this, "Baja...", 1).show();
						b=1;
						jugada(vista);
					}
					else {
						if (ori[4]==3) {
							ImageView gd1 = (ImageView) findViewById(R.id.imageView5);
							gd1.setImageResource(R.drawable.and_cuatro);
							pos[4]=4;
							Toast.makeText(this, "Baja...", 1).show();
							b=1;
							jugada(vista);
						}
						else Toast.makeText(this, "Movimiento Invalido...", 1).show();	
					}
				}

			}
			else Toast.makeText(this, "Movimiento Invalido...", 1).show();	
		}
		else 	Toast.makeText(this, "Lance los dados...", 1).show();

	}


	public void jugada(View vista){
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


		TextView ptit= (TextView)findViewById(R.id.textView4);


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
	public void finalizar(View vista){
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		stop();
		super.onPause();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		start();
		super.onResume();
	}

/*
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
*/
}
