package net.polotecnologico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.derby.client.am.SqlException;

public class dbTest {

	public static void main(String[] args) {
		
//		ClientDriver = new ClientDriver();
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	
}
