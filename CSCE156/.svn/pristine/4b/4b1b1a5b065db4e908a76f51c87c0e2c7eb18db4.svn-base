package unl.cse.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import unl.cse.bst.TreeNode;

public class Heap<T> {

	private List<T> arr;
    private final Comparator<T> comparator;

	public Heap(Comparator<T> comparator) {
		this.comparator = comparator;
		this.arr = new ArrayList<T>(1024);
		//add a dummy element to the zero index
		this.arr.add(null);
	}
	
	public T getTop() {
		
		if(this.arr.isEmpty())
			return null;
		if(this.arr.size() == 1) {
			return this.arr.remove(1);
		}
		T result = arr.set(1, arr.remove(arr.size()-1));

		//bubble the root down...
		int i = 0;
		boolean done = false;
		while(i < arr.size() && !done) {
			int leftChild  = 2*i;
			int rightChild = 2*i + 1;
			
			if( leftChild < arr.size() && rightChild < arr.size()) {
				if(this.comparator.compare(arr.get(i), arr.get(leftChild)) < 0 &&
				   this.comparator.compare(arr.get(i), arr.get(rightChild)) < 0) {
					done = true;
				} else if(this.comparator.compare(arr.get(leftChild), arr.get(rightChild)) > 0) {
					swap(i, rightChild);
					i = rightChild;
				} else if(this.comparator.compare(arr.get(leftChild), arr.get(rightChild)) <= 0) {
					swap(i, leftChild);
					i = leftChild;
				} else {
					done = true;
				}
			} else if (leftChild < arr.size()) {
				if(this.comparator.compare(arr.get(leftChild), arr.get(i)) < 0) {
					swap(i, leftChild);
					i = leftChild;
				} else {
					done = true;
				}
			} else if (rightChild < arr.size()) {
				if(this.comparator.compare(arr.get(rightChild), arr.get(i)) < 0) {
					swap(i, rightChild);
					i = rightChild;
				} else {
					done = true;
				}
			} else {
				done = true;
			}
		}
		
		return result;
	}
	
	private void swap(int i, int j) {
		T tmp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, tmp);
	}
	
	public void addElement(T item) {
		if(item == null)
			throw new IllegalArgumentException("This Heap implementation does not allow null values");
		
		//add to the end of the list, correct it...
		this.arr.add(item);
		
		if(this.arr.size() == 2) 
			return;
		
		int i = this.arr.size()-1;
		int parent = (int) Math.floor( i / 2.0d );
		
		while(parent >= 1 && this.comparator.compare(arr.get(i), arr.get(parent)) < 0) {
			T tmp = arr.get(i);
			arr.set(i, arr.get(parent));
			arr.set(parent, tmp);
			i = parent;
			parent = (int) Math.floor( i / 2.0d);
		}
	}
	
	@Override
	public String toString() {
		System.out.println(this.arr);
		if(arr.size() == 1)
			return "[empty]";
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<Integer>();
		s.add(1);
		while(!s.isEmpty()) {
			Integer i = s.pop();
			if(i < arr.size()) {
				s.push(2*i + 1);
				s.push(2*i);
				int depth = (int) Math.floor(Math.log(i) / Math.log(2));
				for(int j=0; j<depth; j++)
					sb.append("-");
				sb.append(arr.get(i));
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
    public String toTikzString() {
    	
        StringBuilder sb = new StringBuilder();
        sb.append("\\begin{tikzpicture}[level distance=1cm,level/.style={sibling distance=2cm/#1}]\n");
        if(this.arr.get(1) == null) {
        	sb.append("\\node{\\texttt{null}};");
        } else {
        	sb.append("\\node{"+this.arr.get(1).toString()+"}\n");
        	this.toTikzStringRec(2, sb);
        	this.toTikzStringRec(3, sb);
        	sb.append(";\n");
        }
        sb.append("\\end{tikzpicture}\n\n");
        return sb.toString();
    }
    
    private void toTikzStringRec(int i, StringBuilder sb) {
    	if(i >= this.arr.size()) {
    		sb.append("child[draw opacity=0.0] {}\n");
    	} else {
    		sb.append("child {node {"+this.arr.get(i).toString()+"} \n");
    		this.toTikzStringRec(2*i, sb);
    		this.toTikzStringRec(2*i+1, sb);
    		sb.append("}\n");
    	}
    }

}
