package auffuehrungssystem;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Auffuehrungsort {
	private Adresse adresse;
	private Collection<Vorstellung> vorstellungen;
	private String name;
	private Collection<Saal> saele;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param adr
	 */
	public Auffuehrungsort(String name, Adresse adr) {
		this.name = name;
		this.adresse = adr;
		vorstellungen = new HashSet<Vorstellung>();
		saele = new HashSet<Saal>();
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
	 * Erstellt anhand der �bergebenen Argumente ein Vorstellungsobjekt und
	 * verlinkt es entsprechend.
	 * 
	 * @param stueck
	 * @param uhrzeit
	 * @return
	 */
	public Vorstellung createVorstellung(Stueck stueck, String uhrzeit, Saal saal) {
		Vorstellung v = new Vorstellung(stueck, this, uhrzeit, saal);
		this.addVorstellung(v);
		return v;
	}// createVorstellung

	/**
	 * Erstellt anhand der �bergebenen Argumente ein Saalobjekt und
	 * verlinkt es entsprechend.
	 * 
	 * @param bezeichnung
	 * @param sonstiges
	 * @return
	 */
	public Saal createSaal(String bezeichnung, String sonstiges, int reihen, int spalten, int logenReihen) {
		Saal saal = new Saal(bezeichnung, sonstiges, reihen, spalten, logenReihen);
		this.addSaal(saal);
		return saal;
	}// createSaal

	

	/**
	 * @return
	 */
	public Adresse getAdresse() {
		return adresse;
	}// getAnschrift

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}// getName

	/**
	 * Liefert eine (read-only) Liste der zugeh�rigen Vorstellungen zur�ck.
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
	 * Entfernt eine Vorstellung zu diesem Auff�hrungsort.<br>
	 * <i>Achtung: Die Synchronisierung von Vorstellung erfolgt hier nicht, da
	 * ansonsten ein inkonsistenter Zustand entstehen kann! Diese Methode ist
	 * nur f�r den Aufruf durch die Klasse {@link Vorstellung} vorgesehen.</i>
	 * 
	 * @param v
	 */
	void removeVorstellung(Vorstellung v) {
		if (v == null)
			throw new IllegalArgumentException(
					"Vorstellung 'v' darf nicht null sein!");
		vorstellungen.remove(v);
	}// removeVorstellung

	/**
	 * @param s
	 */
	public void addSaal(Saal s) {
		if (s == null)
			throw new IllegalArgumentException(
					"Saal 's' darf nicht null sein!");
		saele.add(s);
	}// addSaal

	void removeSaal(Saal s) {
		if (s == null)
			throw new IllegalArgumentException(
					"Saal 's' darf nicht null sein!");
		saele.remove(s);
	}// removeSaal

}// class
