import java.net.*;
import java.io.*;

public class ChatServer implements Runnable
{  private ChatServerThread clients[] = new ChatServerThread[50];
   private ServerSocket server = null;
   private Thread	thread = null;
   private int clientCount = 0;
   private final String DELIMITER = ":";

   public ChatServer(int port)
   {  try
      {  System.out.println("Binding to port " + port + ", please wait ...");
	 server = new ServerSocket(port);
	 System.out.println("Server started: " + server);
	 start(); }
      catch(IOException ioe)
      {	 System.out.println("Can not bind to port " + port + ": " + ioe.getMessage()); }
   }
   public void run()
   {  while (thread != null)
      {	 try
	 {  System.out.println("Waiting for a client ...");
	    addThread(server.accept()); }
	 catch(IOException ioe)
	 {  System.out.println("Server accept error:" + ioe); stop(); }
      }
   }
   public void start()  {
     if (thread == null)
      {  thread = new Thread(this);
	 thread.start();
      }
   }
   public void stop()      {
     if (thread != null)
     {	 thread.stop();
	 thread = null;
     }
   }
   private int findClient(int ID)
   {  for (int i = 0; i < clientCount; i++)
	 if (clients[i].getID() == ID)
	    return i;
      return -1;
   }
   public synchronized void handle(int ID, String msg)
   {
      // get displayName and input
      String[] tokens = msg.split(DELIMITER);
      String displayName = tokens[0];
      String input = tokens[1];

      if (input.equals(".bye"))
      {  clients[findClient(ID)].send(msg);
	 remove(ID); }
      else
	 for (int i = 0; i < clientCount; i++)
            clients[i].send(msg);
   }
   public synchronized void remove(int ID)
   {  int pos = findClient(ID);
      if (pos >= 0)
      {  ChatServerThread toTerminate = clients[pos];
	 System.out.println("Removing client thread " + ID + " at " + pos);
	 if (pos < clientCount-1)
	    for (int i = pos+1; i < clientCount; i++)
	       clients[i-1] = clients[i];
	 clientCount--;
	 try
	 { toTerminate.close(); }
	 catch(IOException ioe)
	 {  System.out.println("Error closing thread: " + ioe); }
	 toTerminate.stop(); }      
   }
   private void addThread(Socket socket)
   {  if (clientCount < clients.length)
      {  System.out.println("Client accepted: " + socket);
	 clients[clientCount] = new ChatServerThread(this, socket);
	 try
	 {  clients[clientCount].open();
	    clients[clientCount].start();
            clientCount++; }
	 catch(IOException ioe)
	 {  System.out.println("Error opening thread: " + ioe); } }
      else
	 System.out.println("Client refused: maximum " + clients.length + " reached.");
   }
   public static void main(String args[]) {
     ChatServer server = null;
     if (args.length != 1)
	System.out.println("Usage: java ChatServer port");
     else
	server = new ChatServer(Integer.parseInt(args[0]));
   }
}
