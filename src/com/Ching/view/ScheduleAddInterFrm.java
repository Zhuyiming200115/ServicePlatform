package com.Ching.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.Ching.dao.ProjectDao;
import com.Ching.dao.ScheduleDao;
import com.Ching.model.Project;
import com.Ching.model.Schedule;
import com.Ching.util.DbUtil;
import com.Ching.util.StringUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ScheduleAddInterFrm extends JInternalFrame {
	private JTextField ScheduleIdTxt;
	private JTextField ScheduleTimeTxt;
	private JTextField ScheduleFreeIdTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private ScheduleDao scheduleDao=new ScheduleDao();	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleAddInterFrm frame = new ScheduleAddInterFrm();
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
	public ScheduleAddInterFrm() {
		setBackground(new Color(153, 102, 255));
		setTitle("\u65F6\u95F4\u8868\u6DFB\u52A0");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 545, 426);
		
		JLabel lblNewLabel = new JLabel("\u65F6\u95F4\u8868\u7F16\u7801    \uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u65F6\u95F4\u8868\u65F6\u95F4    \uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u81EA\u7531\u804C\u4E1A\u8005\u7F16\u53F7\uFF1A");
		
		ScheduleIdTxt = new JTextField();
		ScheduleIdTxt.setColumns(10);
		
		ScheduleTimeTxt = new JTextField();
		ScheduleTimeTxt.setColumns(10);
		
		ScheduleFreeIdTxt = new JTextField();
		ScheduleFreeIdTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setIcon(new ImageIcon(ScheduleAddInterFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ScheduleAddActionPerformed(e);
				
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setIcon(new ImageIcon(ScheduleAddInterFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(161)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(9))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(79)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ScheduleFreeIdTxt, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
								.addComponent(ScheduleTimeTxt)
								.addComponent(ScheduleIdTxt))
							.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)))
					.addGap(158))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(106)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(ScheduleIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(ScheduleTimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(ScheduleFreeIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		

	}

//项目添加事件
private void ScheduleAddActionPerformed(ActionEvent evt) {
// TODO Auto-generated method stub

String Sch_Id  = this.ScheduleIdTxt.getText();
String Sch_Time = this.ScheduleTimeTxt.getText();
String Sch_Free_Id  = this.ScheduleFreeIdTxt.getText();





if (StringUtil.isEmpty(Sch_Id)) {
	JOptionPane.showMessageDialog(null, "时间表编号不能为空！");
	return;
}

if (StringUtil.isEmpty(Sch_Time)) {
	JOptionPane.showMessageDialog(null, "时间表时间不能为空！");
	return;
}



if (StringUtil.isEmpty(Sch_Free_Id )) {
	JOptionPane.showMessageDialog(null, "自由职业者编号不能为空！");
	return;
}






Schedule schedule = new Schedule(Sch_Id, Sch_Time, Sch_Free_Id);
Connection con=null;
try {
	con=dbUtil.getCon();
	int n=scheduleDao.add(con,schedule);
	if (n==1) {
		JOptionPane.showMessageDialog(null, "添加成功！");
		resetValue();
	}else {
		JOptionPane.showMessageDialog(null, "添加失败！时间表编号已存在！");
	}
	
	
	
}catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	JOptionPane.showMessageDialog(null, "添加失败！时间表编号已存在！");
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
		this.ScheduleIdTxt.setText("");
		this.ScheduleTimeTxt.setText("");
		this.ScheduleFreeIdTxt.setText("");
		
	}



		
		
	}


