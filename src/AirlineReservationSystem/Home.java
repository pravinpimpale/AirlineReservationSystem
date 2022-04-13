package AirlineReservationSystem;

import java.awt.BorderLayout;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
import java.awt.EventQueue;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.event.*;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Home extends JFrame {

	JLabel l9;
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("airline reservation system");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1000, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(0, 255, 255));
		p1.setBounds(10, 114, 964, 70);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel("Home");
		l1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				l1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		l1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		l1.setBackground(new Color(0, 255, 255));
		l1.setForeground(new Color(0, 0, 128));
		l1.setBounds(58, 21, 80, 33);
		p1.add(l1);
		
		JLabel l2 = new JLabel("About Us");
		l2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				l9.setText("<html><h1 style='color:orange'>Abouts</h1><hr><p>Online Flight Reservation System is a web application that helps the commuters to book flight ticket online. In order to book ticket, the commuter has to register himself by filling up the details. Once the user had registered himself he has to login in order to book the ticket. While booking the user has to select the type of airlines he will be travelling and he has to specify the place he is going to travel between. According to the type of airlines and place, the system will provide information regarding flight and venue which are available on the date specified by the Commuter. Commuter can view the reservation after booking the ticket. Commuter will be able to view the details related to his reservation. The System will provide notice related to flight to the passengers.\r\n"
						+ "In Online Flight Reservation System the admin can view the reservation done by the passengers and can add notice that is related to flight.</p></html>");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				l2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		l2.setBackground(new Color(0, 255, 255));
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		l2.setForeground(new Color(0, 0, 128));
		l2.setBounds(174, 21, 103, 33);
		p1.add(l2);
		
		JLabel l3 = new JLabel("Contact Us");
		l3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				l9.setText("<html><body style='margin-left:200px'><center><h1 style='color:orange'>Contact Us</h1><hr><h3 style='color:blue'>Address: Spark Institute, Pune</h3><h3 style='color:blue'>Phone-no.:020-8845652314</h3><h3 style='color:blue'>Fax-no.:4735454853</h3><h3 style='color:blue'>E-mail:abcshdu@gmail.com</h3></center></body></html>");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		l3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		l3.setBackground(new Color(0, 255, 255));
		l3.setForeground(new Color(0, 0, 128));
		l3.setBounds(307, 21, 118, 33);
		p1.add(l3);
		
		JLabel l4 = new JLabel("Login");
		l4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				l4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		l4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		l4.setBackground(new Color(0, 255, 255));
		l4.setForeground(new Color(0, 0, 128));
		l4.setBounds(461, 21, 73, 33);
		p1.add(l4);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		p2.setBounds(10, 11, 964, 102);
		contentPane.add(p2);
		p2.setLayout(null);
		
		JLabel l5 = new JLabel("");
		l5.setIcon(new ImageIcon("G:\\JAVA\\plane-9922.png"));
		l5.setBounds(49, 11, 240, 80);
		p2.add(l5);
		
		JLabel l6 = new JLabel("Airline Reservation System");
		l6.setForeground(new Color(255, 69, 0));
		l6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 47));
		l6.setBounds(330, 11, 552, 80);
		p2.add(l6);
		
		JPanel p3 = new JPanel();
		p3.setBackground(new Color(255, 255, 255));
		p3.setBounds(723, 195, 200, 335);
		contentPane.add(p3);
		p3.setLayout(null);
		
		JLabel l7 = new JLabel("");
		l7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLogin adlogin = new AdminLogin();
				adlogin.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				l7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		l7.setBounds(31, 11, 131, 147);
		p3.add(l7);
		
		JLabel l8 = new JLabel("");
		l8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				l8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		l8.setBounds(31, 169, 131, 147);
		p3.add(l8);
		
		JLabel l7_1 = new JLabel("");
		l7_1.setIcon(new ImageIcon("G:\\JAVA\\pngegg.png"));
		l7_1.setBounds(41, 21, 104, 110);
		p3.add(l7_1);
		
		JLabel l8_1 = new JLabel("");
		l8_1.setIcon(new ImageIcon("G:\\JAVA\\285648_group_user_icon.png"));
		l8_1.setBounds(41, 181, 104, 110);
		p3.add(l8_1);
		
		JLabel l7_2 = new JLabel("Admin");
		l7_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		l7_2.setBounds(65, 130, 80, 27);
		p3.add(l7_2);
		
		JLabel l8_2 = new JLabel("Users");
		l8_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		l8_2.setBounds(65, 286, 80, 25);
		p3.add(l8_2);
		
		 l9 = new JLabel();
		 l9.setVerticalAlignment(SwingConstants.TOP);
		 l9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l9.setBounds(10, 195, 705, 335);
		contentPane.add(l9);
		
		JLabel l10 = new JLabel("");
		l10.setIcon(new ImageIcon("G:\\JAVA\\img3.jpg"));
		l10.setBounds(10, 195, 703, 335);
		contentPane.add(l10);
		
		
		
		 addWindowListener(new WindowAdapter() {
			 public void windowActivated(WindowEvent e) {
				 System.out.println("hello");
				 
				
				 
				 try{  
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");  
						System.out.println("Database Connected...");
				
						Statement stmt=con.createStatement();  
						ResultSet rs=stmt.executeQuery("select * from flight");  
						while(rs.next())  
						{
							String Airline=rs.getString("flight_name");
							String Flight=rs.getString("flight_id");
							Date Time=rs.getDate("departure");
							String Origin=rs.getString("source");
							String Destination=rs.getString("destination");
							String Gate=rs.getString(ABORT);
							String Remark=rs.getString(ABORT);
							System.out.println(Airline);
							//model.addRow(new Object[] {rs.getString("flight_name")});
//							String[] columns = {"Airline", "Flight", "Time","Origin","Destination","Gate","Remark"};
//				            String[][] data = {{Airline, Flight, strDate, Origin, Destination, Gate, Remark}};
//				            DefaultTableModel model = new DefaultTableModel(data,columns);
//							 JTable table = new JTable(model);
//							 JScrollPane pane = new JScrollPane(table);
//							
						}
						con.close();  
						}catch(Exception e1){ System.out.println(e1);}  
				 
				 
				 
				
			    }       
	      }); 
		
	}
}
