package com.xoriant.test;

import java.sql.SQLException;

import javax.naming.NamingException;

/*
 * Class used to test connection factory
 */

import com.xoriant.dao.supp.ConnectionFactoryTest;

public class TestConnectionFactory {
	public static void main(String[] args) throws SQLException, NamingException {
		System.out.println(ConnectionFactoryTest.getConnection());
	}
}
