package AirlineReservationSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AddStaff extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTable table;
	DefaultTableModel model;
	JComboBox comboBox;
	JTextArea ta1;
	JPanel p3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStaff frame = new AddStaff();
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
	public AddStaff() {
		setTitle("Staff Details");
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
		
		JLabel l1 = new JLabel("Staff Details");
		l1.setForeground(new Color(255, 69, 0));
		l1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		l1.setBounds(10, 11, 210, 50);
		p1.add(l1);
		
		JPanel p2 = new JPanel();
		p2.setBackground(new Color(240, 248, 255));
		p2.setBounds(10, 94, 964, 194);
		contentPane.add(p2);
		p2.setLayout(null);
		
		JLabel l2 = new JLabel("Staff Id");
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l2.setBounds(10, 11, 81, 31);
		p2.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(101, 11, 109, 31);
		p2.add(t1);
		t1.setColumns(10);
		
		JLabel l3 = new JLabel("Staff Name");
		l3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l3.setBounds(234, 11, 91, 31);
		p2.add(l3);
		
		t2 = new JTextField();
		t2.setBounds(335, 11, 230, 31);
		p2.add(t2);
		t2.setColumns(10);
		
		JLabel l4 = new JLabel("Designation");
		l4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l4.setBounds(590, 11, 102, 31);
		p2.add(l4);
		
		String str[]= {"Passenger assistant","Airline food service worker","Airline baggage handler","Airport security officer\r\n"
				+ "Aircraft fueler","Airline reservation agent","Flight dispatcher","Flight attendant","Aircraft maintenance technician"," Air traffic controller","Aircraft mechanic","Avionics technician","Airport manager","Airport planner","Airport operations manager","Pilot","Airport engineer","Aeronautical engineer"};
		comboBox = new JComboBox(str);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox.setBounds(694, 11, 109, 31);
		p2.add(comboBox);
		
		JLabel lblStaffAddress = new JLabel("Staff Address");
		lblStaffAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblStaffAddress.setBounds(482, 71, 109, 31);
		p2.add(lblStaffAddress);
		
		JLabel l5 = new JLabel("Phone No");
		l5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		l5.setBounds(10, 73, 81, 31);
		p2.add(l5);
		
		t3 = new JTextField();
		t3.setBounds(101, 73, 156, 31);
		p2.add(t3);
		t3.setColumns(10);
		
		JLabel lblSall = new JLabel("Salary");
		lblSall.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblSall.setBounds(279, 73, 61, 31);
		p2.add(lblSall);
		
		t4 = new JTextField();
		t4.setBounds(351, 73, 109, 31);
		p2.add(t4);
		t4.setColumns(10);
		
		 ta1 = new JTextArea();
		ta1.setBounds(601, 71, 202, 60);
		p2.add(ta1);
		
		JButton b1 = new JButton("Add Staff");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root",""); 
					System.out.println("Database Connected..");
					Statement stmt=con.createStatement();
					String query="insert into staff values('"+t1.getText()+"','"+t2.getText()+"','"+comboBox.getSelectedItem()+"','"+t3.getText()+"','"+t4.getText()+"','"+ta1.getText()+"')";
					stmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Staff Add Successfully....");
					System.out.println("Record is inserted successfully..................");
					Show();
					con.close(); 
				}catch(Exception ea){ System.out.println(ea);}  
			}
		});
		b1.setForeground(new Color(0, 0, 128));
		b1.setBackground(new Color(0, 191, 255));
		b1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		b1.setBounds(101, 144, 120, 39);
		p2.add(b1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {  
	                   Class.forName("com.mysql.jdbc.Driver");  
	                   // establish connection  
	                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");  
	                   Statement stmt = con.createStatement();  
	                   stmt.execute("UPDATE staff SET name='"+t2.getText()+"',designation='"+comboBox.getSelectedItem()+"',phone='"+t3.getText()+"',salary='"+t4.getText()+"',Address='"+ta1.getText()+"' where staff_id='"+t1.getText()+"'  ");  
	                   JOptionPane.showMessageDialog(null, "Record is updated...");  
	                   stmt.close(); 
	                   Show();
	                   con.close();
	               } catch (SQLException | ClassNotFoundException se) {  
	                   JOptionPane.showMessageDialog(null, se);  
	               }  
			}
		});
		btnUpdate.setForeground(new Color(0, 0, 128));
		btnUpdate.setBackground(new Color(0, 191, 255));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnUpdate.setBounds(234, 144, 120, 39);
		p2.add(btnUpdate);
		
		JButton b1_1_1 = new JButton("Remove");
		b1_1_1.setForeground(new Color(0, 0, 128));
		b1_1_1.setBackground(new Color(255, 0, 0));
		b1_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		b1_1_1.setBounds(370, 144, 120, 39);
		p2.add(b1_1_1);
		
		JButton b1_1_2 = new JButton("Reset");
		b1_1_2.setForeground(new Color(0, 0, 139));
		b1_1_2.setBackground(new Color(255, 0, 0));
		b1_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		b1_1_2.setBounds(500, 142, 120, 39);
		p2.add(b1_1_2);
		
		p3 = new JPanel();
		p3.setBackground(new Color(245, 245, 220));
		p3.setBounds(10, 298, 964, 352);
		contentPane.add(p3);
		p3.setLayout(null);
		Show();
	}
		public void Show() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 944, 330);
		p3.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		model=new DefaultTableModel();
		Object[] colomn = {"Staff Id", "Staff Name", "Designation", "Phone No", "Salary", "Address"};
		model.setColumnIdentifiers(colomn);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root","");    
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from staff");  
			while(rs.next())  
			{
				String staffid=rs.getString("staff_id");
				String staffname=rs.getString("name");
				String designation=rs.getString("designation");
				String phone=rs.getString("phone");
				String salary=rs.getString("salary");
				String address=rs.getString("Address");
				Object[] row= {staffid,staffname,designation,phone,salary,address,};//new Object[4];
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
	                comboBox.setSelectedItem((String)model.getValueAt(i, 2));
	                t3.setText((String)model.getValueAt(i, 3));
	                t4.setText((String)model.getValueAt(i, 4));
	                ta1.setText((String)model.getValueAt(i, 5));
					
	            }
	        });
		
		
	}
}
