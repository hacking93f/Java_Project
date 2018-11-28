package src;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
	
	
	Socket sock;
	static DataInputStream in;
	static DataOutputStream out;
	int clientCount;
	static ArrayList<Socket> clients = new ArrayList<Socket>();
	static BufferThread t;
	
	
	
	
	ServerThread(Socket sock ,int clientCount) throws IOException, InterruptedException{
	this.sock=sock;
	this.clientCount=clientCount;
	
	
		//arraylist
    	clients.add(clientCount, sock);
		
		
		
        //lista grafica
		ServerFrame.dlm.addElement(this.toString());
		ServerFrame.list.updateUI();
		
		
		//flusso in/out 
		System.out.println("[+]Utente connesso! :"+ clientCount);
		System.out.println("[+]Thread  :"+this);
		in=new DataInputStream(clients.get(clientCount).getInputStream());
		out= new DataOutputStream(clients.get(clientCount).getOutputStream());
	

		
    	//nuovo thread per img bufferedreader
		
				t =new BufferThread ();
//				
				t.start();
			
				
				

	}
	
	
	public void run() {
		
		
		while(true) {
			
			//devo creare le eccezzioni per il sock non connesso  o per qiando si disconnette
			
			if (sock.isConnected() != true) {
				try {
					sock.close();
					in.close();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
		
			
			try {
				
				
			//flusso input
			String a = in.readUTF();
			
				
			ServerChat.textArea.setText(ServerChat.textArea.getText().trim()+"\n" +"Client "+ clientCount+ " :" +a);
			
			
			
			}catch(IOException ex) {
				ex.printStackTrace();
			}
			
		}
		
		
		
	}
	
	
	
}
