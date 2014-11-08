package unl.cse.stacks;

import unl.cse.linked_list.LinkedList;


public class Stack<T> {

	private final LinkedList<T> list = new LinkedList<T>();
	
	public T pop() {
		//TODO: implement this method
	
		if(list.size() > 0 ){
            return list.removeElementFromTail();
        }
        else{
            return null;
        }
	}
	
	public void push(T item) {
		//TODO: implement this method
		list.addElementToTail(item);
	}

	public int size() {
		 if(list.size() > 0){
	            return this.list.size();
	        }
	        else{
	            return -1;
	        }
	}
	
	public boolean isEmpty() {
        if(this.list.size() == 0){
            return true;
        }
        else{
            return false;
        }
	}
	
}
