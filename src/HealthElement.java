import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;


public class HealthElement extends GUIElement{

	private Color c = Color.RED;
	private int visibleHealth = width;
	
	public HealthElement()
	{
		super(5, 5, Player.getHealth(), 10,"Health Bar");
		
	}
	
	public void draw(Graphics g)
	{
		setWidth();
		tick();
		g.setColor(Color.BLACK);
		g.drawRect(x-1,y-1,101,height+1);
		g.setColor(Color.GREEN);
		g.fillRect(x,y,visibleHealth,height);
		g.setColor(c);
		g.fillRect(x,y,width,height);
		
	}
	
	public void setWidth()
	{
		width = Player.getHealth();
	}
	
	public void tick()
	{
		if (width < visibleHealth)
		{
			visibleHealth -= 1;
		}
		else if (width != visibleHealth) {
			   // Make sure we don't go over
			   visibleHealth = width;
			}
	}
	
	public int getVisibleHealth()
	{
		return visibleHealth;
	}
}
