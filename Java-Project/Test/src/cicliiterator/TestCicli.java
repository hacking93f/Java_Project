package cicliiterator;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class TestCicli {
	
	
	
	
	public static void main (String args[]) {
		
		
		ArrayList<String> s = new ArrayList<String>();
		s.add("123");
		s.add("456");
		TestCicli c = new TestCicli();
		//c.stampaLista(s);
		c.stampaListaConIteratore(s);
		
	}
	
	
	
	public void stampaLista(ArrayList<String> list) {
		
		for(int a=0; a<list.size();a++) {
			
			System.out.print(list.get(a));
			
			
		}
		
	}
	
	public void stampaListaConIteratore(ArrayList list) {
		
		Iterator<String> r = list.iterator();
		int a=0;
		while(r.hasNext()) {
			
						
			String as = r.next(); 

			a++;
			System.out.print(a );
			System.out.println(as);
		}
		
		
	}

}
