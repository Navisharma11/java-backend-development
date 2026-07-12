import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil 
{
	static
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Driver is registered");
	}
	
	public static Connection getDBConnection() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/navi_db";
		String userName = "navi";
		String password = "password";
		
		Connection connect = DriverManager.getConnection(url,userName,password);
		return connect;
	}
	 
	public static void closeResources(Connection connect, Statement stmnt) throws SQLException
	{
		// Safely close the statement first
	    if (stmnt != null) {
	        try {
	            stmnt.close();
	        } catch (SQLException e) {
	            e.printStackTrace(); 
	        }
	    }
	
	    
	    if (connect != null) {
	        try {
	            connect.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
