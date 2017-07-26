package gui;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dbConnect.MyConnect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class frIn extends JFrame {
	Connection conn;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField pwfPass;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frIn frame = new frIn();
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
	public frIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 14, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 39, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(99, 11, 139, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		pwfPass = new JPasswordField();
		pwfPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					System.out.println("a");
					btnNewButton_1.requestFocus();
					
				}
			}
		});
		pwfPass.setEchoChar('*');
		pwfPass.setBounds(99, 36, 139, 20);
		contentPane.add(pwfPass);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBounds(20, 64, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				Login();
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		btnNewButton_1.setBounds(138, 64, 89, 23);
		contentPane.add(btnNewButton_1);
	}

	protected void Login() {
		// TODO Auto-generated method stub
		conn = new MyConnect().getcn();
		if(conn ==null)
		{
			JOptionPane.showMessageDialog(getParent(), "Login false");
			return;
		}
		String User = txtUser.getText();
		String Pass = new String(pwfPass.getPassword());
		
		try {
			//mã hóa pass
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[]  bytePass = md.digest(Pass.getBytes());
			
			//Đổi về chuổi để so sánh
			String SHAPass = new String(bytePass);
			
			//So Sánh CSDL
			String sql = "select Username, Password, Lock, RoleID from Account where Username like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, User);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if(rs.getBoolean(3)==false){ 
					JOptionPane.showMessageDialog(getParent(), "Username is lock"); 
					return;
				}
				else
					if(SHAPass.equals(rs.getString(2))){
						JOptionPane.showMessageDialog(getParent(), "Login Success");
					
						//mở from mới
						if(rs.getInt(4)==1){
								frLogin login = new frLogin();
								login.setVisible(true);
						}else JOptionPane.showMessageDialog(getParent(), "wellcomeback");
						dispose();//ẩn frame
				
					}else JOptionPane.showMessageDialog(getParent(), "Login false");
			}else JOptionPane.showMessageDialog(getParent(), "Username not exit");
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
}
