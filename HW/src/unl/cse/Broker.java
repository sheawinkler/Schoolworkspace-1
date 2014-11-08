package unl.cse;
import java.util.ArrayList;

/*
 * Broker.java class extends the person class.  Within the broker.java class are two 
 * constructors as well as the getter/setter methods for each of the variables.
 */

public class Broker extends Person{

	private char rank;
	private String SEC;
	
	public Broker(String personCode, String nameFirst, String nameLast,
			Address mailingAddress, ArrayList<String> emailAddress, char rank,
			String SEC) {
		super(personCode, nameFirst, nameLast, mailingAddress, emailAddress);
		this.rank = rank;
		this.SEC = SEC;
	}
	public Broker() {
		super();
		this.rank = 'a';
		this.SEC = new String();
	}
	public char getRank() {
		return rank;
	}
	public void setRank(char rank) {
		this.rank = rank;
	}
	public String getSEC() {
		return SEC;
	}
	public void setSEC(String sEC) {
		SEC = sEC;
	}
	@Override
	public String toString() {
		return "Broker [rank=" + rank + ", SEC=" + SEC + "]";
	}
	
	

}
