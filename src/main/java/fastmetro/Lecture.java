package fastmetro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Lecture d'un fichier Json
 * 
 * @author dedarally taariq
 *
 */
public class Lecture {

	/**
	 * Permet lire une Gare
	 * 
	 * @param chemin   d'accés disque
	 * @param gareList on ne peut pas initialiser l'objet gare dans lecture.
	 * @return la liste des gares lu dans le fichier
	 */
	public ArrayList<Gare> initStation(String chemin, ArrayList<Gare> gareList) {
		Reader reader;

		try {
			reader = new FileReader(chemin);
			Type type = new TypeToken<ArrayList<Gare>>() {
			}.getType();
			gareList = new Gson().fromJson(reader, type);
			int i = 0;
			for (Gare gare : gareList) {
				gare.setGareId(i);
				for (Station station : gare.getStationGare()) {
					station.setGareId(gare.getGareId());
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return gareList;
	}

	/**
	 * Le parisGraphe.json à deux id gares (parce que lol). J'ai pas compris le
	 * graphe: Ce sont les stations qui sont connectés entre eux pas les gares ????
	 * 
	 * @param chemin
	 * @param stationList
	 * @param gareList
	 */
	public ArrayList<Station> initGraphe(String chemin, ArrayList<Station> stationList, ArrayList<Gare> gareList) {
		Reader reader;
		try {
			reader = new FileReader(chemin);
			final GsonBuilder builder = new GsonBuilder();
			final Gson gson = builder.create();
			final int[][] valeurs = gson.fromJson(reader, int[][].class);

			initStationsLigne(gareList, stationList, valeurs);

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		}
		return stationList;
	}

	/**
	 * Initialistation station par station, sinon c'est impossible autrement
	 * 
	 * @param gareList
	 * @param stationList
	 * @param valeurs
	 * @return
	 */
	private ArrayList<Station> initStationsLigne(ArrayList<Gare> gareList, ArrayList<Station> stationList,
			int[][] valeurs) {
		ArrayList<Station> stationLigne = new ArrayList<Station>();
		for (int i = 0; i == 14; i++) {
			stationLigne = getStationsLigne(gareList, i);
			initVoisinStation(stationList, stationLigne, valeurs);
		}
		stationLigne = getStationsLigne(gareList, 77);
		initVoisinStation(stationList, stationLigne, valeurs);
		stationLigne = getStationsLigne(gareList, 33);
		initVoisinStation(stationList, stationLigne, valeurs);
		return stationList;
	}

	/**
	 * Initialise les voisins stations
	 * 
	 * @param stationList
	 * @param stationLigne
	 * @param valeurs
	 * @return
	 */
	private ArrayList<Station> initVoisinStation(ArrayList<Station> stationList, ArrayList<Station> stationLigne,
			int[][] valeurs) {
		for (int i = 0; i < valeurs.length; i++) {
			
		}
		return stationList;
	}

	/**
	 * Crée la liste des stations
	 * 
	 * @param gareList
	 * @param ligne
	 * @return
	 */
	private ArrayList<Station> getStationsLigne(ArrayList<Gare> gareList, int ligne) {
		ArrayList<Station> stationLigne = new ArrayList<Station>();
		for (Gare gare : gareList) {
			for (Station station : gare.getStationGare()) {
				if (station.getLigne() == ligne) {
					stationLigne.add(station);
				}
			}
		}
		return stationLigne;
	}
}
