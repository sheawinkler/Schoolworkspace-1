package unl.cse.lists;

public class UserClassB {

	private Integer i;
	private Double d;
	
	public UserClassB(Integer i, Double d) {
		this.i = i;
		this.d = d;
	}
	
	public Integer getInteger() {
		return this.i;
	}
	
	public Double getDouble() {
		return this.d;
	}
	
	public void setInteger(Integer i) {
		this.i = i;
	}
	
	public void SetDouble(Double d) {
		this.d = d;
	}
	
	@Override
	public String toString() {
		return "(" + i + ", " + d + ")";
	}
	
	@Override
	public int hashCode() {
		return this.i.hashCode() * 13 + this.d.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) 
			return true;
		
		if(!(o instanceof UserClassB)) {
			return false;
		}
		UserClassB that = (UserClassB) o;
		boolean result = true;
		result = result && (this.i == null ? that.i == null : this.i.equals(that.i));
		result = result && (this.d == null ? that.d == null : this.d.equals(that.d));
		return result;
	}
}
