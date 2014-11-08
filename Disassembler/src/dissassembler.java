import java.io.*;
import java.math.*;

public class dissassembler {
	 	//set character string
	public static String addressConvert(char x){
		String converted = "0000";
		char toBe = x;
        switch (toBe) {
        	case 	'0':	converted = "0000";			break;
        	case 	'1':  	converted = "0001";     	break;
            case 	'2':  	converted = "0010";     	break;
            case 	'3':  	converted = "0011";		   	break;
            case 	'4':  	converted = "0100";      	break;
            case 	'5':	converted = "0101";			break;
            case 	'6':  	converted = "0110";			break;
            case 	'7':  	converted = "0111";			break;
            case 	'8':  	converted = "1000";        	break;
            case 	'9':  	converted = "1001";    		break;
            case 	'A': 	converted = "1010";       	break;
            case 	'B': 	converted = "1011";			break;
            case 	'C': 	converted = "1100";     	break;
            case	'D': 	converted = "1101"; 		break;
            case	'E': 	converted = "1110";			break;
            case	'F': 	converted = "1111";			break;
        }
		return converted;
	}
	
	public static void lTypeInstruction(String x){
		
	}
	
	public static void typeRegister(String x){
		String toBe = x;
		if(toBe.charAt(0) == '0')
		{
			if(toBe.charAt(1) == '0')
			{
				if(toBe.charAt(2) == '0')
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("$t0 ");
					}
					else
					{
						System.out.print("$t1 ");
					}
				}
				else
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("$t2 ");
					}
					else
					{
						System.out.print("$t3 ");
					}
					
				}
			}
			else
			{
				if(toBe.charAt(2) == '0')
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("$s0 ");
					}
					else
					{
						System.out.print("$s1 ");
					}
				}
				else
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("$s2 ");
					}
					else
					{
						System.out.print("$s3 ");
					}
					
				}	
			}
		}
		else
		{
			if(toBe.charAt(1) == '0')
			{
				if(toBe.charAt(2) == '0')
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("$a0 ");
					}
					else
					{
						System.out.print("$a1 ");
					}
				}
				else
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("$v0 ");
					}
					else
					{
						System.out.print("$SP ");
					}
					
				}
			}
			else
			{
				if(toBe.charAt(2) == '0')
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("$IOA ");
					}
					else
					{
						System.out.print("$IOB ");
					}
				}
				else
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("$MAR ");
					}
					else
					{
						System.out.print("$S ");
					}
					
				}	
			}
		}
	}
	
	public static void rTypeInstruction(String x){
		String toBe = x;
		if(toBe.charAt(0) == '0')
		{
			if(toBe.charAt(1) == '0')
			{
				if(toBe.charAt(2) == '0')
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("addf ");
					}
					else
					{
						System.out.print("addfc ");
					}
				}
				else
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("subf ");
					}
					else
					{
						System.out.print("subfc ");
					}
					
				}
			}
			else
			{
				if(toBe.charAt(2) == '0')
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("testf ");
					}
					else
					{
						System.out.print("testfc ");
					}
				}
				else
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print(" ");
					}
					else
					{
						System.out.print("andf ");
					}
					
				}	
			}
		}
		else
		{
			if(toBe.charAt(1) == '0')
			{
				if(toBe.charAt(2) == '0')
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("orf ");
					}
					else
					{
						System.out.print("xorf ");
					}
				}
				else
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("movfw ");
					}
					else
					{
						System.out.print("movf ");
					}
					
				}
			}
			else
			{
				if(toBe.charAt(2) == '0')
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("clrf ");
					}
					else
					{
						System.out.print("clrw ");
					}
				}
				else
				{
					if(toBe.charAt(3) == '0')
					{
						System.out.print("rlf ");
					}
					else
					{
						System.out.print("rrf ");
					}
					
				}	
			}
		}
	}

	
	public String convertLType(String x){
		String toBe = x;
		String numberArray[]= new  String[toBe.length()];
		String numberFlipped ="";
		int finalNumber =0;
		String binaryNumber= "";
		
		
		for(int i=4; i < toBe.length(); i++){
			numberArray[i]= Character.toString(toBe.charAt(i));
		}
		
		for(int i=4; i<toBe.length(); i++){
			
			if(numberArray[i].equals("0")){
				numberArray[i] = "1";
			}else{
				numberArray[i] = "0";
			}
		}	
		for (int j =0; j< numberArray.length; j++){
			numberFlipped += numberArray[j];
		}
		for (int k=0; k< numberFlipped.length(); k++){
			finalNumber+= (int)numberFlipped.charAt(k)*Math.pow(2,8-k);
		}
		finalNumber = finalNumber+1;
		binaryNumber = Integer.toBinaryString(finalNumber);
		System.out.println(binaryNumber);
		return binaryNumber;
	}
	
	
	public static void main(String args[])
	 {
		String number = "001100110101";
		System.out.println(number);
		dissassembler trial = new dissassembler();
		trial.convertLType(number);
	      /*try{
	    FileInputStream fstream = new FileInputStream("slow_multiply.mif");
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String strLine;
	    while ((strLine = br.readLine()) != null)   {
	    	String delims = "[ ;:\t-]+";
	    	String []splits = strLine.split(delims);
	    		if(splits[0].length() < 3 && splits[0].length() != 0)
	    		{
	    		if(splits[1].charAt(0) == '0' && splits[1].charAt(1) == '0' && splits[1].charAt(2) == '0' && splits[1].charAt(3) == '0')
	    		{
	    			
	    			String instr = Character.toString(splits[1].charAt(4)) + Character.toString(splits[1].charAt(5)) + Character.toString(splits[1].charAt(6)) +Character.toString(splits[1].charAt(7));
		    		rTypeInstruction(instr);
		    		String reg = Character.toString(splits[1].charAt(8)) + Character.toString(splits[1].charAt(9)) + Character.toString(splits[1].charAt(10)) +Character.toString(splits[1].charAt(11));
	    			typeRegister(reg);
	    		}
	    		else if(splits[1].charAt(0) == '0' && (splits[1].charAt(1) == '1' || splits[1].charAt(2) == '1' || splits[1].charAt(3) == '1'))
	    		{
	    			System.out.print("L-Type ");
	    			
	    		}
	    		else if(splits[1].charAt(0) == '1')
	    		{
	    			System.out.print("J-Type ");
	    		}
	    		System.out.println (splits[1]);
	    		}
	    		}
	    in.close();
	    }catch (Exception e){//Catch exception if any
	      
	    	System.err.println("Error: " + e.getMessage());
	    }*/
	  }
}
