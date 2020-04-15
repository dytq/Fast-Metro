package fastmetro;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * Ensemble des algorithmes permettant l'utilisation de dijkstra
 * 
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
	/*
	 * Carte pour récuperer des données concernant la carte et faire les algorithmes
	 */
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
	 * Permet d'ajouter les stations de départ et d'arrivée en local pour pouvoir
	 * les initialisé dans la matrice de dijkstra et de retrouver le chemin en
	 * partant de la station d'arrivée.
	 * 
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
	 * Permet de récuperer la selection de la ligne entrée par
	 * l'utiilisateur
	 * 
	 * @param stationsGare
	 * @param id
	 * @return
	 */
	private Station getQuai(ArrayList<Station> stationsGare, int id) {
		if (stationsGare.size() > 1) {
			int ligne = -1;
			String[] mesOptions = new String[stationsGare.size()];
			int i = 0;
			for (Station station : stationsGare) {
				mesOptions[i] = String.valueOf(station.getLigne());
				i++;
			}
			String ligneEntree = new String();
			do {
				ligneEntree = (String) JOptionPane.showInputDialog(null, "Dans quel quai vous êtes ?", "Fast Metro",
						JOptionPane.QUESTION_MESSAGE, null, mesOptions, mesOptions[1]);
			} while (ligneEntree == null); // Forcer l'utilisateur à selectionner une ligne
			try {
				ligne = Integer.parseInt(ligneEntree);
			} catch (NumberFormatException e) {
				System.out.println("[Debug] Données ligne corrompu");
				System.exit(0); /* On quitte si les données sont corrompus */
			}
			for (Station station : stationsGare) {
				if (station.getLigne() == ligne) {
					JOptionPane.showMessageDialog(null,
							"Fast-Métro vous informe que vous avez selectionné la ligne " + ligne);
					return station;
				}
			}
		}
		JOptionPane.showMessageDialog(null,
				"Fast-Métro vous informe que vous avez selectionné la ligne " + stationsGare.get(0).getLigne());
		return stationsGare.get(0);
	}

	/**
	 * Juste pour vérifier si l'utilisateur à cliquer sur deux gares valides
	 * 
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
	 * 
	 * @return
	 */
	public ArrayList<Station> calculPlusCourtChemin() {
		/* liste des station dans la white liste (ceux qui ne sont pas coloriés) */
		ArrayList<Station> stationListTmp = new ArrayList<Station>();

		/* Matrice de Dijkstra (<Station père,le temps accumulé>) */
		ArrayList<Map<Station, Date>> matriceDijkstra = new ArrayList<Map<Station, Date>>();

		stationListTmp = initWhiteList();

		// int a = (int) ((Math.pow(2, 31)));
		// System.out.print("Max:"+ a);
		
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
	 * 
	 * @return
	 */
	private ArrayList<Station> initWhiteList() {
		return carte.getStationList();
	}

	/**
	 * Permet de retrouver par monté successif les stations pères, pour les
	 * afficher.
	 * 
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
