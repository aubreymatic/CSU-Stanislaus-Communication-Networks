package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimpleCalculator {

	private JFrame frame;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JLabel lblMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator window = new SimpleCalculator();
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
	public SimpleCalculator() {
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
		
		JLabel lblNum1 = new JLabel("Number 1");
		lblNum1.setBounds(12, 12, 86, 15);
		frame.getContentPane().add(lblNum1);
		
		JLabel lblNum2 = new JLabel("Number 2");
		lblNum2.setBounds(12, 39, 86, 15);
		frame.getContentPane().add(lblNum2);
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num1, num2, ret;
				String str;
				
				// addition
				str = tfNum1.getText();
				num1 = Integer.parseInt(str);
				
				str = tfNum2.getText();
				num2 = Integer.parseInt(str);
				
				ret = num1 + num2;
				
				// set added number into lblMsg component
				lblMsg.setText(String.valueOf(ret));
			}
		});
		btnAdd.setBounds(12, 62, 78, 35);
		frame.getContentPane().add(btnAdd);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(14, 109, 406, 145);
		frame.getContentPane().add(lblMsg);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1, num2, ret;
				String str;
				
				// subtraction
				str = tfNum1.getText();
				num1 = Integer.parseInt(str);
				
				str = tfNum2.getText();
				num2 = Integer.parseInt(str);
				
				ret = num1 - num2;
				
				// set subtracted number into lblMsg component
				lblMsg.setText(String.valueOf(ret));
			}
		});
		btnSub.setBounds(106, 62, 78, 35);
		frame.getContentPane().add(btnSub);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1, num2, ret;
				String str;
				
				// multiplication
				str = tfNum1.getText();
				num1 = Integer.parseInt(str);
				
				str = tfNum2.getText();
				num2 = Integer.parseInt(str);
				
				ret = num1 * num2;
				
				// set multiplied number into lblMsg component
				lblMsg.setText(String.valueOf(ret));
			}
		});
		btnMul.setBounds(196, 62, 78, 35);
		frame.getContentPane().add(btnMul);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1, num2, ret;
				String str;
				
				// division
				str = tfNum1.getText();
				num1 = Integer.parseInt(str);
				
				str = tfNum2.getText();
				num2 = Integer.parseInt(str);
				
				ret = num1 / num2;
				
				// set divided number into lblMsg component
				lblMsg.setText(String.valueOf(ret));
			}
		});
		btnDiv.setBounds(286, 62, 78, 35);
		frame.getContentPane().add(btnDiv);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(95, 10, 124, 19);
		frame.getContentPane().add(tfNum1);
		tfNum1.setColumns(10);
		
		tfNum2 = new JTextField();
		tfNum2.setBounds(95, 37, 124, 19);
		frame.getContentPane().add(tfNum2);
		tfNum2.setColumns(10);
	}
}
