/**
 * EmployeeDirectorySystem class works as 
 * the main controlling system for 
 * accessing full time employee objects.
 * CSCE 155 Fall 2009
 * Assignment 2
 * @author
 * @version
 */

// import statements
import java.io.*;
import java.util.*;
import java.lang.*;

public class EmployeeDirectorySystem  {
    
    // -------------------------------------------------------------------------
    // You may add more data members to the following to describe a 
	// directory system.
    // -------------------------------------------------------------------------
    
    // private data members -- variables
	 FullTimeEmployee[] employee;
	 private String dataString;
	 private String dataString2;
	
    
    // -------------------------------------------------------------------------
    // Here are the public and private methods that specify the system.
    // First of all, a employee object will provide information for you, will
    // allow you to change its settings, and will also do quite a bit of other
    // things.  You may add new methods.
    // -------------------------------------------------------------------------
    
    /** Constructor
     *  initialize all private data members to appropriate values
     *  If you add more data members, you will have to initialize them here
     *  too.
     */
    public EmployeeDirectorySystem()  {  

		employee = new FullTimeEmployee[12];
		
      employee[0] = new FullTimeEmployee();
   	employee[1] = new FullTimeEmployee();
    	employee[2] = new FullTimeEmployee();
   	employee[3] = new FullTimeEmployee();
   	employee[4] = new FullTimeEmployee();
   	employee[5] = new FullTimeEmployee();
    	employee[6] = new FullTimeEmployee();
   	employee[7] = new FullTimeEmployee();
    	employee[8] = new FullTimeEmployee();
		employee[9] = new FullTimeEmployee();
		employee[10] = new FullTimeEmployee();
		employee[11] = new FullTimeEmployee();
    }  // end constructor
    
    
    //--------------------------------------------------------------------------
    // Please Complete the runPayroll method below
    // This method will run individual payrolls on the employee depending on 
    // the choice entered by the user.
    //--------------------------------------------------------------------------
    public void dataString(){
	 	System.out.println("Please enter all or part of the employee name, ID, or phone number to view the employee information.");
		dataString = readString();
	 }
	 	    
	 public void runDirectory(){
			int i = 0;
			int numberOfCharacters = 0;
			int count = 0;
			
			while ( i < 12 ) {
				    if(employee[i].getEmployeeName().substring(0,numberOfCharacters-1).equals(dataString))
	 						count++;


				if ("Quit".equalsIgnoreCase(dataString)) {
					System.exit(0);
				}

				else if ("Redo".equalsIgnoreCase(dataString)) {
					dataString = "";
					dataString();
				} 
			
		   	while (count == 0) {
					System.out.println("No match found");
					System.exit(0);
				} 
		
				 if ( count >= 1) {
					System.out.println("Please enter another character");
					dataString2 = readString();
					dataString = (dataString + dataString2);
				}
				
				 if (count == 1){
					numberOfCharacters = dataString.length();
					for (int j=0; j < numberOfCharacters; j++){
						employee[i].display();
					}
				}
				i ++;
			}
 		// 1. Get value from the user
		
		// 2. Determine if you can find a specific employee, if not, ask the 
    	//    user for more information to help determine the employee.
		
		// 3. Once determined, display all of the information regarding 
    	//    the employee.

    }//end of runDirectory
	

    /**
     * This method displays a welcome message to the user.
     */
    public void displayWelcome()  {
        
    	/* Display a brief welcome message about the system */
    	System.out.println("Welcome to the CSE Employee Directory");
   	System.out.println("You can view information about an employee by using this system");
        
    }  // end displayWelcome
    
    /**
     * This method displays a goodbye message to the user.
     */
    public void displayGoodbye()  {
        
        System.out.println("Have a great day!");
        
    }  // end displayGoodbye
    
    /**
     * This method loads the employee information.  
     */
    public void loadData()  {
    	employee[0].setEmployeeName("Jeffery Johnson");
    	employee[0].setEmployeeID("A001");
    	employee[0].setDateOfBirth(new GregorianCalendar(1978, Calendar.JUNE, 14));
    	employee[0].setStartDate(new GregorianCalendar(2006, Calendar.AUGUST, 1));
    	employee[0].setPhoneNumber("402-486-5104");
    	employee[0].setStreetAddress("123 14th Street");
    	employee[0].setCity("Lincoln");
    	employee[0].setState("Nebraska");
    	employee[0].setZIP(68588);
    	employee[0].setMonthlySalary(1400);
		employee[0].setSearchString("Jeffery Johnson A001 402-486-5104");

    	employee[1].setEmployeeName("Jeffery Smith");
    	employee[1].setEmployeeID("B002");
    	employee[1].setDateOfBirth(new GregorianCalendar(1973, Calendar.SEPTEMBER, 12));
    	employee[1].setStartDate(new GregorianCalendar(1999, Calendar.JANUARY, 3));
    	employee[1].setPhoneNumber("402-357-5104");
    	employee[1].setStreetAddress("321 4th Street");
    	employee[1].setCity("Seward");
    	employee[1].setState("Nebraska");
    	employee[1].setZIP(68801);
    	employee[1].setMonthlySalary(1350);
		employee[1].setSearchString("Jeffery Smith B001 402-357-5104");
    	
    	employee[2].setEmployeeName("Jessica Smith");
    	employee[2].setEmployeeID("A303");
    	employee[2].setDateOfBirth(new GregorianCalendar(1974, Calendar.NOVEMBER, 21));
    	employee[2].setStartDate(new GregorianCalendar(2003, Calendar.FEBRUARY, 14));
    	employee[2].setPhoneNumber("402-408-6693");
    	employee[2].setStreetAddress("220 Wenzel Circle");
    	employee[2].setCity("Eagle");
    	employee[2].setState("Nebraska");
    	employee[2].setZIP(68347);
    	employee[2].setMonthlySalary(2200);
		employee[2].setSearchString("Jessica Smith A303 402-408-6693");
    
    	employee[3].setEmployeeName("Jeremy Suing");
    	employee[3].setEmployeeID("X001");
    	employee[3].setDateOfBirth(new GregorianCalendar(1975, Calendar.JUNE, 5));
    	employee[3].setStartDate(new GregorianCalendar(2005, Calendar.MAY, 16));
    	employee[3].setPhoneNumber("402-472-1658");
    	employee[3].setStreetAddress("640 N. 14th Street");
    	employee[3].setCity("Lincoln");
    	employee[3].setState("Nebraska");
    	employee[3].setZIP(68588);
    	employee[3].setMonthlySalary(50);
		employee[3].setSearchString("Jeremy Suing X001 402-472-1658");

    
    	employee[4].setEmployeeName("Sally Smith");
    	employee[4].setEmployeeID("B001");
    	employee[4].setDateOfBirth(new GregorianCalendar(1980, Calendar.JANUARY, 11));
    	employee[4].setStartDate(new GregorianCalendar(2006, Calendar.AUGUST, 1));
    	employee[4].setPhoneNumber("402-357-3798");
    	employee[4].setStreetAddress("55894 893rd Road");
    	employee[4].setCity("Fremont");
    	employee[4].setState("Nebraska");
    	employee[4].setZIP(68321);
    	employee[4].setMonthlySalary(1400);
		employee[4].setSearchString("Sally Smith B001 402-357-3798");

    
    	employee[5].setEmployeeName("John Johnson");
    	employee[5].setEmployeeID("B010");
    	employee[5].setDateOfBirth(new GregorianCalendar(1979, Calendar.JUNE, 14));
    	employee[5].setStartDate(new GregorianCalendar(2000, Calendar.AUGUST, 1));
    	employee[5].setPhoneNumber("402-486-5110");
    	employee[5].setStreetAddress("123 14th Street");
    	employee[5].setCity("Lincoln");
    	employee[5].setState("Nebraska");
    	employee[5].setZIP(68588);
    	employee[5].setMonthlySalary(1450);
		employee[5].setSearchString("John Johnson B010 402-486-5110");
    
    	employee[6].setEmployeeName("Sarah Smith");
    	employee[6].setEmployeeID("B200");
    	employee[6].setDateOfBirth(new GregorianCalendar(1974, Calendar.OCTOBER, 14));
    	employee[6].setStartDate(new GregorianCalendar(1997, Calendar.JANUARY, 31));
    	employee[6].setPhoneNumber("402-408-5104");
    	employee[6].setStreetAddress("321 4th Street");
    	employee[6].setCity("Utica");
    	employee[6].setState("Nebraska");
    	employee[6].setZIP(68701);
    	employee[6].setMonthlySalary(1550);
		employee[6].setSearchString("Sarah Smith B200 402-408-5104");
    
    	employee[7].setEmployeeName("John Doe");
    	employee[7].setEmployeeID("A678");
    	employee[7].setDateOfBirth(new GregorianCalendar(1981, Calendar.MARCH, 28));
    	employee[7].setStartDate(new GregorianCalendar(1998, Calendar.MARCH, 2));
    	employee[7].setPhoneNumber("303-804-1169");
    	employee[7].setStreetAddress("6009 Kingsley Ave.");
    	employee[7].setCity("Littleton");
    	employee[7].setState("Colorado");
    	employee[7].setZIP(80104);
    	employee[7].setMonthlySalary(4100);
		employee[7].setSearchString("John Doe A678 303-804-1169");
    
    	employee[8].setEmployeeName("Tad Jacobs");
    	employee[8].setEmployeeID("X222");
    	employee[8].setDateOfBirth(new GregorianCalendar(1975, Calendar.JULY, 1));
    	employee[8].setStartDate(new GregorianCalendar(2003, Calendar.AUGUST, 16));
    	employee[8].setPhoneNumber("719-555-5555");
    	employee[8].setStreetAddress("7979 Technology Way");
    	employee[8].setCity("Denver");
    	employee[8].setState("Colorado");
    	employee[8].setZIP(80237);
    	employee[8].setMonthlySalary(3333);
		employee[8].setSearchString("Tad Jacobs X222 719-555-5555");
    
    	employee[9].setEmployeeName("Ella Roberts");
    	employee[9].setEmployeeID("B501");
    	employee[9].setDateOfBirth(new GregorianCalendar(1983, Calendar.SEPTEMBER, 4));
    	employee[9].setStartDate(new GregorianCalendar(2006, Calendar.MAY, 10));
    	employee[9].setPhoneNumber("402-472-1100");
    	employee[9].setStreetAddress("5567 Adams Street");
    	employee[9].setCity("Lincoln");
    	employee[9].setState("Nebraska");
    	employee[9].setZIP(68521);
    	employee[9].setMonthlySalary(2400);
		employee[9].setSearchString("Ella Roberts B501 402-472-1100");
    	
    	employee[10].setEmployeeName("Ellen Smith");
    	employee[10].setEmployeeID("A501");
    	employee[10].setDateOfBirth(new GregorianCalendar(1982, Calendar.AUGUST, 24));
    	employee[10].setStartDate(new GregorianCalendar(2001, Calendar.MARCH, 19));
    	employee[10].setPhoneNumber("402-472-2200");
    	employee[10].setStreetAddress("567 9th Street");
    	employee[10].setCity("Lincoln");
    	employee[10].setState("Nebraska");
    	employee[10].setZIP(68520);
    	employee[10].setMonthlySalary(3400);
		employee[10].setSearchString("Sally Smith B001 402-357-3798");
    
    	employee[11].setEmployeeName("Bobby Smith");
    	employee[11].setEmployeeID("B555");
    	employee[11].setDateOfBirth(new GregorianCalendar(1983, Calendar.DECEMBER, 4));
    	employee[11].setStartDate(new GregorianCalendar(2006, Calendar.OCTOBER, 10));
    	employee[11].setPhoneNumber("402-470-1200");
    	employee[11].setStreetAddress("9876 34th Ave.");
    	employee[11].setState("Nebraska");
    	employee[11].setZIP(68527);
    	employee[11].setMonthlySalary(240);
		employee[11].setSearchString("Bobby Smith B555 402-470-1200");
    
    }  // end loadData
    
    /**
     * This method reads an integer and
     * returns that integer to the caller of this method.
     */
    private int readInteger()  {
        
        int temp = 0;
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            temp = scanner.nextInt();  // read integer
        }  catch (InputMismatchException ex) {
            System.out.println(ex);
        }
        
        return temp;
        
    }  // end readInteger
    
    /**
     * This method reads in a string and returns that string to the caller of
     * this method.
     */
    private String readString()  {
        
        String userInput = "";
        
        Scanner scanner = new Scanner(System.in);
        
        userInput = scanner.nextLine();
        
        return userInput;
        
    }  // end readString

    /**
     * This main method creates an object of the EmployeeDirectorySystem class 
     * and runs the Employee Directory System. 
     *
     * First, it asks the EmployeeDirectorySystem object to display a welcome 
     * message. Then it loads the employee data. Next, it asks the 
     * EmployeeDirectorySystem object to run the directory. Finally, it asks 
     * the EmployeeDirectorySystem object to display a goodbye message.
     */
    public static void main(String[] args)  {

    	EmployeeDirectorySystem mySystem = new EmployeeDirectorySystem();
    	mySystem.displayWelcome();
    	mySystem.loadData();
		mySystem.dataString();
    	mySystem.runDirectory();
    	mySystem.displayGoodbye();
                                     
    }  // end main
}  // end Class EmployeeDirectorySystem
