package auffuehrungssystem;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

public class Stueck {
	private String name;
	private Date premiereAm;
	private String handlung;
	private Stuecktyp typ;
	private Regisseur regisseur;
	private Collection<Darsteller> darsteller;
	private Collection<Vorstellung> vorstellungen;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param typ
	 * @param r
	 */
	public Stueck(String name, Stuecktyp typ, Regisseur r) {
		if (r == null)
			throw new IllegalArgumentException(
					"Regisseur 'r' darf nicht null sein!");

		this.name = name;
		this.darsteller = new HashSet<Darsteller>();
		this.vorstellungen = new HashSet<Vorstellung>();
		this.setRegisseur(r);
	}// Stueck

	/**
	 * Fügt einen Darsteller der Liste der Beteiligten hinzu.
	 * 
	 * @param darsteller
	 */
	public void addDarsteller(Darsteller darsteller) {
		if (darsteller == null)
			throw new IllegalArgumentException(
					"'darsteller' darf nicht null sein!");
		if (this.darsteller.add(darsteller))
			darsteller.addStueck(this);
	}// addDarsteller

	/**
	 * Enfernt einen Darsteller aus der Liste der Beteiligten.
	 * 
	 * @param darsteller
	 */
	public void removeDarsteller(Darsteller darsteller) {
		if (darsteller == null)
			throw new IllegalArgumentException(
					"'darsteller' darf nicht null sein!");
		if (this.darsteller.remove(darsteller))
			darsteller.removeStueck(this);
	}// removeDarsteller

	/**
	 * Liefert eine (read-only) Liste der beteiligten Darsteller zurück.
	 * 
	 * @return
	 */
	public Collection<Darsteller> getDarsteller() {
		return Collections.unmodifiableCollection(darsteller);
	}// getDarsteller

	/**
	 * @return
	 */
	public Date getPremiereAm() {
		return premiereAm;
	}// getPremiereAm

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}// getName

	/**
	 * @return
	 */
	public Regisseur getRegisseur() {
		return regisseur;
	}// getRegisseur

	/**
	 * Liefert eine (read-only) Liste der zugehörigen Vorstellungen zurück.
	 * 
	 * @return
	 */
	public Collection<Vorstellung> getVorstellungen() {
		return Collections.unmodifiableCollection(vorstellungen);
	}// getVorstellungen

	/**
	 * Fügt eine Vorstellung zu diesem Stück hinzu.
	 * 
	 * @param v
	 */
	public void addVorstellung(Vorstellung v) {
		if (v == null)
			throw new IllegalArgumentException(
					"Vorstellung 'v' darf nicht null sein!");
		if (vorstellungen.add(v))
			v.setStueck(this);
	}// addVorstellung

	/**
	 * Entfernt eine Vorstellung zu diesem Stück.<br>
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

	/**
	 * Setzt den Regisseur dieses Stueckes neu, d.h. der vorherige gesetzte
	 * Regisseur wird ausgetauscht gegen den gegebenen.
	 * 
	 * @param regisseur
	 */
	public void setRegisseur(Regisseur regisseur) {
		if (regisseur == null)
			throw new IllegalArgumentException(
					"'regisseur' darf nicht null sein!");
		if (this.regisseur != regisseur) {
			if (this.regisseur != null)
				this.regisseur.removeStueck(this);

			this.regisseur = regisseur;
			regisseur.addStueck(this);
		}// if
	}// setRegisseur

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stueck \"" + this.getName() + "\" von " + this.regisseur;
	}// toString

	/**
	 * @return the handlung
	 */
	public final String getHandlung() {
		return handlung;
	}// getHandlung

	/**
	 * @param handlung
	 *            the handlung to set
	 */
	public final void setHandlung(String handlung) {
		this.handlung = handlung;
	}// setHandlung

	/**
	 * @return the typ
	 */
	public final Stuecktyp getTyp() {
		return typ;
	}// getTyp

}// class
