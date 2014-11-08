package unl.cse.sorting;

import java.util.Arrays;

public class SortDemo {

	public static double sPerNS = 1000000000;
	
	public static void main(String args[]) {
		int n = 10000;
		int a[] = SortingUtils.getRandomIntegerArray(n);
		int b[] = null;
		
		System.out.println("a = "+Arrays.toString(a));
		System.out.println("n = "+a.length);
		
		long start, end;
		
		b = Arrays.copyOf(a, a.length);
		start = System.nanoTime();
		SortingUtils.bubbleSort(b);
		end = System.nanoTime();
		System.out.println("BubbleSort,    time = "+ String.format("%.3f", ( (end-start) / sPerNS )) + "s");
		
		b = Arrays.copyOf(a, a.length);
		start = System.nanoTime();
		SortingUtils.selectionSort(b);
		end = System.nanoTime();
		System.out.println("SelectionSort, time = "+ String.format("%.3f", ( (end-start) / sPerNS )) + "s");

		b = Arrays.copyOf(a, a.length);
		start = System.nanoTime();
		SortingUtils.insertionSort(b);
		end = System.nanoTime();
		System.out.println("InsertionSort, time = "+ String.format("%.3f", ( (end-start) / sPerNS )) + "s");

		b = Arrays.copyOf(a, a.length);
		start = System.nanoTime();
		SortingUtils.quickSort(b);
		end = System.nanoTime();
		System.out.println("QuickSort,     time = "+ String.format("%.3f", ( (end-start) / sPerNS )) + "s");

		b = Arrays.copyOf(a, a.length);
		start = System.nanoTime();
		SortingUtils.mergeSort(b);
		end = System.nanoTime();
		System.out.println("MergeSort,     time = "+ String.format("%.3f", ( (end-start) / sPerNS )) + "s");


	}

}
