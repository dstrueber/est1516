package kfzwerkstatt;

public class Kunde {

	private final String name;
	private final String vorname;
	private final String id;

	private int bezahlt;

	public Kunde(String id, String name, String vorname) {
		super();
		this.id = id;
		this.name = name;
		this.vorname = vorname;
		this.bezahlt = 0;
	}

	public int getBezahlt() {
		return bezahlt;
	}

	public void addBezahlt(int bezahlt) {
		this.bezahlt += bezahlt;
	}

	public String getName() {
		return name;
	}

	public String getVorname() {
		return vorname;
	}

	public String getId() {
		return id;
	}

}
