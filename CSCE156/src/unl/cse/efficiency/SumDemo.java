package unl.cse.efficiency;

public class SumDemo {

	public static long sum01(long n) {
		return n * (n + 1) / 2;
	}
	
	public static long sum02(long n) {
		long sum = 0;
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static long sum03(long n) {
		long sum = 0;
		for(int i=1; i<=n; i++) {
			for(int j = 1; j<=i; j++) {
				sum++;
			}
		}
		return sum;
	}
	
	public static void main(String args[]) {
		
		double nsPerMs = 1000000;
		long result = 0;
		long start, end;
		
		for(int n=10; n<10000000; n*=10) {
			
			System.out.println("n = "+n);

			start = System.nanoTime();
			result = sum01(n);
			end = System.nanoTime();
			System.out.println(String.format("\tO(1)   result: %15d %10.3fms", result, (end-start)/nsPerMs));
	
			start = System.nanoTime();
			result = sum02(n);
			end = System.nanoTime();
			System.out.println(String.format("\tO(n)   result: %15d %10.3fms", result, (end-start)/nsPerMs));
	
			start = System.nanoTime();
			result = sum03(n);
			end = System.nanoTime();
			System.out.println(String.format("\tO(n^2) result: %15d %10.3fms", result, (end-start)/nsPerMs));
		}
		
		
	}
}
