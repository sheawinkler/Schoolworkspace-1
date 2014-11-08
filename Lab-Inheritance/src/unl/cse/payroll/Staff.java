package unl.cse.payroll;

public class Staff extends Employee {
	public double hoursPerWeek;
	private String position;
	public Staff(int id, String firstName, String lastName, String type, String position, Double hoursPerWeek){
		super( id,firstName,lastName,type,position);
		this.hoursPerWeek = hoursPerWeek;
		this.position = position;
	}
	
	public double annualPay(){
		double Salary=0.00;
		if(position.equals("full-time")){
			 Salary = 41000;
			
		}else if(position.equals("part-time")){
			 Salary = ((8.50*hoursPerWeek)*52);
		}
		return Salary;
	}

}
