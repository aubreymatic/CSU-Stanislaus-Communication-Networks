import java.io.*;
import java.net.*;

public class FTPServer extends Thread {
	private Socket socket;
	private DataInputStream input;
	private DataOutputStream output;

	private final String EXIT_CMD = "exit";
	private final String PUT_CMD = "put";
	private final String GET_CMD = "get";

	public FTPServer(Socket socket) {
		try {
			this.socket = socket;
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());

			// run thread
			start();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// receive a file from a client
	public void receiveFile() {

		try {
			// get file name from client
			String fileName = input.readUTF();

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

			// send messge to cient
			output.writeUTF("File sent ... done");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// send file to a client
	public void sendFile() {

		try {

			// get file name and check the file
			String fileName = input.readUTF();
			File file = new File(fileName);

			// no file exists
			if (!file.exists()) {
				output.writeUTF("NOT_FOUND");
				return;
			}

			// file exists; send the file
			output.writeUTF("READY");
			FileInputStream inFile = new FileInputStream(file);
			int ch;
			do {
				ch = inFile.read();
				output.writeUTF(String.valueOf(ch));
			} while (ch != -1);
			inFile.close();

			// send messge to cient
			output.writeUTF("File received ... done");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void run() {

		try {

			while (true) {

				// get cmd from client
				String cmd = input.readUTF();

				/* based on the cmd */
				// close ftp
				if (cmd.equals(EXIT_CMD)) {
					System.exit(0);

					// receive a file
				} else if (cmd.equals(PUT_CMD)) {
					receiveFile();

					// send a file
				} else if (cmd.equals(GET_CMD)) {
					sendFile();
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) throws Exception {

		// check parameters
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

}
