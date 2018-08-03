package Modal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import UI.myJframe;
import UI.yourJframe;

public class yourRunable implements Runnable {
	//public static int n=0;
	yourJframe yjf = null;
	public static BufferedWriter writers=null;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket server2;
		InputStream in;
		OutputStream out;
		BufferedReader readers;
		Socket socket2;
		try {
			server2 = new ServerSocket(9110);
			while (true) {
				
				System.out.println("正在监听1");
				socket2 = server2.accept();
				System.out.println("建立连接1");

				in = socket2.getInputStream();
				out = socket2.getOutputStream();
				readers = new BufferedReader(new InputStreamReader(in));
				writers = new BufferedWriter(new OutputStreamWriter(out));

				char[] chars = new char[30];
				System.out.println("准备接收数据qw");
				readers.read(chars);
				System.out.println("接收到消息：" + new String(chars));
				String b = new String(chars);
				
				if (yjf == null) {
					yjf = new yourJframe();
				}
				yourJframe.chatText.append("聂良鹏:" + b + "\n");
				
				if (b.startsWith("拜拜")) {
					break;
				}
//				n++;
//				if(n==1){
//					serRunable_come sercome=new serRunable_come();
//					Thread t6=new Thread(sercome);
//					t6.start();
//				}

			}
			in.close();
			out.close();
			readers.close();
			writers.close();
			socket2.close();
			server2.close();
			// System.out.println("结束交互");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
