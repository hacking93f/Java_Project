package src;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

public class WCClientThread extends Thread {

	static  Socket WCSock; 
static Webcam webcam;

WCClientThread(){
	
	try {
		WCSock = new Socket("127.0.0.1",6000);
	} catch (UnknownHostException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}
	
public void run() {
	
	
	
	System.out.println("Siamo nel img Webcam thread Runned: client");

	
	
	 try {
		
		 //ci metto un break per stoppare sta cazzo di webcam??
		while(true) {
		
	webcam = Webcam.getDefault();
	webcam.open();
	BufferedImage image = webcam.getImage();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, "jpg", baos );
   	WCSock.getOutputStream().write(baos.toByteArray());
   
		 }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
