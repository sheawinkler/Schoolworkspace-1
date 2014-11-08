import java.util.Stack;
import java.io.*;
import java.util.*;

public class teddybearGame {

	//Boolean Function which determines whether the input value is able to reach 42
	private static boolean isWinner(int n, Stack<Integer> moves)
	{
		//precondition: Value of n greater than equal to 42
		//postcondition: return true
		if (n == 42)
		{
			return true;
		}
		
		//precondition: Value of n greater than equal to 42
		//postcondition: return true
		if (n > 42)
		{
			if((n % 2 == 0))
			{

				if(isWinner(n/2, moves))
				{
					moves.push(n/2);
					return true;
				}

			}
			
			//precondition: Value of n is divisible by 3 or 4
			//postcondition: return true
			if ((n % 3 == 0 || n % 4 == 0))
			{
			
				int nLastDigit = n % 10;
				int nSecondToLastDigit = (n % 100) / 10;

				
			// If one of the digits is 0, then we change the solution to false.
				if (!(nLastDigit == 0 || nSecondToLastDigit == 0))
				{
					if(isWinner(n - (nLastDigit * nSecondToLastDigit), moves))
					{
					moves.push(nLastDigit * nSecondToLastDigit);
					return true;
					}
				}
			}
			//precondition: n must be divisible by 5
			//postcondition: return true.
			if ((n % 5 == 0))
			{
				if(isWinner(n-42, moves))
				{
				moves.push(42);
				return true;
				}
			}
		}
		return false;
	}
		

	public void loop(){
    	int n;
    	Stack<Integer> moves = new Stack<Integer>();
    	int total = 0;
    	//initialization of counter to loop through n
    	for (n=40; n<=300; n++)
    	{
    		//precondition: Value of n exist
    		//postcondition: return output
    		if(isWinner(n, moves))
    		{
    			total++;
    			System.out.println("For number " + n + ".  WE HAVE A WINNER LADIES AND GENTLEMEN!!!!!!");
    			if(n==42){
    				System.out.println("Give back zero, User has 42 bears");
    			}
    			while(!moves.empty())
    			{
    				System.out.println("Give Back "+moves.pop()); 
    			}
    			System.out.println("\n");
    		}
    		else
    		{
    			System.out.println("For number " + n + ".  Not So Much.  Sorry"+ "\n");
    		}
    	}
    	System.out.println("The total number the user can win from 40 to 300: "+total);
	}
	
	
	public void readFile(){
		/*try{
			File file = new File("TeddyBears-sample.csv");
			Scanner original = new Scanner(file);
			
			while(original.hasNextLine()){
				int n = Integer.parseInt(original.nextLine());
		    
		    	Stack<Integer> moves = new Stack<Integer>();
		    	//precondition: Value of n exist
	    		//postcondition: return output
	    		if(isWinner(n, moves))
	    		{
	    		
	    			System.out.println("For number " + n + ".  WE HAVE A WINNER LADIES AND GENTLEMEN!!!!!!");
	    			if(n==42){
	    				System.out.println("Give back zero, User has 42 bears");
	    			}
	    			while(!moves.empty())
	    			{
	    				System.out.println("Give Back "+moves.pop()); 
	    			}
	    			System.out.println("\n");
	    		}
	    		else
	    		{
	    			System.out.println("For number " + n + ".  Not So Much.  Sorry"+ "\n");
	    		}
				System.out.println(original);
			}
	
		}catch(FileNotFoundException e){
			e.getMessage();
		}*/
	}
	    public static void main(String[] args) {
	    	teddybearGame teddy = new teddybearGame();
	    	teddy.loop();
	    	//teddy.readFile();
	    	System.exit(0);
	    }
}
