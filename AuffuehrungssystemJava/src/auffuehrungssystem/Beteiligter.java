package auffuehrungssystem;
abstract class Beteiligter {

	/**
	 * Name und Vorname dieses Beteiligten.
	 */
	private final String name, vorname;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param vorname
	 */
	public Beteiligter(String name, String vorname) {
		this.name = name;
		this.vorname = vorname;
	}// Beteiligter

	/**
	 * Ausgabe einer String-Repr�sentation dieses Beteiligten auf der Console.
	 */
	abstract public void ausgabe();

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}// getName

	/**
	 * @return
	 */
	public String getVorname() {
		return vorname;
	}// getVorname

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return vorname + " " + name;
	}// toString

}// class
