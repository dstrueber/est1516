package auffuehrungssystem

class Auffuehrungsort(var name: String, var anschrift: Adresse)  {

  var vorstellungen: List[Vorstellung] = List[Vorstellung]()

  /**
   * Konstruktor
   *
   * @param name
   * @param strasse
   * @param ort
   * @param plz
   */
  def this(name: String, strasse: String, ort: String, plz: Int) {
    this(name, new Adresse(strasse, ort, plz))
  }

  /**
   * Consolenausgabe aller Einnahmen dieses Auffuehrungsortes
   */
  def ausgabeDerEinnahmen {
    System.out.println("Gesamteinnahmen: 0")
  }

  /**
   * Erstellt anhand der übergebenen Argumente ein Vorstellungsobjekt und
   * verlinkt es entsprechend.
   *
   * @param stueck
   * @param uhrzeit
   * @return
   */
  def createVorstellung(stueck: Stueck, uhrzeit: String): Vorstellung = {
    val v: Vorstellung = new Vorstellung(stueck, this, uhrzeit)
    this.addVorstellung(v)
    return v
  }




  /**
   * Gibt alle Vorstellungen an diesem Auffuehrungsort auf der Console aus.
   */
  def printVorstellungen {
    for (v <- vorstellungen) {
      System.out.println(v)
    }
  }

  override def toString: String = {
    return "** Auffuehrungsort " + this.name + " **"
  }

  /**
   * @param v
   */
  def addVorstellung(v: Vorstellung) {
    if (v == null) throw new IllegalArgumentException("Vorstellung 'v' darf nicht null sein!")
    vorstellungen = v :: vorstellungen
    v.setOrt(this)
  }

  /**
   * Entfernt eine Vorstellung zu diesem Aufführungsort.<br>
   * <i>Achtung: Die Synchronisierung von Vorstellung erfolgt hier nicht, da
   * ansonsten ein inkonsistenter Zustand entstehen kann! Diese Methode ist
   * nur fï¿½r den Aufruf durch die Klasse {@link Vorstellung} vorgesehen.</i>
   *
   * @param v
   */
  def removeVorstellung(v: Vorstellung) {
    if (v == null) throw new IllegalArgumentException("Vorstellung 'v' darf nicht null sein!")
    vorstellungen = vorstellungen.filterNot(elm => elm == v)
  }

}


case class Adresse (strasse: String, ort: String, plz: Int) {}
