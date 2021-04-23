public class Personne {
	protected String nom;
	protected String prenom;
	protected int naisse;
	protected boolean sexe;
	protected Personne pere;
	protected Personne mere;

	public Personne(String nom, String prenom, int naisse, boolean sexe){
		this.nom = nom;
		this.prenom = prenom;
		this.naisse = naisse;
		this.sexe = sexe;
		this.pere = null;
		this.mere = null;
	}
	public String getNom(){
		return this.nom;
	}
	public String getPrenom(){
		return this.prenom;
	}
	public int getNaisse(){
		return this.naisse;
	}
	public boolean getSexe(){
		return this.sexe;
	}
	public Personne getPere(){
		return this.pere;
	}
	public Personne getMere(){
		return this.mere;
	}
	public void addPere(Personne pere){
		this.pere = pere;
	}
	public void addMere(Personne mere){
		this.mere = mere;
	}
	public int calculAge(){
		return 2013-this.naisse;
	}
	public boolean freSoeur(Personne personne){
		if (this.pere==null || this.mere==null || personne.mere==null || personne.pere==null){
			System.out.println("Can't compare");
			return false;
		}else{
			return ((this.pere==personne.pere)&&(this.mere==personne.mere));
		}
	}
	public String toString(){
		if (this.pere==null || this.mere==null){
			return (this.sexe==true)? "Monsieur "+this.prenom+" "+this.nom.toUpperCase()+" est né en "+this.naisse:"Madame "+this.prenom+" "+this.nom.toUpperCase()+" est née en "+this.naisse;
		}
		return (this.sexe==true)? "Monsieur "+this.prenom+" "+this.nom.toUpperCase()+" est né en "+this.naisse+". Son père est "+this.getPere().getPrenom()+" "+this.getPere().getNom().toUpperCase()+". Sa mere est "+this.getMere().getPrenom()+" "+this.getMere().getNom().toUpperCase():"Madame "+this.prenom+" "+this.nom.toUpperCase()+" est née en "+this.naisse+". Son père est "+this.getPere().getPrenom()+" "+this.getPere().getNom().toUpperCase()+". Sa mere est "+this.getMere().getPrenom()+" "+this.getMere().getNom().toUpperCase();
	}
}