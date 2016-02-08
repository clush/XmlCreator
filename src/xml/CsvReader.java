package xml;

public class CsvReader {
	
	String LAeq = "-";
	String LAFmax = "-";
	int zeilenNr = 40;
	
	public void readCSV() {
		
        try {
            java.io.BufferedReader FileReader=                      //ein Reader um die Datei Zeilenweise auszulesen
                    new java.io.BufferedReader(
                        new java.io.FileReader(
                            new java.io.File("0st_komplett_PROFILE Sekundenwerte.csv")
                        )
                    );
           
            String zeile="";            
            for(int i=0;i<zeilenNr;i++){ 						//Springe in passede Zeile
            	zeile=FileReader.readLine();
            }  
            
            if (zeilenNr<20896)zeilenNr++;						//Werte bei der Kalibrierung werden nicht berücksichtigt
            	else zeilenNr = 40;
          
            String[] split=zeile.split(";");                	//hier wird die Zeile zerlegt als Trennzeichen ;
            LAeq=split[2].split(" ")[0];                    
            LAFmax=split[3].split(" ")[0];
                 
            
            
        FileReader.close();           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		
        
    }

}
