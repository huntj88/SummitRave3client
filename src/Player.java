import java.awt.Graphics;
import java.io.Serializable;


public class Player{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private String userName;
	private boolean signedIn;
	private static int health=100;
	private int playerState = 1;
	
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
		//System.out.println((pX-x)+" "+(pY-y));
	}
	
	public void playerStates()
	{
		switch(playerState)
		{
			case 0: //dead
			case 1: //normal
			case 2: //other
		}
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
	
	public void Hit(int damage)
	{
		if (health>0)
			health-=damage;
		else 
		{
			playerState = 0;
			health = 0;
		}
	}
	
	public boolean fullHealth()
	{
		if (health >= 100)
		{
			health = 100;
			return true;
		}
		return false;
	}
	
	public String Heal(int healVal)
	{
		if (!fullHealth())
		{
			health+=healVal;
			return "heal "+userName+" "+healVal;
		}
		return"";
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
