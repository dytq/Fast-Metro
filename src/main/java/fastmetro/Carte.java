package fastmetro;

import java.awt.Point;
import java.util.ArrayList;

import gui.Fenetre;

/**
 * La Carte de l'application
 * 
 * @author user
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
	
	private Dijkstra dijkstra= new Dijkstra(this);
	
	/**
	 * Initialise l'objet Carte
	 * 
	 * @param nom du titre de la fenetre
	 */
	public Carte(String nom, String cheminCarte) {
		this.nom = nom;
		this.cheminCarte = cheminCarte;
	}

	/**
	 * Permet d'écrire les stations : obsolète
	 * 
	 * @param chemin
	 */
	// public void drawStation(String chemin) {
	// fenetre.addStation(chemin);
	// }

	/**
	 * Importe des stations
	 * 
	 * @param chemin
	 */
	public void importStations(String chemin) {
		Lecture lecture = new Lecture();
		setGareList(lecture.initStation(chemin, getGareList()));
	}

	/**
	 * Importe une image est affiche les Stations
	 */
	public void initStationCarte() {
		this.fenetre = new Fenetre(nom, cheminCarte);
		fenetre.printStation(gareList);
	}

	public void importGraphe(String chemin) {

	}

	public void cherchePlusCourtChemin() {
		fenetre.selectStation(this,dijkstra);
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

	public int chercheGare(Point point) {
		int cmp = 0;
		for (Gare gare : gareList) {
			if (gare.getPoint().distance(point) < 10) {
				return cmp;
			}
			cmp++;
		}
		return -1;
	}
}