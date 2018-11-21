package src;

import java.io.IOException;
import java.net.Socket;



//thread attesa connessioni webcam



public class WebcamThread extends Thread{
	
	Socket sock;
	int clientCount= 0;
	
	public void run() {
		
	

		
		while (true) {
		try {
			sock = ServerFrame.WCSSock.accept();
			WebcamThreadImg wcti = new WebcamThreadImg(sock , clientCount);
			wcti.start();
			clientCount++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
}
}
