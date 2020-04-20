package fastmetro;

public class CouplePereTemps {
	private Station station;
	private int temps;

	CouplePereTemps(Station station, int temps) {
		this.setStation(station);
		this.setTemps(temps);
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
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
		return "Station: " + station.getId() + " Temps: " + this.temps;
	}

}
