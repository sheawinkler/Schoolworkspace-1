package unl.cse;

public class Email {
	private String emailName = "";
			
	public String getEmailName(){		
		return this.emailName;
	}
	
	public void setEmailName(String emailName){
		if(emailName instanceof String){		
			this.emailName = emailName;
		}
	}
}
