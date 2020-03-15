package fastmetro;

import java.awt.Point;

public class Station {

	/* Identifiant unique */
	private int id;

	/* Nom de la station */
	private String nom;

	/* Numéro de la ligne */
	private int ligne;

	/* Coordonnées sur la map (centre du cercle) */
	private Point coords;

	/**
	 * Voici less composants d'une station:
	 * @param id
	 * @param nom
	 * @param ligne
	 * @param coords
	 */
	public Station(int id,String nom,int ligne,Point coords) {
		this.id = id;
		this.nom = nom;
		this.ligne = ligne;
		this.coords = coords;
	}
}