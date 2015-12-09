package auffuehrungssystem;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Auffuehrungsort {
	private Adresse anschrift;
	private Collection<Vorstellung> vorstellungen;
	private String name;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param adr
	 */
	public Auffuehrungsort(String name, Adresse adr) {
		this.name = name;
		this.anschrift = adr;
		vorstellungen = new HashSet<Vorstellung>();
	}// Auffuehrungsort

	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param strasse
	 * @param ort
	 * @param plz
	 */
	public Auffuehrungsort(String name, String strasse, String ort, int plz) {
		this(name, new Adresse(strasse, ort, plz));
	}// Auffuehrungsort

	/**
	 * Consolenausgabe aller Einnahmen dieses Auffuehrungsortes
	 */
	public void ausgabeDerEinnahmen() {
		// TODO Zu implementieren
		System.out.println("Gesamteinnahmen: 0");
	}// ausgabeDerEinnahmen

	/**
	 * Erstellt anhand der übergebenen Argumente ein Vorstellungsobjekt und
	 * verlinkt es entsprechend.
	 * 
	 * @param stuecktyp
	 * @param preis
	 * @param sitze
	 * @param film
	 * @return
	 */
	public Vorstellung createVorstellung(Stueck s, String uhrzeit) {
		Vorstellung v = new Vorstellung(s, this, uhrzeit);
		this.addVorstellung(v);
		return v;
	}// createVorstellung

	/**
	 * @return
	 */
	public Adresse getAnschrift() {
		return anschrift;
	}// getAnschrift

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}// getName

	/**
	 * Liefert eine (read-only) Liste der zugehörigen Vorstellungen zurück.
	 * 
	 * @return
	 */
	public Collection<Vorstellung> getVorstellungen() {
		return Collections.unmodifiableCollection(vorstellungen);
	}// getVorstellungen

	/**
	 * Gibt alle Vorstellungen an diesem Auffuehrungsort auf der Console aus.
	 */
	public void printVorstellungen() {
		for (Vorstellung v : vorstellungen) {
			System.out.println(v);
		}// for
	}// printVorstellungen

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "** Auffuehrungsort " + this.name + " **";
	}// toString

	/**
	 * @param v
	 */
	public void addVorstellung(Vorstellung v) {
		if (v == null)
			throw new IllegalArgumentException(
					"Vorstellung 'v' darf nicht null sein!");
		if (vorstellungen.add(v))
			v.setOrt(this);
	}// addVorstellung

	/**
	 * Entfernt eine Vorstellung zu diesem Aufführungsort.<br>
	 * <i>Achtung: Die Synchronisierung von Vorstellung erfolgt hier nicht, da
	 * ansonsten ein inkonsistenter Zustand entstehen kann! Diese Methode ist
	 * nur für den Aufruf durch die Klasse {@link Vorstellung} vorgesehen.</i>
	 * 
	 * @param v
	 */
	void removeVorstellung(Vorstellung v) {
		if (v == null)
			throw new IllegalArgumentException(
					"Vorstellung 'v' darf nicht null sein!");
		vorstellungen.remove(v);
	}// removeVorstellung

}// class
