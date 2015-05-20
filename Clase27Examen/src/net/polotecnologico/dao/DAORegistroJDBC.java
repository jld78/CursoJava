package net.polotecnologico.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAORegistroJDBC implements DAORegistro {

	@Override
	public boolean insertarRegistro(Registro registro, String servidor, String usuario, char[] password) throws DAORegistroException {
		
		Connection conn = null;
		Statement st = null;
		
		try{
			Properties prop = new Properties();
			prop.load(new FileReader("db.properties"));
			String driverClass = prop.getProperty("driverClass");
			String urlDatabase = prop.getProperty("urlDatabase");
			urlDatabase = urlDatabase.replace("<servidor>", servidor);
			String dbUsuario = usuario;
			String dbPassword = password.toString();
			
			Class.forName(driverClass);
			
			conn = DriverManager.getConnection(urlDatabase, dbUsuario, dbPassword);
			
			String sql = "INSERT INTO registros(id, nombre, apellido, habilitado) VALUES(" + 
					registro.getId() + 
					",'" + registro.getNombre() + 
					"','" + registro.getApellido() +
					"'," + (registro.isHabilitado()?new Integer("1"): new Integer("0")) +
					")";
			
			st = conn.createStatement();
			int i  = st.executeUpdate(sql);
			return i>0? true: false;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAORegistroException("Error base de datos");
		} catch (IOException e){
			e.printStackTrace();
			throw new DAORegistroException("Error base de datos");
		} catch (SQLException e){
			e.printStackTrace();
			throw new DAORegistroException("Error al insertar el nuevo registro");
		} finally {
			try{
				if(st != null){
					st.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new DAORegistroException("Error al cerrar la conexión a la base de datos");
			}
		}
	}

}
