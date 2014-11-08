package unl.cse.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyPriorityQueue<T> {

	private final List<T> underlyingList;
	private final Map<T, Integer> priorityMap;
	
	public MyPriorityQueue() {
		this.underlyingList = new LinkedList<T>();
		this.priorityMap = new HashMap<T, Integer>();
	}

	public void enqueue(T item, int priorityLevel) {

		int i=0;
		while(i < underlyingList.size() && 
				priorityMap.get(underlyingList.get(i)) < priorityLevel) {
			i++;
		}
		underlyingList.add(i, item);
		priorityMap.put(item, priorityLevel);
	}

	public T dequeue() {
		if(underlyingList.size() > 0)
			return underlyingList.remove(0);
		else
			return null;
	}
	
	public boolean isEmpty() {
		return (this.underlyingList.size() == 0);
	}
	
	public int size() {
		return this.underlyingList.size();
	}
	
	public static void main(String args[]) {

		MyPriorityQueue<String> pq = new MyPriorityQueue<String>();
		pq.enqueue("A", 10);
		pq.enqueue("B", 1);
		pq.enqueue("C", 5);
		pq.enqueue("D", 20);

		System.out.println("dequeue: "+pq.dequeue());
		System.out.println("dequeue: "+pq.dequeue());
		System.out.println("dequeue: "+pq.dequeue());
		System.out.println("dequeue: "+pq.dequeue());

	}

}
