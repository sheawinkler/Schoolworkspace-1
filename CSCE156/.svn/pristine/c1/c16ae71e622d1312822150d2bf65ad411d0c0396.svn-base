package unl.cse.search;

import java.util.Comparator;
import java.util.List;

public class SearchUtils {

	/**
	 * Returns the index for which the first instance of the provided element
	 * exists in the list.
	 * @param list
	 * @return
	 */
	public static <T> Integer linearSearch(List<T> list, Comparator<T> comparator, T element) {

		Integer index = null;
		for(int i=0; i<list.size() && index == null; i++) {
			if(comparator.compare(list.get(i), element) == 0)
				index = i;
		}
		return index;
	}
	
	public static <T> Integer binarySearch(List<T> list, Comparator<T> comparator, T element) {
		return binarySearch(list, comparator, element, 0, list.size()-1);
	}

	private static <T> Integer binarySearch(List<T> list, Comparator<T> comparator, T element, int low, int high) {

		if(low > high) 
			return null;
		int mid = (high + low) / 2;
		if(comparator.compare(list.get(mid), element) == 0)
			return mid;
		else if(comparator.compare(list.get(mid), element) < 0)
			return binarySearch(list, comparator, element, mid+1, high);
		else
			return binarySearch(list, comparator, element, low, mid-1);
	}
	
	public static int binarySearch(int a[], int element)
	{
		int l = 0, h = a.length-1;
		while(l <= h) {
			int m = (l + h) / 2;
			if(a[m] == element)
				return m;
			else if(a[m] < element)
				l = m + 1;
			else
				h = m - 1;
		}
		return -1;
	}
	
}
