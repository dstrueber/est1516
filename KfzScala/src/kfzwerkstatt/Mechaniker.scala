package kfzwerkstatt


class Mechaniker(val mName: String, val mVorname: String, val mId: String) {
  var sumArbeit: Int = 0
  var lohnProZeiteinheit: Int = 15


  def bearbeiteJob(kunde: Kunde, prio: Verkaeufer.Prioritaet.Prioritaet, fehlerbeschreibung: String) {
    System.out.println("Beginne mit Arbeit!")
    val startzeit: Long = compat.Platform.currentTime
    var basisZeit: Int = 100
    if (prio eq Verkaeufer.Prioritaet.DRINGEND) basisZeit = 50
    else if (prio eq Verkaeufer.Prioritaet.WICHTIG) basisZeit = 80
    else if (prio eq Verkaeufer.Prioritaet.NORMAL) basisZeit = 100
    this synchronized {
        wait((Math.random * basisZeit).asInstanceOf[Int])
    }
    val endzeit: Long = compat.Platform.currentTime
    val dauer: Int = (endzeit - startzeit).toInt
    System.out.println("Arbeit beendet! Dauer " + dauer)
    var kostensatz: Int = lohnProZeiteinheit
    if (prio eq Verkaeufer.Prioritaet.DRINGEND) kostensatz += 10
    else if (prio eq Verkaeufer.Prioritaet.WICHTIG) basisZeit += 50
    val lohn: Int = dauer * kostensatz
    sumArbeit += lohn
    kunde.addBezahlt(lohn)
  }

  def gibArbeitskostenZureuck: Int = {
    return sumArbeit
  }


}
