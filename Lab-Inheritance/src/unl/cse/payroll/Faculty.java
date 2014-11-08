package unl.cse.payroll;

public class Faculty extends Employee {
	
	private String position;

	public Faculty(int id, String firstName, String lastName, String type, String position){
		super(id,firstName,lastName,type,position);
		this.position = position;
	}
	
	public double annualPay(){
		double Salary=0.00;
		
		if(position.equals("Assistant-Professor")){
			 Salary = 75000;
		}else if(position.equals("Associate-Professor")){
			 Salary = 84000;
		}else if(position.equals("Professor")){
			Salary = 93000;
		}
		return Salary;
	}

}
