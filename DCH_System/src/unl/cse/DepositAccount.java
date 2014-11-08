package unl.cse;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Class extends Assets and defines another variable, apr.
@XmlRootElement
public class DepositAccount extends Assets {
	private Double apr = 0.00;
	
	public DepositAccount(){};
	public DepositAccount(String alphaNumeric, String type, String label,  Double apr){	
		super( alphaNumeric,type,label);
		this.apr = apr;
	}

	public Double getapr(){		
		return this.apr;
	}
	@XmlElement
	public void setapr(Double apr){
		if(apr instanceof Double){		
			this.apr = apr;
		}
	}
	
}
