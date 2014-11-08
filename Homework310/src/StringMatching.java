import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/*This File takes two inputs via command line to allow 
the user to search a file for a specific phrase.
To search via command line: javac StringMatching.java
To run via command line:  java StringMatching ../data/testtwo searchPhrase */

public class StringMatching {

	public StringMatching(){
		
	}
	
	public int loadFromFile(String anotherFile, String searchPhrase){
		int len = searchPhrase.length();
		int count =0;
		int indexOf = -1;
		File file = new File(anotherFile);

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();	
				
				for(int j=1;j<line.length();j++){
					
					if(line.charAt(j-1)==searchPhrase.charAt(count)){
				
						 indexOf = (j-1)-count;
						if((count+1)==len){
							System.out.println("It's all there.  Your searched phrase begins at index "+ indexOf+".");	
							
							return indexOf;
							
						}
						count++;
					
					}else{
					
						count = 0;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return indexOf;
	}
	

	
	public static void main(String args[]){
		
		StringMatching sm = new StringMatching();
		//String phrase = "za";
		//String testing = "data/testtwo";
		
		String phrase = args[1];
		String testing = args[0];
		sm.loadFromFile(testing, phrase);

		
	}
	
	
}
