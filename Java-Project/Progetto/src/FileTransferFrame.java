package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FileTransferFrame {

	JFrame frame;
	static JTextArea textArea;
	static JTextField textField;
	private JButton btnSetdirectory;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileTransferFrame window = new FileTransferFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
	}

	/**
	 * Create the application.
	 */
	public FileTransferFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 426, 704);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		textField = new JTextField();
		frame.getContentPane().add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		btnSetdirectory = new JButton("setDirectory");
		btnSetdirectory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String invia = textField.getText().trim();
				try {
					ServerFTThread.ftout.writeUTF(invia);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(btnSetdirectory, BorderLayout.EAST);
	}

}
