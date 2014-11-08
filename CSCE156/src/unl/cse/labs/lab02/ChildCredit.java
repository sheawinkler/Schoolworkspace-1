package unl.cse.labs.lab02;

public class ChildCredit {

	public static void main(String args[]) {
		Child tom = new Child("Tommy", 14);
		Child dick = new Child("Richard", 12);
		Child harry = new Child("Harold", 21);
		
		Child arr[] = new Child[3];
		arr[0] = tom;
		arr[1] = dick;
		arr[2] = harry;
		
		System.out.println("Child\t\tAmount");
		double total = 0;
		for(Child kid : arr) {
			double credit = 0;
			if(kid.getAge() <= 18) {
				if(total == 0) {
					credit = 1000;
				} else {
					credit = 500;
				}
			}
			System.out.println(kid + "\t" + String.format("$%.2f", credit));
			total += credit;
		}
		System.out.println("Total Credit: \t"+String.format("$%.2f", total));
		
	}
}
