package fastmetro;

public class CouplePereTemps {
	private int station;
	private int temps;

	CouplePereTemps(int station, int temps) {
		this.setStation(station);
		this.setTemps(temps);
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	@Override
	public String toString() {
		return "Station: " + station + " Temps: " + this.temps;
	}

}
