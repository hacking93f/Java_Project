package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

public class LoginFrame {

    static JFrame frmLogin;
	private static JTextField textFieldnm;
	private static JPasswordField textFieldpw;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					LoginFrame.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
	
		frmLogin.getContentPane().setBackground(Color.BLACK);
		frmLogin.setUndecorated(true);
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 174, 214);
		
		SpringLayout springLayout = new SpringLayout();
		frmLogin.getContentPane().setLayout(springLayout);
		
		textFieldnm = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textFieldnm, 10, SpringLayout.WEST, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textFieldnm, -32, SpringLayout.EAST, frmLogin.getContentPane());
		frmLogin.getContentPane().add(textFieldnm);
		textFieldnm.setColumns(10);
		
		textFieldpw = new JPasswordField();
		springLayout.putConstraint(SpringLayout.EAST, textFieldpw, 0, SpringLayout.EAST, textFieldnm);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldpw, 85, SpringLayout.NORTH, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textFieldpw, 10, SpringLayout.WEST, frmLogin.getContentPane());
		frmLogin.getContentPane().add(textFieldpw);
		textFieldpw.setColumns(10);
		
		btnNewButton = new JButton("Login");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frmLogin.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String innm =textFieldnm.getText().trim();
				String inpw =textFieldpw.getText().trim();
				
				Login_System.username= innm;
				Login_System.password= inpw;
				
				
				Login_System th = new Login_System();
				th.start();
			}
		});
		frmLogin.getContentPane().add(btnNewButton);
		
		JLabel lblNomeUtente = new JLabel("Nome Utente");
		lblNomeUtente.setForeground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.NORTH, textFieldnm, 6, SpringLayout.SOUTH, lblNomeUtente);
		springLayout.putConstraint(SpringLayout.WEST, lblNomeUtente, 10, SpringLayout.WEST, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNomeUtente, -184, SpringLayout.SOUTH, frmLogin.getContentPane());
		frmLogin.getContentPane().add(lblNomeUtente);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.GREEN);
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 10, SpringLayout.WEST, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblPassword, -6, SpringLayout.NORTH, textFieldpw);
		frmLogin.getContentPane().add(lblPassword);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 12, SpringLayout.WEST, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, frmLogin.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 69, SpringLayout.WEST, frmLogin.getContentPane());
		frmLogin.getContentPane().add(btnNewButton_1);
	}
}
