package fastmetro;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

/**
 * Ensemble des algorithmes permettant l'utilisation de dijkstra. Détailler dans le rapport.
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
	 * @param carte la carte 
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
	 * @param id id à ajouter
	 */
	public void addGareId(int id) {
		ArrayList<Station> stationsGare = new ArrayList<Station>();
		stationsGare = carte.getGareList().get(id).getStationGare();
		Station station = getQuai(stationsGare, id);
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
	 * @return le quai
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
					return station;
				}
			}
		}
		return stationsGare.get(0);
	}

	/**
	 * Juste pour vérifier si l'utilisateur à cliquer sur deux gares valides
	 * 
	 * @return si on a selectionée deux gares
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
	 * @param stationList  liste des stations
	 * @param str pour afficher le message
	 * @return la liste des stations qui indique le chemin le plus court
	 */
	public int calculPlusCourtChemin(ArrayList<Station> stationList, ArrayList<String> str, ArrayList<Station>stationListRes) {
		/* Matrice de Dijkstra détaillée dans le rapport */
		Hashtable<Integer, CouplePereTemps> matriceDijkstra_atraiter = new Hashtable<Integer, CouplePereTemps>();
		Hashtable<Integer, CouplePereTemps> matriceDijkstra_res = new Hashtable<Integer, CouplePereTemps>();

		/* Initialisation */
		matriceDijkstra_atraiter.put(stationDepart.getId(), new CouplePereTemps(stationDepart.getId(), 0));
		int station = stationDepart.getId();
		/* Boucle */

		while (!matriceDijkstra_atraiter.isEmpty()) {

			for (CouplePereTemps couple : stationList.get(station).getVoisins()) {

				if (!(matriceDijkstra_res.containsKey(couple.getStation()))) {

					if (matriceDijkstra_atraiter.containsKey(couple.getStation())) {

						if (matriceDijkstra_atraiter.get(couple.getStation())
								.getTemps() < matriceDijkstra_atraiter.get(station).getTemps() + couple.getTemps()) {

							matriceDijkstra_atraiter.put(couple.getStation(), new CouplePereTemps(station,
									matriceDijkstra_atraiter.get(station).getTemps() + couple.getTemps()));
						}
					} else {
						matriceDijkstra_atraiter.put(couple.getStation(), new CouplePereTemps(station,
								matriceDijkstra_atraiter.get(station).getTemps() + couple.getTemps()));
					}
				}
			}

			matriceDijkstra_res.put(station, matriceDijkstra_atraiter.get(station));
			matriceDijkstra_atraiter.remove(station);

			station = getMinDijkstra(matriceDijkstra_atraiter);
		}
		return retrouveChemin(matriceDijkstra_res, str, stationList, stationListRes);
	}

	/**
	 * Obtenir le min de la liste à traiter
	 * 
	 * @param matriceDijkstra_atraiter
	 * @return le minimum de dijkstra de la liste à traiter
	 */
	private int getMinDijkstra(Hashtable<Integer, CouplePereTemps> matriceDijkstra_atraiter) {
		int min = (int) Math.pow(2, 31);
		int e = 0;
		int tempsTmp = 0;

		Iterator<Entry<Integer, CouplePereTemps>> it = matriceDijkstra_atraiter.entrySet().iterator();

		while (it.hasNext()) {
			Entry<Integer, CouplePereTemps> element = it.next();
			tempsTmp = element.getValue().getTemps();
			if (Math.min(min, tempsTmp) != min) {
				min = tempsTmp;
				e = element.getKey();
			}
		}

		return e;
	}

	/**
	 * Permet de retrouver par monté successif les stations pères, pour les
	 * afficher.
	 * 
	 * @param matriceDijkstra
	 * @return la liste des chemins
	 */
	private int retrouveChemin(Hashtable<Integer, CouplePereTemps> matriceDijkstra,
			ArrayList<String> str, ArrayList<Station> stationList,ArrayList<Station> stationListRes) {

		/* Si la stations d'arrivée est inaccesible */
		if (!matriceDijkstra.containsKey(stationArriver.getId())) {
			stationListRes.add(stationDepart);
			stationListRes.add(stationArriver);
			JOptionPane.showMessageDialog(null, "Ouh! Ligne non connecté");
			return 0;
		}
		/* Initialisation */
		CouplePereTemps couple;
		couple = matriceDijkstra.get(stationArriver.getId());
		addToString(str, stationArriver);
		stationListRes.add(stationArriver);

		int station = couple.getStation();

		/* Boucle pour remonter les stations */
		while (station != stationDepart.getId()) {
			addToString(str, stationList.get(station));
			stationListRes.add(stationList.get(station));
			couple = matriceDijkstra.get(station);
			station = couple.getStation();
		}

		addToString(str, stationDepart);
		stationListRes.add(stationDepart);
		return matriceDijkstra.get(stationArriver.getGareId()).getTemps();
	}

	/**
	 * Permet d'afficher chaque station
	 * @param str
	 * @param station
	 */
	private void addToString(ArrayList<String> str, Station station) {
		try {
			str.add("☞" + "Prendre la station " + station.getGareNom() + " : Ligne " + station.getLigne() + "\n");
		} catch (Exception e) {

		}
	}
}