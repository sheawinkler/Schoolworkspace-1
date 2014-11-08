import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Quicksort {
	
	public Quicksort(){
	}
	

	private static Integer[] Quicksort(Integer[] container, int l, int r) {
		
		if(l<r){
			
			int s= lomutoPartition(container, l, r);
			
			Quicksort(container,l,s-1);
			Quicksort(container,s+1,r);
			
			
		}
	
		return container;
	}

	
	//Standard parse file for array manipulation
	public static Integer[] loadFromFile(String anotherFile){
		Integer[] arr=new Integer[0];
		
		File file = new File(anotherFile);
		List<String> myList = new ArrayList<String>();
		String[] t = myList.toArray(new String[myList.size()]);
		int count = 0;

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line= new String();
				if(count==0){
					 int lineLength = Integer.parseInt(scanner.nextLine());
					 count++;
				}else{
			    line = scanner.nextLine();
				t = line.split(",");
			
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		arr= new Integer[t.length];                                      
		for(int i = 0; i < t.length; i++)
		{
			arr[i] = Integer.parseInt(t[i]);
			
		}
		return arr;
	}
	
	public static int lomutoPartition(Integer[] sortList, int left, int right){
		int p = sortList[left];
		int s = left;
		int temp = 0;
		
		for(int i=left+1;i<=right;i++){
			if(sortList[i]<p){
				s = s+1;
				//Swap A[s] A[i]
				temp = sortList[s];
				sortList[s]= sortList[i];
				sortList[i]=temp;
			}
			
		}
		temp = sortList[left];
		sortList[left]= sortList[s];
		sortList[s]=temp;
		return s;
	}
	/*
	public static int hoarePartition(Integer[] sortList, int left, int right){
		
		int p = sortList[left];
		int i =left;
		int j = right;
		int temp =0;
		
		do{
			do{
				i++;
			}while(i< j && sortList[i]<p );
	
			do{
				j--;
			}while(j>0 && sortList[j]>p );
			
				temp = sortList[j];
				sortList[j]= sortList[i];
				sortList[i]=temp;
		}while(i<j);
		
		
		//Swap A[i] A[j]
		temp = sortList[j];
		sortList[j]= sortList[i];
		sortList[i]=temp;
		
		
		//Swap A[l] A[j]
		temp = sortList[j];
		sortList[j]=sortList[left];
		sortList[left]=temp;
		
		return j;
		
	}
	*/
	

	
	
	public static void main(String args[]){
		long startTime = System.currentTimeMillis();
		
		String test = "data/sample";
		//String test = args[0];

		
		//qs is the array arr loaded from the file
		
		Integer[] container = loadFromFile(test);
		container = Quicksort(container, 0, container.length-1);
		
		//Testing
		/*
		for(int i =0;i<container.length;i++){
			System.out.println(container[i]);
		}
		*/
		
		
		//write container to file comma separated
		
		try {
	          File file = new File(test+"-out.txt");
	          BufferedWriter output = new BufferedWriter(new FileWriter(file));
	          for(int i =0;i<container.length;i++){
	        	  output.write(Integer.toString(container[i]));
	        	  
	        	  if(i<container.length-1){
	        		  output.append(",");
	        	  }
	        	  
	          }
	          output.close();
	        } catch ( IOException e ) {
	           e.printStackTrace();
	        }
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		
	}
	
	
}
