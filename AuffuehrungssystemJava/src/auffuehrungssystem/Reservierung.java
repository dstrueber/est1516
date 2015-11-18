package auffuehrungssystem;
import java.util.Collection;

public class Reservierung {
	private Anwender anwender;
	private Vorstellung vorstellung;
	private Collection<Platz> plaetze;
	
	public Reservierung(Anwender anwender, Vorstellung vorstellung, Collection<Platz> plaetze) {
		super();
		this.anwender = anwender;
		this.vorstellung = vorstellung;
		this.plaetze = plaetze;
	}

	public Anwender getAnwender() {
		return anwender;
	}

	public void setAnwender(Anwender anwender) {
		this.anwender = anwender;
	}

	public Vorstellung getVorstellung() {
		return vorstellung;
	}

	public void setVorstellung(Vorstellung vorstellung) {
		this.vorstellung = vorstellung;
	}

	public Collection<Platz> getPlaetze() {
		return plaetze;
	}

	public void setPlaetze(Collection<Platz> plaetze) {
		this.plaetze = plaetze;
	}
	
}
