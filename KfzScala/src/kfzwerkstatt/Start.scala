package kfzwerkstatt

object Start {
  /**
    * @param args
    */
  def main(args: Array[String]) {
    val w: Werkstatt = new Werkstatt
    val v1: Verkaeufer = new Verkaeufer("Lustig", "Peter", "458DD34")
    val m1: Mechaniker = new Mechaniker("Hans", "Obermaier", "45878SQW")
    val k1: Kunde = new Kunde("12345", "Schroeder", "Gerhard")
    val k2: Kunde = new Kunde("5678", "Koch", "Roland")
    w.addMitarbeiterMechaniker(m1)
    w.addMitarbeiterVerkaeufer(v1)
    w.addKunde(k1)
    w.addKunde(k2)
    v1.verkaufeDienstleitung(k1, Verkaeufer.Prioritaet.DRINGEND, "Alles kaputt an der Karre", m1)
    v1.verkaufeDienstleitung(k2, Verkaeufer.Prioritaet.NORMAL, "Reifen wechseln", m1)
    w.gibBruttoEinnahmenAus
    w.gibNettoEinnahmenAus
    w.gibKundenbetraegeAus
  }
}

