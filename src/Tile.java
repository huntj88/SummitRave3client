import java.awt.Color;
import java.awt.Graphics;


public class Tile {
	
	int x;
	int y;
	Color c;
	boolean canCollide;
	public Tile(int x, int y, Color c, boolean canCollide)
	{
		this.canCollide=canCollide;
		this.x=x;
		this.y=y;
		this.c=c;
	}
	
	public void draw(Graphics g,int pX, int pY)
	{
		//only draw if it would be visible
		if(x-pX+VariablesFinal.SIZEX_OF_SCREEN/2>-VariablesFinal.SIZE_OF_TILE&&x-pX+VariablesFinal.SIZEX_OF_SCREEN/2<VariablesFinal.SIZEX_OF_SCREEN+VariablesFinal.SIZE_OF_TILE)
		{
			if(y-pY+VariablesFinal.SIZEY_OF_SCREEN/2>-VariablesFinal.SIZE_OF_TILE&&y-pY+VariablesFinal.SIZEY_OF_SCREEN/2<VariablesFinal.SIZEY_OF_SCREEN+VariablesFinal.SIZE_OF_TILE)
			{
				g.setColor(c);
				g.fillRect(x-pX+VariablesFinal.SIZEX_OF_SCREEN/2, y-pY+VariablesFinal.SIZEY_OF_SCREEN/2, VariablesFinal.SIZE_OF_TILE, VariablesFinal.SIZE_OF_TILE);
			}
		}
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean getCollide()
	{
		return canCollide;
	}

}
