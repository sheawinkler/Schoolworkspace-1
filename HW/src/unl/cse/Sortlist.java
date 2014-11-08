package unl.cse;





import java.lang.reflect.Array;
import java.util.*;

import org.apache.log4j.Logger;
@SuppressWarnings("unused")
public class Sortlist <E>{
	public static void main(String[] args){
		Sortlist<Portfolio> a = new Sortlist<Portfolio>();
		Portfolio newport = new Portfolio();
		Portfolio newport2 = new Portfolio();
		Portfolio newport3 = new Portfolio();
		a.add(newport);
		a.add(newport2);
		a.add(newport3);
		a.add(newport);
		a.add(newport2);
		a.add(newport3);
		a.add(newport);
		a.add(newport2);
		a.add(newport3);
		a.add(newport);
		a.add(newport2);
		a.add(newport3);
		for(int i =0;i<a.getSize();i++){
		System.out.println(a.lastName[i]);
		System.out.println(a.managerRank[i]);
		System.out.println(a.totalValue[i]);
		System.out.println();
		}
	}
	private static Logger logger=Logger.getLogger("HW");
	private Object[] lastName;
	private Object[] managerRank;
	private Object[] totalValue;
	private int size;
	int capacity;

	/**
	 *setups a <i>SortList </i> 
	 * 
	 */
	public Sortlist(){
		this.lastName = new Object[10];
		this.managerRank = new Object[10];
		this.totalValue = new Object[10];
		this.size = 0;
		this.capacity = 10;
	}
	public Sortlist(int capacity){
		this.lastName = new Object[capacity];
		this.managerRank = new Object[capacity];
		this.totalValue = new Object[capacity];
		this.size = 0;
		this.capacity = capacity;
	}
	public void add(Object a){
		 if(size+1 >= capacity){
				Sortlist<Portfolio> newSortlist = new Sortlist<Portfolio>(capacity*2);
				int i = 0;
				this.copy(this,newSortlist);
//				this = newSortlist;
		 }
		if(size == 0){
			lastName[0]=a;
			managerRank[0]=a;
			totalValue[0]=a;
		}else{
			int check=0;
			for(int i=0;i<getSize();i++){
				if(SortlistComparators.lastName((Portfolio) a,(Portfolio) lastName[i]) >-1){
					this.addLastNameAt(i, a);
					check++;
				}
				if(SortlistComparators.managerRank((Portfolio) a,(Portfolio) managerRank[i]) >-1){
					this.addManagerRankAt(i, a);
					check++;
				}
				if(SortlistComparators.totalValue((Portfolio) a,(Portfolio) totalValue[i]) >-1){
					this.addTotalValueAt(i, a);
					check++;
				}
				if(check == 3){
					break;
				}
			}
		}
		size++;
	}

	@SuppressWarnings("unchecked")
	private void copy(Sortlist<E> sortlist, Sortlist<Portfolio> newSortlist) {
		int i=0;
		newSortlist.setlastName((Sortlist<Portfolio>) sortlist);
		newSortlist.setManagerRank((Sortlist<Portfolio>) sortlist);
		newSortlist.setTotalValue((Sortlist<Portfolio>) sortlist);
		newSortlist.setSize(sortlist.getSize());
	}
	private void setSize(int size2) {
		this.size = size2;
		
	}
	private void setTotalValue(Sortlist<Portfolio> sortlist) {
		for(int i=0; i<sortlist.getSize();i++){
			this.totalValue[i] = sortlist.totalValue[i];
		}		
	}
	private void setManagerRank(Sortlist<E> sortlist) {
		for(int i=0;i<sortlist.getSize();i++){
			this.managerRank[i] = sortlist.managerRank[i];
		}
		
	}
	private void setlastName(Sortlist<E> sortlist) {
		for(int i=0; i<sortlist.getSize();i++){
			this.lastName[i] = sortlist.lastName[i];
		}		
	}
	/**
	 * get the Size of the <i>Sortlist</i>
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	protected void addLastNameAt(int i, Object a){
		Object holder = new Object();
		Object holder2 =new Object();
		holder = lastName[i];
		lastName[i]= a;
		holder2 = holder;
		while(i<size){
			i++;
			holder = lastName[i];
			lastName[i]= holder2;
			holder2 = holder;
		}
		
	}
	
	protected void addTotalValueAt(int i, Object a){
		Object holder = new Object();
		Object holder2 =new Object();
		holder = totalValue[i];
		totalValue[i]= a;
		i++;
		holder2 = holder;
		while(i<size){
			holder = totalValue[i];
			totalValue[i]=holder2;
			holder2 = holder;
			i++;
		}
		totalValue[i] = holder2;
	}
	protected void addManagerRankAt(int i, Object a){
		Object holder = new Object();
		Object holder2 =new Object();
		holder = managerRank[i];
		managerRank[i]= a;
		i++;
		holder2 = holder;
		while(i<size){
			holder = managerRank[i];
			managerRank[i]=holder2;
			holder2 = holder;
			i++;
		}
		managerRank[i] = holder2;
	}
	
	



}