package src;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerChat {

	public JFrame frmServer;
	
	public static JTextField textField;
	public static JTextArea textArea;
	@SuppressWarnings("unused")
	private static boolean serverChatIsStarted = false;
	String serverChatSend = null;
	
	
	
	static Boolean serverChatIsStart() {
		
		ServerChat window = new ServerChat();
		window.frmServer.setVisible(true);
		
		return serverChatIsStarted = true;
		
		
	}
	

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerChat window = new ServerChat();
					window.frmServer.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	
	
		
		
	}

	/**
	 * Create the application.
	 */
	public ServerChat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServer = new JFrame();
		frmServer.setTitle("Server");
		frmServer.setBounds(100, 100, 450, 300);
		frmServer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textField = new JTextField();
		frmServer.getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					
					
			    	serverChatSend = textField.getText().trim();
				
					ServerThread.out.writeUTF(serverChatSend);
					
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		frmServer.getContentPane().add(btnNewButton, BorderLayout.EAST);
		textArea = new JTextArea();
		frmServer.getContentPane().add(textArea, BorderLayout.CENTER);
	}

}
