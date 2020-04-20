package fastmetro;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

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
					return station;
				}
			}
		}
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
	 * @param arrayList
	 * 
	 * @param stationList
	 * 
	 * @return la liste des stations qui indique le chemin le plus courtsqxs<
	 */
	public ArrayList<Station> calculPlusCourtChemin(ArrayList<Station> stationList, ArrayList<String> str) {
		/* Matrice de Dijkstra détaillée dans le rapport */
		Hashtable<Station, CouplePereTemps> matriceDijkstra_atraiter = new Hashtable<Station, CouplePereTemps>();
		Hashtable<Station, CouplePereTemps> matriceDijkstra_res = new Hashtable<Station, CouplePereTemps>();

		/* Initialisation */
		matriceDijkstra_atraiter.put(stationDepart, new CouplePereTemps(stationDepart, 0));

		for (CouplePereTemps station : stationDepart.getVoisins()) {
			if (!(matriceDijkstra_res.containsKey(station.getStation()))) {

				matriceDijkstra_atraiter.put(station.getStation(), new CouplePereTemps(stationDepart,
						matriceDijkstra_atraiter.get(stationDepart).getTemps() + station.getTemps()));
			}
		}

		matriceDijkstra_res.put(stationDepart, matriceDijkstra_atraiter.get(stationDepart));
		matriceDijkstra_atraiter.remove(stationDepart);

		/* Boucle */

		while (!matriceDijkstra_atraiter.isEmpty()) {

			Station station = getMinDijkstra(matriceDijkstra_atraiter);

			for (CouplePereTemps couple : stationList.get(station.getId()).getVoisins()) {

				if (!(matriceDijkstra_res.containsKey(couple.getStation()))) {

					if (matriceDijkstra_atraiter.containsKey(couple.getStation())) {

						if (matriceDijkstra_atraiter.get(couple.getStation())
								.getTemps() < matriceDijkstra_atraiter.get(station).getTemps() + couple.getTemps()) {

							matriceDijkstra_atraiter.put(couple.getStation(), new CouplePereTemps(stationDepart,
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
		}
		return retrouveChemin(matriceDijkstra_res,str);
	}

	private Station getMinDijkstra(Hashtable<Station, CouplePereTemps> matriceDijkstra_atraiter) {
		int min = (int) Math.pow(2, 31);
		Station e = null;
		int tempsTmp = 0;

		Iterator<Entry<Station, CouplePereTemps>> it = matriceDijkstra_atraiter.entrySet().iterator();

		while (it.hasNext()) {
			Entry<Station, CouplePereTemps> element = it.next();
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
	 * @return
	 */
	private ArrayList<Station> retrouveChemin(Hashtable<Station, CouplePereTemps> matriceDijkstra,
			ArrayList<String> str) {
		ArrayList<Station> stationListRes = new ArrayList<Station>();
		System.out.println(matriceDijkstra.size());
		//afficheMatrice(matriceDijkstra);
		/* Station de Départ pour la remonter des stations */
		if (!matriceDijkstra.containsKey(stationArriver)) {
			stationListRes.add(stationDepart);
			stationListRes.add(stationArriver);
			JOptionPane.showMessageDialog(null, "Ouh! Ligne non connecté");
			return stationListRes;
		}
		CouplePereTemps couple;
		couple = matriceDijkstra.get(stationArriver);
		addToString(str,stationArriver);
		stationListRes.add(stationArriver);
		Station station = couple.getStation();
		while (station.getId() != stationDepart.getId()) {
			addToString(str,station);
			stationListRes.add(station);
			couple = matriceDijkstra.get(station);
			station = couple.getStation();
		}
		addToString(str,stationDepart);
		stationListRes.add(stationDepart);
		return stationListRes;
	}
	private void addToString(ArrayList<String> str,Station station) {
		try {
			str.add("☞" + "On passe par " + station.getGareNom() + " Ligne: " + station.getLigne() + "\n");
		} catch (Exception e) {

		}
	}
	private void afficheMatrice(Hashtable<Station, CouplePereTemps> matriceDijkstra) {
		Iterator<Entry<Station, CouplePereTemps>> it = matriceDijkstra.entrySet().iterator();

		while (it.hasNext()) {
			Entry<Station, CouplePereTemps> element = it.next();
			System.out.println(element.getKey());
		}
	}
}