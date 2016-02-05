package xml;

import java.text.ParseException;
import java.time.Month;
import java.util.Calendar;


public class Main {
	

	
	
	public static void main(String[] args) throws ParseException {

		String DateiNameAnfang = "0013_AkuMon_conti_Dra_";
		Calendar startDate = Calendar.getInstance();
		startDate.set(2016,Calendar.FEBRUARY,5,0,0,0);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2016,Calendar.FEBRUARY,5,0,2,59);
		
		// Platformunabhängiger Zeilenumbruch wird in den Stream geschrieben
		String br = System.getProperty("line.separator");
		Writer writer = new Writer();
		String dateiName;
		Calendar laufDate = Calendar.getInstance();	
		laufDate = startDate;
		
		
/******************************************************************************/
		
		for (int i = startDate.get(Calendar.MINUTE);i<=endDate.get(Calendar.MINUTE);i++){
		
		laufDate.set(Calendar.MINUTE, i);
		dateiName = DateiNameAnfang + Funktion.getDateiDatum(laufDate) + ".xml";				
		writer.schreibeDateiAnfang(laufDate, dateiName);
		
		writer.schreiben("test",dateiName);
		writer.schreiben(br,dateiName);
		}
	}

}

