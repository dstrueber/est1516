
package auffuehrungssystem

class Vorstellung(var stueck: Stueck, var ort: Auffuehrungsort,
    var uhrzeit: String, var saal: Saal, var preis: Float = Vorstellung.PREIS_DEFAULT, var aufschlag: Float = Vorstellung.AUFSCHLAG_DEFAULT) {

  private var reservierungen: List[Reservierung] = List[Reservierung]()

  /**
   * @return
   */
  def getFreieSitze: Int = {
    throw new UnsupportedOperationException("Funktion derzeit nicht implementiert.")
  }

  /**
   * Setzt das Stueck dieser Vorstellung neu, d.h. das vorherige gesetzte
   * Stueck wird ausgetauscht gegen das gegebene Stueck.
   *
   * @param stueck
   */
  def setStueck(stueck: Stueck) {
    if (stueck == null) throw new IllegalArgumentException("'stueck' darf nicht null sein!")
    if (this.stueck != stueck) {
      if (this.stueck != null) this.stueck.removeVorstellung(this)
      this.stueck = stueck
      stueck.addVorstellung(this)
    }
  }

  /**
   * Setzt das Stueck dieser Vorstellung neu, d.h. das vorherige gesetzte
   * Stueck wird ausgetauscht gegen das gegebene Stueck.
   *
   * @param ort
   */
  def setOrt(ort: Auffuehrungsort) {
    if (ort == null) throw new IllegalArgumentException("'ort' darf nicht null sein!")
    if (this.ort ne ort) {
      if (this.ort != null) this.ort.removeVorstellung(this)
      this.ort = ort
      ort.addVorstellung(this)
    }
  }
  
  def liefereEinnahmen(): Float = {
    var result = 0.0F
    for (r <- reservierungen) {
      for (p <- r.plaetze) {
        result += preis
        if (p.isLoge)
          result += aufschlag
      }
    }
    result
  }

}
object Vorstellung {
  private final val PREIS_DEFAULT: Float = 7.5f
  private final val AUFSCHLAG_DEFAULT: Float = 1.0f
}

case class Reservierung(anwender: Anwender, vorstellung: Vorstellung, plaetze: List[Platz]) {
} 

