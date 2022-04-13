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
import javax.swing.SwingConstants;

public class UserDasboard extends JFrame {

	JLabel l9;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDasboard frame = new UserDasboard();
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
	public UserDasboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(255, 255, 255));
		p1.setBounds(10, 11, 964, 102);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel("");
		l1.setIcon(new ImageIcon("G:\\JAVA\\plane-9922.png"));
		l1.setBounds(57, 11, 240, 80);
		p1.add(l1);
		
		JLabel l2 = new JLabel("Airline Reservation System");
		l2.setForeground(new Color(255, 69, 0));
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		l2.setBounds(325, 11, 391, 80);
		p1.add(l2);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(0, 255, 255));
		p2.setBounds(10, 115, 964, 48);
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
		l3.setBounds(24, 11, 124, 26);
		p2.add(l3);
		
		JLabel l5 = new JLabel("Ticket Booking");
		l5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TicketBooking frame = new TicketBooking();
				frame.setVisible(true);
			}
		});
		l5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l5.setBounds(181, 11, 142, 26);
		p2.add(l5);
		
		JLabel l7 = new JLabel("Ticket Cancle");
		l7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				l9.setText("<html><body><center><form action=\"/\">\r\n"
						+ "  <label for=\"fname\">Seat No:</label><br>\r\n"
						+ "  <input type=\"text\" id=\"fname\" name=\"fname\" value=\"\"><br>\r\n"
						+ "  <label for=\"lname\">Flight No:</label><br>\r\n"
						+ "  <input type=\"text\" id=\"lname\" name=\"lname\" value=\"\"><br><br>\r\n"
						+ "  <input type=\"submit\" value=\"Submit\">\r\n"
						+ "</form> </center></body></html>");
			}
		});
		l7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l7.setBounds(333, 11, 142, 26);
		p2.add(l7);
		
		JLabel l8 = new JLabel("Refund");
		l8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l8.setBounds(485, 11, 83, 26);
		p2.add(l8);
		
		JPanel p3 = new JPanel();
		p3.setBackground(new Color(245, 245, 220));
		p3.setBounds(10, 174, 964, 376);
		contentPane.add(p3);
		p3.setLayout(null);
		
		l9 = new JLabel("");
		l9.setVerticalAlignment(SwingConstants.TOP);
		l9.setBounds(10, 11, 348, 354);
		p3.add(l9);
	}
}
