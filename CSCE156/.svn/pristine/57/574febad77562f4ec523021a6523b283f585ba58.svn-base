package unl.cse.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DistributedMergeSort<T> {

	private final Comparator<T> comparator;
	private static final Comparator<Integer> INT_COMPARATOR = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}};
	private final Integer numSections;
	
	public DistributedMergeSort(Comparator<T> comparator) {
		this(comparator, 10);
	}

	public DistributedMergeSort(Comparator<T> comparator, Integer numSections) {
		this.comparator = comparator;
		this.numSections = numSections;
	}
	
	public void sort(T list[]) {
		
		ExecutorService executor = null;
		
		int high, low;
		try {
			executor = Executors.newFixedThreadPool(10);
			List<Future<Object[]>> sections = new ArrayList<Future<Object[]>>();
			int sectionSize = list.length / numSections;
			for(int i=0; i<this.numSections-1; i++) {
				low = i * sectionSize;
				high = (i+1) * sectionSize;
				CallableSort cs = new CallableSort(list, low, high, comparator);
				Future<Object[]> submit = executor.submit(cs);
				sections.add(submit);
			}
			low = (this.numSections-1)*sectionSize;
			high = list.length;
			CallableSort cs = new CallableSort(list, low, high, comparator);
			Future<Object[]> submit = executor.submit(cs);
			sections.add(submit);

			for(Future<Object[]> f : sections) {
				f.get();
			}
			for(int i=1; i<this.numSections-1; i++) {
				low = i * sectionSize;
				high = (i+1) * sectionSize;
				merge(list, 0, low-1, low, high-1);
			}
			low = (this.numSections-1)*sectionSize;
			high = list.length;
			merge(list, 0, low-1, low, high-1);

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			executor.shutdown();
		}
		return;
	}
	
	//TODO: make a CallableMerge?
	private void merge(T a[], int lowA, int highA, int lowB, int highB) {
		//System.out.println(lowA + ", " + highA + ", " + lowB + ", " + highB);
		if(highA != lowB - 1)
			throw new IllegalStateException("Attempting to merge non-contiguous sections");

		Object tmp[] = new Object[highB - lowA + 1];
		int i = lowA, j = lowB;
		int index = 0;
		while(i <= highA && j <= highB) {
			if(this.comparator.compare(a[i], a[j]) < 0) {
				tmp[index] = a[i];
				i++;
			} else {
				tmp[index] = a[j];
				j++;
			}
			index++;
		}
		while(i <= highA) {
			tmp[index] = a[i];
			index++;
			i++;
		}
		while(j <= highB) {
			tmp[index] = a[j];
			index++;
			j++;
		}
		//System.out.println("in/out:"+Arrays.toString(a)+", "+Arrays.toString(tmp));
		for(i=lowA; i<=highB; i++) {
			a[i] = (T) tmp[i-lowA];
		}
	}
	
	private List<Integer> merge(List<Integer> a, List<Integer> b) {
		List<Integer> result = new ArrayList<Integer>();
		int n = a.size() + b.size();
		int i = 0, j = 0;
		while(i < a.size() && j < b.size()) {
			if(a.get(i) < b.get(j)) {
				result.add(a.get(i));
				i++;
			} else {
				result.add(b.get(j));
				j++;
			}
		}
		while(i < a.size()) {
			result.add(a.get(i));
			i++;
		}
		while(j < b.size()) {
			result.add(b.get(j));
			j++;
		}
		return result;
	}
	
	public static void main(String args[]) {
		Random r = new Random();
		int n = 100000;
		int m = 20;
		Integer list[] = new Integer[n];
		Integer sorted[] = new Integer[n];
		for(int i=0; i<n; i++) {
			list[i] = r.nextInt(n);
			sorted[i] = list[i];
		}
		System.out.println(Arrays.toString(list));
		System.out.println("sorting...");
		DistributedMergeSort<Integer> ms = new DistributedMergeSort<Integer>(INT_COMPARATOR, m);
		long start, end;
		start = System.nanoTime();
		ms.sort(list);
		end = System.nanoTime();
		System.out.println("Distributed Merge Sort Execution Time = "+(end-start)+"ns");
		start = System.nanoTime();
		Arrays.sort(sorted);
		end = System.nanoTime();
		System.out.println("Array Sorter Execution Time = "+(end-start)+"ns");
		//System.out.println("equal? " + Arrays.equals(sorted, list));
		if(!Arrays.equals(sorted, list))
			throw new IllegalArgumentException("Not actually sorted");
		//System.out.println(Arrays.toString(sorted));
		//System.out.println(Arrays.toString(list));
	}
}
