package AirlineReservationSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.*;  
import java.awt.Font;
import java.awt.Color;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.mysql.jdbc.ResultSet;
public class TicketDetails extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	JLabel l8;
	JLabel l10;
	
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
					TicketDetails frame = new TicketDetails();
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
	PreparedStatement pst3;
	PreparedStatement pst4;
	PreparedStatement pst5;
	PreparedStatement pst6;
	PreparedStatement pst7;
	
	
	private JTextField t3;
	JTextField t4;
	JTextField t5;
	private JTextField t6;
	
	public void Connect() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");
			}catch(Exception e1){ System.out.println(e1);}
	}
	/**
	 * Create the frame.
	 */
	public TicketDetails() {
		Connect();
		setTitle("Ticket Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1000, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(255, 255, 255));
		p1.setBounds(10, 11, 964, 75);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel("Ticket Details");
		l1.setForeground(new Color(255, 69, 0));
		l1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		l1.setBounds(10, 11, 223, 53);
		p1.add(l1);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(240, 248, 255));
		p2.setBounds(10, 85, 964, 89);
		contentPane.add(p2);
		p2.setLayout(null);
		
		JLabel l2 = new JLabel("Email Id :");
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		l2.setBounds(10, 11, 75, 26);
		p2.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(87, 11, 118, 26);
		p2.add(t1);
		t1.setColumns(10);
		
		JLabel l3 = new JLabel("D.O.B");
		l3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		l3.setBounds(418, 11, 75, 26);
		p2.add(l3);
		
		JDateChooser date1 = new JDateChooser();
		date1.setBounds(465, 11, 118, 26);
		p2.add(date1);
		
		JLabel l4 = new JLabel("Gender");
		l4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		l4.setBounds(225, 11, 55, 26);
		p2.add(l4);
		
		JRadioButton rb1 = new JRadioButton("Male");
		rb1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		rb1.setBounds(276, 11, 55, 23);
		p2.add(rb1);
		
		JRadioButton rb2 = new JRadioButton("Female");
		rb2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		rb2.setBounds(337, 11, 75, 23);
		p2.add(rb2);
		
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rb1);bg.add(rb2); 
		
		JLabel l5 = new JLabel("Seat");
		l5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		l5.setBounds(597, 11, 55, 26);
		p2.add(l5);
		
		String combo[]= {"Window Seat","Non-Window Seat"};
		JComboBox comboBox = new JComboBox(combo);
		comboBox.setBounds(636, 12, 101, 26);
		p2.add(comboBox);
		
		JLabel l6 = new JLabel("Address");
		l6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		l6.setBounds(747, 11, 55, 26);
		p2.add(l6);
		
		JTextArea ta1 = new JTextArea();
		ta1.setBounds(807, 11, 147, 50);
		p2.add(ta1);
		
		JPanel p3 = new JPanel();
		p3.setBackground(new Color(240, 255, 240));
		p3.setBounds(10, 171, 964, 89);
		contentPane.add(p3);
		p3.setLayout(null);
		
		JLabel l7 = new JLabel("Your Trip");
		l7.setForeground(new Color(255, 69, 0));
		l7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		l7.setBounds(10, 0, 138, 38);
		p3.add(l7);
		
		l8 = new JLabel("<html><body><center>Form Where</center></body></html>");
		l8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l8.setBounds(132, 48, 157, 30);
		p3.add(l8);
		
		l10 = new JLabel("<html><body><center>To Where</center></body></html>");
		l10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l10.setBounds(371, 48, 169, 30);
		p3.add(l10);
		
		JLabel l9 = new JLabel("TO");
		l9.setForeground(new Color(0, 128, 0));
		l9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		l9.setBounds(288, 47, 50, 30);
		p3.add(l9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(0, 0, 964, 38);
		p3.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel p4 = new JPanel();
		p4.setBackground(new Color(245, 245, 220));
		p4.setBounds(10, 259, 964, 291);
		contentPane.add(p4);
		p4.setLayout(null);
		
		JPanel p5 = new JPanel();
		p5.setBackground(new Color(245, 222, 179));
		p5.setBounds(0, 0, 964, 66);
		p4.add(p5);
		p5.setLayout(null);
		
		JLabel l11 = new JLabel("Make Payment");
		l11.setForeground(new Color(255, 69, 0));
		l11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		l11.setBounds(10, 11, 195, 44);
		p5.add(l11);
		
		JLabel l12 = new JLabel("<html><body>Total Package Price :<br>\r\n(Includeing Tax)</html></body>");
		l12.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l12.setBounds(54, 77, 167, 57);
		p4.add(l12);
		
		JLabel l13 = new JLabel("Rs");
		l13.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l13.setBounds(314, 77, 39, 57);
		p4.add(l13);
		
		JLabel l14 = new JLabel("Ammount");
		l14.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l14.setBounds(371, 77, 167, 57);
		p4.add(l14);
		
		JLabel l15 = new JLabel("Pay Your Amount");
		l15.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l15.setBounds(668, 77, 142, 35);
		p4.add(l15);
		
		JButton b1 = new JButton("Confirm Ticket");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seat=t6.getText();
				String flightid=t4.getText();
				SimpleDateFormat Date_Format= new SimpleDateFormat("dd/mm/yyyy");
				String date = Date_Format.format(date1.getDate());
				String mail=t1.getText();
				String flightname=null;
				String customername=null;
				String from=null;
				String where=null;
				String flightid1=null;
				String gate=String.valueOf(b);
				String boardingtime=null;
				String boarding=null;
				String seat1=null;
				String date1=null;
				String departure=null;
				
				
							String gender=null;
							if(rb1.isSelected()){    
								 gender=rb1.getText();
								} 
							if(rb2.isSelected()){    
								 gender=rb2.getText();
								}  
						try{  
							Class.forName("com.mysql.jdbc.Driver");  
							Connection con=DriverManager.getConnection(  
							"jdbc:mysql://localhost:3306/airline","root","");
							System.out.println("database connected...");
							//insert data in database
							Statement stmt=con.createStatement();
							String query="update userdata set gender='"+gender+"',dob='"+date+"',seattype='"+comboBox.getSelectedItem()+"',address='"+ta1.getText()+"',cardno='"+t2.getText()+"',expirydate='"+t3.getText()+"' where email='"+t1.getText()+"'";
							stmt.executeUpdate(query);
							
							
							pst=con.prepareStatement("update seat set status=? where seat =? AND flightno=?");
							pst.setString(1, "Booked");
							pst.setString(2, seat);
							pst.setString(3, flightid);
							pst.executeUpdate();
														
							
							
							
							con.close();  
							
							}catch(Exception e1){ System.out.println(e1);}
				
						JOptionPane.showMessageDialog(null,"Your Ticket is Confirm....Enjoy Journey"); 
						
						UserDasboard userdash = new UserDasboard();
						userdash.setVisible(true);
						userticket frame = new userticket();
						frame.setVisible(true);
						setVisible(false);
						frame.setLocationRelativeTo(null);
						frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
						frame.l12.setText(seat);
						frame.l27_1.setText(seat);
				
				 
			}
		});
		b1.setForeground(new Color(0, 0, 128));
		b1.setBackground(new Color(176, 224, 230));
		b1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		b1.setBounds(615, 208, 155, 57);
		p4.add(b1);
		
		JLabel l16 = new JLabel("Card No.");
		l16.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		l16.setBounds(597, 121, 71, 28);
		p4.add(l16);
		
		t2 = new JTextField();
		t2.setBounds(678, 121, 207, 28);
		p4.add(t2);
		t2.setColumns(10);
		
		JLabel l17 = new JLabel("Expiry date");
		l17.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		l17.setBounds(597, 160, 71, 28);
		p4.add(l17);
		
		t3 = new JTextField();
		t3.setBounds(684, 160, 105, 28);
		p4.add(t3);
		t3.setColumns(10);
		
		JLabel l18 = new JLabel("Flight id");
		l18.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l18.setBounds(54, 160, 79, 43);
		p4.add(l18);
		
		t4 = new JTextField();
		t4.setBounds(135, 160, 86, 43);
		p4.add(t4);
		t4.setColumns(10);
		
		JLabel l19 = new JLabel("Seat No");
		l19.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l19.setBounds(54, 222, 79, 43);
		p4.add(l19);
		
		t6 = new JTextField();
		t6.setColumns(10);
		t6.setBounds(135, 222, 86, 43);
		p4.add(t6);
		
		
		
		
		
		
	}
}
