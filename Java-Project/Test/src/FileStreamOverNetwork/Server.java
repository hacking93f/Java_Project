package FileStreamOverNetwork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	static ServerSocket srvsock;
	static Socket sock ;
	static DataInputStream dis;
	static DataOutputStream dos ;
	static FileInputStream fis ;
	static FileOutputStream fos ;

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		srvsock = new ServerSocket(5000);
		sock = srvsock.accept();
		dis = new DataInputStream(sock.getInputStream());
		dos = new DataOutputStream(sock.getOutputStream());
		
	    
		File tempfile = new File("newfile.txt");
		
		tempfile.createNewFile();
	    FileWriter fw = new FileWriter(tempfile);
	   
		String stringa = "ciao";
		fw.write(stringa);
		fw.close();
		fis = new FileInputStream(tempfile);
		byte[]readin = new byte[1024];
		int a = fis.read(readin);
		
		if(a>0) {
		dos.write(readin);
		}
	}

}
