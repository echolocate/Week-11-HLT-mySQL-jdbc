package library;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	public Connection conn;
	public Statement stmt = null;
	public ResultSet rs = null;
	public ResultSetMetaData rsmd;

	//Constructor 
	public Database(String driver, String database, String username, String password) throws ClassNotFoundException, SQLException {		
			Class.forName(driver);		
			this.conn = DriverManager.getConnection(database, username, password);
		
	}
	
	// Query method
	public void query(String query) throws SQLException {
		this.stmt = this.conn.createStatement();
		this.rs = this.stmt.executeQuery(query);
		this.rsmd = this.rs.getMetaData();
	}
	
	// Output method
	public void printResults() throws SQLException {
		int totalFields = this.rsmd.getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= totalFields; i++) {
				if (i > 1) System.out.print(", ");
				String fieldValue = rs.getString(i);
				System.out.print(fieldValue);
			}
			System.out.println();
		}
	}
	
	// Close connections
	public void closeAll() {
			   // close JDBC objects
			   try {
			      if(rs!=null) rs.close();
			   } catch (SQLException se) {
			      se.printStackTrace();
			   }
			   try {
			      if(stmt!=null) stmt.close();
			   } catch (SQLException se) {
			      se.printStackTrace();
			   }
			   try {
			      if(conn!=null) conn.close();
			   } catch (SQLException se) {
			      se.printStackTrace();
			   }
	}	
}

