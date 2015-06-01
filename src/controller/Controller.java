package controller;

import java.io.IOException;

import utils.DatabaseUtils;
import vue.IHM;

import com.livingobjects.common.configuration.Configuration;

public class Controller implements Runnable {
	
	private IHM main_ihm;
	
	public Controller(IHM in_main_ihm){
		this.main_ihm = in_main_ihm;
	}
	
	public void calculer_profile (){
		this.main_ihm.get_profile_saisie();
		this.main_ihm.update();
	}
	
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
