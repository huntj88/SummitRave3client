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
	
	public void draw(Graphics g, int i, GameClient game, int x, int y, int width, int height) {
		
		int down=i/5*width/5;
		int sideways=i%5*width/5;
		//g.drawImage(VariablesFinal.imageItems, sideways+x, down+y, game);
		g.drawImage(VariablesFinal.imageItems, sideways+x, down+y, sideways+x+width/5, down+y+width/5, 0, 0, 32, 32, game);
	}
	
	public void draw(Graphics g, int i, GameClient game, int x, int y) {
		//g.drawImage(VariablesFinal.imageItems, sideways+x, down+y, game);
		g.drawImage(VariablesFinal.imageItems, x-VariablesFinal.SIZE_OF_TILE/2, y-VariablesFinal.SIZE_OF_TILE/2, x+VariablesFinal.SIZE_OF_TILE, y+VariablesFinal.SIZE_OF_TILE, 0, 0, 32, 32, game);
	}
	
	public int getID()
	{
		return id;
	}
}
