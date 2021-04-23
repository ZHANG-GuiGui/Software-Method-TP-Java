//Classe Point

public class Point {
    protected int x;
    protected int y;
    
    public Point(int a,int b) {
        x=a;
        y=b; // Constructeur d'un point ayant les coordonnées passées en paramètres
    }
    
    public Point(Point p) {
        x=p.getX();
        y=p.getY(); // Constructeur d'un point ayant les mêmes coordonnées que le point p
    }
    
    public int getX() {
        return x; // retourne l'abscisse du point
    }
    
    public int getY() {
        return y; // retourne l'ordonnée du point
    }
    
    public void translater(int a,int b) {
        x=x+a;
        y=y+b;// change les coordonnées du point
    }
    public Point translaterP(int a,int b) {
        return new Point(x+a,y+b);// crée un nouveau point (copie du point) translaté
    }
    public String toString() {
        return("abscisse : "+x+", ordonnée : "+y);
        // La méthode toString() est définie dans la classe Object dont toute classe java hérite
        // elle est redéfinie ici pour renvoyer une chaîne de caractères qui décrit bien l'objet.
    }
}