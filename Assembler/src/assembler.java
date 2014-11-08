import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class assembler {
	//comment case
	//space delimiter

	assembler(){
		
	}
	
	
	public int[] assemble(String newFile){
		File file = new File(newFile);
		int count = 0;
		int[] asmArray = new int[count];
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				count++;
			}
			asmArray = new int[count];
			while (scanner.hasNextLine()) {
				int index = 0;
				int word = 0;
					while(scanner.hasNext()){
						
						String s = scanner.nextLine().toLowerCase();
						String[] ss = s.split(" +");
						String switchTemp=ss[0];
					
						System.out.println(ss[0]);
						if(switchTemp=="sw"){
							word =  5;
						}else if(switchTemp=="lw"){
							word = 	4;
							
						}else if ( switchTemp=="add" |switchTemp=="sub"| switchTemp =="and"|switchTemp =="or"|switchTemp =="xor"|switchTemp =="cmp"|switchTemp=="jr"){
							
						}else if (switchTemp=="lw"|switchTemp =="sw"|switchTemp=="addi"){
							
							
						}else if (switchTemp=="b"|switchTemp=="bal"){
							
		
						}else if (switchTemp =="j"|switchTemp =="jal"){
							
							
						}else if (switchTemp==""){
							
						}
						
					}	
					asmArray[index]=word;
			}

		} catch (FileNotFoundException e) {
			// Catch Block
			e.printStackTrace();	
		}
		return asmArray;	
	}
	
	
	public String convertRegister(String registerString){
		String convertedTo = "0";
		
		if(registerString=="r1"){
			convertedTo = "1";
		}else if(registerString=="r2"){
			convertedTo = "2";
		}else if(registerString=="r3"){
			convertedTo = "3";
		}else if(registerString=="r4"){
			convertedTo = "4";
		}else if(registerString=="r5"){
			convertedTo = "4";
		}
		return  convertedTo;
	}
	
	
	
	public static void main(String args[]){
		
		String test = "data/fileName";
		  
		
		assembler asm = new assembler();
		asm.assemble(test);
	}
}
