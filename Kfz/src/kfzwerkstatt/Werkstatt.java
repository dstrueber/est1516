package kfzwerkstatt;

import java.util.ArrayList;
import java.util.List;

public class Werkstatt {

	private List mitarbeiter;
	private List kunden;

	public Werkstatt() {
		mitarbeiter = new ArrayList();
		kunden = new ArrayList();
	}

	public void addMitarbeiterVerkaeufer(Verkaeufer v) {
		mitarbeiter.add(v);
	}

	public void addMitarbeiterMechaniker(Mechaniker m) {
		mitarbeiter.add(m);
	}

	public void addKunde(Kunde k) {
		kunden.add(k);
	}

	public void gibNettoEinnahmenAus() {
		int summe = 0;

		for (Object o : mitarbeiter) {
			if (o instanceof Verkaeufer) {
				summe += (((Verkaeufer) o).sumVerkaeufe) * 0.81; // 19% Mwst
				// abgezogen
			} else if (o instanceof Mechaniker) {
				summe += (((Mechaniker) o).gibArbeitskostenZureuck()) * 0.81;
			}
		}// for

		System.out.println("Netto :" + summe);
	}

	public void gibBruttoEinnahmenAus() {
		int summe = 0;

		for (Object o : mitarbeiter) {
			if (o instanceof Verkaeufer) {
				summe += (((Verkaeufer) o).sumVerkaeufe);
			} else if (o instanceof Mechaniker) {
				summe += (((Mechaniker) o).gibArbeitskostenZureuck());
			}
		}// for
		System.out.println("Brutto :" + summe);
	}

	public void gibKundenbetraegeAus() {
		System.out.println("Kundenbetraege ");
		for (Object o : kunden) {
			Kunde k = (Kunde) o;
			System.out.println(k.getVorname() + " " + k.getName() + " : " + k.getBezahlt()); 
		}
	}
}
