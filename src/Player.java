import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;


public class Player{
	
	private int drawDisplacementX = VariablesFinal.SIZEX_OF_SCREEN/2;
	private int drawDisplacementY = VariablesFinal.SIZEY_OF_SCREEN/2;
	
	private int x;
	private int y;
	private String userName;
	private boolean signedIn;
	private int health=100;
	private int playerState = 1;
	private boolean sprinting =false;
	private int speed = 2;
	private static int damage;
	private int widthOfPlayer=VariablesFinal.SIZE_OF_TILE;
	private static int[] inventory = new int[25];
	private static int[] equiped = new int[15];
	
	public Player(int x, int y, String userName)
	{
		//inventory[0]=1;
		inventory[1]=1;
		//inventory[2]=1;
		inventory[3]=2;
		//inventory[4]=1;
		inventory[5]=3;
		inventory[6]=4;
		//inventory[7]=1;
		//inventory[8]=1;
		inventory[9]=5;
		//inventory[10]=1;
		inventory[11]=6;
		//inventory[12]=1;
		//inventory[13]=1;
		inventory[14]=7;
		inventory[15]=8;
		//inventory[16]=1;
		//inventory[17]=1;
		inventory[18]=1;
		//inventory[19]=1;
		//inventory[20]=1;
		inventory[21]=1;
		//inventory[22]=1;
		inventory[23]=1;
		//inventory[24]=1;
		signedIn=true;
		this.x=x;
		this.y=y;
		this.userName=userName;
	}
	
	public void drawPlayer(Graphics g)
	{
		int stringWidth=g.getFontMetrics().stringWidth(userName);
		g.setColor(Color.BLACK);
		g.fillRect(drawDisplacementX, drawDisplacementY, widthOfPlayer, widthOfPlayer);
		g.fillRect(drawDisplacementX-stringWidth/2+widthOfPlayer/2, drawDisplacementY-20, g.getFontMetrics().stringWidth(userName), 10);
		g.setColor(Color.WHITE);
		g.drawString(userName,drawDisplacementX-stringWidth/2+widthOfPlayer/2, drawDisplacementY-10);
	}
	
	public void drawMPlayer(Graphics g, int pX, int pY) //draw other players
	{
		int stringWidth=g.getFontMetrics().stringWidth(userName);
		
		//player block
		g.setColor(Color.BLUE);
		g.fillRect(x-pX+drawDisplacementX, y-pY+drawDisplacementY, widthOfPlayer, widthOfPlayer);
		
		//name above player
		g.fillRect(x-pX+drawDisplacementX-stringWidth/2+widthOfPlayer/2, y-pY+drawDisplacementY-20, stringWidth, 10);
		g.setColor(Color.WHITE);
		g.drawString(userName,x-pX+drawDisplacementX-stringWidth/2+widthOfPlayer/2, y-pY+drawDisplacementY-10);
			
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
	
	public int getSpeed()
	{
		return speed;
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
	
	public static void setDamage(int damage)
	{
		Player.damage=damage;
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
	
	public static int[] getInventory()
	{
		return inventory;
	}
	
	public static void changeInventory(int location, int itemId)
	{
		if(location>=0&&location<inventory.length)
		inventory[location]=itemId;
	}
	
	public static int[] getEquiped()
	{
		return equiped;
	}
	
	public static void changeequiped(int location, int itemId)
	{
		if(location>=0&&location<equiped.length)
		equiped[location]=itemId;
		System.out.println(equiped[location]);
	}
	
	public void move(boolean left,boolean right,boolean up,boolean down, World world)
	{
		if(left)
		{
			/*if(up)
			{
			}
			else if(down)
			{
			}
			else*/
			{
				if(world.isValidMove(this, 4))
				x-=speed;
			}
		}
		else if(right)
		{
			/*if(up)
			{
			}
			else if(down)
			{
			}
			else*/
			{
				if(world.isValidMove(this, 2))
				x+=speed;
			}
		}
		else if(up)
		{
			if(world.isValidMove(this, 1))
			y-=speed;
		}
		else if(down)
		{
			if(world.isValidMove(this, 3))
			y+=speed;
		}
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
