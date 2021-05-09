import java.io.*;

public class Main {
private static final String FILENAME = "fichierDEntiers.txt";

	public static void main(String[] arg) throws ExceptionListeVide, IOException {
		ListeChaineeOrdonnee liste = new ListeChaineeOrdonnee();
		
    try {
      FileReader filereader = new FileReader(FILENAME);
      BufferedReader bufferedreader = new BufferedReader(filereader);
      String s;

      while ((s = (String)bufferedreader.readLine()) != null) {
        System.out.println(s);
        liste.ajouter(Integer.parseInt(s));
      }
			/*
			liste.ajouter(21);
			liste.ajouter(35);
			liste.ajouter(8);
			liste.ajouter(19);
			*/
			System.out.println("ecrire");
			liste.ecrire();
			System.out.println("Nombre de chainons (taille de la liste ): " + liste.taille());

			liste.ecrireDecroissant();

			System.out.print("On retire le plus petit : ");
			System.out.println(liste.retirerPlusPetit());
			System.out.println("Valeur du plus grand : " + liste.plusGrand());

			System.out.println("8 existe : " + liste.existe(8));
			System.out.println("19 existe : " + liste.existe(19));
			System.out.println("21 existe : " + liste.existe(21));
			System.out.println("18 existe : " + liste.existe(18));
			
			System.out.println(liste);

			System.out.print("On retire le plus petit : ");
			System.out.println(liste.retirerPlusPetit());
			System.out.print("On retire le plus petit : ");
			System.out.println(liste.retirerPlusPetit());
			System.out.print("On retire le plus petit : ");
			System.out.println(liste.retirerPlusPetit());
			System.out.print("On retire le plus petit : ");
			System.out.println(liste.retirerPlusPetit());
		}
		catch(ExceptionListeVide exc) {
			System.out.println(exc);
		}
		System.out.print("Valeur du plus grand : "); 
		System.out.println(liste.plusGrand());
	}
}