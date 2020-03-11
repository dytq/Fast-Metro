package fastmetro;

import java.awt.geom.Point2D;
import java.util.Scanner;

public class Ecriture {

	private String chemin;
	private Scanner prompt = new Scanner(System.in);

	public Ecriture(String chemin_d_ecriture) {
		this.chemin = chemin_d_ecriture;
	}

	public void scanPrompt(Point2D point2D) {

		System.out.println("Entrer le numéro d'identifiant");
		String numID = prompt.nextLine();

		System.out.println("Entrer le nom de la station");
		String nomStation = prompt.nextLine();

		System.out.println("Entrer le numéro de la ligne");
		String numLigne = prompt.nextLine();

		ecrireFichierStation(point2D, numID, nomStation, numLigne);
		System.out.println("Station enregistré dans " + chemin);
	}

	private void ecrireFichierStation(Point2D point, String numID, String nomStation, String numLigne) {
		/* ecrire json */
	}

	public void ecrireFichierGraphe(int numID1, int numID2, int temps) {
		/* ecrire json */
	}
}
