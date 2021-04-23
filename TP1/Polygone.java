// Class Polygone

import java.awt.* ;
import java.util.Vector;

public class Polygone extends ObjetGraphique {
    protected Vector<Point> vectP;

    public Polygone(){
        vectP = new Vector<Point>();
    }

    public Polygone(Polygone poly){
        vectP = new Vector<Point>();
        for(Point p : poly.getVectP()){
            this.vectP.add(new Point(p));
        }
    }

    public Polygone(Point p1, Point p2, Point p3, Point p4){
        vectP = new Vector<Point>();
        this.vectP.add(p1);
        this.vectP.add(p2);
        this.vectP.add(p3);
        this.vectP.add(p4);
    }

    public Vector<Point> getVectP() {
        return vectP;
    }

    public void translater(int a, int b){
        for (Point p : vectP) {
            p.translater(a,b);
        }
    }

    public void ajouterSommet(Point p) {
        vectP.add(new Point(p));
    }

    public void dessinerObjet(Graphics g){
        int i;
        //System.out.println(vectP.size());
        for (i=0;i<vectP.size()-1;i++){
            ligne(g, vectP.get(i).getX(),vectP.get(i).getY(),vectP.get(i+1).getX(),vectP.get(i+1).getY());
            //System.out.println(i);
        }
        //i = vectP.size()-1;
        //System.out.println(i);
        ligne(g, vectP.get(i).getX(),vectP.get(i).getY(),vectP.get(0).getX(),vectP.get(0).getY());
    }
}