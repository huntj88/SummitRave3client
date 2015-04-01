import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Start implements ActionListener{

	
	static int port = 4000;
	static String ip="127.0.0.1";
	static String username;
	
	public static void main(String[] args) {
	
		
		
		JFrame f = new JFrame("run");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/*GameClient g = new GameClient("127.0.0.1", port,"hi");
		f.add(g);*/
		
		JTextField user = new JTextField("Username");
		user.requestFocus();
		user.selectAll();
		JPasswordField pass = new JPasswordField("Password");
		JButton login = new JButton("Login");
		f.setLayout(new BorderLayout());
		f.add(user, BorderLayout.NORTH);
		f.add(pass, BorderLayout.CENTER);
		f.add(login, BorderLayout.SOUTH);			
		f.setSize(200,110);
		f.setVisible(true);
		
		
		ActionListener loginAction =(new ActionListener(){

		     public void actionPerformed(ActionEvent e){
		         //Check login stuff here... 
		    	 f.setVisible(false);
		    	 //f
		         //with maybe something like this?
		    	 username=user.getText();
		         char[] sPass = pass.getPassword();
		         //Then compare with some other string/data you already have saved somewhere...
		         f.remove(login);
		         f.remove(user);
		         f.remove(pass);
		         JFrame gameFrame = new JFrame();
		         gameFrame.setUndecorated(true);
		         gameFrame.setSize(VariablesFinal.SIZEX_OF_SCREEN,VariablesFinal.SIZEY_OF_SCREEN);
		        
		         
		 		GameClient g = null;
				try {
					g = new GameClient(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gameFrame.add(g);
				gameFrame.setVisible(true);
		     }
		});
		user.addActionListener(loginAction);
		login.addActionListener(loginAction);
		
		f.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
