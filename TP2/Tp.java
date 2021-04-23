///////////////////////////////////////////////////////
// Guillaume ZHANG Xiaofeng
// MELOG - TP2  	tp.java
///////////////////////////////////////////////////////

import java.io.*;
import java.util.*;

public class Tp {
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

		Frequence f = new Frequence(fichier);
		
		//f.afficher();
		f.toFile();
		System.out.println(f.containsKey("this"));
		System.out.println(f.search("other"));
		f.remove("other");
		System.out.println(f.search("other"));

		Contenu added = f.enrichLexique("Textes/notreDameDeParis_A");
		added.ecri();
		System.out.println(f.search("other"));

		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime-startTime);
	}
}
