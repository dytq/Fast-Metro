package fastmetro;

public class Main {

	public static void main(String[] args) {

		Carte metroParisien = new Carte("Metro Parisien");
		metroParisien.importCarte("image/paris.gif");
		metroParisien.importStations("data/parisStation.json");
		metroParisien.importGraphe("data/parisGraphe.json");
		metroParisien.cherchePlusCourtChemin();
		//metroParisien.drawStation("data/parisStation.json"); 		
		// metroParisien.ecrireGraphe("data/parisGraphe.json"); 
	}

}
