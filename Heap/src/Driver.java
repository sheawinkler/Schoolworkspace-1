
public class Driver {

	
	public static void main(String args[]){
		
		long startTime = System.currentTimeMillis();
		
		
		Heap newHeap = new Heap();
		newHeap.isEmpty();
		newHeap.insertItem(20);
		newHeap.printHeap();
		newHeap.insertItem(40);
		newHeap.printHeap();
		newHeap.insertItem(50);
		newHeap.printHeap();
		newHeap.insertItem(60);
		newHeap.printHeap();
		newHeap.isEmpty();
		newHeap.insertItem(70);
		newHeap.insertItem(80);
		newHeap.insertItem(90);
		newHeap.printHeap();
		newHeap.heapSort();
		newHeap.printHeap();
	
		
	
		
		
		
		
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		

	}
}
