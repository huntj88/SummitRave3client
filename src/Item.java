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
	
	public void draw(Graphics g) {
	}
}
