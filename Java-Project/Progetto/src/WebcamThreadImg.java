package src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


import javax.imageio.ImageIO;

public class WebcamThreadImg extends Thread {
	
	Socket sock;
	static BufferedImage image ;
	
	int clientCount ;
	
	static ArrayList<Socket> lists = new ArrayList<Socket>();
	
	
	WebcamThreadImg(Socket wcsock, int clientCount){
		
		this.sock=wcsock;
		this.clientCount = clientCount;
		
		
		lists.add(clientCount, sock);
		

		
	}
	
	

	
	public void run() {
		
		
		System.out.println("[+]Webcam Thread Ready: Server");
		System.out.println("[+]--La webcam Arraylist non è ancora sincronizzata con la list del flusso in/out--");
		System.out.println("[+]--Per il momento startare solamente la webcam del ultimo client connesso!--");
/*
 * prossimi aggiornamenti :
 * 
 * sincronizzazre la list webcam con la list in / out
 *  
 */
	
		if(sock.isConnected() != true) {
			
			
			try {
				sock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		try {
			
			
			image = ImageIO.read(lists.get(clientCount).getInputStream());
			WebcamFrame.panel.getGraphics().drawImage(image, 0, 0, WebcamFrame.panel.getWidth(), WebcamFrame.panel.getHeight(),null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
