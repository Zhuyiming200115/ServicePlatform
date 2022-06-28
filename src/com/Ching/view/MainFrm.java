package com.Ching.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.swing.text.html.AccessibleHTML.TableElementInfo.TableAccessibleContext;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainFrm extends JFrame 
{

	private JPanel contentPane;
	private JDesktopPane table = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 窗体框架设计
	 */
	public MainFrm() 
	{
		setTitle("\u51FA\u79DF\u670D\u52A1\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 457);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6570\u636E\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6863\u6848 (2).png")));
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_4 = new JMenu("\u81EA\u7531\u804C\u4E1A\u8005\u7BA1\u7406");
		mnNewMenu_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7528\u6237.png")));
		mnNewMenu.add(mnNewMenu_4);
		
		//自由职业者添加
		JMenuItem mnNewMenu_9 = new JMenuItem("职业者添加");
		mnNewMenu_9.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FreelanceAddInterFrm freelanceAddInterFrm = new FreelanceAddInterFrm();
				freelanceAddInterFrm.setVisible(true);
				table.add(freelanceAddInterFrm);	
			}
		});
		mnNewMenu_9.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		mnNewMenu_4.add(mnNewMenu_9);
		
		//自由职业者删除
		JMenuItem mnNewMenu_10 = new JMenuItem("职业者删除");
		mnNewMenu_10.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				FreelanceManageInterFrm freelanceManageInterFrm = new FreelanceManageInterFrm();
				freelanceManageInterFrm.setVisible(true);
				table.add(freelanceManageInterFrm);
			}
		});
		mnNewMenu_10.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5220 \u9664 .png")));
		mnNewMenu_4.add(mnNewMenu_10);
		
		//自由职业者修改
		JMenuItem mnNewMenu_11 = new JMenuItem("职业者修改");
		mnNewMenu_11.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FreelanceManageInterFrm freelanceManageInterFrm = new FreelanceManageInterFrm();
				freelanceManageInterFrm.setVisible(true);
				table.add(freelanceManageInterFrm);
			}
		});
		mnNewMenu_11.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539.png")));
		mnNewMenu_4.add(mnNewMenu_11);
		
		//自由职业者查询
		JMenuItem mnNewMenu_12 = new JMenuItem("职业者查询");
		mnNewMenu_12.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				FreelanceManageInterFrm freelanceManageInterFrm = new FreelanceManageInterFrm();
				freelanceManageInterFrm.setVisible(true);
				table.add(freelanceManageInterFrm);
			}
		});
		mnNewMenu_12.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		mnNewMenu_4.add(mnNewMenu_12);
		
		JMenu mnNewMenu_5 = new JMenu("\u666E\u901A\u7528\u6237\u7BA1\u7406");
		mnNewMenu_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5BA2\u6237.png")));
		mnNewMenu.add(mnNewMenu_5);
		
		
		//普通用户添加
		JMenuItem mnNewMenu_13 = new JMenuItem("用户添加");
		mnNewMenu_13.addActionListener(new ActionListener()
{
			public void actionPerformed(ActionEvent e)
			{			
				ConsumerAddInterFrm consumerAddInterFrm = new ConsumerAddInterFrm();
				consumerAddInterFrm.setVisible(true);
				table.add(consumerAddInterFrm);
			}
		});
		mnNewMenu_13.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		mnNewMenu_5.add(mnNewMenu_13);
		
		
		//普通用户删除
		JMenuItem mnNewMenu_14 = new JMenuItem("用户删除");
		mnNewMenu_14.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{	
				ConsumerManageInterFrm consumerManageInterFrm = new ConsumerManageInterFrm();
				consumerManageInterFrm.setVisible(true);
				table.add(consumerManageInterFrm);	
			}
		});
		mnNewMenu_14.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5220 \u9664 .png")));
		mnNewMenu_5.add(mnNewMenu_14);
		
		
		//普通用户修改
		JMenuItem mnNewMenu_15 = new JMenuItem("用户修改");
		mnNewMenu_15.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ConsumerManageInterFrm consumerManageInterFrm = new ConsumerManageInterFrm();
				consumerManageInterFrm.setVisible(true);
				table.add(consumerManageInterFrm);
			}
		});
		mnNewMenu_15.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539.png")));
		mnNewMenu_5.add(mnNewMenu_15);
		
		
		//普通用户查询
		JMenuItem mnNewMenu_16 = new JMenuItem("用户查询");
		mnNewMenu_16.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				ConsumerManageInterFrm consumerManageInterFrm = new ConsumerManageInterFrm();
				consumerManageInterFrm.setVisible(true);
				table.add(consumerManageInterFrm);	
			}
		});
		mnNewMenu_16.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		mnNewMenu_5.add(mnNewMenu_16);
		
		JMenu mnNewMenu_6 = new JMenu("\u65F6\u95F4\u8868\u7BA1\u7406");
		mnNewMenu_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9879\u76EE (1).png")));
		mnNewMenu.add(mnNewMenu_6);
		
		//添加项目
		JMenuItem mnNewMenu_18 = new JMenuItem("\u65F6\u95F4\u8868\u6DFB\u52A0");
		mnNewMenu_18.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				ScheduleAddInterFrm scheduleAddInterFrm = new ScheduleAddInterFrm();
				scheduleAddInterFrm.setVisible(true);
				table.add(scheduleAddInterFrm);
			}
		});
		mnNewMenu_18.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		mnNewMenu_6.add(mnNewMenu_18);
		
		//时间表删除
		JMenuItem mnNewMenu_19 = new JMenuItem("\u65F6\u95F4\u8868\u5220\u9664");
		mnNewMenu_19.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ScheduleManageInterFrm scheduleManageInterFrm = new ScheduleManageInterFrm();
				scheduleManageInterFrm.setVisible(true);
				table.add(scheduleManageInterFrm);	
			}
		});
		mnNewMenu_19.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5220 \u9664 .png")));
		mnNewMenu_6.add(mnNewMenu_19);
		
		//时间表修改
		JMenuItem mnNewMenu_20 = new JMenuItem("\u65F6\u95F4\u8868\u4FEE\u6539");
		mnNewMenu_20.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ScheduleManageInterFrm scheduleManageInterFrm = new ScheduleManageInterFrm();
				scheduleManageInterFrm.setVisible(true);
				table.add(scheduleManageInterFrm);
			}
		});
		mnNewMenu_20.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539.png")));
		mnNewMenu_6.add(mnNewMenu_20);
		
		//时间表查询
		JMenuItem mnNewMenu_17 = new JMenuItem("\u65F6\u95F4\u8868\u67E5\u8BE2");
		mnNewMenu_17.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				ScheduleManageInterFrm scheduleManageInterFrm = new ScheduleManageInterFrm();
				scheduleManageInterFrm.setVisible(true);
				table.add(scheduleManageInterFrm);	
			}
		});
		mnNewMenu_17.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		mnNewMenu_6.add(mnNewMenu_17);
		
		JMenu mnNewMenu_7 = new JMenu("\u9879\u76EE\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu_7.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9879\u76EE.png")));
		mnNewMenu.add(mnNewMenu_7);
		
		
		//添加项目
		JMenuItem mnNewMenu_21 = new JMenuItem("\u9879\u76EE\u6DFB\u52A0");
		mnNewMenu_21.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ProjectAddInterFrm projectAddInterFrm = new ProjectAddInterFrm();
				projectAddInterFrm.setVisible(true);
				table.add(projectAddInterFrm);	
			}
		});
		mnNewMenu_21.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		mnNewMenu_7.add(mnNewMenu_21);
		
		
		//项目删除
		JMenuItem mnNewMenu_22 = new JMenuItem("\u9879\u76EE\u5220\u9664");
		mnNewMenu_22.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				ProjectManageInterFrm projectManageInterFrm = new ProjectManageInterFrm();
				projectManageInterFrm.setVisible(true);
				table.add(projectManageInterFrm);	
			}
		});
		mnNewMenu_22.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5220 \u9664 .png")));
		mnNewMenu_7.add(mnNewMenu_22);
		
		//项目修改
		JMenuItem mnNewMenu_23 = new JMenuItem("\u9879\u76EE\u4FEE\u6539");
		mnNewMenu_23.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				ProjectManageInterFrm projectManageInterFrm = new ProjectManageInterFrm();
				projectManageInterFrm.setVisible(true);
				table.add(projectManageInterFrm);
			}
		});
		mnNewMenu_23.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539.png")));
		mnNewMenu_7.add(mnNewMenu_23);
		
		//项目查询
		JMenuItem mnNewMenu_24 = new JMenuItem("\u9879\u76EE\u67E5\u8BE2");
		mnNewMenu_24.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				ProjectManageInterFrm projectManageInterFrm = new ProjectManageInterFrm();
				projectManageInterFrm.setVisible(true);
				table.add(projectManageInterFrm);	
			}
		});
		mnNewMenu_24.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		mnNewMenu_7.add(mnNewMenu_24);
		
		//安全退出
		JMenuItem mnNewMenu_8 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		mnNewMenu_8.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int result = JOptionPane.showConfirmDialog(null, "是否退出系统？");
				if(result==0) {	
				//System.out.println(result);
				dispose();//销毁窗体
				}
			}
		});
		mnNewMenu_8.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9000\u51FA.png")));
		mnNewMenu.add(mnNewMenu_8);
		
		//审计信息
		JMenu mnNewMenu_1 = new JMenu("\u67E5\u770B\u5BA1\u8BA1\u4FE1\u606F");
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5BA1\u8BA1\u914D\u7F6E.png")));
		menuBar.add(mnNewMenu_1);
		
		
		//审计信息
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u67E5\u770B\u5BA1\u8BA1\u4FE1\u606F");
		mntmNewMenuItem_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				InformationInterFrm informationInterFrm = new InformationInterFrm();
				informationInterFrm.setVisible(true);
				table.add(informationInterFrm);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5BA1\u8BA1\u65E5\u5FD7.png")));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("\u5173\u4E8E");
		mnNewMenu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4E8E.png")));
		menuBar.add(mnNewMenu_3);
		
		
		//关于我们
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		mntmNewMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				ChingInterFrm chingInterFrm = new ChingInterFrm();
				chingInterFrm.setVisible(true);
				table.add(chingInterFrm);	
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4E8E.png")));
		mnNewMenu_3.add(mntmNewMenuItem);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(new Color(102, 102, 255));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(table);
		GroupLayout gl_table = new GroupLayout(table);
		gl_table.setHorizontalGroup
		(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 498, Short.MAX_VALUE)
		);
		gl_table.setVerticalGroup
		(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 387, Short.MAX_VALUE)
		);
		table.setLayout(gl_table);
		
	
		//窗体最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//设置窗体居中
		this.setLocationRelativeTo(null);
		
	}
}
