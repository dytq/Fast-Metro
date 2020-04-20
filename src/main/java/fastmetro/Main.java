package fastmetro;

import javax.swing.JOptionPane;

/**
 * Fast-Metro: Code principal, il s'agit juste de faire appelle à des modules de
 * la carte.
 * 
 * @author dedarallu taariq
 *
 */
public class Main {

	/**
	 * Fonction principal: On initialise une carte et on fait des calculs dessus
	 * 
	 */
	public static void main(String[] args) {
		/* Initialise une Carte */
		Carte metroParisien = new Carte("Metro Parisien", "image/paris.gif");

		/* Importe les Stations d'un fichier */
		metroParisien.importStations("data/parisStation.json");

		/* Initialise la Carte dans l'Interface graphique, les stations */
		metroParisien.initStationCarte();

		/* Importe le graphe */
		metroParisien.importGraphe("data/parisGraphe.json");

		/* Message du début */
		JOptionPane.showMessageDialog(null,
				"Bienvenue sur Fast-Metro! \n Le logiciel qui vous permet de trouver le plus court chemin entre deux stations\n Quick-Start:\n 1.On clique sur une station et on selectionne si besoin la ligne souhaité \n 2.On recommence une autre fois.\n 3.Puis on clique pour afficher le chemin.\n l'équipe de Fast-métro");

		/* On selectionne deux stations et on affiche le plus court chemin */
		metroParisien.cherchePlusCourtChemin();
	}

}
