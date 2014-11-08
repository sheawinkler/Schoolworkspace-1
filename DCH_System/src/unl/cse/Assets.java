package unl.cse;
import java.io.*; 
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Assets class defines the characteristics of the asset class, such as type, label, and alphaNumeric.  These methods and characteristics can be used by extended classes
@XmlRootElement
public class Assets {
	private String alphaNumeric = "";
	private String label = "";
	private String type = "";
	
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
