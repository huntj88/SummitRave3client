import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class MenuElement extends GUIElement{
	
private static boolean showMenu=false;
	
	public MenuElement() 
	{
		super(0, 0, VariablesFinal.SIZEX_OF_SCREEN, VariablesFinal.SIZEY_OF_SCREEN, "Pause Menu");	
	}
	
	public void draw(Graphics g) {
		
		int stringWidth=g.getFontMetrics().stringWidth("Menu shit goes here");
		
		g.setColor(new Color(128,128,128,230));
		g.fillRect(x, y, width, height);
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.setColor(Color.WHITE);
		g.drawString("Menu shit goes here", VariablesFinal.SIZEX_OF_SCREEN/2-stringWidth, VariablesFinal.SIZEY_OF_SCREEN/2);
	}
	
	public static void switchMenuState()
	{
		showMenu=!showMenu;
	}
	
	public boolean getMenuState()
	{
		return showMenu;
	}

}
