package net.polotecnologico.sqlmanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBHelper {

	public static ArrayList<String[]> selectConsulta(Connection conn,
			String sqlStatment) throws SQLException{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sqlStatment);

			ResultSetMetaData rsm = rs.getMetaData();
			ArrayList<String[]> resultado = new ArrayList<>();
			String[] fila = new String[rsm.getColumnCount()];
			for (int i = 0; i < rsm.getColumnCount(); i++) {
				fila[i] = rsm.getColumnName(i+1);
			}
			resultado.add(fila);

			while (rs.next()) {
				String[] filaWhile = new String[rsm.getColumnCount()];
				for (int i = 0; i < rsm.getColumnCount(); i++) {
					filaWhile[i] = rs.getString(i+1);
				}
				resultado.add(filaWhile);
			}

			return resultado;
	}

	public static int updateConsulta(Connection conn, String sqlStatment) throws SQLException{

			Statement st = conn.createStatement();
			int i = st.executeUpdate(sqlStatment);

		return i;
	}

}
