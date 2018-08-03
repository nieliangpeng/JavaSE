package Modal;

import java.io.IOException;

public class serRunable_come implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 接收接收方的消息

		try {
			char[] c = new char[30];
			// System.out.println("执行");

			serRunable.reader.read(c);
			serRunable.writers.write(new String(c));
			serRunable.writers.flush();
			// System.out.println("服务器接收了并发送了"+new String(c));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
