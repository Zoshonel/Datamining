package controller;

import java.io.IOException;

import utils.DatabaseUtils;

import com.livingobjects.common.configuration.Configuration;

public class Controller implements Runnable {

	@Override
	public void run() {
		try {
			Configuration configuration = Configuration.Create.create("./configuration.xml", "./configuration.properties");
			String dataFile = configuration.get("dataFile");
			String host = configuration.get("database.host");
			String port = configuration.get("database.port");
			String databaseName = configuration.get("database.databaseName");
			String id = configuration.get("database.id");
			String password = configuration.get("database.password");
			DatabaseUtils.connectToDatabase(host, port, databaseName, id, password);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
