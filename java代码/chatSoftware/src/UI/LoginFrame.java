package UI;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modal.createDataBase;

public class LoginFrame extends JFrame {
	JTextField txtName=null;
	JPasswordField txtPwd=null;
	JPanel loginPanel;
	JLabel lblName;
	JLabel lblPwd;
	JButton btnLogin;
	JButton btnRegister;
	public LoginFrame(){
		super("��¼");
		loginPanel=new JPanel();
		loginPanel.setLayout(null);
		this.getContentPane().add(loginPanel);
		
		//���Label��text��button
		lblName=new JLabel("�û�����");
		lblName.setBounds(10, 10, 120, 25);
		lblPwd=new JLabel("���룺");
		lblPwd.setBounds(10, 40, 120, 25);
		
		txtName=new JTextField();
		txtName.setBounds(140, 10, 120, 25);
		txtPwd=new JPasswordField();
		txtPwd.setBounds(140, 40 ,120, 25);
		
		btnLogin=new JButton("��¼");
		btnLogin.setBounds(20,80,120,25);
		btnRegister=new JButton("ע��");
		btnRegister.setBounds(150, 80, 120, 25);
		
		BtnListener listener=new BtnListener(this);
		btnLogin.addActionListener(listener);
		btnRegister.addActionListener(listener);
		
		//�������ӵ����
		loginPanel.add(lblName);
		loginPanel.add(lblPwd);
		loginPanel.add(txtName);
		loginPanel.add(txtPwd);
		loginPanel.add(btnLogin);
		loginPanel.add(btnRegister);
		
		this.setBounds(600, 200, 300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	public void login() throws ClassNotFoundException, SQLException{
		createDataBase login=new createDataBase();
		String name=txtName.getText();
		String password=txtPwd.getText();
		int n=login.isExistUser(name,password);
		if(n==1){
			new myJframe();
			this.setVisible(false);
		}else{
			JOptionPane.showMessageDialog(this, "��������û��������벻��ȷ��","��ʾ",JOptionPane.ERROR_MESSAGE);
			txtName.setText("");
			txtPwd.setText("");
			
		}
	}
	
	public void register(){
		new registerFrame ();
		this.setVisible(false);
	}

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//�������ݿ�Ȳ���
		createDataBase data=new createDataBase();
		data.preparationInAdvance();
		data.createDatabaseAndTable();
		data.closeConnection();
		
		LoginFrame loginFrame=new LoginFrame();
		

	}

}

