package unl.cse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;




//LoadFile class reads both Assets.dat and Persons.dat and sets the data into array to be printed into a XML Fil

public class LoadFile {
	
	 LoadFile peopleList[] = new LoadFile[0];
	 Assets[] assetList = new Assets[0];
	 
	
	public LoadFile() {
	}
	
	//Method prints Assets file to XML 
	public void PrintXMLFile(Assets[] assetList) {
		  try {
			  
				File file = new File("data/Assets.xml");
				for(int i=0;i<assetList.length;i++){
					if(assetList[i] instanceof DepositAccount){
				JAXBContext jaxbContext = JAXBContext.newInstance(DepositAccount.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				
				// output pretty printed
				
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(assetList[i], file);
				jaxbMarshaller.marshal(assetList[i], System.out);
			
					}
					else if(assetList[i] instanceof InvestmentAccounts){
				JAXBContext jaxbContext = JAXBContext.newInstance(InvestmentAccounts.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				
				// output pretty printed
				
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(assetList[i], file);
				jaxbMarshaller.marshal(assetList[i], System.out);
				
					}
					else if(assetList[i] instanceof PrivateInvestments){
				JAXBContext jaxbContext = JAXBContext.newInstance(PrivateInvestments.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				
				// output pretty printed
				
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(assetList[i], file);
				jaxbMarshaller.marshal(assetList[i], System.out);
				
			
					}
					else if(assetList[i] instanceof Stocks){
				JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				
				// output pretty printed
				
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 
				
				jaxbMarshaller.marshal(assetList[i], file);
				jaxbMarshaller.marshal(assetList[i], System.out);
					}
				}
				//for loop was here
			      } catch (JAXBException e) {
				e.printStackTrace();
			      }
	}
	
	
	
	//Persons xml print method
	
	public void PrintXMLPersonFile(Person[] personList) {
		  try {
				File file = new File("data/Persons.xml");
				for(int i=0;i<personList.length;i++){
					if(personList[i] instanceof Broker){
				JAXBContext jaxbContext = JAXBContext.newInstance(Broker.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				
				// output pretty printed
				
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 
				
				jaxbMarshaller.marshal(personList[i], file);
				jaxbMarshaller.marshal(personList[i], System.out);
					}
					else if(personList[i] instanceof Person){
						JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
						Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
						
						// output pretty printed
						
						jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				 
						
						jaxbMarshaller.marshal(personList[i], file);
						jaxbMarshaller.marshal(personList[i], System.out);
					}
					
				}
			      } catch (JAXBException e) {
				e.printStackTrace();
			      }
	}
	
//Method prints address value of the array of assets.
	public void printFile(Assets[] assetList){
		for(int i =0;i<assetList.length;i++){
		System.out.println(assetList[i]);
		}
	}
	
//Method loads Assets.dat to array
	public Assets[] loadFirstFile() {
		int k = 0;
		
    	Scanner s = null;
    	try {
			s = new Scanner(new File("data/Assets.dat"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	String count = s.nextLine();
    	int newCounter = Integer.parseInt(count);
    	 Assets[] assetList = new Assets[newCounter];
		
		
		
    	while(s.hasNext()) {
    		String line = s.nextLine();
    		String tokens[] = line.split(";");
    		String alphaNumeric = "";
    		String type = "";
    		String label = "";
    		alphaNumeric = tokens[0];
    		type = tokens[1];
    		label = tokens[2];
    	
    		
    		if(type.equals("S")){
    			Double quarterlyDividend = 0.00;
    			Double baseRateOfReturn = 0.00;
    			Double omega = 0.00;
    			String stockSymbol = "";
    			Double sharePrice = 0.00;
    			
    			quarterlyDividend = Double.parseDouble(tokens[3]);
    			baseRateOfReturn = Double.parseDouble(tokens[4]);
    			omega = Double.parseDouble(tokens[5]);
    			stockSymbol = tokens[6];
    			sharePrice = Double.parseDouble(tokens[7]);
    			Stocks stock = new Stocks(alphaNumeric,type,label,quarterlyDividend, baseRateOfReturn,omega,stockSymbol,sharePrice);
    			stock.setAlphaNumeric(alphaNumeric);
    			stock.settype(type);
    			stock.setlabel(label);
    			stock.setquarterlyDividend(quarterlyDividend);
    			stock.setbaseRateOfReturn(baseRateOfReturn);
    			stock.setomega(omega);
    			stock.setstockSymbol(stockSymbol);
    			stock.setsharePrice(sharePrice);
    			assetList[k]=stock;
    		
    		}else if(type.equals("D")){
    			Double apr = 0.00;
    			
    			apr = Double.parseDouble(tokens[3]);
    			DepositAccount deposit = new DepositAccount( alphaNumeric,type,label,apr);
    			
    			deposit.setAlphaNumeric(alphaNumeric);
    			deposit.settype(type);
    			deposit.setlabel(label);
    			deposit.setapr(apr);
    			assetList[k]=deposit;
    		
    		}else if (type.equals("P")){
    			Double totalValue = 0.00;
    			Double quarterlyDividend = 0.00;
    			Double baseRateOfReturn = 0.00;
    			Double omega = 0.00;
    			
    			quarterlyDividend = Double.parseDouble(tokens[3]);
    			baseRateOfReturn = Double.parseDouble(tokens[4]);
    			omega = Double.parseDouble(tokens[5]);
    			
    			totalValue = Double.parseDouble(tokens[3]);
    			PrivateInvestments privateInvestment = new PrivateInvestments(alphaNumeric,type,label,quarterlyDividend,baseRateOfReturn, omega,totalValue);
    			privateInvestment.setAlphaNumeric(alphaNumeric);
    			privateInvestment.settype(type);
    			privateInvestment.setlabel(label);
    			privateInvestment.setquarterlyDividend(quarterlyDividend);
    			privateInvestment.setbaseRateOfReturn(baseRateOfReturn);
    			privateInvestment.setomega(omega);
    			privateInvestment.settotalValue(totalValue);
    			assetList[k]=privateInvestment;
    			
    		}
 	
    		k++;
    	}
		return assetList;
    	
    }   
    //Method loads Persons.dat to an array
    public Person[] loadFilePerson() {
    	Scanner t = null;
    	try {
			t = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	int k = 0;
		int totalNumber = Integer.parseInt(t.nextLine());
		Person[] newPersonArray = new Person[totalNumber];
		
    	while(t.hasNext()) {
    		String Code = "";
    		String firstName = "";
    		String lastName = "";
    		String Street = "";
    		String City = "";
    		String State = "";
    		String Zip = "";
    		String Country = "";
    		
    		String line = t.nextLine();
    		String tokens[] = line.split(";");
    		Code = tokens[0];
			String fullName[] = tokens[2].split(",");
			firstName = fullName[0];
			lastName = fullName[1];
			String Address[]=tokens[3].split(",");
			Street = Address[0];
			City = Address[1];
			State = Address[2];
			Zip = Address[3];
			Country = Address[4];  
			String firstEmail = "";
			String secondEmail = "";
			boolean answer = false;
			//Beginning of email delimiting
			if(tokens.length>4){

				String emailLine[]=tokens[4].split(",");
				firstEmail =emailLine[0];
				if(emailLine.length >1 && !emailLine[1].isEmpty()){	
					secondEmail =emailLine[1];
					answer = true;
				}
				
			}
    		if(!tokens[1].isEmpty()){
    			String initial = "";
    			String identifier = "";
    			Broker newBroker = new Broker( Code, initial,  identifier,  firstName,  lastName, Street,  City,  State,  Zip,  Country);
    			String details[]=tokens[1].split(",");
    			initial = details[0];
    			identifier = details[0];

    			newBroker.setCode(Code);
    			newBroker.setInitial(initial);
    			newBroker.setIdentifier(identifier);
    			newBroker.setFirstName(firstName);
    			newBroker.setLastName(lastName);
    			newBroker.setStreet(Street);
    			newBroker.setCity(City);
    			newBroker.setState(State);
    			newBroker.setZip(Zip);
    			newBroker.setCountry(Country);
    			
    			if(tokens.length>4){
    				newBroker.setEmailName(firstEmail);
    					if(answer){	
    						newBroker.setEmailName(secondEmail);
    					}
    			}
    			newPersonArray[k]=newBroker;
    				
    		}else{
        		Person newPerson = new Person( Code,  firstName,  lastName,  Street,  City,  State,  Zip,  Country);
    			newPerson.setCode(Code);
    			newPerson.setFirstName(firstName);
    			newPerson.setLastName(lastName);
    			newPerson.setStreet(Street);
    			newPerson.setCity(City);
    			newPerson.setState(State);
    			newPerson.setZip(Zip);
    			newPerson.setCountry(Country);
   
    			if(tokens.length>4){
    				newPerson.setEmailName(firstEmail);
    					if(answer){	
    						newPerson.setEmailName(secondEmail);
    					}
    			}
    			newPersonArray[k]=newPerson;
    		}
    		k++;

    	}//End of while loop
		return newPersonArray;
    }//   End of LoadFilePerson
}
