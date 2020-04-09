package gui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import fastmetro.Carte;
import fastmetro.Dijkstra;
import fastmetro.Gare;
import fastmetro.Station;

public class ClickSelectStation implements MouseListener {

	/* Carte pour trouver les gares */
	private Carte carte;

	/* Panel pour afficher les modifications causé par le click */
	private StationPanel panel;

	/* Pour determiner le plus court chemin */
	private Dijkstra dijkstra;

	/* Pour obtenir le nombre de clics */
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
			try { /* si le clique est en dehors */
				Gare gare = new Gare(carte.chercheGare(point));
				this.dijkstra.addGareId(gare.getGareId());
				panel.setCircleColor(Color.yellow, gare.getGareId());
			} catch (Exception e) {
			}
		} else {
			click = 1 - click;
			if (click == 0) {
				ArrayList<Station> listStations = new ArrayList<Station>();
				listStations.addAll(this.dijkstra.calculPlusCourtChemin());
				System.out.println(listStations.toString());
				for (Station station : listStations) {
					panel.setCircleColor(Color.black, station.getGareId());
				}
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}