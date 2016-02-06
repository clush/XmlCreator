package xml;

import java.util.Calendar;

public class Funktion {
	
	public static String convertToString(int x){
		
		if (x<10)return "0"+x;
		
		return x+"";
		
	}
	
	public static String getDateiDatum(Calendar cal){
		String Jahr = Funktion.getJahr(cal);
		String Monat = Funktion.getMonat(cal);
		String Tag = Funktion.getTag(cal);
		String Stunde = Funktion.getStunde(cal);
		String Minute = Funktion.getMinute(cal);
		String Sekunde = Funktion.getSekunde(cal);
		
		return Jahr+Monat+Tag+"-"+Stunde+Minute+Sekunde;		
	}
	
	public static String getDatum(Calendar cal){
		String Jahr = Funktion.getJahr(cal);
		String Monat = Funktion.getMonat(cal);
		String Tag = Funktion.getTag(cal);
		return Jahr+"-"+Monat+"-"+Tag;
	}
	
	public static String getZeit(Calendar cal){
		String Stunde = Funktion.getStunde(cal);
		String Minute = Funktion.getMinute(cal);
		String Sekunde = Funktion.getSekunde(cal);
		return Stunde+":"+Minute+":"+Sekunde;
	}
	
	public static long getZeitspanne (Calendar cal_1, Calendar cal_2){
		long time = cal_2.getTime().getTime() - cal_1.getTime().getTime();  // Differenz in ms
		long minuten = Math.round( (double)time / (60.*1000.) );; //Differnz in Minuten
		return minuten;
	}
	
	public static String getJahr(Calendar cal){		
		return Funktion.convertToString(cal.get(Calendar.YEAR));		
	}
	
	public static String getMonat(Calendar cal){		
		return Funktion.convertToString(cal.get(Calendar.MONTH)+1);		
	}
	
	public static String getTag(Calendar cal){		
		return Funktion.convertToString(cal.get(Calendar.DATE));		
	}
	
	public static String getStunde(Calendar cal){		
		return Funktion.convertToString(cal.get(Calendar.HOUR));		
	}
	
	public static String getMinute(Calendar cal){		
		return Funktion.convertToString(cal.get(Calendar.MINUTE));
	}
	
	public static String getSekunde(Calendar cal){		
		return Funktion.convertToString(cal.get(Calendar.SECOND));		
	}
}
