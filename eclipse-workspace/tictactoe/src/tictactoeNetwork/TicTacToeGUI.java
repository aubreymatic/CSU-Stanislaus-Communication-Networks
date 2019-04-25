package tictactoeNetwork;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JTextArea;

public class TicTacToeGUI {

	private JFrame frame;
	private JTextField tfMyPort;
	private JTextField tfServer;
	private JTextField tfPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGUI window = new TicTacToeGUI();
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
	public TicTacToeGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMyPort = new JLabel("MyPort");
		lblMyPort.setBounds(12, 17, 67, 15);
		frame.getContentPane().add(lblMyPort);
		
		JLabel lblServer = new JLabel("Server");
		lblServer.setBounds(12, 44, 67, 15);
		frame.getContentPane().add(lblServer);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(12, 71, 67, 15);
		frame.getContentPane().add(lblPort);
		
		JButton btnRunServer = new JButton("Run Server");
		btnRunServer.setBounds(275, 12, 115, 25);
		frame.getContentPane().add(btnRunServer);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(196, 53, 115, 49);
		frame.getContentPane().add(btnConnect);
		
		JButton btnReplay = new JButton("Replay");
		btnReplay.setBounds(323, 53, 115, 49);
		frame.getContentPane().add(btnReplay);
		
		tfMyPort = new JTextField();
		tfMyPort.setBounds(74, 15, 189, 19);
		frame.getContentPane().add(tfMyPort);
		tfMyPort.setColumns(10);
		
		tfServer = new JTextField();
		tfServer.setBounds(74, 42, 124, 19);
		frame.getContentPane().add(tfServer);
		tfServer.setColumns(10);
		
		tfPort = new JTextField();
		tfPort.setBounds(74, 69, 124, 19);
		frame.getContentPane().add(tfPort);
		tfPort.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 117, 408, 209);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JButton btn1 = new JButton("");
		btn1.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn8);
		
		JButton btn9 = new JButton("");
		btn9.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn9);
		
		JTextArea taLog = new JTextArea();
		taLog.setBounds(12, 338, 408, 123);
		frame.getContentPane().add(taLog);
	}
}
