package unl.cse.lists;

public class MyIntegerArrayList {

	private static final int SIZE = 10;
	
	private Integer arr[];
	private int size;
	
	public MyIntegerArrayList() {
		this.arr = new Integer[SIZE];
		this.size = 0;
	}

	public Integer getElementAtIndex(int index) {
		if(index < 0 || index >= size) 
			throw new IllegalArgumentException("index = "+index+" is out of bounds");
		else
			return this.arr[index];
	}
	
	public void removeElementAtIndex(int index) {

		if(index < 0 || index >= size) 
			throw new IllegalArgumentException("index = "+index+" is out of bounds");

		//shift elements 
		for(int i=index; i<size-1; i++) {
			this.arr[i] = this.arr[i+1];
		}
		this.size--;
	}
	
	public void addElementAtEnd(Integer element) {

		if(size == arr.length) {
			//resize
			Integer tmp[] = new Integer[arr.length + SIZE];
			for(int i=0; i<arr.length; i++) {
				tmp[i] = arr[i];
			}
			arr = tmp;
		}

		this.arr[size] = element;
		this.size++;
	}
	
	public int getSize() {
		return this.size;
	}
	
	@Override
	public String toString() {
		if(this.size == 0) {
			return "[empty]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0; i<this.size-1; i++) {
			sb.append(this.arr[i]);
			sb.append(", ");
		}
		sb.append(this.arr[this.size-1]);
		sb.append("]");
		return sb.toString();
	}
}
