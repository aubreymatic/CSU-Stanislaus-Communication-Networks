import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoServer {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.err.println("Usage: java EchoServer <port number>");
			System.exit(1);
		}
		int portNumber = Integer.parseInt(args[0]);
		System.out.println("Server started (port " + portNumber + ")");

		try {
			// create a socket 
			DatagramSocket socket = new DatagramSocket(portNumber);

			while (true) {
				// receive request from client
				byte[] buf = new byte[256];
				byte[] outBuf = new byte[256];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);

				// process the request
				String ret = new String(packet.getData(), 0, packet.getLength());
				ret = "Hi " + ret;
				System.out.println(ret);
				outBuf = ret.getBytes();

				// send data to client
				InetAddress address = packet.getAddress();
				int port = packet.getPort();
				System.out.println("src address = " + address.getHostName());
				System.out.println("src port	= " + port);

				DatagramPacket responsePacket = new DatagramPacket(outBuf, outBuf.length, address, port);
				socket.send(responsePacket);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
