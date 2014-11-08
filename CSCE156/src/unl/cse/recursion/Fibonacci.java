package unl.cse.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	
	protected Map<Integer, Integer> callCount = new HashMap<Integer, Integer>();
	
	private final Map<Integer, Integer> memoizationTable = new HashMap<Integer, Integer>();
	
	/**
	 * Uses a memoization table (tableau) to avoid repeated calls to the same function on the same value.
	 * Instead, the value is looked up in the table first; only if its unavailable do we make the recusive
	 * call to compute it.  Once computed, its added to the table.
	 * @param n
	 * @return
	 */
	public int recursiveFibonacciWithMemoization(int n) {
		
		//callCount demonstration
		if(callCount.get(n) == null) {
			callCount.put(n, 0);
		}
		callCount.put(n, callCount.get(n)+1);
		
		if(memoizationTable.get(n) == null) {
			if(n == 0) {
				memoizationTable.put(0, 0);
				return 0;
			} else if (n == 1) {
				memoizationTable.put(1, 1);
				return 1;
			} else {
				int fn = recursiveFibonacciWithMemoization(n-1) + recursiveFibonacciWithMemoization(n-2);
				memoizationTable.put(n, fn);
				return fn;
			}
		} else {
			return memoizationTable.get(n);
		}
	}

	public int recursiveFibonacci(int n) {
		if(n == 0) 
			return 0;
		else if(n == 1) 
			return 1;
		else
			return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
	}
	
	public int illustratedRecursiveFibonacci(int n, int depth) {

		if(depth == 0) {
			callCount = new HashMap<Integer, Integer>();
		}
		Integer count = callCount.get(n);
		count = (count == null) ? 1 : count + 1;
		callCount.put(n, count);
		
		for(int i=0; i<depth; i++)
			System.out.print("   ");
		System.out.println("fib("+n+")");

		if(n == 0) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else
			return illustratedRecursiveFibonacci(n-1, depth+1) + illustratedRecursiveFibonacci(n-2, depth+1);
	}

	public int nonrecursiveFibonacci(int n) {
		if(n == 0) 
			return 0;
		else if(n == 1) 
			return 1;
		else {
			int a = 0, b = 1;
			int i = 1;
			while(i < n) {
				int c = a + b;
				a = b;
				b = c;
				i++;
			}
			return b;
		}
		
	}
	
	public static void main(String args[]) {
		
		Fibonacci f = new Fibonacci();
		int fib;
		int n = 20;
		fib = f.recursiveFibonacci(n);
		System.out.println("Fibonacci("+n+") = " + fib);
		fib = f.nonrecursiveFibonacci(n);
		System.out.println("Fibonacci("+n+") = " + fib);
		fib = f.illustratedRecursiveFibonacci(n, 0);
		System.out.println("Fibonacci("+n+") = " + fib);
		System.out.println("Number of calls: ");
		for(int i=0; i<=n; i++) {
			System.out.println("fibonacci("+i+") = "+f.callCount.get(i));
		}
		
		f.callCount.clear();
		fib = f.recursiveFibonacciWithMemoization(n);
		System.out.println("Fibonacci("+n+") = " + fib);
		System.out.println("Number of calls using memoization: ");
		for(int i=0; i<=n; i++) {
			System.out.println("fibonacci("+i+") = "+f.callCount.get(i));
		}
		System.out.println(f.memoizationTable);
	}
}
