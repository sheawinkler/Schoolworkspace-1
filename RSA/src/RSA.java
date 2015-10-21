import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class RSA {
	static String parseN;
	static String parseA;
	
	public static List<String>  fileReader(String fileName) throws FileNotFoundException{
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
		List<String> ciphert = new ArrayList<String>();
		while(scan.hasNextLine()){
			ciphert.add(scan.nextLine());
	
		
		}
		scan.close();
		return ciphert;
	}

	
	
	
	
	public List<String>  cipherDecrypt(List<String> cipher){
		List decrypedList = new ArrayList<String>();
	
		
		return decrypedList;
	}
	
	private static BigInteger getPhi(BigInteger[] factors){
		BigInteger fact1 = factors[0].subtract(BigInteger.ONE);
		BigInteger fact2 = factors[1].subtract(BigInteger.ONE);
		BigInteger phi = fact1.multiply(fact2);
		return phi;
	}
	
	public static BigInteger Inverse(BigInteger a, BigInteger b){
		
		BigInteger temp = BigInteger.ZERO;
		BigInteger a0 = a;
		BigInteger b0 = b;
		BigInteger t0 = BigInteger.ZERO;
		BigInteger t = BigInteger.ONE;
		BigInteger s0 = BigInteger.ONE;
		BigInteger s = BigInteger.ZERO;

		BigInteger q = a0.divide(b0);
		BigInteger temp2 = q.multiply(b);
		BigInteger r = a0.subtract(temp2);

		while (r.compareTo(BigInteger.ZERO) == 1) {
			temp = t0.subtract(q.multiply(t));
			t0 = t;
			t = temp;
			temp = s0.subtract(q.multiply(s));
			s0 = s;
			s = temp;
			a0 = b0;
			b0 = r;
			q = a0.divide(b0);
			r = a0.subtract(q.multiply(b0));
		}

		return s;
	}
	
	public static BigInteger computingB(BigInteger a, BigInteger phi){
		BigInteger inverseOfA = Inverse(a, phi);
		if (inverseOfA.compareTo(BigInteger.ZERO) == -1){
			inverseOfA = phi.add(inverseOfA);
		}
		BigInteger b = inverseOfA.mod(phi);
		return b;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("The system is loading the data");
		List<String> ciphertext = fileReader("libs/cipher001.txt");
		
		BigInteger bigN = new BigInteger(parseN);
		AssistFunctions help = new AssistFunctions();
		BigInteger[] factors = help.fermat(bigN);
		BigInteger phi = getPhi(factors);
		BigInteger parseABig = new BigInteger(parseA); 
		BigInteger b = computingB(parseABig,phi);
		System.out.println("The factors are: "+ factors[0]+" and "+factors[1]);
		System.out.println("Phi is: "+ phi);
	}

}
