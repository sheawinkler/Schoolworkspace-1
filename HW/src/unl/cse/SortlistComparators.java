package unl.cse;

public class SortlistComparators<Portfolios> {
	public static int totalValue(Portfolio a, Portfolio b){
		if(a.getTotalValue() > b.getTotalValue()){
			return -1;
		}else if(a.getTotalValue() == b.getTotalValue()){
			return 0;
		}else{
			return 1;
		}
	}
	
	public static int lastName(Portfolio a, Portfolio b){
		int test = nameCompare(a.getManager().getNameLast(), b.getManager().getNameLast());
		if(test == 0){
			return nameCompare(a.getManager().getNameFirst(), b.getManager().getNameFirst());
		}
		return test;
	}
	
	public static int managerRank(Portfolio a, Portfolio b){
		if(a.getManager().getRank() < b.getManager().getRank()){
			return 1;
		}else if(a.getManager().getRank() == b.getManager().getRank()){
			return nameCompare(a.getManager().getNameLast(),b.getManager().getNameLast());
		}else{
			return -1;
		}
	}
	
	private static int nameCompare(String a, String b){
		return a.compareToIgnoreCase(b);
	
	}
}
