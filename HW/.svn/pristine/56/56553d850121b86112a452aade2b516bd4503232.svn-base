package unl.cse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/*
 * The LoadDatabase.java class loads all data into the mysql Database
 */
public class LoadDatabase {
	private static Logger logger=Logger.getLogger("HW");
	
	/*
	 * getAllPortfolio() method returns a list of portfolios contained within the database.
	 */
	public static Lists getAllPortfolio(Lists portfolioList){
		Connection conn = ConnectionFactory.getConnection();
		String query ="SELECT portfolioCode,portfolioID,managerID,ownerID,beneficiaryID FROM Portfolio";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Portfolio p = new Portfolio();
				p.setPortfolioCode(rs.getString("portfolioCode"));
				p.setManager(getBroker(rs.getInt(3)));
				p.setOwner(getPerson(rs.getInt(4)));
				if((Integer)rs.getInt(5) != null){
					p.setBeneficiary(getPerson(rs.getInt(5)));
				}
				p.setAssetList( getAllAsset(rs.getInt("portfolioID")));
				portfolioList.add(p);
				
			}
		}catch(SQLException e ){
			logger.error("SQL error in getAllPortfolio",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
		return portfolioList;
	}
	/*
	 * getAllAssets() method returns a list of Assets that have a specific portolioID
	 */
	private static  ArrayList<Asset> getAllAsset(int portfolioID) {
		ArrayList<Asset> asset = new ArrayList<Asset>();
		Connection conn = ConnectionFactory.getConnection();
		String query ="SELECT p.portfolioID, a.assetID,a.assetCode,a.`char`,pa.totalValue FROM Asset AS a JOIN portfolioAsset AS pa ON pa.assetID = a.assetID JOIN Portfolio AS p ON pa.portfolioID = p.portfolioID Where p.portfolioID = (?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, portfolioID);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("Char").contains("D")){
					Deposit d = new Deposit();
					getDeposit(rs.getInt("assetID"),d);
					d.setAmount(rs.getDouble("totalValue"));
					asset.add(d);
				}else if (rs.getString("Char").contains("S")){
					Stock s = new Stock();
					getStock(rs.getInt("assetID"),s);
					s.setShareOwned(rs.getDouble("totalValue"));
					asset.add(s);
				}else if(rs.getString("Char").contains("P")){
					PrivateInvestment p = new PrivateInvestment();
					getInvestment(rs.getInt("assetID"),p);
					p.setPercentageStake(rs.getDouble("totalValue")*100);
					asset.add(p);
				}else{
					logger.error("in the AssetAdder");
				}
			}
		}catch(SQLException e ){
			logger.error("SQL error in getAsset",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
		return asset;
	}
	/*
	 * getAllPortfolio() method returns a list of investments with a specific 
	 * assetID and PrivateInvestment contained within the database.
	 */
	private static  void getInvestment(int assetID , PrivateInvestment p) {
		Connection conn = ConnectionFactory.getConnection();
		String query ="SELECT assetCode,`label`,quarterlyDivident,baseRateOfReturn,omega,assetValue FROM Asset WHERE assetID = (?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, assetID);
			rs = ps.executeQuery();
			if(rs.next()){
				p.setCode(rs.getString(1));
				p.setLabel(rs.getString(2));
				p.setQuarterlyDivident(rs.getDouble(3));
				p.setBaseRateOfReturn(rs.getDouble(4)*100);
				p.setLetter('P');
				p.setOmegaMeasure(rs.getDouble(5)+.25);
				p.setTotalValue(rs.getDouble(6));
			}
					
		}catch(SQLException e ){
			logger.error("SQL error in getInvestment",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
	}
	
	/*
	 * getStock() method retrieves the stock of a specific assetID
	 */
	private static  void getStock(int assetID, Stock s) {
		Connection conn = ConnectionFactory.getConnection();
		String query ="SELECT assetCode, `label`,quarterlyDivident,baseRateOfReturn,omega,stockSymbol,sharePrice FROM Asset WHERE assetID =(?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, assetID);
			rs = ps.executeQuery();
			if(rs.next()){
				s.setCode(rs.getString(1));
				s.setLabel(rs.getString(2));
				s.setQuarterlyDivident(rs.getDouble(3));
				s.setBaseRateOfReturn(rs.getDouble(4)*100);
				s.setLetter('S');
				s.setOmegaMeasure(rs.getDouble(5)+.1);
				s.setStockSymbol(rs.getString(6));
				s.setSharePrice(rs.getDouble(7));
			}
			
		}catch(SQLException e ){
			logger.error("SQL error in getStock",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
		
	}
	/*
	 * getDeposit() method retrieves the deposit of a specific assetID
	 */
	private static  void getDeposit(int assetID,Deposit d) {
		Connection conn = ConnectionFactory.getConnection();
		String query ="SELECT assetCode,`label`,annualPercentRate FROM Asset WHERE assetID =(?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, assetID);
			rs = ps.executeQuery();
			if(rs.next()){
				d.setLetter('D');
				d.setCode(rs.getString(1));
				d.setLabel(rs.getString(2));
				d.setAPR(rs.getDouble(3)*100);	
			}
				
		}catch(SQLException e ){
			logger.error("SQL error in getDeposit",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
	//return d;
	}
	/*
	 * getPerson() method retrieves the person with a specific personID
	 */
	private static  Person getPerson(int personID) {
		Person person = new Person();
		Connection conn = ConnectionFactory.getConnection();
		String query ="SELECT personCode,lastName,FirstName,brokerCode,SECIdentifier FROM Person WHERE personID = (?);";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, personID);
			rs = ps.executeQuery();
			if(rs.next()){
				person.setPersonCode(rs.getString(1));
				person.setNameLast(rs.getString("lastName"));
				person.setNameFirst(rs.getString("firstName"));
				person.setMailingAddress(getMailAddress(personID));
				person.setEmailAddress(getEmail(personID));	
			}
		}catch(SQLException e ){
			logger.error("SQL error getPerson",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
		return person;
		
	}
	/*
	 * getEmail() method retrieves the email(s) of a person with a specific personID
	 */
	private static  ArrayList<String> getEmail(int personID) {
		ArrayList<String> email = new ArrayList<String>();
		Connection conn = ConnectionFactory.getConnection();
		String query ="SELECT emailAddress FROM Email WHERE personID = (?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps =conn.prepareStatement(query);
			ps.setInt(1, personID);
			rs = ps.executeQuery();			
			while(rs.next()){
				email.add(rs.getString("emailAddress"));
			}
		}catch(SQLException e ){
			logger.error("SQL error in getting Email for a given personID",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
		return email;
	}
	/*
	 * getMailaddress() method retrieves the mail address of a person with a specific personID
	 */
	private static  Address getMailAddress(int personID) {
		Address a = new Address();
		Connection conn = ConnectionFactory.getConnection();
		String query ="SELECT street, city, state, zip, country FROM mailAddress WHERE personID = (?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, personID);
			rs = ps.executeQuery();
			if(rs.next()){
				a.setStreet(rs.getString("street"));
				a.setCity(rs.getString("city"));
				a.setState(rs.getString("state"));
				a.setZIP(rs.getString("zip"));
				a.setCountry(rs.getString("country"));
			}		
		}catch(SQLException e ){
			logger.error("SQL error in getting address for a given personID",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
		return a;
	}
	private static  Broker getBroker(int personID) {
		Broker broker = new Broker();
		Connection conn = ConnectionFactory.getConnection();
		String query ="SELECT personCode,lastName,FirstName,brokerCode,SECIdentifier FROM Person WHERE personID = (?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, personID);
			rs = ps.executeQuery();
			if(rs.next()){
				broker.setPersonCode(rs.getString("personCode"));
				broker.setNameLast(rs.getString("lastName"));
				broker.setNameFirst(rs.getString("firstName"));
				broker.setRank(rs.getString("brokerCode").charAt(0));
				broker.setSEC(rs.getString("SECIdentifier"));
				broker.setMailingAddress(getMailAddress(personID));
				broker.setEmailAddress(getEmail(personID));
			}
		}catch(SQLException e ){
			logger.error("SQL error Loading Broker from DB",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
		return broker;
		
	}
	
}
