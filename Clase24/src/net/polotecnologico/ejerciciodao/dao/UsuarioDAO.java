package net.polotecnologico.ejerciciodao.dao;

import java.util.ArrayList;

import net.polotecnologico.ejerciciodao.Usuario;

public interface UsuarioDAO {

	int update(Usuario usuario);
	int delete(Usuario usuario);
	int deleteByNombre(String nombre);
	int deleteByID(Integer id);
	ArrayList<Usuario> getUsuarioByName(String nombre);
	Usuario getUsuarioById(Integer id);
	
}
