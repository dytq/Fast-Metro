package fastmetro;

public class Carte {
	/* Matrice d'adjacence */
	private Fenetre fenetre;
	
	public Carte(/* Fichier Std in (json)*/) {
		
	}
	
	public void afficherCarte(String nom,String chemin) {
		this.fenetre = new Fenetre(nom);
		this.fenetre.importerImage(chemin);
	}
	
	public void recupereCoords() {
		this.fenetre.afficherCoords();
	}
	
	public void initCarte(String fichier) {
		
	}
	
	public void afficherChemin(Station depart,Station arriver) {
		
	}
	
}