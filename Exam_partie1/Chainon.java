public class Chainon  {
	private int donnee;
	private Chainon suivant;
	
	// Ajouter un constructeur pour initialiser les attributs
	public Chainon(int donnee, Chainon suivant){
		this.donnee = donnee;
		this.suivant = suivant;
	}
	public Chainon getSuivant() {
		return suivant;
	}
	public void setSuivant(Chainon s) {
		this.suivant = s;
	}
	public int getDonnee() {
		return donnee;
	}
	public void setDonnee(int d) {
		this.donnee = d;
	}
}