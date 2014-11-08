package unl.cse.lists;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

	private Node<T> head = null;

	public void addElementToHead(T item) {
		Node<T> newHead = new Node<T>(item);
		newHead.setNext(this.head);
		this.head = newHead;
	}
	
	public void removeFirstInstanceOf(T item) {
		if(head == null) {
			return;
		} else if(head.getItem().equals(item)) {
			head = head.getNext();
		} else {
			Node<T> curr = head;
			Node<T> prev = null;
			while(curr.hasNext() && !curr.getItem().equals(item)) {
				prev = curr;
				curr = curr.getNext();
			}
			if(curr.getItem().equals(item))
				prev.setNext(curr.getNext());
		}
	}

	/* added demo methods BEGIN */
	public void insertAtIndex(T item, int index) {

		if(index < 0 || index > this.getSize()) {
			throw new IllegalArgumentException("index out of bounds");
		}
		
		if(index == this.getSize()) {
			addElementToEndOfList(item);
			return;
		} else if(index == 0) {
			this.addElementToHead(item);
			return;
		}
		
		//find the node with index, index-1
		Node<T> theNode = this.getNodeAtIndex(index-1);
		Node<T> newNode = new Node<T>(item);
		newNode.setNext(theNode.getNext());
		theNode.setNext(newNode);
		
	}
	
	public void addElementToEndOfList(T item) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not yet implemented");
	}	
	private Node<T> getNodeAtIndex(int index) {
		
		if(index < 0 || index >= this.getSize()) {
			throw new IllegalArgumentException("index out of bounds");
		}
		Node<T> current = head;
		for(int i=0; i<index; i++) {
			current = current.getNext();
		}
		return current;

	}
	
	public T getElementAtIndex(int index) {

		Node<T> theNode = this.getNodeAtIndex(index);
		return theNode.getItem();
	}
	
	public int getSize() {
		Node<T> current = head;
		int counter = 0;
		while(current != null) {
			current = current.getNext();
			counter++;
		}
		return counter;
	}
	
	/* added demo methods END */

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> curr = head;
			@Override
			public boolean hasNext() {
				if(curr == null)
					return false;
				else
					return true;
			}
			@Override
			public T next() {
				T item = curr.getItem();
				curr = curr.getNext();
				return item;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("not implemented");
			}};
	}

	@Override
	public String toString() {
		if(this.head == null) {
			return "[empty]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> curr = head;
		while(curr.hasNext()) {
			sb.append(curr.getItem());
			sb.append(", ");
			curr = curr.getNext();
		}
		sb.append(curr.getItem());
		sb.append("]");
		return sb.toString();
	}


}
