package Modal;

import java.io.IOException;

public class serRunable_come implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// ���ս��շ�����Ϣ

		try {
			char[] c = new char[30];
			// System.out.println("ִ��");

			serRunable.reader.read(c);
			serRunable.writers.write(new String(c));
			serRunable.writers.flush();
			// System.out.println("�����������˲�������"+new String(c));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
