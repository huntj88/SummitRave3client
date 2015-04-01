import java.awt.Graphics;


public class Sword extends Item{
	
	int damage;
	public Sword(int id, String itemName,int imageX, int imageY,int damage) {
		super(id, itemName,imageX,imageY);
		this.damage=damage;
		// TODO Auto-generated constructor stub
	}
	
	public void testMethod()
	{
		System.out.println(damage);
	}

}
