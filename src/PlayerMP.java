import java.awt.Color;
import java.awt.Graphics;
public class PlayerMP {




	
	protected int drawDisplacementX = VariablesFinal.SIZEX_OF_SCREEN/2;
	protected int drawDisplacementY = VariablesFinal.SIZEY_OF_SCREEN/2;
	
	protected int x;
	protected int y;
	protected String userName;
	protected boolean signedIn;
	protected int health=100;
	protected int widthOfPlayer=VariablesFinal.SIZE_OF_TILE;
	protected int speed = 2;
	protected int playerState = 1;	
	
	private int[] inventory = new int[25];
	private int[] equiped = new int[15];
	private int damage;
	
	
	public PlayerMP()
	{
		
	}
	
	public PlayerMP(int x, int y, String userName)
	{
		signedIn=true;
		this.x=x;
		this.y=y;
		this.userName=userName;
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
		switch(getPlayerState())
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
	
	public void setMPDamage(int damage)
	{
		this.damage=damage;
	}
	
	public int[] getMPInventory()
	{
		return inventory;
	}
	
	public void changeMPInventory(int location, int itemId)
	{
		if(location>=0&&location<inventory.length)
		inventory[location]=itemId;
	}
	
	public int[] getMPEquiped()
	{
		return equiped;
	}
	
	public void changeMPequiped(int location, int itemId)
	{
		if(location>=0&&location<equiped.length)
		equiped[location]=itemId;
		System.out.println(equiped[location]);
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

	public int getPlayerState() {
		return playerState;
	}

	public void setPlayerState(int playerState) {
		this.playerState = playerState;
	}

}
