package src;

import java.io.IOException;
import java.net.Socket;

public class ServerAttendiFTThread extends Thread {

	
	Socket sock ;
	Socket ftsock;
	int clientCount = -1;
	

	
	public void run() {
		
		
		
		while(true) {
		try {
			sock = ServerFrame.fTSock.accept();
			ftsock = ServerFrame.FTsock.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clientCount ++;
		
		try {
			ServerFTThread sftt = new ServerFTThread(sock , clientCount , ftsock);
			sftt.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		}
		
	}

}
