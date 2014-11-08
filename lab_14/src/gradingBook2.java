import java.io.*;
import java.util.*;
import java.sql.*;

public class gradingBook2 {
	public static void main(String[] args) throws IOException {
		
		int total =0;
		int[][] exams = null;
		String[][] students = null;
		int weighting = 0;
		int option =0;
		
		FileReader file = new FileReader("exam.dat");
		Scanner scan = new Scanner(file);
		int count =0;
		while(scan.hasNext()){
			if(scan.hasNextInt()){
				if (total ==0){
					total = scan.nextInt();
					exams= new int[total][2];
				}else{
					exams[(int)(count / 2)][count % 2] = scan.nextInt();	// assign total points and weight to an array
					count++;
				}
			} else{
				break;
			}
		}
			System.out.println(total);
			System.out.println(exams.length);
			file.close();
			System.out.println(exams.length);
		for(int i=0; i< exams.length; i++){
			weighting += exams[i][1];
		}
		if(weighting != 100){
			option =5;
			System.out.println("Error, please recalculate weights");
		}
		
	   	  	  
	}
}
