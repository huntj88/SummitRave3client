import java.awt.Graphics;


public class ItemId {
	

	static Item[] items = new Item[10];
	
	public static void buildItemID()
	{
		items[0]=null;	
		items[1]=new Sword(0,"black Sword",0,0,5);
	}
	
	public static void DrawItemInventory(Graphics g,int i, int id, GameClient game, int x, int y)
	{
		items[id].draw(g,i,game,x,y);
		System.out.println(i);
	}

}


/*Sword blah = (Sword) items[0];
		blah.testMethod();
		blah = (Sword) items[1];
		blah.testMethod();*/