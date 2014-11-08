package unl.cse.sorting;

public class Location implements Comparable<Location> {

	private final String zipCode;
    private final String city;
    private final Double latitude;
    private final Double longitude;
    private final String state;

    public Location(String zipCode, Double latitude, Double longitude, String city, String state) {
    	this.zipCode = zipCode;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }   

    public String getCity() {
        return this.city;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	
	public String getState() {
		return state;
	}

	/**
      * Complete the implementation of this method that will be used for sorting
      * using the java.util.Collections.sort method.
      * @param o
      * @return
      */
    @Override
    public int compareTo(Location l) {
    	int result = -4;
    	if(this.getZipCode()==l.getZipCode() && this.getCity()==l.getCity() && this.getLatitude()==l.getLatitude() 
    			&& this.getLongitude() == l.getLongitude() && this.getState()==l.getState()){
    		result= 0;
    	}else if(this.getLatitude()<l.getLatitude()){
    		result= -1;
    	}else if(this.getLatitude()>l.getLatitude()){
    		result= 1;
    	}
    	//throw new UnsupportedOperationException("YOU MUST IMPLEMENT THIS");
    	return result;
    	
    	
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.getCity());
    	sb.append(" ");
    	sb.append(this.getState());
    	sb.append(", ");
    	sb.append(this.getZipCode());
    	return sb.toString();
    }

}
