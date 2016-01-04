package com.xoriant.dao.supp;

import java.sql.Connection;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 
 * @author raote_g
 * 
 */
public class ConnectionFactory {
	private static DataSource dataSource;

	private ConnectionFactory() {

	}

	/**
	 * Connection Pooling
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		Context initContext;
		try {

			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/xoriant_survey");

		} catch (NamingException e) {
			e.printStackTrace();
		}

		Connection con = dataSource.getConnection();
		return con;
	}

}
