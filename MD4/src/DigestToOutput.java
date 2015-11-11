import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Scanner;


public class DigestToOutput {
	

	

	public int F(int X, int Y, int Z){
		return X&Y|(~X)&Z ;
	}

	public int G(int X, int Y, int Z){
		
		return X&Y|X&Z|Y&Z;
	}
	
	public int H(int X, int Y, int Z){
		return X^Y^Z;
	}
	
	public int roundOne(int a, int b, int c, int d, int Xk, int s){
		a = (a+F(b,c,d)+Xk)<<s;
		return a;
	}

	public int roundTwo(int a, int b, int c, int d, int Xk, int s){
		a = (a+G(b,c,d)+Xk+0x5A827999)<<s;
		return a;
	}
	
	public int roundThree(int a, int b, int c, int d, int Xk, int s){
		a = (a+H(b,c,d)+Xk+0x6ED9EBA1)<<s;
		return a;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		// Start Up Menu
		System.out.println("Hello My Friend, we are going to run the MD4 System now, please supply the absolute path to file to digest:");		
		
		//Snatch data from cmdLine
//		Scanner scanner = new Scanner(System.in);
//		String md4FileString = scanner.next();
//		scanner.close();
		/*
		 * Delete for commandline--Remove comments from three lines above
		 */
		String md4FileString = "/Users/Deverick/Documents/workspace/MD4/lib/input.txt";
		//Create a quick file
		File	md4File = new File( md4FileString );
		
		//Scan it 
		Scanner fileScanner = null;
    	try{
    		fileScanner = new Scanner(md4File);
    	}catch(FileNotFoundException t){
    		t.printStackTrace();
    	}
    
    	String contains = new String();
    	while(fileScanner.hasNextLine()){
    		contains = contains.concat(fileScanner.nextLine());
    	}
    	//Possibly I may need to insert the 0 that is getting excluded at the beginning of the bit   
    	
    	String binary = new BigInteger(contains.getBytes()).toString(2);
    	if(binary.length()%8!=0){
    		binary= "0"+binary;
    	}
    	// Grab a copy to append in step 2. must make 64 bit..
    	String pre = binary;
    	
    	//Can deletethis
    	System.out.println("As binary: "+binary);
    	String text2 = new String(new BigInteger(binary, 2).toByteArray());
    	System.out.println("As text again: "+text2);
 
    	//Moving to Step 2  Append Padding Bits
    	binary =  binary.concat("1");

    	//Append the padding bits
    	while(binary.length()%512 != 448){
    		binary = binary.concat("0");
    	}
    	
    	System.out.println("As binary after padding bits: "+binary);
    	System.out.println("Binary Length after adding padding: "+binary.length());
 
    	//Moving to Step 2, Extend to 64Bit,  Append Length
    	while(pre.length()%64 !=0){
    		pre = "0".concat(pre);
    	}
    	System.out.println(pre.toString().length());
    	String message = binary+pre;
    	//System.out.println(message);
    	
    	//Step three: Initialize buffer
    	int hexA = 0x01234567;
    	int hexB = 0x89abcdef;
    	int hexC = 0xfedcba98;
    	int hexD = 0x76543210;
    	
    	
 
    	
    	
    	Byte[] XBlock = new Byte[16];
    	for(int i =0; i < message.length(); i+=16){
    		for(int j = 0; j< 15;j++){
    			XBlock[j]=(byte) message.charAt(i*16+j);
    		}	
    		
    		
    		int hexAA = hexA;
    		int hexBB = hexB;
    		int hexCC = hexC;
    		int hexDD = hexD;
    		
    		int a;
    		
    		
            hexA = hexA + hexAA;
            hexB = hexB + hexBB;
            hexC = hexC + hexCC;
            hexD = hexD + hexDD;
    	}
	}
}
