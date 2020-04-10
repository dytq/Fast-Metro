package fastmetro;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Ensemble des algorithmes permettant l'utilisation de dijkstra
 * @author dedarally taariq
 *
 */
public class Dijkstra {

	/* Premier cercle selectionner */
	Station stationDepart;

	/* Deuxième cercle selectionner */
	Station stationArriver;

	/* Nombre de stations */
	int nbrStation;

	/* si c'est la station de départ */
	int isStationDepart;

	/* Pour selectionner une ligne */
	private Scanner prompt = new Scanner(System.in);

	/* Carte pour récuperer des données concernant la carte et faire les algorithmes */
	Carte carte;

	/**
	 * Initialise les points d'entrée
	 * 
	 * @param stationDepart
	 * @param stationArriver
	 */
	public Dijkstra(Carte carte) {
		this.carte = carte;
		this.nbrStation = 0;
		this.isStationDepart = 1;
	}

	/**
	 * Permet d'ajouter les stations de départ et d'arrivée en local pour pouvoir les initialisé dans
	 *  la matrice de dijkstra et de retrouver le chemin en partant de la station d'arrivée.
	 * @param id
	 */
	public void addGareId(int id) {
		ArrayList<Station> stationsGare = new ArrayList<Station>();
		stationsGare = carte.getGareList().get(id).getStationGare();
	
		Station station = new Station(getQuai(stationsGare, id));
		station.setGareId(id);
		this.isStationDepart = 1 - this.isStationDepart;

		if (isStationDepart == 0) {
			stationDepart = station;
			nbrStation++;
		} else {
			stationArriver = station;
			nbrStation++;
		}

	}

	/**
	 * Permet simplement de récuperer la selection de la ligne entrée par l'utiilisateur
	 * @param stationsGare
	 * @param id
	 * @return
	 */
	private Station getQuai(ArrayList<Station> stationsGare, int id) {
		int ligne = -1;
		if (stationsGare.size() > 1) {
			System.out.print("Dans quel quai vous êtes ?");
			afficheListeDeStations(stationsGare);
			/* on aurait pu faire un try catch dans la fonction station */
			do {
				String ligneEntree = prompt.nextLine();
				try {
					ligne = Integer.parseInt(ligneEntree);
				} catch (Exception e) {
					System.out.println("RTFM: Oh la la, on demande en chiffre pas lettre !!!");
				}

			} while (!(ligneEntreeValide(stationsGare, ligne)) || ligne == -1); // si il y a une erreur d'entrée avec le

			for (Station station: stationsGare) {
				if (station.getLigne() == ligne) {
					System.out.println();
					System.out.println("Ligne " + ligne + " selectionnée ");
					System.out.println();
					return station;
				}
			}
		}
		return stationsGare.get(0);
	}

	/**
	 * Affiche la liste des lignes disponible pour une station
	 * 
	 * @param stationsGare
	 */
	private void afficheListeDeStations(ArrayList<Station> stationsGare) {
		for (Station station : stationsGare) {
			System.out.print("[" + station.getLigne() + "]");
		}
	}

	/**
	 * Regarde si l'utilisateur a selectionner un numéro de ligne valide
	 * @param stationsGare
	 * @param ligne
	 * @return
	 */
	private boolean ligneEntreeValide(ArrayList<Station> stationsGare, int ligne) {
		for (Station station : stationsGare) {
			if (station.getLigne() == ligne) {
				return true;
			}
		}
		System.out.println("La station n'existe pas ! Voici la liste des stations, recommence:");
		afficheListeDeStations(stationsGare);
		return false;
	}

	/**
	 * Juste pour vérifier si l'utilisateur à cliquer sur deux gares valides
	 * @return 
	 */
	public boolean aDeuxGaresValider() {
		if (nbrStation >= 2) {
			this.nbrStation = 0;
			return true;
		}
		return false;
	}

	/**
	 * Permet de calculer le plus court chemin 
	 * @return
	 */
	public ArrayList<Station> calculPlusCourtChemin() {
		/* liste des station dans la white liste (ceux qui ne sont pas coloriés) */
		ArrayList<Station> stationListTmp = new ArrayList<Station>();

		/* Matrice de Dijkstra (<Station père,le temps accumulé>) */
		ArrayList<Map<Station, Date>> matriceDijkstra = new ArrayList<Map<Station, Date>>();

		stationListTmp = initWhiteList();

		// init première ligne
		// on ajoute 0 à la station de départ
		// boucle tant que toutes les stations sont prises
		// on copie la ligne précedente à la currente
		// pour la station currente on cherche ses voisins et on l'écrase dans la
		// deuxième ligne si elle est inférieur à la case currente
		// on fin boucle

		return retrouveChemin(matriceDijkstra);
	}

	/**
	 * Initialise la white Liste, récupère toutes les stations
	 * @return
	 */
	private ArrayList<Station> initWhiteList() {
		return carte.getStationList();
	}

	/**
	 * Permet de retrouver par monté successif les stations pères, pour les afficher.
	 * @param matriceDijkstra
	 * @return
	 */
	private ArrayList<Station> retrouveChemin(ArrayList<Map<Station, Date>> matriceDijkstra) {
		ArrayList<Station> stationListRes = new ArrayList<Station>();
		stationListRes.add(stationDepart);
		stationListRes.add(stationArriver);
		// Lecture de la matrice ligne par ligne en remontant */
		return stationListRes;
	}
}
