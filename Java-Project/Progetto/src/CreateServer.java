package src;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class CreateServer {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateServer window = new CreateServer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		
	}
	
	
	public static void createServer() throws InterruptedException {
		
		 
		try {
			
			
			
		File file = File.createTempFile("Server",".java");
	    FileWriter fw = new java.io.FileWriter(file);
  String javaclass = "import java.awt.EventQueue; \n"
                   + "import java.io.DataInputStream; \n"
                   +"import java.io.DataOutputStream; \n"
                   +"import java.io.File; \n"
                   +"import java.io.FileWriter; \n"
                   +"import java.io.IOException; \n"
                   +"import java.net.Socket; \n"
                   +"import java.net.UnknownHostException; \n"
                   +"import java.util.concurrent.ExecutorService;\n"
                   +"import javax.swing.JFrame; \n"
                   +"import javax.swing.JTextField; \n"
                   +"import java.awt.BorderLayout; \n"
                   +"import javax.swing.JButton; \n"
                   +"import javax.swing.JTextArea;\n"
                    +"import java.awt.event.ActionListener; \n"
                   +"import java.awt.image.BufferedImage; \n"
                   +"import java.awt.event.ActionEvent; \n"
                   +"public class Client { \n"//class
                   +"public JFrame frame; \n"
                   +"private static JTextField textField; \n"
                   +"static DataInputStream in; \n"
                   +"static DataOutputStream out; \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                    +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                    +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n"
                   +" \n";
         
        fw.write(javaclass);
        fw.close();
        
        Runtime.getRuntime().exec("javac " + file.getPath()).waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Create the application.
	 */
	public CreateServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
