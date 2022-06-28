package com.Ching.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Ching.dao.ConsumerDao;
import com.Ching.dao.ProjectDao;
import com.Ching.model.Consumer;
import com.Ching.model.Project;
import com.Ching.model.Schedule;
import com.Ching.util.DbUtil;
import com.Ching.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ProjectManageInterFrm extends JInternalFrame {
	private JTable ProjectTable;
	private JTextField s_ProjectTypeTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private ProjectDao projectDao=new ProjectDao();	
	private JTextField ProjectIdTxt;
	private JTextField ProjectTypeTxt;
	private JTextField ProjectFreeIdTxt;
	private JTextField ProjectConIdTxt;
	private JTextArea ProjectContentTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectManageInterFrm frame = new ProjectManageInterFrm();
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
	public ProjectManageInterFrm() {
		getContentPane().setBackground(new Color(0, 204, 204));
		setTitle("\u9879\u76EE\u7BA1\u7406");
		setBackground(SystemColor.activeCaption);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 663, 735);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		JLabel lblNewLabel = new JLabel("\u9879\u76EE\u7C7B\u522B\uFF1A");
		
		s_ProjectTypeTxt = new JTextField();
		s_ProjectTypeTxt.setColumns(10);
		
		//查询按钮
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectSearchActionPerformed(e);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(ProjectManageInterFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.window);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(s_ProjectTypeTxt, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
					.addGap(75))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_ProjectTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(28)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16   \u53F7     \uFF1A");
		
		ProjectIdTxt = new JTextField();
		ProjectIdTxt.setEditable(false);
		ProjectIdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7C7B\u522B\uFF1A");
		
		ProjectTypeTxt = new JTextField();
		ProjectTypeTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u81EA\u7531\u804C\u4E1A\u8005\u7F16\u53F7\uFF1A");
		
		ProjectFreeIdTxt = new JTextField();
		ProjectFreeIdTxt.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u666E\u901A\u7528\u6237\u7F16\u53F7\uFF1A");
		
		ProjectConIdTxt = new JTextField();
		ProjectConIdTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5185   \u5BB9     \uFF1A");
		
		 ProjectContentTxt = new JTextArea();
		ProjectContentTxt.setBackground(SystemColor.menu);
		
		//修改按钮
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectUpdateActionEvent();
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ProjectManageInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		
		//删除按钮
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProjectDeleteActionEvent();
				
				
				
				
			}
			
			
		});
		btnNewButton_2.setIcon(new ImageIcon(ProjectManageInterFrm.class.getResource("/images/\u5220 \u9664 .png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ProjectFreeIdTxt, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ProjectIdTxt, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ProjectTypeTxt, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(ProjectContentTxt, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
								.addComponent(ProjectConIdTxt, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(76)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))))
					.addGap(26))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(ProjectTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ProjectIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(ProjectFreeIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1)
						.addComponent(ProjectConIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(ProjectContentTxt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		//点击事件
		ProjectTable = new JTable();
		ProjectTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				ProjectTableMousePressed(e);
				
				
				
				
			}
		});
		
		ProjectTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7C7B\u522B", "\u81EA\u7531\u804C\u4E1A\u8005\u7F16\u53F7", "\u666E\u901A\u7528\u6237\u7F16\u53F7", "\u5185\u5BB9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_2.setViewportView(ProjectTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Project());
	}

	
	
	
	//点击表单
	private void ProjectTableMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int row= ProjectTable.getSelectedRow();
		ProjectIdTxt.setText( (String)ProjectTable.getValueAt(row, 0));  
		ProjectTypeTxt.setText((String)ProjectTable.getValueAt(row, 1));
		ProjectFreeIdTxt.setText( (String)ProjectTable.getValueAt(row, 2));  
		ProjectConIdTxt.setText((String)ProjectTable.getValueAt(row, 3));
		ProjectContentTxt.setText( (String)ProjectTable.getValueAt(row, 4));  
		
	}

	//删除事件
	private void ProjectDeleteActionEvent() {
		// TODO Auto-generated method stub
		String Pro_Id =ProjectIdTxt.getText();
		if (StringUtil.isEmpty(Pro_Id)) {
			JOptionPane.showMessageDialog(null, "请选择需要删除的记录！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if (n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=    projectDao.delete(con, Pro_Id);
				
				if (deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new Project());
					
				}else {
					JOptionPane.showMessageDialog(null, "删除失败！");
					
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "删除失败！");
			}finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			
		}
		
		
	}

	
	//修改事件
	private void ProjectUpdateActionEvent() {
		// TODO Auto-generated method stub
		String Pro_Id =ProjectIdTxt.getText();
		String Pro_Type =ProjectTypeTxt.getText();
		String Pro_Free_Id =ProjectFreeIdTxt.getText();
		String Pro_Con_Id =ProjectConIdTxt.getText();
		String Pro_Content =ProjectContentTxt.getText();
		
		
		if (StringUtil.isEmpty(Pro_Id)) {
			JOptionPane.showMessageDialog(null, "请选择需要修改的记录！");
			return;
		}
		
		if (StringUtil.isEmpty(Pro_Type)) {
			JOptionPane.showMessageDialog(null, "项目类别不能为空！");
			return;
		}
		
		if (StringUtil.isEmpty(Pro_Free_Id)) {
			JOptionPane.showMessageDialog(null, "自由职业者编号不能为空！");
			return;
		}
		
		
		if (StringUtil.isEmpty(Pro_Con_Id)) {
			JOptionPane.showMessageDialog(null, "普通用户编号不能为空！");
			return;
		}
		
		if (StringUtil.isEmpty(Pro_Content)) {
			JOptionPane.showMessageDialog(null, "项目内容不能为空！");
			return;
		}
		
		
		
		
		
		
		
		Project project=new Project(Pro_Id, Pro_Type, Pro_Free_Id, Pro_Con_Id, Pro_Content);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNumber=  projectDao.update(con, project);
			
			if (modifyNumber==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.fillTable(new Project());
				
			}else {
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "修改失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

	//查询事件
	private void ProjectSearchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String s_Project_Type=this.s_ProjectTypeTxt.getText(); 
		Project project=new Project();
		project.setPro_Time(s_Project_Type);
		this.fillTable(project);
		
		
		
		
		
	}
	
	
	//初始化表格
	
			private void fillTable(Project project) {
				DefaultTableModel dtm=(DefaultTableModel)ProjectTable.getModel();
				dtm.setRowCount(0);//行数设置为0
				Connection con = null;
				try {
					con=dbUtil.getCon();
					
					ResultSet rs  = projectDao.list(con,project);
					while (rs.next()) {
						Vector v = new Vector();
						v.add(rs.getString("Pro_Id"));
						v.add(rs.getString("Pro_Time"));
						v.add(rs.getString("Pro_Free_Id"));
						v.add(rs.getString("Pro_Con_Id"));
						v.add(rs.getString("Pro_Content"));
						dtm.addRow(v);

					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					try {
						dbUtil.closeCon(con);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
			}

			//重置表单
			private void resetValue() {
				this.ProjectIdTxt.setText("");
				this.ProjectFreeIdTxt.setText("");
				this.ProjectTypeTxt.setText("");
				this.ProjectConIdTxt.setText("");
				this.ProjectContentTxt.setText("");
			
			}			
}
