package fastmetro;

import java.util.ArrayList;

import gui.Fenetre;

/**
 * La Carte de l'application
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
	
	/* Chemin de la carte dans /image */ 
	private String chemin;
	
	/**
	 * Initialise l'objet Carte
	 * @param nom du titre de la fenetre
	 */
	public Carte(String nom) {
		this.nom = nom;
	}

	/**
	 * Import une carte
	 * @param chemin
	 */
	public void importCarte(String chemin) {
		this.chemin = chemin;
	}

	/**
	 * Permet d'écrire les stations
	 * @param chemin
	 */
	public void drawStation(String chemin) {
		fenetre.addStation(chemin);
	}
	
	/**
	 * Importe des stations
	 * @param chemin
	 */
	public void importStations(String chemin) {
		Lecture lecture = new Lecture();
		setGareList(lecture.initStation(chemin,getGareList()));	
	}
	
	/**
	 * Importe une image est affiche les Stations
	 */
	public void initStationCarte() {
		this.fenetre = new Fenetre(nom);
		fenetre.importerImage(this.chemin);
		fenetre.printStation(gareList);
	}
	
	public void importGraphe(String chemin) {
		
	}
	
	public void cherchePlusCourtChemin() {
		/* Créer une classe pour la recherche du plus court chemin */ 
	}

	/**
	 * Obtenir la liste des gares
	 * @return la liste des gares
	 */
	public ArrayList<Gare> getGareList() {
		return this.gareList;
	}

	/**
	 * Permet d'initialiser une gare
	 * Est composé de:
	 * - Du nom
	 * - D'un point
	 * - Liste de Stations
	 * @param gareList la liste de gare à initialiser 
	 */
	public void setGareList(ArrayList<Gare> gareList) {
		this.gareList = gareList;
	}
}