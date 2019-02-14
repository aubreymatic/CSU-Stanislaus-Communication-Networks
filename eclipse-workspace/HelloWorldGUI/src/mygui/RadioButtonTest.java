package mygui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RadioButtonTest {

	private JFrame frame;
	private JLabel lblMsg;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadioButtonTest window = new RadioButtonTest();
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
	public RadioButtonTest() {
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
		
		JLabel lblInfo = new JLabel("Select your favorite color");
		lblInfo.setBounds(12, 12, 67, 15);
		frame.getContentPane().add(lblInfo);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(12, 77, 195, 23);
		frame.getContentPane().add(lblMsg);
		
		JRadioButton rdbtnBlue = new JRadioButton("Blue");
		buttonGroup.add(rdbtnBlue);
		rdbtnBlue.setBounds(12, 113, 146, 23);
		frame.getContentPane().add(rdbtnBlue);
		
		JRadioButton rdbtnRed = new JRadioButton("Red");
		buttonGroup.add(rdbtnRed);
		rdbtnRed.setBounds(26, 151, 146, 23);
		frame.getContentPane().add(rdbtnRed);
		
		JRadioButton rdbtnYellow = new JRadioButton("Yellow");
		buttonGroup.add(rdbtnYellow);
		rdbtnYellow.setBounds(35, 195, 146, 23);
		frame.getContentPane().add(rdbtnYellow);
		
		JRadioButton rdbtnWhite = new JRadioButton("White");
		buttonGroup.add(rdbtnWhite);
		rdbtnWhite.setBounds(40, 237, 146, 23);
		frame.getContentPane().add(rdbtnWhite);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnBlue.isSelected()) {
					lblMsg.setText("You selected blue");
				} else if (rdbtnRed.isSelected()) {
					lblMsg.setText("You selected red");
				} else if (rdbtnYellow.isSelected()) {
					lblMsg.setText("You selected yellow");
				} else if (rdbtnWhite.isSelected()) {
					lblMsg.setText("You selected white");
				} else {
					lblMsg.setText("You did not select any color");
				}
			}
		});
		btnCheck.setBounds(92, 42, 115, 25);
		frame.getContentPane().add(btnCheck);
	}
}
