package com.example.calculadora;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	public void sumar(View vista){
		TextView ptv = (TextView) findViewById(R.id.editText1);
	    TextView ptv2 = (TextView) findViewById(R.id.editText2);
	    
	    // Obtener los valores de los TextView como cadenas de texto
	    String textValue1 = ptv.getText().toString();
	    String textValue2 = ptv2.getText().toString();
	    
	    try {
	        // Convertir las cadenas de texto a valores double
	        double valor1 = Double.parseDouble(textValue1);
	        double valor2 = Double.parseDouble(textValue2);
	        
	        // Realizar la suma de los valores
	        double r = valor1 + valor2;
	        
	        // Mostrar el resultado en un TextView
	        TextView ptv3 = (TextView) findViewById(R.id.editText3);
	        ptv3.setText(String.valueOf(r));
	    } catch (Exception e) {
	        // Manejar una excepción si la conversión falla
	        Toast.makeText(this,"ingrese datos correctos",1).show();
	        // También puedes mostrar un mensaje de error al usuario
	    }
	}
	
	public void restar(View vista){
		TextView ptv = (TextView) findViewById(R.id.editText1);
	    TextView ptv2 = (TextView) findViewById(R.id.editText2);
	    
	    // Obtener los valores de los TextView como cadenas de texto
	    String textValue1 = ptv.getText().toString();
	    String textValue2 = ptv2.getText().toString();
	    
	    try {
	        // Convertir las cadenas de texto a valores double
	        double valor1 = Double.parseDouble(textValue1);
	        double valor2 = Double.parseDouble(textValue2);
	        
	        // Realizar la suma de los valores
	        double r = valor1 - valor2;
	        
	        // Mostrar el resultado en un TextView
	        TextView ptv3 = (TextView) findViewById(R.id.editText3);
	        ptv3.setText(String.valueOf(r));
	    } catch (NumberFormatException e) {
	        // Manejar una excepción si la conversión falla
	        Toast.makeText(this,"ingrese datos correctos",1).show();
	        // También puedes mostrar un mensaje de error al usuario
	    }
	}

	public void multiplicar(View vista){
		TextView ptv = (TextView) findViewById(R.id.editText1);
	    TextView ptv2 = (TextView) findViewById(R.id.editText2);
	    
	    // Obtener los valores de los TextView como cadenas de texto
	    String textValue1 = ptv.getText().toString();
	    String textValue2 = ptv2.getText().toString();
	    
	    try {
	        // Convertir las cadenas de texto a valores double
	        double valor1 = Double.parseDouble(textValue1);
	        double valor2 = Double.parseDouble(textValue2);
	        
	        if (valor2 == 0.0){
	        	Toast.makeText(this,"ingrese datos correctos",1).show();
			} else {
				 double r = valor1 * valor2;    
			     // Mostrar el resultado en un TextView
			     TextView ptv3 = (TextView) findViewById(R.id.editText3);
			     ptv3.setText(String.valueOf(r));
			}
	        // Realizar la suma de los valores
	       
	    } catch (Exception e) {
	        // Manejar una excepción si la conversión falla
	        Toast.makeText(this,"ingrese datos correctos",1).show();
	        // También puedes mostrar un mensaje de error al usuario
	    }
	}
	
    public void limpiar(View vista){
    	TextView  ptv = (TextView) findViewById(R.id.editText1);
    	TextView  ptv2 = (TextView) findViewById(R.id.editText2);
    	TextView  ptv3 = (TextView) findViewById(R.id.editText3);
    	
    	ptv.setText("");
    	ptv2.setText("");
    	ptv3.setText("");
    	
    }
	
	public void dividir(View vista){
		TextView ptv = (TextView) findViewById(R.id.editText1);
	    TextView ptv2 = (TextView) findViewById(R.id.editText2);
	    
	    // Obtener los valores de los TextView como cadenas de texto
	    String textValue1 = ptv.getText().toString();
	    String textValue2 = ptv2.getText().toString();
	    
	    try {
	        // Convertir las cadenas de texto a valores double
	        double valor1 = Double.parseDouble(textValue1);
	        double valor2 = Double.parseDouble(textValue2);
	        
	        // Realizar la suma de los valores
	        double r = valor1 / valor2;
	        
	        // Mostrar el resultado en un TextView
	        TextView ptv3 = (TextView) findViewById(R.id.editText3);
	        ptv3.setText(String.valueOf(r));
	    } catch (Exception e) {
	        // Manejar una excepción si la conversión falla
	        Toast.makeText(this,"ingrese datos correctos",1).show();
	        // También puedes mostrar un mensaje de error al usuario
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
