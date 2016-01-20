package kfzwerkstatt;

import java.util.GregorianCalendar;

public class Verkaeufer {

	public enum Prioritaet {
		DRINGEND, WICHTIG, NORMAL;
	}

	private int lohnProZeiteinheit = 3;

	private final String vName;
	private final String vVorname;
	private final String vId;

	public float sumVerkaeufe;

	public Verkaeufer(String name, String vorname, String id) {
		this.vId = id;
		this.vName = name;
		this.vVorname = vorname;
	}

	public void verkaufeDienstleitung(Kunde kunde, Prioritaet prio,
			String fehlerbeschreibung, Mechaniker m) {

		long startzeit = GregorianCalendar.getInstance().getTimeInMillis();
		synchronized (this) {
			try {
				// Hier wird das Arbeiten simuliert
				this.wait((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}

		long endzeit = GregorianCalendar.getInstance().getTimeInMillis();
		int dauer = (int) (endzeit - startzeit);

		// Der Verkäufer berechnet auch Kosten für seine Dienstleistung :-D
		// ...quasi Trinkgeld :-D
		int lohn = dauer * lohnProZeiteinheit;
		sumVerkaeufe += lohn;
		kunde.addBezahlt(lohn);

		m.bearbeiteJob(kunde, prio, fehlerbeschreibung);

	}

	public String getVName() {
		return vName;
	}

	public String getVVorname() {
		return vVorname;
	}

	public String getVId() {
		return vId;
	}

	/**
	 * @return the lohnProZeiteinheit
	 */
	public int getLohnProZeiteinheit() {
		return lohnProZeiteinheit;
	}

	/**
	 * @param lohnProZeiteinheit
	 *            the lohnProZeiteinheit to set
	 */
	public void setLohnProZeiteinheit(int lohnProZeiteinheit) {
		this.lohnProZeiteinheit = lohnProZeiteinheit;
	}

}
