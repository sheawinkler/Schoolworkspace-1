package unl.cse.trucks;

public class TruckListNode {

    private TruckListNode next;
    private TruckListNode prev;
    private Truck item;

    public TruckListNode(Truck item) {
        this.item = item;
        this.next = null;
    }

    public Truck getTruck() {
        return item;
    }
    public TruckListNode getPrev() {
        return prev;
    }

    public void setPrev(TruckListNode prev) {
        this.prev = prev;
    }
    
    public TruckListNode getNext() {
        return next;
    }

    public void setNext(TruckListNode next) {
        this.next = next;
    }
}
