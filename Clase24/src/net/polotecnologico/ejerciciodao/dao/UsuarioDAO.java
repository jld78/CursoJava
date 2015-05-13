package net.polotecnologico.ejerciciodao.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import net.polotecnologico.ejerciciodao.Usuario;

public interface UsuarioDAO {

	void crearTabla() throws SQLException;
	int create(Usuario usuario) throws DAOUsuarioException;
	int update(Usuario usuario) throws DAOUsuarioException;
	int deleteByID(Integer id) throws DAOUsuarioException;
	ArrayList<Usuario> getUsuarioByName(String nombre) throws DAOUsuarioException;
	Usuario getUsuarioById(Integer id) throws DAOUsuarioException;
	
}
