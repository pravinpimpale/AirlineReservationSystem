package AirlineReservationSystem;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.EventQueue;
import java.sql.*;
import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Set;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.Border;
public class userticket extends JFrame {

	private JPanel contentPane;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,l30;
	JLabel l27_1;
	Border blackline = BorderFactory.createLineBorder(Color.black);
	
	int min = 1;  
	int max = 10;  
	int b = (int)(Math.random()*(max-min+1)+min);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userticket frame = new userticket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	Connection con;
	PreparedStatement pst;
	PreparedStatement pst1;
	PreparedStatement pst2;
	
	
	public void Connect() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
			}catch(Exception e1){ System.out.println(e1);}
	}
	
	
	String username;
	String flightname;
	String source;
	String destination;
	String flightid;
	String departure;
	String date;
	String gate=String.valueOf(b);
	private JLabel lblNewLabel;
	private JLabel lblFlightCode;
	private JLabel lblBoardingTime;
	private JLabel lblNo;
	
	
	/**
	 * Create the frame.
	 */
	public userticket() {
		Connect();
		
		
		
		
		
		
		
		
		setTitle("Flight Ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p1.setBounds(0, 0, 654, 302);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JPanel p3 = new JPanel();
		p3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p3.setBounds(0, 0, 654, 51);
		p1.add(p3);
		p3.setLayout(null);
		
		 l1 = new JLabel("Flight Name");
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l1.setBounds(10, 11, 149, 29);
		p3.add(l1);
		
		 l3 = new JLabel("Boarding Pass (Web Check-in)");
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l3.setBounds(169, 11, 199, 29);
		p3.add(l3);
		
		 l4 = new JLabel("Customer Name");
		l4.setForeground(Color.DARK_GRAY);
		l4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l4.setBounds(10, 62, 213, 29);
		p1.add(l4);
		
		 l5 = new JLabel("From");
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l5.setBounds(394, 62, 88, 29);
		p1.add(l5);
		
		 l7 = new JLabel("where");
		l7.setForeground(Color.DARK_GRAY);
		l7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l7.setBounds(540, 62, 104, 29);
		p1.add(l7);
		
		 l6 = new JLabel("To");
		l6.setForeground(Color.BLUE);
		l6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l6.setBounds(492, 62, 33, 29);
		p1.add(l6);
		
		 l8 = new JLabel(" flight id",SwingConstants.CENTER);
		l8.setForeground(Color.DARK_GRAY);
		l8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l8.setBounds(22, 113, 110, 56);
		l8.setBorder(blackline);
		p1.add(l8);
		
		 l9 = new JLabel("gate",SwingConstants.CENTER);
		 l9.setToolTipText("gateno");
		l9.setForeground(Color.DARK_GRAY);
		l9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l9.setBounds(185, 113, 110, 56);
		l9.setBorder(blackline);
		p1.add(l9);
		
		 l10 = new JLabel("boarding time",SwingConstants.CENTER);
		l10.setForeground(Color.DARK_GRAY);
		l10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l10.setBounds(348, 113, 110, 56);
		l10.setBorder(blackline);
		p1.add(l10);
		
		 l12 = new JLabel("seat",SwingConstants.CENTER);
		l12.setForeground(Color.DARK_GRAY);
		l12.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l12.setBounds(511, 113, 110, 56);
		l12.setBorder(blackline);
		p1.add(l12);
		
		 l13 = new JLabel("QR COde",SwingConstants.CENTER);
		l13.setForeground(Color.DARK_GRAY);
		l13.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l13.setBounds(22, 185, 112, 106);
		l13.setBorder(blackline);
		p1.add(l13);
		
		 l14 = new JLabel("Date :");
		l14.setForeground(Color.DARK_GRAY);
		l14.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		l14.setBounds(142, 185, 52, 29);
		p1.add(l14);
		
		 l15 = new JLabel("22 Jan 2022");
		l15.setForeground(Color.BLUE);
		l15.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l15.setBounds(200, 185, 122, 29);
		p1.add(l15);
		
		 l16 = new JLabel("Departure :");
		l16.setForeground(Color.DARK_GRAY);
		l16.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		l16.setBounds(392, 185, 90, 29);
		p1.add(l16);
		
		 l17 = new JLabel("22 Jan 2022");
		l17.setForeground(Color.BLUE);
		l17.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l17.setBounds(490, 185, 122, 29);
		p1.add(l17);
		
		lblNewLabel = new JLabel("Gate No",SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel.setBounds(185, 90, 110, 23);
		p1.add(lblNewLabel);
		
		lblFlightCode = new JLabel("Flight Code",SwingConstants.CENTER);
		lblFlightCode.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblFlightCode.setBounds(22, 90, 110, 23);
		p1.add(lblFlightCode);
		
		lblBoardingTime = new JLabel("Boarding Time",SwingConstants.CENTER);
		lblBoardingTime.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblBoardingTime.setBounds(348, 90, 110, 23);
		p1.add(lblBoardingTime);
		
		lblNo = new JLabel(" Seat No",SwingConstants.CENTER);
		lblNo.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNo.setBounds(511, 90, 110, 23);
		p1.add(lblNo);
		
		
		JPanel p2 = new JPanel();
		p2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p2.setBounds(655, 0, 229, 302);
		contentPane.add(p2);
		p2.setLayout(null);
		
		JPanel p4 = new JPanel();
		p4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p4.setBounds(0, 0, 229, 51);
		p2.add(p4);
		p4.setLayout(null);
		
		 l2 = new JLabel("Your Departure Terminal");
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l2.setBounds(10, 11, 219, 29);
		p4.add(l2);
		
		 l18 = new JLabel("Customer Name");
		l18.setForeground(Color.DARK_GRAY);
		l18.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l18.setBounds(10, 60, 213, 29);
		p2.add(l18);
		
		 l19 = new JLabel("From");
		l19.setForeground(Color.BLACK);
		l19.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l19.setBounds(10, 91, 88, 29);
		p2.add(l19);
		
		 l20 = new JLabel("To");
		l20.setForeground(Color.BLUE);
		l20.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l20.setBounds(98, 91, 33, 29);
		p2.add(l20);
		
		 l21 = new JLabel("where");
		l21.setForeground(Color.DARK_GRAY);
		l21.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l21.setBounds(10, 124, 104, 29);
		p2.add(l21);
		
		 l22 = new JLabel("Departure :");
		l22.setForeground(Color.DARK_GRAY);
		l22.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		l22.setBounds(10, 158, 90, 29);
		p2.add(l22);
		
		 l23 = new JLabel("22 Jan 2022");
		l23.setForeground(Color.BLUE);
		l23.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l23.setBounds(110, 158, 109, 29);
		p2.add(l23);
		
		 l24 = new JLabel("Date :");
		l24.setForeground(Color.DARK_GRAY);
		l24.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		l24.setBounds(10, 199, 90, 29);
		p2.add(l24);
		
		 l25 = new JLabel("22 Jan 2022");
		l25.setForeground(Color.BLUE);
		l25.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l25.setBounds(114, 198, 109, 29);
		p2.add(l25);
		
		 l26 = new JLabel("QR COde", SwingConstants.CENTER);
		l26.setForeground(Color.DARK_GRAY);
		l26.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l26.setBorder(blackline);
		l26.setBounds(10, 231, 81, 71);
		p2.add(l26);
		
		 l27 = new JLabel("Seat :");
		l27.setForeground(Color.DARK_GRAY);
		l27.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		l27.setBounds(98, 238, 57, 29);
		p2.add(l27);
		
		 l27_1 = new JLabel("02");
		l27_1.setForeground(Color.DARK_GRAY);
		l27_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l27_1.setBounds(165, 238, 57, 29);
		p2.add(l27_1);
		
		
		
		
		
		try {
			pst=con.prepareStatement("SELECT flight_name,source,destination,flight_id,departure,date from flight");//SELECT flight.flight_name,flight.source,flight.destination,flight.flight_id,flight.departure,flight.date,userdata.username FROM flight left JOIN userdata ON flight.id = userdata.id
			ResultSet rs=pst.executeQuery();
			
			pst1=con.prepareStatement("SELECT username from userdata");
			ResultSet rs1=pst1.executeQuery();
			while(rs1.next()) {
				username=rs1.getString("username");
				l4.setText(username);
				l18.setText(username);
			}
			
			
			
			while(rs.next()) {
				
				flightname=rs.getString("flight_name");
				source=rs.getString("source");
				destination=rs.getString("destination");
				flightid=rs.getString("flight_id");
				departure=rs.getString("departure");
				date=rs.getString("date");	
				
				
				l1.setText(flightname);
				
				l5.setText(source);
				l7.setText(destination);
				l8.setText(flightid);
				l9.setText(gate);
				l10.setText(departure);
				l15.setText(date);
				l17.setText(departure);
				
				l19.setText(source);
				l21.setText(destination);
				l23.setText(departure);
				l25.setText(date);
				
			}
			}catch(Exception e1){ System.out.println(e1);}
		
	}
}
