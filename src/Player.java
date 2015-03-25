import java.awt.Graphics;
import java.io.Serializable;


public class Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private String userName;
	private boolean signedIn;
	private static int health=100;
	
	public Player(int x, int y, String userName)
	{
		signedIn=true;
		this.x=x;
		this.y=y;
		this.userName=userName;
	}
	
	public void drawPlayer(Graphics g)
	{
		g.fillRect(180, 180, 10, 10);
		g.drawString(userName,180, 180-10);
	}
	
	public void drawMPlayer(Graphics g, int pX, int pY) //draw other players
	{
		g.fillRect(x-pX+180, y-pY+180, 10, 10);
		System.out.println((pX-x)+" "+(pY-y));
	}
	
	public void signOut()
	{
		signedIn=false;
	}
	
	public boolean isSignedIn()
	{
		return signedIn;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public static int getHealth()
	{
		return health;
	}
	
	public void moveLeft()
	{
		x--;
	}
	public void moveRight()
	{
		x++;
	}
	
	public void moveUp()
	{
		y--;
	}
	
	public void moveDown()
	{
		y++;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public String toString()
	{
		return userName;
	}

}
