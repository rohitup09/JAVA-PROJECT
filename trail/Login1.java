package trail;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class Login1 extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JTextField text2;
	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/java";
	
	//Database credentials
	static final String USER = "root";
	static final String PASS = "password";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
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
	public Login1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(544, 253, 391, 314);
		contentPane.add(panel);
		panel.setLayout(null);
		
		text1 = new JTextField();
		text1.setBounds(131, 110, 235, 32);
		panel.add(text1);
		text1.setColumns(10);
		
		text2 = new JTextField();
		text2.setColumns(10);
		text2.setBounds(131, 154, 235, 32);
		panel.add(text2);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setBounds(30, 118, 73, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(30, 162, 73, 16);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String login = text1.getText();
				String password = text2.getText();
				
				Connection conn = null;
				Statement stmt = null;
				try {
					//Step 2: Register JDBC driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					//Step 3: Open a connection

					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					
					//System.out.println("Creating table in given database");
		            stmt = conn.createStatement();
		            
		            //String sql = "CREATE TABLE LOGIN( id varchar(255) not null, password varchar(255), age int)";
		            
		            //stmt.executeUpdate(sql);
		            
					
					
		            PreparedStatement st = (PreparedStatement) conn
	                        .prepareStatement("Select uname, password from users where uname=? and password=?");

	                    st.setString(1, login);
	                    st.setString(2, password);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                        dispose();
	                        UserHome ah = new UserHome();
	                        
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                } catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        });

		btnNewButton.setBounds(141, 227, 117, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		lblNewLabel_2.setBounds(155, 18, 103, 44);
		panel.add(lblNewLabel_2);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/gaming.jpg"));
		lblNewLabel.setBounds(0, 0, 1471, 823);
		contentPane.add(lblNewLabel);
		setSize(1650,1080);
		
		
	}
}
