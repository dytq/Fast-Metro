package fastmetro;

import java.awt.geom.Point2D;

public class Carte {
	/* Matrice d'adjacence */
	private Fenetre fenetre;
	
	public Carte(/* Fichier Std in (json)*/) {
		
	}
	
	public void afficherCarte(String nom,String chemin) {
		this.fenetre = new Fenetre(nom);
		fenetre.importerImage(chemin);
	}
	
	public void drawStation(String chemin) {
		/*oint2D point = new Point2D.Double();*/
		fenetre.drawStation(chemin);
		/*System.out.print(point.toString()); */
	}
	
	public void initCarte(String fichier) {
		
	}
	
	public void afficherChemin(Station depart,Station arriver) {
		
	}
	
}