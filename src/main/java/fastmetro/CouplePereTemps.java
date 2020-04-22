package fastmetro;

/**
 * Permet d'avoir un couple de pere/temps pour dijkstra (voir rapport pour plus de detail)
 * @author dedarally taariq
 *
 */
public class CouplePereTemps {
	
	/* Id de la station */
	private int station;
	/* Temps */
	private int temps;

	/**
	 * Initialise une couple de pere/temps (le temps initiale)
	 * @param station
	 * @param temps
	 */
	CouplePereTemps(int station, int temps) {
		this.setStation(station);
		this.setTemps(temps);
	}

	/**
	 * Récupère id station père
	 * @return id station
	 */
	public int getStation() {
		return station;
	}

	/**
	 * Initialise id station
	 * @param station id station
	 * 	 */
	public void setStation(int station) {
		this.station = station;
	}

	/**
	 * Récupère le temps
	 * @return le temps
	 */
	public int getTemps() {
		return temps;
	}

	/**
	 * initialise le temps
	 * @param temps à initialiser
	 */
	public void setTemps(int temps) {
		this.temps = temps;
	}

	@Override
	public String toString() {
		return "Station: " + station + " Temps: " + this.temps;
	}

}