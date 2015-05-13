package net.polotecnologico.ejerciciodao.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import net.polotecnologico.ejerciciodao.Usuario;

public class UsuarioDAOJDBC implements UsuarioDAO{
	
	@Override
	public int create(Usuario usuario) throws DAOUsuarioException{
		String sql = "INSERT INTO usuarios(nombre, clave, email) VALUES('" + 
				usuario.getNombre() + 
				"','" + usuario.getClave()+ 
				"','" + usuario.getEmail() + 
				"')";
		try {
			return updateConsulta(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOUsuarioException("Error creando el usuario");
		}
	}	

	@Override
	public int update(Usuario usuario) throws DAOUsuarioException {
		String sql = "UPDATE USUARIOS SET " + 
				"nombre='" + usuario.getNombre() + 
				"', clave='" + usuario.getClave()+ 
				"', email='" + usuario.getEmail() + 
				"' WHERE id=" + usuario.getId();
		try {
			return updateConsulta(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			new DAOUsuarioException("Error actualizando usuario");
		}
		return 0;
	}

	@Override
	public int deleteByID(Integer id) throws DAOUsuarioException {
		String sql = "DELETE FROM usuarios WHERE id =" + id;
		try {
			return updateConsulta(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			new DAOUsuarioException("Error eliminando usuario");
		}
		return 0;
	}

	@Override
	public ArrayList<Usuario> getUsuarioByName(String nombre) throws DAOUsuarioException {
		String sql = "SELECT * FROM usuarios WHERE nombre LIKE '" + nombre + "'";
		try {
			return selectConsulta(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOUsuarioException("Error buscando usuarios");
		}
	}

	@Override
	public Usuario getUsuarioById(Integer id) throws DAOUsuarioException {
		String sql = "SELECT * FROM usuarios WHERE id=" + id;
		try {
			return selectConsulta(sql).get(0);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOUsuarioException("Error obteniendo usuario");
		} catch (IndexOutOfBoundsException e){
			e.printStackTrace();
		}
		return null;

	}

	private Connection getConnection() throws SQLException{
		
		try {
			Properties prop = new Properties();
			prop.load(new FileReader("db.properties"));
			String driverClass = prop.getProperty("driverClass");
			String urlDatabase = prop.getProperty("urlDatabase");
			String dbUsuario = prop.getProperty("dbUsuario");
			String dbPassword = prop.getProperty("dbPassword");
			
			Class.forName(driverClass);
			
			Connection conn = DriverManager.getConnection(urlDatabase, dbUsuario, dbPassword);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	private ArrayList<Usuario> selectConsulta(String sql) throws SQLException{
		ResultSet rs = null;
		
		try (Connection conn = getConnection();
				Statement st = conn.createStatement();){
			
			
			rs  = st.executeQuery(sql);
			if(rs != null){
				ArrayList<Usuario> usuarios = new ArrayList<>();
					while(rs.next()){
						Integer uId = rs.getInt("id");
						String uNombre = rs.getString("nombre");
						String uClave = rs.getString("clave");
						String uEmail = rs.getString("email");

						usuarios.add(new Usuario(uId, uNombre, uClave, uEmail));
					}
				return usuarios;
				
			}
		}
		return null;
	}
	
private int updateConsulta(String sql) throws SQLException{
		Statement st;
		try (Connection conn = getConnection()){
			st = conn.createStatement();
			int i  = st.executeUpdate(sql);
			return i;
		}

	}

public void crearTabla(){
	
	Statement st;
	try(Connection conn = getConnection();) {
		st = conn.createStatement();
		st.executeUpdate("CREATE TABLE usuarios(id INT GENERATED ALWAYS AS IDENTITY, nombre VARCHAR(25), clave VARCHAR(25), email VARCHAR(50))");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
}
