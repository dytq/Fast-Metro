package gui;

import javax.swing.*;

import fastmetro.Carte;
import fastmetro.Gare;

import java.awt.*;
import java.util.ArrayList;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel pan = new JPanel();

	StationPanel panel; 
	
	/**
	 * Le gestionnaire de Fenetre graphique du logiciel
	 * 
	 * @param nom de la fenetre
	 */
	public Fenetre(String nom,String cheminCarte) {
		super(nom);
		setSize(new Dimension(1008, 735));
		this.panel = new StationPanel(cheminCarte);
		
		BoxLayout bl = new BoxLayout(pan, BoxLayout.Y_AXIS);
		pan.setLayout(bl);
		pan.setBackground(Color.BLACK);
		setContentPane(pan);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Permet l'ajout d'une station :: obsolète
	 * 
	 * @param cheminEcriture pour sauvegarder une station
	 */
	//public void addStation(String cheminEcriture) {
		//StationPanel panel = new StationPanel(cheminCarte); // dessine les stations sur la carte
		//this.add(panel);
		// panel.addMouseListener(new ClickDrawStation(panel,cheminEcriture));
	//}

	public void printStation(ArrayList<Gare> gareList) {
	// dessine les stations sur la carte
		this.add(panel);
		for (Gare gare : gareList) {
			Circle circle = new Circle(gare.getPoint());
			panel.addCircle(circle);
		}
	}
	public void selectStation(Carte carte) {
		panel.addMouseListener(new ClickSelectStation(panel,carte));
	}
}