package kfzwerkstatt;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Werkstatt w = new Werkstatt();
		
		Verkaeufer v1 = new Verkaeufer("Lustig", "Peter", "458DD34");
		Mechaniker m1 = new Mechaniker("Hans", "Obermaier", "45878SQW");
		Kunde k1 = new Kunde("12345", "Schroeder", "Gerhard");
		Kunde k2 = new Kunde("5678", "Koch", "Roland");

		w.addMitarbeiterMechaniker(m1);
		w.addMitarbeiterVerkaeufer(v1);
		w.addKunde(k1);
		w.addKunde(k2);
		
		v1.verkaufeDienstleitung(k1, Verkaeufer.Prioritaet.DRINGEND, "Alles kaputt an der Karre", m1);
		v1.verkaufeDienstleitung(k2, Verkaeufer.Prioritaet.NORMAL, "Reifen wechseln", m1);
		
		w.gibBruttoEinnahmenAus();
		w.gibNettoEinnahmenAus();
		w.gibKundenbetraegeAus();
		
	}

}
