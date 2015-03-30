import java.awt.Color;
import java.awt.Graphics;


public class Tile {
	
	int x;
	int y;
	Color c;	
	public Tile(int x, int y, Color c)
	{
		this.x=x;
		this.y=y;
		this.c=c;
	}
	
	public void draw(Graphics g,int pX, int pY)
	{
		g.setColor(c);
		g.fillRect(x-pX+VariablesFinal.SIZEX_OF_SCREEN/2, y-pY+VariablesFinal.SIZEY_OF_SCREEN/2, 16, 16);
	}

}
