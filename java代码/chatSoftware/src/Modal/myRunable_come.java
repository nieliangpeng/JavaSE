package Modal;

import java.io.IOException;

import UI.myJframe;

public class myRunable_come implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			// System.out.println("first");
			char[] c = new char[30];
			// System.out.println("first3");
			myRunable.reader.read(c);
			// System.out.println("first2");
			String rSend = new String(c).trim();
			myJframe.chatText.append(myJframe.name.getText() + ":" + rSend + "\n");
			// System.out.println("***");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
