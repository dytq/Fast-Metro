package fastmetro;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
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
	 * Permet de récuperer la selection de la ligne entrée par l'utiilisateur
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
	 * Permet de calculer le plus court chemin. Détail du fonctionnement dans le
	 * rapport
	 * 
	 * @param stationList
	 * 
	 * @return la liste des stations qui indique le chemin le plus courtsqxs<
	 */
	public ArrayList<Station> calculPlusCourtChemin() {
		/* Matrice de Dijkstra détaillée dans le rapport */
		Hashtable<Station, CouplePereTemps> matriceDijkstra_atraiter = new Hashtable<Station, CouplePereTemps>();
		Hashtable<Station, CouplePereTemps> matriceDijkstra_res = new Hashtable<Station, CouplePereTemps>();

		/* Initialisation */
		matriceDijkstra_atraiter.put(stationDepart, new CouplePereTemps(stationDepart, 0));
		matriceDijkstra_atraiter.put(stationArriver, new CouplePereTemps(stationDepart, 0));
		/* Boucle tant que chaque sommet à un voisin */
		/* while(stationListTmp.size()> 0) */
		/* 1. Trouver le min */
		Station pere = new Station(getMinDijkstra(matriceDijkstra_atraiter));
		/* On ajoute les voisins et leurs temps */
		// Station stationPere = new Station(matriceDijkstra_atraiter.)
		/*
		 * for (CouplePereTemps voisins : stationDepart.getVoisins()) {
		 * 
		 * matriceDijkstra_atraiter.put(voisins.getStation(), new
		 * CouplePereTemps(stationDepart,
		 * matriceDijkstra_atraiter.get(stationDepart).getTemps() +
		 * voisins.getTemps())); }
		 * 
		 * 
		 * /* { // on copie la ligne précedente à la currente // pour la station
		 * currente on cherche ses voisins et on l'écrase dans la // deuxième ligne si
		 * elle est inférieur à la case currente // on fin boucle }
		 */
		System.out.println(pere.getId());
		return retrouveChemin(matriceDijkstra_res);
	}

	private Station getMinDijkstra(Hashtable<Station, CouplePereTemps> matriceDijkstra_atraiter) {
		Enumeration e = matriceDijkstra_atraiter.elements();
		int min = 0; // pas besoin du premier element, le min c'est toujours 0
		int idStation;
		while (e.hasMoreElements()) {
			if(Math.min(min, matriceDijkstra_atraiter.get(e.nextElement()).getTemps()) != min) {
				idStation = matriceDijkstra_atraiter.get(e.nextElement()).getStation().getId();
			};
			e.nextElement();
		}
		return matriceDijkstra_atraiter.get().getStation();
	}

	/**
	 * Initialise la white Liste, récupère toutes les stations
	 * 
	 * @return
	 */
	/*
	 * private ArrayList<Station> initWhiteList() { return carte.getStationList(); }
	 */

	/**
	 * Permet de retrouver par monté successif les stations pères, pour les
	 * afficher.
	 * 
	 * @param matriceDijkstra
	 * @return
	 */
	private ArrayList<Station> retrouveChemin(Hashtable<Station, CouplePereTemps> matriceDijkstra) {
		ArrayList<Station> stationListRes = new ArrayList<Station>();
		stationListRes.add(stationDepart);
		stationListRes.add(stationArriver);
		// Lecture de la matrice ligne par ligne en remontant */
		return stationListRes;
	}
}
