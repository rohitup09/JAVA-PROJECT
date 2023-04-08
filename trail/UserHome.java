package trail;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;

public class UserHome extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
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
					UserHome frame = new UserHome();
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
	public UserHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBounds(544, 253, 391, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnShow = new JButton("Show Sales Table");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conn = null;
				Statement stmt = null;
				ResultSet rs = null;
				String[] columnNames = {"id","product", "amount"};
				try {
					//Step 2: Register JDBC driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					//Step 3: Open a connection

					conn = DriverManager.getConnection(DB_URL, USER, PASS);
			        
					DefaultTableModel model = new DefaultTableModel();
			        model.setColumnIdentifiers(columnNames);
			        
			        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			        
			        /*JScrollPane scroll = new JScrollPane(tbl);
			        scroll.setHorizontalScrollBarPolicy(
			                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			        scroll.setVerticalScrollBarPolicy(
			                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			        */
			        
			        String product = "";
			        int id = 0;
			        float amount = 0.0f;
			        String sql2 = "SELECT * FROM BOUGHT";
			        stmt = conn.createStatement();
			        rs = stmt.executeQuery(sql2);
			        int i = 0;
			        String[] title= {"ID","PRODUCT","AMOUNT"};
			        model.addRow(title);
			        while (rs.next()) {
			        	amount = rs.getFloat("amount");
			        	product = rs.getString("product");
			        	id = rs.getInt("id");
			        	
			        	String amt = String.valueOf(amount);
			        	String id2 = String.valueOf(id);
			        	
			        	String []data = {id2, product, amt};
			        	model.addRow(data);
			        	++i;
			        }
			            if (i < 1) {
			                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			            if (i == 1) {
			                System.out.println(i + " Record Found");
			            } else {
			                System.out.println(i + " Records Found");
			            }
						tbl.setModel(model);
						
				}
				catch(SQLException se) {
					//Handle errors for JDBC
					se.printStackTrace();
				}
				catch (Exception e1) {
					//Handle errors for Class.forName
					e1.printStackTrace();
				}
				finally {
					//end finally try
				}//end try 
				System.out.println("Goodbye!");
			}
		});
		btnShow.setBounds(71, 42, 248, 58);
		panel.add(btnShow);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(btnLogout, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    Login1 obj = new Login1();
                    obj.setTitle("Login");
                    obj.setVisible(true);
                }
                dispose();
                Login1 obj = new Login1();

                obj.setTitle("Login");
                obj.setVisible(true);

            }
        });
		btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnLogout.setBounds(71, 132, 248, 58);
		panel.add(btnLogout);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tbl = new JTable();
		tbl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tbl.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tbl.setBounds(497, 583, 505, 173);
		contentPane.add(tbl);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/gaming.jpg"));
		lblNewLabel.setBounds(0, 0, 1471, 823);
		contentPane.add(lblNewLabel);
		setSize(1650,1080);
	}
}
