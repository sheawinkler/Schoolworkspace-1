package unl.cse.recursion;

import java.math.BigInteger;

public class Factorial {

	/**
	 * This is a non-recursive method to compute the factorial
	 * @param n
	 * @return
	 */
	public int factorial_nonrec(int n) {
		int f = 1;
		for(int i=2; i<=n; i++)
			f *= i;
		return f;
	}

	/**
	 * This is a recursive method to compute the factorial
	 */
	public int factorial(int n) {
		if(n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}
	
	/**
	 * This version uses Java's BigInteger, an arbitrary precision
	 * integer class implementation.  It calls the tail-recursive version
	 * of factorial (see {@link #factorial_tail(int, BigInteger)}).
	 * @param n
	 * @return
	 */
	public BigInteger factorial_tail(int n) {
		return this.factorial_tail(n, BigInteger.ONE);
	}

	/**
	 * A tail-recursive version of the factorial method--the method has
	 * no local state, instead the state is carried through the function
	 * arguments, minimizing the impact to the program stack.
	 * @param n
	 * @param f
	 * @return
	 */
	private BigInteger factorial_tail(int n, BigInteger f) {
		if(n == 1)
			return f;
		else
			return factorial_tail(n-1, f.multiply(BigInteger.valueOf(((long) n))));
	}
	
	public static void main(String args[]) {
		int n = 100;
		Factorial fac = new Factorial();
		long start, end;
		start = System.nanoTime();
		int f1 = fac.factorial(n);
		end = System.nanoTime();
		System.out.println("factorial("+n+") = "+f1+", time = "+(end-start)+"ns");
		
		start = System.nanoTime();
		BigInteger f2 = fac.factorial_tail(n);
		end = System.nanoTime();
		System.out.println("factorial("+n+") = "+f2+", time = "+(end-start)+"ns");

		start = System.nanoTime();
		int f3 = fac.factorial_nonrec(n);
		end = System.nanoTime();
		System.out.println("factorial("+n+") = "+f3+", time = "+(end-start)+"ns");

	}
}
