
public class MeleeWeapon extends Item{
		
	int damage;
	public MeleeWeapon(int id, String itemName,int imageX, int imageY,int damage) {
		super(id, itemName,imageX,imageY);
		this.damage=damage;
	}
		
	public void testMethod()
	{
		System.out.println(damage);
	}
}

