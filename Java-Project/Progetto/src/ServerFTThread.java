package src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ServerFTThread extends Thread {
	
	
	Socket sock ;
	int clientCount;
	Socket ftsock;
	static DataInputStream ftin;
	static DataOutputStream ftout;
	static ArrayList<Socket> ftlist = new ArrayList<Socket>();
	static ArrayList<Socket> FTlist = new ArrayList<Socket>();
	static DataInputStream FTin ;
	static FileOutputStream fos ;
	static FThread ft;
	ServerFTThread(Socket sock , int clientCount, Socket ftsock ) throws IOException{
		
		this.sock=sock;
		this.clientCount=clientCount;
		this.ftsock=ftsock;
		
		ftlist.add(clientCount, sock);
		FTlist.add(clientCount,ftsock);
		
		
		ftin = new DataInputStream(ftlist.get(clientCount).getInputStream());
		ftout = new DataOutputStream(ftlist.get(clientCount).getOutputStream());
		FTin = new DataInputStream(FTlist.get(clientCount).getInputStream());
		
		
		ft = new FThread();
		ft.start();
    
		
	}
	

	public void run() {
		
		
		
		System.out.println("[+]FileTransfer Ready : Server ");

		
		while(true) {
			
		try {
			
			
			String ric = ftin.readUTF();
			
			FileTransferFrame.textArea.setText(FileTransferFrame.textArea.getText().trim() + ric +"\n");
	
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}

}
