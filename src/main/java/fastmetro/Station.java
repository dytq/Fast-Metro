package fastmetro;

public class Station {

	/* Identifiant unique */
	private int id;

	/* Numéro de la ligne */
	private int ligne;

	/**
	 * Voici less composants d'une station:
	 * @param id
	 * @param nom
	 * @param ligne
	 * @param coords
	 */
	public Station(int id,int ligne) {
		this.id = id;
		this.ligne = ligne;
	}
	
}