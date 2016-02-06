package xml;

import java.text.ParseException;

import java.util.Calendar;


public class Main {
	

	
	
	public static void main(String[] args) throws ParseException {

		String DateiNameAnfang = "0013_AkuMon_conti_Dra_";
		Calendar startDate = Calendar.getInstance();
		startDate.set(2016,Calendar.FEBRUARY,5,0,0,0);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2016,Calendar.FEBRUARY,5,0,2,59);
		
		Writer writer = new Writer();
		String dateiName;
		CsvReader reader = new CsvReader();
	
/******************************************************************************/
		long Dateienanzahl=Funktion.getZeitspanne(startDate, endDate);
		
		for (int i = 0;i<Dateienanzahl;i++){

		dateiName = DateiNameAnfang + Funktion.getDateiDatum(startDate) + ".xml";				
		writer.schreibeDateiAnfang(startDate, dateiName);
			for (int j=0;j<60;j++){				
				writer.writeData(startDate, reader.readCSV(i,j)[0], 50,reader.readCSV(i,j)[1], 1, dateiName);
				
			}
		writer.schreibeEnde(dateiName);
		startDate.set(Calendar.MINUTE,startDate.get(Calendar.MINUTE)+1);
		
		}
		
	}
	
	

}

