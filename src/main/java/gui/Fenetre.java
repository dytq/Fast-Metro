package gui;

import javax.swing.*;

import java.awt.*;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel pan = new JPanel();
	private String cheminCarte;

	/**
	 * Le gestionnaire de Fenetre graphique du logiciel
	 * @param nom de la fenetre
	 */
	public Fenetre(String nom) {
		super(nom);
		setSize(new Dimension(1008, 735));

		BoxLayout bl = new BoxLayout(pan, BoxLayout.Y_AXIS);
		pan.setLayout(bl);
		pan.setBackground(Color.ORANGE);
		setContentPane(pan);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Permet d'importer une image (juste on écrit le nom de l'image sur une variable)
	 * @param chemin du fichier image
	 */
	public void importerImage(String chemin) {
		this.cheminCarte = chemin;
	}
	
	/**
	 * Permet l'ajout d'une station
	 * @param cheminEcriture pour sauvegarder une station
	 */
	public void addStation(String cheminEcriture) {
		StationPanel panel = new StationPanel(cheminCarte, cheminEcriture); // dessine les stations sur la carte
		this.add(panel);
		panel.addMouseListener(new ClickDrawStation(panel,cheminEcriture));
	}
}