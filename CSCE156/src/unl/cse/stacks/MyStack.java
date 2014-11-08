package unl.cse.stacks;

import java.util.LinkedList;
import java.util.List;

public class MyStack<T> {

	private static final Integer DEFAULT_MAX_SIZE = 100;
	private final Integer maxSize;
	private final List<T> underlyingList;
	
	public MyStack() {
		this(DEFAULT_MAX_SIZE);
	}
	
	public MyStack(Integer maxSize) {
		this.maxSize = maxSize;
		underlyingList = new LinkedList<T>();
		
	}

	/**
	 * Places the given <code>item</code> on top of the stack if its maximum capacity
	 * (specified at instantiation) allows it and return <code>true</code>.  If the 
	 * stack is full, the item is not placed on the top and <code>false</code> is 
	 * returned.
	 * @param item
	 * @return
	 */
	public boolean push(T item) {
		if(underlyingList.size() == this.maxSize)
			return false;
		else {
			underlyingList.add(0, item);
			return true;
		}
	}

	public T pop() {
		if(underlyingList.size() > 0)
			return underlyingList.remove(0);
		else
			return null;
	}
	
	public boolean isEmpty() {
		return (this.underlyingList.size() == 0);
	}
	
	public boolean isFull() {
		return (this.underlyingList.size() == this.maxSize);
	}
	
	public int size() {
		return this.underlyingList.size();
	}
	
	public static void main(String args[]) {

		MyStack<Integer> s = new MyStack<Integer>(10);
		for(int i=0; i<10; i++) {
			Integer a = i * 10;
			System.out.println("Pushing "+a+"...");
			s.push(a);
		}
		System.out.println("stack is full? "+s.isFull());
		System.out.println("pop: "+s.pop());
		System.out.println("pop: "+s.pop());
		System.out.println("pop: "+s.pop());
		System.out.println("the stack size is now "+s.size());

	}
}
