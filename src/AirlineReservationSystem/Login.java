package AirlineReservationSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 500, 446);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Login Page");
		l1.setForeground(new Color(0, 128, 0));
		l1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		l1.setBounds(144, 11, 160, 47);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("User Name / Email");
		l2.setForeground(Color.RED);
		l2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l2.setBounds(130, 83, 174, 26);
		contentPane.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(130, 120, 223, 40);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel l3 = new JLabel("Password");
		l3.setForeground(Color.RED);
		l3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		l3.setBounds(130, 171, 92, 26);
		contentPane.add(l3);
		
		JButton b1 = new JButton("Login");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline","root",""); 
					System.out.println("Database Connected..");
					Statement stmt=con.createStatement();
					String query="select * from userdata where email='"+t1.getText()+"' and PASSWORD='"+t2.getText()+"'";
					
					ResultSet rs=(ResultSet) stmt.executeQuery(query);
					
					if(rs.next()) {
						dispose();
						UserDasboard userdashboard = new UserDasboard();
						userdashboard.setVisible(true);
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
		b1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		b1.setBounds(303, 303, 77, 40);
		contentPane.add(b1);
		
		JCheckBox c1 = new JCheckBox("Show Password");
		c1.setBackground(Color.WHITE);
		c1.setForeground(new Color(0, 128, 0));
		c1.setBounds(130, 253, 132, 23);
		contentPane.add(c1);
		
		JLabel l4 = new JLabel("click here to create a new account");
		l4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserSignUp signup = new UserSignUp();
				signup.setVisible(true);
				dispose();
				
			}
		});
		l4.setForeground(Color.RED);
		l4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		l4.setBounds(157, 355, 223, 26);
		contentPane.add(l4);
		
		JLabel l5 = new JLabel("Forgot password?");
		l5.setForeground(Color.DARK_GRAY);
		l5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		l5.setBounds(230, 283, 123, 17);
		contentPane.add(l5);
		
		JLabel l0 = new JLabel("");
		l0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home = new Home();
				home.setVisible(true);
				dispose();
			}
		});
		l0.setIcon(new ImageIcon("G:\\JAVA\\13.png"));
		l0.setBounds(415, 11, 46, 41);
		contentPane.add(l0);
		
		JLabel l = new JLabel("");
		l.setIcon(new ImageIcon("G:\\JAVA\\login.png"));
		l.setBounds(0, 0, 484, 407);
		contentPane.add(l);
		
		t2 = new JPasswordField();
		t2.setBounds(130, 208, 223, 40);
		contentPane.add(t2);
	}
}
