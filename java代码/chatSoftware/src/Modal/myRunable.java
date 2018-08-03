package Modal;

import UI.myJframe;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import UI.myJframe;

public class myRunable implements Runnable {
	Socket client1;
	InputStream input;
	OutputStream output;
	public static BufferedReader reader;
	BufferedWriter writer;
    public myRunable() throws UnknownHostException, IOException {
		// TODO Auto-generated constructor stub
    	client1 = new Socket("127.0.0.1", 9101);
		input = client1.getInputStream();
		output = client1.getOutputStream();
		reader = new BufferedReader(new InputStreamReader(input));
		writer = new BufferedWriter(new OutputStreamWriter(output));
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 发送给服务器

		try {
			
			String send = "";
			send = myJframe.input.getText();
			System.out.println("完成输入" + send);
			writer.write(send);
			writer.flush();
			myJframe.input.setText("");

			System.out.println("发送成功");

			if (send.endsWith("拜拜")) {
				output.close();
				input.close();
				reader.close();
				client1.close();
				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
