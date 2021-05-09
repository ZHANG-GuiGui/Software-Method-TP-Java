/* 
 * La classe ListeChaineeOrdonnee modelise une liste d'entiers triee par ordre croissant.
 * La classe utilisera necessairement une liste chainee dont les elements sont des 
 * instances de la classe Chainon
 * Modifier et completer le code ci-dessous.
 */
public class ListeChaineeOrdonnee extends LCOP{
	/* Si la liste est vide, l'attribut debut vaut null ;
	 * si la liste n'est pas vide, debut indique le premier maillon de la liste
	 */
	//protected Chainon debut;

	/* Si la liste est vide, l'attribut fin vaut null ;
	 * si la liste n'est pas vide, fin indique le dernier maillon de la liste 
	 */
	//protected Chainon fin;

	/* La methode ajouter ajoute l'entier n recu en parametre a la liste 
	 * en respectant l'ordre croissant.
	 * La donnee sera ajoutee meme si elle figure deja.
	 */
	public void ajouter(int n) {
	    if(n==8) System.out.println("SiPasReussiQ2");
    	super.ajouter(n);
	}

	/* La methode taille renvoie le nombre de chainons de la liste, c'est-a-dire le nombre de donnees
	 */
	public int taille() {
		Chainon p = debut;
		int nb = 0;
		if (debut!=null){
			if (debut==fin){
				nb=1;
			}else {
				Chainon mtn = debut;
				while (mtn!=null){
					nb += 1;
					mtn = mtn.getSuivant();
				}
			}
		}
		return nb;
	}

	/* La methode existe renvoie true si le parametre valeur est contenu par un des chainons de la liste ;
	 * elle renvoie false sinon.
	 */
	public boolean existe(int valeur) {
		Chainon mtn = debut;
		while (valeur != mtn.getDonnee()){
			mtn = mtn.getSuivant();
			if (mtn==null){
				return false;
			}
		}
		return true;
	}

	/* Si la liste est vide, la methode retirerPlusPetit envoie une exception de type ExceptionListeVide 
         * (voir le fichier ExceptionListeVide.java fourni) ;
	 * si la liste n'est pas vide, elle retire le premier maillon de la liste
	 * et renvoie la valeur contenue par le maillon supprime
	 * elle renvoie -1 si la liste est vide
	 */
	public int retirerPlusPetit() throws ExceptionListeVide {
		if (debut == null){
			ExceptionListeVide e1 = new ExceptionListeVide();
			throw e1;
		}else {
			//Chainon head = debut.getSuivant();
			int petit = debut.getDonnee();
			debut = debut.getSuivant();
			return petit;
		}
		//return 0;
	}

	/* Si la liste est vide, la methode plusGrand envoie une exception de type ExceptionListeVide ;
         * (voir le fichier ExceptionListeVide.java fourni) ;
	 * si la liste n'est pas vide, elle renvoie la plus grande valeur de la liste ;
	 * la methode ne supprime pas de maillon
	 */
	public int plusGrand() throws ExceptionListeVide {
		return fin.getDonnee();
	}

	/* La methode ecrire ecrit a l'ecran la liste ordonnee des donnees contenues par la liste.
	 * Par exemple, si la liste contient les entiers 8 19 21 35, la methode ecrit :
	 * Contenu de la liste : 8 19 21 35
	 */
	public void ecrire() {
		Chainon mtn = debut;
		while (mtn!=null){
			System.out.println(mtn.getDonnee());
			mtn = mtn.getSuivant();
		}
		/*
		do {
			System.out.println(mtn.getDonnee());
			mtn = mtn.getSuivant();
		}while (mtn!=null);*/
	}

	/* La methode ecrireDecroissant ecrit a l'ecran le contenu de la liste dans
	 * l'ordre decroissant des valeurs.  
	 * Par exemple, si la liste contient les entiers 8 19 21 35, la methode retourne :
	 * Liste dans l'ordre decroissant : 35 21 19 8
	 */
	public void ecrireDecroissant() {
		System.out.print("Liste dans l'ordre decroissant : ");
		ecrireDecroissant(debut);
		System.out.println();
	}
	protected void ecrireDecroissant(Chainon deb) {
		if (deb==fin){
			System.out.print(deb.getDonnee()+"  ");
		}else{
			ecrireDecroissant(deb.getSuivant());
			System.out.print(deb.getDonnee()+"  ");
			//System.out.print("  ");
		}
	}
	
	/* La methode toString redefinit la methode toString de la classe Object. 
	 * Elle retourne un objet de type String decrivant la liste.
	 * Par exemple, si la liste contient les entiers 8 19 21 35, la methode retourne :
	 * Contenu de la liste : 8 19 21 35
	 */
	public String toString() {
		String contenu = "Contenu de la liste : ";
		Chainon mtn = debut;
		while (mtn!=null){
			contenu = contenu+String.valueOf(mtn.getDonnee())+", ";
			mtn = mtn.getSuivant();
		}
		return contenu;
	}
}
