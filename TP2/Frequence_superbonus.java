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