package auffuehrungssystem

class Auffuehrungsort(var name: String, var adr: Adresse)  {


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
  def createVorstellung(stueck: Stueck, uhrzeit: String, saal: Saal): Vorstellung = {
    val v: Vorstellung = new Vorstellung(stueck, this, uhrzeit, saal)
    this.addVorstellung(v)
    return v
  }

  /**
   * Erstellt anhand der übergebenen Argumente ein Saalobjekt und
   * verlinkt es entsprechend.
   *
   * @param bezeichnung
   * @param sonstiges
   * @return
   */
  def createSaal(bezeichnung: String, sonstiges: String, reihen: Int, spalten: Int, logenReihen: Int): Saal = {
    val saal: Saal = new Saal(bezeichnung, sonstiges, reihen, spalten, logenReihen)
    this.addSaal(saal)
    return saal
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

  /**
   * @param s
   */
  def addSaal(s: Saal) {
    if (s == null) throw new IllegalArgumentException("Saal 's' darf nicht null sein!")
    saele = s::saele
  }

  def removeSaal(s: Saal) {
    if (s == null) throw new IllegalArgumentException("Saal 's' darf nicht null sein!")
    saele = saele.filterNot(elm => elm == s)
  }

  var vorstellungen: List[Vorstellung] = List[Vorstellung]()
  var saele: List[Saal] = List[Saal]()
}


case class Saal(bezeichnung: String, sonstiges: String) {
  var plaetze = List[Platz]()
  
  def this(bezeichnung: String, sonstiges: String, reihen: Int, spalten: Int, logenReihen: Int) {
    this(bezeichnung, sonstiges)
    if (reihen <= 0 || spalten <= 0 || logenReihen < 0) {
      throw new IllegalArgumentException("Es darf nicht weniger als eine Reihe, 1 Spalte und 0 Logenreihen geben.")
    }
    
    for (reihe <- 0 to reihen)  {
        for (spalte <- 0 to spalten) {
           var platz = new Platz(reihe, spalte, logenReihen <= reihe)
           plaetze = platz :: plaetze
      }
    }
  }

}

case class Adresse (strasse: String, ort: String, plz: Int) {}
case class Platz(reihe: Int, nr: Int, isLoge: Boolean) { }
