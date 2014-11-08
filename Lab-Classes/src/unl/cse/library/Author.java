package unl.cse.library;

public class Author {
	
	private String firstName;   
	private String lastName;

   public Author(String firstName, String lastName) {
	    	
	   this.firstName = firstName;
	   this.lastName = lastName;
   }
	
    /**
     * Getter method for firstName
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter method for firstName
     * @param title
     */
    public void setFirstName(String firstName) {
    	if(firstName instanceof String){
    		this.firstName = firstName;
    	}
    }
	
    /**
     * Getter method for LastName
     * @return
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter method for LastName
     * @param title
     */
    public void setLastName(String lastName) {
    	if(lastName instanceof String){
    		this.lastName = lastName;
    	}
    }
    
    public String returnName(){
    	String returned = this.firstName + ","+ this.lastName;
    	return returned;
    	
    }
}
