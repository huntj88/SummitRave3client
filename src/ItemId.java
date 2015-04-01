import java.awt.Graphics;


public class ItemId {
	

	static Item[] items = new Item[10];
	
	public static void buildItemID()
	{
		items[0]=null;	
		items[1]=new Sword(0,"black Sword",0,0,5);
	}
	
	public static void DrawItemInventory(Graphics g,int spot, int id, GameClient game, int x, int y, int width, int height)
	{
		items[id].draw(g,spot,game,x,y,width, height);
	}
	
	public static void DrawItemMouse(Graphics g,int spot, int id, GameClient game, int mouseX,int mouseY)
	{
		items[id].draw(g,spot,game,mouseX,mouseY);
	}

}


/*Sword blah = (Sword) items[0];
		blah.testMethod();
		blah = (Sword) items[1];
		blah.testMethod();*/