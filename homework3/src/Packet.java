/**
 * A class that implements the methods of type Packet.
 * 
 * @author Deverick Simpson
 * 
 */
public class Packet {

		
		//Declare variables of the Packet class
		protected int pageId;
		protected int totalPackets;
		protected int packetId;
		protected double lengthOfPackets;
		protected String destinationNode;
		protected String originatingNode;
	
		/**
		 *
		 * constructor method
		 */
		public Packet(){
		}
		
		/**
		 *
		 * constructor method
		 */
		public Packet(int pageId, int totalPackets, int packetId, double lengthOfPackets){
			this.pageId=pageId;
			this.totalPackets=totalPackets;
			this.packetId=packetId;
			this.lengthOfPackets=lengthOfPackets;
		}

	    /**
	     *
	     * @return pageId
	     */
	    public int getPageId() {
	        return pageId;
	    }
	    
	    /**
	     *
	     * @return totalPackets
	     */
	    public int getTotalPackets() {
	        return totalPackets;
	    }
	    
	    /**
	     *
	     * @return packetId
	     */
	    public int getPacketId() {
	        return packetId;
	    }
	    
	    /**
	     *
	     * @return lengthOfPackets
	     */
	    public double getLengthOfPackets() {
	        return lengthOfPackets;
	    }
	    
	    /**
	     *
	     * @return destinationNode
	     */
	    public String getDestinationNode() {
	        return destinationNode;
	    }

	    /**
	     *
	     * @return destinationNode
	     */
	    public String getOriginatingNode() {
	        return destinationNode;
	    }
	    
	    /**
	     * Setter method for page id
	     * @param pageId
	     */
	    public void setPageId(int pageId) {
	        this.pageId = pageId;
	    }
	    
	    /**
	     * Setter method for totalPackets
	     * @param totalPackets
	     */
	    public void setTotalPackets(int totalPackets) {
	        this.totalPackets = totalPackets;
	    }

	    /**
	     * Setter method for packet Id
	     * @param pageId
	     */
	    public void setPacketId(int packetId) {
	        this.packetId = packetId;
	    }
	    
	    /**
	     * Setter method for length of packets
	     * @param pageId
	     */
	    public void setLengthOfPackets(double lengthOfPackets) {
	        this.lengthOfPackets = lengthOfPackets;
	    }
	 
	    /**
	     * Setter method for destination node
	     * @param pageId
	     */
	    public void setDestinationNode(String destinationNode) {
	        this.destinationNode = destinationNode;
	    }
	   
	    /**
	     * Setter method for originating Node
	     * @param pageId
	     */
	    public void setOriginatingNode(String originatingNode) {
	        this.originatingNode = originatingNode;
	    }

	    public boolean printResults(){
	    	System.out.println("Output is "+ getPageId() + " " + getPacketId() + " "  + getTotalPackets() + " "  + getLengthOfPackets() + " "  + getDestinationNode() + " "  + getOriginatingNode() );
	    	return true;
	    }
	    
}
