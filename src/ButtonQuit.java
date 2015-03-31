


public class ButtonQuit extends Button{

	public ButtonQuit(int x, int y, int width, int height, String text) {
		super(x, y, width, height, text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buttonFunction() {
		System.exit(0);
	}

}
