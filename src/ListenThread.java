import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ListenThread extends Thread{

	int PORT = 4001;
    byte[] buf = new byte[1000];
    DatagramSocket socket;
    DatagramPacket packet;
    
	public ListenThread() throws SocketException
	{
		socket = new DatagramSocket(PORT);
		packet = new DatagramPacket(buf, buf.length);
		start();
	}
	
	public void run()
	{
		System.out.println("Client Listening");
		while(true)
	    {
	    	try {
				socket.receive(packet);
				System.out.println("From Client: "+new String(packet.getData(), 0, packet.getLength()));
				
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    			
	    }
	}
}
