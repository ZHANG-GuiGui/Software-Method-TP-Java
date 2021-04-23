import java.io.*;
import java.util.*;

class Frequence extends HashMap<String, Integer>{
	protected String nom;

	public Frequence(){}

	//Constructor
	public Frequence(String texte) throws IOException {
		this.nom = texte;
		Reader reader = new FileReader(this.nom+".txt");
		BufferedReader in = new BufferedReader(reader);
		String ligne = in.readLine();
		while (ligne != null) {
			String delimiteurs = "/0123456789°~^%$*-_=+|#'.,;:?!() {}[]`<>\"\t\\<>«»";
			StringTokenizer st = new StringTokenizer(ligne,delimiteurs);
			while (st.hasMoreTokens()){
				String mot = st.nextToken();
				mot = mot.toLowerCase();
				//System.out.println(mot);
				this.putIfAbsent(mot,0);
				//System.out.println(newInput.toString());
				this.computeIfPresent(mot,(key,value)->value+1);
			}
			ligne = in.readLine();
		}
	}

	//The affichage function
	public void afficher(){
		System.out.println(this);
	}

	/*
	Les methodes tester la presence et supprimer peuvent etre extends de class HashMap
	this.containsKey(String str) et this. remove(String str)
	 */

	//Search if a certain word is in the read text
	public String search(String searched){
		return (this.containsKey(searched))? "The number of occurences of <"+searched+"> is:"+this.get(searched):"<"+searched+"> not existed.";
	}

	//Write the word and frequency to file
	public void toFile() throws IOException {
		Writer writer = new FileWriter(this.nom+"_frequence.txt");
		writer.write("###########\n#\n# Frequence of each word occurred in "+this.nom+".txt\n#\n# In total "+this.size()+" words.\n#\n#############\n\n\n");
		String res = this.toString();
		String subres = res.substring(1,res.length()-1);
		//System.out.println(subres);
		String [] eachFre = subres.split(", ");
		for (String k : eachFre){
			writer.write(k+"\n");
		}
		writer.close();
	}

	//Read another file and update the lexique, return a list of added words
	public Contenu enrichLexique(String texte) throws IOException{
		Contenu addedLexique = new Contenu();
		addedLexique.set_name(texte);
		Reader reader = new FileReader(texte+".txt");
		BufferedReader in = new BufferedReader(reader);
		String ligne = in.readLine();
		while (ligne != null) {
			String delimiteurs = "/0123456789°~^%$*-_=+|#'.,;:?!() {}[]`<>\"\t\\<>«»";
			StringTokenizer st = new StringTokenizer(ligne,delimiteurs);
			while (st.hasMoreTokens()){
				String mot = st.nextToken();
				mot = mot.toLowerCase();
				//System.out.println(mot);
				if (!this.containsKey(mot)){
					addedLexique.add(mot);
				}
				this.putIfAbsent(mot,0);
				this.computeIfPresent(mot,(key,value)->value+1);
			}
			ligne = in.readLine();
		}
		return addedLexique;
	}
}