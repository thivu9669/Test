package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrDangKy extends JFrame {

	private JPanel contentPane;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrDangKy frame = new FrDangKy();
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
	public FrDangKy() {
		setTitle("Form Đăng Ký");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 469);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(null, "Gi\u1EDBi T\u00EDnh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(445, 24, 67, 110);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JRadioButton rdbtnNu = new JRadioButton("N\u1EEF");
		rdbtnNu.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnNu);
		panel_1.add(rdbtnNu, BorderLayout.CENTER);
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setSelected(true);
		rdbtnNam.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnNam);
		panel_1.add(rdbtnNam, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "S\u1EDF Th\u00EDch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(25, 145, 487, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JCheckBox chckbxGame = new JCheckBox("Game");
		chckbxGame.setSelected(true);
		chckbxGame.setBounds(46, 21, 132, 23);
		panel.add(chckbxGame);
		
		JCheckBox chckbxSach = new JCheckBox("\u0110\u1ECDc S\u00E1ch");
		chckbxSach.setBounds(205, 21, 132, 23);
		panel.add(chckbxSach);
		
		JCheckBox chckbxHoc = new JCheckBox("H\u1ECDc Ti\u1EBFng Anh");
		chckbxHoc.setBounds(345, 21, 136, 23);
		panel.add(chckbxHoc);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(25, 212, 487, 110);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTrnh = new JLabel("Tr\u00ECnh \u0110\u1ED9");
		lblTrnh.setBounds(10, 11, 41, 14);
		panel_2.add(lblTrnh);
		
		JLabel lblKinThm = new JLabel("\u00DD Ki\u1EBFn Th\u00EAm");
		lblKinThm.setBounds(245, 11, 136, 14);
		panel_2.add(lblKinThm);
		
		JComboBox cbbTrinhDo = new JComboBox();
		cbbTrinhDo.setModel(new DefaultComboBoxModel(new String[] {"[Ch\u1ECDn B\u1EB1ng C\u1EA5p]", "12/12", "Trung C\u1EA5p", "Cao \u0110\u1EB3ng", "\u0110\u1EA1i H\u1ECDc"}));
		cbbTrinhDo.setBounds(10, 29, 186, 30);
		panel_2.add(cbbTrinhDo);
		
		JTextArea tarYKien = new JTextArea();
		tarYKien.setWrapStyleWord(true);
		tarYKien.setLineWrap(true);
		tarYKien.setBounds(245, 32, 200, 67);
		panel_2.add(tarYKien);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(35, 333, 487, 84);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		
		
		
		
		JLabel lblThongBao = new JLabel("Th\u00F4ng B\u00E1o !!!");
		lblThongBao.setBounds(10, 11, 384, 14);
		panel_3.add(lblThongBao);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(25, 24, 410, 110);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(10, 85, 118, 14);
		panel_4.add(lblEmail);
		
		JLabel lblHTn = new JLabel("H\u1ECD T\u00EAn: ");
		lblHTn.setBounds(10, 60, 118, 14);
		panel_4.add(lblHTn);
		
		JLabel lblFormngK = new JLabel("FORM \u0110\u0102NG K\u00DD");
		lblFormngK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblFormngK.setBounds(128, 11, 168, 44);
		panel_4.add(lblFormngK);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(138, 56, 206, 22);
		panel_4.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(138, 81, 206, 22);
		panel_4.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtHoTen.setText("");
				txtEmail.setText("");
				chckbxGame.setSelected(false);
				chckbxHoc.setSelected(false);
				chckbxSach.setSelected(false);
				cbbTrinhDo.setSelectedIndex(0);
				tarYKien.setText("");
				lblThongBao.setText("");
			}
		});
		btnReset.setBounds(119, 50, 91, 23);
		panel_3.add(btnReset);
		
		JButton btnngK = new JButton("\u0110\u0103ng K\u00FD");
		btnngK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Kiểm tra họ tên
				String hoTen = txtHoTen.getText().trim();
				if (hoTen.equalsIgnoreCase("")){
					lblThongBao.setText("Bạn Chưa điền Họ Tên, ");
					txtHoTen.requestFocusInWindow();
					return;
				}
				//Kiểm tra Email
				String Email = txtEmail.getText().trim();
				String mau = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
				Pattern p = Pattern.compile(mau);
				Matcher m = p.matcher(Email);
				if(!m.matches()){
					lblThongBao.setText("Email ko đúng chuẩn");
					txtEmail.requestFocusInWindow();
					return;
				}
				//Kiểm tra checkBox
				if(!(chckbxGame.isSelected() || chckbxHoc.isSelected() || chckbxSach.isSelected()) ){
					lblThongBao.setText("Chưa chọn sở thích");
					return;
				}
				//kiểm tra combobox
				int chon = cbbTrinhDo.getSelectedIndex();
				if(chon == 0){
					lblThongBao.setText("Chưa chọn trình độ");
					return;
				}
				
				lblThongBao.setText("Đăng ký thành công");
			}
		});
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnngK.setBounds(253, 50, 91, 23);
		panel_3.add(btnngK);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
