package net.polotecnologico.dao;

public interface DAORegistro{
	boolean insertarRegistro(Registro registro, String servidor, String usuario, char[] pasword) throws DAORegistroException;
}
