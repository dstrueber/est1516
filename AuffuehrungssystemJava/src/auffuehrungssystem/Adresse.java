package auffuehrungssystem;
public class Adresse {
	private final String strasse, ort;
	private final int plz;

	public Adresse(String strasse, String ort, int plz) {
		this.strasse = strasse;
		this.ort = ort;
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public int getPlz() {
		return plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public String toString() {
		String str = "";
		str += strasse;
		str += "\n";
		str += plz;
		str += " ";
		str += ort;
		return str;
	}

}
