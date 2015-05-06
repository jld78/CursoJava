package net.polotecnologico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test");
			
			
			Statement st = con.createStatement();
			int i = st.executeUpdate("INSERT INTO usuarios (usuario, clave, email) "
					+ "VALUES ('usuario3', 'clave_usuario3', 'usuario3@mail.com')");
			
			System.out.println("Se insertaron " + i + " filas.");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
}
