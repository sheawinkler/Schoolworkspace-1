import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Mergesort {

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
	
    
	public static void mergeSort2(Integer[] array) {
		if(array.length < 2) {
			return;
		}
	
		int sizeOf = 1;
		
		
		int leftIndex, rightIndex;

		while(sizeOf < array.length) {
			leftIndex = 0;
			rightIndex = sizeOf;
			while(rightIndex + sizeOf <= array.length) {
				mergeArrays(array, leftIndex, leftIndex + sizeOf, rightIndex, rightIndex + sizeOf);
				leftIndex = rightIndex + sizeOf;
				rightIndex = leftIndex + sizeOf;
			}
	
			if(rightIndex < array.length) {
				mergeArrays(array, leftIndex, leftIndex + sizeOf, rightIndex, array.length);
			}
			sizeOf *= 2;
		}
	}

	// Merge
	public static void mergeArrays(Integer[] array, int leftFirst, int leftLast, int rightFirst, int rightLast) {
		
		
		
		int[] rightMerge = new int[rightLast - rightFirst + 1];
		int[] leftMerge = new int[leftLast - leftFirst + 1];

	//
		for(int i = 0, k = rightFirst; i < (rightMerge.length - 1); ++i, ++k) {
			rightMerge[i] = array[k];
		}
		
		for(int i = 0, k = leftFirst; i < (leftMerge.length - 1); ++i, ++k) {
			leftMerge[i] = array[k];
		}
		
		
		rightMerge[rightMerge.length-1] = Integer.MAX_VALUE;
		leftMerge[leftMerge.length-1] = Integer.MAX_VALUE;

		// Merging the two 
		for(int k = leftFirst, m = 0, n = 0; k < rightLast; ++k) {
			if(leftMerge[m] <= rightMerge[n]) {
				array[k] = leftMerge[m];
				m++;
			}
			else {
				array[k] = rightMerge[n];
				n++;
			}
		}
	}

	
	
	
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		String test = "data/sample";
		//String test = args[0];
		
		Integer[] array = loadFromFile(test);
		mergeSort2(array);
		
	     
	     
			try {
		          File file = new File(test+"-out.txt");
		          BufferedWriter output = new BufferedWriter(new FileWriter(file));
		          for(int i =0;i<array.length;i++){
		        	  output.write(Integer.toString(array[i]));
		        	  
		        	  if(i<array.length-1){
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
