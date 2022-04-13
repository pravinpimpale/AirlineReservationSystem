package AirlineReservationSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JPasswordField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 481, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Admin Login");
		l1.setForeground(new Color(0, 128, 0));
		l1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		l1.setBounds(156, 11, 154, 49);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("User Name");
		l2.setForeground(new Color(255, 69, 0));
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l2.setBounds(126, 82, 112, 37);
		contentPane.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(126, 118, 219, 37);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel l3 = new JLabel("Password");
		l3.setForeground(new Color(255, 69, 0));
		l3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l3.setBounds(126, 166, 112, 37);
		contentPane.add(l3);
		
		JButton b1 = new JButton("Login");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root",""); 
					System.out.println("Database Connected..");
					Statement stmt=con.createStatement();
					String query="select * from admin where username='"+t1.getText()+"' and PASSWORD='"+t2.getText()+"'";
					
					ResultSet rs=(ResultSet) stmt.executeQuery(query);
					
					if(rs.next()) {
						dispose();
						AdminDashboard frame = new AdminDashboard();
						frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(contentPane, "username or password wrong...");
						t1.setText("");
						t2.setText("");
					}
					con.close(); 
				}catch(Exception ea){ System.out.println(ea);} 
				
			}
		});
		b1.setBackground(new Color(0, 255, 255));
		b1.setForeground(new Color(0, 0, 128));
		b1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		b1.setBounds(233, 283, 112, 37);
		contentPane.add(b1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember Password");
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		chckbxNewCheckBox.setBounds(126, 254, 154, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel l4 = new JLabel("");
		l4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		l4.setBackground(Color.WHITE);
		l4.setIcon(new ImageIcon("G:\\JAVA\\13.png"));
		l4.setBounds(409, 11, 46, 41);
		contentPane.add(l4);
		
		JLabel l = new JLabel("");
		l.setIcon(new ImageIcon("G:\\JAVA\\plane-9956.png"));
		l.setBounds(10, 11, 445, 339);
		contentPane.add(l);
		
		t2 = new JPasswordField();
		t2.setBounds(126, 202, 219, 37);
		contentPane.add(t2);
	}
}
