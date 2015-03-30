import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;


public class Tile{
	
	int x;
	int y;
	boolean canCollide;
	int tileX;
	int tileY;
	int tileXOverlay=-5;
	int tileYOverlay=-5;
	
	public Tile(int x, int y, boolean canCollide, int tileX, int tileY)
	{
		this.canCollide=canCollide;
		this.x=x;
		this.y=y;
		this.tileX=tileX;
		this.tileY=tileY;
	}
	
	public Tile(int x, int y, boolean canCollide, int tileX, int tileY,int tileXOverlay, int tileYOverlay)
	{
		this.canCollide=canCollide;
		this.x=x;
		this.y=y;
		this.tileX=tileX;
		this.tileY=tileY;
		this.tileXOverlay=tileXOverlay;
		this.tileYOverlay=tileYOverlay;
	}
	
	public void draw(Graphics g,int pX, int pY, GameClient gameClient)
	{
		//only draw if it would be visible
		if(x-pX+VariablesFinal.SIZEX_OF_SCREEN/2>-VariablesFinal.SIZE_OF_TILE&&x-pX+VariablesFinal.SIZEX_OF_SCREEN/2<VariablesFinal.SIZEX_OF_SCREEN+VariablesFinal.SIZE_OF_TILE)
		{
			if(y-pY+VariablesFinal.SIZEY_OF_SCREEN/2>-VariablesFinal.SIZE_OF_TILE&&y-pY+VariablesFinal.SIZEY_OF_SCREEN/2<VariablesFinal.SIZEY_OF_SCREEN+VariablesFinal.SIZE_OF_TILE)
			{
				g.drawImage(VariablesFinal.imageTiles, x-pX+VariablesFinal.SIZEX_OF_SCREEN/2, y-pY+VariablesFinal.SIZEY_OF_SCREEN/2, x-pX+VariablesFinal.SIZEX_OF_SCREEN/2+VariablesFinal.SIZE_OF_TILE, y-pY+VariablesFinal.SIZEY_OF_SCREEN/2+VariablesFinal.SIZE_OF_TILE, tileX, tileY, tileX+16, tileY+16, gameClient);
				if(tileXOverlay>0)
				{
					g.drawImage(VariablesFinal.imageTiles, x-pX+VariablesFinal.SIZEX_OF_SCREEN/2, y-pY+VariablesFinal.SIZEY_OF_SCREEN/2, x-pX+VariablesFinal.SIZEX_OF_SCREEN/2+VariablesFinal.SIZE_OF_TILE, y-pY+VariablesFinal.SIZEY_OF_SCREEN/2+VariablesFinal.SIZE_OF_TILE, tileXOverlay, tileYOverlay, tileXOverlay+16, tileYOverlay+16, gameClient);
				}
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
