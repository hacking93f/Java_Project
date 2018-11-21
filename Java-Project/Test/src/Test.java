import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test extends Thread {
	
	
	 synchronized void dosStart(){
	 for (int a =0; a<2000;a++) {
	    	Thread t = new Thread(this);
	    	Thread f = new Thread(this);
	    t.start();
	   f.start();
	    }
	}
	
	
	public static void main(String args[]) throws IOException {
		
		
		
	   Test t = new Test();
	   t.dosStart();
		
	}
	
	public synchronized void run() {
		
		
		try {
			
			
			URL url = new URL("http://www.google.it");
			url.openStream();
			System.out.println(this+""+ url.openConnection().getInputStream());
			System.out.println(url.getHost()+""+url.getPort());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
