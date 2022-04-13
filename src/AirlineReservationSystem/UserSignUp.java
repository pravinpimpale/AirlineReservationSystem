package AirlineReservationSystem;

import java.awt.BorderLayout;
import java.sql.*;  
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.sql.SQLException.*;
public class UserSignUp extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JPasswordField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSignUp frame = new UserSignUp();
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
	public UserSignUp() {
		setTitle("User Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 500, 470);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Sign Up");
		l1.setForeground(new Color(255, 69, 0));
		l1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		l1.setBounds(39, 11, 104, 37);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Full Name");
		l2.setForeground(new Color(0, 128, 0));
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l2.setBounds(39, 96, 104, 31);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Email Id");
		l3.setForeground(new Color(0, 128, 0));
		l3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l3.setBounds(39, 149, 104, 31);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Mobile No.");
		l4.setForeground(new Color(0, 128, 0));
		l4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l4.setBounds(39, 202, 104, 31);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Password");
		l5.setForeground(new Color(0, 128, 0));
		l5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l5.setBounds(39, 255, 104, 31);
		contentPane.add(l5);
		
		t1 = new JTextField();
		t1.setBounds(180, 96, 253, 31);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(180, 149, 253, 31);
		contentPane.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(180, 202, 253, 31);
		contentPane.add(t3);
		t3.setColumns(10);
		
		JButton b1 = new JButton("Submit");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root",""); 
					System.out.println("Database Connected..");
					Statement stmt=con.createStatement();
					String query="insert into userdata(username,email,mobileno,password)values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
					stmt.executeUpdate(query);
					System.out.println("Record is inserted successfully..................");
					con.close(); 
				}catch(Exception ea){ System.out.println(ea);}  
				
				
				
				
				Home home= new Home();
				home.setVisible(true);
				dispose();
				JOptionPane.showMessageDialog(home,"Your Registration Successfully....");
				
			}
		});
		b1.setBackground(new Color(0, 255, 255));
		b1.setForeground(new Color(255, 255, 255));
		b1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		b1.setBounds(102, 339, 132, 37);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Reset");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				
			}
		});
		b2.setBackground(new Color(255, 0, 0));
		b2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		b2.setForeground(new Color(255, 255, 255));
		b2.setBounds(266, 339, 132, 37);
		contentPane.add(b2);
		
		JLabel l6 = new JLabel("click here to login");
		l6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}
		});
		l6.setForeground(new Color(0, 0, 139));
		l6.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		l6.setBounds(164, 396, 132, 19);
		contentPane.add(l6);
		
		JLabel l = new JLabel("");
		l.setIcon(new ImageIcon("G:\\JAVA\\plane1.png"));
		l.setBounds(10, 11, 464, 409);
		contentPane.add(l);
		
		t4 = new JPasswordField();
		t4.setBounds(180, 255, 253, 31);
		contentPane.add(t4);
	}

}
