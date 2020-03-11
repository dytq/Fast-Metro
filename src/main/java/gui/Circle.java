package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Circle extends JPanel {

	private static final long serialVersionUID = 1L;
	private String chemin;
	private int x;
	private int y;

	public Circle(int x, int y) {
		super();
		this.x = x - 5;
		this.y = y - 5;
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillOval(x, y, 10, 10);
	}
}