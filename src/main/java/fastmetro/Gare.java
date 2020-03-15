package fastmetro;

import java.awt.Point;
import java.util.ArrayList;

public class Gare {
	private String nom;
	private Point point;
	private ArrayList<Station> stationGare = new ArrayList<Station>();
	
	Gare(String nom,Point point) {
		this.nom = nom;
		this.point = point;
	}
	public void addStation(Station station) {
		stationGare.add(station);
	}
}
