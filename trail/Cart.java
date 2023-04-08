package trail;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JSeparator;

public class Cart extends JFrame {

	private JPanel contentPane;
	String name;
	float price;
	//JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/java";
	
	//Database credentials
	static final String USER = "root";
	static final String PASS = "password";
	private JTable tbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cart frame = new Cart();
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
	public Cart(String name,float price)
	{
		ActionListener actionListener = new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	        	ThankYou obj=new ThankYou();
	        	obj.setVisible(true);
	        	
	        }
		};
		this.name=name;
		this.price=price;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(63, 12, 11));
		setSize(1650,1080);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(35, 36, 109));
		panel.setBounds(0, 0, 173, 818);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/home.jpg"));
		lblNewLabel_7.setBounds(62, 127, 49, 48);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6_1 = new JLabel("Gaming");
		lblNewLabel_6_1.setBounds(45, 34, 74, 25);
		lblNewLabel_6_1.setForeground(new Color(250, 249, 245));
		lblNewLabel_6_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6 = new JLabel("ZenTraac");
		lblNewLabel_6.setBounds(35, 6, 103, 28);
		lblNewLabel_6.setForeground(new Color(245, 246, 241));
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/cart.jpg"));
		btnNewButton_6.setBounds(62, 209, 49, 48);
		panel.add(btnNewButton_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(520, 212, 634, 205);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblYourCart = new JLabel("YOUR CART");
		lblYourCart.setBounds(718, 39, 223, 50);
		lblYourCart.setForeground(new Color(242, 253, 255));
		lblYourCart.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(lblYourCart);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(319, 0, 10, 205);
		panel_2.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(0, 47, 634, 10);
		panel_1.add(panel_3);
		
		JLabel lblItem = new JLabel("ITEM");
		lblItem.setBackground(new Color(0, 0, 0));
		lblItem.setForeground(new Color(0, 0, 0));
		lblItem.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblItem.setBounds(113, 0, 117, 50);
		panel_1.add(lblItem);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblPrice.setBackground(Color.BLACK);
		lblPrice.setBounds(425, 0, 117, 50);
		panel_1.add(lblPrice);
		
		JLabel lblGame = new JLabel(this.name);
		lblGame.setForeground(Color.BLACK);
		lblGame.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblGame.setBackground(Color.BLACK);
		lblGame.setBounds(17, 103, 290, 50);
		panel_1.add(lblGame);
		
		String y=String.valueOf(this.price);
		JLabel lblPrice_1 = new JLabel(y);
		lblPrice_1.setForeground(Color.BLACK);
		lblPrice_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblPrice_1.setBackground(Color.BLACK);
		lblPrice_1.setBounds(425, 103, 117, 50);
		panel_1.add(lblPrice_1);
		
		JButton btnNewButton = new JButton("BUY NOW");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
		btnNewButton.setBackground(new Color(169, 164, 99));
		btnNewButton.setBounds(718, 464, 223, 74);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(actionListener);
		
	}
	public Cart() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(240, 255, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(63, 12, 11));
		setSize(1650,1080);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 173, 818);
		panel.setBackground(new Color(35, 36, 109));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/home.jpg"));
		lblNewLabel_7.setBounds(62, 127, 49, 48);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6_1 = new JLabel("Gaming");
		lblNewLabel_6_1.setBounds(45, 34, 74, 25);
		lblNewLabel_6_1.setForeground(new Color(250, 249, 245));
		lblNewLabel_6_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6 = new JLabel("ZenTraac");
		lblNewLabel_6.setBounds(35, 6, 103, 28);
		lblNewLabel_6.setForeground(new Color(245, 246, 241));
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/cart.jpg"));
		btnNewButton_6.setBounds(62, 209, 49, 48);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton = new JButton("BUY NOW");
		btnNewButton.setBackground(new Color(169, 164, 99));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
		btnNewButton.setBounds(718, 464, 223, 74);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblYourCart = new JLabel("YOUR CART");
		lblYourCart.setBounds(718, 39, 223, 50);
		lblYourCart.setForeground(new Color(242, 253, 255));
		lblYourCart.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		contentPane.add(lblYourCart);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(520, 212, 634, 205);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(319, 0, 10, 205);
		panel_2.setBackground(new Color(0, 0, 0));
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(0, 47, 634, 10);
		panel_1.add(panel_3);
		
		JLabel lblItem = new JLabel("ITEM");
		lblItem.setBackground(new Color(0, 0, 0));
		lblItem.setForeground(new Color(0, 0, 0));
		lblItem.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblItem.setBounds(113, 0, 117, 50);
		panel_1.add(lblItem);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblPrice.setBackground(Color.BLACK);
		lblPrice.setBounds(425, 0, 117, 50);
		panel_1.add(lblPrice);
		
		JLabel lblGame = new JLabel("GAME");
		lblGame.setForeground(Color.BLACK);
		lblGame.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lblGame.setBackground(Color.BLACK);
		lblGame.setBounds(17, 103, 290, 50);
		panel_1.add(lblGame);
		
		JLabel lblPrice_1 = new JLabel("PRICE");
		lblPrice_1.setForeground(Color.BLACK);
		lblPrice_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblPrice_1.setBackground(Color.BLACK);
		lblPrice_1.setBounds(425, 103, 117, 50);
		panel_1.add(lblPrice_1);
		
		
		
		
		
		
	}
}
