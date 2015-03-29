import java.awt.Graphics;


public class GUI {
	
	static HealthElement healthBar;
	static MenuElement menu;
	
	
	public static void makeGUIObjects(Player player)
	{
		healthBar=new HealthElement(player);
		menu = new MenuElement();
	}
	
	public static void drawEverything(Graphics g) //stuff thats always on the screen
	{
		healthBar.draw(g);
		drawMenu(g);
	}
	
	public static void drawMenu(Graphics g)
	{
		if(menu.getMenuState())
		menu.draw(g);
	}

}
