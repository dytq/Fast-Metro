package fastmetro;


import java.util.HashMap;
import java.util.Map;

public class Station extends Gare {

	/* Identifiant unique */
	private int id;

	/* Numéro de la ligne */
	private int ligne;

	/* Voisin des stations */
	private Map<Station, Integer> voisinMap = new HashMap<Station,Integer>();

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
		super();
		this.id = station.id;
		this.ligne = station.ligne;
	}

	/**
	 * Obtenir l'identifiant d'une Station
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}

	public int getIdGare() {
		return this.getGareId();
	}

	/**
	 * Obtenir le numéro de ligne
	 * 
	 * @return
	 */
	public int getLigne() {
		return this.ligne;
	}

	@Override
	public String toString() {
		return "{ id:" + this.id + "ligne:" + this.ligne + " }" + "gareid" + this.getGareId();
	}

	public void addCoupleVoisin(Station station, int date) {
		//voisinMap.put(station, date);
	}
}