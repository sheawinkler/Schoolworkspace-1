package unl.cse.labs.lab02;

public class Natural {

	public static void main(String args[]) {
		if(args.length != 1) {
			System.err.println("ERROR: expecting a single integer argument");
			System.exit(1);
		}
		
		Integer n = null;
		try {
			n = Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			System.err.println("ERROR: expecting a single integer argument");
			System.exit(1);
		}
		
		String zeroToTen[] = new String[11];
		zeroToTen[0] = "zero";
		zeroToTen[1] = "one";
		zeroToTen[2] = "two";
		zeroToTen[3] = "three";
		zeroToTen[4] = "four";
		zeroToTen[5] = "five";
		zeroToTen[6] = "six";
		zeroToTen[7] = "seven";
		zeroToTen[8] = "eight";
		zeroToTen[9] = "nine";
		zeroToTen[10] = "ten";
		
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		System.out.println("sum of 1.."+n+" is "+sum);
		
		sum = 0;
		int i = 1;
		while(i<=n) {
			sum += i;
			i++;
		}
		System.out.println("sum of 1.."+n+" is "+sum);
		
		String result = "";
		for(String s : zeroToTen) {
			result += s + " "; 
		}
		System.out.println(result);
	}
}
