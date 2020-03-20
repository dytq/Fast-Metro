package fastmetro;

import gui.Fenetre;

public class Carte {
	
	private Fenetre fenetre;
	private Lecture lecture = new Lecture();
	
	public Carte(String nom) {
		this.fenetre = new Fenetre(nom);
	}

	public void importCarte(String chemin) {
		fenetre.importerImage(chemin);
	}

	public void drawStation(String chemin) {
		fenetre.addStation(chemin);
	}
	
	public void importStations(String chemin) {
		
	}
	
	public void importGraphe(String chemin) {
		
	}
	
	public void cherchePlusCourtChemin() {
		/* Créer une classe pour la recherche du plus court chemin */ 
	}
	
}