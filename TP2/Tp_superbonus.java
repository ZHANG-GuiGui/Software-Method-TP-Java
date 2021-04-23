///////////////////////////////////////////////////////
// Guillaume ZHANG Xiaofeng
// MELOG - TP2  	tp_superbonus.java
///////////////////////////////////////////////////////

import java.io.*;
import java.util.*;

public class Tp_superbonus {
	public static void main(String[] argv) throws IOException {
		long startTime = System.currentTimeMillis();

		// Recuperation du nom du fichier a traiter
		String fichier;
        //fichier =(argv.length!=0)? argv[0]: "texte";
        fichier = "Textes/lesMiserables_A";

        /*
		// Appel de l'affichage du texte
		Contenu t = new Contenu(fichier);
		// Ecriture du texte modifie dans un second fichier texte
		t.ecri();
		*/

		Frequence_superbonus f = new Frequence_superbonus(fichier);
		System.out.println("The 15 most used words in lesMiserables_A are: \n");
		f.sortPlus();
		System.out.println("\n\n");
		Contenu added = f.enrichLexique("Textes/notreDameDeParis_A");
		System.out.println("The 15 most used words in lesMiserables_A+notreDameDeParis_A are: \n");
		f.sortPlus();
		System.out.println("\n\n");

		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime-startTime);
	}
}
