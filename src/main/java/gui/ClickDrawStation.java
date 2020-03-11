package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

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
		Point2D point2D = new Point2D.Double(event.getX(),event.getY());
		e.scanPrompt(point2D);
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