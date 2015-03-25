import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameClient extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
	
	

	private Socket socket;
	// The streams we communicate to the server; these come
	// from the socket
	private ObjectOutputStream dout;
	private ObjectInputStream din;
	private Player player;
	private ArrayList<Player> mp = new ArrayList<Player>();
	private World world;
	
	public GameClient(String host,int port,String username)
	{
		player = new Player(0,0,username) ;
		try {
			// Initiate the connection
			socket = new Socket(host, port);
			// We got a connection! Tell the world
			System.out.println("connected to " + socket);
			// Let's grab the streams and create DataInput/Output streams
			// from them
			din = new ObjectInputStream(socket.getInputStream());
			dout = new ObjectOutputStream(socket.getOutputStream());
			// Start a background thread for receiving messages
			//new Thread(this).start();
		} catch (IOException ie) {
			System.out.println(ie);
		}	
	setFocusable( true );
	//setVisible(true);
	new Thread(this).start();
	addKeyListener(this);
	addMouseListener(this);
	addMouseMotionListener(this);
	GUI.makeGUIObjects(player);
	try {
		world = new World(player.getX(),player.getY());
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sendInfo();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 400, 400);
		
		
		world.drawWorld(player.getX(), player.getY(), g,mp);
		GUI.drawEverything(g);
		
		
		g.setColor(Color.BLACK);
		player.drawPlayer(g);		
	}
	

	@Override
	public void run() {
		try {
			//sendInfo();
			// Receive messages one-by-one, forever
			while (true) {
				// Get the next message
				//System.out.println("blah");
				Player newPlayer = (Player) din.readObject();
				//System.out.println(newPlayer.isSignedIn());
				//if(!mp.contains(message)&&!message.getUserName().equals(player.getUserName()))
				boolean add=true;
				if(!newPlayer.getUserName().equals(player.getUserName()))
				{
				for(int i=0;i<mp.size();i++)
				{
					if(newPlayer.isSignedIn()==false&&mp.get(i).getUserName().equals(newPlayer.getUserName()))
					{
						mp.remove(i);
						add=false;
						System.out.println("signedout");
					}
					else if(mp.get(i).getUserName().equals(newPlayer.getUserName()))
					{
						add=false;
						if(mp.get(i).getX()!=newPlayer.getX()||mp.get(i).getY()!=newPlayer.getY())
						{
							mp.remove(i);
							add=true;
							
						}
							
					}
					
				}
				if(add==true)
				{
					mp.add(newPlayer);
					sendInfo();
				}
				}
				repaint();
				
				try {
					Thread.currentThread();
					Thread.sleep(8);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException ie) {
			System.out.println(ie);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void sendInfo() {
		try {
			// Send it to the server
			
			dout.writeObject(player);
			dout.reset();
			// Clear out text input field
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
			{
				player.moveRight();
				//System.out.println(player.getX());
			}
			else if(e.getKeyCode()==KeyEvent.VK_LEFT) 
			{
				player.moveLeft();
			}
	
			if(e.getKeyCode()==KeyEvent.VK_UP)
			{
				player.moveUp();
			}
			else if(e.getKeyCode()==KeyEvent.VK_DOWN) 
			{
				player.moveDown();
			}
			
			if(e.getKeyCode()==KeyEvent.VK_SPACE) 
			{
				//sendInfo();
			}
			
			if(e.getKeyCode()==KeyEvent.VK_A) 
			{
				player.Hit(10);
				System.out.println(player.getHealth());
			}
			
			if(e.getKeyCode()==KeyEvent.VK_D) 
			{
				player.Heal();
				System.out.println(player.getHealth());
			}
			
			sendInfo();
		
		//System.out.println(Variables.directionHeldX+" "+Variables.directionHeldY);
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
		//grabbed = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	

}