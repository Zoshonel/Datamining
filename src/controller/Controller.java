package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.Profile;
import vue.IHM;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import com.livingobjects.common.configuration.Configuration;

public class Controller {

	private IHM ihm;

	public Controller(IHM ihm) {
		this.ihm = ihm;
	}

	public void startEvaluate(Profile profile) {
		int resultFinal = calculerProfile(profile);
		ihm.update(resultFinal);
	}
	
	public Integer calculerProfile(Profile profile) {
		try {
			Configuration configuration = Configuration.Create.create(
					"./configuration.xml", "./configuration.properties");
			String csvFile = configuration.get("file.csv");
			String arffFile = configuration.get("file.arff");

			if (!(new File(arffFile).exists())) {
				convertCsvToArff(csvFile, arffFile);
			}

			BufferedReader wekaReader = new BufferedReader(new FileReader(arffFile));
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
