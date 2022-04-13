package AirlineReservationSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminDashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
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
	public AdminDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1000, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(255, 255, 255));
		p1.setBounds(10, 11, 964, 102);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("G:\\JAVA\\plane-9922.png"));
		l1.setBounds(42, 11, 240, 80);
		p1.add(l1);
		
		JLabel l2 = new JLabel("Airline Reservation System");
		l2.setForeground(new Color(255, 69, 0));
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		l2.setBounds(308, 11, 460, 80);
		p1.add(l2);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(0, 255, 255));
		p2.setBounds(10, 111, 964, 62);
		contentPane.add(p2);
		p2.setLayout(null);
		
		JLabel l3 = new JLabel("Dashboard");
		l3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(true);
			}
		});
		l3.setForeground(new Color(0, 128, 0));
		l3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		l3.setBounds(10, 11, 126, 40);
		p2.add(l3);
		
		JLabel l5 = new JLabel("Flight");
		l5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddFlight frame = new AddFlight();
				frame.setVisible(true);
			}
		});
		l5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l5.setBounds(157, 11, 74, 40);
		p2.add(l5);
		
		JLabel l6 = new JLabel("Staff");
		l6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddStaff frame = new AddStaff();
				frame.setVisible(true);
			}
		});
		l6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l6.setBounds(241, 11, 74, 40);
		p2.add(l6);
		
		JLabel l7 = new JLabel("Flight Booked");
		l7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l7.setBounds(320, 11, 133, 40);
		p2.add(l7);
		
		JLabel l8 = new JLabel("Airports");
		l8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l8.setBounds(463, 11, 92, 40);
		p2.add(l8);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\JAVA\\10 - Copy (2).jpg"));
		lblNewLabel.setBounds(10, 184, 964, 366);
		contentPane.add(lblNewLabel);
	}
}
