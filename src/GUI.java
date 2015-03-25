import java.awt.Graphics;


public class GUI {
	
	static HealthElement h;
	
	public static void makeGUIObjects(Player player)
	{
		h=new HealthElement();
	}
	
	public static void drawEverything(Graphics g)
	{
		h.draw(g);
	}


}
