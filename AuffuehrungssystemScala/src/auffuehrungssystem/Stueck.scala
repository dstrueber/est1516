package auffuehrungssystem

case class Stueck(name: String, handlung: String, typ: Stuecktyp.Value, premiereAm: java.util.Date) {

  var regisseur: Regisseur = null
  var darsteller: List[Darsteller] = List[Darsteller]()
  var vorstellungen: List[Vorstellung] = List[Vorstellung]()

  /**
   * Fuegt einen Darsteller der Liste der Beteiligten hinzu.
   *
   * @param darsteller
   */
  def addDarsteller(dars: Darsteller) {
    if (dars == null) throw new IllegalArgumentException("'darsteller' darf nicht null sein!")
    darsteller = dars :: darsteller
    dars.addStueck(this)
  }

  /**
   * Enfernt einen Darsteller aus der Liste der Beteiligten.
   *
   * @param darsteller
   */
  def removeDarsteller(dars: Darsteller) {
    if (dars == null) throw new IllegalArgumentException("'darsteller' darf nicht null sein!")
    darsteller = darsteller.filterNot(elm => elm == dars)
    dars.removeStueck(this)
  }

  /**
   * F�gt eine Vorstellung zu diesem Stueck hinzu.
   *
   * @param v
   */
  def addVorstellung(v: Vorstellung) {
    if (v == null) throw new IllegalArgumentException("Vorstellung 'v' darf nicht null sein!")
    vorstellungen = v :: vorstellungen
    v.setStueck(this)
  }

  /**
   * Entfernt eine Vorstellung zu diesem Stueck.
   * @param v
   */
  def removeVorstellung(v: Vorstellung) {
    if (v == null) throw new IllegalArgumentException("Vorstellung 'v' darf nicht null sein!")
    vorstellungen = vorstellungen.filterNot(elm => elm == v)
  }

  /**
   * Setzt den Regisseur dieses Stueckes neu, d.h. der vorherige gesetzte
   * Regisseur wird ausgetauscht gegen den gegebenen.
   *
   * @param regisseur
   */
  def setRegisseur(regisseur: Regisseur) {
    if (regisseur == null) throw new IllegalArgumentException("'regisseur' darf nicht null sein!")
    if (this.regisseur ne regisseur) {
      if (this.regisseur != null) this.regisseur.removeStueck(this)
      this.regisseur = regisseur
      regisseur.addStueck(this)
    }
  }

}
final object Stuecktyp extends Enumeration {
  val OPERETTE, THEATERSTUECK, FILM, SONSTIGES = Value
}