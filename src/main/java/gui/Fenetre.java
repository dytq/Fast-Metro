package gui;

import javax.swing.*;

import fastmetro.Carte;
import fastmetro.Dijkstra;
import fastmetro.Gare;

import java.awt.*;
import java.util.ArrayList;

/**
 * Fenetre graphique de l'interface, on dessine ici la cartes et les stations
 * pour l'interface
 * 
 * @author dedarally taariq
 *
 */
public class Fenetre extends JFrame {

	/** error */
	private static final long serialVersionUID = 1L;

	/* pannel */
	private JPanel pan = new JPanel();

	/* station panel */
	StationPanel panel;

	/**
	 * Le gestionnaire de Fenetre graphique du logiciel. initialise le panel.
	 * 
	 * @param nom de la fenetre
	 * @param cheminCarte chemin de la carte pour l'affciher
	 */
	public Fenetre(String nom, String cheminCarte) {
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
	 * Affiche les stations dans le panel
	 * @param gareList la liste des gares pour les afficher
	 */
	public void printStation(ArrayList<Gare> gareList) {
		// dessine les stations sur la carte
		this.add(panel);
		for (Gare gare : gareList) {
			Circle circle = new Circle(gare.getPoint());
			panel.addCircle(circle);
		}
	}

	/**
	 * Le comportement de cette fonction, est appelé de mettre sous écoute la
	 * souris. Celle-ci est tourné en boucle dans le panel et elle réagit que
	 * lorsqu'il y a un clique
	 * 
	 * @param carte la carte 
	 * @param dijkstra l'objet dijkstra relative à la carte 
	 */
	public void selectStation(Carte carte, Dijkstra dijkstra) {
		panel.addMouseListener(new ClickSelectStation(panel, carte, dijkstra));
	}
}