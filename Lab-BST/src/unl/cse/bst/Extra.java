package unl.cse.bst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Extra {
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner read = new Scanner(new File("/Users/Deverick/Desktop/bonus/ncaaStadiumDistances.csv"));
		
		ArrayList<Integer> to = new ArrayList<Integer>();
		ArrayList<Integer> from = new ArrayList<Integer>();
		ArrayList<Double> distance = new ArrayList<Double>();
		while (read.hasNext()){
			String[] arr = read.nextLine().split(",");
			to.add(Integer.parseInt(arr[0]));
			from.add(Integer.parseInt(arr[1]));
			distance.add(Double.parseDouble(arr[2]));
		}
		
		System.out.println(distance);
	}
}