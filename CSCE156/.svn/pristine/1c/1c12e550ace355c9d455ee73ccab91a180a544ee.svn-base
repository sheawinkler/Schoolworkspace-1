package unl.cse.recursion;

public class AdaptiveQuadrature {

	public static final Double EPSILON = 0.0000001;
	private double f(double x) {
		return Math.sin(x);
	}
	
	public double trapezoid(double a, double b, int n) {
		double h = (b - a) / n;
		double sum = 0.5 * h * (f(a) + f(b));
		for(int i=1; i<n; i++) {
			sum += h * f(a + h*i);
		}
		return sum;
	}

	public double adaptiveQuadrature(double a, double b) {
		double area = trapezoid(a, b, 10);
		double check = trapezoid(a, b, 5);
		if(Math.abs(area - check) > EPSILON) {
			double m = (a + b) / 2.0;
			area = adaptiveQuadrature(a, m) + adaptiveQuadrature(m, b);
		}
		return area;
	}
	
	public static void main(String args[]) {

		AdaptiveQuadrature aq = new AdaptiveQuadrature();
		double value, true_value = .4596976941318602;
		value = aq.trapezoid(0, 1, 5);
		System.out.println("value = "+value+", error = "+(true_value - value));
		value = aq.adaptiveQuadrature(0, 1);
		System.out.println("value = "+value+", error = "+(true_value - value));
	}
}
