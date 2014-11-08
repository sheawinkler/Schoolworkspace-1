package unl.cse.recursion;

public class Binomials {

	public long binomial(long n, long r) {
		if(r==0 || r == n) {
			return 1;
		} else {
			return binomial(n - 1, r) + binomial(n - 1, r - 1);
		}
	}
	
	public static void main(String args[]){
		long n = 35, r = 15;
		Binomials b = new Binomials();
		long bin = b.binomial(n, r);
		System.out.println("binomial("+n+", "+r+") = "+bin);
	}
}
