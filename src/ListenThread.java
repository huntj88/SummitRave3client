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
    ArrayList<String[]> updates = new ArrayList<String[]>();
    String username;
    
	public ListenThread(String username) throws SocketException
	{
		this.username=username;
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
				String recieved[]=new String(packet.getData(), 0, packet.getLength()).split(" ");
				boolean serverCommand=false;
				for(String server : recieved)
				{
					if(server.contains("Server"))
						serverCommand=true;
				}
				
				if(!recieved[1].equals(username)||serverCommand)
				updates.add(recieved);
				//System.out.println("From Client: "+new String(packet.getData(), 0, packet.getLength()));
				
				/*if(updates.size()>0)
				System.out.println("listen thread "+updates.get(0));*/
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    			
	    }
	}
	
	public ArrayList<String[]> getServerUpdates()
	{
		ArrayList<String[]> halfway=updates;
		//updates.clear();
		//System.out.println(halfway.size());
		return halfway;
	}
}
