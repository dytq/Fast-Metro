package fastmetro;

import java.awt.List;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.System;

public class Ecriture {

	private String chemin;
	private Scanner prompt = new Scanner(System.in);
	private static ArrayList<Station> stationList = new ArrayList<Station>();

	public Ecriture(String chemin_d_ecriture) {
		this.chemin = chemin_d_ecriture;
		
	}

	public void scanPrompt(Point point) throws IOException {

		System.out.println("Voulez-vous enregistrer les stations entrées[y/n]");
		String ecrire = prompt.nextLine();

		switch (ecrire) {
		case "y":
			ecrireFichierStation();
			break;
		default:
			System.out.println("Entrer le numéro d'identifiant ");
			String numID = prompt.nextLine();

			System.out.println("Entrer le nom de la station");
			String nomStation = prompt.nextLine();

			System.out.println("Entrer le numéro de la ligne");
			String numLigne = prompt.nextLine();

			ajoutStationToList(point, numID, nomStation, numLigne);
			System.out.println("Station ajouté:Attendre clic");
		}
	}

	private void ajoutStationToList(Point point, String numID, String nomStation, String numLigne) {
		int id = Integer.parseInt(numID);
		int ligne = Integer.parseInt(numLigne);
		Station station = new Station(id, nomStation, ligne, point);
		stationList.add(station);
		System.out.println(station.toString());
	}

	private void ecrireFichierStation() throws IOException {
		try {
			Writer writer = new FileWriter(chemin);
			GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
			Gson gson = builder.create();
			gson.toJson(stationList, writer);

			writer.close();
			System.out.println("Station enregistré dans " + chemin);
			System.out.println("Fin du programme");
			System.exit(0);
		} catch (ExportException e) {
			e.printStackTrace();
		}
	}

	public void ecrireFichierGraphe(int numID1, int numID2, int temps) {
		/* ecrire json */
	}
}
