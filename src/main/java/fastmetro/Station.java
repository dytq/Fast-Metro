package fastmetro;

import java.awt.geom.Point2D;

public class Station {
	
	/* Identifiant unique */
	private int id;
	
	/* Nom de la station */
	private String nom;
	
	/* Numéro de la ligne */
	private int ligne;
	
	/* Coordonnées sur la map (centre du cercle) */
	private Point2D coords;
	
	public Station(int id,String nom,int ligne,Point2D coords) {
		this.setId(id);
		this.setNom(nom);
		this.setLigne(ligne);
		this.setCoords(coords);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Point2D getCoords() {
		return coords;
	}

	public void setCoords(Point2D coords) {
		this.coords = coords;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int ligne) {
		this.ligne = ligne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}