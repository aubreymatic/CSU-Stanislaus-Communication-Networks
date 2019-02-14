package mygui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HelloWorldGUI {

	private JFrame frame;
	private JTextField tfName;
	private JLabel lblMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorldGUI window = new HelloWorldGUI();
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
	public HelloWorldGUI() {
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
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(37, 45, 67, 15);
		frame.getContentPane().add(lblNewLabel);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(37, 125, 236, 64);
		frame.getContentPane().add(lblMsg);
		
		tfName = new JTextField();
		tfName.setBounds(106, 43, 124, 19);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		JButton btnHi = new JButton("Hi");
		btnHi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = tfName.getText();
				lblMsg.setText("Hi " + name);
			}
		});
		btnHi.setBounds(37, 72, 115, 25);
		frame.getContentPane().add(btnHi);
	}
}
