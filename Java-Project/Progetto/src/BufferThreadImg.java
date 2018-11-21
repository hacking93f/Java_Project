package src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.imageio.ImageIO;


//thread screenshot
public class BufferThreadImg  extends Thread {
	
	Socket sock;
	
	static BufferedImage image;
	int clientCount;
	static ArrayList<Socket> vlists = new ArrayList<Socket>();
	

	BufferThreadImg(Socket sock ,int clientCount ) throws IOException, InterruptedException{
		
		this.sock=sock;
		
		this.clientCount=clientCount;
		
		
		vlists.add(clientCount, sock);
	    
		
	}
	
	public void run() {
		
if(sock.isConnected() != true ) {
			
			
			try {
				sock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	
		
			
		
			System.out.println("[+]ScreenShot Thread ready: Server");
			
			while(true) {
				try {
			//flusso input imagereader
				

			image = ImageIO.read(vlists.get(clientCount).getInputStream());
			ServerFrame.panel.getGraphics().drawImage(image, 0, 0, ServerFrame.panel.getWidth(), ServerFrame.panel.getHeight(), null);
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		
		
	}

}
