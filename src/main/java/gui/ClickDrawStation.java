package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickDrawStation implements MouseListener {
	private StationPanel panel;

	public ClickDrawStation(StationPanel panel2) {
		super();
		this.panel = panel2;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		panel.addCircle(new Circle(event.getX(), event.getY()));
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