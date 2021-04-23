// Class SegmentColore

import java.util.*;
import java.awt.* ;
import javax.swing.* ;
import java.awt.event.* ;
import java.util.Vector;

public class SegmentColore extends Segment {
	private Color color;

	public SegmentColore(){
		super();
	}


	public SegmentColore(Segment s, Color c){
		super(s);
		color = c;
	}
	
	public void colorerObjet(Graphics g){
		g.setColor(color);
	}
	/*
	public void dessinerObjet(Graphics g){
		ligne(g, vectP.get(0).getX(),vectP.get(0).getY(), vectP.get(1).getX(),vectP.get(1).getY());
    }   */
}
