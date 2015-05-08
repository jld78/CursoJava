package net.polotecnologico.ejerciciodao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.polotecnologico.ejerciciodao.Usuario;

public class UsuarioDAOJDBC implements UsuarioDAO{

	@Override
	public int update(Usuario usuario) {
		String sql = "UPDATE USUARIOS SET " + 
				"name='" + usuario.getNombre() + 
				"', clave='" + usuario.getClave()+ 
				"', email='" + usuario.getEmail() + 
				"' WHERE id=" + usuario.getId();
		return updateConsulta(sql);
	}

	@Override
	public int delete(Usuario usuario) {
		String sql = "DELETE FROM USUARIO WHERE id=" + usuario.getId();
		return updateConsulta(sql);
	}

	@Override
	public int deleteByNombre(String nombre) {
		String sql = "DELETE FROM USUARIO WHERE nombre LIKE '%" + nombre + "%'";
		return updateConsulta(sql);
	}

	@Override
	public int deleteByID(Integer id) {
		String sql = "DELETE FROM USUARIO WHERE id =" + id;
		return updateConsulta(sql);
	}

	@Override
	public ArrayList<Usuario> getUsuarioByName(String nombre) {
		String sql = "SELECT * FROM usuarios WHERE nombre LIKE '%" + nombre + "%'";
		ResultSet rs = selectConsulta(sql);
		
		if(rs != null){
			ArrayList<Usuario> usuarios = new ArrayList<>();
			try {
				while(rs.next()){
					Integer uId = rs.getInt("id");
					String uNombre = rs.getString("name");
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
		return null;
	}

	@Override
	public Usuario getUsuarioById(Integer id) {
		String sql = "SELECT * FROM usuarios WHERE id=" + id;
		
		ResultSet rs = selectConsulta(sql);
		
		try {
			if (rs != null) {
				if(rs.next()){
					Integer uId = rs.getInt("id");
					String uNombre = rs.getString("name");
					String uClave = rs.getString("clave");
					String uEmail = rs.getString("email");
					
					Usuario usuario = new Usuario(uId, uNombre, uClave, uEmail);
					
					return usuario;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private Connection getConnection(){
		
		try {
			Class.forName("org.apache.derby.client");
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/test", "app", "app");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	private ResultSet selectConsulta(String sql){
		
		Statement st;
		try {
			Connection conn = getConnection();
			st = conn.createStatement();
			ResultSet rs  = st.executeQuery(sql);
			conn.close();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
private int updateConsulta(String sql){
		
		Statement st;
		try {
			Connection conn = getConnection();
			st = conn.createStatement();
			int i  = st.executeUpdate(sql);
			conn.close();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
