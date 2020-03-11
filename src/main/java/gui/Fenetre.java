package gui;

import javax.swing.*;

import java.awt.*;

public class Fenetre extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel pan = new JPanel();
	private String cheminCarte;

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

	public void importerImage(String chemin) {
		this.cheminCarte = chemin;
	}

	public void addStation(String cheminEcriture) {
		StationPanel panel = new StationPanel(cheminCarte, cheminEcriture); // dessine les stations sur la carte
		this.add(panel);
		panel.addMouseListener(new ClickDrawStation(panel));
	}
}