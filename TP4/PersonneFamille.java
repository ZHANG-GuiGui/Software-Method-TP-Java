import java.io.*;
import java.util.*;

public class PersonneFamille extends Personne {
	protected PersonneFamille couple;
	protected Vector<Personne> enfants;

	public PersonneFamille(String nom, String prenom, int naisse, boolean sexe){
		super(nom,prenom,naisse,sexe);
		this.enfants = new Vector<Personne>();
	}
	public PersonneFamille getCouple(){
		return this.couple;
	}
	public boolean marier(PersonneFamille amarier){
		if (amarier.getSexe()!=this.getSexe()){
			this.couple = amarier;
			amarier.couple = this;
			return true;
		}else{
			return false;
		}
	}
	public Vector<Personne> getEnfant(){
		return this.enfants;
	}
	public void ajoutEnfant(Personne enfant){
		this.enfants.add(enfant);
		if (!this.getCouple().getEnfant().contains(enfant)){
			this.getCouple().getEnfant().add(enfant);
		}
	}
	public int compterEnfant(){
		return this.enfants.size();
	}
	public String toString(){
		if (this.getEnfant().size()!=0){
			String res = super.toString()+". Ses enfants sont ";
			for (Personne item : this.enfants){
				res += item.getPrenom()+" "+item.getNom().toUpperCase()+" ";
			}
			return res;
		}else{
			return super.toString()+". Pas d'enfant.";
		}
	}

}