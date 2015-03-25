import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class World {

	Tile tile1;
	public World(int x, int y) //login location
	{
		//find chunk that needs to be loaded
		//render all tiles
		//find if new chunk needs to be loaded after moving, and if so check if old chunks need to be removed
		
		//temp tile
		tile1=new Tile(100,100,Color.BLUE);
	}
	
	public void drawWorld(int pX, int pY,Graphics g,ArrayList<Player> mp)
	{
		tile1.draw(g, pX, pY);
		
		for(int i=0;i<mp.size();i++)
		{
			//System.out.println("hi"+mp.get(i).getX()+" "+mp.size());
			mp.get(i).drawMPlayer(g,pX,pY);	
		}
	}
}
