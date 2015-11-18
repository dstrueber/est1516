package auffuehrungssystem;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Darsteller extends Beteiligter {

	/**
	 * Stuecke, in der der Darsteller mitgespielt hat.
	 */
	private Collection<Stueck> stuecke;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param vorname
	 */
	public Darsteller(String name, String vorname) {
		super(name, vorname);
		this.stuecke = new HashSet<Stueck>();
	}// Darsteller

	/*
	 * (non-Javadoc)
	 * 
	 * @see auffuehrungssystem.Beteiligter#ausgabe()
	 */
	public void ausgabe() {
		System.out.println("Darsteller: " + this + "; ");
	}// ausgabe

	/**
	 * Liefert eine (read-only) Liste der Filme zur�ck, in der dieser Darsteller
	 * mitgespielt hat.
	 * 
	 * @return
	 */
	public Collection<Stueck> getStuecke() {
		return Collections.unmodifiableCollection(stuecke);
	}// getFilme

	/**
	 * F�gt ein Stueck dem Darsteller hinzu.
	 * 
	 * @param stueck
	 */
	public void addStueck(Stueck stueck) {
		if (stueck == null)
			throw new IllegalArgumentException("'stueck' darf nicht null sein!");
		if (stuecke.add(stueck))
			stueck.addDarsteller(this);
	}// addStueck

	/**
	 * Entfernt ein Stueck aus der Liste des Darsteller.
	 * 
	 * @param stueck
	 */
	public void removeStueck(Stueck stueck) {
		if (stueck == null)
			throw new IllegalArgumentException("'stueck' darf nicht null sein!");
		if (stuecke.remove(stueck))
			stueck.removeDarsteller(this);
	}// removeStueck

}// class
