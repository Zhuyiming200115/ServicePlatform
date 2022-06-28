package com.Ching.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;


import com.Ching.dao.ProjectDao;
import com.Ching.model.Consumer;
import com.Ching.model.Project;
import com.Ching.util.DbUtil;
import com.Ching.util.StringUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.SystemColor;
import java.awt.Color;

public class ProjectAddInterFrm extends JInternalFrame {
	private JTextField ProjectIdTxt;
	private JTextField ProjectTimeTxt;
	private JTextField ProjectFreeIdTxt;
	private JTextField ProjectConIdTxt;
	private JTextArea ProjectContentTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private ProjectDao projectDao=new ProjectDao();	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectAddInterFrm frame = new ProjectAddInterFrm();
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
	public ProjectAddInterFrm() {
		setTitle("\u9879\u76EE\u6DFB\u52A0");
		setBackground(new Color(102, 51, 204));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 714, 482);
		
		JLabel lblNewLabel = new JLabel("\u9879\u76EE\u7F16\u53F7          \uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u9879\u76EE\u7C7B\u522B          \uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u53C2\u4E0E\u81EA\u7531\u804C\u4E1A\u8005\u7F16\u53F7\uFF1A");
		
		JLabel lblNewLabel_2_1 = new JLabel("\u53C2\u4E0E\u666E\u901A\u7528\u6237\u7F16\u53F7 \uFF1A ");
		
		JLabel lblNewLabel_3 = new JLabel("\u9879\u76EE\u5185\u5BB9          \uFF1A");
		
		ProjectContentTxt = new JTextArea();
		
		ProjectIdTxt = new JTextField();
		ProjectIdTxt.setColumns(10);
		
		ProjectTimeTxt = new JTextField();
		ProjectTimeTxt.setColumns(10);
		
		ProjectFreeIdTxt = new JTextField();
		ProjectFreeIdTxt.setColumns(10);
		
		ProjectConIdTxt = new JTextField();
		ProjectConIdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		
		JButton btnNewButton_2 = new JButton("\u6DFB\u52A0");
		
		JButton btnNewButton_1_1 = new JButton("\u91CD\u7F6E");
		
		//添加按钮
		JButton btnNewButton_3 = new JButton("\u6DFB\u52A0");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProjectAddActionPerformed(e);
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(ProjectAddInterFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		
		JButton btnNewButton_4 = new JButton("\u91CD\u7F6E");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resetValueActionPerformed(e);
				
				
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(ProjectAddInterFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2)
							.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(ProjectConIdTxt, Alignment.LEADING)
									.addComponent(ProjectContentTxt, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(ProjectIdTxt, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
											.addComponent(ProjectTimeTxt, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
											.addComponent(ProjectFreeIdTxt, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE))
										.addGap(180))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
												.addGap(70)
												.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
												.addGap(70)
												.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
										.addGap(48))))))
					.addGap(48))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(113)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(ProjectIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(ProjectTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(ProjectFreeIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ProjectConIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(ProjectContentTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4))
					.addGap(213)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(63))
		);
		getContentPane().setLayout(groupLayout);

		//设置文本域边框
				ProjectContentTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

			}
	
	//项目添加事件
	private void ProjectAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	    String Project_Id  = this.ProjectIdTxt.getText();
	    String Project_Time = this.ProjectTimeTxt.getText();
	    String Project_Content  = this.ProjectContentTxt.getText();
	    
	    
	    
	    String Project_Free_Id  = this.ProjectFreeIdTxt.getText();                               
	    String Project_Con_Id   = this.ProjectConIdTxt.getText() ;
		
	    if (StringUtil.isEmpty(Project_Id)) {
	    	JOptionPane.showMessageDialog(null, "项目编号不能为空！");
			return;
		}
	    
	    if (StringUtil.isEmpty(Project_Time)) {
	    	JOptionPane.showMessageDialog(null, "项目时间不能为空！");
			return;
		}
	    
	    

	    if (StringUtil.isEmpty(Project_Free_Id )) {
	    	JOptionPane.showMessageDialog(null, "项目参与自由职业者编号不能为空！");
			return;
		}
	    
	    if (StringUtil.isEmpty(Project_Con_Id)) {
	    	JOptionPane.showMessageDialog(null, "项目参与普通用户编号不能为空！");
			return;
		}
	    
	    if (StringUtil.isEmpty(Project_Content)) {
	    	JOptionPane.showMessageDialog(null, "项目内容不能为空！");
			return;
		}
	    
	    
	    
	    
	    
	    Project project = new Project( Project_Id, Project_Time, Project_Free_Id, Project_Con_Id, Project_Content);
	    Connection con=null;
	    try {
	    	con=dbUtil.getCon();
	    	int n=projectDao.add(con,project);
	    	if (n==1) {
				JOptionPane.showMessageDialog(null, "添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败！项目编号已存在！");
			}
	    	
	    	
	    	
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
	    	JOptionPane.showMessageDialog(null, "添加失败！项目编号已存在！");
		}finally {
			try {
				dbUtil.closeCon(con);
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
	    
	    
	    
	}
	
	

			//重置事件处理
			private void resetValueActionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				this.resetValue();
			}

			
			
			//重置表单
			private void resetValue() {
				this.ProjectIdTxt.setText("");
				this.ProjectTimeTxt.setText("");
				this.ProjectFreeIdTxt.setText("");
				this.ProjectConIdTxt.setText("");
				this.ProjectContentTxt.setText("");
				
			}
		
	}

