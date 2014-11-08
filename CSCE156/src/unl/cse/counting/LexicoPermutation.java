package unl.cse.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LexicoPermutation<T> implements Permutation<T> {

	private final List<T> underlyingSet;
	
	public LexicoPermutation(Collection<T> collection) {
		this.underlyingSet = Collections.unmodifiableList(new ArrayList<T>(collection));
	}
	
	@Override
	public Iterator<List<T>> iterator() {
		return new Iterator<List<T>>(){
			private int a[];
			private List<T> curr = null;
			{
				a = new int[underlyingSet.size()];
				for(int i=0; i<a.length; i++) {
					a[i] = i;
				}
				curr = indiciesToList(a);
			}
			@Override
			public boolean hasNext() {
				return (curr != null);
			}

			@Override
			public List<T> next() {
				List<T> result = curr;
				int j = a.length-2;
				int tmp;
				while(j >= 0 && a[j] > a[j+1]) {
					j--;
				}
				if(j < 0) {
					curr = null;
				} else {
					int k = a.length-1;
					while(a[j] > a[k]) {
						k--;
					}
	
					tmp = a[j];
					a[j] = a[k];
					a[k] = tmp;
					
					int r = a.length-1;
					int s = j+1;
					while(r > s) {
	
						tmp = a[r];
						a[r] = a[s];
						a[s] = tmp;
	
						r--;
						s++;
					}
					curr = indiciesToList(a);
				}
				return result;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove not allowed");
			}};
	}
	
	private List<T> indiciesToList(int a[]) {
		List<T> result = new ArrayList<T>();
		for(int i=0; i<a.length; i++) {
			result.add(this.underlyingSet.get(a[i]));
		}
		return result;
	}

	@Override
	public List<List<T>> getAllPermutations() {
		List<List<T>> result = new ArrayList<List<T>>();
		
		int n = this.underlyingSet.size();
		int tmp;

		int a[] = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = i;
		}
		
		result.add(this.indiciesToList(a));

		while(true) {
			int j = n-2;
			while(j >= 0 && a[j] > a[j+1]) {
				j--;
			}
			if(j < 0) {
				break;
			}
			int k = n-1;
			while(a[j] > a[k]) {
				k--;
			}

			tmp = a[j];
			a[j] = a[k];
			a[k] = tmp;
			
			int r = n-1;
			int s = j+1;
			while(r > s) {

				tmp = a[r];
				a[r] = a[s];
				a[s] = tmp;

				r--;
				s++;
			}
			result.add(this.indiciesToList(a));
		}
		
		return result;
	}

	
	public static void main(String args[]) {
		
		List<Character> chars = Arrays.asList('a', 'b', 'c', 'd');
		Permutation<Character> perm = new LexicoPermutation<Character>(chars);
		int count;
		count = 1;
		for(List<Character> p : perm) {
			System.out.println(count + ": " + p);
			count++;
		}
	}

}
