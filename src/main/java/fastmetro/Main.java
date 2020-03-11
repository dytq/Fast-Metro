package fastmetro;

public class Main {

	public static void main(String[] args) {
		Carte metroParisien = new Carte("Metro Parisien");
		metroParisien.importCarte("image/paris.gif");
		
		// Mode dev:
		metroParisien.drawStation("data/parisStation.json");
		//metroParisien.drawGraphe("data/parisGraphe.json");
		
		// Mode utilisateur:
		/* init carte */
		/* Demander Station départ */
		/* Demander Station arriver */
		/* appelle a afficher chemin */
	}

}
