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
	public int create(Usuario usuario) throws SQLException{
		String sql = "INSERT INTO usuarios(nombre, clave, email) VALUES('" + 
				usuario.getNombre() + 
				"','" + usuario.getClave()+ 
				"','" + usuario.getEmail() + 
				"')";
		return updateConsulta(sql);
	}	

	@Override
	public int update(Usuario usuario) throws SQLException {
		String sql = "UPDATE USUARIOS SET " + 
				"nombre='" + usuario.getNombre() + 
				"', clave='" + usuario.getClave()+ 
				"', email='" + usuario.getEmail() + 
				"' WHERE id=" + usuario.getId();
		return updateConsulta(sql);
	}

	@Override
	public int delete(Usuario usuario) throws SQLException {
		String sql = "DELETE FROM USUARIO WHERE id=" + usuario.getId();
		return updateConsulta(sql);
	}

	@Override
	public int deleteByNombre(String nombre) throws SQLException {
		String sql = "DELETE FROM USUARIO WHERE nombre LIKE '%" + nombre + "%'";
		return updateConsulta(sql);
	}

	@Override
	public int deleteByID(Integer id) throws SQLException {
		String sql = "DELETE FROM USUARIO WHERE id =" + id;
		return updateConsulta(sql);
	}

	@Override
	public ArrayList<Usuario> getUsuarioByName(String nombre) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE nombre LIKE '%" + nombre + "%'";
		return selectConsulta(sql);
	}

	@Override
	public Usuario getUsuarioById(Integer id) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE id=" + id;
		return selectConsulta(sql).get(0);

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
		Connection conn = null;
		Statement st;
		ResultSet rs = null;
		try {
			conn = getConnection();
			st = conn.createStatement();
			rs  = st.executeQuery(sql);
			if(rs != null){
				ArrayList<Usuario> usuarios = new ArrayList<>();
				try {
					while(rs.next()){
						Integer uId = rs.getInt("id");
						String uNombre = rs.getString("nombre");
						String uClave = rs.getString("clave");
						String uEmail = rs.getString("email");

						usuarios.add(new Usuario(uId, uNombre, uClave, uEmail));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return usuarios;
				
			}
		}finally{
			if(rs != null){
				rs.close();
			}	
			if(conn != null){	
				conn.close();
			}
		}
		return null;
	}
	
private int updateConsulta(String sql) throws SQLException{
		Connection conn = null;
		Statement st;
		try {
			conn = getConnection();
			st = conn.createStatement();
			int i  = st.executeUpdate(sql);
			return i;
		} finally{
			if(conn != null){	
				conn.close();
			}
		}

	}

public void crearTabla() throws SQLException{
	Connection conn = getConnection();
	Statement st = conn.createStatement();
	try {
		st.executeUpdate("CREATE TABLE usuarios(id INT GENERATED ALWAYS AS IDENTITY, nombre VARCHAR(25), clave VARCHAR(25), email VARCHAR(50))");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
}
