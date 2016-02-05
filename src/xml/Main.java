package xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Main {
	

	
	
	public static void main(String[] args) throws ParseException {
		// Platformunabhängiger Zeilenumbruch wird in den Stream geschrieben
		String br = System.getProperty("line.separator");
		String name1 = "0013_AkuMon_conti_Dra_";
		
		Writer writer = new Writer();
		
		int stunde = 0;
		int minute = 0;
		int sekunde = 0;		
		String Stunde = Funktion.convertToString(stunde);
		String Minute = Funktion.convertToString(minute);
		String Sekunde = Funktion.convertToString(sekunde);
		
/******************************************************************************/
		
		String datum = "20160205-"+Stunde+Minute+Sekunde;
		String name = name1 + datum + ".xml";
		
		writer.schreibeDateiAnfang(name);
		writer.schreiben("test",name);
		writer.schreiben(br,name);
		writer.schreiben("</>",name);		

	}

}

