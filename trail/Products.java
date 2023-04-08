package trail;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Products extends JFrame {

private JPanel contentPane;
private final Action action = new SwingAction();
static int index=0;
static int autoid=1001;
int id=0;
String cart[]=new String[10000];
float p=0.0f;
/**
* Launch the application.
*/
//JDBC driver name and database URL
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/java";

//Database credentials
static final String USER = "root";
static final String PASS = "password";
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Products frame = new Products();
//frame.setSize(1600,800);
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
frame.setVisible(true);
frame.setTitle("Gaming");

} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
*/
public Products() {
	ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
        if(index==10) {
//         System.out.println("CART IS FULL");
        JOptionPane.showMessageDialog(null, "CART IS FULL", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        else {
        cart[++index] = event.getActionCommand();
        if(cart[index].equalsIgnoreCase("VICE CITY") || cart[index].equalsIgnoreCase("Dragon Ball Z BT3"))
        {
        	p=29.99f;
        }
        else
        {
        	p=59.99f;
        }
           System.out.println("Cart "+(index)+" = " + cart[index]);
           System.out.println("Price of" + cart[index]+": "+p);
           id=autoid;
           autoid++;
          JOptionPane.showMessageDialog(null, "Successfully Added to the Cart", "Success", JOptionPane.PLAIN_MESSAGE);
          
         // Cart ob=new Cart();
         // ob.setVisible(true);
        }
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
            
			
			
			String ins = "INSERT INTO BOUGHT VALUES(\""+id+"\",\""+cart[index]+"\","+p+")";
			
			stmt.execute(ins);
			
			System.out.println("Data Entered Succesfully");
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
		Cart ob=new Cart(cart[index],p);
		ob.setVisible(true);
		System.out.println("Goodbye!");
        }
     };
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//setBounds(0, 0, 913, 817);
setSize(1650,1080);
contentPane = new JPanel();

contentPane.setToolTipText("");
contentPane.setBackground(new Color(63, 12, 11));
contentPane.setBorder(null);

setContentPane(contentPane);
contentPane.setLayout(null);


//PRODUCT 1
JPanel panel = new JPanel();
panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
panel.setBounds(242, 146, 168, 271);
contentPane.add(panel);

ImageIcon imageIcon1 = new ImageIcon("//Users//rohitupadhyay//Desktop//eclipse-workspace//Demo//images//fifa.jpeg"); // load the image to a imageIcon
Image image1 = imageIcon1.getImage(); // transform it
Image newimg1 = image1.getScaledInstance(170, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imageIcon1 = new ImageIcon(newimg1);
panel.setLayout(null);

ImageIcon imageIcon2 = new ImageIcon("//Users//rohitupadhyay//Desktop//eclipse-workspace//Demo//images//god.jpeg"); // load the image to a imageIcon
Image image2 = imageIcon2.getImage(); // transform it
Image newimg2 = image2.getScaledInstance(170, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imageIcon2 = new ImageIcon(newimg2);
panel.setLayout(null);

ImageIcon imageIcon3 = new ImageIcon("//Users//rohitupadhyay//Desktop//eclipse-workspace//Demo//images//vice.jpeg"); // load the image to a imageIcon
Image image3 = imageIcon3.getImage(); // transform it
Image newimg3 = image3.getScaledInstance(170, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imageIcon3 = new ImageIcon(newimg3);
panel.setLayout(null);

ImageIcon imageIcon4 = new ImageIcon("//Users//rohitupadhyay//Desktop//eclipse-workspace//Demo//images//tlou.jpeg"); // load the image to a imageIcon
Image image4 = imageIcon4.getImage(); // transform it
Image newimg4 = image4.getScaledInstance(170, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imageIcon4 = new ImageIcon(newimg4);
panel.setLayout(null);

ImageIcon imageIcon5 = new ImageIcon("//Users//rohitupadhyay//Desktop//eclipse-workspace//Demo//images//nba2k.jpeg"); // load the image to a imageIcon
Image image5 = imageIcon5.getImage(); // transform it
Image newimg5 = image5.getScaledInstance(170, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imageIcon5 = new ImageIcon(newimg5);
panel.setLayout(null);

ImageIcon imageIcon6 = new ImageIcon("//Users//rohitupadhyay//Desktop//eclipse-workspace//Demo//images//halo.jpeg"); // load the image to a imageIcon
Image image6 = imageIcon6.getImage(); // transform it
Image newimg6 = image6.getScaledInstance(170, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imageIcon6 = new ImageIcon(newimg6);
panel.setLayout(null);

ImageIcon imageIcon7 = new ImageIcon("//Users//rohitupadhyay//Desktop//eclipse-workspace//Demo//images//home.png"); // load the image to a imageIcon
Image image7 = imageIcon7.getImage(); // transform it
Image newimg7 = image7.getScaledInstance(10, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
imageIcon7 = new ImageIcon(newimg7);
panel.setLayout(null);


JLabel lblNewLabel = new JLabel("");

lblNewLabel.setToolTipText("Book1");
lblNewLabel.setBounds(6, 6, 156, 190);
lblNewLabel.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/fifa13.jpg"));
panel.add(lblNewLabel);
String s="FIFA 13";
JLabel lblIndianMetropolis = new JLabel(s);
lblIndianMetropolis.setBounds(56, 198, 55, 18);
lblIndianMetropolis.setForeground(new Color(0, 0, 0));
panel.add(lblIndianMetropolis);

JButton btnNewButton = new JButton("ADD TO CART");
btnNewButton.setActionCommand("FIFA 13"); 
btnNewButton.addActionListener(actionListener);

btnNewButton.setBounds(23, 244, 114, 21);
panel.add(btnNewButton);
JLabel lblIndianMetropolis_6 = new JLabel("$59.99");
lblIndianMetropolis_6.setForeground(Color.BLACK);
lblIndianMetropolis_6.setBounds(56, 214, 55, 18);
panel.add(lblIndianMetropolis_6);

JPanel panel_1 = new JPanel();
panel_1.setLayout(null);
panel_1.setBounds(484, 146, 168, 271);
contentPane.add(panel_1);

JLabel lblNewLabel_1 = new JLabel("");

lblNewLabel_1.setIcon(imageIcon2);
lblNewLabel_1.setBounds(0, 0, 168, 202);
panel_1.add(lblNewLabel_1);

JLabel lblIndianMetropolis_1 = new JLabel("God Of War");
lblIndianMetropolis_1.setForeground(Color.BLACK);
lblIndianMetropolis_1.setBounds(54, 200, 81, 18);
panel_1.add(lblIndianMetropolis_1);

JButton btnNewButton_1 = new JButton("ADD TO CART");
btnNewButton_1.setActionCommand("God Of War"); 

btnNewButton_1.addActionListener(actionListener);
btnNewButton_1.setBounds(24, 244, 114, 21);
panel_1.add(btnNewButton_1);
JLabel lblIndianMetropolis_6_1 = new JLabel("$59.99");
lblIndianMetropolis_6_1.setForeground(Color.BLACK);
lblIndianMetropolis_6_1.setBounds(64, 214, 55, 18);
panel_1.add(lblIndianMetropolis_6_1);

JPanel panel_2 = new JPanel();
panel_2.setLayout(null);

panel_2.setBounds(726, 146, 168, 271);
contentPane.add(panel_2);

JLabel lblNewLabel_2 = new JLabel("");
lblNewLabel_2.setIcon(imageIcon3);
lblNewLabel_2.setBounds(0, 0, 168, 202);
panel_2.add(lblNewLabel_2);

JLabel lblIndianMetropolis_2 = new JLabel("Vice  City");
lblIndianMetropolis_2.setForeground(Color.BLACK);
lblIndianMetropolis_2.setBounds(59, 201, 78, 18);
panel_2.add(lblIndianMetropolis_2);

JButton btnNewButton_2 = new JButton("ADD TO CART");
btnNewButton_2.setActionCommand("Vice City"); 

btnNewButton_2.addActionListener(actionListener);
btnNewButton_2.setBounds(31, 244, 114, 21);
panel_2.add(btnNewButton_2);
JLabel lblIndianMetropolis_6_2 = new JLabel("$29.99");
lblIndianMetropolis_6_2.setForeground(Color.BLACK);
lblIndianMetropolis_6_2.setBounds(69, 214, 55, 18);
panel_2.add(lblIndianMetropolis_6_2);

JPanel panel_3 = new JPanel();
panel_3.setLayout(null);
panel_3.setBounds(242, 449, 168, 283);
contentPane.add(panel_3);

JLabel lblNewLabel_3 = new JLabel("");

lblNewLabel_3.setIcon(imageIcon4);
lblNewLabel_3.setBounds(0, 0, 168, 202);
panel_3.add(lblNewLabel_3);

JLabel lblIndianMetropolis_3 = new JLabel("The Last Of Us");
lblIndianMetropolis_3.setForeground(Color.BLACK);
lblIndianMetropolis_3.setBounds(41, 196, 97, 18);
panel_3.add(lblIndianMetropolis_3);

JButton btnNewButton_3 = new JButton("ADD TO CART");
btnNewButton_3.setActionCommand("The Last Of Us"); 

btnNewButton_3.addActionListener(actionListener);
btnNewButton_3.setBounds(24, 256, 114, 21);
panel_3.add(btnNewButton_3);
JLabel lblIndianMetropolis_6_4 = new JLabel("$59.99");
lblIndianMetropolis_6_4.setForeground(Color.BLACK);
lblIndianMetropolis_6_4.setBounds(62, 215, 55, 18);
panel_3.add(lblIndianMetropolis_6_4);

JPanel panel_4 = new JPanel();
panel_4.setLayout(null);
panel_4.setBounds(484, 449, 168, 283);
contentPane.add(panel_4);

JLabel lblNewLabel_4 = new JLabel("");

lblNewLabel_4.setIcon(imageIcon5);
lblNewLabel_4.setBounds(0, 0, 168, 202);
panel_4.add(lblNewLabel_4);

JLabel lblIndianMetropolis_4 = new JLabel("NBA 2K15");
lblIndianMetropolis_4.setForeground(Color.BLACK);
lblIndianMetropolis_4.setBounds(46, 201, 74, 18);
panel_4.add(lblIndianMetropolis_4);

JButton btnNewButton_4 = new JButton("ADD TO CART");
btnNewButton_4.setActionCommand("NBA 2K15"); 

btnNewButton_4.addActionListener(actionListener);
btnNewButton_4.setBounds(24, 256, 114, 21);
panel_4.add(btnNewButton_4);
JLabel lblIndianMetropolis_6_5 = new JLabel("$59.99");
lblIndianMetropolis_6_5.setForeground(Color.BLACK);
lblIndianMetropolis_6_5.setBounds(56, 226, 55, 18);
panel_4.add(lblIndianMetropolis_6_5);

JPanel panel_5 = new JPanel();
panel_5.setLayout(null);
panel_5.setBounds(726, 449, 168, 283);
contentPane.add(panel_5);

JLabel lblNewLabel_5 = new JLabel("");
lblNewLabel_5.setIcon(imageIcon6);
lblNewLabel_5.setBounds(0, 0, 168, 202);
panel_5.add(lblNewLabel_5);

JLabel lblIndianMetropolis_5 = new JLabel("Halo");
lblIndianMetropolis_5.setForeground(Color.BLACK);
lblIndianMetropolis_5.setBounds(66, 203, 78, 18);
panel_5.add(lblIndianMetropolis_5);

JButton btnNewButton_5 = new JButton("ADD TO CART");
btnNewButton_5.setActionCommand("Halo"); 

btnNewButton_5.addActionListener(actionListener);
btnNewButton_5.setBounds(24, 256, 114, 21);
panel_5.add(btnNewButton_5);
JLabel lblIndianMetropolis_6_6 = new JLabel("$59.99");
lblIndianMetropolis_6_6.setForeground(Color.BLACK);
lblIndianMetropolis_6_6.setBounds(60, 226, 55, 18);
panel_5.add(lblIndianMetropolis_6_6);
JPanel panel_6 = new JPanel();
panel_6.setBackground(new Color(35, 36, 109));
panel_6.setBounds(0, 0, 173, 818);
contentPane.add(panel_6);
panel_6.setLayout(null);
JLabel lblNewLabel_6 = new JLabel("ZenTraac");
lblNewLabel_6.setBounds(43, 6, 103, 28);
lblNewLabel_6.setForeground(new Color(245, 246, 241));
panel_6.add(lblNewLabel_6);
lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
JLabel lblNewLabel_6_1 = new JLabel("Gaming");
lblNewLabel_6_1.setBounds(53, 34, 74, 25);
lblNewLabel_6_1.setForeground(new Color(250, 249, 245));
lblNewLabel_6_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
panel_6.add(lblNewLabel_6_1);
JLabel lblNewLabel_7 = new JLabel("");
lblNewLabel_7.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/home.jpg"));
lblNewLabel_7.setBounds(66, 157, 49, 48);
panel_6.add(lblNewLabel_7);
JButton btnNewButton_6 = new JButton("");
btnNewButton_6.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		
	}
});
btnNewButton_6.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/cart.jpg"));
btnNewButton_6.setBounds(66, 258, 49, 48);
panel_6.add(btnNewButton_6);
JButton btnNewButton_6_1 = new JButton("");
btnNewButton_6_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Login l=new Login();
        l.setVisible(true);
       // dispose();
	}
});
btnNewButton_6_1.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/profile (1).jpg"));
btnNewButton_6_1.setBounds(66, 369, 49, 48);
panel_6.add(btnNewButton_6_1);
JPanel panel_2_1 = new JPanel();
panel_2_1.setLayout(null);
panel_2_1.setBounds(982, 146, 168, 271);
contentPane.add(panel_2_1);
JLabel lblNewLabel_2_1 = new JLabel("");
lblNewLabel_2_1.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/WWE.jpg"));
lblNewLabel_2_1.setBounds(0, 0, 168, 202);
panel_2_1.add(lblNewLabel_2_1);
JLabel lblIndianMetropolis_2_1 = new JLabel("WWE 2K15");
lblIndianMetropolis_2_1.setForeground(Color.BLACK);
lblIndianMetropolis_2_1.setBounds(52, 202, 78, 18);
panel_2_1.add(lblIndianMetropolis_2_1);
JButton btnNewButton_2_1 = new JButton("ADD TO CART");
btnNewButton_2_1.setActionCommand("WWE 2K15"); 

btnNewButton_2_1.addActionListener(actionListener);
btnNewButton_2_1.setBounds(32, 244, 114, 21);
panel_2_1.add(btnNewButton_2_1);
JLabel lblIndianMetropolis_6_3 = new JLabel("$59.99");
lblIndianMetropolis_6_3.setForeground(Color.BLACK);
lblIndianMetropolis_6_3.setBounds(62, 226, 55, 18);
panel_2_1.add(lblIndianMetropolis_6_3);
JPanel panel_2_1_1 = new JPanel();
panel_2_1_1.setLayout(null);
panel_2_1_1.setBounds(982, 449, 168, 283);
contentPane.add(panel_2_1_1);
JLabel lblNewLabel_2_1_1 = new JLabel("");
lblNewLabel_2_1_1.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/spidey.jpg"));
lblNewLabel_2_1_1.setBounds(0, 0, 168, 202);
panel_2_1_1.add(lblNewLabel_2_1_1);
JLabel lblIndianMetropolis_2_1_1 = new JLabel("Spider-Man");
lblIndianMetropolis_2_1_1.setForeground(Color.BLACK);
lblIndianMetropolis_2_1_1.setBounds(52, 202, 78, 18);
panel_2_1_1.add(lblIndianMetropolis_2_1_1);
JButton btnNewButton_2_1_1 = new JButton("ADD TO CART");
btnNewButton_2_1_1.setActionCommand("Spider-Man"); 

btnNewButton_2_1_1.addActionListener(actionListener);
btnNewButton_2_1_1.setBounds(31, 256, 114, 21);
panel_2_1_1.add(btnNewButton_2_1_1);
JLabel lblIndianMetropolis_6_7 = new JLabel("$59.99");
lblIndianMetropolis_6_7.setForeground(Color.BLACK);
lblIndianMetropolis_6_7.setBounds(62, 226, 55, 18);
panel_2_1_1.add(lblIndianMetropolis_6_7);
JPanel panel_2_1_2 = new JPanel();
panel_2_1_2.setLayout(null);
panel_2_1_2.setBounds(1227, 146, 168, 271);
contentPane.add(panel_2_1_2);
JLabel lblNewLabel_2_1_2 = new JLabel("");
lblNewLabel_2_1_2.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/battlefield (1).jpg"));
lblNewLabel_2_1_2.setBounds(0, 0, 168, 202);
panel_2_1_2.add(lblNewLabel_2_1_2);
JLabel lblIndianMetropolis_2_1_2 = new JLabel("Battlefield 4");
lblIndianMetropolis_2_1_2.setForeground(Color.BLACK);
lblIndianMetropolis_2_1_2.setBounds(52, 202, 78, 18);
panel_2_1_2.add(lblIndianMetropolis_2_1_2);
JButton btnNewButton_2_1_2 = new JButton("ADD TO CART");
btnNewButton_2_1_2.setActionCommand("Battlefield 4"); 

btnNewButton_2_1_2.addActionListener(actionListener);

btnNewButton_2_1_2.setBounds(31, 244, 114, 21);
panel_2_1_2.add(btnNewButton_2_1_2);
JLabel lblIndianMetropolis_6_9 = new JLabel("$59.99");
lblIndianMetropolis_6_9.setForeground(Color.BLACK);
lblIndianMetropolis_6_9.setBounds(62, 224, 55, 18);
panel_2_1_2.add(lblIndianMetropolis_6_9);
JPanel panel_2_1_1_1 = new JPanel();
panel_2_1_1_1.setLayout(null);
panel_2_1_1_1.setBounds(1227, 449, 168, 283);
contentPane.add(panel_2_1_1_1);
JLabel lblNewLabel_2_1_1_1 = new JLabel("");
lblNewLabel_2_1_1_1.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/dbz (1).jpg"));
lblNewLabel_2_1_1_1.setBounds(0, 0, 168, 202);
panel_2_1_1_1.add(lblNewLabel_2_1_1_1);
JLabel lblIndianMetropolis_2_1_1_1 = new JLabel("Dragon Ball Z BT3");
lblIndianMetropolis_2_1_1_1.setForeground(Color.BLACK);
lblIndianMetropolis_2_1_1_1.setBounds(31, 206, 120, 18);
panel_2_1_1_1.add(lblIndianMetropolis_2_1_1_1);
JButton btnNewButton_2_1_1_1 = new JButton("ADD TO CART");
btnNewButton_2_1_1_1.setActionCommand("Dragon Ball Z BT3"); 

btnNewButton_2_1_1_1.addActionListener(actionListener);

btnNewButton_2_1_1_1.setBounds(31, 256, 114, 21);
panel_2_1_1_1.add(btnNewButton_2_1_1_1);
JLabel lblIndianMetropolis_6_8 = new JLabel("$29.99");
lblIndianMetropolis_6_8.setForeground(Color.BLACK);
lblIndianMetropolis_6_8.setBounds(61, 226, 55, 18);
panel_2_1_1_1.add(lblIndianMetropolis_6_8);
JLabel lblProducts = new JLabel("PRODUCTS");
lblProducts.setForeground(new Color(242, 253, 255));
lblProducts.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
lblProducts.setBounds(702, 34, 223, 50);
contentPane.add(lblProducts);


}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}