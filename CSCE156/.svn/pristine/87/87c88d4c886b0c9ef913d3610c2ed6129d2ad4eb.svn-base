package unl.cse.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortingGrader {

	private static final Comparator<Integer> INTEGER_COMPARATOR = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}};

	public static <T> void insertionSort(T array[], Comparator<T> comparator) {
		int n = array.length;
		for(int i=1; i<n; i++) {
			int j = i;
			T tmp = array[i];
			while ((j > 0) && (comparator.compare(array[j-1], tmp) > 0)) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = tmp;
		}
	}
	
	private static final long nsPerMS = 1000000;
		
	private final Random r;
	private final Integer repetitions = 10;
	private static final Integer sizes[] = {10, 100, 200, 400, 1000, 10000, 20000, 50000, 100000};

	public SortingGrader() {
		this.r = new Random();
	}

	public boolean correctnessCheck() {

		int n = 100;
		Integer a[] = getRandomIntegerArray(n);
		Integer b[] = new Integer[n];
		for(int i=0; i<n; i++) {
			b[i] = a[i];
		}
		SortingGrader.insertionSort(a, INTEGER_COMPARATOR);
		Sorting.sort(b, INTEGER_COMPARATOR);
		
		boolean result = Arrays.equals(a, b);
		return result;
	}
	
	private Integer[] getRandomIntegerArray(int n) {
		Integer b[] = new Integer[n];
		for(int i=0; i<n; i++) {
			Integer x = r.nextInt(1000);
			b[i] = x;
		}
		return b;
	}
	
	private double runPerformanceExperiment(int n) {
		
		long start, end;
		long totalDuration = 0l;
		for(int i=0; i<this.repetitions; i++) {
			Integer a[] = getRandomIntegerArray(n);
			start = System.nanoTime();
			Sorting.sort(a, INTEGER_COMPARATOR);
			end = System.nanoTime();
			totalDuration += (end - start) / (double) nsPerMS;
		}
		return totalDuration / (double) this.repetitions;
	}
	
	public static void main(String args[]) {
		SortingGrader sg = new SortingGrader();
		if(!sg.correctnessCheck()) {
			System.out.println("ERROR: Sorting.sort() method failed to actually sort, not performing any further tests, quitting...");
			System.exit(1);
		} else {
			System.out.println("Sorting.sort(): SUCCESS");
		}
		
		System.out.println("Performance Tests");
		System.out.println(String.format("%10s", "n") + String.format("%10s", "Time"));
		for(Integer n : sizes) {
			double d = sg.runPerformanceExperiment(n);
			System.out.print(String.format("%10d", n));
			System.out.print(String.format("%10.2fms\n", d));
		}
		
	}
}
