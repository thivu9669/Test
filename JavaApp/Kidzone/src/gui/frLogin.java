package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;

import dbConnect.MyConnect;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.beans.VetoableChangeListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.beans.PropertyChangeEvent;

public class frLogin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtName;
	private JTextField txtUser;
	private JTextField txtContact;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField pwtPass;
	private JRadioButton rdbAdmin;
	private JRadioButton rdbEmpCall;
	private JRadioButton rdbEmpSale;
	private JButton btnLock;
	Connection conn;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public void loadTable(){
		conn = new MyConnect().getcn();
		
		Object []row = new Object[4];
		try {
			String sql = "SELECT Account.Fullname, Account.Username, Role.Decription, Account.Lock FROM Account INNER JOIN Role ON Account.RoleID = Role.RoleID";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			model.setRowCount(0);
			while(rs.next()){
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frLogin frame = new frLogin();
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
	public frLogin() {
		conn = new MyConnect().getcn();
		if(conn == null){
			JOptionPane.showMessageDialog(getParent(), "Kết nối database thất bại");
			return;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(387, 11, 312, 229);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAccountDetails = new JLabel("ACCOUNT DETAILS");
		lblAccountDetails.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblAccountDetails.setBounds(43, 11, 243, 31);
		panel.add(lblAccountDetails);
		
		JLabel lblFullname = new JLabel("FullName");
		lblFullname.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblFullname.setBounds(10, 67, 111, 14);
		panel.add(lblFullname);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblContact.setBounds(10, 109, 111, 14);
		panel.add(lblContact);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblUsername.setBounds(10, 151, 111, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		lblPassword.setBounds(10, 192, 111, 14);
		panel.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setBounds(131, 64, 171, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtContact = new JTextField();
		txtContact.setBounds(131, 106, 171, 20);
		panel.add(txtContact);
		txtContact.setColumns(10);
		
		txtUser = new JTextField();		
		txtUser.setBounds(131, 148, 171, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		pwtPass = new JPasswordField();
		pwtPass.setEchoChar('*');
		pwtPass.setBounds(131, 190, 171, 20);
		panel.add(pwtPass);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(387, 251, 202, 123);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		rdbEmpCall = new JRadioButton("Employee Call");
		buttonGroup.add(rdbEmpCall);
		rdbEmpCall.setBackground(Color.CYAN);
		rdbEmpCall.setForeground(Color.BLACK);
		rdbEmpCall.setBounds(21, 11, 109, 23);
		panel_1.add(rdbEmpCall);
		
		rdbEmpSale = new JRadioButton("Employee Sale");
		buttonGroup.add(rdbEmpSale);
		rdbEmpSale.setBackground(Color.CYAN);
		rdbEmpSale.setForeground(Color.BLACK);
		rdbEmpSale.setBounds(21, 50, 109, 23);
		panel_1.add(rdbEmpSale);
		
		rdbAdmin = new JRadioButton("Admin");
		rdbAdmin.setSelected(true);
		buttonGroup.add(rdbAdmin);
		rdbAdmin.setBackground(Color.CYAN);
		rdbAdmin.setForeground(Color.BLACK);
		rdbAdmin.setBounds(21, 89, 109, 23);
		panel_1.add(rdbAdmin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(599, 251, 100, 123);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateNew();
			}
		});
		btnCreate.setBounds(10, 11, 80, 23);
		panel_2.add(btnCreate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(10, 50, 80, 23);
		panel_2.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			
			}
		});
		btnClose.setBounds(10, 89, 80, 23);
		panel_2.add(btnClose);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(10, 11, 367, 285);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 347, 263);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				LoadFrom();
			}
		});
		Object[]columns = {"FullName", "UserName", "Role", "Lock"};
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.CYAN);
		panel_4.setBounds(10, 307, 367, 66);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateNew();
			}
		});
		btnUpdate.setBounds(10, 21, 89, 23);
		panel_4.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteOld();
			}
		});
		btnDelete.setBounds(144, 21, 89, 23);
		panel_4.add(btnDelete);
		
		btnLock = new JButton("Lock");
		btnLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetLock();
			}
		});
		btnLock.setBounds(268, 21, 89, 23);
		panel_4.add(btnLock);
		
		loadTable();
	}

	protected void CreateNew() {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(getParent(), "Bạn có muốn thêm")==JOptionPane.OK_OPTION){
			if(!valid())return;
			
			//Đặt biến
			String Fullname = txtName.getText();
			String Contact = txtContact.getText();
			String Username = txtUser.getText();
			String Password = new String(pwtPass.getPassword());
			
			int RoleID;
			if(rdbAdmin.isSelected()) RoleID=1;
			else if(rdbEmpCall.isSelected()) RoleID=2;
			else RoleID=3;
			
			//kết nối
			conn = new MyConnect().getcn();
			try {
				String sql = "insert into Account values(?,?,?,?,?,1)";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				//Mã hóa pass
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				byte []bytePass = md.digest(Password.getBytes());
				
				ps.setString(1, Username);
				ps.setString(2, new String(bytePass));
				ps.setString(3, Fullname);
				ps.setString(4, Contact);
				ps.setInt(5, RoleID);
				
				int kq = ps.executeUpdate();
				if(kq ==0)
					JOptionPane.showMessageDialog(getParent(), "Insert thất bại");
				else
					JOptionPane.showMessageDialog(getParent(), "Insert thành công");
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				JOptionPane.showMessageDialog(getParent(), "Tên Đăng Nhập đã tồn tại");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loadTable();
			reset();
	}
	}
	protected void UpdateNew() {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(getParent(), "Bạn có muốn Thay đổi")==JOptionPane.OK_OPTION){
			if(!valid())return;
			
			//Đặt biến
			String Fullname = txtName.getText();
			String Contact = txtContact.getText();
			String Username = txtUser.getText();
			String Password = new String( pwtPass.getPassword());
			int RoleID;
			if(rdbAdmin.isSelected()) RoleID=1;
			else if(rdbEmpCall.isSelected()) RoleID=2;
			else RoleID=3;
			
			//kết nối
			conn = new MyConnect().getcn();
			try {
				String sql = "update Account set Password = ?, Fullname = ?, Contact = ?, RoleID = ? where Username = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				//Mã hóa pass
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				byte []bytePass = md.digest(Password.getBytes());
				
				ps.setString(5, Username);
				ps.setString(1, new String(bytePass));
				ps.setString(2, Fullname);
				ps.setString(3, Contact);
				ps.setInt(4, RoleID);
				
				int kq = ps.executeUpdate();
				if(kq ==0)
					JOptionPane.showMessageDialog(getParent(), "Update thất bại");
				else
					JOptionPane.showMessageDialog(getParent(), "Update thành công");
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			loadTable();
			reset();
	}
	}
	
	protected void DeleteOld() {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(getParent(), "Bạn có muốn Xóa")==JOptionPane.OK_OPTION){
			
			//Đặt biến
			String Username = txtUser.getText();
			
			//kết nối
			conn = new MyConnect().getcn();
			try {
				String sql = "delete Account where Username = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, Username);
			
				
				int kq = ps.executeUpdate();
				if(kq ==0)
					JOptionPane.showMessageDialog(getParent(), "delete thất bại");
				else
					JOptionPane.showMessageDialog(getParent(), "delete thành công");
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			loadTable();
			reset();
	}
	}
	
	protected void SetLock() {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(getParent(), "Bạn có muốn Khóa/Mở Khóa tài khoản")==JOptionPane.OK_OPTION){
			
			//Đặt biến
			String Username = txtUser.getText();
			
			//kết nối
			conn = new MyConnect().getcn();
			try {
				String sql="";
				if(btnLock.getText() == "Lock")
					 sql = "update Account set Lock = 1 where Username = ?";
				else
					sql = "update Account set Lock = 0 where Username = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, Username);
			
				
				int kq = ps.executeUpdate();
				if(kq ==0)
					JOptionPane.showMessageDialog(getParent(), "Thiết lập thất bại");
				else
					JOptionPane.showMessageDialog(getParent(), "Thiết lập thành công");
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			loadTable();
			reset();
	}
	}
	
	private void reset() {
		// TODO Auto-generated method stub
		txtContact.setText("");
		txtName.setText("");
		txtUser.setText("");
		pwtPass.setText("");
		rdbAdmin.setSelected(true);
	}

	private boolean valid() {
		// TODO Auto-generated method stub
		if(txtContact.getText()=="" | txtName.getText()=="" | txtUser.getText() =="" | pwtPass.getPassword().toString() == "") return false;
		else return true;
	}

	protected void LoadFrom() {
		// TODO Auto-generated method stub
conn = new MyConnect().getcn();
		
		try {
			
			int i = table.getSelectedRow();
			String Username = model.getValueAt(i, 1).toString();
			String sql = "SELECT Account.Fullname, Account.Contact, Account.Username, Account.Password, RoleID, Lock FROM Account where Username like'%" + Username + "%'";
			
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				txtName.setText( rs.getString(1));
				txtUser.setText(rs.getString(3));
				txtContact.setText(rs.getString(2));
				pwtPass.setText(rs.getString(4));
				if(rs.getInt(5) == 1) rdbAdmin.setSelected(true);
				else if(rs.getInt(5) == 2) rdbEmpCall.setSelected(true);
				else rdbEmpSale.setSelected(true);
				if(rs.getInt(6) == 0) btnLock.setText("Lock");
				else btnLock.setText("UnLock");
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
