
package kfzwerkstatt

class Werkstatt {
  var mitarbeiter: List[Any] = List[Any]()
  var kunden: List[Kunde] = List[Kunde]()


  def addMitarbeiterVerkaeufer(v: Verkaeufer) {
    mitarbeiter = v :: mitarbeiter 
  }

  def addMitarbeiterMechaniker(m: Mechaniker) {
    mitarbeiter = m :: mitarbeiter 
  }

  def addKunde(k: Kunde) {
    kunden = k :: kunden
  }

  def gibNettoEinnahmenAus {
    var summe: Int = 0
    import scala.collection.JavaConversions._
    for (o <- mitarbeiter) {
      if (o.isInstanceOf[Verkaeufer]) {
        summe += (((o.asInstanceOf[Verkaeufer]).sumVerkaeufe) * 0.81).asInstanceOf[Int]
      }
      else if (o.isInstanceOf[Mechaniker]) {
        summe += (((o.asInstanceOf[Mechaniker]).gibArbeitskostenZureuck) * 0.81).asInstanceOf[Int]
      }
    }
    System.out.println("Netto :" + summe)
  }

  def gibBruttoEinnahmenAus {
    var summe: Int = 0
    import scala.collection.JavaConversions._
    for (o <- mitarbeiter) {
      if (o.isInstanceOf[Verkaeufer]) {
        summe += ((o.asInstanceOf[Verkaeufer]).sumVerkaeufe).asInstanceOf[Int]
      }
      else if (o.isInstanceOf[Mechaniker]) {
        summe += ((o.asInstanceOf[Mechaniker]).gibArbeitskostenZureuck)
      }
    }
    System.out.println("Brutto :" + summe)
  }

  def gibKundenbetraegeAus {
    System.out.println("Kundenbetraege ")
    import scala.collection.JavaConversions._
    for (o <- kunden) {
      val k: Kunde = o.asInstanceOf[Kunde]
      System.out.println(k.vorname + " " + k.name + " : " + k.bezahlt)
    }
  }
}
