package unl.cse.trucks;


public class TruckList {
	TruckListNode head= null;
	
    public void clear() {
    	head = null;
    	//throw new UnsupportedOperationException("Not yet implemented.");
    }

    public void addToStart(Truck t) {
    	TruckListNode newNode = new TruckListNode(t);
    	newNode.setNext(head);
    	head = newNode;
    	
    }

    public void addToEnd(Truck t) {
    	TruckListNode anotherNode = new TruckListNode(t);
    	if(head==null){
    		addToStart(t);
    	}else{
    		TruckListNode curr = head;
    		while(curr.getNext()!=null){
    			curr = curr.getNext();
    		}
    		curr.setNext(anotherNode);
    	}
    }

    public void remove(int position) {
    	TruckListNode curr = head;
    	TruckListNode previous  = null;
    	
    	if(position == 0 ){
    		head = (head.getNext());
    	}else{
    		for(int i =0; curr.getNext()!=null;i++){
        		if(i==position){
        			previous.setNext(curr.getNext());
        			return;
        		}
        		previous = curr;
    			curr = curr.getNext();
           	}
    		previous.setNext(null);
    		
    	}
    	//throw new UnsupportedOperationException("Not yet implemented.");
    }
    
    @SuppressWarnings("unused")
	private TruckListNode getTruckListNode(int position) {
    	TruckListNode curr = head;
    	int i=0;
    	while(i<position){
    		curr = curr.getNext();
    	}
    	return curr;
    	//throw new UnsupportedOperationException("Not yet implemented.");
    }
    
    public Truck getTruck(int position) {
    	TruckListNode curr = head;
    	Truck newTruck = null;
    	int count =0;
    	for(int i=0;curr.getNext()!=null;i++){
    		if(i == position){
    			newTruck = curr.getTruck();
        		return newTruck;      				
    		}
			curr = curr.getNext();
			count++;
    	}
    	if(count == position){
    		newTruck = curr.getTruck();
    		return newTruck;
    	}
    	throw new IndexOutOfBoundsException("IndexOutOfBoundsException");	
    }

    public void print() {
    	int i =0;
    	TruckListNode curr = head;
    	if (curr != null) {
	    	do{
	    		System.out.println(i+curr.getTruck().toString());
	    		curr = curr.getNext();
	    		i++;
	    	}while(curr != null);
    	}
    	System.out.println("");
    }
    
}

