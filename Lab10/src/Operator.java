/**
 *
 * @author knobel
 */
public class Operator {

    public static final String[] OPERATOR_TYPE={"+","-","*","/"};
    private String type;
	
	public Operator(){
	
	}

    public Operator(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }    
}
