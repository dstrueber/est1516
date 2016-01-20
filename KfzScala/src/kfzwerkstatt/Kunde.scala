
package kfzwerkstatt

class Kunde(var name: String, var vorname: String, var id: String) {
  private var _bezahlt: Int = 0

  def addBezahlt(bezahlt: Int) {
    _bezahlt += bezahlt
  }
  
  def bezahlt = _bezahlt
}
