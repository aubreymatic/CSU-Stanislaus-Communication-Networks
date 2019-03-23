package tcpclientgui;

import java.awt.EventQueue;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class TCPClientGUI {

	private JFrame frame;
	private JTextField tfServer;
	private JTextField tfPort;
	private JTextField tfSentence;
	private JLabel lblMsg;
	
	private String getSentence(String server, int port, String sentence) {
		
		String modifiedSentence = "";
		
		try {
			/* define stream and open socket */
			// stream to send the input to server (socket)
			Socket socket =
				new Socket(server, port);
			DataOutputStream toServer = new DataOutputStream(
					socket.getOutputStream());
			
			// stream to get output from server
			BufferedReader fromServer =
					new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
			
			/* send the input to server */
			toServer.writeBytes(sentence + "\n");
			
			/* get output from server */
			modifiedSentence = fromServer.readLine();
			System.out.println("From Server: " +
								modifiedSentence);
			
			/* close socket */
			socket.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return modifiedSentence;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TCPClientGUI window = new TCPClientGUI();
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
	public TCPClientGUI() {
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
		
		JLabel lblServer = new JLabel("Server");
		lblServer.setBounds(12, 24, 67, 15);
		frame.getContentPane().add(lblServer);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(12, 51, 67, 15);
		frame.getContentPane().add(lblPort);
		
		JLabel lblSentence = new JLabel("Sentence");
		lblSentence.setBounds(12, 78, 67, 15);
		frame.getContentPane().add(lblSentence);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(12, 180, 426, 74);
		frame.getContentPane().add(lblMsg);
		
		JButton btnCapitalize = new JButton("Capitalize");
		btnCapitalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String server = tfServer.getText();
				int port = Integer.parseInt(tfPort.getText());
				String sentence = tfSentence.getText();
				
				lblMsg.setText(getSentence(server, port, sentence));
			}
		});
		btnCapitalize.setBounds(21, 125, 115, 25);
		frame.getContentPane().add(btnCapitalize);
		
		tfServer = new JTextField();
		tfServer.setBounds(118, 22, 124, 19);
		frame.getContentPane().add(tfServer);
		tfServer.setColumns(10);
		
		tfPort = new JTextField();
		tfPort.setBounds(118, 49, 124, 19);
		frame.getContentPane().add(tfPort);
		tfPort.setColumns(10);
		
		tfSentence = new JTextField();
		tfSentence.setBounds(118, 76, 124, 19);
		frame.getContentPane().add(tfSentence);
		tfSentence.setColumns(10);
	}
}
