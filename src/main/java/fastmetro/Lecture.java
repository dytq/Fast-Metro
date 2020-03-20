package fastmetro;

import java.util.ArrayList;

public class Lecture {

	private static ArrayList<Gare> gareList = new ArrayList<Gare>();

	public Lecture() {

	}

	public void initStation(String chemin, ArrayList<Gare> gare) {
		lireFichier(chemin);
		
	}
	
	public void initGare(String chemin) {
		lireFichier(chemin);
	}
	
	private void lireFichier(String chemin) {

	}
}
