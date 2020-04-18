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
	 * Le parisGraphe.json à deux id stations
	 * 
	 * @param chemin
	 * @param stationList
	 * @param gareList
	 */
	public ArrayList<Station> initGraphe(String chemin, ArrayList<Station> stationList) {
		Reader reader;
		try {
			reader = new FileReader(chemin);
			final GsonBuilder builder = new GsonBuilder();
			final Gson gson = builder.create();
			final int[][] valeurs = gson.fromJson(reader, int[][].class);
			for (int i = 0; i < stationList.size(); i++) {
				stationList.set(i, initGrapheValeurs(stationList, valeurs, i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return stationList;
	}

	/**
	 * Initialise une valeur pour la station list
	 * 
	 * @param gareList
	 * @param stationList
	 * @param valeurs
	 * @return
	 */
	private Station initGrapheValeurs(ArrayList<Station> stationList, int[][] valeurs, int id) {
		Station station = new Station(stationList.get(id));
		for (int i = 0; i < valeurs.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (valeurs[i][j] == id) {
					station.addCoupleVoisin(stationList.get(valeurs[i][j ^ 1]), valeurs[i][2]);
				}
			}
		}
		return station;
	}
}
