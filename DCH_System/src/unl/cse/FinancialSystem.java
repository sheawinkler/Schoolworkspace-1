package unl.cse;


//Main System:  This section creates an instance of LoadFile.java and pushes that data to an XML file.
public class FinancialSystem {
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        FinancialSystem demo = new FinancialSystem();
        LoadFile newLoad = new LoadFile();
        Assets[] newAssetList =newLoad.loadFirstFile();
        newLoad.PrintXMLFile(newAssetList);
        
        Person[] newPersons = newLoad.loadFilePerson();
        newLoad.PrintXMLPersonFile(newPersons);
	}
}
