import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class RSA {
	static String parseN;
	static String parseA;
	
	public static String fileReader(String fileName) throws FileNotFoundException{
		File file = new File(fileName);	
		Scanner scan = new Scanner(file);
		scan.nextLine();
		String[] parsing = scan.nextLine().split("=");
		parseN = parsing[1].trim();
		scan.nextLine();
		parsing = scan.nextLine().split(" = ");
		parseA = parsing[1].trim();
		scan.nextLine();
		scan.nextLine();
		scan.nextLine();
		String cipher = new String();
	
		while(scan.hasNextLine()){
			 cipher = cipher + scan.nextLine();
		}
		scan.close();
		return cipher;
	}

	
	
	
	
	public String cipherDecrypt(String cipher){
		
		return cipher;
	}
	
	private static BigInteger getPhi(BigInteger[] factors){
		BigInteger fact1 = factors[0].subtract(BigInteger.ONE);
		BigInteger fact2 = factors[1].subtract(BigInteger.ONE);
		BigInteger phi = fact1.multiply(fact2);
		return phi;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		String ciphertext = fileReader("libs/cipher001.txt");
		
		BigInteger bigN = new BigInteger(parseN);
		Helpers help = new Helpers();
		BigInteger[] factors = help.fermat(bigN);
		BigInteger phi = getPhi(factors);
		System.out.println("The factors are: "+ factors[0]+" and "+factors[1]);
		System.out.println("Phi is: "+ phi);
	}

}
