package unl.cse.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sorting {

	public static <T> void sort(T array[], Comparator<T> comparator) {
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
	
	public static void main(String args[]) {

		Comparator<Integer> comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg0.compareTo(arg1);
			}
		};
		int n = 1000;
		Random r = new Random(); 
		Integer arr[] = new Integer[n];
		for(int i=0; i<n; i++) {
			arr[i] = r.nextInt(100);
		}
		System.out.println(Arrays.toString(arr));
		sort(arr, comp);
		System.out.println(Arrays.toString(arr));
	}
}
