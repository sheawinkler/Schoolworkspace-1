package unl.cse;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Private Investment accounts extends accounts and adds extra variables
@XmlRootElement
public class Stocks extends InvestmentAccounts {
	private String stockSymbol = "";
	private Double sharePrice = 0.00;
	
	public Stocks(){}
	public Stocks(String alphaNumeric, String type, String label, Double quarterlyDividend, Double baseRateOfReturn, Double omega, String stockSymbol, Double sharePrice){	
		super(alphaNumeric,type,label,quarterlyDividend,baseRateOfReturn,omega);
		this.stockSymbol = stockSymbol;
		this.sharePrice = sharePrice;
	}

	public String getstockSymbol(){		
		return this.stockSymbol;
	}
	@XmlElement
	public void setstockSymbol(String stockSymbol){
		if(stockSymbol instanceof String){		
			this.stockSymbol = stockSymbol;
		}
	}
	
	public Double getsharePrice(){		
		return this.sharePrice;
	}
	@XmlElement
	public void setsharePrice(Double sharePrice){
		if(sharePrice instanceof Double){		
			this.sharePrice = sharePrice;
		}
	}
}
