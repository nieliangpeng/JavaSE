package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerListener implements ActionListener {
    registerFrame ret;
    public registerListener(registerFrame ret){
		this.ret=ret;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("·µ»ØµÇÂ¼")){
			ret.reLogin();
		}
	}

}
