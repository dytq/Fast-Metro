package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.JPanel;

import fastmetro.Ecriture;

public class StationPanel extends JPanel {

	private static final long serialVersionUID = -752649660103581438L;

	private LinkedList<Circle> circles = new LinkedList<Circle>();

	private String cheminCarte;
	private String cheminEcriture;
	
	/**
	 * Pannel Station  est une classe pour ajouter une station dans une map.
	 * On ajoute une cercle sur une map donc c'est pourquoi on a cheminCarte (c'est ici qu'on affiche la map)
	 * @param cheminCarte
	 * @param cheminEcriture
	 */
	public StationPanel(String cheminCarte, String cheminEcriture) {
		this.cheminCarte = cheminCarte;
		this.cheminEcriture = cheminEcriture;
	}

	/**
	 * Ajout d'un cercle dans une tableau
	 * @param circle
	 */
	public void addCircle(Circle circle) {
		circles.add(circle);
		this.repaint();
	}
	
	/**
	 * Dessiner un cercle et une image 
	 * J'ai les mis dans une meme buffered vu qu'on dessine une station sur une map
	 */
	@Override
	public void paint(Graphics g) {
		Image img = bufferedImage();
		g.drawImage(img, 0, 0, this);
	}

	private Image bufferedImage() {
		BufferedImage bufferedImage = new BufferedImage(1008, 735, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		super.paintComponent(g);
		Image img = Toolkit.getDefaultToolkit().getImage(cheminCarte);
		g.drawImage(img, 0, 0, this);

		for (Circle c : circles) {
			c.draw(g);
		}
		return bufferedImage;
	}
}