package vue;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import model.Profile;

public class IHM {
	
	private JButton evaluer;
	private Profile prof_saisie;
	
	public IHM(){
		JFrame main_frame = new JFrame("Aide à la décision");
		
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
		JLabel lab_champ8 = new JLabel("Décision");
		
		// Déclaration des champs de saisie
		JTextField champ_num_1 = new JTextField(15);
		JTextField champ_num_2 = new JTextField(15);
		JTextField champ_num_4 = new JTextField(15);
		
		
		//model et combobox pour les variables qualitatives
		String[] liste_code1 = new String[4];
		liste_code1[0]="A11";
		liste_code1[1]="A12";
		liste_code1[2]="A13";
		liste_code1[3]="A14";
		JComboBox<String> champ_box_3 = new JComboBox<String>(liste_code1);
		
		String[] liste_code2 = new String[5];
		liste_code2[0]="A30";
		liste_code2[1]="A31";
		liste_code2[2]="A32";
		liste_code2[3]="A33";
		liste_code2[4]="A34";
		JComboBox<String> champ_box_5 = new JComboBox<String>(liste_code2);
		
		String[] liste_code3 = new String[4];
		liste_code3[0]="A171";
		liste_code3[1]="A172";
		liste_code3[2]="A173";
		liste_code3[3]="A174";
		JComboBox<String> champ_box_6 = new JComboBox<String>(liste_code3);
		
		String[] liste_code4 = new String[3];
		liste_code4[0]="A101";
		liste_code4[1]="A102";
		liste_code4[2]="A103";
		JComboBox<String> champ_box_7 = new JComboBox<String>(liste_code4);
		
		String[] liste_code5 = new String[3];
		liste_code5[0]="1";
		liste_code5[1]="2";
		JComboBox<String> champ_box_8 = new JComboBox<String>(liste_code5);
		
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
		saisie_panel.add(lab_champ8);
		saisie_panel.add(champ_box_8);
	
		//Ajout au panel principal
		main_panel.add(saisie_panel);
		
		//fermeture de la fenetre principale
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//dimentionner la fenetre
		main_frame.setSize(700, 500);
		
		//finalisation
		main_frame.add(main_panel);
		//afficher la fenetre 
		main_frame.setVisible(true);
	}
	
	public Profile get_profile_saisie(){
		return prof_saisie;
	}
	
	public void update(){
		
	}

}
