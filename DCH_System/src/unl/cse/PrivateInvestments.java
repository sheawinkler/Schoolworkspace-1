package unl.cse;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Private Investment accounts extends accounts and adds extra variables
@XmlRootElement
public class PrivateInvestments extends InvestmentAccounts {
	private Double totalValue = 0.00;
	
	public PrivateInvestments(){}
	public PrivateInvestments(String alphaNumeric, String type, String label, Double quarterlyDividend, Double baseRateOfReturn, Double omega, Double totalValue){	
		super(alphaNumeric,type,label,quarterlyDividend,baseRateOfReturn,omega);
		this.totalValue = totalValue;
	
	}

	public Double gettotalValue(){		
		return this.totalValue;
	}
	@XmlElement
	public void settotalValue(Double totalValue){
		if(totalValue instanceof Double){		
			this.totalValue = totalValue;
		}
	}

}
