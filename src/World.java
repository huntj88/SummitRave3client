
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;



public class World {

	Tile[][] map;
	public World(int x, int y) throws FileNotFoundException //login location
	{
		//find chunk that needs to be loaded
		//render all tiles
		//find if new chunk needs to be loaded after moving, and if so check if old chunks need to be removed
		
		//temp tile
		//tile1=new Tile(100,100,Color.BLUE);
		map=LoadMap.getMap("test");
		
	}
	
	public void drawWorld(int pX, int pY,Graphics g,ArrayList<Player> mp)
	{
		//tile1.draw(g, pX, pY);
		
		for(int x=0; x<map.length;x++)
		{
			for(int y=0; y<map[0].length;y++)
			{
				if(map[x][y]!=null)
					map[x][y].draw(g, pX,pY);
			}
		}
		
		for(int i=0;i<mp.size();i++)
		{
			mp.get(i).drawMPlayer(g,pX,pY);	
		}
	}
}
