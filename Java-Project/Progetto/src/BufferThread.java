package src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;


// thread screenshot in attesa di connessione 
public class BufferThread extends Thread {
	
	
	

	
	
	
	BufferedImage image;
	//nuovo socket
	
	Socket sock;
	
	int clientCount=0;
	



public void run() {
	
	
	
	
	 
		while(true) {
	
	try {
		
		
		 sock = ServerFrame.srvimg.accept();
		 BufferThreadImg trimg = new BufferThreadImg(sock ,clientCount);
		 trimg.start();
		
		 clientCount++;
	} catch (IOException | InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	}
	
	
	
	
}
}
}
