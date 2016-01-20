package kfzwerkstatt;

import java.util.GregorianCalendar;

import kfzwerkstatt.Verkaeufer.Prioritaet;

public class Mechaniker {

	private final String mName;
	private final String mVorname;
	private final String mId;

	public int sumArbeit;

	private int lohnProZeiteinheit = 15;

	public Mechaniker(String vorname, String name, String id) {
		mId = id;
		mName = name;
		mVorname = vorname;
	}

	public void bearbeiteJob(Kunde kunde, Prioritaet prio,
			String fehlerbeschreibung) {

		System.out.println("Beginne mit Arbeit!");
		long startzeit = GregorianCalendar.getInstance().getTimeInMillis();

		// je nach Prio wird die Arbeit potentiell schneller erleidgt :-D
		int basisZeit = 100;
		if (prio == Verkaeufer.Prioritaet.DRINGEND)
			basisZeit = 50;
		else if (prio == Verkaeufer.Prioritaet.WICHTIG)
			basisZeit = 80;
		else if (prio == Verkaeufer.Prioritaet.NORMAL)
			basisZeit = 100;

		synchronized (this) {
			try {
				// Hier wird das Arbeiten simuliert
				wait((int) (Math.random() * basisZeit));
			} catch (InterruptedException e) {
			}
		}

		long endzeit = GregorianCalendar.getInstance().getTimeInMillis();

		int dauer = (int) (endzeit - startzeit);
		System.out.println("Arbeit beendet! Dauer " + dauer);
		// Millisekunden werden hier exemplarisch als Minuten gezählt

		// je nach Prio wird ein Aufschlag erhoben pro Zeiteinheit
		int kostensatz = lohnProZeiteinheit;
		if (prio == Verkaeufer.Prioritaet.DRINGEND)
			kostensatz += 10;
		else if (prio == Verkaeufer.Prioritaet.WICHTIG)
			basisZeit += 50;

		int lohn = dauer * kostensatz;
		sumArbeit += lohn;
		kunde.addBezahlt(lohn);
	}

	public int gibArbeitskostenZureuck() {
		return sumArbeit;
	}

	public String getMName() {
		return mName;
	}

	public String getMVorname() {
		return mVorname;
	}

	public String getMId() {
		return mId;
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
