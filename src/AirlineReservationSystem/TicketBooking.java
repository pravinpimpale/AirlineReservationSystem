package AirlineReservationSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.ButtonUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class TicketBooking extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTable table;
	DefaultTableModel model;
	JButton  jb=new JButton("ello");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketBooking frame = new TicketBooking();
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
	public TicketBooking() {
		setTitle("Ticket Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1200, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(175, 238, 238));
		p1.setBounds(10, 11, 1164, 102);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel("Welcome to Online Flight Ticket Booking System");
		l1.setForeground(new Color(165, 42, 42));
		l1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		l1.setBounds(212, 11, 771, 80);
		p1.add(l1);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(255, 255, 255));
		p2.setBounds(35, 124, 1111, 50);
		contentPane.add(p2);
		p2.setLayout(null);
		
		String str[]= {"One Way","Return Trip"};
		JComboBox comboBox1 = new JComboBox(str);
		comboBox1.setBounds(81, 12, 100, 27);
		p2.add(comboBox1);
		
		JLabel l2 = new JLabel("Trip Type");
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l2.setBounds(10, 11, 72, 27);
		p2.add(l2);
		
		JLabel l3 = new JLabel("From");
		l3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l3.setBounds(191, 12, 46, 27);
		p2.add(l3);
		
		t1 = new JTextField();
		t1.setBounds(231, 11, 119, 28);
		p2.add(t1);
		t1.setColumns(10);
		
		JLabel l4 = new JLabel("To");
		l4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l4.setBounds(360, 11, 26, 28);
		p2.add(l4);
		
		t2 = new JTextField();
		t2.setBounds(382, 11, 119, 28);
		p2.add(t2);
		t2.setColumns(10);
		
		JLabel l5 = new JLabel("Depart on");
		l5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l5.setBounds(511, 11, 72, 27);
		p2.add(l5);
		
		JDateChooser date1 = new JDateChooser();
		date1.setBounds(580, 12, 100, 27);
		p2.add(date1);
		
		JLabel l6 = new JLabel("Return on");
		l6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		l6.setBounds(686, 12, 72, 27);
		p2.add(l6);
		
		JDateChooser date2 = new JDateChooser();
		date2.setBounds(751, 12, 100, 28);
		p2.add(date2);
		
		String str1[]= {"Adults","Children","Infants"};
		JComboBox comboBox2 = new JComboBox(str1);
		comboBox2.setBounds(861, 12, 66, 27);
		p2.add(comboBox2);
		
		String str2[]= {"1","2","3","4","5","6","7","8","9"};
		JComboBox comboBox3 = new JComboBox(str2);
		comboBox3.setBackground(new Color(255, 255, 255));
		comboBox3.setBounds(937, 11, 46, 28);
		p2.add(comboBox3);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 201, 1164, 349);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
				
				TableModel model=table.getModel();
				
				String flightid=model.getValueAt(index, 0).toString();
				String airline=model.getValueAt(index, 1).toString();
				String source=model.getValueAt(index, 2).toString();
				String destination=model.getValueAt(index, 3).toString();
				String departure=model.getValueAt(index, 4).toString();
				String arrival=model.getValueAt(index, 5).toString();
				String price=model.getValueAt(index, 6).toString();
				
				TicketDetails frame1 = new TicketDetails();
				frame1.setVisible(true);
				//frame1.pack();
				frame1.setLocationRelativeTo(null);
				frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				frame1.t4.setText(flightid);
				frame1.l8.setText(source);
				frame1.l10.setText(destination);
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		model=new DefaultTableModel();
		Object[] colomn = {"Airline Code","Airline","Source","Destination", "Departure", "Arrival","Date", "Price"};
		model.setColumnIdentifiers(colomn);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		
		
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		
		
		
		
		
		
		
		
		JButton b1 = new JButton("Search");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				try{  
//					Class.forName("com.mysql.jdbc.Driver");  
//					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");    
//					Statement stmt=con.createStatement();  
//					ResultSet rs=stmt.executeQuery("select * from flight where source='"+t1.getText()+"'  and destination='"+t2.getText()+"'  or date='"+date1.getDate()+"'");  
//					while(rs.next())  
//					{
//						String flightid=rs.getString("flight_id");
//						String flightname=rs.getString("flight_name");
//						String departure=rs.getString("departure");
//						String arrival=rs.getString("arrival_time");
//						String price=rs.getString("flight_charges");
//						Object[] row= {flightid,flightname,departure,arrival,price};//new Object[4];
//						model.addRow(row);
//					}
//					con.close();  
//					}catch(Exception e1){ System.out.println(e1);}
				
				String combo=comboBox1.getSelectedItem().toString();
				String combo1="One Way";//"One Way","Return Trip"
				String combo2="Return Trip";
				
				if(combo==combo1) {
					try{  
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");    
						Statement stmt=con.createStatement();  
						ResultSet rs=stmt.executeQuery("select * from flight where source='"+t1.getText()+"'  AND destination='"+t2.getText()+"'  or date='"+date1.getDate()+"'");  
						while(rs.next())  
						{
							String flightid=rs.getString("flight_id");
							String flightname=rs.getString("flight_name");
							String departure=rs.getString("departure");
							String arrival=rs.getString("arrival_time");
							String price=rs.getString("flight_charges");
							String source=rs.getString("source");
							String destination=rs.getString("destination");
							String date=rs.getString("date");
							Object[] row= {flightid,flightname,source,destination,departure,arrival,date,price};//new Object[4];
							model.addRow(row);
						}
						con.close();  
						}catch(Exception e1){ System.out.println(e1);}
				}
				else if(combo==combo2) {
					try{  
						Class.forName("com.mysql.jdbc.Driver");  
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");    
						Statement stmt=con.createStatement();  
						ResultSet rs=stmt.executeQuery("select * from flight where source='"+t1.getText()+"'  AND destination='"+t2.getText()+"'  or date='"+date1.getDate()+"'  or date='"+date2.getDate()+"'");  
						while(rs.next())  
						{
							String flightid=rs.getString("flight_id");
							String flightname=rs.getString("flight_name");
							String departure=rs.getString("departure");
							String arrival=rs.getString("arrival_time");
							String price=rs.getString("flight_charges");
							String source=rs.getString("source");
							String destination=rs.getString("destination");
							String date=rs.getString("date");
							Object[] row= {flightid,flightname,source,destination,departure,arrival,date,price};//new Object[4];
							model.addRow(row);
						}
						con.close();  
						}catch(Exception e1){ System.out.println(e1);}
				}
				
				
				
				
				
			}
		});
		b1.setForeground(new Color(255, 255, 255));
		b1.setBackground(new Color(0, 0, 255));
		b1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		b1.setBounds(993, 11, 100, 28);
		p2.add(b1);
	}
}
