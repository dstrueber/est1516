
package auffuehrungssystem

class Vorstellung(var stueck: Stueck, var ort: Auffuehrungsort,
    var uhrzeit: String,
    var preis: Float = Vorstellung.PREIS_DEFAULT,
    var sitzeGesamt: Int = Vorstellung.SITZE_GESAMT_DEFAULT,
    var sitzeBelegt: Int = Vorstellung.SITZE_BELEGT_DEFAULT) {

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
    throw new UnsupportedOperationException("Funktion derzeit nicht implementiert.")
  }
  	
  
  /**
	 * @param anzahl
	 * @return true, falls die geforderten Sitze belegt werden konnten, sonst
	 *         false
	 */
  def belegeSitze(anzahl: Int): Boolean = {
    throw new UnsupportedOperationException("Funktion derzeit nicht implementiert.")
  }
  
	/**
	 * Setzt die Gesamtanzahl der in dieser Vorstellung zur Verfügung stehenden
	 * Sitze. Der vorherige Wert wird dabei überschrieben.
	 * 
	 * @param sitzeGesamt
	 *            the sitzeGesamt to set
	 */
  def setSitzeGesamt(anzahl: Int): Boolean = {
    throw new UnsupportedOperationException("Funktion derzeit nicht implementiert.")    
  }
}
object Vorstellung {
  private final val PREIS_DEFAULT: Float = 7.5f
  private final val SITZE_GESAMT_DEFAULT = 200;
  private final val SITZE_BELEGT_DEFAULT = 0;
}

