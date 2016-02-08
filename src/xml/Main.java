package xml;

import java.io.File;
import java.text.ParseException;

import java.util.Calendar;


public class Main {
	
	
	public static void main(String[] args) throws ParseException {

		String DateiNameAnfang = "0013_AkuMon_conti_Dra_";
		Calendar startDate = Calendar.getInstance();
		startDate.set(2016,Calendar.FEBRUARY,5,0,0,23);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2016,Calendar.FEBRUARY,6,0,0,22);
		
		Writer writer = new Writer();
		String dateiName;
		CsvReader reader = new CsvReader();
	
/******************************************************************************/
		long Dateienanzahl=Funktion.getZeitspanne(startDate, endDate);
		File dir = new File("Demodaten");
		dir.mkdir();
		
		for (int i = 0;i<Dateienanzahl;i++){

		dateiName = dir+"/"+DateiNameAnfang + Funktion.getDateiDatum(startDate) + ".xml";				
		writer.schreibeDateiAnfang(startDate, dateiName);
			for (int j=0;j<60;j++){	
				reader.readCSV();
				writer.writeData(startDate, reader.LAeq, 50,reader.LAFmax, 1, dateiName);
				startDate.set(Calendar.SECOND,startDate.get(Calendar.SECOND)+1);
				
			}
		writer.schreibeEnde(dateiName);
		
		}
		
	}
	
	

}

