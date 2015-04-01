
public class ItemId {
	

	static Item[] items = new Item[10];
	
	public static void buildItemID()
	{
		items[0]=null;	
		items[1]=new Sword(0,"black Sword",0,0,5);		
	}

}


/*Sword blah = (Sword) items[0];
		blah.testMethod();
		blah = (Sword) items[1];
		blah.testMethod();*/