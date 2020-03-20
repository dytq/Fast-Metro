package fastmetro;

public class Station {

	/* Identifiant unique */
	private int id;

	/* Numéro de la ligne */
	private int ligne;

	/**
	 * Une Station est une composante d'une Gare. Elle représente en réalité un ensemble de Quai
	 * ou passe une unique ligne de métro dans les deux sens de circulation.
	 * @param id : identifiant unique
	 * @param ligne : La ligne de la Station
	 */
	public Station(int id,int ligne) {
		this.id = id;
		this.ligne = ligne;
	}
	
	/**
	 * Obtenir l'identifiant d'une Station
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Obtenir le numéro de ligne
	 * @return
	 */
	public int getLigne() {
		return this.ligne;
	}
	
	@Override
	public String toString() {
		return "{ id:" + this.id + "ligne:" + this.ligne + " }";
	}
}