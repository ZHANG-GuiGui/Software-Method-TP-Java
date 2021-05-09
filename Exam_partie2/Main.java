import java.io.IOException;

public class Main {
	public static void main(String[] arg) {
		long startTime = System.currentTimeMillis();

		ArBinRech abr = new ArBinRech();
		abr.inserer("bien");
		abr.inserer("que");
		abr.inserer("ce");
		abr.inserer("rapport");
		abr.inserer("rapport");
		abr.inserer("detail");
		abr.inserer("n'ait");
		abr.inserer("aucun");
		abr.inserer("rapport");

		System.out.println("La hauteur de l'arbre est : " + abr.hauteur());
		abr.ecrireInfixe();
		System.out.println("Le nombre de noeuds de l'arbre est : " + abr.nbNoeuds());
		String dd = abr.estUnABR() ? "l'arbre est bien un ABR" : "l'arbre n'est pas un ABR";
		System.out.println(dd);
		System.out.println("Le mot plus frequent est : " + abr.leMotPlusFrequent());

		System.out.println("\nNouvel arbre");
		try {
			abr = new ArBinRech("debutDesMiserables_A.txt");
			System.out.println("La hauteur de l'arbre est : " + abr.hauteur());
			abr.ecrireInfixe();
		    System.out.println("Le nombre de noeuds de l'arbre est : " + abr.nbNoeuds());

 			String s = abr.estUnABR() ? "l'arbre est bien un ABR" : "l'arbre n'est pas un ABR";
			System.out.println(s);
			System.out.println("Le mot plus frequent est : " + abr.leMotPlusFrequent());
		}
		catch(IOException exc) {
			System.out.println("Fichier " + "debutDesMiserables_A.txt" + " inexistant ou non correct");
		}
		long stopTime = System.currentTimeMillis();
    	long elapsedTime = stopTime - startTime;
    	System.out.println(elapsedTime/1000. + "s.");

	}
}
