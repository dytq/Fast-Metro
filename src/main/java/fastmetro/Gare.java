package fastmetro;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Une gare est un ensemble de stations. Un ensemble non structurellement liée,
 * car une gare n'a pas d'information en commun avec une station.
 * 
 * @author dedarally taariq
 *
 */
public class Gare {

	/* Nom de la Gare */
	private String nom;

	/* Point sur la Carte */
	private Point point;

	/* Liste de Stations */
	private ArrayList<Station> stationGare = new ArrayList<Station>();

	private int gareid;

	/**
	 * Une Gare est un ensemble de Stations. Elle contient ainsi un nom et des
	 * coordonnées 2D. Les Stations sont sauvegardées sous forme de liste. Une Gare
	 * peut évidement contenir une seule station
	 * 
	 * @param nom   de la gare
	 * @param point sur la map (2D)
	 */
	Gare(String nom, Point point) {
		this.nom = nom;
		this.point = point;
	}

	public Gare(Gare gare) {
		this.nom = gare.getNom();
		this.point = gare.getPoint();
		this.gareid = gare.getGareId();
	}

	public Gare() {
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
		return "Gare:" + nom + " Coords {" + point.toString() + "}" + stationGare.toString() + "+ id:" + this.gareid + '\n';
	}

	/**
	 * Récuperer les coordonnées d'une gare
	 * 
	 * @return coords sur la map
	 */
	public Point getPoint() {
		return this.point;
	}

	/**
	 * Nom de la station
	 * 
	 * @return nom de la station
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Liste des stations
	 * 
	 * @return la liste des stations
	 */
	public ArrayList<Station> getStationGare() {
		return stationGare;
	}

	/**
	 * Récupère la taille de la liste des stations pour une gare
	 * @return le nombre de quai dans une gare
	 */
	public int getNbrStations() {
		return this.stationGare.size();
	}

	public void setGareId(int i) {
		this.gareid = i;
	}

	public int getGareId() {
		return this.gareid;
	}
}
