package src;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;

public class ClientThread extends Thread {
	
	
	
	
	BufferedImage image;
	Socket sock;

	
	public void run() {
		
	
		
		
		
    try {
		sock = new Socket("127.0.0.1",5020);
	} catch (UnknownHostException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
  
        System.out.println("Siamo nel  buffered image thread:  client");
		
        
        
		while (true ) {
			
		try {
			
		
			
			Robot rob = new Robot();
			Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			image = rob.createScreenCapture(rec);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", baos);
			
			sock.getOutputStream().write(baos.toByteArray());
			
			
		
		} catch (IOException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
