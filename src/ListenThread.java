import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

public class ListenThread extends Thread{

	int PORT = 4001;
    byte[] buf = new byte[1000];
    DatagramSocket socket;
    DatagramPacket packet;
    ArrayList<String> updates = new ArrayList<String>();
    
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
				updates.add(new String(packet.getData(), 0, packet.getLength()));
				//System.out.println("From Client: "+new String(packet.getData(), 0, packet.getLength()));
				
				/*if(updates.size()>0)
				System.out.println("listen thread "+updates.get(0));*/
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    			
	    }
	}
	
	public ArrayList<String> getServerUpdates()
	{
		ArrayList<String> halfway=updates;
		//updates.clear();
		//System.out.println(halfway.size());
		return halfway;
	}
}
