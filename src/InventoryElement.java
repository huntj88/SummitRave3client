import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class InventoryElement extends GUIElement{

	private static boolean showMenu=false;
	
	public InventoryElement(Player player) 
	{
		super(VariablesFinal.SIZEX_OF_SCREEN-VariablesFinal.SIZEX_OF_SCREEN/5, 0+VariablesFinal.SIZEY_OF_SCREEN/5, VariablesFinal.SIZEX_OF_SCREEN/5, VariablesFinal.SIZEY_OF_SCREEN-VariablesFinal.SIZEY_OF_SCREEN/5*2, "Inventory");
		
	}

	public void draw(Graphics g,GameClient game) {
		g.setColor(new Color(128,128,128,158));
		g.fillRect(x, y, width, height);
		
		int[] tempInventory = Player.getInventory();
		for(int i = 0; i <24;i++)
		{
			if(tempInventory[i]!=0)
			{
				ItemId.DrawItemInventory(g, i,tempInventory[i], game, x, y);
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
	

}
