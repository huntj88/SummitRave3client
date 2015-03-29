import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class HealthElement extends GUIElement {

	private Color c = Color.GREEN;
	private int visibleHealth = width;
	private int tempHealth = 0;
	public final int DELAY = 25;
	Timer timer;

	public HealthElement() {
		super(5, 5, Player.getHealth(), 10, "Health Bar");
		timer = new Timer();
		timer.schedule(new UpdateYellowTask(), 0, DELAY);
	}

	public void draw(Graphics g) {
		setWidth();
		g.setColor(Color.BLACK);
		g.drawRect(x - 1, y - 1, 101, height + 1);
		g.setColor(Color.RED);
		g.fillRect(x, y, visibleHealth, height);
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, tempHealth, height);
		g.setColor(c);
		g.fillRect(x, y, width, height);

	}

	public void setWidth() {
		width = Player.getHealth();
	}

	public void syncHealth() {
		if (tempHealth <= width)
			tempHealth = width;
		else
			tempHealth--;
		System.out.print(tempHealth + " ");
	}

	public int getVisibleHealth() {
		return visibleHealth;
	}

	class UpdateYellowTask extends TimerTask {
		public void run() {
			syncHealth();
		}
	}
}
