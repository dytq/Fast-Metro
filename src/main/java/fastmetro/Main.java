package fastmetro;

public class Main {

	public static void main(String[] args) {
		
		/* Initialise une Carte */
		Carte metroParisien = new Carte("Metro Parisien","image/paris.gif");
		
		/* Importe les Stations d'un fichier */
		metroParisien.importStations("data/parisStation.json");
		
		//metroParisien.importGraphe("data/parisGraphe.json");
		
		/* Initialise la Carte dans l'interface graphique */
		metroParisien.initStationCarte();
		
		/* On selectionne deux stations et on affiche le plus court chemin */
		metroParisien.cherchePlusCourtChemin();
		
		// obsolète
		//metroParisien.drawStation("data/parisStation.json"); 		
		//metroParisien.ecrireGraphe("data/parisGraphe.json"); 
	}

}
