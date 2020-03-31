package gui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.Timer;

import fastmetro.Carte;
import fastmetro.Dijkstra;

public class ClickSelectStation implements MouseListener {

	private Carte carte;
	private StationPanel panel;
	private Dijkstra dijkstra;
	private int click;

	public ClickSelectStation(StationPanel panel, Carte carte, Dijkstra dijkstra) {
		super();
		this.panel = panel;
		this.carte = carte;
		this.dijkstra = dijkstra;
		this.click = 1;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (!dijkstra.aDeuxGaresValider()) {
			Point point = new Point(event.getX(), event.getY());
			int gareid;
			gareid = carte.chercheGare(point);
			if (gareid != -1) {
				this.dijkstra.addGareId(gareid);
				panel.setCircleColor(Color.yellow, gareid);
			}
		} else {
			click = 1 - click;
			if (click == 0) {
				// On initialise une liste de chemin en recherchant le plus court chemin
				// listStation = dijsktra.plusCourtChemin();
				// On affiche en jaune avec la liste de stations
			} else {
				// avec la liste on recolorie en rouge
			}
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
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}