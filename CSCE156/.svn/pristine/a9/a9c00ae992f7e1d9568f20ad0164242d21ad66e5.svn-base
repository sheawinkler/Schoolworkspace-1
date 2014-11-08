package unl.cse.labs.lab03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DNA {

	public static void main(String args[]) {

		if(args.length != 1) {
			System.err.println("ERROR: expecting a single string argument");
		}
		
		String fileName = "data/H1N1nucleotide.txt";
		Scanner s = null;
		try {
			s = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String dna = "";

		while(s.hasNext()) {
			dna += s.next().trim();
		}
		s.close();

		String subsequence = args[0];

		int count = 0; 
		for(int i=0; i<dna.length()-subsequence.length(); i++) {
			boolean equal = true;
			for(int j=0; j<subsequence.length(); j++) {
				if(subsequence.charAt(j) != dna.charAt(j+i)) {
					equal = false;
				}
			}
			if(equal) {
				count++;
			}
		}
		System.out.println(subsequence + " appears " + count + " times");
		
	}
	
}
