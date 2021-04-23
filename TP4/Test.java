import java.io.*;
import java.util.*;

public class Test {
	public static void main(String[] argv){
		Personne zxf = new Personne("Zhang","Xiaofeng",1998,true);
		Personne jcx = new Personne("Jiang","Chenxiao",1997,false);
		System.out.println(zxf.calculAge());
		System.out.println(jcx.calculAge());
		System.out.println(zxf.toString());
		System.out.println(jcx.toString());
		PersonneFamille zxfM = new PersonneFamille("Zhang","Xiaofeng",1998,true);
		PersonneFamille ije = new PersonneFamille("Ishkqp","Homeixo",1997,false);
		System.out.println(zxfM.marier(ije));
		System.out.println(zxfM.toString());
		zxfM.ajoutEnfant(jcx);
		System.out.println(zxfM.toString());
		System.out.println(ije.toString());

		Personne pere = new Personne("Shioew","Djiowxie",1970,true);
		Personne mere = new Personne("Shioew","Opeiwoxje",1972,false);

		zxf.addPere(pere);
		zxf.addMere(mere);
		jcx.addPere(pere);
		jcx.addMere(mere);
		System.out.println(zxf.toString());
		System.out.println(jcx.toString());
		System.out.println(jcx.freSoeur(zxfM));
	}
}