import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;


public class Player{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int drawDisplacementX = VariablesFinal.SIZEX_OF_SCREEN/2;
	private int drawDisplacementY = VariablesFinal.SIZEY_OF_SCREEN/2;
	
	private int x;
	private int y;
	private String userName;
	private boolean signedIn;
	private int health=100;
	private int playerState = 1;
	private boolean sprinting =false;
	private int speed = 4;
	
	public Player(int x, int y, String userName)
	{
		signedIn=true;
		this.x=x;
		this.y=y;
		this.userName=userName;
	}
	
	public void drawPlayer(Graphics g)
	{ //+5 on x is cause that is half the width of player square
		int stringWidth=g.getFontMetrics().stringWidth(userName);
		g.setColor(Color.BLACK);
		g.fillRect(drawDisplacementX, drawDisplacementY, 10, 10);
		g.fillRect(drawDisplacementX-stringWidth/2+5, drawDisplacementY-20, g.getFontMetrics().stringWidth(userName), 10);
		g.setColor(Color.WHITE);
		g.drawString(userName,drawDisplacementX-stringWidth/2+5, drawDisplacementY-10);
	}
	
	public void drawMPlayer(Graphics g, int pX, int pY) //draw other players
	{
		int stringWidth=g.getFontMetrics().stringWidth(userName);
		
		//player block
		g.setColor(Color.BLUE);
		g.fillRect(x-pX+drawDisplacementX, y-pY+drawDisplacementY, 10, 10);
		
		//name above player
		g.fillRect(x-pX+drawDisplacementX-stringWidth/2+5, y-pY+drawDisplacementY-20, stringWidth, 10);
		g.setColor(Color.WHITE);
		g.drawString(userName,x-pX+drawDisplacementX-stringWidth/2+5, y-pY+drawDisplacementY-10);
			
		//health bar
		g.setColor(Color.GREEN);
		g.fillRect(x-pX+drawDisplacementX-20, y-pY+drawDisplacementY-9,health/2,5);
		g.setColor(Color.BLACK);
		g.drawRect(x-pX+drawDisplacementX-20, y-pY+drawDisplacementY-10,50,6);
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
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int health)
	{
		this.health=health;
	}
	
	public void setSpeed(int speed)
	{
		this.speed=speed;
	}
	
	public void sprint()
	{
		if(sprinting==false)
		{
			speed=speed*2;
			sprinting=true;
		}
	}
	
	public void stopSprint()
	{
		if(sprinting)
		{
			speed=speed/2;
			sprinting=false;
		}
	}
	
	public String Hit(int damage)
	{
		if (health>0)
		{
			health-=damage;
			return "Health "+userName+" "+health;
		}
		else 
		{
			playerState = 0;
			health = 0;
			return "";
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
			return "Health "+userName+" "+health;
		}
		return"";
	}
	
	public void moveLeft()
	{
		x-=speed;
	}
	public void moveRight()
	{
		x+=speed;
	}
	
	public void moveUp()
	{
		y-=speed;
	}
	
	public void moveDown()
	{
		y+=speed;
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
