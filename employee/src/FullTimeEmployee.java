/*
 * FullTimeEmployee.java
 *
 * CSCE 155 Fall 2009
 * Assignment 2
 * @author
 * @version
 */

// import statements
import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Used to store information of the full time employee.  It can also be used
 * to calculate the pay for a full time employee.
 * 
 * @author
 * @version
 */

public class FullTimeEmployee {
    
    // -------------------------------------------------------------------------
    // You may add more data members to the following to describe a Full Time 
	// Employee.  You may need to remove some data members as well.
    // -------------------------------------------------------------------------
 
    
    //-------------Declare private variables-----------------------------------
    
    /**
     * Represents the name for the employee
     */
    private String 	employeeName; 	
	 
    /**
     * Represents the amount in dollars of the salary for the employee
     */
    private int 	monthlySalary; 	
	 
    /**
     * Represents the date of employment
     */
    private GregorianCalendar 	startDate; 
	 
	 /**
	  * Represents the ID for the employee
	  */
	 private String employeeID;
	 
	 /**
	  * Represents the phone number of the employee
	  */
	 private String phoneNumber;
	 
	 /**
	  * Represents the street address of the employee
	  */
	 private String streetAddress;
	 
    /**
	  * Represents the city of the employee
	  */
	 private String city;
	 
	 /**
	  * Represents the state of the employee
	  */
	 private String state;
	 
    /**
	  * Represents the zip of the employee
	  */
	 private int zip;
	 
	 /**
	  * Represents the date of birth of the employee
	  */
	 private GregorianCalendar dateOfBirth;	 
	 
	 /**
	  * Represents the date of birth of the employee
	  */
	 private String searchString;
	 
	 
	 		
        
    /**
     * Constructor used to create this object.  Responsible for setting
     * all of this object's information to their corresponding default values
     */
    public FullTimeEmployee(){
        this.employeeName = "";
		  this.employeeID = "";
		  this.phoneNumber = "";
		  this.streetAddress = "";
		  this.city = "";
		  this.state = "";
		  this.zip = 0;
		  this.monthlySalary = 0;
		  this.searchString = "";
		  
        
    }//end of constructor
    
    
    //-------------------------------------------------------------------------
    //Please complete the following get and set methods
    //Some may need to be added or removed.
    //------------------------------------------------------------------------

     /**
     * Returns the employee's name from this object 
     * @return <code>String</code> Name of the Employee represented in object
     */
	public String getEmployeeName() {
		return employeeName;
	}
	
	  /**
     * Returns the employee's ID from this object 
     * @return <code>String</code> ID of the Employee represented in object
     */
	public String getEmployeeID() {
		return employeeID;
	}
	
     /**
     * Returns the employee's date of birth from this object 
     * @return <code>String</code> Date of birth of the Employee represented in object
     */
	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}
	
     /**
     * Returns the employee's name from this object 
     * @return <code>String</code> Name of the Employee represented in object
     */
	public GregorianCalendar getStartDate() {
		return startDate;
	}
	
     /**
     * Returns the employee's phone number from this object 
     * @return <code>String</code> Phone number of the Employee represented in object
     */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
     /**
     * Returns the employee's address from this object 
     * @return <code>String</code> Address of the Employee represented in object
     */
	public String getStreetAddress() {
		return streetAddress;
	}
	
     /**
     * Returns the employee's city from this object 
     * @return <code>String</code> City of the Employee represented in object
     */
	public String getCity() {
		return city;
	}
	
	  /**
     * Returns the employee's state from this object 
     * @return <code>String</code> State of the Employee represented in object
     */
	public String getState() {
		return state;
	}
	
	  /**
     * Returns the employee's zip from this object 
     * @return <code>String</code> Zip of the Employee represented in object
     */
	public int getZIP() {
		return zip;
	}
	
	  /**
     * Returns the employee's monthly salary from this object 
     * @return <code>String</code> Monthly salary of the Employee represented in object
     */
	public int getMonthlySalary() {
		return monthlySalary;
	}
	
	public String getSearchString() {
		return searchString;
	}

     /**
     * Sets the employee name represented by this object
     * @param employeeName the name of the employee
     */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	  /**
     * Sets the employee ID represented by this object
     * @param employeeID the ID of the employee
     */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	  /**
     * Sets the employee date of birth represented by this object
     * @param dateOfBirth the date of birth of the employee
     */
	public void setDateOfBirth(GregorianCalendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	  /**
     * Sets the employee start date represented by this object
     * @param startDate the start date of the employee
     */
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}
	
	  /**
     * Sets the employee phone number represented by this object
     * @param phoneNumber the phone number of the employee
     */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	  /**
     * Sets the employee street address represented by this object
     * @param streetAddress the street address of the employee
     */
	public void setStreetAddress(String StreetAddress) {
		this.streetAddress = streetAddress;
	}
	
	  /**
     * Sets the employee city represented by this object
     * @param city the city of the employee
     */
	public void setCity(String city) {
		this.city = city;
	}
	
	  /**
     * Sets the employee name represented by this object
     * @param state the state of the employee
     */
	public void setState(String state) {
		this.state = state;
	}
	
	  /**
     * Sets the employee zip represented by this object
     * @param zip the zip of the employee
     */
	public void setZIP(int zip) {
		this.zip = zip;
	}
	
	  /**
     * Sets the employee monthly salary represented by this object
     * @param monthlySalary the monthly salary of the employee
     */
	public void setMonthlySalary(int monthlySalary) {
		this.monthlySalary = monthlySalary;
	}
	
  	  /**
     * Sets the employee search string represented by this object
     * @param search the search string of the employee
     */
	public void setSearchString(String searchString){
		this.searchString = searchString;
	}

    //--------------------------------------------------------------------------
    //Please complete the code and docmentation for the following methods
    //--------------------------------------------------------------------------

    // --------------------------------------------------------------------------
    // In the following, we just have some method signitures.  Our method will 
	// simply printout a statement "performing" an action.  You need to perform/
	// display the appropriate calculations/information for the employee.
    // --------------------------------------------------------------------------
    
    public void display(){
        System.out.println("Displaying Information for Employee");
	     System.out.println("Employee ID: " + employeeID);
	     System.out.println("Employee name: " + employeeName);
		  System.out.println(" Date of birth: "+ (dateOfBirth.get(Calendar.MONTH)+1)+ "/"+dateOfBirth.get(Calendar.DATE)+"/"+ dateOfBirth.get(Calendar.YEAR));
		  System.out.println(" Date of employment: "+ (startDate.get(Calendar.MONTH)+1)+ "/"+startDate.get(Calendar.DATE)+"/"+ startDate.get(Calendar.YEAR));		  
		  System.out.println("Employee phone number: " + phoneNumber);
		  System.out.println("Employee street address: " + streetAddress);
	     System.out.println("Employee city, state, and zip: " + city + ", " + state + " " + zip);
        System.out.println("The gross pay of the employee is: $" + monthlySalary);
        
    }//end of display      
}//end of class FullTimeEmployee