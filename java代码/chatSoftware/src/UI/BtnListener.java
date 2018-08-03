package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class BtnListener implements ActionListener {
	LoginFrame loginFrame;
	public BtnListener(LoginFrame loginFrame){
		this.loginFrame=loginFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("µÇÂ¼")){
			try {
				loginFrame.login();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getActionCommand().equals("×¢²á")){
			loginFrame.register();
		}

	}

}

