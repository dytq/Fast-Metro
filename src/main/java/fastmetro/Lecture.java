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
 * @author user
 *
 */
public class Lecture {

	public Lecture() {

	}
	
	/**
	 * Permet lire une Gare 
	 * @param chemin
	 * @param gareList
	 * @return
	 */
	public ArrayList<Gare> initStation(String chemin,ArrayList<Gare> gareList) {
		Reader reader;
		
		try {
			reader = new FileReader(chemin);
			Type type = new TypeToken<ArrayList<Gare>>(){}.getType();
			gareList = new Gson().fromJson(reader, type);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return gareList;
	}
	
	public void initGare(String chemin) {
		
	}
	
}
