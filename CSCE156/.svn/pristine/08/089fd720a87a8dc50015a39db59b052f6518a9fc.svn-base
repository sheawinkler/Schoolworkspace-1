package unl.cse.efficiency;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("unused")
public class MaxSubseqSumDemo {

	/**
	 * Algorithm description:
	 * 	foreach sequence starting at i
	 *     foreach sequence ending at j
	 *       add up a_i thru a_j
	 *       if larger, update maxSum
	 * @param a
	 * @return
	 */
	public static int maxSubsequenceSum01(int a[]) {

		int maxSum = 0;
		for(int i=0; i<a.length; i++) {
			for(int j=i; j<a.length; j++) {
				int thisSum = 0;
				
				for(int k=i; k<=j; k++) {
					thisSum += a[k];
				}
				
				if(thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}

	/**
	 * Algorithm description:
	 *  foreach sequence starting at i
	 *    sum = 0
	 *    for j = i..n-1
	 *      sum += a_j
	 *      if larger, update maxSum
	 *      
	 * @param a
	 * @return
	 */
	public static int maxSubsequenceSum02(int a[]) {

		int maxSum = 0;
		
		for(int i=0; i<a.length; i++) {
			int thisSum = 0;
			
			for(int j=i; j<a.length; j++) {
				thisSum += a[j];
				if(thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
	
	/**
	 * linear solution
	 * @param a
	 * @return
	 */
	public static int maxSubsequenceSum03(int a[]) {
		int maxSum = 0;
		int thisSum = 0;
		for(int i=0, j=0; j<a.length; j++) {
			thisSum += a[j];
			if(thisSum > maxSum) {
				maxSum = thisSum;
			} 
			else if(thisSum < 0) {
				i = j + 1;
				thisSum = 0;
			}
		}
		return maxSum;
	}

	public static void main(String args[]) {

		int n = 2000;
		Random r = new Random();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = r.nextInt(n*20)-n*10;
		
		double nsPerMs = 1000000;
		long result = 0;
		long start, end;
		
		System.out.println("demonstrating for array of size n = "+n);
		
		start = System.nanoTime();
		result = maxSubsequenceSum01(arr);
		end = System.nanoTime();
		System.out.println(String.format("\tO(n^3) result: %15d %10.3fms", result, (end-start)/nsPerMs));

		start = System.nanoTime();
		result = maxSubsequenceSum02(arr);
		end = System.nanoTime();
		System.out.println(String.format("\tO(n^2) result: %15d %10.3fms", result, (end-start)/nsPerMs));

		start = System.nanoTime();
		result = maxSubsequenceSum03(arr);
		end = System.nanoTime();
		System.out.println(String.format("\tO(n)   result: %15d %10.3fms", result, (end-start)/nsPerMs));
	}
}
