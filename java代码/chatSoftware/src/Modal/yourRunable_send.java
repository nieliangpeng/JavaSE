package Modal;

import java.io.IOException;

import UI.yourJframe;

public class yourRunable_send implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String send = "";
		send=yourJframe.input.getText();
	    try {
			yourRunable.writers.write(send);
			yourRunable.writers.flush();
			System.out.println("you已经发送");
//			String sendText=yourJframe.input.getText();
			yourJframe.input.setText("");
//			yourJframe.chatText.append("我："+sendText+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		//writers.flush();
	}

}
