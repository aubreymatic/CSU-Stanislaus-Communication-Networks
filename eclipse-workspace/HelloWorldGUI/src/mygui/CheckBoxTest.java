package mygui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CheckBoxTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBoxTest window = new CheckBoxTest();
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
	public CheckBoxTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInfo = new JLabel("What course do you take?");
		lblInfo.setBounds(12, 12, 194, 24);
		frame.getContentPane().add(lblInfo);
		
		JCheckBox chkbx1500 = new JCheckBox("CS1500");
		chkbx1500.setBounds(10, 44, 130, 23);
		frame.getContentPane().add(chkbx1500);
		
		JCheckBox chkbx2500 = new JCheckBox("CS2500");
		chkbx2500.setBounds(6, 82, 130, 23);
		frame.getContentPane().add(chkbx2500);
		
		JCheckBox chkbx3000 = new JCheckBox("CS3000");
		chkbx3000.setBounds(10, 116, 130, 23);
		frame.getContentPane().add(chkbx3000);
		
		JCheckBox chkbx3100 = new JCheckBox("CS3100");
		chkbx3100.setBounds(11, 158, 130, 23);
		frame.getContentPane().add(chkbx3100);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(144, 81, 115, 25);
		frame.getContentPane().add(btnCheck);
		
		JTextArea taMsg = new JTextArea();
		taMsg.setBounds(12, 207, 194, 54);
		frame.getContentPane().add(taMsg);
	}
}
