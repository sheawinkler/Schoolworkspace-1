package unl.cse;

import java.util.ArrayList;

/*
 * The Person.java class defines a person.  The class contains two constructors 
 * and getter/setter methods for the variables
 */
public class Person {
	
	private String personCode;
	private String nameFirst;
	private String nameLast;
	private Address mailingAddress;
	private ArrayList<String> emailAddress;

	//Input Person Constructor
	public Person(String personCode, String nameFirst, String nameLast,
			Address mailingAddress, ArrayList<String> emailAddress) {
		super();
		this.personCode = personCode;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.mailingAddress = mailingAddress;
		this.emailAddress = emailAddress;
	}
	//New person Constructor
	public Person() {
		this.personCode = new String();
		this.nameFirst = new String();
		this.nameLast = new String();
		this.mailingAddress = new Address();
		this.emailAddress = new ArrayList<String>();
	}
	
	public String getPersonCode() {
		return personCode;
	}
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	public String getNameFirst() {
		return nameFirst;
	}
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}
	public String getNameLast() {
		return nameLast;
	}
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}
	public Address getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(Address mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public ArrayList<String> getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(ArrayList<String> emailAddress) {
		this.emailAddress = emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress.add(emailAddress);
	}
	public String getName() {
		String s = (this.getNameLast() +","+" "+ this.getNameFirst());
		return s;
	}
}


 

