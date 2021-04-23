import java.io.*;
import java.util.*;

class Frequence_bonus extends HashMap<String, LinkedList<Integer>>{
	protected String nom;

	public Frequence_bonus(){}

	public Frequence_bonus(String texte) throws IOException {
		this.nom = texte;
		Reader reader = new FileReader(this.nom+".txt");
		BufferedReader in = new BufferedReader(reader);
		String ligne = in.readLine();
		int lineNum = 1;
		while (ligne != null) {
			String delimiteurs = "/0123456789°~^%$*-_=+|#'.,;:?!() {}[]`<>\"\t\\<>«»";
			StringTokenizer st = new StringTokenizer(ligne,delimiteurs);
			while (st.hasMoreTokens()){
				String mot = st.nextToken();
				mot = mot.toLowerCase();
				LinkedList<Integer> newInput = new LinkedList<Integer>();
				newInput.add(0);
				this.putIfAbsent(mot,newInput);
				if ((this.containsKey(mot))){
					int first = this.get(mot).pollFirst();
					this.get(mot).addFirst(first+1);
					this.get(mot).add(lineNum);
				}
			}
			ligne = in.readLine();
			lineNum += 1;
		}
	}

	public void afficher(){
		System.out.println(this);
	}

	/*
	Les methodes tester la presence et supprimer peuvent etre extends de class HashMap
	this.containsKey(String str) et this. remove(String str)
	 */

	public String search(String searched){
		return (this.containsKey(searched))? "The number of occurences of <"+searched+"> is:"+this.get(searched).get(0):"<"+searched+"> not existed.";
		//+" and the lines appeared are:"+this.get(searched).toArray().get(1:this.get(searched).size())
	}

	public String printLine(String searched){
		if (this.containsKey(searched)){
			String [] cntLines = this.get(searched).toString().split(", ",2);
			return "The word <"+searched+"> appeared in lines:"+cntLines[1].subSequence(0,cntLines[1].length()-1);
		}else{
			return "<"+searched+"> not existed.";
		}
	}

	public void toFile() throws IOException {
		Writer writer = new FileWriter(this.nom+"_frequence_bonus.txt");
		writer.write("###########\n#\n# Frequence of each word occurred in "+this.nom+".txt\n#\n# In total "+this.size()+" words.\n#\n#############\n\n\n");
		for (String item : this.keySet()){
			String [] cntLines = this.get(item).toString().split(", ",2);
			writer.write("The word <"+item+"> occured "+cntLines[0].subSequence(1,cntLines[0].length())+" times, and it occured in lines "+cntLines[1].subSequence(0,cntLines[1].length()-1)+"\n");
		}
		writer.close();
	}
}