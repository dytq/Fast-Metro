package fastmetro;

import java.awt.geom.Point2D;

import gui.Fenetre;

public class Carte {
	/* Matrice d'adjacence */
	private Fenetre fenetre;
	private Point2D point2d;

	public Carte(String nom) {
		this.fenetre = new Fenetre(nom);
	}

	public void importCarte(String chemin) {
		fenetre.importerImage(chemin);
	}

	public void drawStation(String chemin) {
		fenetre.addStation(chemin);
	}

	public void initCarte(String fichier) {

	}

	public void afficherChemin(Station depart, Station arriver) {

	}

}