package unl.cse.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableSort implements Callable<Object[]> {

	private final Object[] list;
	private final int low;
	private final int high;
	private final Comparator c;
	
	public CallableSort(Object[] list, int low, int high, Comparator c) {
		this.list = list;
		this.low = low;
		this.high = high;
		this.c = c;
	}
	
	@Override
	public Object[] call() throws Exception {
		
		for(int i=low; i<high; i++) {
			int j = i;
			Object tmp = list[i];
			while ((j > low) && (c.compare(list[j-1], tmp) > 0)) {
				list[j] = list[j-1];
				j--;
			}
			list[j] = tmp;
			
		}
		return null;
	}
	
	public static void main(String args[]) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(20);
		list.add(10);
		list.add(350);
		list.add(320);
		list.add(201);
		
		Integer arr[] = new Integer[list.size()];
		for(int i=0; i<list.size(); i++) {
			arr[i] = list.get(i);
		}
		for(int i=1; i<arr.length; i++) {
			int j = i;
			Integer tmp = arr[i];
			while ((j > 0) && (arr[j-1] < tmp)) {
				arr[j] = arr[j-1];						
				j--;
			}
			arr[j] = tmp;
			
		}
		System.out.println(Arrays.asList(arr));
	}

}
