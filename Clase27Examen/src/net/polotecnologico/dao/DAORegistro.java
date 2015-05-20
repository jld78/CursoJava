package net.polotecnologico.dao;

import net.polotecnologico.Registro;

public interface DAORegistro{
	boolean insertarRegistro(Registro registro, String servidor, String usuario, char[] pasword) throws DAORegistroException;
}
