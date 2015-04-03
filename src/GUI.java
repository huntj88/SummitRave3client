import java.awt.Graphics;


public class GUI {
	
	static HealthElement healthBar;
	static MenuElement menu;
	static InventoryElement inventory;
	static EquipedElement equip;
	
	public static void makeGUIObjects(Player player)
	{
		
		healthBar=new HealthElement(player);
		menu = new MenuElement();
		inventory = new InventoryElement(player);
		equip = new EquipedElement(player,inventory.y);
		ItemId.buildItemID();
	}
	
	public static void drawEverything(Graphics g,GameClient game) //stuff thats always on the screen
	{
		healthBar.draw(g);
		drawInventory(g, game);
		drawMenu(g);
		
	}
	
	public static void drawMenu(Graphics g)
	{
		if(menu.getMenuState())
		menu.draw(g);
	}
	
	public static void drawInventory(Graphics g,GameClient game)
	{
		if(inventory.getMenuState())
		{
			inventory.draw(g,game);
			equip.draw(g, game);
		}
	}

}
