import java.io.*;
import java.util.*;
import java.sql.*;

public class gradingBook {

/**
* @param args
*/
	
	
		public static double calculateLetter(double grade){
		  
		if( grade>=0 && grade<=60){
			System.out.println("F");
		}
		else if( grade>=60 && grade<=63){
			System.out.println("D-");	
		}
		else if( grade>=63 && grade<=67){
			System.out.println("D");	
		}
		else if( grade>=67 && grade<=70){
			System.out.println("D+");
		}
		else if( grade>=70 && grade<=73){
			System.out.println("C-");		
		}			
		else if( grade>=73 && grade<=77){
			System.out.println("C");	
		}
		else if( grade>=77 && grade<=80){
			System.out.println("C+");
		}
		else if( grade>=80 && grade<=83){
			System.out.println("B-");
		}	
		else if( grade>=83 && grade<=87){
			System.out.println("B");
		}
		else if( grade>=87 && grade<=90){
			System.out.println("B+");	
		}
		else if( grade>=90 && grade<=94){
			System.out.println("A-");		
		}
		else if ( grade>=94 && grade<=100){
			System.out.println("A");		
		}
		return 0;													
	}
	
	public static void main(String[] args) throws IOException {
			 //gradingBook example = new gradingBook();

          Scanner d = null;	//reading from file exam.dat and loading into array
	       int total = 0;  //Variable total represents number of exams in class
	       double [] examScores;
	       double [] examWeight;
			 Scanner s = null;
			 String [] lastName;
			 String [] firstName;
			 double [][] studentGrades;
			 double [] overallScore;
			 String finalGrade = "";
			 int counter = 0;
			 int userDecision=0;
			 String userInput ="";
		
		//mysql connection	 
	    Connection con = null;
	    ResultSet rs=null;
	    Statement statement = null;
	    String url = "jdbc:mysql://cse.unl.edu/";
	    String db = "dsimpson";
	    String driver = "com.mysql.jdbc.Driver";
	    String user = "dsimpson";
	    String pass = "t64__W";
	    boolean check = true;
	    int controlFlow = 0;
	    
		    try{
	        Class.forName(driver);
	        con = DriverManager.getConnection(url+db, user, pass);
		       	 try {
			       	statement = con.createStatement();
		            DatabaseMetaData dbm = con.getMetaData();
		            String[] types = {"TABLE"};
		        
		            rs = dbm.getTables(null,null,"%",types);
		            System.out.println("Table name:");
		            while (rs.next()){
		              String table = rs.getString("TABLE_NAME");
		              System.out.println(table);
		            }
		       	 	try{
		       		  d = new Scanner(new BufferedReader(new FileReader("exam.dat")));
				 		 	total = d.nextInt();
							examScores = new double[total];
						    examWeight = new double[total];
						 	for(int j = 0; j < total; j++){
						 		 while (d.hasNext()) {
										examScores[j] = d.nextDouble();
										examWeight[j] = d.nextDouble();
								 	j++;
		     		 			 }
					     }
				  	  }finally{
		          		  if (d != null){
		              		  d.close();
		           		  }
		       		}//End of loading from exam.dat
				  	  
					try {
						 s = new Scanner(new BufferedReader(new FileReader("student.dat")));
						 //Variable counter represents number of students in class
		
						 while(s.hasNextLine()){
						 	String test = s.nextLine();
						 	counter++;
						 }
						 s.close();
						 s = new Scanner(new BufferedReader(new FileReader("student.dat")));
						 //Array represents a student
							studentGrades = new double[counter][total];	
							lastName = new String[counter];
							firstName = new String[counter];
							overallScore = new double[counter];
							//iterating through total count from the list
							for(int i = 0; i < counter; i++){
								//holding person on student.dat
											lastName[i] = s.next();
											firstName[i] = s.next();
											for(int m =0; m < total; m++){
												studentGrades[i][m] = s.nextDouble();
												overallScore[i]+= (examWeight[m]/100)*(studentGrades[i][m]/examScores[m])*100;
									      }
												calculateLetter(overallScore[i]);
												System.out.println(overallScore[i]);					
							}
					}finally {
						 if (s != null){
							s.close();
						 }
					 }	//End of reading from student file 
	          }
	          catch (SQLException t){
	            System.out.println("Not any table in the database");
	          }
		      finally{
		        con.close();
		      }
	        }
	        catch (Exception e){
	          e.printStackTrace();
	        }

	     
					
					
				System.out.println("You can view student information, add students, and run the payroll using this system.");
				System.out.println("Please select one of the following options (1-5):");
				System.out.println("1. Print Grade Report for All Student\n2. Run Grade Roster for the Course\n3. Print Statistics for an Exam\n4. Print Statistics for Final Course Grade\n5. Quit\n");
				Scanner choice = new Scanner(System.in);
				
				//Choosing event case
				String quitVariable = "QUIT";
				String userOption = choice.next().toUpperCase();
				if(userOption.equals(quitVariable)){
								System.out.println("Thank you for using the Grading System");
				 				System.exit(0);		
				}
					int myChoice = Integer.parseInt(userOption);
					switch(myChoice){
						case 1:
											double studentAverages = 0.00;
											for(int p=0;p<counter;p++){
												studentAverages += overallScore[p];
											}
											studentAverages = Math.rint((studentAverages/counter)*100.0)/100.0;
											System.out.println("Total number of Students: " + counter + "\nAverage Score: " + studentAverages);
											Formatter formatter = new Formatter(System.out);
											
											System.out.print("   ");
											System.out.format("%6s   %6s","LastName","FirstName");
											for(int v=0; v<total;v++){
												System.out.format("   %6s","Exam"+(v+1));
											}
											System.out.format("  %6s   %6s"," Final Grade","Overall %\n");
										  
											for(int j=0;j<counter;j++){
												System.out.format("  %6s   %6s",lastName[j],firstName[j]);
												for(int w=0;w<total;w++){
													System.out.format("    %6.2f ",studentGrades[j][w]);
												}
												overallScore[j] = Math.rint((overallScore[j])*100.0)/100.0;
												System.out.format("%6.2f %6.2s\n",overallScore[j],calculateLetter(overallScore[j]));
											}
								break;
						case 2:
								break;
						case 3:
										   Scanner e = new Scanner(System.in);
											System.out.println("Please enter a valid exam(1-"+total+"): ");
											userInput = e.next().toUpperCase();
											int inputOptions = Integer.parseInt(userInput);	
											if(inputOptions<total && inputOptions>1){
												System.out.println("Statistics for Exam "+inputOptions+" is:");
											}
								break;
						case 4:
								
								break;
						case 5:
								System.out.println("Thank you for using the Grading System");
				 				System.exit(0);
								break;
						}
					System.out.println("\nThank you for using the Grading System");
					System.exit(0);
			 }
		}
			 
	
	
	
			
		// TODO Auto-generated method stub


	
	

	
