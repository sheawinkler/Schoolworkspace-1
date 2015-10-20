import java.util.*;
import java.util.Map;
import java.util.HashMap;



public class InfixToPostfix {
	
	Map<Character, Integer> precedenceMap = new HashMap<Character, Integer>();
	/*
	 * Constructor
	 */
		public InfixToPostfix(){
			precedenceMap.put('(', 1);
			precedenceMap.put('|', 2);
			precedenceMap.put('.', 3);
			precedenceMap.put('*',4);
		}
	
		/**
		 * Add the '.' concat operator to the string
		 */
		public String addConcat(String currString) {
			String concatString = new String();
			List<Character> allOperators = Arrays.asList('|', '*');
			List<Character> binaryOperators = Arrays.asList('|');

			for (int i = 0; i < currString.length(); i++) {
				Character char1 = currString.charAt(i);

				if (i + 1 < currString.length()) {
					Character char2 = currString.charAt(i + 1);

					concatString += char1;

					if (!char1.equals('(') && !char2.equals(')') && !allOperators.contains(char2) && !binaryOperators.contains(char1)) {
						concatString += '.';
					}
				}
			}
			concatString += currString.charAt(currString.length() - 1);

			return concatString;
		}
		
		
		/*
		 * Returns the <int> precedence value of the input
		 *
		 */
		public int returnPrecedence(char inputChar){
			int stat = precedenceMap.get(inputChar);
			System.out.println();
			return stat;
		}

/*
 * Returns true if the current character
 * has higher precedence than the comparing
 * Need to check if EQUALITY IS ACCEPETED AS HIGHER PRECEDENCE
 */
		public boolean higherPrecedence(char inputChar, char comparingChar){
			if(returnPrecedence(inputChar)>=returnPrecedence(comparingChar)){
				return true;
			}else{
				return false;
			}
			
		}
		
		
		
		
		
		public String convertToPostfix(String infixString){
			String tmp_string="";
			
			Stack<Character> operatorStack = new Stack<Character>();
			for(int i =0;i<infixString.length();i++){
			
				switch(infixString.charAt(i)){
					case 'a':
						   // append operand to end of PE
						tmp_string = tmp_string + infixString.charAt(i);
						break;
					case 'b':
						   // append operand to end of PE
						tmp_string = tmp_string + infixString.charAt(i);
						break;
					case '(':
						   // save ’(’ on stack
						operatorStack.push(infixString.charAt(i));
						break;
					case ')':
						 //  pop stack until matching ’(’
						while(operatorStack.size()>0 && ('(' != operatorStack.peek())){
							tmp_string = tmp_string + operatorStack.peek();
							operatorStack.pop();
						}
						if(operatorStack.size()==0){
							System.out.println("Mismatched Parenthesis detected");
						}
					   //Removing contributing '(' char
						operatorStack.pop();
						break;
					default:
						   /* Add it to the stack only after we have popped off everything of higher precedence
						    * if operator is left associative, we pop operators of equal precedence
						    * if it is right associative we do not
						    * This may or may not be right.  May need to skip if ( or )
						    */
						   // process stack operators of greater precedence
						
						 while((operatorStack.size() > 0) && ('('!=operatorStack.peek()) && (higherPrecedence(operatorStack.peek(), infixString.charAt(i)))  ){
				   		 	 //If operator stack precedence is greater or equal to char
							 		tmp_string = tmp_string + operatorStack.peek();
							 		
				   		 		
				   		 		 	operatorStack.pop();
						 }
				   		 operatorStack.push(infixString.charAt(i));	//Save new char

				   		 break;
				}
				
				
			}
			while(operatorStack.size()>0){
				 tmp_string = tmp_string + operatorStack.peek();
			
			   	 operatorStack.pop();
			}
			
			//while stack has operators..enqueue into outputQueue
			if(operatorStack.size()>0){
				System.out.println("There are still items on the stack, mismatch occurred while converting to Postfix   ");
			}
			return tmp_string;
		}	
}
