public class Noeud {
	private String mot;
	private Noeud fg, fd;
	private int nbOcc;
	
	public Noeud(String mot) {
		this.mot = mot;
	}
	public int getNbOcc() {
		return this.nbOcc;
	}
	public void setNbOcc(int n) {
		this.nbOcc = n;
	}
	public void setMot(String m) {
		this.mot = m;
	}
	public String getMot() {
		return this.mot;
	}
	public void setDonnee(String m) {
		this.mot = m;
	}
	public Noeud getFg() {
		return this.fg;
	}
	public void setFg(Noeud newfg) {
		this.fg = newfg;
	}
	public Noeud getFd() {
		return this.fd;
	}
	public void setFd(Noeud newfd) {
		this.fd = newfd;
	}
}