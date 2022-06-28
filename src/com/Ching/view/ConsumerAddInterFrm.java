package com.Ching.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.Ching.dao.ConsumerDao;
import com.Ching.model.Consumer;
import com.Ching.util.DbUtil;
import com.Ching.util.StringUtil;
import java.awt.SystemColor;
import java.awt.Color;

public class ConsumerAddInterFrm extends JInternalFrame {
	
	

	private JTextField ConsumerTypeTxt;
	private JTextField ConsumerIdTxt;
	private JTextField ConsumerNameTxt;
	private JTextField ConsumerPhoneTxt;
	private JTextArea  ConsumerAddrTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private ConsumerDao consumerDao=new ConsumerDao();	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsumerAddInterFrm frame = new ConsumerAddInterFrm();
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
	public ConsumerAddInterFrm() {
		setBackground(new Color(204, 102, 255));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u81EA\u7531\u804C\u4E1A\u8005\u6DFB\u52A0");
		setBounds(100, 100, 573, 404);
		
		JLabel lblNewLabel = new JLabel("\u666E\u901A\u7528\u6237\u59D3\u540D\uFF1A");
		
		JLabel lblNewLabel_1 = new JLabel("\u666E\u901A\u7528\u6237\u7535\u8BDD\uFF1A");
		
		JLabel lblNewLabel_2 = new JLabel("\u666E\u901A\u7528\u6237\u5730\u5740\uFF1A");
		
		ConsumerNameTxt = new JTextField();
		ConsumerNameTxt.setColumns(10);
		
		ConsumerPhoneTxt = new JTextField();
		ConsumerPhoneTxt.setColumns(10);
		
		ConsumerAddrTxt = new JTextArea();
		
		//添加事件
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsumerAddActionPerformed(e);
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(ConsumerAddInterFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
				
				
			}

			
			
		});
		btnNewButton_1.setIcon(new ImageIcon(ConsumerAddInterFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		
		JLabel lblNewLabel_3 = new JLabel("\u666E\u901A\u7528\u6237\u7C7B\u522B\uFF1A");
		
		JLabel lblNewLabel_4 = new JLabel("\u666E\u901A\u7528\u6237\u7F16\u53F7\uFF1A");
		
		ConsumerTypeTxt = new JTextField();
		ConsumerTypeTxt.setColumns(10);
		
		ConsumerIdTxt = new JTextField();
		ConsumerIdTxt.setColumns(10);
		
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
						.addComponent(ConsumerIdTxt, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
						.addComponent(ConsumerTypeTxt, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(ConsumerPhoneTxt, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(ConsumerNameTxt, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
						.addComponent(ConsumerAddrTxt, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
					.addGap(90))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(ConsumerIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(ConsumerTypeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConsumerNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ConsumerPhoneTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(ConsumerAddrTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
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
		ConsumerAddrTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

	}
	
	
	//自由职业者添加事件
	private void ConsumerAddActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	    String Consumer_Name  = this.ConsumerNameTxt.getText();
	    String Consumer_Phone = this.ConsumerPhoneTxt.getText();
	    String Consumer_Addr  = this.ConsumerAddrTxt.getText();
	    
	    
	    
	    String Consumer_Type  = this.ConsumerTypeTxt.getText();                               
	    String Consumer_Id    = this.ConsumerIdTxt.getText() ;
		
	    if (StringUtil.isEmpty(Consumer_Id)) {
	    	JOptionPane.showMessageDialog(null, "自由职业者编号不能为空！");
			return;
		}
	    
	    if (StringUtil.isEmpty(Consumer_Type)) {
	    	JOptionPane.showMessageDialog(null, "自由职业者类别不能为空！");
			return;
		}
	    
	    

	    if (StringUtil.isEmpty(Consumer_Name)) {
	    	JOptionPane.showMessageDialog(null, "自由职业者姓名不能为空！");
			return;
		}
	    
	    if (StringUtil.isEmpty(Consumer_Phone)) {
	    	JOptionPane.showMessageDialog(null, "自由职业者联系电话不能为空！");
			return;
		}
	    
	    if (StringUtil.isEmpty(Consumer_Addr)) {
	    	JOptionPane.showMessageDialog(null, "自由职业者地址不能为空！");
			return;
		}
	    
	    
	    
	    
	    
	    Consumer consumer = new Consumer( Consumer_Id, Consumer_Type,Consumer_Name,Consumer_Phone,Consumer_Addr);
	    Connection con=null;
	    try {
	    	con=dbUtil.getCon();
	    	int n=consumerDao.add(con,consumer);
	    	if (n==1) {
				JOptionPane.showMessageDialog(null, "添加成功！");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败！普通用户编号已存在！");
			}
	    	
	    	
	    	
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
	    	JOptionPane.showMessageDialog(null, "添加失败！普通用户编号已存在！");
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
		this.ConsumerNameTxt.setText("");
		this.ConsumerPhoneTxt.setText("");
		this.ConsumerAddrTxt.setText("");
		this.ConsumerIdTxt.setText("");
		this.ConsumerTypeTxt.setText("");
		
	}

}
