package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.table.DefaultTableModel;

import dbConnect.MyConnect;
import entities.*;
import model.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frKidzone extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtParent;
	private JTextField txtContact;
	private JTable tblKidzone;
	private JComboBox cbbStandard;
	private JComboBox cbbfee;
	String regID;
	Connection conn;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frKidzone frame = new frKidzone();
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
	// hàm tạo dữ liệu cho combobox
	Vector v1 = new Vector();
	Vector v2 = new Vector();
	
	public void loadComboBox(){
		try {
			String sql = "select * from standards";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				v1.addElement(rs.getString(1));
				v2.addElement(rs.getInt(2));
			}
			
			//đổ dữ liệu vao combobox
			cbbStandard.setModel(new DefaultComboBoxModel(v1));
			cbbfee.setModel(new DefaultComboBoxModel(v2));
			
			//đóng kết nối
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
				
	}
	public void loadTable(){
		conn = new MyConnect().getcn();
		Object []row = new Object[7];
		try {
			String sql = "Select * from Student";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			model.setRowCount(0);
			while(rs.next()){
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				row[6] = rs.getString(7);
				model.addRow(row);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	private boolean valid(){
		if(txtAddress.getText() ==""|txtContact.getText().length() <=7|txtContact.getText().length()>=12|txtName.getText()==""|txtParent.getText()==""){
			return false;
		}
		else return true;
		
		
	}
	
	public frKidzone() {
		
		conn = new MyConnect().getcn();
		if(conn == null){
			JOptionPane.showMessageDialog(getParent(), "Kết nối database thất bại");
			return;
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 11, 444, 180);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 19, 113, 14);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 50, 113, 14);
		panel.add(lblAddress);
		
		JLabel lblParentsName = new JLabel("Parent's Name");
		lblParentsName.setBounds(10, 82, 113, 14);
		panel.add(lblParentsName);
		
		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setBounds(10, 113, 113, 14);
		panel.add(lblContactNo);
		
		JLabel lblStandard = new JLabel("Standard");
		lblStandard.setBounds(10, 144, 113, 14);
		panel.add(lblStandard);
		
		JLabel lblFee = new JLabel("fee");
		lblFee.setBounds(251, 144, 46, 14);
		panel.add(lblFee);
		
		txtName = new JTextField();
		txtName.setBounds(133, 16, 301, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(133, 47, 301, 20);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtParent = new JTextField();
		txtParent.setBounds(133, 79, 301, 20);
		panel.add(txtParent);
		txtParent.setColumns(10);
		
		txtContact = new JTextField();
		txtContact.setBounds(133, 110, 301, 20);
		panel.add(txtContact);
		txtContact.setColumns(10);
		
		cbbStandard = new JComboBox();
		cbbStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbbfee.setSelectedIndex(cbbStandard.getSelectedIndex());
			}
		});
		cbbStandard.setBounds(133, 141, 86, 20);
		panel.add(cbbStandard);
		
		cbbfee = new JComboBox();
		cbbfee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbbStandard.setSelectedIndex(cbbfee.getSelectedIndex());
			}
		});
		cbbfee.setBounds(303, 141, 91, 20);
		panel.add(cbbfee);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(10, 202, 444, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setBounds(10, 11, 89, 23);
		panel_1.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdate.setBounds(122, 11, 89, 23);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setBounds(234, 11, 89, 23);
		panel_1.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(345, 11, 89, 23);
		panel_1.add(btnReset);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(10, 253, 444, 136);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 114);
		panel_2.add(scrollPane);
		
		tblKidzone = new JTable();
		tblKidzone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ClickOnTable();
			}
		});
		scrollPane.setViewportView(tblKidzone);
		
		Object[]columns = {"RegID", "Name", "Address", "Parent", "Contact", "Standard", "fee"};
		model.setColumnIdentifiers(columns);
		tblKidzone.setModel(model);
			//ẩn cột đầu
		tblKidzone.removeColumn(tblKidzone.getColumnModel().getColumn(0));
		
		loadComboBox();
		loadTable();
	}
	protected void reset() {
		// TODO Auto-generated method stub
		txtName.setText("");
		txtAddress.setText("");
		txtContact.setText("");
		txtParent.setText("");
		cbbStandard.setSelectedIndex(0);
	}
	protected void delete() {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(getParent(), "Bạn có muốn xóa")==JOptionPane.OK_OPTION){
			//tạo kết nối
			conn = new MyConnect().getcn();
			try {
				String sql = "delete from Student where RegID = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, regID);
				int kq = ps.executeUpdate();
				if(kq==0)
					JOptionPane.showMessageDialog(getParent(), "Delete không thành Công");
				else
					JOptionPane.showMessageDialog(getParent(), "Delete thành Công");
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			loadTable();
			reset();
		}
	}
	protected void update() {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(getParent(), "Bạn có muốn cập nhập")==JOptionPane.OK_OPTION){
			if(!valid())return;
			
			//Đặt biến
			String name = txtName.getText();
			String address = txtAddress.getText();
			String parentName = txtParent.getText();
			String phone = txtContact.getText();
			String standard = (String) cbbStandard.getSelectedItem();
			
			
			//kết nối
			conn = new MyConnect().getcn();
			try {
				String sql = "update Student set Name = ?, Address = ?, parentName=?, phone=?, standard = ? where RegID = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, name);
				ps.setString(2, address);
				ps.setString(3, parentName);
				ps.setString(4, phone);
				ps.setString(5, standard);
				ps.setString(6, regID);
				
				int kq = ps.executeUpdate();
				if(kq ==0)
					JOptionPane.showMessageDialog(getParent(), "Update thất bại");
				else
					JOptionPane.showMessageDialog(getParent(), "Update thành công");
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			loadTable();
			reset();
		}
	}
	protected void ClickOnTable() {
		// TODO Auto-generated method stub
		int i = tblKidzone.getSelectedRow();
		regID = model.getValueAt(i, 0).toString();
		String name = model.getValueAt(i, 1).toString();
		String address = model.getValueAt(i, 2).toString();
		String parent = model.getValueAt(i, 3).toString();
		String contact = model.getValueAt(i, 4).toString();
		String standard = model.getValueAt(i, 5).toString();
	
		txtName.setText(name);
		txtAddress.setText(address);
		txtContact.setText(contact);
		txtParent.setText(parent);
		cbbStandard.setSelectedItem(standard);
	}
	protected void save() {
		// TODO Auto-generated method stub
		//Kiểm tra điều kiện nhập
		if(JOptionPane.showConfirmDialog(getParent(), "Bạn có muốn thêm")==JOptionPane.OK_OPTION){
			if(!valid())return;
			
			//Đặt biến
			String name = txtName.getText();
			String address = txtAddress.getText();
			String parentName = txtParent.getText();
			String phone = txtContact.getText();
			String standard = (String) cbbStandard.getSelectedItem();
			Calendar c = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			String refDate = df.format(c.getTime());
			
			//kết nối
			conn = new MyConnect().getcn();
			try {
				String sql = "insert into Student values(?,?,?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, name);
				ps.setString(2, address);
				ps.setString(3, parentName);
				ps.setString(4, phone);
				ps.setString(5, standard);
				ps.setString(6, refDate);
				
				int kq = ps.executeUpdate();
				if(kq ==0)
					JOptionPane.showMessageDialog(getParent(), "Insert thất bại");
				else
					JOptionPane.showMessageDialog(getParent(), "Insert thành công");
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			loadTable();
			reset();
		}
	}

}
