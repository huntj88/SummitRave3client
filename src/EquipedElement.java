import java.awt.Color;
import java.awt.Graphics;
import java.io.ObjectInputStream.GetField;


public class EquipedElement extends GUIElement{

	private int mouseX,mouseY;
	private int idGrabbed;
	private boolean clicked=false;
	private int spot;
	static int spotDropped;
	private static int[] tempEquiped = Player.getEquiped();
	
	public EquipedElement(Player player, int y) 
	{
		super(VariablesFinal.SIZEX_OF_SCREEN-VariablesFinal.SIZEX_OF_SCREEN/5, VariablesFinal.SIZEY_OF_SCREEN/5, VariablesFinal.SIZEX_OF_SCREEN/5,y-VariablesFinal.SIZEY_OF_SCREEN/5, "equip");
	}
	

	public void draw(Graphics g,GameClient game) {
		g.setColor(new Color(128,128,128,158));
		g.fillRect(x, y, width, height);
		
		g.setColor(Color.DARK_GRAY);
		/*for(int space=1;space<5;space++)
		g.drawLine(x+space*width/5, y, x+space*width/5, y+height);
		
		for(int space=1;space<5;space++)
			g.drawLine(x, y+space*width/5, x+width, y+space*width/5);*/
		//if(tempEquiped[0]!=0)
		//ItemId.DrawItemInventory(g, 7,tempEquiped[0], game, x, y,width,height);
		
		for(int i = 0; i <tempEquiped.length;i++)
		{
			if(clicked&&i==spot&&mouseX>=x)
			{
				if(tempEquiped[i]!=0)
				{
				ItemId.DrawItemMouse(g, i, tempEquiped[i], game, mouseX, mouseY);
				idGrabbed=tempEquiped[i];
				}
			}
			else if(tempEquiped[i]!=0)
			{
				ItemId.DrawItemInventory(g, i,tempEquiped[i], game, x, y,width,height);
			}
			
		}

	}
	
	
	public void checkIfItemGrabbed(int mouseX, int mouseY)
	{
		idGrabbed=0;
		this.mouseX=mouseX;
		this.mouseY=mouseY;
		clicked=true;
		int mouseXSpot=(mouseX-x)/(width/5);
		int mouseYSpot=(mouseY-y)/(width/5);
		spot = 5*mouseYSpot+mouseXSpot;
		spotDropped=1000;
	}
	
	public void getMouseWhileDragged(int mouseX, int mouseY)
	{
		this.mouseX=mouseX;
		this.mouseY=mouseY;
	}
	
	public void released(int mouseX,int mouseY)
	{	
		
		clicked=false;
		this.mouseX=mouseX;
		this.mouseY=mouseY;
		int mouseXSpot=(mouseX-x)/(width/5);
		int mouseYSpot=(mouseY-y)/(height/5);
		spotDropped = 5*mouseYSpot+mouseXSpot;

		/*if(spot<tempEquiped.length&&spotDropped>=0&&spotDropped<tempEquiped.length&&mouseX>=x)
		{
			int tempSwitch=tempEquiped[spotDropped];
			Player.changeequiped(spotDropped, idGrabbed);
			Player.changeequiped(spot, tempSwitch);
		}*/
		
		if(mouseY>y+height&&spot<=15)
		{
			InventoryElement.giveItem(tempEquiped[spot]);
			//Player.changeInventory(spot, 0);
		}
	}
	
	public static void giveItem(int id,int location)
	{
		if(ItemId.getItemType(id)==1)
		{
		Player.changeInventory(location, tempEquiped[6]);
		Player.changeequiped(6, id);		
		Player.setDamage(ItemId.getWeaponDamage(id));
		}
		
	}
	

}
