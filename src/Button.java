import java.awt.Color;
import java.awt.Graphics;


public abstract class Button {
	
	int x;
	int y;
	int width;
	int height;
	String text;
	
	public Button(int x, int y, int width, int height, String text)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.text=text;
	}
	
	public void drawButton(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		//g.fillRect(x, y, width, height);
		g.fillRoundRect(x, y, width, height, 20, 20);
		g.setColor(Color.WHITE);
		g.drawString(text, x+(width-g.getFontMetrics().stringWidth(text))/2, y+(height-g.getFontMetrics().getHeight()/3));
	}
	
	public boolean wasClicked(int mouseX, int mouseY)
	{
		if(mouseX>x&&mouseX<x+width)
		{
			if(mouseY>y&&mouseY<y+height)
				return true;
		}
		
		return false;
	}
	
	public abstract void buttonFunction();
	
}
