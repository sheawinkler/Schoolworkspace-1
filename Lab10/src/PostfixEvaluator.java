import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author knobel
 */
public class PostfixEvaluator {

    /**
     * Constructor
     */
    public PostfixEvaluator() {
        
    }

    /**
     *
     * @param value
     * @return true if the input String is an operator
     */
    private boolean isOperator(String value){
        return value.compareTo("+")==0 || value.compareTo("-")==0 || value.compareTo("*")==0 || value.compareTo("/")==0 ;
    }

    /**
     * Evaluates the given arithmetic expression in postfix format
     * change this method
     * @param expression
     * @return
     */
    private double evaluateExpression(String expression) {
    	String temp;
       	Stack<String> lifo = new Stack<String>();
       	double operand1=0.00;
       	double operand2=0.00;
       	String operator="";
		Double finalAnswer;
       	
        //Extract the numerals and the operators from expression parameter
		//		(Hint: think about the split method in the String class).
		String delim[] = expression.split(" ");

    	for(int i=0; i<delim.length; i++){
    		temp = delim[i];
  
    		if(this.isOperator(temp)){
    		
    			operand2 = Double.parseDouble(lifo.pop());
    			operand1 = Double.parseDouble(lifo.pop());

    			if(temp.equals("*")){
    				finalAnswer = operand1*operand2;
    				
    			}
    			else if(temp.equals( "+")){
    				finalAnswer = operand1+operand2;
    			}
    			else if(temp.equals("-")){
    				finalAnswer = operand1-operand2;
    			}
    			else{
    				finalAnswer = operand1/operand2;
    			}
    			lifo.push(finalAnswer.toString());
    		} else{
    				lifo.push(temp);
    		}  
    	}
    	
		return Double.parseDouble(lifo.pop());
 
  

		//Use the provided algorithm and the methods provided in the java.util.Stack class to 
		//evaluate the Postfix expression.
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
        System.out.print("Please enter the Arithmatic Expression (Postfix form) to evaluate: ");
        Scanner myScanner = new Scanner(System.in);
        String expression = myScanner.nextLine();
        System.out.println("Result: " + postfixEvaluator.evaluateExpression(expression));
    }
}
