package unl.cse.sorting;

import java.util.Comparator;
import java.util.List;

public class InsertionSorter<T> implements Sorter<T> {

	@Override
	public void sort(List<T> list, Comparator<T> comparator) {
		for(int i=1; i<list.size(); i++) {
			int j = i;
			T tmp = list.get(i);
			while ((j > 0) && (comparator.compare(list.get(j-1), tmp) > 0)) {
				list.set(j, list.get(j-1));
				j--;
			}
			list.set(j, tmp);
		}
	}

}
