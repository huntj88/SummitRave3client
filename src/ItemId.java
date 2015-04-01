import java.awt.Graphics;


public class ItemId {
	

	static Item[] items = new Item[10];
	
	public static void buildItemID()
	{
		items[0]=null;	
		items[1]=new MeleeWeapon(0,"Basic Sword",0,224,5);
		items[2]=new MeleeWeapon(0,"Scimitar",32,224,5);
		items[3]=new MeleeWeapon(0,"sword 3",64,224,5);
		items[4]=new MeleeWeapon(0,"Broad sword",96,224,5);
		items[5]=new MeleeWeapon(0,"Rapier",128,224,5);
		items[6]=new MeleeWeapon(0,"sword 6",160,224,5);
		items[7]=new MeleeWeapon(0,"Sword 7",192,224,5);
		items[8]=new MeleeWeapon(0,"Sword 8",224,224,5);
		/*
		items[9]=new MeleeWeapon(0,"Basic Sword",0,224,5);
		items[10]=new MeleeWeapon(0,"Basic Sword",0,224,5);
		items[11]=new MeleeWeapon(0,"Basic Sword",0,224,5);
		*/
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