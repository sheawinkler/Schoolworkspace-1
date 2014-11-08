package unl.cse;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Portfolios {
	private String alphaNumeric = "";
	private String ownerCode = "";
	private String managerCode = "";
	private String beneficiaryCode = "";
	private String assetListPortfolio = "";
	
	public Assets(){};
	public Assets(String alphaNumeric, String type, String label){
		this.alphaNumeric = alphaNumeric;
		this.label = label;
		this.type = type;
	}
	
	public String getAlphaNumeric(){		
		return this.alphaNumeric;
	}
	@XmlAttribute
	public void setAlphaNumeric(String alphaNumeric){
		if(alphaNumeric instanceof String){		
			this.alphaNumeric = alphaNumeric;
		}
	}
	
	public String getlabel(){		
		return this.label;
	}
	@XmlElement
	public void setlabel(String label){
		if(alphaNumeric instanceof String){		
			this.label = label;
		}
	}

	public String gettype(){		
		return this.alphaNumeric;
	}
	@XmlElement
	public void settype(String type){
		if(alphaNumeric instanceof String){		
			this.type = type;
		}
	}
}
