package unl.cse.hw;

public class SquareRoot {

	public static void main(String args[]) {
		
		if(args.length != 2) {
			System.err.println("Usage: x n");
			System.exit(1);
		}
		
		double x = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		double sqrtX = Math.sqrt(x);

		double x_n = 1.0;

		System.out.println(String.format("%3s %12s %12s %12s", "i", "a_i", "delta", "error"));

		for(int i=1; i<n; i++) {
			double tmp = 0.5 * (x_n + x / x_n);
			System.out.println(String.format("%3d %12.4f %12.4f %12.4f", i, tmp, Math.abs(tmp-x_n), Math.abs(tmp-sqrtX)));
			x_n = tmp;
		}


	}
}
