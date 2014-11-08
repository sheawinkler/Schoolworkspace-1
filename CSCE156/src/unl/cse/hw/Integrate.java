package unl.cse.hw;

import java.util.Random;

public class Integrate {

	private static final Random r = new Random();
	
	private static double getRangedDouble(double low, double high) {
		double d = r.nextDouble();
		return low + d * Math.abs(low - high);
	}

	public static void main(String args[]) {
		
		if(args.length != 3) {
			System.err.println("Usage: a b n");
			System.exit(1);
		}

		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);

		if(a > b) {
			System.err.println("Invalid input, "+a+" > "+b+"\n");
			System.exit(1);
		}

		double A_r = 1.25 * Math.abs(b-a);
		int m = 0;
		for(int i=1; i<n; i++) {
			double x = getRangedDouble(a, b);
			double y = getRangedDouble(-0.25, 1.0);

			if(x == 0) {
				if(y >= 0) {
					m++;
			    }
			} else {
				double f = Math.sin(x) / x;
			    if( (0.0 < y) && (y < f) ) {
			    	m++;
			    } else if( (0.0 > y) && (y > f) ) {
			        m--;
			    }
			}
		}
		
		double integral = (m / (double) n) * A_r;

		System.out.println(String.format("integral(%.4f, %.4f) = %.4f\n", a, b, integral));

	}
}
