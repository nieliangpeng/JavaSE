package Modal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import UI.myJframe;
import UI.myJframeListener;

public class serRunable implements Runnable {
	public static BufferedReader reader;
	public static BufferedWriter writers;
	ServerSocket server1;
	Socket socket ;
	InputStream in;
	OutputStream out;
	BufferedReader readers;
	BufferedWriter writer;
	Socket client2 ;
	InputStream input;
	OutputStream output ;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		try {
			server1 = new ServerSocket(9101);
			while (true) {
				
				System.out.println("���ڼ���");
				socket = server1.accept();
				System.out.println("��������");

				in = socket.getInputStream();
				out = socket.getOutputStream();
				readers = new BufferedReader(new InputStreamReader(in));
				writers = new BufferedWriter(new OutputStreamWriter(out));
				
				client2 = new Socket(myJframe.ip, 9110);
				input = client2.getInputStream();
				output = client2.getOutputStream();
				reader = new BufferedReader(new InputStreamReader(input));
				writer = new BufferedWriter(new OutputStreamWriter(output));

				char[] chars = new char[30];
				System.out.println("׼����������");
				readers.read(chars);
				System.out.println("���յ���Ϣ��" + new String(chars));
				String b = new String(chars);

				// �������շ�

				writer.write(b);
				writer.flush();
				
				
				if (b.startsWith("�ݰ�")) {
					break;
				}
			}

			
			client2.close();
			input.close();
			output.close();
			reader.close();
			writer.close();
			in.close();
			out.close();
			readers.close();
			writers.close();
			socket.close();
			server1.close();

			// System.out.println("��������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
