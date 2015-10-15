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
	
	
		
		public String addConcat(String currChar){
			String concatReg = "";
			char concat = '.';
			
			for(int i=0;i< (currChar.length()-1);i++){
				
				if((currChar.charAt(i)=='a'|| currChar.charAt(i)== 'b')  && (currChar.charAt(i+1)=='a'|| currChar.charAt(i+1)=='b')){
					concatReg = concatReg+currChar.charAt(i)+currChar.charAt(i+1)+concat;
					i++;
				}else if(currChar.charAt(i)==')' && currChar.charAt(i+1)=='('){
					concatReg = concatReg+currChar.charAt(i)+concat;
				
				}else if(currChar.charAt(i)=='*' && (currChar.charAt(i+1)=='a'||currChar.charAt(i+1)=='b') ){
					concatReg = concatReg+currChar.charAt(i);
					concatReg = concatReg+concat;
				}else if(currChar.charAt(i)=='*' && currChar.charAt(i+1)=='('){
					concatReg = concatReg+concat;
				}else if(currChar.charAt(i) =='|' && (currChar.charAt(i+1)== 'a' || currChar.charAt(i+1)== 'b') ){
					
				}else if((currChar.charAt(i)== 'a' || currChar.charAt(i)== 'b') && (currChar.charAt(i+1)=='|')){
					
				}
				
				
			}
			return concatReg;
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
			String output_string = "";
			Queue<Character> outputQueue = new ArrayDeque<Character>();
			Stack<Character> operatorStack = new Stack<Character>();
			for(int i =0;i<infixString.length();i++){
			
				switch(infixString.charAt(i)){
					case 'a':
						   // append operand to end of PE
						outputQueue.add(infixString.charAt(i));
						break;
					case 'b':
						   // append operand to end of PE
						outputQueue.add(infixString.charAt(i));
						break;
					case '(':
						   // save ’(’ on stack
						operatorStack.push(infixString.charAt(i));
						break;
					case ')':
						 //  pop stack until matching ’(’
						while(operatorStack.size()>0 && ('(' != operatorStack.peek())){
							outputQueue.add(operatorStack.peek());
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
				   		 		 	outputQueue.add(operatorStack.peek());
				   		 		 	operatorStack.pop();
						 }
				   		 operatorStack.push(infixString.charAt(i));	//Save new char

				   		 break;
				}
				
				
			}
			while(operatorStack.size()>0){
			   	 outputQueue.add(operatorStack.peek());
			   	 operatorStack.pop();
			}
			output_string= outputQueue.toString();
			outputQueue.clear();
			//return string
			System.out.println("Here is the final output String  ");
			System.out.println("Above should be the postfix output to console   ");
			//while stack has operators..enqueue into outputQueue
			if(operatorStack.size()>0){
				System.out.println("There are still items on the stack, mismatch occurred   ");
			}
			return output_string;
		}
		
		
		
		
		
		
	
}
