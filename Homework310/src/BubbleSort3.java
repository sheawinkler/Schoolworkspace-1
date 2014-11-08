import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
import java.util.List;


public class BubbleSort3 {
	
	public BubbleSort3(){
		
	}
	

	public String[] loadFromFile(String anotherFile){
		File file = new File(anotherFile);
		List<String> myList = new ArrayList<String>();
		String[] arr = myList.toArray(new String[myList.size()]);

		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				 arr = line.split(",");	 
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return arr;
	}


	public void sort(int[] arrSort){
		int temp = 0;
		int size = arrSort.length;
		do{
			for(int i=0;i<(arrSort.length-1);i++){
				if(arrSort[i]>arrSort[i+1]){
					temp = arrSort[i+1];
					arrSort[i+1]=arrSort[i];
					arrSort[i]=temp;
				}else{		}
			}
			size = size-1;
		}while(size>0);
	
	}

	public static void main(String args[]){
		
		BubbleSort3 bs2 = new BubbleSort3();
		String test = "data/testone";
		
		bs2.loadFromFile(test);
		int[] arr2 = new int[bs2.loadFromFile(test).length];
		
		for(int i=0;i<bs2.loadFromFile(test).length;i++){
			arr2[i]=Integer.parseInt(bs2.loadFromFile(test)[i]);
		}
	
		bs2.sort(arr2);
		for(int i=0;i<arr2.length;i++){
			System.out.println(arr2[i]);
		}
	}
}
