import java.net.*;
import java.io.*;

public class FTPServer extends Thread {

	private Socket socket;
	private DataInputStream input;
	private DataOutputStream output;

	private final String EXIT_CMD = "exit";
	private final String PUT_CMD = "put";
	private final String GET_CMD = "get";

	public static void main(String[] args) throws Exception {

		// check paramters
		if (args.length != 1) {
			System.out.println("Usage: java FTPServer <port>");
			return;
		}

		int port = Integer.parseInt(args[0]);
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Waiting...");

		while (true) {

			// open a socket for a client request
			Socket socket = serverSocket.accept();
			System.out.println("Connected to client");

			FTPServer server = new FTPServer(socket);
		}
	}

	public FTPServer(Socket socket) {

		socket = socket;
		input = input;
		output = output;

		start();
	}

	public void receiveFile() {

		// write file
		File file = new File(fileName);
		FileOutputStream outFile = new FileOutputStream(file);
		String line;
		int ch;
		do {
			line = input.readUTF();
			ch = Integer.parseInt(line);
			if (ch != -1) {
				outFile.write(ch);
			}
		} while (ch != -1);
		outFile.close();
	}

	public void sendFile() {

		output.writeUTF("READY");
		FileInputStream inFile = new FileInputStream(file);
		int ch;
		do {
			ch = inFile.read();
			output.writeUTF(String.valueOf(ch));
		} while (ch != -1);
		inFile.close();
	}

	public void run() {

	}
}