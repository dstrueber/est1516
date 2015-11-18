package auffuehrungssystem


case class Anwender(name: String, vorname: String, telefonnummer: Int) {
  var reservierungen: List[Reservierung] = List[Reservierung]()
}