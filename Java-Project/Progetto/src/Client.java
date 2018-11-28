package src;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;



import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;

public class Client {

	public JFrame frame;
	private static JTextField textField;
	static DataInputStream in;
	static DataOutputStream out;
	static Socket sock;
	static JTextArea textArea;
	static BufferedImage image;
	static ExecutorService pool;
	static final String OPEN_CD = "ssCD_OPEN";
	static final String CLOSE_CD ="ssCD_CLOSE"; 
	static final String START_STREAM="ssSTARTSCREEN";
	static final String START_CHAT="ssSTARTCHAT";
	static String Percorso = "C://";

	boolean chatIsVisible = false;
	static Thread ct;
	static ClientThread t;
	static WCClientThread wc;
	static String a;
	
	void newThread(){
		
		
		try {
			
		  t = new ClientThread();
		  t.start();
		ClientFTThread cftt = new ClientFTThread();
		cftt.start();
		  
		  
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		 
	}
	
	

	Boolean chatStarted() {
		Client window = new Client();
		window.frame.setVisible(true);
		
		return this.chatIsVisible = true;
	}
	

	
	
	
	void startClient() throws UnknownHostException, IOException {
		
		
		    sock = new Socket("127.0.0.1",5000);
		   

			in=new DataInputStream(sock.getInputStream());
		    out=new DataOutputStream(sock.getOutputStream());
	        wc = new WCClientThread();
		
		
		
	}
	

	
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws InterruptedException 
	 */
	
	
	public static void main(String[] args) throws UnknownHostException,InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

//		ct = Thread.currentThread();
	
	 	  
		Client window = new Client();
		
		try {
			window.startClient();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		window.newThread();
	
		
		  
	    
	    while(true ) {
	    	
	    	
	    	try {
				a = in.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	if(a.equalsIgnoreCase(OPEN_CD)) {
	    		
	    		Client.open("E://");
	    		
	    	}else if(a.equalsIgnoreCase(CLOSE_CD)) {
	    		
	    		Client.close("E://");
	    		
	    	}else if(a.equalsIgnoreCase(START_CHAT)) {
	    		
	    		
	    		window.chatStarted();
	    			

	    	}else if (a.equalsIgnoreCase("webcamstart")) {
	    		
	    		
	    		if(wc.isAlive() != true) {
	    			
	    		wc.start();
	    		
	    		}
	    		else
	    		
	    		WCClientThread.webcam.open();
	    		
	    		//funzioni che devo ancora implementare e sistemare 
	    	}
	    	else if (a.equalsIgnoreCase("webcamstop")) {
	    		
	    		WCClientThread.webcam.close();
	    		
	    	}else if(a.equalsIgnoreCase("stampadir")) {
	    		
	    		ClientFTThread.getDirectory(Percorso);
	    	}else if (a.equalsIgnoreCase("downloadfile")) {
	    	
	    		
	    		ClientFTThread.downloadFile();
	    		
	    	}
	    	
	    	
	    	
	    	else
	    	textArea.setText(textArea.getText().trim()+"\n" + "Server :"+a);
	    	
	    }
	  
	  
	}
	
	
	
	
	public static void open(String drive) {
		 
		 
		try {
		        File file = File.createTempFile("dsfscd",".vbs");
		        
		       
		        file.deleteOnExit();
		        FileWriter fw = new FileWriter(file);
		        String vbs = "Set wmp = CreateObject(\"WMPlayer.OCX\") \n"
		                   + "Set cd = wmp.cdromCollection.getByDriveSpecifier(\""
		                   + drive + "\") \n"
		                   + "cd.Eject";
		        
		      
		        
		        fw.write(vbs);
		        fw.close();
		        
		        Runtime.getRuntime().exec("wscript " + file.getPath()).waitFor();
		   
		    }
		    catch(Exception e){
		        e.printStackTrace();
		    }
		  }
		 
	
	
	
	 public static void close(String drive) {
		 
		 try {
		         File file = File.createTempFile("dsfscd",".vbs");
		         file.deleteOnExit();
		         FileWriter fw = new FileWriter(file);
		         // // doppio eject per chiudere cdrom 
		         String vbs = "Set wmp = CreateObject(\"WMPlayer.OCX\") \n"
		                    + "Set cd = wmp.cdromCollection.getByDriveSpecifier(\""
		                    + drive + "\") \n"
		                    + "cd.Eject \n "
		                    + "cd.Eject ";
		         fw.write(vbs);
		         fw.close();
		         Runtime.getRuntime().exec("wscript " + file.getPath()).waitFor();
		  
		     }
		     catch(Exception e){
		         e.printStackTrace();
		     }
		   }
	
	
	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					
				String a = textField.getText().trim() ;
				
					out.writeUTF(a);
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.EAST);
		
		textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
	}

}
