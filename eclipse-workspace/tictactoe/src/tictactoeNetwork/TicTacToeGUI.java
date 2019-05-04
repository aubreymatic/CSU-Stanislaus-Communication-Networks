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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToeGUI {

	private JFrame frame;
	private JTextField tfMyPort;
	private JTextField tfServer;
	private JTextField tfPort;
	private JButton btnRunServer;
	private JButton btnConnect;
	private JButton btnReplay;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	
	private JTextArea taLog;
	
	private TicTacToeClient client;
	private TicTacToeServer server;
	private boolean isClient;

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
		
		btnRunServer = new JButton("Run Server");
		btnRunServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int myPort = Integer.parseInt(tfMyPort.getText());
				
				// run server
				server = new TicTacToeServer(myPort, taLog, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
				
				isClient = false;
			}
		});
		btnRunServer.setBounds(275, 12, 115, 25);
		frame.getContentPane().add(btnRunServer);
		
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serverIP = tfServer.getText();
				int serverPort = Integer.parseInt(tfPort.getText());
				
				// run client
				client = new TicTacToeClient(serverIP, serverPort, taLog, btn1, btn2 ,btn3, btn4, btn5, btn6, btn7, btn8, btn9);
				
				isClient = true;
			}
		});
		btnConnect.setBounds(196, 53, 115, 49);
		frame.getContentPane().add(btnConnect);
		
		btnReplay = new JButton("Replay");
		btnReplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isClient) {
					client.init();
				} else {
					server.init();
				}
			}
		});
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
		
		btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(0,0);
			}
		});
		btn1.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn1);
		
		btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(0,1);
			}
		});
		btn2.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn2);
		
		btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(0,2);
			}
		});
		btn3.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn3);
		
		btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(1,0);
			}
		});
		btn4.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn4);
		
		btn5 = new JButton("");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(1,1);
			}
		});
		btn5.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn5);
		
		btn6 = new JButton("");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(1,2);
			}
		});
		btn6.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn6);
		
		btn7 = new JButton("");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doAction(2,0);
			}
		});
		btn7.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn7);
		
		btn8 = new JButton("");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(2,1);
			}
		});
		btn8.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn8);
		
		btn9 = new JButton("");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doAction(2,2);
			}
		});
		btn9.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(btn9);
		
		taLog = new JTextArea();
		taLog.setBounds(12, 338, 408, 123);
		frame.getContentPane().add(taLog);
	}
	
	public void doAction(int row, int col) {
		if (isClient) {
			if (client.changeText(row, col)) {
				client.send(row, col);
			}
		} else {
			if (server.changeText(row, col)) {
				server.send(row, col);
			}
		}
	}
}
