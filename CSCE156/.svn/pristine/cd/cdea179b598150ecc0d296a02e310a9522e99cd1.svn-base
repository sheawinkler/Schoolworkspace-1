package unl.cse.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HeapDemo {

	public static void main(String args[]) {
		
		Heap<Integer> h = new Heap<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}} );
		
		List<Integer> list = Arrays.asList(30, 20, 50, 10, 3, 7, 9, 10);
		for(Integer i : list) {
			h.addElement(i);
		}
		System.out.println(h);
		System.out.println(h.toTikzString());
	}
}
