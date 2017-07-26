package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;

public class DemoJSlider extends JFrame {

	private JPanel contentPane;
	private JTextField txtHienThi;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoJSlider frame = new DemoJSlider();
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
	private void showdate(){
		Calendar cal = Calendar.getInstance();
		cal.set(slider.getValue(), slider_1.getValue() - 1, slider_2.getValue());
		java.util.Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
		String sDate = sdf.format(d);
		txtHienThi.setText(sDate);
	}
	
	
	JSlider slider;
	JSlider slider_1;
	JSlider slider_2;
	public DemoJSlider() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		slider = new JSlider();
		
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(5);
		slider.setMaximum(2020);
		slider.setMinimum(2000);
		slider.setToolTipText("");
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(10, 102, 332, 40);
		slider.setLabelTable(slider.createStandardLabels(10));
		contentPane.add(slider);
		
		slider_1 = new JSlider();
		slider_1.setSnapToTicks(true);
		slider_1.setPaintLabels(true);
		slider_1.setPaintTicks(true);
		String [] chuoi = {"Jan", "Fer", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
				Hashtable<Integer, JLabel> h = new Hashtable<Integer, JLabel>();
				for (int i = 0; i < chuoi.length ; i++)
						h.put(i, new JLabel(chuoi[i]));
				slider_1.setLabelTable(h);
				slider_1.setValue(0);
		
		slider_1.setMinorTickSpacing(1);
		slider_1.setMaximum(11);
		slider_1.setMajorTickSpacing(1);
		slider_1.setBounds(10, 153, 332, 40);
		contentPane.add(slider_1);
		
		slider_2 = new JSlider();
		
		slider_2.setMinorTickSpacing(1);
		slider_2.setSnapToTicks(true);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setMinimum(1);
		slider_2.setMaximum(31);
		slider_2.setMajorTickSpacing(5);
		slider_2.setBounds(10, 204, 332, 46);
		contentPane.add(slider_2);
		
		txtHienThi = new JTextField();
		txtHienThi.setBounds(36, 33, 178, 40);
		contentPane.add(txtHienThi);
		txtHienThi.setColumns(10);
		
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				showdate();
				
				
			}
		});
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				showdate();
			}
		});
		slider_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				showdate();
			}
		});
	}
	
}
