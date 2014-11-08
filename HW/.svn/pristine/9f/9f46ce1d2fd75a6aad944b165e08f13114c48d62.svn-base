package unl.cse;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To call use DataConverter.deserialize("data/Persons.dat,data/Assets.dat,data/Portfolios.dat");
 * 
 */


/*
 * DataConverter.java populates ArrayList objects for each of the object types from three 
 * separate file inputs; Persons.dat, Assets.dat, and Portfolio.dat.
 */

public class DataConverter {
	
	public static Lists deserialize(String inputs) {
		String tokenInput[] = inputs.split(",");
		if(tokenInput.length != 3){
			System.out.println("Error Need Data Files in Persons.dat, Assets.dat, and Portfolio.dat");
		}
		
		String peopleFile = tokenInput[0];							//start of reading in person file
		Scanner s = null;

		try {
			s = new Scanner(new File(peopleFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Person> personList = new ArrayList<Person>();
		ArrayList<Broker> brokerList = new ArrayList<Broker>();
		int numberOfPeople = 0,countofReadInPerson = 0;
		numberOfPeople = s.nextInt();
		
		s.nextLine();
		
		while(s.hasNext() &&(numberOfPeople > countofReadInPerson)){
			s.useDelimiter("\\n");
			String line =  s.nextLine();
			String token[] =line.split(";");
			String personCode= token[0];
			String nameToken[] = token[2].split(",");
			String lastName = nameToken[0].replaceAll("\\s", "");
			String firstName = nameToken[1].replaceAll("\\s", "");
			
			String addressToken[] = token[3].split(",");
			Address a = new Address(addressToken[0],addressToken[1],addressToken[2],addressToken[3],addressToken[4]);
			
			if(token.length < 5){
				if(token[1].equals("")){
					Person e = new Person(personCode,lastName,firstName,a,new ArrayList<String>());
					personList.add(e);
				}else{
					String subToken[] = token[1].split(",");
					char rank = (subToken[0].charAt(0));
					String SEC = (subToken[1]);
					Broker e = new Broker(personCode,  firstName, lastName, a, new ArrayList<String>(),rank, SEC);
					brokerList.add(e);
					personList.add(e);
				}
			}else{
				String emailToken[] = token[4].split(",");
				ArrayList<String> emailList = new ArrayList<String>();	
				for(int i = 0; i < emailToken.length;i++){
					emailList.add(emailToken[i]);
				}
				if(token[1].equals("")){
					Person e = new Person(personCode,lastName,firstName,a,emailList);
					personList.add(e);
				}else{
					String subToken[] = token[1].split(",");
					char rank = (subToken[0].charAt(0));
					String SEC = (subToken[1]);
					Broker e = new Broker(personCode, firstName, lastName, a, emailList, rank, SEC);
					brokerList.add(e);
					personList.add(e);
				}
			}
		countofReadInPerson++;
		}
		s.close();
		
		if(!(personList.size() == numberOfPeople)){						//checks to make sure all items were read in from file		
			System.out.printf("There appaers to be a problem with person %d,%d", personList.size(),numberOfPeople);
		}else{
			//System.out.println("all clear within read in of Person");
		}
		
		Flatten.flattenToXML(personList,"person");
		Flatten.flattenToGson(personList, "people");
		
																		//end of Person Parse and write begin of assets
		
		
		
		String assetFile = tokenInput[1];
		Scanner sAsset = null;

		try {
			sAsset = new Scanner(new File(assetFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Asset> assetList = new ArrayList<Asset>();
		int numberOfAsset = 0,countOFReadInAsset=0;
		numberOfAsset = sAsset.nextInt();
		sAsset.nextLine();
		
		while(sAsset.hasNext()&&(countOFReadInAsset<numberOfAsset)){
			sAsset.useDelimiter("\\n");
			String line =  sAsset.nextLine();
			String token[] =line.split(";");
			if(token[1].equalsIgnoreCase("D")){
				Deposit d = new Deposit();
				d.setCode(token[0]);
				d.setLetter(token[1].charAt(0));
				d.setLabel(token[2]);
				d.setAPR(((Double.parseDouble(token[3]))));
				assetList.add(d);
			}else if(token[1].equalsIgnoreCase("S")){
				Stock stock = new Stock();
				stock.setCode(token[0]);
				stock.setLetter(token[1].charAt(0));
				stock.setLabel(token[2]);
				stock.setQuarterlyDivident((Double.parseDouble(token[3])));
				stock.setBaseRateOfReturn((Double.parseDouble(token[4])));
				stock.addOmegaMeasure((Double.parseDouble(token[5])));
				stock.setStockSymbol(token[6]);
				stock.setSharePrice((Double.parseDouble(token[7])));
				assetList.add(stock);
			}else if (token[1].equalsIgnoreCase("P")){
				PrivateInvestment pI = new PrivateInvestment();
				pI.setCode(token[0]);
				pI.setLetter(token[1].charAt(0));
				pI.setLabel(token[2]);
				pI.setQuarterlyDivident((Double.parseDouble(token[3])));
				pI.setBaseRateOfReturn((Double.parseDouble(token[4])));
				pI.addOmegaMeasure((Double.parseDouble(token[5])));
				pI.setTotalValue((Double.parseDouble(token[6])));
				assetList.add(pI);					
			}
			countOFReadInAsset++;
			
		}
		sAsset.close();
		
		if(!(assetList.size() == numberOfAsset)){					//checks to make sure all items were read in from file
			System.out.printf("There appaers to be a problem with asset %d,%d", assetList.size(),numberOfAsset);
		}else{
			//System.out.println("all clear with read in of Asset");
		}
		Flatten.flattenToGson(assetList, "asset");
		Flatten.flattenToXML(assetList, "asset");
		
		
																	//end of asset parse begin of portfolio 
		
		String portfolioFile = tokenInput[2];
		Scanner sPortfolio = null;
		
		try {
			sPortfolio = new Scanner(new File(portfolioFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Lists portfolioList = new Lists();
		int numberOfPortfolio = 0, countOFReadInPortfolio=0;
		numberOfPortfolio = sPortfolio.nextInt();
		sPortfolio.nextLine();
		
		while(sPortfolio.hasNext()&&(countOFReadInPortfolio<numberOfPortfolio)){		//start of work
			sPortfolio.useDelimiter("\\n");
			String line =  sPortfolio.nextLine();
			String token[] =line.split(";");
			Portfolio portfolio = new Portfolio();
			portfolio.setPortfolioCode(token[0]);
			for(int i=0; i<personList.size();i++){
				if(token[1].equalsIgnoreCase(personList.get(i).getPersonCode())){
					portfolio.setOwner(personList.get(i));
					break;
				}
			}
			for(int i=0; i<brokerList.size();i++){
				if(token[2].equalsIgnoreCase(brokerList.get(i).getPersonCode())){
					portfolio.setManager(brokerList.get(i));
					break;
				}
			}
			if(token.length >=4 && !(token[3].equals(""))){
				for(int i=0; i<personList.size();i++){
					if(token[3].equalsIgnoreCase(personList.get(i).getPersonCode())){
						portfolio.setBeneficiary(personList.get(i));
						break;
					}
				}
			}
		
			int portfolioAsset = 0,i=0;
			if(token.length>=5 && !(token[4].equals("")) ){
				while(portfolioAsset < numberOfPortfolio){
					String assetString[] = token[4].split(",");
					i =0;
					while(assetString.length > portfolioAsset){
						String tokenAsset[] = assetString[portfolioAsset].split(":");
						
						if(tokenAsset[0].equalsIgnoreCase(assetList.get(i).getCode())){
							if((assetList.get(i).getLetter()==('D'))){
								Deposit d = new Deposit();
								d.setLetter(assetList.get(i).getLetter());
								d.setLabel(assetList.get(i).getLabel());
								d.setCode(assetList.get(i).getCode());
								d.setAPR(((Deposit) assetList.get(i)).getAPR());
								d.setAmount(Double.parseDouble(tokenAsset[1]));
								portfolio.setAssets(d);
							}else if (assetList.get(i).getLetter() ==('S')){
								Stock stock = new Stock();
								stock.setLetter('S');
								stock.setCode(assetList.get(i).getCode());
								stock.setBaseRateOfReturn(((Investment) assetList.get(i)).getBaseRateOfReturn());
								stock.setLabel(assetList.get(i).getLabel());
								stock.setOmegaMeasure(( (Stock) assetList.get(i)).getOmegaMeasure());
								stock.setQuarterlyDivident(((Investment) assetList.get(i)).getQuarterlyDivident());
								stock.setStockSymbol(((Investment) assetList.get(i)).getStockSymbol());
								stock.setSharePrice(((Stock) assetList.get(i)).getSharePrice());
								stock.setShareOwned(Double.parseDouble(tokenAsset[1]));
								portfolio.setAssets(stock);
							}else if(assetList.get(i).getLetter() == ('P')){
								PrivateInvestment pI = new PrivateInvestment();
								pI.setCode(assetList.get(i).getCode());
								pI.setLetter(assetList.get(i).getLetter());
								pI.setLabel(assetList.get(i).getLabel());
								pI.setQuarterlyDivident(((Investment) assetList.get(i)).getQuarterlyDivident());
								pI.setBaseRateOfReturn(((Investment) assetList.get(i)).getBaseRateOfReturn());
								pI.setOmegaMeasure(((PrivateInvestment) assetList.get(i)).getOmegaMeasure());
								pI.setTotalValue(((PrivateInvestment) assetList.get(i)).getTotalValue());
								pI.setPercentageStake(Double.parseDouble(tokenAsset[1]));
								portfolio.setAssets(pI);
							}
							
							break;
						}
						
						i++;
						
					}			
					portfolioAsset++;
					
				}
			}
			
			
			
			
			portfolioList.add(portfolio);
			countOFReadInPortfolio++;
			
		}
		sPortfolio.close();
		if(countOFReadInPortfolio != numberOfPortfolio){
			System.out.println("Error Number of Portfolio doesnt match up with what was read in");
		}
	
	
		
		
		//Flatten.flattenToXML(portfolioList, "portfolio");
		//Flatten.flattenToGson(portfolioList, "portfolio");
		return portfolioList;
	}
}


