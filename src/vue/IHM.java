package vue;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import model.Profile;

public class IHM extends JFrame{
	
	
	private JTextField champ_num_1,champ_num_2,champ_num_4;
	private JComboBox<String> champ_box_3,champ_box_5,champ_box_6,champ_box_7;
	private JProgressBar progressBar;
	
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
			JLabel empty_lab = new JLabel("");
			
			// Déclaration des champs de saisie
			this.champ_num_1 = new JTextField(15);
			this.champ_num_2 = new JTextField(15);
			this.champ_num_4 = new JTextField(15);
			
			
			//model et combobox pour les variables qualitatives
			String[] liste_code1 = new String[]{"A11","A12","A13","A14"};
			champ_box_3 = new JComboBox<String>(liste_code1);
			
			String[] liste_code2 = new String[]{"A30","A31","A32","A33","A34"};
			champ_box_5 = new JComboBox<String>(liste_code2);
			
			String[] liste_code3 = new String[]{"A171","A172","A173","A174"};
			champ_box_6 = new JComboBox<String>(liste_code3);
			
			String[] liste_code4 = new String[]{"A101","A102","A103"};
			champ_box_7 = new JComboBox<String>(liste_code4);
			
			//Bouton evaluer le profile
			JButton b_evaluer = new JButton("Evaluer");
			
			
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
			saisie_panel.add(empty_lab);
			saisie_panel.add(b_evaluer);
		
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
		this.setSize(700, 150);
		this.setResizable(false);
		
		
		//ajout des panels à la fenetre principale
		this.add(main_panel);
		
		//afficher la fenetre 
		this.setVisible(true);
	}
	
	public void update(int res_decision){
		this.progressBar.setValue(res_decision);
	}

}
