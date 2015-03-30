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
		//only draw if it would be visible
		if(x-pX+VariablesFinal.SIZEX_OF_SCREEN/2>-16&&x-pX+VariablesFinal.SIZEX_OF_SCREEN/2<VariablesFinal.SIZEX_OF_SCREEN+16)
		{
			if(y-pY+VariablesFinal.SIZEY_OF_SCREEN/2>-16&&y-pY+VariablesFinal.SIZEY_OF_SCREEN/2<VariablesFinal.SIZEY_OF_SCREEN+16)
			{
				g.setColor(c);
				g.fillRect(x-pX+VariablesFinal.SIZEX_OF_SCREEN/2, y-pY+VariablesFinal.SIZEY_OF_SCREEN/2, 16, 16);
			}
		}
	}

}
