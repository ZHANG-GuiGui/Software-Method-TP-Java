public class PersonneMariee extends Personne {
	protected PersonneMariee couple;

	public PersonneMariee(String nom, String prenom, int naisse, boolean sexe){
		super(nom,prenom,naisse,sexe);
		this.couple = null;
	}

	public boolean marier(PersonneMariee amarier){
		if (amarier.getSexe()!=this.getSexe()){
			this.couple = amarier;
			amarier.couple = this;
			return true;
		}else{
			return false;
		}
	}

	public PersonneMariee getCouple(){
		return this.couple;
	}

	public String toString(){
		return (this.couple==null)?super.toString()+" et ne s'est pas encore marié.":super.toString()+" et s'est marié avec "+this.couple.getPrenom()+" "+this.couple.getNom().toUpperCase();
	}
}