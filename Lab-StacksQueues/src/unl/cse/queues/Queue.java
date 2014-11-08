package unl.cse.queues;

import unl.cse.linked_list.LinkedList;

public class Queue<T> {

	private final LinkedList<T> list = new LinkedList<T>();
	
	public T dequeue() {
		//TODO: implement this method
		 if(list.size() > 0){
	            return list.removeElementFromHead();
	        }else{
	            return null;
	        }
	}
	
	public void enqueue(T item) {
		//TODO: implement this method
        list.addElementToTail(item);
	}

	public int size() {
		//TODO: implement this method
		  if(this.list.size() > 0){
	            return this.list.size();
	        }else{
	            return -1;
	        }
	}
	
	public boolean isEmpty() {
		//TODO: implement this method
		 if(list.size() > 0){
	            return false;
	        }else{
	            return true;
	        }
	}
	
}
