package UI;
import javax.swing.JOptionPane;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Modal.createDataBase;
import javax.swing.JOptionPane;
public class registerFrame extends JFrame{
	JTextField txtName;
	JPasswordField txtPwd;
	JPanel registerPanel;
	JLabel lblName;
	JLabel lblPwd;
	JButton btnregister;
	JButton btnLogin;
	public registerFrame(){
		super("注册");
		registerPanel=new JPanel();
		registerPanel.setLayout(null);
		this.getContentPane().add(registerPanel);
		
		//添加Label、text、button
		lblName=new JLabel("用户名：");
		lblName.setBounds(10, 10, 120, 25);
		lblPwd=new JLabel("密码：");
		lblPwd.setBounds(10, 40, 120, 25);
		
		txtName=new JTextField();
		txtName.setBounds(140, 10, 120, 25);
		txtPwd=new JPasswordField();
		txtPwd.setBounds(140, 40 ,120, 25);
		
		
		btnregister=new JButton("确定");
		btnregister.setBounds(140, 70, 120, 25);
		btnLogin=new JButton("返回登录");
		btnLogin.setBounds(140, 100, 120, 25);
		
			
		registerListener listener=new registerListener(this);
		btnLogin.addActionListener(listener);
		btnregister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createDataBase data=new createDataBase();
				//data.s="chater";
				//System.out.println(data.s);
				String name=txtName.getText();
				String password=txtPwd.getText();
				int n=0;
				try {
					 //System.out.println("成功");
					 
					 n=data.insertTable(name,password);
					 //System.out.println("成功");
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(n==1){
					JOptionPane.showMessageDialog(btnregister, "注册成功","恭喜", JOptionPane.OK_CANCEL_OPTION 
);
					//System.out.println("成功");
				}
			}
		});
		
		
		//将组件添加到面板
		registerPanel.add(lblName);
		registerPanel.add(lblPwd);
		registerPanel.add(txtName);
		registerPanel.add(txtPwd);
		registerPanel.add(btnregister);
		registerPanel.add(btnLogin);
		
		
		this.setBounds(600, 200, 300, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void reLogin(){
		// TODO Auto-generated method stub
		
		new LoginFrame();
		this.setVisible(false);
	}
//	public static void main(String[] args) {
//		registerFrame  loginFrame=new registerFrame ();
//		
//
//	}
}
