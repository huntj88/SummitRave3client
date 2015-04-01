import java.awt.Color;
import java.awt.Graphics;


public class InventoryElement extends GUIElement{

	private static boolean showMenu=false;
	private boolean clicked=false;
	private int spot;
	private int idGrabbed;
	private int mouseX,mouseY;
	private int[] tempInventory = Player.getInventory();
	
	public InventoryElement(Player player) 
	{
		super(VariablesFinal.SIZEX_OF_SCREEN-VariablesFinal.SIZEX_OF_SCREEN/5, 0+VariablesFinal.SIZEY_OF_SCREEN/5, VariablesFinal.SIZEX_OF_SCREEN/5, VariablesFinal.SIZEY_OF_SCREEN-VariablesFinal.SIZEY_OF_SCREEN/5*2+5, "Inventory");
		
	}

	public void draw(Graphics g,GameClient game) {
		g.setColor(new Color(128,128,128,158));
		g.fillRect(x, y, width, height);
		
		
		for(int i = 0; i <tempInventory.length;i++)
		{
			if(clicked&&i==spot)
			{
				ItemId.DrawItemMouse(g, i, tempInventory[i], game, mouseX, mouseY);
				idGrabbed=tempInventory[i];
			}
			else if(tempInventory[i]!=0)
			{
				ItemId.DrawItemInventory(g, i,tempInventory[i], game, x, y+VariablesFinal.SIZEY_OF_SCREEN/4,width,height);
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
		this.mouseX=mouseX;
		this.mouseY=mouseY;
		clicked=true;
		int mouseXSpot=(mouseX-x)/(width/5);
		int mouseYSpot=(mouseY-y-VariablesFinal.SIZEY_OF_SCREEN/4)/(width/5);
		spot = 5*mouseYSpot+mouseXSpot;
		
		
		System.out.println(spot);
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
		int mouseYSpot=(mouseY-y-VariablesFinal.SIZEY_OF_SCREEN/4)/(width/5);
		int spotDropped = 5*mouseYSpot+mouseXSpot;
		clicked=false;

		int tempSwitch=tempInventory[spotDropped];
		Player.changeInventory(spotDropped, idGrabbed);
		Player.changeInventory(spot, tempSwitch);
	}
	

}
