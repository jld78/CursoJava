package net.polotecnologico.ejerciciodao.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import net.polotecnologico.ejerciciodao.Usuario;

public interface UsuarioDAO {

	void crearTabla() throws SQLException;
	int create(Usuario usuario) throws SQLException;
	int update(Usuario usuario) throws SQLException;
	int delete(Usuario usuario) throws SQLException;
	int deleteByNombre(String nombre) throws SQLException;
	int deleteByID(Integer id) throws SQLException;
	ArrayList<Usuario> getUsuarioByName(String nombre) throws SQLException;
	Usuario getUsuarioById(Integer id) throws SQLException;
	
}
