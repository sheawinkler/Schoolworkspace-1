import java.util.ArrayList;
import java.util.Collections;
/*
 * Deverick Simpson
 * Spring 2014
 * Heap data structure implementation using an ArrayList data struct
 * I add a null variable 0 to  al[0] to adjust for computation 
 * The variable count is not accurately reporting the number of swaps outputting
 * Duplicate values are not allowed
 */

public class Heap {
	
	//global variable to count the number of swaps
	int count = 0;
	
	ArrayList<Integer> al = new ArrayList<Integer>();
	int index=1;
	
	
	public Heap(){
		//As recommended in the book, 
		//I add a null variable 0 to  al[0] to adjust for computation 
		al.add(0, 0000);
	}
	
	
	/*
	 * Inserting a new item into the current heap.  After insertion, 
	 * it prints the number of swaps that were made, which will be one with this top down method
	 * 
	 */
	public void insertItem(int newItem){
		count = 0;
		al.add(index, newItem);	
		if(index>1){
		
			this.heapify();
		}
		index++;
		
		
		if(count>0 && count<2){
			System.out.println("There was "+count+" swap ");
		}
		if(count>=2){
			System.out.println("There were "+count+" swaps");
		}
		

	}
	
	
	/*
	 * This method will analyze the heap 
	 * and adjust according to definitions of heap
	 */
	public void heapify(){
		boolean truth = false;
	
		
		for(int i=1; i<=Math.floor(al.size()/2);i++){
			
			int left = 2*i;
			int right = (2*i)+1;
			
			//System.out.println("Parent value: "+al.get(i) +", i: " +i +", left: " + left + ", right: " + right);
			//System.out.println(al.toString());
			
			
			//Determining the max number to swap and swapping it
			int maxToSwap =0;	
			if (right<al.size() && al.get(i)<al.get(right)){
				
				truth= true;
				 maxToSwap = Math.max(al.get(left), al.get(right));	
				
				if(al.get(left) == maxToSwap){
					int tempSwap = al.get(i);
					al.set(i, maxToSwap);
					al.set(left, tempSwap);
					count++;
					
					
				}else{
					int tempSwap = al.get(i);
					al.set(i, maxToSwap);
					al.set(right, tempSwap);
					count++;
					
				}
			}else if(left<al.size() && al.get(i)<al.get(left)){
				truth = true;
				maxToSwap = al.get(left);	
				int tempSwap = al.get(i);
				al.set(i, maxToSwap);
				al.set(left, tempSwap);
				count++;
			}			
				//System.out.println("swap"+al.toString()+"\n");
			
			//recursive call made to heapify the graph if a swap was previously made.
			if(truth == true){
				this.heapify();
			}
		}
	}
	
	/*
	 * Deletes the root node, returning it to the calling function. 
	 *  After deletion, the heap will be heapified
	 */
	public int deleteItem(){
		count = 0;
		al.remove(1);
		this.heapify();

		//Print the number of swaps
		if(count>0 && count<2){
			System.out.println("There was "+count+" swap");
		}
		if(count>=2){
			System.out.println("There were "+count+"swaps");
		}
		
		return al.get(1);
		
	}
	
	
	public boolean isEmpty(){
		if(al.size()>1){
			System.out.println("This is an not empty set");
			return true;
		}
		else{
			System.out.println("This is an empty set");
			return false;
		}
	}
	
	/*
	 * From my understanding, the heapsort sorts a 
	 * copy of the current heap returning it to the STDout, not affecting the original heap.
	 */
	
	public void heapSort(){
		Heap temp = new Heap();
		temp = this;
		temp.heapify();
		temp.printHeap();
		
		
		if(count>0 && count<2){
			System.out.println("There was "+count+" swap");
		}
		if(count>=2){
			System.out.println("There were "+count+"swaps");
		}
		
	}
	
	
	public void printHeap(){
		System.out.println(al.toString());
	}
	
	
	
	public static void main(String args[]){	
		Heap newHeap = new Heap();
		
		
		
	}
}
