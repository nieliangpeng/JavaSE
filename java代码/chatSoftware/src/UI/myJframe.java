package UI;
import javax.swing.*;

import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Modal.myRunable;
import Modal.myRunable_come;
import Modal.serRunable;
import Modal.serRunable_come;
import Modal.yourRunable;

import javax.swing.*;
import javax.swing.*;
import javax.swing.*;
public class myJframe extends JFrame {
	//public static int n=0;
	public static String ip;
	//面板
	protected JPanel jpanel; 
	//标签
	public static  JLabel name;
	//聊天窗口
	public static JTextArea chatText;
	//选项
	protected JComboBox combobox;
	//输入框
	public static JTextArea input;
	//发送按钮
	protected JButton send;
	//重置
	protected JButton reset;
	//public static int p=0;
	public myJframe() {
		// TODO Auto-generated constructor stub
		//面板
		jpanel=new JPanel();
		jpanel.setLayout(null);
		this.add(jpanel);
		//label标签
		name=new JLabel("聊天对象");
		name.setBounds(150, 10, 100, 20);
		jpanel.add(name);
		//聊天窗口
		chatText =new JTextArea();
		Border b1=BorderFactory.createLineBorder(Color.BLUE);
		Border b2=BorderFactory.createEtchedBorder();
	    chatText.setBorder(BorderFactory.createCompoundBorder(b1,b2));
	    chatText.setBounds(20, 40, 300, 400);
		chatText.setLineWrap(true);
		jpanel.add(chatText);
		//选择项
		combobox =new JComboBox<>();
		combobox.addItem("聊天对象");
		combobox.addItem("夏天");
		combobox.addItem("纳兹");
		combobox.addItem("里包恩");
		combobox.setEditable(true);
		combobox.setBounds(340, 40, 80, 20);
		jpanel.add(combobox);
		//选项事件
		combobox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				name.setText(combobox.getSelectedItem().toString());
				if(combobox.getSelectedItem().toString().equals("夏天")){
					ip="127.0.0.1";
				}else if(combobox.getSelectedItem().toString().equals("纳兹")){
					ip="127.0.0.1";
				}else{
					ip="127.0.0.1";
				}
				
				yourRunable your=new yourRunable();
				serRunable ser= new serRunable();
				
				
				
				Thread t2=new Thread(ser);
				
				Thread t3=new Thread(your);
				t2.start();
				//t1.start();
				t3.start();
				
				//
			}
		});
		//输入框
		input=new JTextArea("输入聊天消息");
		input.setBorder(BorderFactory.createCompoundBorder(b1,b2));
		input.setBounds(20, 450, 300, 25);
		jpanel.add(input);
		input.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				input.setText("");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//发送按钮
		send=new JButton("发送");
		send.setBounds(350, 450, 60, 20);
		jpanel.add(send);
		myJframeListener listener=new myJframeListener(this);
		send.addActionListener(listener);
		
		//重置按钮
		reset=new JButton("重置");
		reset.setBounds(350, 480, 60, 20);
		jpanel.add(reset);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				input.setText("");
				chatText.setText("");
			}
		});
		//窗口
        this.setBounds(600,100, 450,550);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
	}
	//按下发送按钮时
	public void sender () throws InterruptedException, UnknownHostException, IOException{
		//n++;
		String sendText="我说："+input.getText();
		
		chatText.append(sendText+"\n");
		
		myRunable mySend=new myRunable();
	    Thread t1=new Thread(mySend);
	    t1.start();
	    //t1.sleep(2000);
//	    if(n==1){
//	    	myRunable_come myCome=new myRunable_come();
//	    	Thread t2=new Thread(myCome);
//	    	t2.start();
//	    }
		//p=1;
		
		
	}
	public static void main(String[] args) {
		new myJframe();
		

	}
	
}

