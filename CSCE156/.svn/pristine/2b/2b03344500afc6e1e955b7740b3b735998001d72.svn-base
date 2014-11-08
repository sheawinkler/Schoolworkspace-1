package unl.cse.recursion;

public class GCD {

	private int numCalls = 0;
	
	public int gcd(int p, int q) {
		numCalls++;
		if(q == 0) 
			return p;
		else
			return gcd(q, p % q);
	}
	
	public static void main(String args[]) {

		int p = 17*12*3412, q = 24*7;
		GCD g = new GCD();
		int result = g.gcd(q, p);
		System.out.println("gcd("+p+", "+q+") = "+result);
		System.out.println("numCalls = "+g.numCalls);
	}
}
