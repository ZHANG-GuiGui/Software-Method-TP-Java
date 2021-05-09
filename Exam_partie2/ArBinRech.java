
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
//import java.Math

public class ArBinRech {
    private Noeud racine;
    
    public ArBinRech() {}
    
    public ArBinRech(String nomFichier)  throws IOException {
        construire(nomFichier); 
    }
    
    public void inserer(String mot) {
        racine = inserer(racine, mot);
    }
    
    public Noeud inserer(Noeud rac, String mot ) {
        if (rac == null) {
            Noeud nouveau = new Noeud(mot);
            return nouveau;
        }
        if (mot.compareTo(rac.getMot()) < 0) {
            rac.setFg(inserer(rac.getFg(), mot));
            return rac;
        } // compareTo() retourne une 
        // valeur negative si le mot precede le parametre dans l'ordre alphabetique
        //Compares this object with the specified object for order. 
        //Returns a negative integer, zero, or a positive integer as this object   
        //is less than, equal to, or greater than the specified object.

        else if (mot.compareTo(rac.getMot()) == 0) {
            rac.setNbOcc(rac.getNbOcc()+1);
            return rac;
        }
        else {
            rac.setFd(inserer(rac.getFd(),mot));
            return rac;
        }
        //return rac ;
    }
    
    public void construire(String nomFichier) throws IOException {
        Scanner lecteur = new Scanner(new File(nomFichier));
        while(lecteur.hasNext()) inserer(lecteur.next());
    }
    
    public int hauteur() {
        return hauteur(racine);
    }
    
    private int hauteur(Noeud rac) {
        if (rac==null){
            return 0;
        }else{
            return Math.max(hauteur(rac.getFd()),hauteur(rac.getFg()))+1;
        }
        //return 0; // à corriger . . .
    }
    
    public int nbNoeuds() {
        return nbNoeuds(racine);
    }
    
    private int nbNoeuds(Noeud rac) {
        if (rac==null){
            return 0;
        }else{
            return nbNoeuds(rac.getFg())+nbNoeuds(rac.getFd())+1;
        }
        //return 0; // à corriger . . .
    }
    
    public void ecrireInfixe() {
        ecrireInfixe(racine);
    }
    
    private void ecrireInfixe(Noeud rac) {
        if (rac != null) {
            ecrireInfixe(rac.getFg());
            System.out.println(rac.getMot());
            ecrireInfixe(rac.getFd());
        }
    }
        
    public boolean estUnABR(){
        return estUnABR(racine); // à corriger . . .
    }

    private boolean superieur(Noeud rac, String mot){
        if (hauteur(rac)==0){
            if (mot.compareTo(rac.getMot())<0){
                return false;
            }else{
                return true;
            }
        }else{
            boolean fgb=true;
            boolean fdb=true;
            if (rac.getFg()!=null){
                fgb =superieur(rac.getFg(),rac.getMot());
            }
            if (rac.getFd()!=null){
                fdb = superieur(rac.getFd(),rac.getMot());
            }
            return (fdb & fgb);
        }
    }

    private boolean inferieur(Noeud rac,String mot){
        if (hauteur(rac)==0){
            if (mot.compareTo(rac.getMot())<0){
                return true;
            }else{
                return false;
            }
        }else{
            boolean fgb=true;
            boolean fdb=true;
            if (rac.getFg()!=null){
                fgb = inferieur(rac.getFg(),rac.getMot());
            }
            if (rac.getFd()!=null){
                fdb = inferieur(rac.getFd(),rac.getMot());
            }
            return (fdb & fgb);
        }
    }

    public boolean estUnABR(Noeud rac){
        if (hauteur(rac)==0){
            return true;
        }else{
            boolean fgb = true;
            boolean fdb = true;
            if (rac.getFg()!=null){
                fgb = (superieur(rac.getFg(),rac.getMot()) && estUnABR(rac.getFg()));
            }
            if (rac.getFd()!=null){
                fdb = (superieur(rac.getFd(),rac.getMot()) && estUnABR(rac.getFd()));
            }
            return (fdb & fgb);
        }
    }

    public String leMotPlusFrequent(){
        return leMotPlusFrequent(racine);
    }

    private HashMap<String, Integer> motFrequency(Noeud rac){
        HashMap<String,Integer> motFreq = new HashMap<String,Integer>();
        if (rac!=null){
            motFreq.put(rac.getMot(),rac.getNbOcc());
            motFreq.putAll(motFrequency(rac.getFg()));
            motFreq.putAll(motFrequency(rac.getFd()));
        }
        return motFreq;
    }

    private String leMotPlusFrequent(Noeud rac){
        HashMap<String,Integer> motFreq = motFrequency(rac);
        //System.out.println(motFreq.toString());
        int freq=-10;
        String mot="";
        for (String key : motFreq.keySet()){
            if (motFreq.get(key)>freq){
                mot = key;
                freq = motFreq.get(key);
            }
        }
        return mot;
    }
}