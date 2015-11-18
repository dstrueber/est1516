package auffuehrungssystem;
public class Platz {
	private int reihe;
	private int nr;
	private boolean isLoge;
	
	
	public Platz(int reihe, int nr, boolean isLoge) {
		super();
		this.reihe = reihe;
		this.nr = nr;
		this.isLoge = isLoge;
	}
	
	public int getReihe() {
		return reihe;
	}
	public void setReihe(int reihe) {
		this.reihe = reihe;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public boolean isLoge() {
		return isLoge;
	}
	public void setLoge(boolean isLoge) {
		this.isLoge = isLoge;
	}
}
