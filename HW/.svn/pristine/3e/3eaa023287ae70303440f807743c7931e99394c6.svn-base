package unl.cse;
import java.util.ArrayList;

/*
 * PortfolioReport.java creates an arraylist of portfolios and 
 * populates the information to be returned to the console
 *
 *
public class PortfolioReport {
	
	public static void main(String[] args) {
				
		ArrayList<Portfolio> portfolioList = new ArrayList<Portfolio>();
		LoadDatabase.getAllPortfolio(portfolioList);
		
		
			System.out.println("Portfolio Summary Report");
			System.out.println("============================================================================================================================");			//begin of summary
			System.out.printf("%-11s %-19s %-22s %10s %12s %13s %14s %15s%n","Portfolio","Owner","Manager","Fees","Commissions","Weighted Risk","Return","Total");
			double totalFee=0.0,totalComission=0.0,totalAnnual = 0.0,totalValue=0.0;
			for(int i=0;i<portfolioList.size();i++){
				System.out.printf("%-11s %-19s %-22s $%8.2f $%12.2f %12.4f $%14.2f $%14.2f%n",portfolioList.get(i).getPortfolioCode(),
													portfolioList.get(i).getOwner().getName(),
													portfolioList.get(i).getManager().getName(),
													portfolioList.get(i).getFee(),
													portfolioList.get(i).getCommission(),
													portfolioList.get(i).getWieghtedRisk(),
													portfolioList.get(i).getAnnualReturnTotal(),
													portfolioList.get(i).getTotalValue());
				totalFee += portfolioList.get(i).getFee();
				totalComission += portfolioList.get(i).getCommission();
				totalAnnual += portfolioList.get(i).getAnnualReturnTotal();
				totalValue += portfolioList.get(i).getTotalValue();
			}
			System.out.println();
			System.out.printf("%124s%n","-------------------------------------------------------------------------");
			System.out.printf("%54s $%8.2f  $%12.2f		        $%12.2f $%14.2f%n","Totals",totalFee,totalComission,totalAnnual,totalValue);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("Portfolio Detail Report");
			System.out.println("============================================================================================================================");
			
			for(int i=0;i<portfolioList.size();i++){																													//Begin of detail loop
				double subTotalValue = 0.0,subTotalReturn = 0.0;
				System.out.printf("PortFolio  %s%n",portfolioList.get(i).getPortfolioCode());
				System.out.println("-----------------------------------------------------------");
				System.out.printf("%-15s %s%n", "Owner:",portfolioList.get(i).getOwner().getName());
				System.out.printf("%-15s %s%n", "Manager:",portfolioList.get(i).getManager().getName());
				System.out.printf("%-15s %s%n","Beneficiary:",portfolioList.get(i).getBeneficiary().getName());
				System.out.println("Assets");
				System.out.printf("%-11s %-39s %-17s %-14s %-22s %-20s%n","Code","Asset","Return Rate","Risk (Omega)","Annual Return","Value" );
				for(int j=0;j<portfolioList.get(i).getAssetList().size();j++){
					if(portfolioList.get(i).getAssetList().get(j).getLetter() =='D'){
						System.out.printf("%-10s %-43s %6.2f%% %19s   $%13.2f   $%12.2f%n",
								portfolioList.get(i).getAssetList().get(j).getCode(),
								portfolioList.get(i).getAssetList().get(j).getLabel(),
								portfolioList.get(i).getAssetList().get(j).rateOfReturn(),
								"0.00",
								portfolioList.get(i).getAssetList().get(j).annualReturn(),
								((Deposit) portfolioList.get(i).getAssetList().get(j)).getAmount());
						
						subTotalReturn += portfolioList.get(i).getAssetList().get(j).annualReturn();
						subTotalValue+=((Deposit) portfolioList.get(i).getAssetList().get(j)).getAmount();
					}else if(portfolioList.get(i).getAssetList().get(j).getLetter() =='S'){
						System.out.printf("%-10s %-43s %6.2f%% %19.2f   $%13.2f   $%12.2f%n",
								portfolioList.get(i).getAssetList().get(j).getCode(),
								portfolioList.get(i).getAssetList().get(j).getLabel(),
								portfolioList.get(i).getAssetList().get(j).rateOfReturn(),
								((Stock) portfolioList.get(i).getAssetList().get(j)).getOmegaMeasure(),
								portfolioList.get(i).getAssetList().get(j).annualReturn(),
								((Stock) portfolioList.get(i).getAssetList().get(j)).getValue());
						
						subTotalReturn +=portfolioList.get(i).getAssetList().get(j).annualReturn();
						subTotalValue+=((Stock) portfolioList.get(i).getAssetList().get(j)).getValue();
					}else if(portfolioList.get(i).getAssetList().get(j).getLetter() =='P'){
						System.out.printf("%-10s %-43s %6.2f%% %19.2f   $%13.2f   $%12.2f%n",
								portfolioList.get(i).getAssetList().get(j).getCode(),
								portfolioList.get(i).getAssetList().get(j).getLabel(),
								((Investment) portfolioList.get(i).getAssetList().get(j)).rateOfReturn(),
								((PrivateInvestment) portfolioList.get(i).getAssetList().get(j)).getOmegaMeasure(),
								portfolioList.get(i).getAssetList().get(j).annualReturn(),
								((PrivateInvestment) portfolioList.get(i).getAssetList().get(j)).getValue());
						
						subTotalValue+=((PrivateInvestment) portfolioList.get(i).getAssetList().get(j)).getValue();
						subTotalReturn += portfolioList.get(i).getAssetList().get(j).annualReturn();
					}else{
						System.out.println("Error");
					}
						
				}
				System.out.printf("%115s%n","----------------------------------------------------");
				System.out.printf("%60s %20.4f   $%13.2f   $%12.2f%n","Totals",portfolioList.get(i).getWieghtedRisk(),subTotalReturn,subTotalValue);
				System.out.println();
				System.out.println();
				System.out.println();
			}
	
		
		
	}
}
*/