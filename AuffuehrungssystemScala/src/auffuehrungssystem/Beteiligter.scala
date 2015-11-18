package auffuehrungssystem

trait Beteiligter {
  var stuecke = List[Stueck]()
}

case class Darsteller(vorname: String, nachname: String) extends Beteiligter {
  def addStueck(stueck: Stueck) {
    if (stueck == null) throw new IllegalArgumentException("'stueck' darf nicht null sein!")
    stuecke = stueck :: stuecke
    if (!stueck.darsteller.contains(this))
      stueck.addDarsteller(this)
  }
  
  def removeStueck(stueck: Stueck) {
    if (stueck == null) throw new IllegalArgumentException("'stueck' darf nicht null sein!")
    stuecke = stuecke.filterNot(elm => elm == stueck)
    if (stueck.darsteller.contains(this))
      stueck.removeDarsteller(this)
  }
}

case class Regisseur(vorname: String, nachname: String) extends Beteiligter {

    def ausgabeAllerStuecke {
    println("Stuecke: ")
    for (stueck <- stuecke) {
      println(stueck.name + " " + stueck.premiereAm)
    }
  }
  
  def addStueck(stueck: Stueck) {
    if (stueck == null) throw new IllegalArgumentException("'stueck' darf nicht null sein!")
    stuecke = stueck :: stuecke
    if (stueck.regisseur != this)
      stueck.setRegisseur(this)
  }
  
  def removeStueck(stueck: Stueck) {
    if (stueck == null) throw new IllegalArgumentException("'stueck' darf nicht null sein!")
    stuecke = stuecke.filterNot(elm => elm == stueck)
  }
}