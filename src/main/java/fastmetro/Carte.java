package fastmetro;

import java.awt.Point;
import java.util.ArrayList;

import gui.Fenetre;

/**
 * La Carte de l'application.
 * 
 * @author dedarally taariq
 *
 */
public class Carte {

	/* Fenetre graphique */
	private Fenetre fenetre;

	/* Liste des gares */
	private ArrayList<Gare> gareList = new ArrayList<Gare>();

	/* Titre de l'interface */
	private String nom;

	/* chemin de la carte */
	private String cheminCarte;

	/* Initialise l'objet Dijkstra */
	private Dijkstra dijkstra = new Dijkstra(this);

	/* toutes les stations */
	private ArrayList<Station> stationList = new ArrayList<Station>();

	/* Lecture de données */
	private Lecture lecture = new Lecture();

	/**
	 * Initialise l'objet Carte
	 * 
	 * @param nom         du titre de la fenetre
	 * @param cheminCarte c'est la carte qu'on souhaite importer
	 */
	public Carte(String nom, String cheminCarte) {
		this.nom = nom;
		this.cheminCarte = cheminCarte;
	}
	/**
	 * Importe des stations
	 * 
	 * @param chemin d'écriture
	 */
	public void importStations(String chemin) {
		setGareList(lecture.initStation(chemin, getGareList()));
		setStationList();
	}

	/**
	 * Importe une image et affiche les Stations
	 */
	public void initStationCarte() {
		this.fenetre = new Fenetre(nom, cheminCarte);
		fenetre.printStation(gareList);
	}

	/**
	 * Importe le graphe 
	 * @param chemin de lecture
	 */
	public void importGraphe(String chemin) {
		stationList = lecture.initGraphe(chemin, stationList);
		int i = 0;
		int j = 0;
		for (Gare gare : gareList) {
			for (Station station : gare.getStationGare()) {
				gare.getStationGare().set(j, stationList.get(i));
				j++;
				i++;
			}
			j = 0;
		}
	}

	/**
	 * Dans la selection des stations on recherche le plus court chemin
	 */
	public void cherchePlusCourtChemin() {
		fenetre.selectStation(this, dijkstra);
	}

	/**
	 * Obtenir la liste des gares
	 * 
	 * @return la liste des gares
	 */
	public ArrayList<Gare> getGareList() {
		return this.gareList;
	}

	/**
	 * Permet d'initialiser une gare Est composé de: - Du nom - D'un point - Liste
	 * de Stations
	 * 
	 * @param gareList la liste de gare à initialiser
	 */
	public void setGareList(ArrayList<Gare> gareList) {
		this.gareList = gareList;
	}

	/**
	 * Recherche la gare à partie des coordonnées dans la liste Gare
	 * 
	 * @param point la gare clické.
	 * @return id de la gare pour la colorier sur la carte comme étant séléctionner
	 *         par l'utilisateur
	 */
	public Gare chercheGare(Point point) {
		for (Gare gare : gareList) {
			if (gare.getPoint().distance(point) < 10) {
				return gare;
			}
		}
		return null;
	}

	/**
	 * Permet d'initialiser toutes les stations pour l'utiliser dans la white liste
	 * dans dijsktra
	 */
	public void setStationList() {
		for (Gare gare : gareList) {
			for (Station station : gare.getStationGare()) {
				stationList.add(station);
			}
		}
	}

	/**
	 * Recupère la liste des stations
	 * 
	 * @return retour la liste des stations
	 */
	public ArrayList<Station> getStationList() {
		return stationList;
	}
}