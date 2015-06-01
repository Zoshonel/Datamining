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
		JPanel saisie_panel = new JPanel(new GridLayout());
		
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
		JTextField champ_num_1 = new JTextField();
		JTextField champ_num_2 = new JTextField();
		JTextField champ_num_3 = new JTextField();
	
		//Ajout au panel principal
		main_panel.add(saisie_panel);
		
		//fermeture de la fenetre principale
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//dimentionner la fenetre
		main_frame.pack();
		
		
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
