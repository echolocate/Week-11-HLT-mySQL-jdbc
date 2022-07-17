package library;
import java.sql.*;
import java.util.Scanner;

public class Library {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM books;");
			
			while(rs.next()) {
				System.out.println(rs.getLong("isbn") + rs.getString("title") + rs.getString("author"));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
