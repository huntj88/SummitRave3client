import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class MenuElement extends GUIElement{
	
private static boolean showMenu=false;
private ButtonQuit quitButton = new ButtonQuit(VariablesFinal.SIZEX_OF_SCREEN/2-50,300,100,40,"Quit");;
	
	public MenuElement() 
	{
		super(0, 0, VariablesFinal.SIZEX_OF_SCREEN, VariablesFinal.SIZEY_OF_SCREEN, "Pause Menu");	
	}
	
	public void draw(Graphics g) {
		
		g.setColor(new Color(128,128,128,230));
		g.fillRect(x, y, width, height);
		g.setFont(new Font("Serif", Font.BOLD, 30));
		g.setColor(Color.WHITE);
		
		quitButton.drawButton(g);
	}
	
	public static void switchMenuState()
	{
		showMenu=!showMenu;
	}
	
	public boolean getMenuState()
	{
		return showMenu;
	}
	
	public void checkIfButtonsClicked(int mouseX, int mouseY)
	{
		if(quitButton.wasClicked(mouseX, mouseY))
		{
			quitButton.buttonFunction();
		}
		//else if() other buttons
	}
	

}
