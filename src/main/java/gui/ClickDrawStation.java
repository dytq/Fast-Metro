package gui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.io.IOException;

import fastmetro.Ecriture;

public class ClickDrawStation implements MouseListener {
	private StationPanel panel;
	private String cheminEcriture;
	
	public ClickDrawStation(StationPanel panel2,String cheminEcriture) {
		super();
		this.panel = panel2;
		this.cheminEcriture = cheminEcriture;
	}
	
	/**
	 * Quand on clique on ajoute un cercle
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		Ecriture e = new Ecriture(cheminEcriture);
		panel.addCircle(new Circle(event.getX(), event.getY()));
		Point point = new Point(event.getX(),event.getY());
		try {
			e.scanPrompt(point);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}