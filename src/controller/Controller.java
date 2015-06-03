package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import model.Profile;
import vue.IHM;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

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
			String arffFile = "./resources/German_Bank.arff";

			BufferedReader wekaReader = new BufferedReader(new FileReader(arffFile)); // Get the arff file
			Instances data = new Instances(wekaReader); // Build the data instances
			wekaReader.close(); // Close the reader since we won't need it again.
			data.setClassIndex(data.numAttributes() - 1); // Set the target attribute used for classification, it's last column => number of attributes - 1
			
			NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
			nb.buildClassifier(data);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
