import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/* Deverick Simpson
 * BubbleSort Implementation 
 * CSCE 310 Fall 2014
 * File uses constructor to read file and construct a list of integers to be sorted.
 * */
public class BubbleSort {
	
	static List<Integer> myList = new ArrayList<Integer>();
	
	BubbleSort(String fileName){
		String newFilename = fileName+".txt";

		File file = new File(newFilename);
		try {
			Scanner scanner = new Scanner(file).useDelimiter(",");
			while (scanner.hasNextLine()) {
				myList.add(scanner.nextInt()); 
			}
		} catch (FileNotFoundException e) {
			// Catch Block
			e.printStackTrace();	
		}	
	}
	 
	//Sort algorithm takes no paramaters and outputs the sorted list to Fileout.txt in the current directory
		public void sort(){
			int temp = 0;
			int size = myList.size();
			Object[] arr = myList.toArray();
		
			do{
				for(int i=0;i<(arr.length-1);i++){
					if(Integer.parseInt(arr[i].toString())>Integer.parseInt(arr[i+1].toString())){
						temp = (Integer) arr[i+1];
						arr[i+1]=arr[i];
						arr[i]=temp;
					}else{		}
				}
				size = size-1;
			}while(size>0);

			try {
				FileWriter fstream = new FileWriter("filename-Out.txt");
				BufferedWriter out = new BufferedWriter(fstream);
				for(int k=0;k<myList.size();k++){
					out.write((Integer) arr[k]+",");
					
				}
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Error: " + e.getMessage());
			}
		}
		
		/*This area is strictly used for testing purposed and may be 
		 * uncommented to directly compile and run program.
		 * 	
		public static void main(String args[]){
			String test = "data/filename";
			BubbleSort bs2 = new BubbleSort(test);
			bs2.sort();
		}
		 */
}
