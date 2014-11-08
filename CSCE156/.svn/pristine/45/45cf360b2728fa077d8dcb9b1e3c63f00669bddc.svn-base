package unl.cse.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Provides a way to iterate over all permutations of a {@link Collection} using 
 * the Johnson-Trotter algorithm
 * @author cbourke
 *
 */
public class JohnsonTrotter<T> implements Permutation<T> {

	private final List<T> underlyingSet;
	
	public JohnsonTrotter(Collection<T> collection) {
		this.underlyingSet = Collections.unmodifiableList(new ArrayList<T>(collection));
	}
	
	@Override
	public Iterator<List<T>> iterator() {
		return new Iterator<List<T>>() {
			private List<Boolean> orient = new ArrayList<Boolean>(underlyingSet.size());
			private List<Integer> indices = new ArrayList<Integer>(underlyingSet.size());
			private List<T> curr;
			{
				for(int i=0; i<underlyingSet.size(); i++) {
					orient.add(false); 
					indices.add(i);
				}
				curr = new ArrayList<T>();
				for(Integer i : indices) {
					curr.add(underlyingSet.get(i));
				}
			}
			@Override
			public boolean hasNext() {
				return (curr != null);
			}

			@Override
			public List<T> next() {
				
				List<T> result = curr;
				
				//find largest mobile index
				int index = -1;
				for(int i=0; i<indices.size(); i++) {
					if(orient.get(i)) {
						if(i<indices.size()-1 && indices.get(i+1) < indices.get(i)) {
							if(index == -1)
								index = i;
							else if(indices.get(i) > indices.get(index))
								index = i;
						}
					} else {
						if(i>0 && indices.get(i-1) < indices.get(i)) {
							if(index == -1)
								index = i;
							else if(indices.get(i) > indices.get(index))
								index = i;
						}
					}
				}
				if(index == -1) {
					curr = null; 
				} else {
					curr = new ArrayList<T>();

					//swap index and what it points to
					int k = indices.get(index);
					if(orient.get(index)) {
						//swap index, index+1
						Integer tmp = indices.get(index);
						indices.set(index, indices.get(index+1));
						indices.set(index+1, tmp);
						Boolean btmp = orient.get(index);
						orient.set(index, orient.get(index+1));
						orient.set(index+1, btmp);
					} else {
						//swap index, index+1
						Integer tmp = indices.get(index);
						indices.set(index, indices.get(index-1));
						indices.set(index-1, tmp);
						Boolean btmp = orient.get(index);
						orient.set(index, orient.get(index-1));
						orient.set(index-1, btmp);
					}
					
					//reverse direction of all indices > index
					for(int i=0; i<orient.size(); i++) {
						if(indices.get(i) > k) {
							orient.set(i, !orient.get(i));
						}
					}
	
					for(Integer i : indices) {
						curr.add(underlyingSet.get(i));
					}
				}
				return result;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove is not allowed");
			}
			
		};
	}

	@Override
	public List<List<T>> getAllPermutations() {
		List<List<T>> result = new ArrayList<List<T>>();
		//false = <-; true = ->
		List<Boolean> orient = new ArrayList<Boolean>(this.underlyingSet.size());
		List<Integer> indices = new ArrayList<Integer>(this.underlyingSet.size());
		for(int i=0; i<this.underlyingSet.size(); i++) {
			orient.add(false); 
			indices.add(i);
		}

		List<T> list = new ArrayList<T>();
		for(Integer i : indices) {
			list.add(this.underlyingSet.get(i));
		}
		result.add(list);

		while(true) {
			//find largest mobile index
			int index = -1;
			for(int i=0; i<indices.size(); i++) {
				if(orient.get(i)) {
					if(i<indices.size()-1 && indices.get(i+1) < indices.get(i)) {
						if(index == -1)
							index = i;
						else if(indices.get(i) > indices.get(index))
							index = i;
					}
				} else {
					if(i>0 && indices.get(i-1) < indices.get(i)) {
						if(index == -1)
							index = i;
						else if(indices.get(i) > indices.get(index))
							index = i;
					}
				}
			}
			if(index == -1)
				break;
			//swap index and what it points to
			int k = indices.get(index);
			if(orient.get(index)) {
				//swap index, index+1
				Integer tmp = indices.get(index);
				indices.set(index, indices.get(index+1));
				indices.set(index+1, tmp);
				Boolean btmp = orient.get(index);
				orient.set(index, orient.get(index+1));
				orient.set(index+1, btmp);
			} else {
				//swap index, index+1
				Integer tmp = indices.get(index);
				indices.set(index, indices.get(index-1));
				indices.set(index-1, tmp);
				Boolean btmp = orient.get(index);
				orient.set(index, orient.get(index-1));
				orient.set(index-1, btmp);
			}
			
			//reverse direction of all indices > index
			for(int i=0; i<orient.size(); i++) {
				if(indices.get(i) > k) {
					orient.set(i, !orient.get(i));
				}
			}

			list = new ArrayList<T>();
			for(Integer i : indices) {
				list.add(this.underlyingSet.get(i));
			}
			result.add(list);
		}
		return result;
	}
	
	public static void main(String args[]) {
		
		List<Character> chars = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
		Permutation<Character> perm = new JohnsonTrotter<Character>(chars);
		int count;
		count = 1;
		for(List<Character> p : perm) {
			System.out.println(count + ": " + p);
			count++;
		}
	}

}
