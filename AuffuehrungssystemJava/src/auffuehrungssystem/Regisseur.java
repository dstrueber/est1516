package auffuehrungssystem;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Regisseur extends Beteiligter {

	private Collection<Stueck> stuecke;

	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param vorname
	 */
	public Regisseur(String name, String vorname) {
		super(name, vorname);
		this.stuecke = new HashSet<Stueck>();
	}// Regisseur

	/*
	 * (non-Javadoc)
	 * 
	 * @see auffuehrungssystem.Beteiligter#ausgabe()
	 */
	public void ausgabe() {
		System.out.println("Regisseur: " + this + "; ");
	}// ausgabe

	/**
	 * Ausgabe aller geleiteter Stuecke auf der Console.
	 */
	public void ausgabeAllerStuecke() {
		System.out.println("Stuecke: ");
		for (Stueck stueck : stuecke) {
			System.out.println(stueck.getName() + " " + stueck.getPremiereAm());
		}// for
	}// ausgabeAllerStuecke

	/**
	 * 
	 * Liefert eine (read-only) Liste der Filme zur�ck, in der dieser Beteiligte
	 * der Regisseur war.
	 * 
	 * @return
	 */
	Collection<Stueck> getGeleiteteStuecke() {
		return Collections.unmodifiableCollection(stuecke);
	}// getGeleiteteStuecke

	/**
	 * F�gt ein Stueck dem Regisseur hinzu. Der vorherige Regisseur des St�cks wird gegen diesen ausgetauscht.
	 * 
	 * @param stueck
	 */
	public void addStueck(Stueck stueck) {
		if (stueck == null)
			throw new IllegalArgumentException("'stueck' darf nicht null sein!");
		if (stuecke.add(stueck))
			stueck.setRegisseur(this);
	}// addStueck

	/**
	 * Entfernt die Verbindung zwischen diesem Regisseur und dem Stueck.<br>
	 * <i>Achtung: Die Synchronisierung von Stueck erfolgt hier nicht, da
	 * ansonsten ein inkonsistenter Zustand entstehen kann! Diese Methode ist
	 * nur f�r den Aufruf durch die Klasse {@link Stueck} vorgesehen.</i>
	 * 
	 * @param stueck
	 */
	void removeStueck(Stueck stueck) {
		if (stueck == null)
			throw new IllegalArgumentException("'stueck' darf nicht null sein!");
		stuecke.remove(stueck);
		// Hier erfolgt keine R�ck-Synchronisierung!
	}// removeStueck

}// class
