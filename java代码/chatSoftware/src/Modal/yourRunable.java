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
				
				System.out.println("���ڼ���1");
				socket2 = server2.accept();
				System.out.println("��������1");

				in = socket2.getInputStream();
				out = socket2.getOutputStream();
				readers = new BufferedReader(new InputStreamReader(in));
				writers = new BufferedWriter(new OutputStreamWriter(out));

				char[] chars = new char[30];
				System.out.println("׼����������qw");
				readers.read(chars);
				System.out.println("���յ���Ϣ��" + new String(chars));
				String b = new String(chars);
				
				if (yjf == null) {
					yjf = new yourJframe();
				}
				yourJframe.chatText.append("������:" + b + "\n");
				
				if (b.startsWith("�ݰ�")) {
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
			// System.out.println("��������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
