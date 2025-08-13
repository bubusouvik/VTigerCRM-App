package com.vtiger.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {

	public void getConnection() throws SQLException {

		Driver driverRef = new Driver();
		// load driver register
		DriverManager.registerDriver(driverRef);
		// create connections
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		try {

			// create statement for execute query
			Statement state = con.createStatement();
			// store entire table records in result set
			ResultSet rs = state.executeQuery("select * from test");

			while (rs.next()) {

				System.out.println(
						rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
			}

		} catch (Exception e) {
			System.out.println("Handeled Exception");
		}

	}

	public void closeConnection() throws SQLException {
		Driver driverRef = new Driver();
		// load driver register
		DriverManager.registerDriver(driverRef);
		// create connections
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		con.close();
	}

}
