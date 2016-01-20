package kfzwerkstatt

object Verkaeufer {

  object Prioritaet extends Enumeration {
    type Prioritaet = Value
    val DRINGEND, WICHTIG, NORMAL = Value
  }

}

class Verkaeufer(val vName: String, val vVorname: String, val vId: String)  {
  private var lohnProZeiteinheit: Int = 3
  var sumVerkaeufe: Double = 0.0


  def verkaufeDienstleitung(kunde: Kunde, prio: Verkaeufer.Prioritaet.Prioritaet, fehlerbeschreibung: String, m: Mechaniker) {
    val startzeit: Long = compat.Platform.currentTime
    this synchronized {
        this.wait((Math.random * 100).asInstanceOf[Int])
    }
    val endzeit: Long = compat.Platform.currentTime
    val dauer: Int = (endzeit - startzeit).toInt
    val lohn: Int = dauer * lohnProZeiteinheit
    sumVerkaeufe += lohn
    kunde.addBezahlt(lohn)
    m.bearbeiteJob(kunde, prio, fehlerbeschreibung)
  }

}
