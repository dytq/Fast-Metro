package fastmetro;

/**
 * Fast-Metro: Code principal, il s'agit juste de faire appelle à des modules de
 * la carte.
 * 
 * @author dedarallu taariq
 *
 */
public class Main {

	/**
	 * Fonction principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/* Initialise une Carte */
		Carte metroParisien = new Carte("Metro Parisien", "image/paris.gif");
		// int a = (int) ((Math.pow(2, 31)));
		// System.out.print(a);
		/* Importe les Stations d'un fichier */
		metroParisien.importStations("data/parisStation.json");

		/* Initialise la Carte dans l'Interface graphique, les stations */
		metroParisien.initStationCarte();

		/* Importe le graphe */
		metroParisien.importGraphe("data/parisGraphe.json");

		/* On selectionne deux stations et on affiche le plus court chemin */
		metroParisien.cherchePlusCourtChemin();
	}

}
