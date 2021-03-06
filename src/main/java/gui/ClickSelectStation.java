package gui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import fastmetro.Carte;
import fastmetro.Dijkstra;
import fastmetro.Gare;
import fastmetro.Station;

/**
 * Ce qui se passe quand on clique sur une gare dans l'interface graphique, la
 * souris est mise sous écoute.
 * 
 * @author dedarally taariq
 *
 */
public class ClickSelectStation implements MouseListener {

	/* Carte pour trouver les gares */
	private Carte carte;

	/* Panel pour afficher les modifications causé par le click */
	private StationPanel panel;

	/* Pour determiner le plus court chemin */
	private Dijkstra dijkstra;

	/* Pour obtenir le nombre de clics */
	private int click;

	/**
	 * Initialise les composants necessaires quand on clique
	 * 
	 * @param panel le panel pour l'affichage
	 * @param carte la carte 
	 * @param dijkstra objet dijkstrea
	 */
	public ClickSelectStation(StationPanel panel, Carte carte, Dijkstra dijkstra) {
		super();
		this.panel = panel;
		this.carte = carte;
		this.dijkstra = dijkstra;
		this.click = 1;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (click == 0) {
			ArrayList<Station> listStations = new ArrayList<Station>();
			this.dijkstra.calculPlusCourtChemin(carte.getStationList(), null,listStations);
			for (Station station : listStations) {
				panel.setCircleColor(Color.red, station.getGareId());
			}
			click = 1 - click;
		}
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
				ArrayList<String> str = new ArrayList<String>();
				int total = 0;
				total = this.dijkstra.calculPlusCourtChemin(carte.getStationList(), str,listStations);
				for (Station station : listStations) {
					panel.setCircleColor(Color.black, station.getGareId());
				}
				Collections.reverse(str);
				String res = String.join("", str).concat("\n Le tout prendra " + total +" secondes");
				JOptionPane.showMessageDialog(null, res);
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