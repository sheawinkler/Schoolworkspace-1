package unl.cse.queue;

import java.util.LinkedList;
import java.util.List;

public class MyQueue<T> {

	private static final Integer DEFAULT_MAX_SIZE = 100;
	private final Integer maxSize;
	private final List<T> underlyingList;
	
	public MyQueue() {
		this(DEFAULT_MAX_SIZE);
	}
	
	public MyQueue(Integer maxSize) {
		this.maxSize = maxSize;
		this.underlyingList = new LinkedList<T>();
		
	}

	/**
	 * Places the given <code>item</code> on end of the queue if its maximum capacity
	 * (specified at instantiation) allows it and return <code>true</code>.  If the 
	 * queue is full, the item is not placed on the top and <code>false</code> is 
	 * returned.
	 * @param item
	 * @return
	 */
	public boolean enqueue(T item) {
		if(underlyingList.size() == this.maxSize)
			return false;
		else {
			underlyingList.add(item);
			return true;
		}
	}

	/**
	 * Removes and returns the element at the front of the queue; returns null if the 
	 * queue is empty.
	 * @return
	 */
	public T dequeue() {
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

		MyQueue<Integer> q = new MyQueue<Integer>(10);
		for(int i=0; i<10; i++) {
			Integer a = i * 10;
			System.out.println("Enqueing "+a+"...");
			q.enqueue(a);
		}
		System.out.println("queue is full? "+q.isFull());
		System.out.println("dequeue: "+q.dequeue());
		System.out.println("dequeue: "+q.dequeue());
		System.out.println("dequeue: "+q.dequeue());
		System.out.println("the queue size is now "+q.size());

	}
}
