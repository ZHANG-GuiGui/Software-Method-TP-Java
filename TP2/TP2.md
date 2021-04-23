# TP2 Compte Rendu
> Guillaume ZHANG Xiaofeng 21/04/2021
[toc]

## Question 0
J'étudie comment traiter les fichier txt en lisant les codes dans `Contenu.java`.
**************************************
## Question 1
Je choisis Hashmap pour représenter un lexique. Un mot (key) associe avec un nombre d'occurence (value).

La classe `Frequence` hérite donc de la classe `Hashmap`. **Attention : la classe `Frequence` possède donc des méthodes intégrées dans la classe `Hashmap`.**

Je concois deux constructeurs. L'un est constructeur vide, l'un est constructeur pour établir ce lexique. Je réalise ce constructeur par l'inspiration de la classe `Contenu`.

J'ai trouvé deux méthodes intéressantes `putIfAbsent` et `computeIfPresent` qui me permet de ne pas écrire un `If Else`.

Les mots dans ce lexique est rendu dans l'ordre de l'apparence des mots dans les textes.

Puisque `Frequence` est un `Hashmap`, les methodes `tester la presence` et `supprimer` peuvent être extends de la class HashMap `this.containsKey(String str)` et `this. remove(String str)`.

Pour établir un lexique de `lesMiserables_A`, il faut 405 secondes.

```java
import java.io.*;
import java.util.*;

class Frequence extends HashMap<String, Integer>{
    protected String nom;
    //Constructor
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
                this.putIfAbsent(mot,0);
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
}
```
***********************************************
## Question 2
Cette question nous demande d'enrichir ce lexique et renvoyer un list des mots rajoutés.

Je rajoute une méthode `enrichLexique` dans la classe `Frequence` qui renvoie un `Contenu`.

Le processus est comme le constructeur, sauf il faut ajouter de nouveaux mots dans `Contenu`.

```java
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
```
**********************************************
## Question bonus
Il faut ajouter des lignes dans le lexique. Donc je n'utilise plus Hashmap<String,int>. J'utilise Hashmap<String, LinkedList<Integer>>.

Dans ce LinkedList, le premier entier représente le nombre d'occurence, les entiers qui suivent signifies les lignes où chaque fois ce mot apparait.

Le constructeur change le plus. Pour changer le premier élément dans un LinkedList, je ne peux pas directement affecter un nouveau valeur sur cette position comme `LinkedList[0] = 1`. Je fais donc d'abord poll ce premier élément pour obtenir sa valeur et le supprimer. Ensuite, je rajoute un nouveau élément à la tête avec une valeur +1.

Pour les lignes, j'utilise `add` pour les rajouter à la fin de ce LinkedList. Pas de difficulté.

D'autres méthodes sont légèrement modifiées.

```java
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
```
****************************************
## Question super bonus
Je rajoute une méthode `sortPlus` pour sort Hashmap à travers ces valeurs. Ensuite, les 15 plus fréquemment utilisé mots qui ont une longueur plus de 3 caractères sont imprimés.
```java
import java.io.*;
import java.util.*;

class Frequence_superbonus extends Frequence{
    public Frequence_superbonus(String texte) throws IOException {
        super(texte);
    }

    public void sortPlus(){
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(this.entrySet()); //转换为list
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().length()>3){
                System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
                k+=1;
                if (k>14) break;
            }
        }
    }
}
```