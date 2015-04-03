import java.awt.Color;
import java.awt.Graphics;


public class InventoryElement extends GUIElement{

	private static boolean showMenu=false;
	private boolean clicked=false;
	private int spot;
	private int idGrabbed;
	private int locationGrabbed;
	private int mouseX,mouseY;
	private static int[] tempInventory = Player.getInventory();
	private static int spotDropped;
	
	public InventoryElement(Player player) 
	{
		super(VariablesFinal.SIZEX_OF_SCREEN-VariablesFinal.SIZEX_OF_SCREEN/5, VariablesFinal.SIZEY_OF_SCREEN/2, VariablesFinal.SIZEX_OF_SCREEN/5, VariablesFinal.SIZEY_OF_SCREEN-VariablesFinal.SIZEY_OF_SCREEN/20*13, "Inventory");
		
	}

	public void draw(Graphics g,GameClient game) {
		g.setColor(new Color(128,128,128,158));
		g.fillRect(x, y, width, height);
		
		g.setColor(Color.DARK_GRAY);
		for(int space=1;space<5;space++)
		g.drawLine(x+space*width/5, y, x+space*width/5, y+height);
		
		for(int space=0;space<5;space++)
			g.drawLine(x, y+space*width/5, x+width, y+space*width/5);
		
		
		for(int i = 0; i <tempInventory.length;i++)
		{
			if(clicked&&i==spot)
			{
				if(tempInventory[i]!=0)
				{
				locationGrabbed=i;
				ItemId.DrawItemMouse(g, i, tempInventory[i], game, mouseX, mouseY);
				idGrabbed=tempInventory[i];
				}
			}
			else if(tempInventory[i]!=0)
			{
				ItemId.DrawItemInventory(g, i,tempInventory[i], game, x, y,width,height);
			}
			
		}
	}
	
	public static void switchMenuState()
	{
		showMenu=!showMenu;
	}
	
	public boolean getMenuState()
	{
		return showMenu;
	}
	
	public void checkIfItemGrabbed(int mouseX, int mouseY)
	{
		
		locationGrabbed=-1;
		idGrabbed=0;
		spot=-1;
		
		if(mouseY>=y)
		{
		
		this.mouseX=mouseX;
		this.mouseY=mouseY;
		clicked=true;
		int mouseXSpot=(mouseX-x)/(width/5);
		int mouseYSpot=(mouseY-y)/(width/5);
		spot = 5*mouseYSpot+mouseXSpot;
		
		
		//iSystem.out.println(spot);
		}
	}
	
	public void getMouseWhileDragged(int mouseX, int mouseY)
	{
		this.mouseX=mouseX;
		this.mouseY=mouseY;
	}
	
	public void released(int mouseX,int mouseY)
	{		
		this.mouseX=mouseX;
		this.mouseY=mouseY;
		int mouseXSpot=(mouseX-x)/(width/5);
		int mouseYSpot=(mouseY-y)/(width/5);
		spotDropped = 5*mouseYSpot+mouseXSpot;
		clicked=false;

		if(spot>=0&&spotDropped>=0&&spotDropped<tempInventory.length&&mouseX>=x&&mouseY>y)
		{
			int tempSwitch=tempInventory[spotDropped];
			Player.changeInventory(spotDropped, idGrabbed);
			Player.changeInventory(spot, tempSwitch);
		}
		else if(mouseY<y&&spot>=0)
		{
			EquipedElement.giveItem(tempInventory[spot],locationGrabbed);
			//Player.changeInventory(spot, 0);
		}
			
	}
	
	public static void giveItem(int id)
	{
		if(ItemId.getItemType(id)==1)
		{
			System.out.println(tempInventory[spotDropped]+"!"+tempInventory[spotDropped-1]+"!"+tempInventory[spotDropped+1]);
		Player.changeequiped(6, tempInventory[spotDropped]);
		Player.changeInventory(spotDropped, id);
		Player.setDamage(0);
		}
		
	}
	

}
