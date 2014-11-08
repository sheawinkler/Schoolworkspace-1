package unl.cse.relations;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import unl.cse.utils.Pair;


/**
 * A class that represents a <i>relation</i> on a <i>set</i> of (parameterized) elements.
 * 
 * @param <T>
 */
public class Relation<T> {
	
	private Set<T> newSet;
	private Set<Pair<T, T>> elements;
	
	/**
1	 * Creates an empty relation on an empty set
	 */
	public Relation() {
		elements = new HashSet<Pair<T, T>>();
		newSet = new HashSet<T>();
	}
	
	/**
	 * Creates an empty relation on the given set
	 * @param items
	 */
	public Relation(Set<T> items) {
		//Set of pairs
		elements = new HashSet<Pair<T, T>>();
		newSet = new HashSet<T>(items);
	}
	

	
	public Relation(Relation<T> relate){
		
	
	}
	
	/**
	 * Returns (a new copy of) the underlying set that the relation is based on
	 * @return
	 */
	public Set<T> getRelationSet() {
		Set<T> finalSet = new HashSet<T>(newSet);
		return finalSet;
	}

	/**
	 * Return <code>true</code> if this relation is <i>reflexive</i>, <code>false</code>
	 * otherwise.
	 * @return
	 */
	public boolean isReflexive() {
		for (Pair<T, T> a : this.elements) {
			boolean reflexive = false;
			for (Pair<T, T> b : this.elements) {
				if (b.getSecond() == a.getFirst() && b.getFirst() == a.getFirst()) {
					reflexive = true;
					break;
				}
			}
			if (!reflexive) return false;
		}
		return true;
	}
	
	/**
	 * Return <code>true</code> if this relation is <i>symmetric</i>, <code>false</code>
	 * otherwise.
	 * @return
	 */
	public boolean isSymmetric() {
		for (Pair<T, T> a : this.elements) {
			boolean Symmetric = false;
			for (Pair<T, T> b : this.elements) {
				if (a.getFirst() == b.getSecond() && a.getSecond() == b.getFirst()) {
					Symmetric = true;
					break;
				}
			}
			if (!Symmetric) return false;
		}
		return true;
	}

	/**
	 * Return <code>true</code> if this relation is <i>asymmetric</i>, <code>false</code>
	 * otherwise.
	 * @return
	 */
	public boolean isAsymmetric() {
		boolean aSymmetric = false;
				if (!isSymmetric()) {
					aSymmetric = true;
				}
			return aSymmetric;
	}

	/**
	 * Return <code>true</code> if this relation is <i>antisymmetric</i>, <code>false</code>
	 * otherwise.
	 * @return
	 */
	public boolean isAntisymmetric() {
		
		for (Pair<T, T> a : this.elements) {
			boolean antiSymmetric = false;
			for (Pair<T, T> b : this.elements) {
				//if (this.elements.isRelation(a, b)) {
					antiSymmetric = true;
					break;
				//}
			}
			if (!antiSymmetric) return false;
		}
		return true;
	}

	/**
	 * Return <code>true</code> if this relation is <i>transitive</i>, <code>false</code>
	 * otherwise.
	 * @return
	 */
	public boolean isTransitive() {
		for (Pair<T, T> a : this.elements) {
			boolean isTransitive = false;
			for (Pair<T, T> b : this.elements) {
				//if (newSet.)) {
					
					isTransitive = true;
				//}
			}
			if (!isTransitive) return false;
		}
		return true;
	}
	
	/**
	 * Return <code>true</code> if this relation is a <i>partial order</i>, <code>false</code>
	 * otherwise.
	 * @return
	 */
	public boolean isPartialOrder() {
		boolean truth = false;
		if(this.isReflexive() && this.isAntisymmetric() && this.isTransitive()){
			truth = true;
		}
		return truth;
	}

	/**
	 * Return <code>true</code> if this relation is an <i>equivalence relation</i>, <code>false</code>
	 * otherwise.
	 * @return
	 */
	public boolean isEquivalenceRelation() {
		return false;
	}
	
	/**
	 * Is a function if it passes the horizontal line test.  One y for the x inputs
	 * 
	 * Returns <code>true</code> if this relation is a <i>function</i> on the underlying
	 * set, <code>false</code> otherwise.
	 * @return
	 */
	public boolean isFunction() {
		for (T yVariable : newSet) {
			int totalAmount = 0;
			for (Pair<T, T> relationSet : this.elements) {
				if (relationSet.getFirst() == yVariable)
					totalAmount++;
			}
			if (totalAmount != 1)
				return false;
		}
		
		return true;
	}

	/**
	 * Returns <code>true</code> if this relation is a function and is <i>surjective</i> 
	 * (an onto function), <code>false</code> otherwise.
	 * @return
	 */
	public boolean isSurjection() {
		boolean truth = false;
		if (isFunction()){
			for(T yVariable : newSet){
				int totalAmount = 0;
				for (Pair<T, T> relationSet : this.elements) {
					if(relationSet.getSecond() == yVariable){
						totalAmount++;
					}
					if (totalAmount != 1)
						truth = false;
						
				}
			}
		}
		return truth;
	}

	/**
	 * Returns <code>true</code> if this relation is a function and is <i>injective</i> 
	 * (a one-to-one function), <code>false</code> otherwise.
	 * @return
	 */
	public boolean isInjection() {
		return false;
	}

	/**
	 * Returns <code>true</code> if this relation is a function and is <i>bijective</i> 
	 * (a one-to-one and onto function), <code>false</code> otherwise.
	 * @return
	 */
	public boolean isBijection() {
		boolean truth = false;
		if(this.isInjection() && this.isSurjection()){
			truth = true;
		}
		return truth;

	}

	/**
	 * Returns <code>true</code> if the elements in the given ordered pair (a, b) are related
	 * (that is, if a is-related-to- b).
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean isRelation(T a, T b) {
		boolean truth = false;
		if(this.elements.contains(new Pair<T,T>(a,b))){
			truth = true;
		}
		return truth;
	}

	/**
	 * Adds the element <code>a</code> to the underlying set that this relation 
	 * is based on.  This method does not infer any particular relation involving 
	 * <code>a</code> and other elements in the underlying set (to add relations, 
	 * use {@link #addRelation} to add relations between elements).  If <code>a</code> 
	 * is null, an {@link IllegalArgumentException} is thrown.
	 */
	public void addElement(T a) {
		if(a == null)
			throw new IllegalArgumentException("Relation does not allow null values");

		this.newSet.add(a);
		
	}
	
	/**
	 * Removes the element <code>a</code> from the underlying set that this relation
	 * is based on.  As a side-effect, removes all relations involving <code>a</code> 
	 * @param a
	 */
	public void removeElement(T a) {
		this.newSet.remove(a);
		//Still need to remove any pairs with elements of A
	}
	
	/**
	 * Adds the relation between the ordered pair (a, b) to this relation.  If a or b
	 * are not contained in the underlying set that this relation is based on, calling this
	 * method will add them for you.  If either a or b are null, an {@link IllegalArgumentException}
	 * is thrown.
	 * @param a
	 * @param b
	 */
	public void addRelation(T a, T b) {
		
		if(a == null || b == null) 
			throw new IllegalArgumentException("Relation does not allow null values");
		if(!this.elements.contains(new Pair<T,T>(a,b))){
			this.elements.add(new Pair<T, T>(a, b));
		}

	}
	
	/**
	 * Removes the relation between the ordered pair (a, b) if it exists
	 * @param a
	 * @param b
	 */
	public void removeRelation(T a, T b) {
		if(this.elements.contains(new Pair<T,T>(a,b))){
			this.elements.remove(new Pair<T, T>(a, b));
		}
	}

	/**
	 * Returns a new {@link Relation} that represents the <i>reflexive closure</i> of this
	 * relation
	 * @return
	 */
	public Relation<T> getReflexiveClosure() {
		return null;
	}
	
	/**
	 * Returns a new {@link Relation} that represents the <i>symmetric closure</i> of this
	 * relation
	 * @return
	 */
	public Relation<T> getSymmetricClosure() {
		return null;

	}

	/**
	 * Returns a new {@link Relation} that represents the <i>transitive closure</i> of this
	 * relation
	 * @return
	 */
	public Relation<T> getTransitiveClosure() {
		return null;

	}

	/**
	 * Overridden <code>toString()</code> method that returns a string representation of this
	 * relation.  The formatting of the output string includes the underlying set and all of 
	 * the ordered pairs in the relation.  An example:
	 * <pre>
	 *   R({a, b, c}) = { (a, b), (a, c), (b, a), (c, c) }
	 * </pre>
	 */
	@Override
	public String toString() {
StringBuilder s = new StringBuilder();
		
		s.append("R(");
		s.append(this.newSet.toString());
		s.append(") = ");
		s = new StringBuilder(s.toString().replace('[', '{').replace(']', '}'));
		s.append(this.elements.toString());
		return s.toString().replace("[", "{ ").replace("]", " }").replace('<', '(').replace('>', ')').replace(",", ", ").replace(",  ", ", ");

	}

	public static void main(String[]args){
		LinkedHashSet<String> list = new LinkedHashSet<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		Relation<String> relate1 = new Relation<String>(list);
		relate1.addRelation("a", "b");
		relate1.addRelation("b","c");
		System.out.println(relate1);
		System.out.println(relate1.toString());
		
		System.out.println(relate1.isSymmetric());
		
		System.out.println(relate1.isTransitive());
		for(String a : relate1.getRelationSet()) {
			for(String b : relate1.getRelationSet()) {
				System.out.println("(a,b) = ("+a+","+b+") = "+relate1.isRelation(a, b));
			}
		}
		
		Relation<String> rc = relate1.getReflexiveClosure();
		System.out.println(rc);
		System.out.println(rc.isReflexive());
		for(String a : rc.getRelationSet()) {
			for(String b : rc.getRelationSet()) {
				System.out.println("(a,b) = ("+a+","+b+") = "+rc.isRelation(a, b));
			}
		}
		
		Relation<String> tc = relate1.getTransitiveClosure();
		System.out.println(tc);
		System.out.println(tc.isTransitive());
		for(String a : tc.getRelationSet()) {
			for(String b : tc.getRelationSet()) {
				System.out.println("(a,b) = ("+a+","+b+") = "+tc.isRelation(a, b));
			}
		}
		Relation<String> sc = relate1.getSymmetricClosure();
		System.out.println(sc);
		System.out.println(sc.isSymmetric());
		for(String a : sc.getRelationSet()) {
			for(String b : sc.getRelationSet()) {
				System.out.println("(a,b) = ("+a+","+b+") = "+sc.isRelation(a, b));
			}
		}

		System.out.println(relate1.toString());
		System.out.println(relate1.isSymmetric());
		System.out.println(relate1.isTransitive());
		for(String a : relate1.getRelationSet()) {
			for(String b : relate1.getRelationSet()) {
				System.out.println("(a,b) = ("+a+","+b+") = "+relate1.isRelation(a, b));
			}
		}
		
	}
}
