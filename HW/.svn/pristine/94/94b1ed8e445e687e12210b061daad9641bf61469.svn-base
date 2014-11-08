package unl.cse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/*
 * url			mysql://chicken.x64.me/roots
 * user			root2
 * password   	roots
 * Or
 * url			mysql://cse.unl.edu/emorton
 * user			emorton
 * Password   	gNe54D 
 */


/*
 * ConnectionFactor.java is defined with a few methods used to connect and disconnect a mysql database
 * The class has one default constructor.
 */
public class ConnectionFactory {
	private static Logger logger=Logger.getLogger("HW");
	 //static reference to itself
    private static ConnectionFactory instance = new ConnectionFactory();
    public static final String URL = "jdbc:mysql://cse.unl.edu/emorton";
    public static final String USER = "emorton";
    public static final String PASSWORD = "gNe54D";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
 
    //default constructor
    private ConnectionFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			logger.error("InstantiationException: ",e);
		} catch (IllegalAccessException e) {
			logger.error("IllegalAccessException: ",e);
		} catch (ClassNotFoundException e) {
			logger.error("ClassNotFoundException: ", e);
		}
    }
    
    //createConnection() method attempts to use data variables to connect to the Mysql database.
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
        	logger.error("SQLException: e",e);
        }
        return connection;
    }   
    //getConnection() method returns an instance of the connection
    public static Connection getConnection() {
        return instance.createConnection();
    }
    //close(ResultSet) method attempts to close an object of type ResultSet
    private static void close(ResultSet rs){
    	if(rs != null){
    		try {
    			rs.close();
    		}catch (SQLException e){
    			logger.error("SQLException: e",e);
    		}
    	}
    }
  //close(PreparedStatement statement) method attempts to close an object of type PreparedStatement
    private static void close(PreparedStatement statement){
    	if (statement != null){
    		try {
    			statement.close();
       		} catch (SQLException e){
       			logger.error("SQLException: e",e);
       		}
    	}
    }
    //close(Connection conn)
    private static void close(Connection conn){
    	if (conn != null){
    		try{
    			conn.close();
    		} catch (SQLException e){
    			logger.error("SQLException: e",e);
    		}
    	}
    }
    //closeConnection(ResultSet, Connection, PreparedStatement) closes the connection as a whole
    public static void closeConnection(ResultSet rs, Connection conn,PreparedStatement ps){
    	close(rs);
    	close(conn);
    	close(ps);
    }
  //closeConnection(Connection, PreparedStatement) calls the closee(conn) and close(ps) method deffined above
    public static void closeConnection( Connection conn,PreparedStatement ps){
    	close(conn);
    	close(ps);
    }
}
