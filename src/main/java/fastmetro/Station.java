package fastmetro;

import java.util.ArrayList;


/**
 * C'est une station qui hérite d'une gare
 * 
 * @author dedarally taariq
 *
 */
public class Station extends Gare {

	/* Identifiant unique */
	private int id;

	/* Numéro de la ligne */
	private int ligne;

	/* Voisin des stations */
	private ArrayList<CouplePereTemps> voisin = new ArrayList<CouplePereTemps>();

	/**
	 * Une Station est une composante d'une Gare. Elle représente en réalité un
	 * ensemble de Quai ou passe une unique ligne de métro dans les deux sens de
	 * circulation.
	 * 
	 * @param id    : identifiant unique
	 * @param ligne : La ligne de la Station
	 */
	public Station(int id, int ligne) {
		super();
		this.id = id;
		this.ligne = ligne;
	}

	public Station(Station station) {
		this.id = station.id;
		this.ligne = station.ligne;
		this.setVoisin(station.getVoisins());
		this.setGareNom(station.getNom());
		this.setGareId(station.getGareId());
	}
	

	/**
	 * Obtenir l'identifiant d'une Station
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	public String getNomGare() {
		return this.getNom();
	}
	
	public void setVoisin(ArrayList<CouplePereTemps> voisin) {
		if (voisin != null) {
			for (CouplePereTemps couple : voisin) {
				this.voisin.add(couple);
			}
		}
	}

	/**
	 * Obtenir le numéro de ligne
	 * 
	 * @return
	 */
	public int getLigne() {
		return this.ligne;
	}

	/**
	 * Récupere la chaine de caractère des données d'une station
	 */
	@Override
	public String toString() {
		return "{ id:" + this.id + "ligne:" + this.ligne + " } gareid: " + "gareid" + this.getGareId() + "\n";
	}

	/**
	 * Ajoute une couple de voisins à cette stations
	 * 
	 * @param station
	 * @param date
	 */
	public void addCoupleVoisin(Station station, int date) {
		this.voisin.add(new CouplePereTemps(station.getId(), date));
	}

	/**
	 * Récupère les Couples des voisins stations à cette station
	 * 
	 * @return
	 */
	public ArrayList<CouplePereTemps> getVoisins() {
		return voisin;
	}
}