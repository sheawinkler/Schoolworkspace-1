package unl.cse.payroll;

import java.io.File;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Class designed for testing and executing the correctness of
 * the three classes that you implemented Employee.java,
 * FullTimeEmployee.java, PartTimeEmployee.java
 */
public class Payroll {

	private Employee employees[];
	private int numEmployees = 0;
	private NumberFormat nf = NumberFormat.getCurrencyInstance();

	public Payroll() {
		this.employees = new Employee[100];
		loadFile();
	}
	
	private void loadFile() {

		try {
			String fileName = "data/employeeRecords.txt";
			File inFile = new File(fileName); 
			Scanner s = new Scanner(inFile);
			int i=0;
			while(s.hasNextLine())
			{
				String line = s.nextLine();
				String tokens[] = line.split(",");
				Integer id = Integer.parseInt(tokens[0]);
				String lastName = tokens[1];
				String firstName = tokens[2];
				String employeeType = tokens[3]; //Faculty or Staff
				//Faculty: Assistant-Professor, Associate-Professor, or Professor
				//Staff: full-time or part-time
				String position = tokens[4]; 
				if(employeeType.equals("Faculty")){	
					
					Faculty facultyOne = new Faculty( id,firstName,lastName,employeeType,position);
					this.employees[i] = facultyOne;
					i++;
				}else if(employeeType.equals("Staff")){
					Double hoursPerWeek = null;
					try {
						hoursPerWeek = Double.parseDouble(tokens[5]);
					} catch (Exception e) {}
					Staff staffOne = new Staff( id,firstName,lastName,employeeType,position,hoursPerWeek);
					this.employees[i]=staffOne;
					i++;
				}
			}
			this.numEmployees = i;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void printAnnualReport() {
		System.out.println(String.format("%-20s %10s %10s", "Employee Name", "Annual Pay", "FICA"));
		for(int i=0; i<this.numEmployees; i++) {
			Employee e = this.employees[i];
			System.out.println(String.format("%-20s %10s %10s", this.employees[i].employeeName(),
						                                        this.employees[i].annualPay(), 
						                                        nf.format(e.getAnnualFica())));
		}
	}
	
    public static void main(String[] args) {
    	Payroll payroll = new Payroll();
    	payroll.printAnnualReport();
    }
}
