// Class PolygoneColore

import java.awt.* ;
import java.util.Vector;

public class PolygoneColore extends Polygone {
    protected Color color;

    public PolygoneColore(){
        super();
    }

    public PolygoneColore(Polygone poly,Color couleur){
        super(poly);
        color = couleur;
    }
    public PolygoneColore(Point p1, Point p2, Point p3, Point p4,Color couleur){
        super(p1,p2,p3,p4);
        color = couleur;
    }

    public void colorerObjet(Graphics g){
        g.setColor(color);
    }
/*
    public void dessinerObjet(Graphics g){
        int i;
        for (i=0;i<vectP.size()-1;i++){
            ligne(g, vectP.get(i).getX(),vectP.get(i).getY(),vectP.get(i+1).getX(),vectP.get(i+1).getY());
        }
        ligne(g, vectP.get(i).getX(),vectP.get(i).getY(),vectP.get(0).getX(),vectP.get(0).getY());
    }
    */
}