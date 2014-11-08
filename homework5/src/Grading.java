import java.io.*;
//import java.util.Formatter;
import java.util.Scanner;
import java.sql.*;

public class Grading {
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
    int totalExams =0;
    
    
    //made a nonstatic reference
    public void fileToDatabase(){
	    try{
	        Class.forName(driver);
	        try{
		        con = DriverManager.getConnection(url+db, user, pass);
		        
		        //testing connection by listing tables
		    	statement = con.createStatement();

	           
	            statement.executeUpdate("TRUNCATE TABLE exams");
		    	statement.executeUpdate("TRUNCATE TABLE students");
		    	statement.executeUpdate("INSERT INTO exams(testID,score,weight) VALUES(3, 50, 7)");
		    	statement.executeUpdate("TRUNCATE TABLE exams");
		    	statement.executeUpdate("TRUNCATE TABLE students");
		    	
		    	// exporting information from exam.dat to dsimpson mysql database
		    	File exam = new File("exam.dat");
		    	Scanner scanner = null;
		    	try{
		    		scanner = new Scanner(exam);
		    	}catch(FileNotFoundException t){
		    		t.printStackTrace();
		    	}
		    	int totalExams = scanner.nextInt();
		    	int noExams =1;
		    	int noStudents =1;
		    	while(scanner.hasNext()){
		    		statement.executeUpdate("INSERT INTO exams(testID, score, weight) VALUES ("+noExams+","+scanner.nextInt()+","+scanner.nextInt()+")");
		    		noExams++;
		    	}
				ResultSet set = statement.executeQuery("SELECT SUM(`weight`) FROM exams");
				set.next();
				String totalWeight = set.getString(1);
				//Calculating total weight and adding info to student column
				if(totalWeight.equals("100")){
					File student = new File("student.dat");
					Scanner studentScan = null;
					try{
						studentScan = new Scanner(student);
					}catch(FileNotFoundException e){
						e.printStackTrace();
					}
					while(studentScan.hasNext()){
						statement.executeUpdate("INSERT INTO students (firstName,lastName, first, second, third, fourth) VALUES ("+"'"+studentScan.next()+"'"+","+"'"+studentScan.next()+"'"+","+studentScan.nextInt()+","+studentScan.nextInt()+","+studentScan.nextInt()+","+studentScan.nextInt()+")");
						noStudents++;
					}
					System.out.println("Database  information added");
					//con.close();
				}
				else{
					System.out.println("Exam weights do not total to 100");
				}
			} catch (SQLException e) {	
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    
    public void userInput(){
		System.out.println("\nYou can view student information, add students, and run the grading using this system.");
		System.out.println("Please select one of the following options (1-5):");
		System.out.println("1. Print Grade Report for All Student\n2. Run Grade Roster for the Course\n3. Print Statistics for an Exam\n4. Print Statistics for Final Course Grade\n5. Quit\n");
		
		Scanner choice = null;
		choice = new Scanner(System.in);
		
		//Choosing event case
		String quitVariable = "QUIT";
		String userOption = choice.next().toUpperCase();
		if(userOption.equals(quitVariable)){
						System.out.println("Thank you for using the Grading System");
		 				System.exit(0);		
		}
			int myChoice = Integer.parseInt(userOption);
		try{
			switch(myChoice){
			case 1:
				System.out.println("option 1");
				optionOne();
				userInput();
				break;
			case 2:
				System.out.println("option 2");
				optionTwo();
				userInput();
				break;
			case 3:
				System.out.println("option 3");
				optionThree();
				userInput();
				break;
			case 4:
				System.out.println("option 4");
				optionFour();
				userInput();
				break;
			case 5:
				System.out.println("option 5");
				optionFive();
				userInput();
				break;
			}
		}catch (Exception e){
	          e.printStackTrace();
        }
    }
    
    public void optionOne() throws SQLException, ClassNotFoundException{

        ResultSet noOfStudents = statement.executeQuery("SELECT COUNT(`testID`) FROM exams");
        noOfStudents.next();
        String totalStudents = noOfStudents.getString(1);
        System.out.println("Total number of students: " + totalStudents);
        
        //ResultSet averageScore = statement.executeQuery("");
        System.out.println("Average score: ");
		System.out.print("   ");
		System.out.format("%6s   %6s","LastName","FirstName");
		System.out.print("   ");
		System.out.format("  %6s   %6s"," Final Grade","Overall %\n");

    }//End optionOne
    
    public static void optionTwo(){
		System.out.print("   ");
		System.out.format("%6s   %6s","LastName","FirstName");
		System.out.print("   ");
		System.out.format("%6s", "Final Grade\n");
    }
    
    public static void optionThree(){
    	
    }
 
    public static void optionFour(){
    	
    }
 
    public void optionFive()throws SQLException, ClassNotFoundException{
    	System.out.println("Thank you for using the grading system");
        con.close();
    	System.exit(1);
    }
    
	public static void main(String[] args) throws IOException {
		Grading grades = new Grading();
		grades.fileToDatabase();
		grades.userInput();

	}
}
