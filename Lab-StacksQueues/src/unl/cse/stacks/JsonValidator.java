package unl.cse.stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A basic JSON validator.  This validator only checks that the JSON file is
 * well-balanced: that all opening brackets have a corresponding closing bracket
 * and that they follow legal nesting rules.  
 * 
 */
public class JsonValidator {

	public static void validate(String jsonString) {
		//TODO: implement this function
		Stack truth = new Stack();
		
		
		for(int i =0;i<jsonString.length();i++){
			if(jsonString.charAt(i)=='{'){
				truth.push(jsonString.charAt(i));
			}else if(jsonString.charAt(i)=='}'){
				if (truth.isEmpty()){
					System.out.println("No, not symmetrical");
				}
				truth.pop();
			}
		}

		if(truth.isEmpty()){
			System.out.println("YES it is symmetrical");
		}else{
			System.out.println("No, not symmetrical");
		}
	}
	
	public static String getFileContents(String fileName) {
		StringBuilder sb = new StringBuilder();
		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		while(s.hasNext()) {
			sb.append(s.nextLine());
		}
		s.close();
		return sb.toString();
	}
	
	public static void main(String args[]) {
		String jsonFileName = "data/data004.json";
		String jsonString = getFileContents(jsonFileName);
	
		validate(jsonString);
	}
}
