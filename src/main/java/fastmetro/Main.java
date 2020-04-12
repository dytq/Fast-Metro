package fastmetro;

/**
 * Fast-Metro
 * 
 * Principe: Code principal, il s'agit juste de faire appelle à des modules de
 * la carte.
 * 
 * Possiblité: On peut changer de carte, mais il faut initialisé le graphe et
 * les stations. Il est possible d'initialisé les stations via la méthode
 * drawstation mais en revanche, on ne peut pas initialisé un graphe (a coder ce
 * n'est pas difficile, et en plus on a pas besoin d'afficher la fenêtre
 * graphique)
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

		/* Initialise la Carte dans l'interface graphique, les stations */
		metroParisien.initStationCarte();
		
		/* Importe le graphe */
		metroParisien.importGraphe("data/parisGraphe.json");
		
		/* On selectionne deux stations et on affiche le plus court chemin */
		metroParisien.cherchePlusCourtChemin();

		// obsolète : écrire station et écrire graphe
		// metroParisien.drawStation("data/parisStation.json");
		// metroParisien.ecrireGraphe("data/parisGraphe.json");
	}

}
