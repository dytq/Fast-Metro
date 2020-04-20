package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * Simple cercle
 * 
 * @author dedarally taariq
 *
 */
public class Circle extends JPanel {

	/* error */
	private static final long serialVersionUID = 1L;

	/* Coordonnées */
	private int x;
	private int y;

	/* Couleur par défaut rouge */
	Color color;

	/**
	 * Cercle
	 * 
	 * @param point coords ( le centre du cercle)
	 */
	public Circle(Point point) {
		super();
		this.x = (int) (point.getX() - 5);
		this.y = (int) (point.getY() - 5);
		this.color = Color.red;
	}

	/**
	 * Caracteristique un cercle
	 * 
	 * @param g graphics
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 10, 10);
	}

	/**
	 * Permet d'affecter une couleur à un cercle
	 * 
	 * @param color couleur du cercle
	 */
	public void setColor(Color color) {
		this.color = color;
	}
}