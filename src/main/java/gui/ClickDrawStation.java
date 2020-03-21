package gui;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import fastmetro.Ecriture;

public class ClickDrawStation implements MouseListener {
	private StationPanel panel;
	private String cheminEcriture;
	
	public ClickDrawStation(StationPanel panel,String cheminEcriture) {
		super();
		this.panel = panel;
		this.cheminEcriture = cheminEcriture;
	}
	
	/**
	 * Quand on clique on ajoute un cercle
	 */
	@Override
	public void mouseClicked(MouseEvent event) {
		Ecriture e = new Ecriture(cheminEcriture);
		Point point2 = new Point(event.getX(), event.getY());
		panel.addCircle(new Circle(point2));
		Point point = new Point(event.getX(),event.getY());
		try {
			e.scanPrompt(point);
		} catch (IOException e1) {
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