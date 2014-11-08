package unl.cse.sorting;

import java.util.Comparator;
import java.util.List;

public interface Sorter<T> {

	public void sort(List<T> list, Comparator<T> comparator);
}
