package unl.cse.bears;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BearGameAnswer {

	public static Integer WIN_NUMBER = 42;
	
	private static Map<Integer, Boolean> SOLUTIONS = new HashMap<Integer, Boolean>();
	private static Map<Integer, Integer> SOLUTION_COUNTS = new HashMap<Integer, Integer>();
	
	public void testWin(int numBears) {
		if(numBears < WIN_NUMBER) {
			System.out.println("Number of bears is less than winning number ("+WIN_NUMBER+"), win not possible");
		}
		if(canWin(numBears)) {
			System.out.println("A win is possible for n = "+numBears+", see above");
		} else {
			System.out.println("No win is possible");
		}
		
	}
	
	private boolean canWin(int numBears) {

		if(numBears < 42) 
			return false;
		else if(numBears == 42) {
			System.out.println("Number of bears left: "+numBears+", WIN");
			return true;
		}
		else if(numBears % 2 == 0) {
			//if numBears is even..
			//can give back n/2
			int x = numBears / 2;
			if(canWin(numBears - x)) {
				System.out.println("Number of bears left: "+numBears+", give back "+x+" bears");
				return true;
			} else {
				return false;
			}
			
		}
		else if(numBears % 3 == 0 || numBears % 4 == 0) {
			//if divisible by 3 or 4...
			//can give back x bears:
			int x = (numBears % 10) * ((numBears %100) / 10);
			if(x == 0) {
				//no valid move
				return false;
			}
			if(canWin(numBears - x)) {
				System.out.println("Number of bears left: "+numBears+", give back "+x+" bears");
				return true;
			} else {
				return false;
			}
		}
		else if(numBears % 5 == 0) {
			//if divisible by 5...
			//can give back 42 bears
			int x = 42;
			if(canWin(numBears - x)) {
				System.out.println("Number of bears left: "+numBears+", give back "+x+" bears");
				return true;
			} else {
				return false;
			}
		}
		else {
			//no valid move, lose
			return false;
		}
	}
	
	public Boolean isWinnable(int numBears) {

		if(SOLUTIONS.get(numBears) != null) {
			return SOLUTIONS.get(numBears);
		}
		
		boolean result = false;
		if(numBears < 42) {
			return false;
		} else if(numBears == 42) {
			return true;
		} else {
			if(numBears % 2 == 0) {
				int x = numBears / 2;
				result = result || isWinnable(numBears - x);
			}
			if(numBears % 3 == 0 || numBears % 4 == 0) {
				int x = (numBears % 10) * ((numBears %100) / 10);
				if(x > 0) {
					result = result || isWinnable(numBears - x);
				}
			}
			if(numBears % 5 == 0) {
				int x = 42;
				result = result || isWinnable(numBears - x);
			}
		}
		SOLUTIONS.put(numBears, result);
		return result;
	}
	
	public void printASolution(int n) {
		
	}
	
	public void printAllSolutions(int numBears) {
		Stack<String> s = new Stack<String>();
		s.push("A Solution for n = "+numBears+":");
		printAllSolutionsRec(numBears, s);
	}

	private void printSolution(Stack<String> solution) {
		for(String s : solution) {
			System.out.println(s);
		}
	}
	
	private void printAllSolutionsRec(int numBears, Stack<String> solution) {

//		System.out.println("DEBUG: n = "+numBears);
//		printSolution(solution);
		if(numBears < 42) {
			return;
		} else if(numBears == 42) {
			solution.push("\tLeaving you with 42, WIN!");
			printSolution(solution);
			solution.pop();
		} else {
			if(numBears % 2 == 0) {
				int x = numBears / 2;
				solution.push("\t"+numBears + " is even so, give back "+x+" and you are left with "+(numBears-x)+", then ");
				printAllSolutionsRec(numBears - x, solution);
				solution.pop();
			}
			if(numBears % 3 == 0 || numBears % 4 == 0) {
				int x = (numBears % 10) * ((numBears % 100) / 10);
				if(x > 0) {
					solution.push("\t"+numBears + " is divisible by 3 or 4 so, give back "+x+" and you are left with "+(numBears-x)+", then ");
					printAllSolutionsRec(numBears - x, solution);
					solution.pop();
				}
			}
			if(numBears % 5 == 0) {
				int x = 42;
				solution.push("\t"+numBears + " is divisible by 5 so, give back "+x+" and you are left with "+(numBears-x)+", then ");
				printAllSolutionsRec(numBears - x, solution);
				solution.pop();
			}
		}
	}
	
	public Integer getNumSolutions(int numBears) {
		
		if(SOLUTION_COUNTS.get(numBears) != null) {
			return SOLUTION_COUNTS.get(numBears);
		}
		
		int result = 0;
		if(numBears < 42) {
			return result;
		} else if(numBears == 42) {
			return 1;
		} else {
			if(numBears % 2 == 0) {
				int x = numBears / 2;
				result += getNumSolutions(numBears - x);
			}
			if(numBears % 3 == 0 || numBears % 4 == 0) {
				int x = (numBears % 10) * ((numBears %100) / 10);
				if(x > 0) {
					result += getNumSolutions(numBears - x);
				}
			}
			if(numBears % 5 == 0) {
				int x = 42;
				result += getNumSolutions(numBears - x);
			}
		}
		SOLUTION_COUNTS.put(numBears, result);
		return result;
	}
	
	public static void main(String args[]) {
		
		int n = 1000;
		int count = 0;
		int m = 3214512;
		BearGameAnswer bg = new BearGameAnswer();
		for(int i=1; i<=n; i++) {
			if(bg.isWinnable(i)) {
				System.out.println(String.format("%4d  %-5s  %5d", i, bg.isWinnable(i), bg.getNumSolutions(i)));
				count++;
			}
		}
		
		System.out.println("Total winnable games: "+count + " = "+String.format("%.2f", (count / (double) n) * 100));

		System.out.println(String.format("%4d  %-5s  %5d", m, bg.isWinnable(m), bg.getNumSolutions(m)));
		bg.printAllSolutions(424);
		
	}
}
