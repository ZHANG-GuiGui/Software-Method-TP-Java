// Class Rectangle

import java.awt.* ;
import java.util.Vector;

public class RectangleColore extends PolygoneColore {
    protected Vector<Point> vectP;
    protected Color color;

    public RectangleColore(){
        super();
    }

    public RectangleColore(Point a, Point b, Color couleur){
        //super(a,b);
        super(new Point(a),new Point(a.getX(),b.getY()),new Point(b),new Point(b.getX(),a.getY()),couleur);
    }

    public RectangleColore(RectangleColore rect, Color couleur){
        super(rect, couleur);
    }
}