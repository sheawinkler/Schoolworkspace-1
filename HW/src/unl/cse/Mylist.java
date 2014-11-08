package unl.cse;


public class Mylist {
	Mylistnode head;
	private int length = 0;
	
	
	public void add(Portfolio port,int position){
		Mylistnode newNode = new Mylistnode(port);
		Mylistnode curr = head;
		int i=0;
		//System.out.println(port.getPortfolioCode());
		if(position == 0){
			head = newNode;
			newNode.setNext(head);
			newNode.setPrev(head);
			length++;
			return;
		}
		if(position<=length){
			while(i<=position){
				if(position==i){
					newNode.setPrev(curr.getPrev());
					newNode.setNext(curr);
					curr.setPrev(newNode);
					curr.getPrev().setNext(newNode);
					length++;
					return;
				}
				i++;
				curr = curr.getNext();
			}
		}
		if(position >= length){
			newNode.setPrev(curr);
			curr.setNext(newNode);
			length++;
		}
		//throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		
	}
	public Portfolio get(int position){
		Mylistnode curr = head;
		int i=0;
    	while(i<position){
    		curr = curr.getNext();
    		i++;
    	}
    	return curr.getItem();	
	}
	
	public void remove(int position){
		Mylistnode curr = head;
		if(position == 0 ){
    		head = (head.getNext());
    	}else{
    		for(int i =0; curr.getNext()!=null;i++){
        		if(i==position){
        			curr.getPrev().setNext(curr.getNext());
        			return;
        		}
        		
    			curr = curr.getNext();
           	}
    		curr.getPrev().setNext(null);
    	}
	}
	public int length(){
		return length;
	}
}
