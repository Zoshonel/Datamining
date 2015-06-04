package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import controller.Controller;
import model.KeyValeur;
import model.Profile;

public class IHM extends JFrame{
	
	
	private JTextField champ_num_1,champ_num_2,champ_num_4;
	private JComboBox<KeyValeur> champ_box_3,champ_box_5,champ_box_6,champ_box_7;
	private JProgressBar progressBar;
	private Controller controller;
	private JLabel resultat;


	public IHM(){
			super();
			
			this.setTitle("Aide à la décision");
		
		//construction de la fenetre
		 JPanel main_panel = new JPanel(new BorderLayout());
	
		// 1 les champs à saisir
			JPanel saisie_panel = new JPanel(new GridLayout(4,8));
			
			// Déclaration des libellés des champs
			JLabel lab_champ1 = new JLabel("Montant du crédit");
			JLabel lab_champ2 = new JLabel("Durée du crédit");
			JLabel lab_champ3 = new JLabel("Statut du compte");
			JLabel lab_champ4 = new JLabel("Nombre de crédits effectués");
			JLabel lab_champ5 = new JLabel("Historique des crédits");
			JLabel lab_champ6 = new JLabel("Job");
			JLabel lab_champ7 = new JLabel("précense d'un garant");
			resultat = new JLabel("");
			
			// Déclaration des champs de saisie
			this.champ_num_1 = new JTextField(15);
			this.champ_num_2 = new JTextField(15);
			this.champ_num_4 = new JTextField(15);
			
			this.champ_num_1.setText("0");
			this.champ_num_2.setText("0");
			this.champ_num_4.setText("0");
			
			
			//model et combobox pour les variables qualitatives
			KeyValeur[] liste1 = new KeyValeur[]{new KeyValeur("A11","<0"),new KeyValeur("A12","0<=X<200"),new KeyValeur("A13",">=200"),new KeyValeur("A14","no checking")};
			champ_box_3 = new JComboBox<KeyValeur>(liste1);
			
			KeyValeur[] liste2 = new KeyValeur[]{new KeyValeur("A30","no credits/all paid"),new KeyValeur("A31","all paid"),new KeyValeur("A32","existing paid"),new KeyValeur("A33","delayed previously"),new KeyValeur("A34","critical/other existing credit")};
			champ_box_5 = new JComboBox<KeyValeur>(liste2);
			
			KeyValeur[] liste3 = new KeyValeur[]{new KeyValeur("A171","unemp/unskilled non res"),new KeyValeur("A172","unskilled resident"),new KeyValeur("A173","skilled"),new KeyValeur("A174","high qualif/self emp/mgmt")};
			champ_box_6 = new JComboBox<KeyValeur>(liste3);
			
			KeyValeur[] liste4 = new KeyValeur[]{new KeyValeur("A101","none"),new KeyValeur("A102","co applicant"),new KeyValeur("A103","guarantor")};
			champ_box_7 = new JComboBox<KeyValeur>(liste4);
			
			//Bouton evaluer le profile
			JButton b_evaluer = new JButton("Evaluer");
				//ecouteur
				EvaluerListener ecouteur_evaluer = new EvaluerListener(this);
				b_evaluer.addActionListener(ecouteur_evaluer);
				
				//panel du resultat
				JPanel p_result = new JPanel(new BorderLayout());
			
			
			//ajout au panel
			saisie_panel.add(lab_champ1);
			saisie_panel.add(champ_num_1);
			saisie_panel.add(lab_champ2);
			saisie_panel.add(champ_num_2);
			saisie_panel.add(lab_champ3);
			saisie_panel.add(champ_box_3);
			saisie_panel.add(lab_champ4);
			saisie_panel.add(champ_num_4);
			saisie_panel.add(lab_champ5);
			saisie_panel.add(champ_box_5);
			saisie_panel.add(lab_champ6);
			saisie_panel.add(champ_box_6);
			saisie_panel.add(lab_champ7);
			saisie_panel.add(champ_box_7);
			saisie_panel.add(b_evaluer);
			p_result.add(resultat,BorderLayout.LINE_END);
			saisie_panel.add(p_result);
		
			//Ajout au panel principal
			main_panel.add(saisie_panel,BorderLayout.CENTER);
			
		//barre de progression pour le resultat
			//JPanel progress_panel = new JPanel(new BorderLayout());
			//JLabel progress_label_non = new JLabel("Non");
			//JLabel progress_label_oui = new JLabel("Oui");
			
			this.progressBar = new JProgressBar(0, 100);
			this.progressBar.setValue(0);
			this.progressBar.setStringPainted(true);
			
			//progress_panel.add(progress_label_non,BorderLayout.LINE_START);
			//progress_panel.add(progressBar,BorderLayout.CENTER);
			//progress_panel.add(progress_label_oui,BorderLayout.LINE_END);
			
			main_panel.add(progressBar,BorderLayout.PAGE_START);
		
		//fermeture de la fenetre principale
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//dimentionner la fenetre
		this.setSize(800, 150);
		this.setResizable(false);
		
		
		//ajout des panels à la fenetre principale
		this.add(main_panel);
		
		//afficher la fenetre 
		this.setVisible(true);
	}
	
	public void update(double res_decision){
		int value = (int) res_decision;
		this.progressBar.setValue(value);
		if(value>=70){
			this.resultat.setText("Good");
			this.resultat.setForeground(new Color(0, 204, 102));
			progressBar.setForeground(new Color(0, 204, 102));
		}else{
			if(value<50){
				this.resultat.setText("Bad");
				progressBar.setForeground(Color.RED);
				this.resultat.setForeground(Color.RED);
			}else{
				this.resultat.setText("Bad");
				this.resultat.setForeground(new Color(255, 128, 0));
				progressBar.setForeground(new Color(255, 128, 0));
			}
		}
		
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public String getChamp_num_1_text() {
		if(champ_num_1.getText() == null){
			return "0";
		}else{
			return champ_num_1.getText();
		}
	}

	public String getChamp_num_2_text() {
		if(champ_num_2.getText() == null){
			return "0";
		}else{
		return champ_num_2.getText();
		}
	}

	public String getChamp_num_4_text() {
		if(champ_num_4.getText() == null){
			return "0";
		}else{
		return champ_num_4.getText();
		}
	}

	public String getChamp_box_3_text() {
		KeyValeur  item = (KeyValeur)champ_box_3.getSelectedItem();
		return item.getValeur();
	}

	public String getChamp_box_5_text() {
		KeyValeur  item = (KeyValeur)champ_box_5.getSelectedItem();
		return item.getValeur();
	}

	public String getChamp_box_6_text() {
		KeyValeur  item = (KeyValeur)champ_box_6.getSelectedItem();
		return item.getValeur();
	}

	public String getChamp_box_7_text() {
		KeyValeur  item = (KeyValeur)champ_box_7.getSelectedItem();
		return item.getValeur();
	}


	
	
	
}
