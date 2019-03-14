import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String[] args)
		throws Exception {
		
		String sentence;
		String modifiedSentence;

		/* define stream and open socket */
		// stream to get input from keyboard
		BufferedReader keyboard = new BufferedReader(
				new InputStreamReader(System.in));

		// stream to send the input to server (socket)
		Socket socket =
			new Socket("35.235.78.62",50000);
		DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());

		// stream to get output from server
		BufferedReader fromServer =
			new BufferedReader(new InputStreamReader(socket.getInputStream()));

		/* get input */
		sentence = keyboard.readLine();

		/* send the input to server */
		toServer.writeBytes(sentence + "\n");

		/* get output from server */
		modifiedSentence = fromServer.readLine();
		System.out.println("From Server: " + modifiedSentence);
		/* close socket */
		socket.close();
	}
}
