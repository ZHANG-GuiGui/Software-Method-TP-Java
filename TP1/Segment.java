// Class Segment

import java.awt.* ;
import java.util.Vector;

public class Segment extends ObjetGraphique {
	protected Vector<Point> vectP;
	
	public Segment(){
		vectP = new Vector<Point>();
	}

	public Segment(Segment seg){
		vectP = new Vector<Point>();
		for(Point p : seg.getVectP()){
			this.vectP.add(new Point(p));
		}
	}

	public Segment(Point p1, Point p2){
		vectP = new Vector<Point>();
		this.vectP.add(p1);
		this.vectP.add(p2);
	}

	public Vector<Point> getVectP() {
		return vectP;
	}
		
	public void translater(int a, int b){
		for (Point p : vectP) {
			p.translater(a,b);
		}
	}
		
	public Segment translaterS(int a, int b){
		for (Point p : vectP) {
			p.translater(a,b);
		}
		return new Segment(this);
	}
		
		public void ajouterSommet(Point P2) {
		vectP.add(new Point(P2));
	}

	public void dessinerObjet(Graphics g){
		ligne(g, vectP.get(0).getX(),vectP.get(0).getY(), vectP.get(1).getX(),vectP.get(1).getY());
        }     	

}
