package unl.cse;

public class Lists {
	
	public static void main(String[] args){
		Lists m = new Lists();
		//m = DataConverter.deserialize("data/Persons.dat,data/Assets.dat,data/Portfolios.dat");
		LoadDatabase.getAllPortfolio(m);
		int i =0;
		while(i<m.lastName.length()){
			System.out.println(m.getLastName().get(i).getPortfolioCode());
			i++;
		}
		System.out.println(m.getLastName().get(i).getPortfolioCode());
		//System.out.println(m.getManagerRank());
		//System.out.println(m.getTotalValue());
	}
	
	private Mylist lastName = new Mylist();
	private Mylist totalValue = new Mylist();
	private Mylist managerRank = new Mylist();
	
	public void add(Portfolio portfolio){
		System.out.println(portfolio.getPortfolioCode());
		if(lastName.length()==0 ){
			lastName.add(portfolio, 0);
			totalValue.add(portfolio, 0);
			managerRank.add(portfolio, 0);
			return;
		}
		int i=0;
		boolean check =true;
		while(i<lastName.length()){
			if(SortlistComparators.lastName(lastName.get(i),portfolio) <0){
				lastName.add(portfolio, i);
				check = false;
			}
			i++;
		}
		if(check){
			lastName.add(portfolio, i);
		}
		check = true;
		i=0;
		@SuppressWarnings("unused")
		double a,b;
		while(i<=totalValue.length()&&check){
			a = totalValue.get(i).getTotalValue();
			b = portfolio.getTotalValue();
			if(SortlistComparators.totalValue(totalValue.get(i), portfolio)<0){
				totalValue.add(portfolio, i);
				check = false;
			}
			System.out.println(i);
			i++;
		}
		System.out.println("safe");
		if(check){
			totalValue.add(portfolio, i);
		}
		check =true;
		i=0;
		while(i<=managerRank.length()&&check){
			if(SortlistComparators.managerRank(managerRank.get(i), portfolio)<0){
				managerRank.add(portfolio, i);
				check = false;
			}
			i++;
		}
		if(check){
			managerRank.add(portfolio, i+1);
		}
	}
	
	public Mylist getLastName(){
		return lastName;
	}
	
	public Mylist getTotalValue(){
		return totalValue;
	}
	
	public Mylist getManagerRank(){
		return managerRank;
	}
}
