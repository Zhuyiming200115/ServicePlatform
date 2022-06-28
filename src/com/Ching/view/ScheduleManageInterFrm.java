package com.Ching.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Ching.dao.ProjectDao;
import com.Ching.dao.ScheduleDao;
import com.Ching.model.Freelance;
import com.Ching.model.Project;
import com.Ching.model.Schedule;
import com.Ching.util.DbUtil;
import com.Ching.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ScheduleManageInterFrm extends JInternalFrame {
	private JTable ScheduleTable;
	private JTextField s_ScheduleIdTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private ScheduleDao scheduleDao=new ScheduleDao();	
	private JTextField ScheduleIdTxt;
	private JTextField ScheduleTimeTxt;
	private JTextField ScheduleFreeIdTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleManageInterFrm frame = new ScheduleManageInterFrm();
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
	public ScheduleManageInterFrm() {
		setTitle("\u65F6\u95F4\u8868\u7BA1\u7406");
		getContentPane().setBackground(new Color(51, 102, 204));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 593, 679);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u65F6\u95F4\u8868\u7F16\u53F7\uFF1A");
		
		s_ScheduleIdTxt = new JTextField();
		s_ScheduleIdTxt.setColumns(10);
		
		//查询按钮
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleSearchActionPerformed(e);
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(ScheduleManageInterFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(s_ScheduleIdTxt, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)))))
					.addGap(151))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_ScheduleIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel(" \u7F16\u53F7         \uFF1A");
		
		ScheduleIdTxt = new JTextField();
		ScheduleIdTxt.setEditable(false);
		ScheduleIdTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u65F6\u95F4         \uFF1A");
		
		ScheduleTimeTxt = new JTextField();
		ScheduleTimeTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u81EA\u7531\u804C\u4E1A\u8005\u7F16\u53F7\uFF1A");
		
		ScheduleFreeIdTxt = new JTextField();
		ScheduleFreeIdTxt.setColumns(10);
		
		//修改按钮
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleUpdateActionEvent();
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ScheduleManageInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		
		//删除按钮
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleDeleteActionEvent();
				
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ScheduleManageInterFrm.class.getResource("/images/\u5220 \u9664 .png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ScheduleTimeTxt, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
								.addComponent(ScheduleFreeIdTxt)
								.addComponent(ScheduleIdTxt)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(85)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(ScheduleIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(ScheduleFreeIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(ScheduleTimeTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		
		//点击表单
		ScheduleTable = new JTable();
		ScheduleTable.setBackground(new Color(0, 102, 255));
		ScheduleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ScheduleTableMousePressed(e);
				
				
			}
		});
		ScheduleTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u65F6\u95F4\u8868\u7F16\u53F7", "\u81EA\u7531\u804C\u4E1A\u8005\u7F16\u53F7", "\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(ScheduleTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillTable(new Schedule());
	}

	//删除事件
	private void ScheduleDeleteActionEvent() {
		// TODO Auto-generated method stub
		String Sch_Id =ScheduleIdTxt.getText();
		if (StringUtil.isEmpty(Sch_Id)) {
			JOptionPane.showMessageDialog(null, "请选择需要删除的记录！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if (n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=    scheduleDao.delete(con, Sch_Id);
				
				if (deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new Schedule());
					
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
	private void ScheduleUpdateActionEvent() {
		// TODO Auto-generated method stub
		String Sch_Id =ScheduleIdTxt.getText();
		String Sch_Time =ScheduleTimeTxt.getText();
		String Sch_Free_Id =ScheduleFreeIdTxt.getText();
		
		
		if (StringUtil.isEmpty(Sch_Id)) {
			JOptionPane.showMessageDialog(null, "请选择需要修改的记录！");
			return;
		}
		
		if (StringUtil.isEmpty(Sch_Free_Id)) {
			JOptionPane.showMessageDialog(null, "自由职业者编号不能为空！");
			return;
		}
		
		
		if (StringUtil.isEmpty(Sch_Time)) {
			JOptionPane.showMessageDialog(null, "时间表时间不能为空！");
			return;
		}
		
		
		
		
		
		
		
		Schedule schedule=new Schedule(Sch_Id, Sch_Time, Sch_Free_Id);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNumber=  scheduleDao.update(con, schedule);
			
			if (modifyNumber==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.fillTable(new Schedule());
				
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

	//点击表单
	private void ScheduleTableMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		int row= ScheduleTable.getSelectedRow();
		ScheduleIdTxt.setText( (String)ScheduleTable.getValueAt(row, 0));  
		ScheduleFreeIdTxt.setText( (String)ScheduleTable.getValueAt(row, 1));  
		ScheduleTimeTxt.setText((String)ScheduleTable.getValueAt(row, 2));
		
		
		
	}

	//查询事件
	private void ScheduleSearchActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		String s_Schedule_Id=this.s_ScheduleIdTxt.getText(); 
		Schedule schedule=new Schedule();
		schedule.setSch_Id(s_Schedule_Id);
		this.fillTable(schedule);
		
		
	}
	//初始化表格
	
	private void fillTable(Schedule schedule) {
		DefaultTableModel dtm=(DefaultTableModel)ScheduleTable.getModel();
		dtm.setRowCount(0);//行数设置为0
		Connection con = null;
		try {
			con=dbUtil.getCon();
			
			ResultSet rs  = scheduleDao.list(con,schedule);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Sch_Id"));
			
				v.add(rs.getString("Sch_Free_Id"));
				v.add(rs.getString("Sch_Time"));
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
				this.ScheduleIdTxt.setText("");
				this.ScheduleFreeIdTxt.setText("");
				this.ScheduleTimeTxt.setText("");
				
				
			}

	
	
}
