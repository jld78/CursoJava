package net.polotecnologico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test");
			
			
			Statement st = con.createStatement();
			int i = st.executeUpdate("DELETE FROM USUARIOS WHERE usuario = 'usuario3'");
			
			System.out.println("Se eliminaron " + i + " filas.");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
