import java.io.IOException;




public class ButtonQuit extends Button{

	public ButtonQuit(int x, int y, int width, int height, String text) {
		super(x, y, width, height, text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buttonFunction() {
		try {
			new Logout(Start.ip, Start.port,Start.username);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
