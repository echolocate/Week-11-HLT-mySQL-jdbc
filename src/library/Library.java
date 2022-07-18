package library;

import java.sql.*;
import java.util.Scanner;

public class Library {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		int choice;

		try {
			Database db = new Database("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/library", "root", "root");

		do {
			System.out.println("-------------------Library Application-------------------");
			System.out.println("Select from the following options:");
			System.out.println("   1: Show all users");
			System.out.println("   2: Show all books");
			System.out.println("   3: Show all users that have books loaned");
			System.out.println("   4: Show all books that are loaned by users");
			System.out.println("   5: Show all loaned books and the users who loaned them");
			System.out.println("   6: Show all overdue books");
			System.out.println("   7: Custom query");
			System.out.println("   8: Exit this program");
			System.out.print(">> ");
			choice = sc.nextInt();
			
			switch (choice) {
				case 1: {
					db.query("SELECT * FROM users;");
					db.printResults();
					break;
				}
				case 2: {
					db.query("SELECT * FROM books;");
					db.printResults();
					break;
				}
				case 3: {
					db.query("SELECT u.first_name, u.last_name, \"\r\n"
							+ "							\"FROM loaned JOIN users u ON u.user_id=loaned.u_id JOIN books b ON b.isbn=loaned.b_id;");
					db.printResults();
					break;
				}
				case 4: {
					db.query("SELECT b.title, b.author "
							+ "FROM loaned JOIN users u ON u.user_id=loaned.u_id JOIN books b ON b.isbn=loaned.b_id;");
					db.printResults();
					break;
				}
				case 5: {
					db.query("SELECT u.first_name, u.last_name, b.title, b.author\r\n"
							+ "				FROM loaned JOIN users u ON u.user_id=loaned.u_id JOIN books b ON b.isbn=loaned.b_id;");
					db.printResults();
					break;
				}
				case 6: {
					db.query("SELECT u.first_name, u.last_name, b.title, b.author, loaned.due_date\r\n"
							+ "FROM loaned JOIN users u ON u.user_id=loaned.u_id JOIN books b ON b.isbn=loaned.b_id WHERE due_date<CURDATE()");
					db.printResults();
					break;
				}
				case 7: {
					Scanner s = new Scanner(System.in);
					System.out.println("Enter Query:  ");
					String searchTerm = s.nextLine();
					// s.close();
					db.query(searchTerm);
					db.printResults();
					break;
				}				
			}
		} while (choice != 8);
			db.closeAll();
			System.out.println("Connection to database closed.");
			sc.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}
}