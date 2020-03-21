package fastmetro;

public class Main {

	public static void main(String[] args) {
		
		/* Initialise une Carte */
		Carte metroParisien = new Carte("Metro Parisien");
		
		/* Importe une carte */
		metroParisien.importCarte("image/paris.gif");
		
		/* Importe les Stations d'un fichier */
		metroParisien.importStations("data/parisStation.json");
		
		//metroParisien.importGraphe("data/parisGraphe.json");
		
		/* Initialise la Carte dans l'interface graphique */
		metroParisien.initStationCarte();
		
	
		//metroParisien.cherchePlusCourtChemin();
		//metroParisien.drawStation("data/parisStation.json"); 		
		//metroParisien.ecrireGraphe("data/parisGraphe.json"); 
	}

}
