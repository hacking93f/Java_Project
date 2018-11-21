package src;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientFTThread extends Thread {
	
	Socket cfttsock ;
	static DataOutputStream cfttout;
    static DataInputStream cfttin;
    static String p;
    Socket ftsock;
    static DataOutputStream ftout;
	public void run() {
		

		try {
		
		
			cfttsock = new Socket("127.0.0.1",5402);

			ftsock = new Socket("127.0.0.1",8765);
			
			System.out.println("Siamo nel client File transfer thread ");

			cfttin = new DataInputStream(cfttsock.getInputStream());
			cfttout = new DataOutputStream(cfttsock.getOutputStream());
			
			ftout = new DataOutputStream(ftsock.getOutputStream());
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			try {
				ClientFTThread.setPercorso();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	// metodo che dovrò implementare
	
	public static void setPercorso() throws IOException {
			
		p = cfttin.readUTF();
		Client.Percorso=p;
	}
	
	//devo ancora sistemare il metodo 
	//scarica una sola volta
	
	static void downloadFile() {
		
try {
			
			BufferedInputStream fis =new BufferedInputStream (new FileInputStream(Client.Percorso));
			
			byte[] baos = new byte[6022386];
			int a = fis.read(baos);
			while(a != -1) {
			
				ftout.flush();
			ftout.write(baos,0,a);
			
			
			
			}
			 fis.close();
        
           
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ho fatto cosi per best practice per il momento la vedo cosi 
	static void getDirectory(String dire){
		
		Client.Percorso=dire;
		File dir = new File(dire);
		if(dir.isDirectory()) {
	    File [] fil = dir.listFiles();
	    
	    for(int a=0 ; a<fil.length ; a++) {
	    	
	    	File name = fil[a];
	    	String nome = name.getName();
	    	
	    	try {
	    		
	    		
				cfttout.writeUTF("\n"+nome+"\n");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    
	    // il sender dei file
	    //purtroppo sul server devo ancora non implementare
	    // ma pensare , un metodo per ricevere file.
	    //non voglio ricorrere a creare un altro socket......
	    //anzi lo sconsiglio...
	    //quindi, per il momento cerchiamo d non far arrivare il codice"Thread"
	    //a questo else if xD please
	}else if(dir.isFile()) {
try {
	cfttout.writeUTF("Non è una directory, impossibile stampare");
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	}

}
