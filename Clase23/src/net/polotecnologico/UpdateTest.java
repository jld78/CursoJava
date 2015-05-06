package net.polotecnologico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test");
			
			
			Statement st = con.createStatement();
			int i = st.executeUpdate("UPDATE usuarios SET email='usuario2@gmail.com' WHERE usuario='usuario2'");
			
			System.out.println("Se actualizaron " + i + " filas.");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
