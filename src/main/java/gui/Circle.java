package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class Circle extends JPanel {

	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
	
	/* Couleur par défaut rouge */
	Color color;

	/**
	 * Cercle 
	 * @param x coords
	 * @param y coords
	 */
	public Circle(Point point) {
		super();
		this.x = (int) (point.getX() - 5);
		this.y = (int) (point.getY() - 5);
		this.color = Color.red;
	}
	
	/**
	 * Caracteristique un cercle 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 10, 10);
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}