package mygui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBoxTest {

	private JFrame frame;
	private JTextArea taMsg;
	private JCheckBox chkbx1500;
	private JCheckBox chkbx2500;
	private JCheckBox chkbx3000;
	private JCheckBox chkbx3100;
	
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
		
		chkbx1500 = new JCheckBox("CS1500");
		chkbx1500.setBounds(10, 44, 130, 23);
		frame.getContentPane().add(chkbx1500);
		
		chkbx2500 = new JCheckBox("CS2500");
		chkbx2500.setBounds(6, 82, 130, 23);
		frame.getContentPane().add(chkbx2500);
		
		chkbx3000 = new JCheckBox("CS3000");
		chkbx3000.setBounds(10, 116, 130, 23);
		frame.getContentPane().add(chkbx3000);
		
		chkbx3100 = new JCheckBox("CS3100");
		chkbx3100.setBounds(11, 158, 130, 23);
		frame.getContentPane().add(chkbx3100);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = "";
				if (chkbx1500.isSelected()) {
					msg += chkbx1500.getText() + "\n";
				}
				if (chkbx2500.isSelected()) {
					msg += chkbx2500.getText() + "\n";
				}
				if (chkbx3000.isSelected()) {
					msg += chkbx3000.getText() + "\n";
				}
				if (chkbx3100.isSelected()) {
					msg += chkbx3100.getText() + "\n";
				}
				
				taMsg.setText(msg);
			}
		});
		btnCheck.setBounds(144, 81, 115, 25);
		frame.getContentPane().add(btnCheck);
		
		taMsg = new JTextArea();
		taMsg.setBounds(12, 189, 194, 65);
		frame.getContentPane().add(taMsg);
	}
}
