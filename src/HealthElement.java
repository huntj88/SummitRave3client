import java.awt.Color;
import java.awt.Graphics;


public class HealthElement extends GUIElement{

	private Color c = Color.RED;
	private int health;
	
	public HealthElement()
	{
		super(0, 0, 25, 100,"Health Bar");
	}
	
	public void draw(Graphics g)
	{
		g.setColor(c);
		g.fillRect(x,y,width,height);
	}
	
}
