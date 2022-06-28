package com.Ching.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.Ching.dao.ProjectDao;
import com.Ching.model.Project;
import com.Ching.util.DbUtil;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class InformationInterFrm extends JInternalFrame {
	private JTable InformationTable;
	
	private DbUtil dbUtil=new DbUtil();
	private ProjectDao projectDao=new ProjectDao();	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformationInterFrm frame = new InformationInterFrm();
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
	public InformationInterFrm() {
		setIconifiable(true);
		setClosable(true);
		setBackground(new Color(255, 102, 204));
		setTitle("\u5BA1\u8BA1\u4FE1\u606F");
		setBounds(100, 100, 684, 602);
		
		JScrollPane scrollPane = new JScrollPane();
		
		InformationTable = new JTable();
		InformationTable.setBackground(new Color(255, 102, 153));
		InformationTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9879\u76EE\u7F16\u53F7", "\u7C7B\u522B", "\u81EA\u7531\u804C\u4E1A\u8005\u7F16\u53F7", "\u666E\u901A\u7528\u6237\u7F16\u53F7", "\u5185\u5BB9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(InformationTable);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 599, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		this.fillTable(new Project());
	}
	
	//初始化表格
	
	private void fillTable(Project project) {
		DefaultTableModel dtm=(DefaultTableModel)InformationTable.getModel();
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

}
