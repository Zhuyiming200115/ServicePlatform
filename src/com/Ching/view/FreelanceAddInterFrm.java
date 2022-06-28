package com.Ching.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.Ching.dao.FreelanceDao;
import com.Ching.model.Freelance;
import com.Ching.util.DbUtil;
import com.Ching.util.StringUtil;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Scrollbar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FreelanceAddInterFrm extends JInternalFrame {
	
	private JTextField FreelanceTypeTxt;
	private JTextField FreelanceIdTxt;
	private JTextField FreelanceNameTxt;
	private JTextField FreelancePhoneTxt;
	private JTextArea  FreelanceAddrTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private FreelanceDao freelanceDao=new FreelanceDao();	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FreelanceAddInterFrm frame = new FreelanceAddInterFrm();
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
	public FreelanceAddInterFrm() {
		getContentPane().setBackground(new Color(204, 102, 204));
		setBackground(new Color(204, 0, 204));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u81EA\u7531\u804C\u4E1A\u8005\u6DFB\u52A0");
		setBounds(100, 100, 573, 404);
		
		JLabel lblNewLabel = new JLabel("\u81EA\u7531\u804C\u4E1A\u8005\u59D3\u540D\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u81EA\u7531\u804C\u4E1A\u8005\u7535\u8BDD\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u81EA\u7531\u804C\u4E1A\u8005\u5730\u5740\uFF1A");
		
		FreelanceNameTxt = new JTextField();
		FreelanceNameTxt.setColumns(10);
		
		FreelancePhoneTxt = new JTextField();
		FreelancePhoneTxt.setColumns(10);
		
		FreelanceAddrTxt = new JTextArea();
		
		//添加事件
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FreelanceAddActionPerformed(e);
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(FreelanceAddInterFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
				
				
			}

			
			
		});
		btnNewButton_1.setIcon(new ImageIcon(FreelanceAddInterFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		
		JLabel lblNewLabel_3 = new JLabel("\u81EA\u7531\u804C\u4E1A\u8005\u7C7B\u522B\uFF1A");
		
		JLabel lblNewLabel_4 = new JLabel("\u81EA\u7531\u804C\u4E1A\u8005\u7F16\u53F7\uFF1A");
		
		FreelanceTypeTxt = new JTextField();
		FreelanceTypeTxt.setColumns(10);
		
		FreelanceIdTxt = new JTextField();
		FreelanceIdTxt.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(140)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(157, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(60, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1, Alignment.LEADING)))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(FreelanceIdTxt, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
						.addComponent(FreelanceTypeTxt, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(FreelancePhoneTxt, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(FreelanceNameTxt, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(FreelanceAddrTxt, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
					.addGap(90))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(FreelanceIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(FreelanceTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(FreelanceNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(FreelancePhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(FreelanceAddrTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(lblNewLabel_2)))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(34))
		);
		getContentPane().setLayout(groupLayout);
		
		//设置文本域边框
		FreelanceAddrTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

	}
	
	
	//自由职业者添加事件
	private void FreelanceAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	    String Freelance_Name  = this.FreelanceNameTxt.getText();
	    String Freelance_Phone = this.FreelancePhoneTxt.getText();
	    String Freelance_Addr  = this.FreelanceAddrTxt.getText();
	    
	    
	    
	    String Freelance_Type  = this.FreelanceTypeTxt.getText();                               
	    String Freelance_Id    = this.FreelanceIdTxt.getText() ;
		
	    if (StringUtil.isEmpty(Freelance_Id)) {
	    	JOptionPane.showMessageDialog(null, "自由职业者编号不能为空！");
			return;
		}
	    
	    if (StringUtil.isEmpty(Freelance_Type)) {
	    	JOptionPane.showMessageDialog(null, "自由职业者类别不能为空！");
			return;
		}
	    
	    

	    if (StringUtil.isEmpty(Freelance_Name)) {
	    	JOptionPane.showMessageDialog(null, "自由职业者姓名不能为空！");
			return;
		}
	    
	    if (StringUtil.isEmpty(Freelance_Phone)) {
	    	JOptionPane.showMessageDialog(null, "自由职业者联系电话不能为空！");
			return;
		}
	    
	    if (StringUtil.isEmpty(Freelance_Addr)) {
	    	JOptionPane.showMessageDialog(null, "自由职业者地址不能为空！");
			return;
		}
	    
	    
	    
	    
	    
	    Freelance freelance = new Freelance( Freelance_Id, Freelance_Type,Freelance_Name,Freelance_Phone,Freelance_Addr);
	    Connection con=null;
	    try {
	    	con=dbUtil.getCon();
	    	int n=freelanceDao.add(con,freelance);
	    	if (n==1) {
				JOptionPane.showMessageDialog(null, "添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败！自由职业者编号已存在！");
			}
	    	
	    	
	    	
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
	    	JOptionPane.showMessageDialog(null, "添加失败！自由职业者编号已存在！");
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
		this.FreelanceNameTxt.setText("");
		this.FreelancePhoneTxt.setText("");
		this.FreelanceAddrTxt.setText("");
		this.FreelanceIdTxt.setText("");
		this.FreelanceTypeTxt.setText("");
		
	}
		
	
}
