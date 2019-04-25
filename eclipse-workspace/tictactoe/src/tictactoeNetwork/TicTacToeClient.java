package tictactoeNetwork;

import javax.swing.*;
import java.net.*;
import java.io.*;

public class TicTacToeClient implements Runnable {

	//----------------------------------------
	// Variables
	//---------------------------------------- 

	// for tracking board 
	private String board[][];
	private int count;
	private String turn; // CIRCLE: client, CROSS: server
	
	// for P2P communication
	private Socket socket = null;
	private Thread thread = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;

	// for accessing GUI
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
	
	//---------------------------------------
	// Public Methods (including constructors)
	//---------------------------------------- 
	public void init() {
		initCommon();
		send("init");
	}
	
	public void initCommon() {
		TicTacToe.initBoard(board);
		count = 0;
		turn = TicTacToe.CIRCLE;

		enableButtons();

		btn1.setText("");
		btn2.setText("");
		btn3.setText("");
		btn4.setText("");
		btn5.setText("");
		btn6.setText("");
		btn7.setText("");
		btn8.setText("");
		btn9.setText("");
		
		taLog.setText("");
	}
	
	public TicTacToeClient(String serverIP, int serverPort, JTextArea taLog, 
			JButton btn1, JButton btn2, JButton btn3, JButton btn4,
			JButton btn5, JButton btn6, JButton btn7, JButton btn8, JButton btn9) {

		board = new String[]
	}
	
	@Override
	public void run() {

		/****************************************************
		*
		* Put Code Here
		*
		*****************************************************/

	}
	
	public boolean changeText(int row, int col) {
		return changeText(board, row, col);
	}
	
	public JButton getButton(int row, int col) {
		if (row == 0 && col == 0) {
			return btn1;
		} else if (row == 0 && col == 1) {
			return btn2;
		} else if (row == 0 && col == 2) {
			return btn3;
		} else if (row == 1 && col == 0) {
			return btn4;
		} else if (row == 1 && col == 1) {
			return btn5;
		} else if (row == 1 && col == 2) {
			return btn6;
		} else if (row == 2 && col == 0) {
			return btn7;
		} else if (row == 2 && col == 1) {
			return btn8;
		} else if (row == 2 && col == 2) {
			return btn9;
		} else {
			System.out.println("client: no button is selected");
			return null;
		}
	}
	
	public boolean changeText(String[][] board, int row, int col) {
		boolean winFlag = false;
		boolean tieFlag = false;
		
		JButton btn = getButton(row, col);
		
		// return if button has been selected
		if (btn.getText().equals(TicTacToe.CIRCLE) ||
			btn.getText().equals(TicTacToe.CROSS)) {
			return false;
		}
		
		// select button
		if (turn.equals(TicTacToe.CIRCLE)) {
			btn.setText(TicTacToe.CIRCLE);
			board[row][col] = TicTacToe.CIRCLE;
			// check winning condition
			if (TicTacToe.checkWin(board, TicTacToe.NUM_OF_ROWS, TicTacToe.NUM_OF_COLS, 
					TicTacToe.CIRCLE, row, col)) {
				winFlag = true;
			} else {
				turn = TicTacToe.CROSS;	
			}
			
			
		} else {
			btn.setText(TicTacToe.CROSS);
			board[row][col] = TicTacToe.CROSS;
			// check winning condition
			if (TicTacToe.checkWin(board, TicTacToe.NUM_OF_ROWS, TicTacToe.NUM_OF_COLS, 
					TicTacToe.CROSS, row, col)) {
				winFlag = true;
			} else {
				turn = TicTacToe.CIRCLE;	
			}
		}
		
		// check draw condition
		if (TicTacToe.checkTie(++count, TicTacToe.NUM_OF_ROWS, TicTacToe.NUM_OF_COLS)) {
			tieFlag = true;
		}
		
		// action for win, draw, and continue
		if (winFlag) {
			TicTacToe.win(turn);
			disableButtons();
		} else if (tieFlag) {
			TicTacToe.tie();
			disableButtons();
		}
		
		return true;
			
	}
	
	public void send(int row, int col) {

		/****************************************************
		*
		* Put Code Here
		*
		*****************************************************/
	}

	public void send(String cmd) {

		/****************************************************
		*
		* Put Code Here
		*
		*****************************************************/
	}

	public void disableButtons() {
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);
	}

	public void enableButtons() {
		btn1.setEnabled(true);
		btn2.setEnabled(true);
		btn3.setEnabled(true);
		btn4.setEnabled(true);
		btn5.setEnabled(true);
		btn6.setEnabled(true);
		btn7.setEnabled(true);
		btn8.setEnabled(true);
		btn9.setEnabled(true);
	}

}