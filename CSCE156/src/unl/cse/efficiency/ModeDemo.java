package unl.cse.efficiency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class ModeDemo {

	/**
	 * Quadratic mode-finding algorithm
	 * @param arr
	 * @return
	 */
	public static int mode01(int arr[]) {

		int maxCount = 0;
		int modeIndex = 0;
		for(int i=0; i<arr.length; i++) {
			int count = 0;
			int candidate = arr[i];
			for(int j=0; j<arr.length; j++) {
				if(arr[j] == candidate) {
					count++;
				}
			}
			if(count > maxCount) {
				modeIndex = i;
				maxCount = count;
			}
		}
		return arr[modeIndex];
	}

	/**
	 * "Linear" mode-finding algorithm that preprocesses the array by sorting it
	 * @param arr
	 * @return
	 */
	public static int mode02(int arr[]) {
		Arrays.sort(arr);
		int i=0; 
		int modeIndex = 0;
		int maxCount = 0;
		while(i < arr.length-1) {
			int count=0;
			while(i < arr.length-1 && arr[i] == arr[i+1]) {
				count++;
				i++;
			}
			if(count > maxCount) {
				modeIndex = i;
				maxCount = count;
			}
			i++;
		}
		return arr[modeIndex];
	}
	
	/**
	 * A map-based ("linear") mode finding algorithm
	 * @param arr
	 * @return
	 */
	public static int mode03(int arr[]) {
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length; i++) {
			Integer count = counts.get(arr[i]);
			if(count == null) count = 0;
			count++;
			counts.put(arr[i], count);
		}
		int maxCount = 0;
		int mode = 0;
		for(Entry<Integer, Integer> e : counts.entrySet()) {
			if(e.getValue() > maxCount) {
				maxCount = e.getValue();
				mode = e.getKey();
			}
		}
		return mode;
	}
	
	public static void main(String args[]) {

		int n = 100;
		Random r = new Random();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = r.nextInt(n*10);
		
		double nsPerMs = 1000000;
		long result = 0;
		long start, end;
		
		System.out.println("n = "+n);
			
		System.out.println("Note: results may vary if the array is multi-modal, each method is only guaranteed to return *a* mode.");

			start = System.nanoTime();
			result = mode01(arr);
			end = System.nanoTime();
			System.out.println(String.format("  O(n^2) \tresult: %15d %10.3fms", result, (end-start)/nsPerMs));
	
			start = System.nanoTime();
			result = mode03(arr);
			end = System.nanoTime();
			System.out.println(String.format("  Map-based\tresult: %15d %10.3fms", result, (end-start)/nsPerMs));
	
			start = System.nanoTime();
			result = mode02(arr);
			end = System.nanoTime();
			System.out.println(String.format("  Sort-based\tresult: %15d %10.3fms", result, (end-start)/nsPerMs));
	}

}
