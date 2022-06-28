package com.Ching.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Ching.dao.ConsumerDao;
import com.Ching.model.Consumer;
import com.Ching.model.Freelance;
import com.Ching.util.DbUtil;
import com.Ching.util.StringUtil;

import javax.swing.JScrollPane;
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
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ConsumerManageInterFrm extends JInternalFrame {
	private JTable ConsumerTable;
	private JTextField s_ConsumerTypeTxt;

	private DbUtil dbUtil=new DbUtil();
	private ConsumerDao consumerDao=new ConsumerDao();	
	private JTextField ConsumerIdTxt;
	private JTextField ConsumerNameTxt;
	private JTextField ConsumerTypeTxt;
	private JTextField ConsumerPhoneTxt;
	private JTextArea ConsumerAddrTxt ;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsumerManageInterFrm frame = new ConsumerManageInterFrm();
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
	public ConsumerManageInterFrm() {
		getContentPane().setBackground(new Color(0, 51, 153));
		setTitle("\u666E\u901A\u7528\u6237\u7BA1\u7406");
		setBackground(new Color(102, 102, 204));
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 675, 668);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
					
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u666E\u901A\u7528\u6237\u7C7B\u522B\uFF1A");
		
		s_ConsumerTypeTxt = new JTextField();
		s_ConsumerTypeTxt.setColumns(10);
		
		//查询按钮
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsumerSearchActionPerformed(e);
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(ConsumerManageInterFrm.class.getResource("/images/\u67E5\u8BE2.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_ConsumerTypeTxt, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(110, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
							.addGap(71))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(s_ConsumerTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		
		ConsumerIdTxt = new JTextField();
		ConsumerIdTxt.setEditable(false);
		ConsumerIdTxt.setColumns(10);
		
		ConsumerNameTxt = new JTextField();
		ConsumerNameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u7C7B\u522B\uFF1A");
		
		JLabel lblNewLabel_4 = new JLabel("\u7535\u8BDD\uFF1A");
		
		ConsumerTypeTxt = new JTextField();
		ConsumerTypeTxt.setColumns(10);
		
		ConsumerPhoneTxt = new JTextField();
		ConsumerPhoneTxt.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("\u5730\u5740\uFF1A");
		
		 ConsumerAddrTxt = new JTextArea();
		
		 //修改按钮
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539\uFF1A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConsumerUpdateActionEvent();
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ConsumerManageInterFrm.class.getResource("/images/\u4FEE\u6539.png")));
		
		//删除按钮
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsumerDeleteActionEvent();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ConsumerManageInterFrm.class.getResource("/images/\u5220 \u9664 .png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ConsumerAddrTxt))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ConsumerNameTxt)
								.addComponent(ConsumerIdTxt, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ConsumerTypeTxt)
								.addComponent(ConsumerPhoneTxt, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
					.addContainerGap(85, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(126)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(ConsumerIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(ConsumerTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(ConsumerNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(ConsumerPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(ConsumerAddrTxt, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_2)
								.addComponent(btnNewButton_1)))
						.addComponent(lblNewLabel_4_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		ConsumerTable = new JTable();
		
		//点击表单
		ConsumerTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ConsumerTableMousePressed(e);
			}
		});
		ConsumerTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u7C7B\u522B", "\u59D3\u540D", "\u7535\u8BDD", "\u5730\u5740"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(ConsumerTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Consumer());
	}

	//删除事件
	private void ConsumerDeleteActionEvent() {
		// TODO Auto-generated method stub
		String Con_Id =ConsumerIdTxt.getText();
		if (StringUtil.isEmpty(Con_Id)) {
			JOptionPane.showMessageDialog(null, "请选择需要删除的记录！");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该记录吗？");
		if (n==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
				int deleteNum=    consumerDao.delete(con, Con_Id);
				
				if (deleteNum==1) {
					JOptionPane.showMessageDialog(null, "删除成功！");
					this.resetValue();
					this.fillTable(new Consumer());
					
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

	private void ConsumerUpdateActionEvent() {
		// TODO Auto-generated method stub
		String Con_Id =ConsumerIdTxt.getText();
		String Con_Type =ConsumerTypeTxt.getText();
		String Con_Name =ConsumerNameTxt.getText();
		String Con_Phone =ConsumerPhoneTxt.getText();
		String Con_Addr =ConsumerAddrTxt.getText();
		
		if (StringUtil.isEmpty(Con_Id)) {
			JOptionPane.showMessageDialog(null, "请选择需要修改的记录！");
			return;
		}
		
		if (StringUtil.isEmpty(Con_Type)) {
			JOptionPane.showMessageDialog(null, "普通用户类别不能为空！");
			return;
		}
		
		if (StringUtil.isEmpty(Con_Name)) {
			JOptionPane.showMessageDialog(null, "普通用户姓名不能为空！");
			return;
		}
		
		if (StringUtil.isEmpty(Con_Phone)) {
			JOptionPane.showMessageDialog(null, "普通用户电话不能为空！");
			return;
		}
		
		if (StringUtil.isEmpty(Con_Addr)) {
			JOptionPane.showMessageDialog(null, "普通用户地址不能为空！");
			return;
		}
		
		
		
		Consumer consumer=new Consumer(Con_Id, Con_Type, Con_Name, Con_Phone, Con_Addr);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNumber=  consumerDao.update(con, consumer);
			
			if (modifyNumber==1) {
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();
				this.fillTable(new Consumer());
				
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

	//点击事件
	private void ConsumerTableMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int row= ConsumerTable.getSelectedRow();
		ConsumerIdTxt.setText( (String)ConsumerTable.getValueAt(row, 0));  
		ConsumerTypeTxt.setText( (String)ConsumerTable.getValueAt(row, 1));  
		ConsumerNameTxt.setText((String)ConsumerTable.getValueAt(row, 2));
		ConsumerPhoneTxt.setText((String)ConsumerTable.getValueAt(row, 3));
		ConsumerAddrTxt.setText((String)ConsumerTable.getValueAt(row, 4));
		
		
		
	}

	//查询事件
	private void ConsumerSearchActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String s_Consumer_Type=this.s_ConsumerTypeTxt.getText(); 
		Consumer consumer=new Consumer();
		consumer.setCon_Type(s_Consumer_Type);
		this.fillTable(consumer);
		
		
	}
	
	
	//初始化表格
	
		private void fillTable(Consumer consumer) {
			DefaultTableModel dtm=(DefaultTableModel)ConsumerTable.getModel();
			dtm.setRowCount(0);//行数设置为0
			Connection con = null;
			try {
				con=dbUtil.getCon();
				
				ResultSet rs  = consumerDao.list(con,consumer);
				while (rs.next()) {
					Vector v = new Vector();
					v.add(rs.getString("Con_Id"));
					v.add(rs.getString("Con_Type"));
					v.add(rs.getString("Con_Name"));
					v.add(rs.getString("Con_Phone"));
					v.add(rs.getString("Con_Addr"));
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
					this.ConsumerNameTxt.setText("");
					this.ConsumerPhoneTxt.setText("");
					this.ConsumerAddrTxt.setText("");
					this.ConsumerIdTxt.setText("");
					this.ConsumerTypeTxt.setText("");
					
				}
		
		
}
	

