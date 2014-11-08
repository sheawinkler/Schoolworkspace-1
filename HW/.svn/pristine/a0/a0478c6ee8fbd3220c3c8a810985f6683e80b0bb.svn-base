package unl.cse;

/* Asset.java class defines an individual asset.  The class contains two default constructors and 
 * getter/setter methods for each of the variables.
 */

public abstract class Asset {

	private String label;
	private String code;
	private char letter;
	
	public Asset(String code, char letter, String label) {
		super();
		this.code = code;
		this.letter = letter;
		this.label = label;
	}
	public Asset() {
		this.code = new String();
		this.letter = 'a';
		this.label = new String();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public abstract double getValue();
	public abstract double annualReturn();
	public abstract double rateOfReturn();
}
