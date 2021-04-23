///////////////////////////////////////////////////////
// Guillaume ZHANG Xiaofeng
// MELOG - TP2  	tp_bonus.java
///////////////////////////////////////////////////////

import java.io.*;
import java.util.*;

public class Tp_bonus {
	public static void main(String[] argv) throws IOException {
		long startTime = System.currentTimeMillis();

		// Recuperation du nom du fichier a traiter
		String fichier;
        //fichier =(argv.length!=0)? argv[0]: "texte";
        fichier = "Textes/lesMiserables_A";


		Frequence_bonus f = new Frequence_bonus(fichier);
		//f.afficher();
		f.toFile();
		System.out.println(f.containsKey("this"));
		System.out.println(f.printLine("other"));
		System.out.println(f.search("other"));
		f.remove("other");
		System.out.println(f.search("other"));


		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime-startTime);
	}
}
