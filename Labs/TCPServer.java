import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args)
		throws Exception {

		String clientSentence;
		String modifiedSentence;

		/* open a server socket */
		ServerSocket serverSocket = new ServerSocket(50000);
		System.out.println("Waiting...");

		while (true) {
			// open a socket for a client request
			Socket socket = serverSocket.accept();
			System.out.println("Connected to client");

			/* define stream */
			// stream to get input from client
			BufferedReader fromClient = 
				new BufferedReader(new InputStreamReader(
							socket.getInputStream()));

			// stream to send output to client
			DataOutputStream toClient = 
				new DataOutputStream(socket.getOutputStream());

			/* get input from client */
			clientSentence = fromClient.readLine();
			System.out.println("From Client: " + clientSentence);

			/* send output to client */
			modifiedSentence = 
				clientSentence.toUpperCase() + "\n";
			toClient.writeBytes(modifiedSentence);
			System.out.println("Sent: " + modifiedSentence);
		}
	}
}
