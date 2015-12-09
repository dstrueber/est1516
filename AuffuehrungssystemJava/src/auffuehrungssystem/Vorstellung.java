package auffuehrungssystem;

public class Vorstellung {

	public static final String EXC_MSG_PLAETZE_BEREITS_GEBUCHT = "Preis wurde nicht gesetzt, da bereis Plätze gebucht wurden.";

	public static final String EXC_MSG_PLATZANZAHL_UNTER_GEBUCHT = "Die Platzanzahl kann nicht unter die bereits gebuchte Platzanzahl gesenkt werden.";

	public static final String EXC_MSG_MINDESTENS_EIN_PLATZ = "Parameter 'sitzeGesamt' hat illegalen Wert. Es muss mindestens ein Platz zur Verfügung stehen.";

	private static final float PREIS_DEFAULT = 7.5f;
	private static final int SITZE_GESAMT_DEFAULT = 200;
	private static final int SITZE_BELEGT_DEFAULT = 0;

	private String uhrzeit;
	private float preis;
	private int sitzeGesamt, sitzeBelegt;
	private Stueck stueck;
	private Auffuehrungsort ort;

	/**
	 * @param s
	 * @param ort
	 * @param uhrzeit
	 */
	Vorstellung(Stueck s, Auffuehrungsort ort, String uhrzeit) {
		this.preis = PREIS_DEFAULT;
		sitzeGesamt = SITZE_GESAMT_DEFAULT;
		sitzeBelegt = SITZE_BELEGT_DEFAULT;
		this.uhrzeit = uhrzeit;
		this.ort = ort;
		this.ort.addVorstellung(this);
		this.stueck = s;
		this.stueck.addVorstellung(this);
	}// Vorstellung

	/**
	 * @param anzahl
	 * @return true, falls die geforderten Sitze belegt werden konnten, sonst
	 *         false
	 */
	public boolean belegeSitze(int anzahl) {
		// TODO Zu implementieren
		return false;
	}// belegeSitze

	/**
	 * @return
	 */
	public float liefereEinnahmen() {
		// TODO Zu implementieren
		return -1;
	}// liefereEinnahmen

	/**
	 * @return
	 */
	public Stueck getStueck() {
		return stueck;
	}// getStueck

	/**
	 * @return
	 */
	public int getFreieSitze() {
		return this.sitzeGesamt - this.sitzeBelegt;
	}// getFreieSitze

	/**
	 * @return
	 */
	public Auffuehrungsort getOrt() {
		return ort;
	}// getOrt

	/**
	 * @return
	 */
	public float getPreis() {
		return preis;
	}// getPreis

	/**
	 * @return
	 */
	public String getUhrzeit() {
		return uhrzeit;
	}// getUhrzeit

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = "";
		str += uhrzeit;
		str += " " + stueck;
		str += " Preis: " + preis;
		return str;
	}// toString

	/**
	 * Setzt das Stueck dieser Vorstellung neu, d.h. das vorherige gesetzte
	 * Stueck wird ausgetauscht gegen das gegebene Stueck.
	 * 
	 * @param stueck
	 */
	public void setStueck(Stueck stueck) {
		if (stueck == null)
			throw new IllegalArgumentException("'stueck' darf nicht null sein!");
		if (this.stueck != stueck) {
			if (this.stueck != null)
				this.stueck.removeVorstellung(this);

			this.stueck = stueck;
			stueck.addVorstellung(this);
		}// if
	}// setStueck

	/**
	 * Setzt das Stueck dieser Vorstellung neu, d.h. das vorherige gesetzte
	 * Stueck wird ausgetauscht gegen das gegebene Stueck.
	 * 
	 * @param ort
	 */
	public void setOrt(Auffuehrungsort ort) {
		if (ort == null)
			throw new IllegalArgumentException("'ort' darf nicht null sein!");
		if (this.ort != ort) {
			if (this.ort != null)
				this.ort.removeVorstellung(this);

			this.ort = ort;
			ort.addVorstellung(this);
		}// if
	}// setStueck

	/**
	 * @param preis
	 *            the preis to set
	 */
	public final void setPreis(float preis) {
		if (this.sitzeBelegt > 0)
			System.err.println(EXC_MSG_PLAETZE_BEREITS_GEBUCHT);
		this.preis = preis;
	}// setPreis

	/**
	 * Setzt die Gesamtanzahl der in dieser Vorstellung zur Verfügung stehenden
	 * Sitze. Der vorherige Wert wird dabei überschrieben.
	 * 
	 * @param sitzeGesamt
	 *            the sitzeGesamt to set
	 */
	public final void setSitzeGesamt(int sitzeGesamt) {
		// TODO Zu implementieren
	}// setSitzeGesamt

}// class
