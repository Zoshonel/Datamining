package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {

	/**
	 * This function will connect to the database, using the function getConnection(database, id, password) of the class DriveManager
	 * @param host
	 * @param port
	 * @param databaseName
	 * @param id
	 * @param password
	 * @return 
	 */
	public static Connection connectToDatabase(String host, String port, String databaseName, String id, String password) {
		Connection connection = null;
		try {
			String database = "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;
			connection = DriverManager.getConnection(database, id, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This function will close the connection to database if there have, else nothing will happen
	 * @param connection
	 */
	public static void disconnectFromDatabase(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
}
