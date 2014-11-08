package unl.cse.sorting;

import java.util.Random;

public class SortingUtils {

	private static int MERGE_HELPER[];
	
	/**
	 * Returns true if the given array is sorted in non-decreasing order and false otherwise.
	 * @param array
	 * @return
	 */
	public static boolean isSorted(int array[]) {
		for(int i=0; i<array.length-1; i++) {
			if(array[i] > array[i+1])
				return false;
		}
		return true;
	}
	
	public static void bubbleSort(int array[])
	{
		int n = array.length;
		int temp = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < (n-i); j++) {
				if(array[j-1] > array[j]) {
			        temp = array[j-1];
			        array[j-1]=array[j];
			        array[j]=temp;
				}
			}
		}
	}

	public static void selectionSort(int array[]) {
		int n = array.length;
		for(int i=0; i<n; i++){
			int index_of_min = i;
		    for(int j=i; j<n; j++){
		      if(array[index_of_min] > array[j]){
		        index_of_min = j;
		      }
		    }
		    int temp = array[i];
		    array[i] = array[index_of_min];
		    array[index_of_min] = temp;
		}
	}
	
	public static void insertionSort(int array[]) {
		  int value;
		  for(int i=1; i<array.length; i++) {
		    value = array[i];
		    int j = i;
		    while(j > 0 && array[j-1] > value) {
		      array[j] = array[j-1];
		      j--;
		    }
		    array[j] = value;
		  }
	}
	
	public static void quickSort(int a[]) {
		quickSort(a, 0, a.length-1);
	}

	private static void quickSort(int a[], int left, int right) {
		  int index = partition(a, left, right);
		  if (left < index - 1)
		    quickSort(a, left, index - 1);
		  if (index < right)
		    quickSort(a, index, right);
	}
	
	private static int partition(int a[], int left, int right)
	{
	  int i = left, j = right;
	  int tmp;
	  int pivot = a[(left + right) / 2];
	     
	  while (i <= j) {
	    while (a[i] < pivot)
	      i++;
	    while (a[j] > pivot)
	      j--;
	      if (i <= j) {
	        tmp = a[i];
	        a[i] = a[j];
	        a[j] = tmp;
	        i++;
	        j--;
	      }
	  }
	  return i;
	}
	
	public static void mergeSort(int a[]) {
		/*
		 * Sorting is IO bound; declaring a new "helper" array for each merge call would eclipse the
		 * speedup provided by mergesort, so we declare it once and reuse it
		 */
		MERGE_HELPER = new int[a.length];
		mergeSort(a, 0, a.length-1);
	}
	
	private static void mergeSort(int a[], int low, int high)
	{
	  if (low < high) {
	    int middle = (low + high) / 2;
	    mergeSort(a, low, middle);
	    mergeSort(a, middle + 1, high);
	    merge(a, low, middle, high);
	  }
	}
	
	private static void merge(int a[], int low, int middle, int high) {

		  // Copy both parts into the helper array
		  for (int i = low; i <= high; i++) {
		    MERGE_HELPER[i] = a[i];
		  }
		  int i = low;
		  int j = middle + 1;
		  int k = low;
		  //Copy the smallest values from the left or the right side back to the original array
		  while (i <= middle && j <= high) {
		    if (MERGE_HELPER[i] <= MERGE_HELPER[j]) {
		      a[k] = MERGE_HELPER[i];
		      i++;
		    } else {
		      a[k] = MERGE_HELPER[j];
		      j++;
		    }
		    k++;
		  }
		  // Copy the rest of the left side of the array into the target array
		  while (i <= middle) {
		    a[k] = MERGE_HELPER[i];
		    k++;
		    i++;
		  }
	}

	public static int[] getRandomIntegerArray(int n) {
		Random r = new Random();
		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = r.nextInt(100);
		}
		return a;
	}

}
