package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import fastmetro.Carte;
import fastmetro.Dijkstra;
import fastmetro.Station;

public class ClickSelectStation implements MouseListener {
	
	private Carte carte;
	private StationPanel panel;
	
	public ClickSelectStation(StationPanel panel,Carte carte) {
		super();
		this.panel = panel;
		this.carte = carte;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		System.out.println(event.toString());
		panel.setCircle(Color.yellow);
		// On regarde les id stations selectionner 
		// On initilise l'objet dijsktra
		Dijkstra dijsktra = new Dijkstra(new Station(5,1),new Station(6,3),carte);
		// On initialise une liste de chemin en recherchant le plus court chemin
		// listStation = dijsktra.plusCourtChemin(); 
		// On affiche en jaune avec la liste de stations
		// On attend qql seconde 
		// avec la liste on recolorie en rouge 
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