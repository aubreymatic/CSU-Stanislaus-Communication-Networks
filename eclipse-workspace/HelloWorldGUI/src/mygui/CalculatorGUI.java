package mygui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorGUI {

	private JFrame frame;
	private JTextField tfNum1;
	private JTextField tfNum2;
	private JLabel lblMsg;
	
	// define Calculator object
	private Calculator calculator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI window = new CalculatorGUI();
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
	public CalculatorGUI() {
		
		// create Calculator object
		calculator = new Calculator();
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
		
		JLabel lblNewLabel = new JLabel("Number1");
		lblNewLabel.setBounds(29, 37, 67, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number2");
		lblNewLabel_1.setBounds(29, 64, 67, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(29, 189, 361, 65);
		frame.getContentPane().add(lblMsg);
		
		tfNum1 = new JTextField();
		tfNum1.setBounds(123, 33, 124, 19);
		frame.getContentPane().add(tfNum1);
		tfNum1.setColumns(10);
		
		tfNum2 = new JTextField();
		tfNum2.setBounds(133, 62, 124, 19);
		frame.getContentPane().add(tfNum2);
		tfNum2.setColumns(10);
		
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
				
				ret = calculator.add(num1, num2);
				
				// set added number into lblMsg component
				lblMsg.setText(String.valueOf(ret));
			}
		});
		btnAdd.setBounds(26, 101, 83, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num1, num2, ret;
				String str;
				
				// get numbers
				str = tfNum1.getText();
				num1 = Integer.parseInt(str);
				
				str = tfNum2.getText();
				num2 = Integer.parseInt(str);
				
				// subtraction
				ret = calculator.subtract(num1, num2);
				
				// set result into lblMsg component
				lblMsg.setText(String.valueOf(ret));
			}
		});
		btnSub.setBounds(122, 101, 83, 25);
		frame.getContentPane().add(btnSub);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1, num2, ret;
				String str;
				
				// get numbers
				str = tfNum1.getText();
				num1 = Integer.parseInt(str);
				
				str = tfNum2.getText();
				num2 = Integer.parseInt(str);
				
				// multiplication
				ret = calculator.multiply(num1, num2);
				
				// set result into lblMsg component
				lblMsg.setText(String.valueOf(ret));
			}
		});
		btnMul.setBounds(217, 101, 83, 25);
		frame.getContentPane().add(btnMul);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1, num2, ret;
				String str;
				
				// get numbers
				str = tfNum1.getText();
				num1 = Integer.parseInt(str);
				
				str = tfNum2.getText();
				num2 = Integer.parseInt(str);
				
				// division
				ret = calculator.divide(num1, num2);
				
				// set result into lblMsg component
				lblMsg.setText(String.valueOf(ret));
			}
		});
		btnDiv.setBounds(307, 101, 83, 25);
		frame.getContentPane().add(btnDiv);
	}
}
