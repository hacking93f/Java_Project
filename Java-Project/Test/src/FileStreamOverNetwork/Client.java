package FileStreamOverNetwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	
	static Socket sock ;
	static DataInputStream dis;
	static DataOutputStream dos ;
	FileInputStream fis ;
	
	FileWriter fw ;
	

	public static void main(String[] args){
		// TODO Auto-generated method stub

		try {
			sock = new Socket("127.0.0.1",5000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			dis = new DataInputStream(sock.getInputStream());

			dos = new DataOutputStream(sock.getOutputStream());

			byte[] received = new byte[1024];
			
			 dis.read(received);
			 FileOutputStream fos = new FileOutputStream("ricevuto.txt");
			 fos.write(received);
			 
			 fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
