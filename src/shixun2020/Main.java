package shixun2020;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * 组件定义
		 */
		JLabel usernamelabel = new JLabel("用户名：");
		usernamelabel.setBounds(23, 47, 73, 36);
		contentPane.add(usernamelabel);
		
		JLabel passwordlabel = new JLabel("密码：");
		passwordlabel.setBounds(23, 107, 73, 36);
		contentPane.add(passwordlabel);
		
		textField = new JTextField("请输入用户名");
		textField.setBounds(106, 47, 189, 36);
		contentPane.add(textField);
		textField.addFocusListener(new JTextFieldHintListener("请输入用户名", textField));
		textField.setColumns(10);
		
		textField_1 = new JPasswordField("请输入密码");
		textField_1.setColumns(10);
		textField_1.setBounds(106, 107, 189, 36);
		textField_1.setEchoChar((char)0);
		textField_1.addFocusListener(new JTextFieldHintListener("请输入密码", textField_1));
		contentPane.add(textField_1);
		
		JRadioButton systemAdmin = new JRadioButton("系统管理员");
		systemAdmin.setBounds(52, 6, 121, 23);
		contentPane.add(systemAdmin);
		
		JRadioButton dianpuAdmin = new JRadioButton("店铺管理员");
		dianpuAdmin.setBounds(203, 6, 121, 23);
		contentPane.add(dianpuAdmin);
		// 创建一个按钮组
		ButtonGroup btnGroup = new ButtonGroup();

		// 添加单选按钮到按钮组
		btnGroup.add(systemAdmin);
		btnGroup.add(dianpuAdmin);
		
		JButton loginBtn = new JButton("登录");
		loginBtn.setBounds(23, 168, 140, 54);
		contentPane.add(loginBtn);
		
		JButton RegisterBtn = new JButton("注册");
		RegisterBtn.setBounds(216, 168, 140, 54);
		contentPane.add(RegisterBtn);
		
		JLabel forgetPassword = new JLabel("忘记密码？");
		forgetPassword.setBounds(305, 118, 73, 15);
		contentPane.add(forgetPassword);
		
		/**
		 * 监听器部分
		 */
		
		systemAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RegisterBtn.setVisible(false);
			}
		});
		
		dianpuAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterBtn.setVisible(true);
				
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(String.valueOf(textField_1.getPassword()));
				if(systemAdmin.isSelected())
				try {
//					Class.forName("com.mysql.jdbc.Driver");
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
					Statement stmt = conn.createStatement();
					String sql = "select * from adminuser where username ='"+textField.getText()+"' and password = '"+String.valueOf(textField_1.getPassword())+"';";
					ResultSet rs=	stmt.executeQuery(sql);
					if(rs.next()) {
						System.out.println("搜索到记录");
						new 账号管理();
					}
					jdbcUtil.result(conn, stmt, rs);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				else if(dianpuAdmin.isSelected()) {
					
				}
			}
		});
		textField_1.addFocusListener(new JTextFieldHintListener("请输入密码", textField_1));
		forgetPassword.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				JOptionPane.showMessageDialog(null, "此功能尚未开发", "抱歉",JOptionPane.WARNING_MESSAGE);  
			}
		}
			
		);
	setVisible(true);	
	}
	
}