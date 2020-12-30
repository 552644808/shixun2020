package shixun2020;
 
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class qqlogin extends JFrame{
	JButton jbg,jbz,jbt1;
	JTextField jc;
	JPasswordField jps;
	public qqlogin() {
		BorderLayout g1 = new BorderLayout();
		this.setTitle("登录QQ");
		this.setLayout(g1);
		/*******添加背景图片*******/
		ImageIcon image = new ImageIcon("tupian//qqbeijing.jpg");
		JLabel l1 = new JLabel(image);
		l1.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
	    this.getLayeredPane().add(l1,new Integer(Integer.MIN_VALUE)); 
	    JPanel contentPanel = (JPanel)this.getContentPane();  
	    contentPanel.setOpaque(false);
	    /**********添加各个部分面板*************/
	    
	    
	    /*******北部面板******/
	    JPanel jpn = creatpanelno();
	    this.add(jpn,g1.NORTH);
	    /*******中间面板*******/
	    JPanel jpc = creatpanelce();
	    this.add(jpc,g1.CENTER);
	    
	    
	    /*******西部面板*******/
	    JPanel jpw = creatpanelwe();
	    this.add(jpw,g1.WEST);
	    
	    /*******南部面板*******/
	    JPanel jps = creatpanelsou();
	    this.add(jps,g1.SOUTH);
	    
	    /******消除边框****/
	    this.setUndecorated(true);
	    this.setResizable(true);
	    this.setVisible(true);
		this.setSize(380,294);
		this.setLocation(497,242);
	}
	private JPanel creatpanelno() {
		JPanel pn = new JPanel();  
		pn.setLayout(null);  
		//设置北边面板容器的大小  
		pn.setPreferredSize(new Dimension(0,140)); 
		/******关闭按钮*****/
		jbg = new JButton("G");
		jbg.setBounds(342,-1,39,20);
		jbg.setBorderPainted(false);  
		jbg.setFocusPainted(false);  
		jbg.setToolTipText("关闭");
		/*********匿名类，点击关闭按钮，关闭***********/
		ActionListener guanbi = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
			} 
		};
		jbg.addActionListener(guanbi);
		pn.add(jbg);
		jbz = new JButton("Z");
		jbz.setBounds(315,-1,28,20); 
		jbz.setBorderPainted(false);  
		jbz.setFocusPainted(false);  
		jbz.setToolTipText("最小化");
		/*********匿名类，点击最小化按钮最小化***********/
		ActionListener mini=new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setExtendedState(ICONIFIED);
			} 
		};
		jbz.addActionListener(mini);
		pn.add(jbz);
		pn.setOpaque(false);
		return pn;
	}
	private JPanel creatpanelsou() {
		JPanel ps = new JPanel();
		ps.setPreferredSize(new Dimension(0,51));
		ps.setBorder(null);
		ps.setLayout(null);
		jbt1 = new JButton("登      录");
		jbt1.setFont(new Font("宋体",0,13));
		jbt1.setBounds(113,8,162,30);
		jbt1.setBorderPainted(false); 
		jbt1.setFocusPainted(false);//设置点击不出现边框  
		jbt1.addActionListener(new ActionLis());
		ps.add(jbt1);
		ps.setOpaque(false);
		return ps;
	}
	private JPanel creatpanelwe() {
		JPanel pw = new JPanel();
		pw.setPreferredSize(new Dimension(102,0));
		pw.setLayout(new FlowLayout(FlowLayout.RIGHT)); 
		ImageIcon iw = new ImageIcon("tupian//qqw.jpg");
		JLabel lw = new JLabel(iw);
		lw.setBounds(206,100,iw.getIconWidth(),iw.getIconHeight());
		pw.add(lw);
		pw.setOpaque(false);
		return pw;
	}
	private JPanel creatpanelce() {
		JPanel pc = new JPanel();
		pc.setLayout(null);
	    jc = new JTextField();  
	    pc.add(jc);  
	    jc.setBounds(7, 18, 185, 25);  
	    jc.setFont(new Font("Calibri ",0,13));  
		/***注册账号标签******/
		JLabel jl1 = new JLabel("注册账号");
		pc.add(jl1);
		jl1.setFont(new Font("宋体",0,13));
		jl1.setForeground(new Color(114,184,254));  
        jl1.setBounds(206,20,100,16);
        /******密码框******/
        jps = new JPasswordField();  
        jps.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));  
        LineBorder lin = new LineBorder(Color.WHITE,3,true);  
        jps.setBorder(lin);  
        jps.setBounds(7,55,185,23);  
        jps.setPreferredSize(new Dimension(185,25));  
        pc.add(jps);  
        /*******找回密码标签******/
        JLabel jl2 = new JLabel("找回密码");
        jl2.setFont(new Font("宋体",0,12));  
        jl2.setForeground(new Color(114,184,254));  
        jl2.setBounds(206, 55, 100, 16);  
        pc.add(jl2);  
        /*******两个复选框*******/
        JCheckBox jch1 = new JCheckBox("记住密码");
        jch1.setFocusPainted(false); //选中时没有边框  
        jch1.setFont(new Font("宋体",0,13));//字体  
        jch1.setBounds(2, 83, 80, 15);
        pc.add(jch1);
        JCheckBox jch2 = new JCheckBox("自动登录");  
        jch2.setFocusPainted(false);  
        jch2.setFont(new Font("宋体",0,12));  
        jch2.setBounds(80, 83, 80, 15);  
        pc.add(jch2);
        jch1.setOpaque(false);  
        jch2.setOpaque(false);  
        pc.setOpaque(false);
		return pc;
	}
	class ActionLis implements ActionListener{
 
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			String qt = "admin";
			String qp = "123456";
			if( b == jbt1) {
				String ID = jc.getText();
				String password = jps.getText();
				if(ID.equals(qt) && password.equals(qp)) {
						setVisible(false);
						JFrame jf = new JFrame("登录成功");
						JPanel pp = new JPanel();
						ImageIcon im = new ImageIcon("tupian//denglu.jpg");
						JLabel ll = new JLabel(im);
						ll.setBounds(206,100,im.getIconWidth(),im.getIconHeight());
						pp.add(ll);
						jf.add(pp);
						jf.setSize(im.getIconWidth(),im.getIconHeight());
						jf.setLocation(1500,0);
						jf.setVisible(true);
						jf.setResizable(false);
				}else {
					JFrame jf = new JFrame("登录失败");
					JPanel pp = new JPanel();
					ImageIcon im = new ImageIcon("tupian//shibai.jpg");
					JLabel ll = new JLabel(im);
					ll.setBounds(206,150,im.getIconWidth(),im.getIconHeight());
					pp.add(ll);
					jf.add(pp);
					jf.setSize(im.getIconWidth(),im.getIconHeight());
					jf.setLocation(500,300);
					jf.setVisible(true);
					jf.setResizable(false);
				}
			}
		}
	}
	public static void main(String[] args) {
		new qqlogin();
	}
 
}