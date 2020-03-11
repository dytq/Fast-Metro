package fastmetro;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Carte metroParisien = new Carte("Metro Parisien");
		metroParisien.importCarte("image/paris.gif");
		metroParisien.drawStation("data/parisStation.json");
		
	}

}
