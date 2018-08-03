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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Modal.myRunable_come;
import Modal.serRunable_come;
import Modal.yourRunable_send;

import javax.swing.*;
import javax.swing.*;
import javax.swing.*;
public class yourJframe extends JFrame {
//	public static int n=0;
	//面板
	protected JPanel jpanel; 
	//标签
	protected JLabel name;
	//聊天窗口
	public static JTextArea chatText;
	
	//输入框
	public static JTextArea input;
	//发送按钮
	protected JButton send;
	//重置
	protected JButton reset;
	//public static int p=0;
	public yourJframe() {
		// TODO Auto-generated constructor stub
		//面板
		jpanel=new JPanel();
		jpanel.setLayout(null);
		this.add(jpanel);
		//label标签
		name=new JLabel("聂良鹏");
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
		send.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
				String sendText=input.getText();
				chatText.append("我："+sendText+"\n"); 
				yourRunable_send yourSend=new yourRunable_send();
				serRunable_come serCome=new serRunable_come();
				myRunable_come myCome=new myRunable_come();
				Thread t5=new Thread(serCome);
				Thread t6=new Thread(myCome);
				Thread t4=new Thread(yourSend);
				t5.start();
				t6.start();
				t4.start();
				
				//p=1;
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
		});
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
//	public static void main(String[] args) {
//		//new yourJframe();
//		
//
//	}
}

