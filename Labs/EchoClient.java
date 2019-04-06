import java.io.*;
import java.net.*;

public class EchoClient {
	public static void main(String[] args) {

		if (args.length != 2) {
			System.err.println("Usage: java EchoClient <host name> <port number>");
			System.exit(1);
		}
		String hostName = args[0];
		int postNumber = Integer.parseInt(args[1]);
		System.out.println("java EchoClient " + hostName + " " + portNumbers);

		try {
			/* define socket and stream */
			// get a socket
			DatagramSocket socket = new DatagramSocket();

			// 
