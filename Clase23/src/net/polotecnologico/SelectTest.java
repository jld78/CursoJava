package net.polotecnologico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {
	public static void main(String[] args) {
		
//		ClientDriver = new ClientDriver();
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/test", "app", "app");
			
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM USUARIOS WHERE usuario LIKE '%2'");
			
			while(rs.next()){
				int id = rs.getInt("id");
				String usuario = rs.getString("usuario");
				String clave = rs.getString("clave");
				String email = rs.getString("email");
				
				System.out.println("{" + id + ", "+ usuario + ", " + clave + ", " + email + "}");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
}
