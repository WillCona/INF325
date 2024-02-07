package com.example.coopertivasbd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Cooperativa {
	//clientes = cl
	//
	public static final String N_BD = "cooperativa.db";
	public static final int VERSION_BD = 1;
	public static final String CLCAR = "carnet";
	public static final String CLNOM = "nombres";
	public static final String CLPRO = "codprof";
	public static final String CLDEP = "codepto";
	private static final String N_CLIENTES = "clientes";
	
	public static final String CTCTA = "cuenta";
	public static final String CTCAR = "carnet";
	public static final String CTFAP = "fapertura";
	private static final String N_CUENTAS = "cuentas";
	
	public static final String DPCOD = "codepto";
	public static final String DPDES = "descripcion";
	private static final String N_DEPTOS = "departamentos";
	
	
	public static final String MVCOR = "id";
	public static final String MVCTA = "cuenta";
	public static final String MVMON = "monto";
	public static final String MVFEC = "fecha";
	public static final String MVSEM = "semana";
	private static final String N_MOVIMS = "movimientos";
	
	public static final String PFCOD = "codprof";
	public static final String PFDES = "descripcion";
	private static final String N_PROF = "profesiones";

	
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
			db.execSQL("CREATE TABLE " + N_CLIENTES + " (" + 
					CLCAR + " INTEGER PRIMARY KEY," + 
					CLNOM + " TEXT NOT NULL," + 
					CLPRO + " INTEGER NOT NULL," + 
					CLDEP + " INTEGER NOT NULL);");
			
			db.execSQL("CREATE TABLE " + N_CUENTAS + " (" + 
					CTCTA + " TEXT PRIMARY KEY," + 
					CTCAR + " INTEGER NOT NULL," + 
					CTFAP + " TEXT NOT NULL);");
			
			db.execSQL("CREATE TABLE " + N_DEPTOS + " (" + 
					DPCOD + " INTEGER PRIMARY KEY," + 
					DPDES + " TEXT NOT NULL);");
			
			db.execSQL("CREATE TABLE " + N_MOVIMS + " (" + 
					MVCOR + " INTEGER PRIMARY KEY," + 
					MVCTA + " TEXT NOT NULL," + 
					MVMON + " INTEGER NOT NULL," + 
					MVFEC + " TEXT NOT NULL," +
					MVSEM + " INTEGER NOT NULL);");
					
			db.execSQL("CREATE TABLE " + N_PROF + " (" + 
					PFCOD + " INTEGER PRIMARY KEY," + 
					PFDES + " TEXT NOT NULL);");
					
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int aVERSION, int nVERSION) {
			db.execSQL("DROP TABLE IF EXISTS " + N_CLIENTES);
			db.execSQL("DROP TABLE IF EXISTS " + N_CUENTAS);
			db.execSQL("DROP TABLE IF EXISTS " + N_DEPTOS);
			db.execSQL("DROP TABLE IF EXISTS " + N_MOVIMS);
			db.execSQL("DROP TABLE IF EXISTS " + N_PROF);
			onCreate(db);
		}
	}
	
	public Cooperativa(Context c) {
		nContexto = c;
	}
	
	public Cooperativa apertura() throws Exception {
		Control = new Creactua(nContexto);
		pBD = Control.getWritableDatabase();
		return this;
	}
	
	public void cerrar() {
		Control.close();
	}
	
	public long CLins(int qCar, String qNom,int qCpr,int qCdp){
		
		ContentValues cv=new ContentValues();
		cv.put(CLCAR, qCar);
		cv.put(CLNOM, qNom);
		cv.put(CLPRO, qCpr);
		cv.put(CLDEP,qCdp);

		return pBD.insert(N_CLIENTES, null, cv);
		
	}
	
	public long CTins(String qCta,int qCar,String qFap){
		
		ContentValues cv=new ContentValues();
		cv.put(CTCAR, qCta);
		cv.put(CTCAR, qCar);
		cv.put(CTFAP, qFap);


		return pBD.insert(N_CUENTAS, null, cv);
		
	}

	public long DPins(int qCod,String qDes){
		
		ContentValues cv=new ContentValues();
		cv.put(DPCOD, qCod);
		cv.put(DPDES, qDes);
		return pBD.insert(N_DEPTOS, null, cv);
		
	}
	
	public long MVins(int qCor, String qCta,int qMon,String qFec, int qSem){
		
		ContentValues cv=new ContentValues();
		cv.put(MVCOR, qCor);
		cv.put(MVCTA, qCta);
		cv.put(MVMON, qMon);
		cv.put(MVFEC,qFec);
		cv.put(MVSEM,qSem);		

		return pBD.insert(N_MOVIMS, null, cv);
		
	}
	

	public long PFins(int qCod,String qDes){
		
		ContentValues cv=new ContentValues();
		cv.put(PFCOD, qCod);
		cv.put(PFDES, qDes);
		return pBD.insert(N_PROF, null, cv);
		
	}

	
	public String CLRep(){
		String []columnas=new String[]{CLCAR,CLNOM,CLPRO,CLDEP};
		Cursor c=pBD.query(N_CLIENTES, columnas, null, null, null, null, null);
		String res="";
		int iCar=c.getColumnIndex(CLCAR);
		int iNom=c.getColumnIndex(CLNOM);
		int iPro=c.getColumnIndex(CLPRO);
		int iDep=c.getColumnIndex(CLDEP);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			res+=c.getString(iCar)+" "+c.getString(iNom)+" "+c.getString(iPro)+c.getString(iDep)+"\n";
		}
		return res;
	}
	
	
	public String DPRep(){
		String []columnas=new String[]{DPCOD,DPDES};
		Cursor c=pBD.query(N_DEPTOS, columnas, null, null, null, null, null);
		String res="";
		int iCod=c.getColumnIndex(DPCOD);
		int iDes=c.getColumnIndex(DPDES);

		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			res+=c.getString(iCod)+" "+c.getString(iDes)+"\n";
		}
		return res;
	}
	
}
