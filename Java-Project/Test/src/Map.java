import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Map {

	

	public HashMap<Integer, String > creaMappa(){
		
		HashMap<Integer,String> mappa = new HashMap<Integer,String>();
		
		for(int a=0; a<10; a++) {
			mappa.put(a, "String" +a);
		}
		
		return mappa;
	}
	
	
	public void stampaMappa(HashMap<Integer,String> mappa) {
		
		Set<Integer> chiavi = mappa.keySet();
		Iterator<Integer> iteratoChiavi = chiavi.iterator();
		while(iteratoChiavi.hasNext()) {
			
			Integer chiave = iteratoChiavi.next();
			String valore = mappa.get(chiave);
			System.out.println(valore);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				Map mappa = new Map();
				HashMap<Integer,String> map = mappa.creaMappa();
				mappa.stampaMappa(map);

	}

}
