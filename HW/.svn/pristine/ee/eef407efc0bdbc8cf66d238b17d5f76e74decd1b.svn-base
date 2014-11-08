package unl.cse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * This is a collection of utility methods that define a general API for
 * interacting with the database supporting this application.
 *
 */
public class PortfolioData {
	//sets up the logger
	private static Logger logger=LogManager.getLogger(PortfolioData.class.getName());

	/**
	 * Method that removes every person record from the database
	 */
	public static void removeAllPersons() {
		removeAllPortfolios();
		removeAllEmail();
		removeAllMailAddress();
		Connection conn = ConnectionFactory.getConnection();
		String query ="DELETE FROM Person";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in dropping All Persons Table",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}
	
	/**
	 * Removes the person record from the database corresponding to the
	 * provided <code>personCode</code>
	 * @param personCode
	 */
	public static void removePerson(String personCode) {
		removeEmail(personCode);
		removeMailAddress(personCode);
		Connection conn = ConnectionFactory.getConnection();
		String query,  queryDelete = "DELETE FROM Portfolio WHERE PortfolioID = (?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		for(int i =0;i<3;i++){
			if(i==0){
				query ="SELECT portfolioID FROM Portfolio WHERE beneficiaryID = (?)";
			}else if(i==1){
				query ="SELECT portfolioID FROM Portfolio WHERE ownerID = (?)";
			}else{
				query ="SELECT portfolioID FROM Portfolio WHERE managerID = (?)";
			}
			
			try{
				ps = conn.prepareStatement(query);
				ps.setInt(1, getPersonID(personCode));
				rs = ps.executeQuery();
				while(rs.next()){
					removePortfolioAsset(rs.getInt(1));
					ps = conn.prepareStatement(queryDelete);
					ps.setInt(1, rs.getInt("portfolioID"));
					ps.executeUpdate();
				}
			}catch(SQLException e ){
				logger.error("SQL error in Deleting all of Portfolio Table relating to a given person",e);
			}	
		}
		
		query ="DELETE FROM Person WHERE personCode = (?)";
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, personCode);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in removing person from Person Table",e);
		}
		
		ConnectionFactory.closeConnection(conn,ps);
	}
	
	

	/**
	 * Method to add a person record to the database with the provided data. The
	 * <code>brokerType</code> will either be "E" or "J" (Expert or Junior) or 
	 * <code>null</code> if the person is not a broker.
	 * @param personCode
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @param brokerType
	 */

	public static void addPerson(String personCode, String firstName, String lastName, String street, String city, String state, String zip, String country, String brokerType, String secBrokerId) {
		Connection conn = ConnectionFactory.getConnection();
		String query ="INSERT INTO Person(personCode,firstName,lastName,brokerCode,SECIdentifier) VALUES (?,?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer personID = null;
		if((brokerType) != null){
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, personCode);
				ps.setString(2, firstName);
				ps.setString(3, lastName);
				ps.setString(4, brokerType);
				ps.setString(5, secBrokerId);					
				ps.executeUpdate();			
			}catch(SQLException e){
				logger.error("SQLExpcetion: in Adding broker INTO Person Table",e);
			}
		}else{
			try {
				query ="INSERT INTO Person(personCode,firstName,lastName) VALUES (?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setString(1, personCode);
				ps.setString(2, firstName);
				ps.setString(3, lastName);
				ps.executeUpdate();			
			}catch(SQLException e){
				logger.error("SQLExpcetion: in adding person INTO Person Table",e);
			}
		}
		
		personID = getPersonID(personCode);
		
		try{
			String queryAddress = "SELECT * From mailAddress WHERE personID = (?)";
			ps = conn.prepareStatement(queryAddress);
			ps.setInt(1, personID);
			rs = ps.executeQuery();
			if(!rs.next()){
				queryAddress = "INSERT INTO mailAddress (personID,street,city,state,zip,country) VALUES (?,?,?,?,?,?)";
				try{
					ps = conn.prepareStatement(queryAddress);
					ps.setInt(1, personID);
					ps.setString(2, street);
					ps.setString(3, city);
					ps.setString(4, state);
					ps.setString(5,zip);
					ps.setString(6, country);
					ps.execute();
				}catch(SQLException e ){
					logger.error("SQL error adding address to database",e);
				}
			}
		}catch(SQLException e ){
			logger.error("SQL error in address",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
		
	}
	
	/**
	 * Adds an email record corresponding person record corresponding to the
	 * provided <code>personCode</code>
	 * @param personCode
	 * @param email
	 */
	public static void addEmail(String personCode, String email) {
		
		Connection conn = ConnectionFactory.getConnection();
		String query = "INSERT INTO Email (personID,emailAddress) VALUES (?,?)";
		PreparedStatement ps = null;
		
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, getPersonID(personCode));
			ps.setString(2, email);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in add Email Table -adding email",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}

	/**
	 * Removes all asset records from the database
	 */
	public static void removeAllAssets() {
		removeAllPortfolioAsset();
		Connection conn = ConnectionFactory.getConnection();
		String query = "DELETE FROM Asset";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in removeAllAssets->deleting all info from Asset Table",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}
	/**
	 * Removes the asset record from the database corresponding to the
	 * provided <code>assetCode</code>
	 * @param assetCode
	 */
	public static void removeAsset(String assetCode) {
		Connection conn = ConnectionFactory.getConnection();
		String query ="DELETE FROM portfolioAsset where assetID = (SELECT assetID FROM Asset WHERE assetCode = (?)";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, assetCode);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in removeAllAssets->deleting given asset from portfolioAsset Table",e);
		}
		query = "DELETE FROM Asset WHERE assetCode = (?)";
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, assetCode);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in removeAllAssets->deleting given asset from Asset Table",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}
	
	/**
	 * Adds a deposit account asset record to the database with the
	 * provided data. 
	 * @param assetCode
	 * @param label
	 * @param apr
	 */
	public static void addDepositAccount(String assetCode, String label, double apr) {
		Connection conn = ConnectionFactory.getConnection();
		String query = "INSERT INTO Asset (assetCode,`label`,`char`,annualPercentRate)Values(?,?,'D',?)";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, assetCode);
			ps.setString(2, label);
			ps.setDouble(3, apr);
			ps.executeUpdate();			
		}catch(SQLException e ){
			logger.error("SQL error in Adding Deposit Account to Asset Table",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
		
	}
	
	/**
	 * Adds a private investment asset record to the database with the
	 * provided data. 
	 * @param assetCode
	 * @param label
	 * @param quarterlyDividend
	 * @param baseRateOfReturn
	 * @param omega
	 * @param totalValue
	 */
	public static void addPrivateInvestment(String assetCode, String label, Double quarterlyDividend, 
			Double baseRateOfReturn, Double omega, Double totalValue) {
		Connection conn = ConnectionFactory.getConnection();
		String query = "INSERT INTO Asset (assetCode,`label`,`char`,quarterlyDivident,baseRateOfReturn,omega,assetValue)Values(?,?,'P',?,?,?,?)";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, assetCode);
			ps.setString(2, label);
			ps.setDouble(3, quarterlyDividend);
			ps.setDouble(4, baseRateOfReturn);
			ps.setDouble(5, omega);
			ps.setDouble(6, totalValue);
			ps.executeUpdate();			
		}catch(SQLException e ){
			logger.error("SQL error in Adding Private Investment Account to Asset Table",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}
	
	/**
	 * Adds a stock asset record to the database with the
	 * provided data. 
	 * @param assetCode
	 * @param label
	 * @param quarterlyDividend
	 * @param baseRateOfReturn
	 * @param omega
	 * @param stockSymbol
	 * @param sharePrice
	 */
	public static void addStock(String assetCode, String label, Double quarterlyDividend, 
			Double baseRateOfReturn, Double omega, String stockSymbol, Double sharePrice) {
		Connection conn = ConnectionFactory.getConnection();
		String query = "INSERT INTO Asset (assetCode, `label`, `char`, quarterlyDivident, baseRateOfReturn, omega, stockSymbol, sharePrice) Values (?,?,'S',?,?,?,?,?)";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, assetCode);
			ps.setString(2, label);
			ps.setDouble(3, quarterlyDividend);
			ps.setDouble(4, baseRateOfReturn);
			ps.setDouble(5, omega);
			ps.setString(6, stockSymbol);
			ps.setDouble(7, sharePrice);
			ps.executeUpdate();			
		}catch(SQLException e ){
			logger.error("SQL error in Adding Stock to Asset Table",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}

	/**
	 * Removes all portfolio records from the database
	 */
	public static void removeAllPortfolios() {
		removeAllPortfolioAsset();
		Connection conn = ConnectionFactory.getConnection();
		String query ="DELETE FROM Portfolio";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in removeAllPortfolios removing all info from Portfolio Table",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}
	
	/**
	 * Removes the portfolio record from the database corresponding to the
	 * provided <code>portfolioCode</code>
	 * @param portfolioCode
	 */
	public static void removePortfolio(String portfolioCode) {
		Connection conn = ConnectionFactory.getConnection();
		String query ="DELETE FROM portfolioAsset WHERE portfolioID = (SELECT portfolioID FROM Portfolio WHERE portfolioCode = (?))";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, portfolioCode);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in Deleting protfolioAsset with given portfolioCode",e);
		}
		query = "DELETE FROM Portfolio WHERE portfolioCode= (?)";
		
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, portfolioCode);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in Deleteing Portfolio given portfolioCode",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}
	
	/**
	 * Adds a portfolio records to the database with the given data.  If the portfolio has no
	 * beneficiary, the <code>beneficiaryCode</code> will be <code>null</code>
	 * @param portfolioCode
	 * @param ownerCode
	 * @param managerCode
	 * @param beneficiaryCode
	 */
	public static void addPortfolio(String portfolioCode, String ownerCode, String managerCode, String beneficiaryCode) {
		Connection conn = ConnectionFactory.getConnection();
		String query ="INSERT INTO Portfolio (portfolioCode, ownerID, managerID) VALUES(?,(?),(?))";
		PreparedStatement ps = null;
		if(beneficiaryCode == null){
			try{
				ps = conn.prepareStatement(query);
				ps.setString(1, portfolioCode);
				ps.setInt(2, getPersonID(ownerCode));
				ps.setInt(3, getPersonID(managerCode));
				ps.executeUpdate();			
			}catch(SQLException e ){
				logger.error("SQL error in Adding new portfolio with Beneficiary",e);
			}
		}else{
			try{
				query = "INSERT INTO Portfolio (portfolioCode, ownerID, managerID,beneficiaryID) VALUES(?,(?),(?),(?))";
				ps = conn.prepareStatement(query);
				ps.setString(1, portfolioCode);
				ps.setInt(2, getPersonID(ownerCode));
				ps.setInt(3, getPersonID(managerCode));
				ps.setInt(4, getPersonID(beneficiaryCode));
				ps.executeUpdate();			
			}catch(SQLException e ){
				logger.error("SQL error in Adding new portfolio without beneficiary",e);
			}
		}
		
		ConnectionFactory.closeConnection(conn,ps);
	}
	
	/**
	 * Associates the asset record corresponding to <code>assetCode</code> with the 
	 * portfolio corresponding to the provided <code>portfolioCode</code>.  The third 
	 * parameter, <code>value</code> is interpreted as a <i>balance</i>, <i>number of shares</i>
	 * or <i>stake percentage</i> depending on the type of asset the <code>assetCode</code> is
	 * associated with.
	 * @param portfolioCode
	 * @param assetCode
	 * @param value
	 */
	public static void addAsset(String portfolioCode, String assetCode, double value) {
		Connection conn = ConnectionFactory.getConnection();
		String query = "INSERT INTO portfolioAsset(portfolioID, assetID,totalValue) VALUES"
				+ "((SELECT portfolioID FROM Portfolio WHERE portfolioCode = (?)),"
				+"(SELECT assetID FROM Asset WHERE assetCode = (?)),?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, portfolioCode);
			ps.setString(2,assetCode);
			ps.setFloat(3, (float) value);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in Adding link between asset and portfolio in portfolioAsset",e);
		}
		ConnectionFactory.closeConnection(rs, conn,ps);
	}
	/**
	 * s complete portfolioAsset Table
	 * @param None
	 */
	private static void removeAllPortfolioAsset() {
		Connection conn = ConnectionFactory.getConnection();
		String query ="DELETE FROM portfolioAsset";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in Deleting all protfolioAsset Table",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}
	/**
	 * Drops complete Email Table
	 * @param None
	 */
	private static void removeAllEmail() {
		Connection conn = ConnectionFactory.getConnection();
		String query ="DELETE FROM Email";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in Deleting all from Email Table",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}
	/**
	 * Drops complete mailAddress Table
	 * @param None
	 */
	private static void removeAllMailAddress() {
		Connection conn = ConnectionFactory.getConnection();
		String query ="DELETE FROM mailAddress";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in Deleting everything from mailAddress Table",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}

	private static void removeEmail(String personCode){
		Connection conn = ConnectionFactory.getConnection();
		String query ="DELETE FROM Email WHERE personID =(?)";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, getPersonID(personCode));
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error in removing an email connected to given personCode",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}
	private static void removeMailAddress(String personCode){
		Connection conn = ConnectionFactory.getConnection();
		String query ="DELETE FROM mailAddress WHERE personID = (?)";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, getPersonID(personCode));
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error removing mailAddress connected to given personCode",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
	}
	private static void removePortfolioAsset(int portfolioID) {
		Connection conn = ConnectionFactory.getConnection();
		String query ="DELETE FROM portfolioAsset WHERE portfolioID = (?)";
		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);
			ps.setInt(1, portfolioID);
			ps.executeUpdate();
		}catch(SQLException e ){
			logger.error("SQL error removing a given portfoiloID in the portfolioAsset",e);
		}
		ConnectionFactory.closeConnection(conn,ps);
		
	}
	
	private static int getPersonID(String personCode){
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer personID= null;
		String query = "SELECT personID FROM Person WHERE personCode = (?)";
		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, personCode);
			rs = ps.executeQuery();
			if(rs.next()){
				personID = rs.getInt("personID");
			}
		}catch(SQLException e){
			logger.error("SQLExpcetion: in the check to see if person is already there",e);
		}
		ConnectionFactory.closeConnection(rs,conn,ps);
		return personID;
	}
}


