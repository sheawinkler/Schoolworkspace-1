package unl.cse;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	private String Code = "";
	private String firstName = "";
	private String lastName = "";
	private String Street = "";
	private String City = "";
	private String State = "";
	private String Zip = "";
	private String Country = "";
	private String emailName = "";
	
	public Person(){}
	public Person(String Code, String firstName, String lastName, String Street, String City, String State, String Zip, String Country){
		this.Code = Code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Street = Street;
		this.City = City;
		this.State = State;
		this.Zip = Zip;
		this.Country = Country;
	}
	
	public String getCode(){		
		return this.Code;
	}
	@XmlAttribute
	public void setCode(String Code){
		if(Code instanceof String){		
			this.Code = Code;
		}
	}
	
	public String getFirstName(){		
		return this.firstName;
	}
	@XmlElement
	public void setFirstName(String firstName){
		if(firstName instanceof String){		
			this.firstName = firstName;
		}
	}

	public String getLastName(){		
		return this.lastName;
	}
	@XmlElement
	public void setLastName(String lastName){
		if(lastName instanceof String){		
			this.lastName = lastName;
		}
	}
	public String getStreet(){		
		return this.Street;
	}
	@XmlElement
	public void setStreet(String Street){
		if(Street instanceof String){		
			this.Street = Street;
		}
	}
	public String getCity(){		
		return this.City;
	}
	@XmlElement
	public void setCity(String City){
		if(City instanceof String){		
			this.City = City;
		}
	}
	public String getState(){		
		return this.State;
	}
	@XmlElement
	public void setState(String State){
		if(State instanceof String){		
			this.State = State;
		}
	}
	public String getZip(){		
		return this.Zip;
	}
	@XmlElement
	public void setZip(String Zip){
		if(State instanceof String){	
			this.Zip = Zip;
		}
	}
	public String getCountry(){		
		return this.Country;
	}
	@XmlElement
	public void setCountry(String Country){
		if(Country instanceof String){		
			this.Country = Country;
		}
	}
	
    public String returnName(){
    	String returned = this.firstName + ","+ this.lastName;
    	return returned;
    	
    }
    
	
    public String getEmailName(){		
    	return this.emailName;
    }
	@XmlElement
    public void setEmailName(String emailName){
    	if(emailName instanceof String){		
    		this.emailName = emailName;
    	}
    }
}
