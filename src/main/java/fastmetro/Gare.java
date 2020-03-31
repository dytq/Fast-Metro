package fastmetro;

import java.awt.Point;
import java.util.ArrayList;

public class Gare {

	/* Nom de la Gare */
	private String nom;

	/* Point sur la Carte */
	private Point point;

	/* Liste de Stations */
	private ArrayList<Station> stationGare = new ArrayList<Station>();

	/**
	 * Une Gare est un ensemble de Stations.
	 * Elle contient ainsi un nom et des coordonnées 2D.
	 * Les Stations sont sauvegardées sous forme de liste.
	 * Une Gare peut évidement contenir une seule station
	 * @param nom de la gare
	 * @param point sur la map (2D)
	 */
	Gare(String nom,Point point) {
		this.nom = nom;
		this.point = point;
	}

	public Gare(Gare gare) {
		this.nom = gare.getNom();
		this.point = gare.getPoint();
	}

	/**
	 * Ajout d'une Station dans la Gare
	 * 
	 * @param station
	 */
	public void addStation(Station station) {
		stationGare.add(station);
	}
	
	@Override
	public String toString() {
		return "Gare:" + nom + " Coords {" + point.toString() + "}" + stationGare.toString() + '\n';
	}

	/**
	 * Récuperer les coordonnées d'une gare
	 * 
	 * @return
	 */
	public Point getPoint() {
		return this.point;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public ArrayList<Station> getStationGare() {
		return stationGare;
	}
}
