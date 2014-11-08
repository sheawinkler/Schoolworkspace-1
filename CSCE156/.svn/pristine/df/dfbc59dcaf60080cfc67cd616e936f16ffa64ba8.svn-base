package unl.cse.labs.lab01;

public class StatisticsCLI {

	public static void main(String args[]) {

		if(args.length < 2) {
			System.out.println("Error: invalid number of command line arguments, should be at least 2");
			System.exit(1);
		}

		int array[] = new int[args.length];
		
		for(int i=0; i<array.length; i++) {
			array[i] = Integer.parseInt(args[i]);
		}
		
		int min = Statistics.getMin(array);
		int max = Statistics.getMax(array);
		int sum = Statistics.getSum(array);
		double ave = Statistics.getAverage(array);
		
		System.out.println("The sum is " + sum);
		System.out.println("The average is " + ave);
		System.out.println("The highest is " + max);
		System.out.println("The lowest is " + min);

	}
}
