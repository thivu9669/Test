package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;
import javax.swing.event.ChangeEvent;
import java.awt.Font;
import java.awt.TextArea;

public class FrColor extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrColor frame = new FrColor();
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
	JTextArea txtrAbcasdasdasdasdas ;
	JButton btnChangeForeground;
	public FrColor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnColor = new JMenu("Color");
		menuBar.add(mnColor);
		
		JRadioButtonMenuItem rdbtnmntmRed = new JRadioButtonMenuItem("Red");
		rdbtnmntmRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeColor(rdbtnmntmRed, Color.RED);
			}
		});
		
		
		buttonGroup.add(rdbtnmntmRed);
		mnColor.add(rdbtnmntmRed);
		
		JRadioButtonMenuItem rdbtnmntmBlue = new JRadioButtonMenuItem("Blue");
		rdbtnmntmBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeColor(rdbtnmntmBlue, Color.blue);
			}
		});
		
		buttonGroup.add(rdbtnmntmBlue);
		mnColor.add(rdbtnmntmBlue);
		
		JRadioButtonMenuItem rdbtnmntmGreen = new JRadioButtonMenuItem("Green");
		rdbtnmntmGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeColor(rdbtnmntmGreen, Color.green);
			}
		});
		
		buttonGroup.add(rdbtnmntmGreen);
		mnColor.add(rdbtnmntmGreen);
		
		JRadioButtonMenuItem rdbtnmntmAnother = new JRadioButtonMenuItem("Another");
		rdbtnmntmAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeColor(rdbtnmntmAnother, Color.yellow);
			}
		});
		buttonGroup.add(rdbtnmntmAnother);
		mnColor.add(rdbtnmntmAnother);
		
		JSeparator separator = new JSeparator();
		mnColor.add(separator);
		
		JCheckBoxMenuItem chckbxmntmClear = new JCheckBoxMenuItem("Clear");
		chckbxmntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeDefaul();
			}
		});
		mnColor.add(chckbxmntmClear);
		
		JCheckBoxMenuItem chckbxmntmExit = new JCheckBoxMenuItem("Exit");
		chckbxmntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnColor.add(chckbxmntmExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileTest();
			}
		});
		mnEdit.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		mnEdit.add(mntmSave);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 434, 31);
		contentPane.add(toolBar);
		
		btnChangeForeground = new JButton("Change Foreground");
		btnChangeForeground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnChangeForeground.getText().equals("Change Foreground")){
					btnChangeForeground.setText("Change Background");
				}else{
					btnChangeForeground.setText("Change Foreground");
				}
			}
		});
		toolBar.add(btnChangeForeground);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 30, 434, 210);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 210);
		panel.add(scrollPane);
		
		 txtrAbcasdasdasdasdas = new JTextArea();
		 txtrAbcasdasdasdasdas.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 18));
		 txtrAbcasdasdasdasdas.setText("MyLover!!!");
		scrollPane.setViewportView(txtrAbcasdasdasdasdas);
	}

	protected void saveFile() {
		// TODO Auto-generated method stub
		JFileChooser f = new JFileChooser();
		int chon = f.showSaveDialog(getParent());
		
		if (chon==f.APPROVE_OPTION){
			String fName = f.getSelectedFile().getAbsolutePath();
			
			try {
				FileWriter fr = new FileWriter(fName);
			BufferedWriter br = new BufferedWriter(fr);
			
			String noidung= txtrAbcasdasdasdasdas.getText();
			br.write(noidung);
			br.close();
			} catch (IOException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
		}
	}

	protected void ChangeDefaul() {
		// TODO Auto-generated method stub
		txtrAbcasdasdasdasdas.setBackground(Color.white);
		txtrAbcasdasdasdasdas.setBackground(Color.BLACK);
	}
	private void openFileTest(){
		//mo hop thoai chon file
		JFileChooser fc = new JFileChooser("D:/ThiVu/JavaApp");
		fc.setDialogTitle("Chọn file");
		
		int r = fc.showOpenDialog(null);
		if(r == JFileChooser.CANCEL_OPTION) return;
		
		//lay ten tap tin dc chon
		String fName = fc.getSelectedFile().getPath();
		
		Path p = FileSystems.getDefault().getPath(fName);
		try {
			java.util.List<String> line = Files.readAllLines(p, StandardCharsets.UTF_8);
			
			for (String s : line) {
				txtrAbcasdasdasdasdas.append(s+"n/");;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void ChangeColor(JRadioButtonMenuItem rdbtn, Color Color) {
		// TODO Auto-generated method stub
		if(btnChangeForeground.getText().equals("Change Background")){
			if(rdbtn.isSelected()){
				if(rdbtn.getText().equals("Another")){
					Color c = JColorChooser .showDialog(null, "Chọn màu nền", Color.BLUE);
						if (c!=null){
							txtrAbcasdasdasdasdas.setBackground(c);
						}
						return;
				}else{			
					txtrAbcasdasdasdasdas.setBackground(Color);
				}
			}
		}else{
			if(rdbtn.isSelected()){
				if(rdbtn.getText().equals("Another")){
					Color c = JColorChooser .showDialog(null, "Chọn màu nền", Color.BLUE);
						if (c!=null){
							txtrAbcasdasdasdasdas.setForeground(c);
						}
						return;
				}else{			
					txtrAbcasdasdasdasdas.setForeground(Color);
				}
			}
		}
		
		
		
		
	}
}
