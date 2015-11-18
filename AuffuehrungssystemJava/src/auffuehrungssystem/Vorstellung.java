package auffuehrungssystem;
import java.util.ArrayList;
import java.util.Collection;

public class Vorstellung {

	private static final float PREIS_DEFAULT = 7.5f;
	private static final float AUFSCHLAG_DEFAULT = 1.0f;

	private String uhrzeit;
	private float preis;
	private float aufschlag;
	private Stueck stueck;
	private Auffuehrungsort ort;
	private Saal saal;
	private Collection<Reservierung> reservierungen;

	/**
	 * @param s
	 * @param ort
	 * @param uhrzeit
	 */
	Vorstellung(Stueck s, Auffuehrungsort ort, String uhrzeit, Saal saal) {
		this.preis = PREIS_DEFAULT;
		this.aufschlag = AUFSCHLAG_DEFAULT;
		this.uhrzeit = uhrzeit;
		this.ort = ort;
		this.ort.addVorstellung(this);
		this.stueck = s;
		this.stueck.addVorstellung(this);
		this.saal = saal;
		this.reservierungen = new ArrayList<Reservierung>();
	}// Vorstellung

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
		throw new UnsupportedOperationException("Funktion derzeit nicht implementiert.");
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
		this.preis = preis;
	}// setPreis

	/**
	 * Setzt die Gesamtanzahl der in dieser Vorstellung zur Verf�gung stehenden
	 * Sitze. Der vorherige Wert wird dabei �berschrieben.
	 * 
	 * @param sitzeGesamt
	 *            the sitzeGesamt to set
	 */
	public final void setSitzeGesamt(int sitzeGesamt) {
		throw new UnsupportedOperationException("Funktion derzeit nicht implementiert.");
	}// setSitzeGesamt

}// class
