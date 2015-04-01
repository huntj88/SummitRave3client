import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
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

	public GameClient(String username) throws IOException {
		
		VariablesFinal.imageTiles= ImageIO.read(new File("res/roguelikeSheet_transparent.png"));
		
		player = new Player(0, 0, username);
		
		hostAddress = InetAddress.getByName(Start.ip);
		//new ListenThread().start();
		
		String outString ="Login "+username;
	    buffer = outString.getBytes();
	    out = new DatagramPacket(buffer, buffer.length, hostAddress, Start.port);
	    socket.send(out);
			
		setFocusable(true);
		// setVisible(true);
		listenToServer=new ListenThread(username);
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
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, VariablesFinal.SIZEX_OF_SCREEN, VariablesFinal.SIZEY_OF_SCREEN);

		world.drawWorld(player.getX(), player.getY(), g, mp,this);
		
		g.setColor(Color.BLACK);
		player.drawPlayer(g);
		
		GUI.drawEverything(g);
	}

	@Override
	public void run() {
		//try {
			// Receive messages one-by-one, forever
			while (true) {
				
				ArrayList<String[]> updates = listenToServer.getServerUpdates();
				if(updates.size()>0)
				{
					for(String[] splitData : updates)
					{
						
						boolean serverCommand=false;
						for(String server : splitData)
						{
							if(server.contains("Server"))
								serverCommand=true;
						}
						//String[] splitData=data.split(" ");
						
						//if the user is someone else update that user on this clients screen, else just ignore. no point in the client updating itself with its own data
						//if(splitData.length>1&&!splitData[1].equals(player.getUserName()))
						{
							
							if(splitData[0].equals("Login")&&!serverCommand)
					    	{
					    		login(splitData[1]);
					    	}
							else if(splitData[0].equals("Logout")&&!serverCommand)
							{
								logout(splitData[1]);
							}
							else if(splitData[0].equals("Move"))
							{
								if(serverCommand&&splitData[1].equals(player.getUserName()))
								{
									player.setX(Integer.parseInt(splitData[2]));
									player.setY(Integer.parseInt(splitData[3]));
								}
								else
								{
									boolean loggedIn=false;
									for(Player test:mp)
									{
										if(splitData[1].equals(test.getUserName()))
										{
											test.setX(Integer.parseInt(splitData[2]));
											test.setY(Integer.parseInt(splitData[3]));
											loggedIn=true;
											break;
										}
									
									}
									if(loggedIn==false)
										login(splitData[1]);
								}
							}
							else if(splitData[0].equals("Health"))
							{
							
								if(serverCommand&&splitData[1].equals(player.getUserName()))
								{
									player.setHealth(Integer.parseInt(splitData[2]));
								}
								else
								{
									boolean loggedIn=false;
									for(Player test:mp)
									{
										if(splitData[1].equals(test.getUserName()))
										{
											test.setHealth(Integer.parseInt(splitData[2]));
											loggedIn=true;
											break;
										}
									
									}
									if(loggedIn==false)
										login(splitData[1]);
								}
							}
							//System.out.println(mp.size());
						}
						
						//System.out.println(data);
					}
				}
				listenToServer.updates.clear();
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
	
	public void login(String name)
	{
    		boolean add=true;
    		for(Player test : mp)
    		{
    			if(test.getUserName().equals(name))
    			add=false;
    			
    		}
    		if(add)
    		{
    		mp.add(new Player(0,0,name));
    		System.out.println("player added");
    		}
	}
	
	public void logout(String name)
	{
		Iterator<Player> i = mp.iterator();
		while (i.hasNext())
		{
			
			if(i.next().getUserName().equals(name))
			{
				i.remove();
				System.out.println(name+" has logged off");
				break;
			}
		}
	}

	public void sendInfo(String outString) throws IOException {
		
    	buffer = outString.getBytes();
	    out = new DatagramPacket(buffer, buffer.length, hostAddress, 4000);
	    socket.send(out);
	    //System.out.println("sent");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		String packetCreate="";
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(world.isValidMove(player,2))
			{
				player.moveRight();
				packetCreate="Move "+player.getUserName()+" "+player.getX()+" "+player.getY();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(world.isValidMove(player,4))
			{
				player.moveLeft();
				packetCreate="Move "+player.getUserName()+" "+player.getX()+" "+player.getY();
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if(world.isValidMove(player,1))
			{
				player.moveUp();
				packetCreate="Move "+player.getUserName()+" "+player.getX()+" "+player.getY();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(world.isValidMove(player,3))
			{
				player.moveDown();
				packetCreate="Move "+player.getUserName()+" "+player.getX()+" "+player.getY();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			player.sprint();
			// sendInfo();
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			packetCreate=player.Hit(10);
			//System.out.println(player.getHealth());
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {		
			packetCreate=player.Heal(10);
			//System.out.println(player.getHealth());
		}
		
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {		
			MenuElement.switchMenuState();
		}

		try {
			if(!packetCreate.equals(""))
			sendInfo(packetCreate);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// System.out.println(Variables.directionHeldX+" "+Variables.directionHeldY);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			player.stopSprint();;
			// sendInfo();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		GUI.menu.checkIfButtonsClicked(e.getX(), e.getY());
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
