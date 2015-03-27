import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.swing.JPanel;


public class GameClient extends JPanel implements Runnable, KeyListener,
		MouseListener, MouseMotionListener {

	private DatagramSocket socket = new DatagramSocket();
	byte[] buffer = new byte[1000];
	private InetAddress hostAddress;
	private DatagramPacket out;
	
	private Player player;
	private ArrayList<Player> mp = new ArrayList<Player>();
	private World world;
	private ListenThread listenToServer;

	public GameClient(String host, int port, String username) throws IOException {
		player = new Player(0, 0, username);
		
		hostAddress = InetAddress.getByName(host);
		//new ListenThread().start();
		
		String outString ="Login "+username;
	    buffer = outString.getBytes();
	    out = new DatagramPacket(buffer, buffer.length, hostAddress, port);
	    socket.send(out);
			
		setFocusable(true);
		// setVisible(true);
		listenToServer=new ListenThread();
		new Thread(this).start();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		GUI.makeGUIObjects(player);
		
		try {
			world = new World(player.getX(), player.getY());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 400, 400);

		world.drawWorld(player.getX(), player.getY(), g, mp);
		GUI.drawEverything(g);

		g.setColor(Color.BLACK);
		player.drawPlayer(g);
	}

	@Override
	public void run() {
		//try {
			// Receive messages one-by-one, forever
			while (true) {
				// Get the next message
				// System.out.println("blah");
				/*Player newPlayer = (Player) din.readObject();
				// System.out.println(newPlayer.isSignedIn());
				// if(!mp.contains(message)&&!message.getUserName().equals(player.getUserName()))
				boolean add = true;
				if (!newPlayer.getUserName().equals(player.getUserName())) {
					for (int i = 0; i < mp.size(); i++) {
						if (newPlayer.isSignedIn() == false
								&& mp.get(i).getUserName()
										.equals(newPlayer.getUserName())) {
							mp.remove(i);
							add = false;
							System.out.println("signedout");
						} else if (mp.get(i).getUserName()
								.equals(newPlayer.getUserName())) {
							add = false;
							if (mp.get(i).getX() != newPlayer.getX()
									|| mp.get(i).getY() != newPlayer.getY()) {
								mp.remove(i);
								add = true;

							}

						}

					}
					if (add == true) {
						mp.add(newPlayer);
					}
				}*/
				repaint();

				try {
					Thread.currentThread();
					Thread.sleep(8);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		/*} catch (IOException ie) {
			System.out.println(ie);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}

	public void sendInfo(String outString) throws IOException {
		
    	buffer = outString.getBytes();
	    out = new DatagramPacket(buffer, buffer.length, hostAddress, 4000);
	    socket.send(out);
	    System.out.println("sent");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		String packetCreate="";
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.moveRight();
			packetCreate="Move right ";
			// System.out.println(player.getX());
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.moveLeft();
			packetCreate="Move left ";
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.moveUp();
			packetCreate="Move up ";
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.moveDown();
			packetCreate="Move down ";
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// sendInfo();
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.Hit(10);
			System.out.println(player.getHealth());
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.Heal(10);
			System.out.println(player.getHealth());
			packetCreate="heal";
		}

		try {
			sendInfo(packetCreate);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// System.out.println(Variables.directionHeldX+" "+Variables.directionHeldY);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// grabbed = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}
