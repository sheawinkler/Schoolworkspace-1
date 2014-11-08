package unl.cse;
import java.util.ArrayList;


/*
 * The Portfolio.java class defines a portfolio.  In theory, a portfolio contains the 
 * details of a customers assets.  The class has two constructors and getter/setter methods for the variables.
 * The class also contains get methods to calculate an individuals weighted risk and annualReturn
 */
public class Portfolio {
	
	private String portfolioCode;
	private Person owner;
	private Broker manager;
	private Person beneficiary;
	private ArrayList<Asset> assets;
	
	public Portfolio(){
		this.portfolioCode = new String();
		this.owner = new Person();
		this.manager = new Broker();
		this.beneficiary = new Person();
		this.assets = new ArrayList<Asset>();
	}
	public Portfolio(String portfolioCode, Person owner, Broker manager,
			Person beneficiary, ArrayList<Asset> assetList) {
		super();
		this.portfolioCode = portfolioCode;
		this.owner = owner;
		this.manager = manager;
		this.beneficiary = beneficiary;
		this.assets = assetList;
	}
	/**
	 * @return the portfolioCode
	 */
	public String getPortfolioCode() {
		return portfolioCode;
	}
	/**
	 * @param portfolioCode the portfolioCode to set
	 */
	public void setPortfolioCode(String portfolioCode) {
		this.portfolioCode = portfolioCode;
	}
	/**
	 * @return the owner
	 */
	public Person getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	/**
	 * @return the manager
	 */
	public Broker getManager() {
		return manager;
	}
	/**
	 * @param manager the manager to set
	 */
	public void setManager(Broker manager) {
		this.manager = manager;
	}
	/**
	 * @return the beneficiary
	 */
	public Person getBeneficiary() {
		return beneficiary;
	}
	/**
	 * @param beneficiary the beneficiary to set
	 */
	public void setBeneficiary(Person beneficiary) {
		this.beneficiary = beneficiary;
	}
	/**
	 * @return the assetList
	 */
	public ArrayList<Asset> getAssetList() {
		return assets;
	}
	/**
	 * @param assetList the assetList to set
	 */
	public void setAssetList(ArrayList<Asset> assetList) {
		this.assets = assetList;
	}
	public void addToAssetList(Asset asset){
		this.assets.add(asset);
	}
	/**
	 * @return the fee
	 */
	public double getFee() {
		double fee=0;
		if(manager.getRank() == 'J'){
			fee= assets.size()*50;
		}else if(manager.getRank() == 'E'){
			fee= assets.size()*10;
		}
		return fee;
	}
	public double getCommission(){
		double commission=0.0;
		if(manager.getRank() == 'J'){
			commission = this.getAnnualReturnTotal()*.02;
		}else if(manager.getRank() == 'E'){
			commission = this.getAnnualReturnTotal() *.05;
		}
		
		return commission;
	}
	public double getTotalValue(){
		double value=0;
		if(assets.isEmpty()){
			return 0.0;
		}
		for (int i=0;i<assets.size();i++){
			value+= this.assets.get(i).getValue();
		}
		return value;
	}
	public double getAnnualReturnTotal(){
		double totalAnnualReturn=0.0;
		for(int i=0;i<assets.size();i++){
			totalAnnualReturn+= assets.get(i).annualReturn();
		}
		return totalAnnualReturn;
	}
	public ArrayList<Asset> getAssets() {
		return assets;
	}
	public void setAssets(Asset assets) {
		this.assets.add(assets);
	}
	public double getWieghtedRisk(){  //figures the risk for the total portfolio based on value vs each assets own value
		double risk=0.0;
		for(int i=0;i<assets.size();i++){
			if(assets.get(i).getLetter() == 'D'||assets.get(i).getLetter() == 'd'){
				//Do Nothing NO Risk well expect for the Bacon
			}else if(assets.get(i).getLetter() == 'S'||assets.get(i).getLetter() == 's'){
				risk +=((assets.get(i).getValue()/this.getTotalValue())*((Stock) assets.get(i)).getOmegaMeasure());
			}else if(assets.get(i).getLetter() == 'P'||assets.get(i).getLetter() == 'p'){
				risk +=((assets.get(i).getValue()/this.getTotalValue())*((PrivateInvestment) assets.get(i)).getOmegaMeasure());
			}else{
				System.out.println("The bacon has Gotten loose\t"+assets.get(i).getLetter()+manager.getRank());
				
			}
		}	
		return risk;
	}
}
