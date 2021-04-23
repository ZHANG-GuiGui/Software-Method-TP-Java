// Class Segment0

import java.util.Vector;

public class Segment0 {
	protected Vector<Point> vectP;
	
	public Segment0(){
		vectP = new Vector<Point>();
	}

	public Segment0(Segment0 seg){
		vectP = new Vector<Point>();
		for(Point p : seg.getVectP()){
			this.vectP.add(new Point(p));
		}
	}

	public Segment0(Point p1, Point p2){
		vectP = new Vector<Point>();
		this.vectP.add(p1);
		this.vectP.add(p2);
	}

	public Point getExtremite(int i) {
		return vectP.get(i-1);
	}
		
	public Vector<Point> getVectP() {
		return vectP;
	}
		
	public void translater(int a, int b){
		for (Point p : vectP) {
			p.translater(a,b);
		}
	}
		
	public Segment0 translaterS(int a, int b){
		for (Point p : vectP) {
			p.translater(a,b);
		}
		return new Segment0(this);
	}
		
	public void ajouterSommet(Point p) {
        this.vectP.add(new Point(p));// compléter cette méthode
	}
}
		
		
