package controller;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;
import vue.IHM;

import com.livingobjects.common.configuration.Configuration;

public class Controller implements Runnable {

	private IHM main_ihm;

	public Controller(IHM in_main_ihm) {
		this.main_ihm = in_main_ihm;
	}

	public void calculer_profile() {
		this.main_ihm.get_profile_saisie();
		this.main_ihm.update();
	}

	@Override
	public void run() {
		try {
			Configuration configuration = Configuration.Create.create(
					"./configuration.xml", "./configuration.properties");
			convertCsvToArff(configuration.get("file.csv"),
					configuration.get("file.arff"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private ArffSaver convertCsvToArff(String csvFilePath, String arffFilePath)
			throws IOException {
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File(csvFilePath));
		Instances data = loader.getDataSet();

		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File(arffFilePath));
		saver.setDestination(new File(arffFilePath));
		saver.writeBatch();
		return saver;
	}

}
