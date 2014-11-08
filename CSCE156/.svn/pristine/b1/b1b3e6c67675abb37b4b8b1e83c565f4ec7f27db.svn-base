package unl.cse.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Combination<T> implements Iterable<List<T>> {

	private final List<T> underlyingSet;
	private final Integer r;
	
	public Combination(Collection<T> collection, Integer r) {
		if(collection == null || collection.size() == 0) {
			throw new IllegalArgumentException("Combination expects a non-null, non-empty collection");
		}
		if(r < 0 || r > collection.size()) {
			throw new IllegalArgumentException("Invalid r-value: "+r);
		}
		this.underlyingSet = Collections.unmodifiableList(new ArrayList<T>(collection));
		this.r = r;
	}

	private List<T> getOrderedList(List<Integer> indices) {
		List<T> result = new ArrayList<T>(indices.size());
		for(Integer index : indices) {
			result.add(this.underlyingSet.get(index-1));
		}
		return result;
	}

	@Override
	public Iterator<List<T>> iterator() {
		return new Iterator<List<T>>() {
			private List<T> curr = underlyingSet.subList(0, r);
			private final List<Integer> a = new ArrayList<Integer>(underlyingSet.size());
			private final List<Integer> c;
			{
				for(int i=1; i<=underlyingSet.size(); i++) {
					a.add(i);
				}				
				c  = a.subList(0, r);
			}
			@Override
			public boolean hasNext() {
				return (curr != null);
			}

			@Override
			public List<T> next() {
				List<T> result = curr;
				int i = r;
				while(i > 0 && c.get(i-1).intValue() == (underlyingSet.size()-r+i)) {
					i--;
				}
				if(i == 0) {
					curr = null;
				} else {
					c.set(i-1, c.get(i-1)+1);
					for(int j=(i+1); j<=r; j++) {
						c.set(j-1, c.get(i-1)+j-i);
					}
					this.curr = getOrderedList(c);
				}
				return result;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove is not allowed");
				
			}
			
		};
	}

	public List<List<T>> getCombinations() {
		List<List<T>> result = new ArrayList<List<T>>();

		int n = this.underlyingSet.size();
		List<Integer> a = new ArrayList<Integer>(n);
		for(int i=1; i<=n; i++) {
			a.add(i);
		}
		List<Integer> c = a.subList(0, r);
		
		result.add(getOrderedList(c));
		
		while(true) {
			int i = r;
			while(i > 0 && c.get(i-1).intValue() == (n-r+i)) {
				i--;
			}
			if(i == 0) {
				break;
			}
			c.set(i-1, c.get(i-1)+1);
			for(int j=(i+1); j<=r; j++) {
				c.set(j-1, c.get(i-1)+j-i);
			}
			result.add(getOrderedList(c));
		}
		
		return result;
	}

	public static void main(String args[]) {
		
		List<Character> c = Arrays.asList('a', 'b', 'c', 'd', 'e');
		
		Combination<Character> comb = new Combination<Character>(c, 3);
		System.out.println("gettin' all: ");
		int count = 1;
		for(List<Character> list : comb) {			
			System.out.println(count +": " +list);
			count++;
		}
	}

}
