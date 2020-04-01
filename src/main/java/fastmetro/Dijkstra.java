package fastmetro;

public class Dijkstra {

	/* Premier cercle selectionner */
	Station stationDepart;

	/* Deuxième cercle selectionner */
	Station stationArriver;

	int nbrStation;

	Carte carte;

	/**
	 * Initialise les points d'entrée
	 * 
	 * @param stationDepart
	 * @param stationArriver
	 */
	public Dijkstra(Carte carte) {
		this.carte = carte;
		this.nbrStation = 0;
	}

	public void addGareId(int id) {
		System.out.println(carte.getGareList().get(id).getNom() + " ajouté");
		carte.getGareList().get(id);
		this.nbrStation++;
	}

	public boolean aDeuxGaresValider() {
		if (nbrStation >= 2) {
			this.nbrStation = 0;
			return true;
		}
		return false;
	}
	// public calculPlusCourtChemin()

}
