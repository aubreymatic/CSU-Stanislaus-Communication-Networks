import java.io.*;
import java.net.*;

public class EchoClient {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.err.println("Usage: java EchoClient <host name> <port number>");
			System.exit(1);
		}
		String hostName = args[0];
		int portNumber = Integer.parseInt(args[1]);
		System.out.println("java EchoClient " + hostName + " " + portNumber);

		try {
			/* define socket and stream */
			// get a socket
			DatagramSocket socket = new DatagramSocket();

			// Open an input stream from user
			System.out.print("Name: ");
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

			/* socket processing */
			String userInput;
			while ((userInput = stdIn.readLine()) != null) {
				// send request
				byte[] buf = userInput.getBytes();
				InetAddress address = InetAddress.getByName(hostName);
				DatagramPacket packet = new DatagramPacket(buf, buf.length, address, portNumber);
				socket.send(packet);

				// get response
				byte[] recvBuf = new byte[256];
				DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
				socket.receive(recvPacket);

				// process the response from server
				String ret = new String(recvPacket.getData(), 0, recvPacket.getLength());
				System.out.println(ret);
			}

			// close socket
			socket.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}