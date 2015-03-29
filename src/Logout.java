import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Logout {
	
	private DatagramSocket socket = new DatagramSocket();
	byte[] buffer = new byte[1000];
	private InetAddress hostAddress;
	private DatagramPacket out;
	
	public Logout(String host, int port, String username) throws IOException {
		
		hostAddress = InetAddress.getByName(host);
		
		String outString ="Logout "+username;
	    buffer = outString.getBytes();
	    out = new DatagramPacket(buffer, buffer.length, hostAddress, port);
	    socket.send(out);
		
	}
}
