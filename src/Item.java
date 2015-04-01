import java.awt.Graphics;


public class Item {

	int id;
	String itemName;
	int imageX;
	int imageY;
	
	public Item(int id, String itemName,int imageX, int imageY)
	{
		this.itemName=itemName;
		this.id=id;
		this.imageX=imageX;
		this.imageY=imageY;
	}
	
	public void draw(Graphics g, int i, GameClient game, int x, int y) {
		
		int down=i/4*32;
		int sideways=i%4*32;
		g.drawImage(VariablesFinal.imageItems, sideways+x, down+y, game);
	}
	
	public int getID()
	{
		return id;
	}
}
