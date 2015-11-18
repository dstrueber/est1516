package auffuerhungssystem.main;

import auffuehrungssystem.Auffuehrungsort;
import auffuehrungssystem.Darsteller;
import auffuehrungssystem.Regisseur;
import auffuehrungssystem.Saal;
import auffuehrungssystem.Stueck;
import auffuehrungssystem.Stuecktyp;
import auffuehrungssystem.Vorstellung;

public class Main {
	public static void main(String[] args) {

		Auffuehrungsort auffuehrungsort = new Auffuehrungsort("Gloria", "Bahnhofstra�e 22", "Marburg", 35037);
		Saal centerSaal = auffuehrungsort.createSaal("Center-Saal", "", 30, 20, 10);

		Darsteller d1 = new Darsteller("Schnabel", "Adolf");
		Darsteller d2 = new Darsteller("Schreinemarkers", "Margot");
		Darsteller d3 = new Darsteller("Fischer", "Ottfried");
		Darsteller d4 = new Darsteller("Parker", "Peter");
		Regisseur r1 = new Regisseur("Benoshie", "Hoshie");

		Stueck stueck1 = new Stueck("Hulk XIV", Stuecktyp.FILM, r1);
		stueck1.addDarsteller(d1);
		stueck1.addDarsteller(d2);

		Stueck stueck2 = new Stueck("Spider Pig", Stuecktyp.OPERETTE, r1);
		stueck2.addDarsteller(d4);
		stueck2.addDarsteller(d3);
		stueck2.addDarsteller(d2);
		stueck2.setRegisseur(r1);

		Vorstellung v1 = auffuehrungsort.createVorstellung(stueck1, "18Uhr", centerSaal);
		Vorstellung v2 = auffuehrungsort.createVorstellung(stueck2, "20Uhr", centerSaal);

		System.out.println(auffuehrungsort);
		System.out.println(v1.getStueck() + "\nEinnahmen: " + v1.liefereEinnahmen());
		System.out.println(v2.getStueck() + "\nEinnahmen: " + v2.liefereEinnahmen());
		auffuehrungsort.ausgabeDerEinnahmen();
	}
}
