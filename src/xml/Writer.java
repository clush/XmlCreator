package xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Writer {
	
	 FileWriter writer;
	 File file;

	 
public void schreiben (String text, String name){
	
	file = new File(name);
    try {
      // new FileWriter(file ,true) - falls die Datei bereits existiert
      // werden die Bytes an das Ende der Datei geschrieben      
      // new FileWriter(file) - falls die Datei bereits existiert
      // wird diese überschrieben
      writer = new FileWriter(file ,true);      
      // Text wird in den Stream geschrieben
      writer.write(text);
      
      
      
      // Schreibt den Stream in die Datei
      // Sollte immer am Ende ausgeführt werden, sodass der Stream 
      // leer ist und alles in der Datei steht.
      writer.flush();
      
      // Schließt den Stream
      writer.close();
   } catch (IOException e) {
     e.printStackTrace();
   }
}

public void schreibeDateiAnfang(String name) throws ParseException{
	String br = System.getProperty("line.separator");
	file = new File(name); 
	try {
	writer = new FileWriter(file);	
	writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
    writer.flush();    
    // Schließt den Stream
    
    writer.close();
	writer = new FileWriter(file, true);
	writer.write(br);
	writer.write("<Values>");
	writer.write(br);
	writer.write("<Type>Second Values</Type>");
	writer.write(br);
	writer.write("<ProtocollVersion>1.34</ProtocollVersion>");
	writer.write(br);
	writer.write("<Company>DRALLE Systementwicklungen</Company>");
	writer.write(br);
	writer.write("<Location>0013_AkuMon</Location>");
	writer.write(br);
	
	Calendar myCal = Calendar.getInstance();
	myCal.set( 2016, Calendar.FEBRUARY, 5, 12, 3, 6 );
	String jahr = Funktion.convertToString(myCal.get(Calendar.YEAR));
	int monat = myCal.get(Calendar.MONTH)+1;
	int tag = myCal.get(Calendar.DATE);
	int stunde = myCal.get(Calendar.HOUR);
	int minute = myCal.get(Calendar.MINUTE);
	int sekunde = myCal.get(Calendar.SECOND);
	
	writer.write("<StartDate>"+jahr+"-"+monat+"-"+tag+"</StartDate>");
	writer.write(br);
	writer.write("<StartTime>"+stunde+"-"+minute+"-"+sekunde+"</StartTime>");
	
	writer.flush();
    
    // Schließt den Stream
    writer.close();
	 } catch (IOException e) {
	     e.printStackTrace();
	 	}

}
}
