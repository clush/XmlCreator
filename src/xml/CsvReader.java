package xml;

public class CsvReader {
	
	public String[] readCSV(int x, int y) {
		String[] result = {"-","-"};
        try {
            java.io.BufferedReader FileReader=                      //ein Reader um die Datei Zeilenweise auszulesen
                    new java.io.BufferedReader(
                        new java.io.FileReader(
                            new java.io.File("0st_komplett_PROFILE Sekundenwerte.csv")
                        )
                    );
           
            String zeile="";
            
            int zaehler = 40+(x*60)+y;
            while(zaehler>20918){
            	zaehler-=20878;
            }
            
            for(int i=0;i<zaehler;i++){ 					//Springe in passede Zeile
            	zeile=FileReader.readLine();
            }
           
          
                String[] split=zeile.split(";");                //hier wird die Zeile zerlegt als Trennzeichen ;
                String LAeq=split[2].split(" ")[0];
                result[0]=LAeq;                       
                
                String LAFmax=split[3].split(" ")[0];
                result[1]=LAFmax;  
            
            
        FileReader.close();           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		return result;
        
    }

}
