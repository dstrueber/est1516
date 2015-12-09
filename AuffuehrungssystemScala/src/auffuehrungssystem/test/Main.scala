package auffuehrungssystem.test

import auffuehrungssystem.Auffuehrungsort
import auffuehrungssystem.Darsteller
import auffuehrungssystem.Stueck
import auffuehrungssystem.Vorstellung
import auffuehrungssystem.Regisseur
import java.util.Date
import auffuehrungssystem.Stuecktyp

object Main {
 def main(args: Array[String]): Unit = {
       val auffuehrungsort: Auffuehrungsort = new Auffuehrungsort("Gloria", "Bahnhofstra?e 22", "Marburg", 35037)
    val d1: Darsteller = new Darsteller("Schnabel", "Adolf")
    val d2: Darsteller = new Darsteller("Schreinemarkers", "Margot")
    val d3: Darsteller = new Darsteller("Fischer", "Ottfried")
    val d4: Darsteller = new Darsteller("Parker", "Peter")
    val r1: Regisseur = new Regisseur("Benoshie", "Hoshie")
    val stueck1: Stueck = new Stueck("Hulk XIV", "", Stuecktyp.FILM,  createDate(2015,11,18))
    stueck1.addDarsteller(d1)
    stueck1.addDarsteller(d2)
    val stueck2: Stueck = new Stueck("Spider Pig", "", Stuecktyp.OPERETTE, createDate(2015,11,18))
    stueck2.addDarsteller(d4)
    stueck2.addDarsteller(d3)
    stueck2.addDarsteller(d2)
    stueck2.setRegisseur(r1)
    val v1: Vorstellung = auffuehrungsort.createVorstellung(stueck1, "18Uhr")
    val v2: Vorstellung = auffuehrungsort.createVorstellung(stueck2, "20Uhr")
    System.out.println(auffuehrungsort)
    System.out.println(v1.stueck + "\nEinnahmen: " + v1.liefereEinnahmen)
    System.out.println(v2.stueck + "\nEinnahmen: " + v2.liefereEinnahmen)
    auffuehrungsort.ausgabeDerEinnahmen
 } 
 
 def createDate(year: Int , month: Int, day: Int): Date =  {
   return new Date(year-1900,month-1,day)
 }
}