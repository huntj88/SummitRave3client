
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;



public class World {

	Tile[][] map;
	public World(int x, int y) throws FileNotFoundException //login location
	{
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
	
	public boolean isValidMove(Player player,int direction) //top = 1; goes clockwise to with number and directions. 2 is right, 3 is down, 4 is left;
	{
		
		int startArrayX=Math.abs((map[0][0].getX()-player.getX())/VariablesFinal.SIZE_OF_TILE)-1; 
		int startArrayY=Math.abs((map[0][0].getY()-player.getY())/VariablesFinal.SIZE_OF_TILE);
		if(map[startArrayX][startArrayY]!=null&&map[startArrayX][startArrayY].getCollide())
		{
			if(direction==4)
				if(player.getX()-player.getSpeed()<map[startArrayX][startArrayY].getX()+VariablesFinal.SIZE_OF_TILE)
				{
					return false;
				}
		}
		else if(map[startArrayX+2][startArrayY]!=null&&map[startArrayX+2][startArrayY].getCollide())
		{
			if(direction==2)
				if(player.getX()+player.getSpeed()+VariablesFinal.SIZE_OF_TILE>map[startArrayX+2][startArrayY].getX())
				{
					return false;
				}
		}
		
		
		
		
		
		startArrayX=Math.abs((map[0][0].getX()-player.getX())/VariablesFinal.SIZE_OF_TILE); 
		startArrayY=Math.abs((map[0][0].getY()-player.getY())/VariablesFinal.SIZE_OF_TILE)-1;
		
		if(map[startArrayX][startArrayY]!=null&&map[startArrayX][startArrayY].getCollide())
		{
			if(direction==1)
				if(player.getY()-player.getSpeed()<map[startArrayX][startArrayY].getY()+VariablesFinal.SIZE_OF_TILE)
				{
					return false;
				}
		}
		else if(map[startArrayX][startArrayY+2]!=null&&map[startArrayX][startArrayY+2].getCollide())
		{
			if(direction==3)
				if(player.getY()+player.getSpeed()+VariablesFinal.SIZE_OF_TILE>map[startArrayX][startArrayY+2].getY())
				{
					return false;
				}
		}
		
		return true;	
	}
}
