package fastmetro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Lecture {

	//private static ArrayList gareList = new ArrayList<Gare>();

	public Lecture() {

	}

	public void initStation(String chemin) {
		Reader reader;
		try {
			reader = new FileReader(chemin);
			Type type = new TypeToken<ArrayList<Gare>>(){}.getType();
			ArrayList<Gare> list = new Gson().fromJson(reader, type);
			System.out.println(list.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initGare(String chemin) {
		
	}
	
}
