import java.awt.Graphics;




public abstract class GUIElement {
	
	protected int x;
	protected int y;
	protected String nameOfElement=null;
	protected int height;
	protected int width;
	
	public GUIElement(int x, int y, int width, int height, String nameOfElement)
	{
		this.x=x;
		this.y=y;
		this.nameOfElement=nameOfElement;
		this.height=height;
		this.width=width;
	}
	
	

}
