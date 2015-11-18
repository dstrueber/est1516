package auffuehrungssystem;
import java.util.ArrayList;
import java.util.Collection;

public class Saal {

	private String bezeichnung;
	private String sonstiges;
	private Collection<Platz> plaetze;
	
	public Saal(String bezeichnung, String sonstiges) {
		super();
		this.bezeichnung = bezeichnung;
		this.sonstiges = sonstiges;
		this.plaetze = new ArrayList<Platz>();
	}
	
	public Saal(String bezeichnung, String sonstiges, int reihen, int spalten, int logenReihen) {
		this(bezeichnung, sonstiges);
		if (reihen <= 0 || spalten <= 0 || logenReihen < 0) {
			throw new IllegalArgumentException("Es darf nicht weniger als eine Reihe, 1 Spalte und 0 Logenreihen geben.");
		}
		for (int reihe=0; reihe<reihen; reihe++) {
			for (int spalte=0; spalte<spalten; spalte++) {
				Platz platz = new Platz(reihe, spalte, logenReihen<=reihe);
				plaetze.add(platz);
			}	
		}
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getSonstiges() {
		return sonstiges;
	}

	public void setSonstiges(String sonstiges) {
		this.sonstiges = sonstiges;
	}
}
