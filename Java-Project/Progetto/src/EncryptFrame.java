package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import java.awt.Toolkit;

public class EncryptFrame {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptFrame window = new EncryptFrame();
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
	}

	/**
	 * Create the application.
	 */
	public EncryptFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(EncryptFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeLeaf.gif")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 206);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 29, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, 230, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblOutputfolder = new JLabel("InputFile");
		springLayout.putConstraint(SpringLayout.WEST, lblOutputfolder, 0, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, lblOutputfolder, -5, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, lblOutputfolder, 74, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblOutputfolder);
		
		JButton btnNewButton = new JButton("Browse");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 22, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, textField);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 48, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblOutputfolder_1 = new JLabel("OutputFolder");
		springLayout.putConstraint(SpringLayout.WEST, lblOutputfolder_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblOutputfolder_1, -6, SpringLayout.NORTH, textField_1);
		frame.getContentPane().add(lblOutputfolder_1);
		
		JButton btnNewButton_1 = new JButton("Browse");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton);
		frame.getContentPane().add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("AES");
		rdbtnNewRadioButton.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 22, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton, 0, SpringLayout.WEST, textField);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JButton btnNewButton_2 = new JButton("EncryptStart");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, rdbtnNewRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 10, SpringLayout.EAST, rdbtnNewRadioButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_2);
		
		JProgressBar progressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, progressBar, 3, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar, 14, SpringLayout.SOUTH, textField_1);
		springLayout.putConstraint(SpringLayout.EAST, progressBar, 0, SpringLayout.EAST, btnNewButton_2);
		frame.getContentPane().add(progressBar);
	}
}
