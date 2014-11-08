package unl.cse.sets;

import java.util.*;

import unl.cse.sets.Pair;

public class SetUtils {
	
	/**
	 * example of generic set usage--this method has been done for you
	 */
	public static <T> Set<T> setMinus(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>();
		
		result.addAll(a);
		for(T element : b) {
			result.remove(element);
		}
		return result;
	}
	
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
	    Set<T> result = new HashSet<T>(); 
		result.addAll(a);
        result.addAll(b);
        return result;
	}
	
	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		 Set<T> result = new HashSet<T>(); 
        result.addAll(a);
        result.retainAll(b);
        return result;
	}

	/**
	 * Returns a set containing all subsets of the given set
	 */
	public static <T> Set<Set<T>> getPowerSet(Set<T> set) {
		Set<Set<T>> result = new HashSet<Set<T>>();
		if(set.isEmpty()){
			result.add(new HashSet<T>());
			return result;
		}
		
	    List<T> list = new ArrayList<T>(set);
	    T head = list.get(0);
	    Set<T> rest = new HashSet<T>(list.subList(1,list.size())); 
	    for (Set<T> restSet : getPowerSet(rest)) {
	    	Set<T> newSet = new HashSet<T>();
	    	newSet.add(head);
	    	newSet.addAll(restSet);
	    	result.add(newSet);
	    	result.add(restSet);
	    }		
	    return result;
	}

	/**
	 * Returns a set containing all subsets of the given set with the specified cardinality
	 */
	public static <T> Set<Set<T>> getSetsOfCardinality(Set<T> set, int size) {
		Set<Set<T>> result = new HashSet<Set<T>>();
		if(set.size()==size){

			if(set.isEmpty()){
				result.add(new HashSet<T>());
				return result;
			}
		
			List<T> list = new ArrayList<T>(set);
			T head = list.get(0);
			Set<T> rest = new HashSet<T>(list.subList(1,list.size())); 
		for (Set<T> restSet : getPowerSet(rest)) {
	    		Set<T> newSet = new HashSet<T>();
	    		newSet.add(head);
	    		newSet.addAll(restSet);
	    		result.add(newSet);
	    		result.add(restSet);
			}		
	    
		}
		return result;
	}
	
	/**
	 * Returns the symmetric difference of the two given sets
	 */
	public static <T> Set<T> symmetricDifference(Set<T> a, Set<T> b) {
		
		Set<T> result2 = new HashSet<T>();
		result2.addAll(a);
		result2.addAll(b);
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		
		Set<T> finalResult = new HashSet<T>(result2);
		finalResult.removeAll(result);
		return finalResult;
	}

	public static <S, T> Set<Pair<S, T>> cartesianProduct(Set<S> a, Set<T> b) {
		Set<Pair<S,T>> result = new HashSet<Pair<S,T>>();
		for (S element:a){
			for(T element2:b){
				
				result.add(new Pair(element,element2));
			}
		}
		
		return result;
	}
	
}
