package unl.cse;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Investment accounts extends accounts and adds extra variables
@XmlRootElement
public class InvestmentAccounts extends Assets {
	
	private Double quarterlyDividend = 0.00;	
	private Double baseRateOfReturn = 0.00;
	private Double omega = 0.00;	
	
	public InvestmentAccounts(){}
	public InvestmentAccounts(String alphaNumeric, String type, String label, Double quarterlyDividend, Double baseRateOfReturn, Double omega){	
		super(alphaNumeric,type,label);
		this.quarterlyDividend = quarterlyDividend;
		this.baseRateOfReturn = baseRateOfReturn;
		this.omega = omega;
	}

	public Double getquarterlyDividend(){		
		return this.quarterlyDividend;
	}
	@XmlElement
	public void setquarterlyDividend(Double quarterlyDividend){
		if(quarterlyDividend instanceof Double){		
			this.quarterlyDividend = quarterlyDividend;
		}
	}
	
	public Double getbaseRateOfReturn(){		
		return this.baseRateOfReturn;
	}
	@XmlElement
	public void setbaseRateOfReturn(Double baseRateOfReturn){
		if(baseRateOfReturn instanceof Double){		
			this.baseRateOfReturn = baseRateOfReturn;
		}
	}

	public Double getomega(){		
		return this.omega;
	}
	@XmlElement
	public void setomega(Double omega){
		if(omega instanceof Double){		
			this.omega = omega;
		}
	}
}
