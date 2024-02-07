package com.example.basedatos1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Productos {
	
	public static final String COD ="codigo";
	public static final String DES = "descripcion";
	public static final String UND = "und";
	public static final String UEN = "undxenv";
	public static final String LINEA = "linea";
	public static final String EXS = "existencia";
	private static final String N_BD = "Ventas";
	private static final String N_TABLA = "Productos";
	private static final int VERSION_BD = 4;
	private Creactua Control;
	private final Context nContexto;
	private SQLiteDatabase pBD;
	private static class Creactua extends SQLiteOpenHelper{
		public Creactua(Context context) {
			super(context, N_BD, null, VERSION_BD);
			// TODO Auto-generated constructor stub
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + N_TABLA + " (" + 
					COD + " INTEGER PRIMARY KEY," + 
					DES + " TEXT NOT NULL," + 
					UND + " TEXT NOT NULL," + 
					UEN + " INTEGER NOT NULL," + 
					LINEA + " TEXT NOT NULL," + 
					EXS + " INTEGER NOT NULL);");
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int aVERSION, int nVERSION) {
			db.execSQL("DROP TABLE IF EXISTS " + N_TABLA);
			onCreate(db);
		}
	}
	
	public Productos(Context c) {
		nContexto = c;
	}
	
	public Productos apertura() throws Exception {
		Control = new Creactua(nContexto);
		pBD = Control.getWritableDatabase();
		return this;
	}
	
	public void cerrar() {
		Control.close();
	}
	
	public long Insertar(int qcOD,String qDes,String qUnd,int qUe,String qLin,int qExs){
		
		ContentValues cv=new ContentValues();
		cv.put(COD, qcOD);
		cv.put(DES, qDes);
		cv.put(UND, qUnd);
		cv.put(UEN,qUe);
		cv.put(LINEA, qLin);
		cv.put(EXS,qExs);
		return pBD.insert(N_TABLA, null, cv);
		
	}
	
	public String Listar(){
		String []columnas=new String[]{COD,DES,EXS};
		Cursor c=pBD.query(N_TABLA, columnas, null, null, null, null, null);
		String res="";
		int iCod=c.getColumnIndex(COD);
		int iDes=c.getColumnIndex(DES);
		int iExs=c.getColumnIndex(EXS);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			res+=c.getString(iCod)+" "+c.getString(iDes)+" "+c.getString(iExs)+"\n";
		}
		return res;
	}
}
