package fastmetro;

import java.awt.geom.Point2D;

import gui.Fenetre;

public class Carte {
	/* Matrice d'adjacence */
	private Fenetre fenetre;
	private Point2D point2d;

	/**
	 * La Carte c'est un ensemble de station avec une image. C'est sur la carte qu'on affiche et calcul le plus court chemin
	 * @param nom de la fenetre
	 */
	public Carte(String nom) {
		this.fenetre = new Fenetre(nom);
	}

	/**
	 * Importer une image
	 * @param chemin
	 */
	public void importCarte(String chemin) {
		fenetre.importerImage(chemin);
	}

	/**
	 * Ajouter une station sur la fenetre graphique
	 * @param chemin
	 */
	public void drawStation(String chemin) {
		fenetre.addStation(chemin);
	}

	public void initCarte(String fichier) {

	}

	public void afficherChemin(Station depart, Station arriver) {

	}

}