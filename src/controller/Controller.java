package controller;

import java.io.File;
import java.util.Enumeration;

import model.Profile;
import vue.IHM;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class Controller {

	private IHM ihm;
	private Instances data;

	public Controller(IHM ihm) {
		this.ihm = ihm;
	}

	public void startEvaluate(Profile profile) {
		double resultFinal = calculerProfile(profile);
		ihm.update(resultFinal);
	}
	
	public double calculerProfile(Profile profile) {
		double result = 0;
		try {
			// Load data
			String arffFile = "./resources/German_Bank.arff";
			ArffLoader arffLoader = new ArffLoader();
			arffLoader.setFile(new File(arffFile)); // Get the arff file
			Instances structure = arffLoader.getStructure();
			structure.setClassIndex(structure.numAttributes() - 1);
			
			// Train NaiveBayes
			NaiveBayesUpdateable nb = new NaiveBayesUpdateable();
			nb.buildClassifier(structure);

			Instance current;
			while ((current = arffLoader.getNextInstance(structure)) != null) {
				nb.updateClassifier(current);
			}
			
			//Create new instance from IHM
			Instance newProfile = new DenseInstance(7);
			FastVector attributes = new FastVector(structure.numAttributes());
			for (int i = 0; i < structure.numAttributes(); i++) {
				attributes.addElement(structure.attribute(i));
			}
			
			Instances instances = new Instances("test", attributes, 1);
			instances.setClassIndex(attributes.size() - 1);
			newProfile.setDataset(instances);
			instances.add(newProfile);
			
			newProfile.setValue(structure.attribute("checking_status"), profile.getStatutDuCompte());
			newProfile.setValue(structure.attribute("duration"), Integer.parseInt(profile.getDureeDuCredit()));
			newProfile.setValue(structure.attribute("credit_history"), profile.getHistoriqueDuCredit());
			newProfile.setValue(structure.attribute("credit_amount"), Integer.parseInt(profile.getMontantDuCredit()));
			newProfile.setValue(structure.attribute("other_parties"), profile.getGaranti());
			newProfile.setValue(structure.attribute("existing_credits"), Integer.parseInt(profile.getNombreCredit()));
			newProfile.setValue(structure.attribute("job"), profile.getJob());
			
			result = nb.distributionForInstance(newProfile)[0]*100;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
