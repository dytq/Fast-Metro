package fastmetro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
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
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return gareList;
	}

	public void initGare(String chemin) {

	}

}
