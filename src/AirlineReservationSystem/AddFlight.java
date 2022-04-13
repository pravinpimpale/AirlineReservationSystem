package AirlineReservationSystem;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.event.*;
public class AddFlight extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTable table;
	DefaultTableModel model;
	JComboBox comboBox1;
	JDateChooser date1;
	JPanel p3;
//	SimpleDateFormat Date_Format= new SimpleDateFormat();
//	String date = Date_Format.format(date1.getDate());
	
	//JFormattedTextField t6,t7;
	
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
		
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlight frame = new AddFlight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	"Flight Id", "Flight Name", "Flight Class", "Flight Charges", "Source", "Destination", "Departure", "Arrival Time", "Seats", "Date"
	/**
	 * Create the frame.
	 */
	public AddFlight() {
		Connect();
		setTitle("Flight Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(255, 255, 255));
		p1.setBounds(10, 11, 964, 72);
		contentPane.add(p1);
		p1.setLayout(null);
		
		JLabel l1 = new JLabel("Flight Details");
		l1.setForeground(new Color(255, 69, 0));
		l1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		l1.setBounds(10, 11, 273, 50);
		p1.add(l1);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(240, 248, 255));
		p2.setBounds(10, 94, 964, 210);
		contentPane.add(p2);
		p2.setLayout(null);
		
		JLabel l2 = new JLabel("Flight Id");
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l2.setBounds(10, 11, 88, 30);
		p2.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(103, 11, 88, 30);
		p2.add(t1);
		t1.setColumns(10);
		
		JLabel l3 = new JLabel("Flight Name");
		l3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l3.setBounds(201, 11, 100, 30);
		p2.add(l3);
		
		t2 = new JTextField();
		t2.setBounds(306, 11, 110, 30);
		p2.add(t2);
		t2.setColumns(10);
		
		JLabel l4 = new JLabel("Flight Class");
		l4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l4.setBounds(426, 11, 88, 30);
		p2.add(l4);
		
		String str[]= {"First Class","Business Class","Economy Class"};
		 comboBox1 = new JComboBox(str);
		comboBox1.setBounds(525, 11, 110, 30);
		p2.add(comboBox1);
		
		JLabel l5 = new JLabel("Flight Charges");
		l5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l5.setBounds(645, 11, 115, 30);
		p2.add(l5);
		
		t3 = new JTextField();
		t3.setBounds(767, 11, 110, 30);
		p2.add(t3);
		t3.setColumns(10);
		
		JLabel l6 = new JLabel("Source");
		l6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l6.setBounds(10, 52, 88, 30);
		p2.add(l6);
		
		t4 = new JTextField();
		t4.setBounds(103, 52, 88, 30);
		p2.add(t4);
		t4.setColumns(10);
		
		JLabel l7 = new JLabel("Destination");
		l7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l7.setBounds(201, 52, 100, 30);
		p2.add(l7);
		
		t5 = new JTextField();
		t5.setBounds(306, 52, 110, 30);
		p2.add(t5);
		t5.setColumns(10);
		
		JLabel l8 = new JLabel("Departure");
		l8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l8.setBounds(426, 52, 88, 30);
		p2.add(l8);
		
		
		t6=new JTextField();
		t6.setBounds(525, 52, 110, 30);
		p2.add(t6);
		t6.setColumns(10);
		
		JLabel l9 = new JLabel("Arrival Time");
		l9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l9.setBounds(645, 52, 110, 30);
		p2.add(l9);
		
		//t7 = new JFormattedTextField(shortTime);
		t7=new JTextField();
		t7.setBounds(767, 52, 110, 30);
		p2.add(t7);
		t7.setColumns(10);
		
		JLabel l10 = new JLabel("Seats");
		l10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l10.setBounds(10, 93, 88, 30);
		p2.add(l10);
		
		t8 = new JTextField();
		t8.setBounds(103, 93, 88, 30);
		p2.add(t8);
		t8.setColumns(10);
		
		JLabel l11 = new JLabel("Date");
		l11.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l11.setBounds(201, 93, 100, 30);
		p2.add(l11);
		
		 date1 = new JDateChooser();
		date1.setBounds(306, 92, 110, 31);
		p2.add(date1);
		
		
		
		JButton b1 = new JButton("Add Flight");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat Date_Format= new SimpleDateFormat("MM/dd/yyyy");
				String date = Date_Format.format(date1.getDate());
				
				 
				
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/airline","root","");
					System.out.println("database connected...");
					//insert data in database
					Statement stmt=con.createStatement();
					String query="insert into flight(flight_id,flight_name,flight_class,flight_charges,source,destination,departure,arrival_time,seats,date)values('"+t1.getText()+"','"+t2.getText()+"','"+comboBox1.getSelectedItem()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"','"+date+"')";
					stmt.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null,"Flight Added Successfully...");  
					System.out.println("Record is inserted successfully..................");
					Show();
					con.close();  
					}catch(Exception e1){ System.out.println(e1);}
			
			
			
			String flightno=t1.getText();
			String seat=t8.getText();
			
			int s=Integer.parseInt(seat);
			
			
			for(int i=1;i<=s;i++) 
			{
				try {
					
					int seats=i;
					String status="unbooked";
					
					pst=con.prepareStatement("insert into seat(flightno,seat,date,status)values(?,?,?,?)");
					pst.setString(1, flightno);
					pst.setInt(2, seats);
					pst.setString(3, date);
					pst.setString(4, status);
					pst.executeUpdate();
					
				}catch(Exception e1){ System.out.println(e1);}
				
			}
			
			JOptionPane.showMessageDialog(null,"Seat Added Successfully...");
			
			
			
			
			
			
			
	}	
		});
		b1.setForeground(new Color(0, 0, 128));
		b1.setBackground(new Color(0, 191, 255));
		b1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		b1.setBounds(103, 149, 115, 31);
		p2.add(b1);
		
		 
		JButton b2 = new JButton("Update");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat Date_Format= new SimpleDateFormat("MM/dd/yyyy");
				String date = Date_Format.format(date1.getDate());
//				   int i = table.getSelectedRow();
//	               model.setValueAt(t1.getText(), i, 0);
//	               model.setValueAt(t2.getText(), i, 1);
//	               model.setValueAt(comboBox1.getSelectedItem(), i, 2);
//	               model.setValueAt(t3.getText(), i, 3);
//	               model.setValueAt(t4.getText(), i, 4);
//	               model.setValueAt(t5.getText(), i, 5);
//	               model.setValueAt(t6.getText(), i, 6);
//	               model.setValueAt(t7.getText(), i, 7);
//	               model.setValueAt(t8.getText(), i, 8);
//	               model.setValueAt(date1.getDate(), i, 9);
	               
	               
	               try {  
	                   Class.forName("com.mysql.jdbc.Driver");  
	                   // establish connection  
	                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");  
	                   Statement stmt = con.createStatement();  
	                   stmt.execute("UPDATE flight SET flight_name='"+t2.getText()+"',flight_class='"+comboBox1.getSelectedItem()+"',flight_charges='"+t3.getText()+"',source='"+t4.getText()+"',destination='"+t5.getText()+"',departure='"+t6.getText()+"',arrival_time='"+t7.getText()+"',seats='"+t8.getText()+"',date='"+date+"' where flight_id='"+t1.getText()+"'  ");  
	                   JOptionPane.showMessageDialog(null, "Record is updated...");  
	                   stmt.close(); 
	                   Show();
	                   con.close();
	               } catch (SQLException | ClassNotFoundException se) {  
	                   JOptionPane.showMessageDialog(null, se);  
	               }  
			}
		});
		b2.setBackground(new Color(0, 191, 255));
		b2.setForeground(new Color(0, 0, 128));
		b2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		b2.setBounds(228, 149, 115, 31);
		p2.add(b2);
		
		JButton b3 = new JButton("Cancle");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				pst1=con.prepareStatement("delete from flight where flight_id = '"+t1.getText()+"'");
				pst1.executeUpdate();
				JOptionPane.showMessageDialog(null,"Fligt Cancle Successfully...");
				Show();
				pst2=con.prepareStatement("delete from seat where flightno = '"+t1.getText()+"'");
				pst2.executeUpdate();
				con.close(); 
				JOptionPane.showMessageDialog(null,"Seat Deleted Successfully...");
				}catch(Exception e1){ System.out.println(e1);}
			}
		});
		b3.setForeground(new Color(0, 0, 128));
		b3.setBackground(new Color(255, 0, 0));
		b3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		b3.setBounds(353, 149, 115, 31);
		p2.add(b3);
		
		JButton b4 = new JButton("Reset");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				comboBox1.setSelectedItem("First Class");
				date1.setDate(null);
			}
		});
		b4.setBackground(new Color(255, 0, 0));
		b4.setForeground(new Color(0, 0, 128));
		b4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		b4.setBounds(483, 149, 115, 31);
		p2.add(b4);
		
		 p3 = new JPanel();
		p3.setBackground(new Color(245, 245, 220));
		p3.setBounds(10, 315, 964, 335);
		contentPane.add(p3);
		p3.setLayout(null);
		Show();
	}
		public void Show() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 964, 335);
		p3.add(scrollPane);
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		model=new DefaultTableModel();
		Object[] colomn = {"Flight Id", "Flight Name", "Flight Class", "Flight Charges", "Source", "Destination", "Departure", "Arrival Time", "Seats", "Date"};
		model.setColumnIdentifiers(colomn);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");    
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from flight");  
			while(rs.next())  
			{
				String flightid=rs.getString("flight_id");
				String flightname=rs.getString("flight_name");
				String flightclass=rs.getString("flight_class");
				String flightcharges=rs.getString("flight_charges");
				String source=rs.getString("source");
				String destination=rs.getString("destination");
				String departure=rs.getString("departure");
				String arrival=rs.getString("arrival_time");
				String seats=rs.getString("seats");
				String date=rs.getString("date");
				Object[] row= {flightid,flightname,flightclass,flightcharges,source,destination,departure,arrival,seats,date};//new Object[4];
				model.addRow(row);
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);}
		
		
		
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		
		 table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
	          @Override
	          public void valueChanged(ListSelectionEvent e) {
	                int i = table.getSelectedRow();
	                t1.setText((String)model.getValueAt(i, 0));
	                t2.setText((String)model.getValueAt(i, 1));
	                comboBox1.setSelectedItem((String)model.getValueAt(i, 2));
	                t3.setText((String)model.getValueAt(i, 3));
	                t4.setText((String)model.getValueAt(i, 4));
	                t5.setText((String)model.getValueAt(i, 5));
	                t6.setText((String)model.getValueAt(i, 6));
	                t7.setText((String)model.getValueAt(i, 7));
	                t8.setText((String)model.getValueAt(i, 8));
	                date1.setDateFormatString((String)model.getValueAt(i, 9));
					
	            }
	        });
		}
}

