import java.awt.Color;
import java.awt.Graphics;


public class HealthElement extends GUIElement{

	private Color c = Color.RED;
	private int visibleHealth;
	
	public HealthElement()
	{
		super(5, 5, Player.getHealth(), 10,"Health Bar");
		
	}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawRect(x-1,y-1,width+1,height+1);
		g.setColor(c);
		g.fillRect(x,y,width,height);
	}
	
	public void setWidth()
	{
		width = Player.getHealth();
	}
	
	public int getVisibleHealth()
	{
		return visibleHealth;
	}
}
