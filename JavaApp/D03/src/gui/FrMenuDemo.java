package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrMenuDemo extends JFrame {

	private JPanel contentPanel;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrMenuDemo frame = new FrMenuDemo();
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
	JTextArea textArea;
	JEditorPane editorPane;
	public FrMenuDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 351);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setIcon(new ImageIcon(FrMenuDemo.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		menuBar.add(mnFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileTest();
			}
		});
		
		mntmNewMenuItem.setIcon(new ImageIcon(FrMenuDemo.class.getResource("/javax/swing/plaf/metal/icons/ocean/upFolder.gif")));
		mnFile.add(mntmNewMenuItem);
		
		JMenuItem mntmClose = new JMenuItem("Save");
		mntmClose.setIcon(new ImageIcon(FrMenuDemo.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mnFile.add(mntmClose);
		
		JMenu mnSystem = new JMenu("System");
		mnSystem.setIcon(new ImageIcon(FrMenuDemo.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
		menuBar.add(mnSystem);
		
		JMenu mnLanguege = new JMenu("Languege");
		mnLanguege.setIcon(new ImageIcon(FrMenuDemo.class.getResource("/javax/swing/plaf/metal/icons/ocean/expanded.gif")));
		mnSystem.add(mnLanguege);
		
		JRadioButtonMenuItem rdbtnmntmEngligh = new JRadioButtonMenuItem("Engligh");
		buttonGroup.add(rdbtnmntmEngligh);
		mnLanguege.add(rdbtnmntmEngligh);
		
		JRadioButtonMenuItem rdbtnmntmVietnamese = new JRadioButtonMenuItem("Vietnamese");
		buttonGroup.add(rdbtnmntmVietnamese);
		mnLanguege.add(rdbtnmntmVietnamese);
		
		JMenuItem mntmAboutUs = new JMenuItem("About us");
		mnSystem.add(mntmAboutUs);
		
		JMenuItem mntmClose_1 = new JMenuItem("Close");
		mnSystem.add(mntmClose_1);
		
		JSeparator separator = new JSeparator();
		mnSystem.add(separator);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 434, 290);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 38, 414, 84);
		panel.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		JLabel lblTestarea = new JLabel("TestArea");
		lblTestarea.setBounds(191, 13, 46, 14);
		panel.add(lblTestarea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 159, 414, 120);
		panel.add(scrollPane);
		
		editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(editorPane, popupMenu);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		popupMenu.add(mntmOpen);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		popupMenu.add(mntmReset);
		
		JMenuItem mntmChangeBackground = new JMenuItem("Change Background");
		mntmChangeBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeBGColor();
				}
		});
		popupMenu.add(mntmChangeBackground);
		
		JLabel lblEditorpane = new JLabel("EditorPane");
		lblEditorpane.setBounds(130, 133, 159, 14);
		panel.add(lblEditorpane);
		
	}
	protected void ChangeBGColor() {
		// TODO Auto-generated method stub
		Color c = JColorChooser .showDialog(null, "Chọn màu nền", Color.BLUE);
		if (c!=null){
			textArea.setBackground(c);
		}
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
				textArea.append(s+"n/");;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
