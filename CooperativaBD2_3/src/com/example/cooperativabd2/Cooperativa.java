package com.example.cooperativabd2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Cooperativa {
	//clientes = cl
	//
	public static final String N_BD = "cooperativa.db";
	public static final int VERSION_BD = 2;
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
		cv.put(CTCTA, qCta);
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
	
	public String CLRep2(){
		String []columnas=new String[]{CLCAR,CLNOM};
		Cursor c=pBD.query(N_CLIENTES, columnas, null, null, null, null, null);
		String res="";
		int iCar=c.getColumnIndex(CLCAR);
		int iNom=c.getColumnIndex(CLNOM);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			res+=c.getString(iCar)+" "+c.getString(iNom)+"\n";
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
	public String repNombre(String carnet){
		String []columnas=new String[]{CLNOM};
		String cond = CLCAR+" = ?";
		String[] seleccionArgs = {carnet};
		Cursor c=pBD.query(N_CLIENTES, columnas, cond, seleccionArgs, null, null, null);
		String res="No existe";
		int iNom=c.getColumnIndex(CLNOM);
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			res=c.getString(iNom)+"\n";
		}
		c.close();
		return res;
	}
	
	
	public String buscardepto(String xdepto){
	
		String res="";
		
		String consulta = "SELECT "+DPDES + " FROM departamentos where "+DPCOD + " = "+xdepto;
		
		
		Cursor c = pBD.rawQuery(consulta, null);
		
		if (c.moveToFirst()) {
		    res = ""; // Reinicia el resultado

		    do {
		        // Obtiene los índices de las columnas
		        int iDes = c.getColumnIndex(DPDES);


		        // Obtiene los valores de las columnas
		        String descripcion = c.getString(iDes);

		        // Construye el resultado
		        res = res +descripcion+ "\n";
		    } while (c.moveToNext());
		}
		
		consulta = "select sum(m.monto) as comida from cuentas c, movimientos m "+
		"where c.cuenta = m.cuenta and c.carnet in (select c.carnet "+
		"from clientes c, departamentos d where c.codepto = d.codepto and d.codepto = "+xdepto+");";

		c = pBD.rawQuery(consulta, null);
		
		if (c.moveToFirst()) {
		    //res = ""; // Reinicia el resultado

		    do {
		        // Obtiene los índices de las columnas
		        int iSum = c.getColumnIndex("comida");


		        // Obtiene los valores de las columnas
		        String descripcion = c.getString(iSum);

		        // Construye el resultado
		        res = res +"TOTAL:"+descripcion+ "\n";
		    } while (c.moveToNext());
		}
		
		c.close();
		return res;
		
	}
	
	
	public String buscarprof(String xprof){
		
		String res="";
		
		String consulta = "SELECT "+PFDES + " FROM profesiones where "+PFCOD + " = "+xprof;
		
		
		Cursor c = pBD.rawQuery(consulta, null);
		
		if (c.moveToFirst()) {
		    res = ""; // Reinicia el resultado

		    do {
		        // Obtiene los índices de las columnas
		        int iDes = c.getColumnIndex(PFDES);


		        // Obtiene los valores de las columnas
		        String descripcion = c.getString(iDes);

		        // Construye el resultado
		        res = res +descripcion+ "\n";
		    } while (c.moveToNext());
		}
		
		consulta = "select sum(m.monto) as comida from cuentas c, movimientos m "+
				"where c.cuenta = m.cuenta and c.carnet in (select c.carnet from clientes c where c.codprof = "+xprof+");";
		
//		consulta = "select sum(m.monto) as comida from cuentas c, movimientos m "+
//		"where c.cuenta = m.cuenta and c.carnet in (select c.carnet "+
//		"from clientes c, departamentos d where c.codepto = d.codepto and d.codepto = "+xdepto+");";

		c = pBD.rawQuery(consulta, null);
		
		if (c.moveToFirst()) {
		    //res = ""; // Reinicia el resultado

		    do {
		        // Obtiene los índices de las columnas
		        int iSum = c.getColumnIndex("comida");


		        // Obtiene los valores de las columnas
		        String descripcion = c.getString(iSum);

		        // Construye el resultado
		        res = res +"TOTAL:"+descripcion+ "\n";
		    } while (c.moveToNext());
		}
		
		c.close();
		return res;
		
	}
	
	
	public String repNombre2(String carnet){
		String res = "no hay";
		String consulta = "SELECT "+CLNOM + ",p."+PFDES+", d."+DPDES+
						" FROM "+N_CLIENTES+" c, "+N_DEPTOS+" d, "+N_PROF+" p "+
						"WHERE c."+CLPRO +" = p."+PFCOD+" AND "+ "d."+DPCOD+" = c."+CLDEP+" AND c."+CLCAR + " = ?";
		
		Cursor c = pBD.rawQuery(consulta, new String[]{carnet});
						
		if (c.moveToFirst()) {
		    res = ""; // Reinicia el resultado

		    do {
		        // Obtiene los índices de las columnas
		        int iNom = c.getColumnIndex(CLNOM);
		        int iPFDES = c.getColumnIndex("p."+PFDES);
		        int iDPDES = c.getColumnIndex("d."+DPDES);

		        // Obtiene los valores de las columnas
		        String nombre = c.getString(iNom);
		        String pfdes = c.getString(iPFDES);
		        String dpdes = c.getString(iDPDES);

		        // Construye el resultado
		        res = res +nombre + "\n" + dpdes + "\n";
		    } while (c.moveToNext());
		}

		c.close();
		
		consulta = "SELECT "+ PFDES +
						" FROM "+N_CLIENTES+" c, "+N_PROF+" p "+
						"WHERE c."+CLPRO +" = p."+PFCOD+" AND "+CLCAR + " = ?";
		
		c = pBD.rawQuery(consulta, new String[]{carnet});
		
		if (c.moveToFirst()) {
		    //res = ""; // Reinicia el resultado

		    do {
		        // Obtiene los índices de las columnas

		        int iPFDES = c.getColumnIndex(PFDES);

		        // Obtiene los valores de las columnas
		        String pfdes = c.getString(iPFDES);


		        // Construye el resultado
		        res+=pfdes;
		    } while (c.moveToNext());
		}
		c.close();
		
		res +="##\n";
		
		consulta = "SELECT c."+CTCTA+", "+"sum("+MVMON+") "+
					"FROM "+ N_CUENTAS+" c, "+N_MOVIMS+" m "+
					"WHERE "+"c."+CTCTA+" = m."+MVCTA+" AND c."+CTCAR+" = "+carnet+
					" GROUP BY m."+CTCTA;
		
		
		c = pBD.rawQuery(consulta, null);
		
		if (c.moveToFirst()) {
		    //res = ""; // Reinicia el resultado

		    do {
		        // Obtiene los índices de las columnas

		        int iCTCTA = c.getColumnIndex(CTCTA);
		        int iSUM = c.getColumnIndex("sum("+MVMON+")");

		        // Obtiene los valores de las columnas
		        String ctcta = c.getString(iCTCTA);
		        String sum = c.getString(iSUM);

		        // Construye el resultado
		        res+=ctcta+"\t"+sum+"\n";
		    } while (c.moveToNext());
		}
		c.close();
		
		
		res +="##";
		
		consulta = "select sum("+MVMON+")"+
					" from "+N_CUENTAS+" c,"+N_MOVIMS+" m "+
					"WHERE c."+ CTCTA+" = m."+MVCTA+" AND c."+CTCAR+" = "+carnet;
		
		c = pBD.rawQuery(consulta, null);
		
		if (c.moveToFirst()) {
		    //res = ""; // Reinicia el resultado

		    do {
		        // Obtiene los índices de las columnas
		        int isum = c.getColumnIndex("sum("+MVMON+")");
		        // Obtiene los valores de las columnas
		        String sum = c.getString(isum);

		        // Construye el resultado
		        res = res + sum;
		    } while (c.moveToNext());
		}

		c.close();
		
		return res;
	}
}
