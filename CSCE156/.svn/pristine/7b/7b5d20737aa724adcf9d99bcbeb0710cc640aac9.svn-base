package unl.cse.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchDemo {

	private static final Double nsPerMs = 1000000.0;
	
	public static void main(String args[]) {

		Comparator<Integer> int_comp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}};
		List<Integer> a = new ArrayList<Integer>();
		int n = 1000;
		for(int i=0; i<n; i++)
			a.add(i);

		System.out.println("Demo:");
		System.out.println("size: "+a.size());
		System.out.println("Index linearSearch("+2+") = "+SearchUtils.linearSearch(a, int_comp, 2));
		System.out.println("Index binarySearch("+2+") = "+SearchUtils.binarySearch(a, int_comp, 2));
		
		long start, end;
		start = System.nanoTime();
		SearchUtils.linearSearch(a, int_comp, n - 2);
		end = System.nanoTime();
		System.out.println("Linear Search time: " + String.format("%.4f", (end-start) / nsPerMs) + "ms");

		start = System.nanoTime();
		SearchUtils.binarySearch(a, int_comp, n - 2);
		end = System.nanoTime();
		System.out.println("Binary Search time: " + String.format("%.4f", (end-start) / nsPerMs) + "ms");

		int arr[] = new int[a.size()];
		for(int i=0; i<a.size(); i++) {
			arr[i] = a.get(i);
		}
		
		start = System.nanoTime();
		int index = SearchUtils.binarySearch(arr, 500);
		end = System.nanoTime();
		System.out.println("arr["+index+"] = "+arr[index]);
		System.out.println("Binary Search time: " + String.format("%.4f", (end-start) / nsPerMs) + "ms");
	}

}
