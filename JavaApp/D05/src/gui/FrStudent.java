package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import entities.*;
import model.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent; 

public class FrStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTable viewStudent;
	private JComboBox cbbBatch;
	private JButton btnSeach;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrStudent frame = new FrStudent();
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
	public FrStudent() {	
		initComnonents();
		initDataComboBatch();
		intModelStudent();
	}
	
	DefaultTableModel modelStudent;
	TableRowSorter<TableModel> sorter;
	private JScrollPane scrollPane;
	private void intModelStudent() {
		// TODO Auto-generated method stub
		modelStudent = (DefaultTableModel) viewStudent.getModel();
		modelStudent.setRowCount(0);
		List<Student> ds = StudentDAO.getList();
		for (Student student : ds) {
			modelStudent.addRow(student.toVector());
		}
		
		viewStudent.setAutoCreateRowSorter(true);
		sorter= (TableRowSorter<TableModel>)viewStudent.getRowSorter();
	}

	private void initDataComboBatch() {
		// TODO Auto-generated method stub
		List<Batch> ds = BatchDAO.getList();
		for (Batch batch : ds) {
			cbbBatch.addItem(batch.getBatchno());
		}
	}

	private void initComnonents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 85);
		panel.setBackground(Color.CYAN);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SeachByName();
			}
			
		});
		txtName.setBounds(78, 8, 127, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblBatchno = new JLabel("Batchno:");
		lblBatchno.setBounds(237, 11, 77, 14);
		panel.add(lblBatchno);
		
		cbbBatch = new JComboBox();
		cbbBatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeachByBatch();
			}
		});
		cbbBatch.setBounds(312, 8, 102, 20);
		panel.add(cbbBatch);
		
		btnSeach = new JButton("Seach");
		btnSeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SeachByAll();
			}
		});
		btnSeach.setBounds(171, 51, 89, 23);
		panel.add(btnSeach);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(5, 101, 424, 149);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 404, 127);
		panel_1.add(scrollPane);
		
		viewStudent = new JTable();
		scrollPane.setViewportView(viewStudent);
		viewStudent.setFillsViewportHeight(true);
		viewStudent.setSurrendersFocusOnKeystroke(true);
		viewStudent.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		viewStudent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "LastName", "FirstName", "Gender", "Phone", "BatchNo"
			}
		));
		viewStudent.getColumnModel().getColumn(0).setPreferredWidth(43);
		viewStudent.getColumnModel().getColumn(1).setPreferredWidth(127);
		viewStudent.getColumnModel().getColumn(3).setPreferredWidth(46);
		viewStudent.getColumnModel().getColumn(4).setPreferredWidth(40);
		viewStudent.getColumnModel().getColumn(5).setPreferredWidth(51);
	}

	protected void SeachByAll() {
		// TODO Auto-generated method stub
		if(sorter ==null) return;
		String DK1 ="(?i)"+txtName.getText().trim();
		String DK2 = cbbBatch.getSelectedItem().toString();
		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		  filters.add(RowFilter.regexFilter(DK1, 1,2));
		  filters.add(RowFilter.regexFilter(DK2, 5));
		  sorter.setRowFilter(RowFilter.andFilter(filters));

	
	}

	protected void SeachByName() {
		// TODO Auto-generated method stub
		if(sorter == null)return;
		String DK = "(?i)"+txtName.getText().trim();
		sorter.setRowFilter(RowFilter.regexFilter(DK, 1,2));
	}
	protected void SeachByBatch() {
		// TODO Auto-generated method stub
		if(sorter == null)return;
		String DK = cbbBatch.getSelectedItem().toString();
		sorter.setRowFilter(RowFilter.regexFilter(DK, 5));
		
	}
}
