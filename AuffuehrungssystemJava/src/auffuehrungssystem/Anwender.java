package auffuehrungssystem;
import java.util.Collection;
import java.util.HashSet;

public class Anwender {
	private String name;
	private String vorname;
	private int telefonnummer;
	private Collection<Reservierung> reservierungen;
	
	public Anwender(String name, String vorname, int telefonnummer) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.telefonnummer = telefonnummer;
		this.reservierungen = new HashSet<Reservierung>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public int getTelefonnummer() {
		return telefonnummer;
	}
	public void setTelefonnummer(int telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	public Collection<Reservierung> getReservierungen() {
		return reservierungen;
	}
}
