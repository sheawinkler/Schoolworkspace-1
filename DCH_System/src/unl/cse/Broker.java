package unl.cse;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Broker extends Person {
	String initial = "";
	String identifier = "";
	
	public Broker(){}
	public Broker(String Code,String initial, String identifier, String firstName, String lastName,String Street, String City, String State, String Zip, String Country) {
	
		super(Code, firstName, lastName, Street, City, State, Zip, Country);
		this.initial=initial;
		this.identifier = identifier;
	}

	public String getInitial(){		
		return this.initial;
	}
	@XmlElement
	public void setInitial(String initial){
		if(initial instanceof String){		
			this.initial = initial;
		}
	}
	
	public String getIdentifier(){		
		return this.identifier;
	}
	@XmlElement
	public void setIdentifier(String identifier){
		if(identifier instanceof String){		
			this.identifier=identifier;
		}
	}

}
