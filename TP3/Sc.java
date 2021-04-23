// Exemple d'utilisation de la classe Arbre fournie pour le TP n III
// exemple d'execution : 
// java Sc "((5*(x^3))-(4*(x^2)))+(x+6)" 1
// java Sc "((x^5)+(2*(x^2)))/((x^2)+(x-5))" 1
// necessite les fichiers Arbre.java, Clavier.javaGUIHelper.java, JCanvas.java, ManipulationArbre.java, TextInter.java
import java.io.*;
import java.awt.Dimension;


public class Sc{
        
    public static void main(String args[]) throws IOException {
		//utilisation des methodes pour transformer le texte d'une expression en un arbre (avec stockage dans un format intermediaire)
	   if (args.length==0) {System.out.println("Default");ManipulationArbre.generationXMLdepuisTexte("(x+3)*(5-(2*x))","XML.xml");}
	   else {
	     System.out.println("Normal"); ManipulationArbre.generationXMLdepuisTexte(args[0], "XML.xml");};

        // Recuperation d'un objet de la classe Arbre
        Arbre arbreOrigin = ManipulationArbre.XMLVersArbre("XML.xml");
        Arbre arbre = ManipulationArbre.XMLVersArbre("XML.xml");
        Double x = Double.valueOf(args[1]);
		System.out.println("L'arbre en préfixe est :");
		arbre.afficherPrefixe();
		System.out.println();
		System.out.println("Le résultat d'équation avec x="+x+" est : "+arbre.calculNum(x));
		ManipulationArbre.Affiche(arbreOrigin);
		System.out.println();
		//Simplification
		arbre.simplification();
		arbre.afficherPrefixe();
		System.out.println();
		System.out.println("L'équation après simplification est : "+arbre.arbreVersTexte());
		ManipulationArbre.generationXMLdepuisTexte(arbre.arbreVersTexte(), "Simplify.xml");
		System.out.println("Le résultat d'équation après simplification est : "+arbre.calculNum(x));
		Arbre arbreSimp = ManipulationArbre.XMLVersArbre("Simplify.xml");
		ManipulationArbre.Affiche(arbreSimp);
		System.out.println();

		//Dérivation :équation polynôme ou rationnelle
		if (arbre.valeur().equals("/")){
			arbre.deriveRatio();
		}else{
			arbre.derivePoly();
		}
		arbre.afficherPrefixe();
		System.out.println();
		System.out.println("La dérivée de l'équation est : "+arbre.arbreVersTexte());
		ManipulationArbre.generationXMLdepuisTexte(arbre.arbreVersTexte(), "Derive.xml");
		System.out.println("Le dérivée d'équation en x="+x+" est : "+arbre.calculNum(x));
		Arbre arbreDerive = ManipulationArbre.XMLVersArbre("Derive.xml");
		ManipulationArbre.Affiche(arbreDerive);
    }
  }
