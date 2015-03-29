import java.awt.Color;
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
		g.setColor(Color.BLACK);
		g.fillRect(180, 180, 10, 10);
		g.fillRect(180, 180-20, g.getFontMetrics().stringWidth(userName), 10);
		g.setColor(Color.WHITE);
		g.drawString(userName,180, 180-10);
	}
	
	public void drawMPlayer(Graphics g, int pX, int pY) //draw other players
	{
		g.setColor(Color.BLUE);
		g.fillRect(x-pX+180, y-pY+180, 10, 10);
		g.fillRect(x-pX+180, y-pY+180-20, g.getFontMetrics().stringWidth(userName), 10);
		g.setColor(Color.WHITE);
		g.drawString(userName,x-pX+180, y-pY+180-10);
		g.setColor(Color.GREEN);
		g.fillRect(x-pX+180, y-pY+180,health/2,5);
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
	
	public void setX(int x)
	{
		this.x=x;
	}
	
	public void setY(int y)
	{
		this.y=y;
	}
	
	public String toString()
	{
		return userName;
	}

}
