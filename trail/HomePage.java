package trail;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/*
class Home2 extends JPanel {

	  private static final long serialVersionUID = 1L;
	Image image;

	  public Home2() {
	    image = Toolkit.getDefaultToolkit().createImage("Images/spin.gif");
	  }

	  @Override
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if (image != null) {
	      g.drawImage(image, 0, 0, this);
	    }
	  }

	}*/
public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	
	public HomePage() {
		ActionListener actionListener = new ActionListener() {
	        public void actionPerformed(ActionEvent event) {
	        
	          Products obj=new Products();
	          obj.setVisible(true);
	          dispose();
	        }
	     };
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ZENTRAAC ");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(254, 250, 253));
		lblNewLabel_1.setFont(new Font("Myanmar MN", Font.BOLD, 30));
		lblNewLabel_1.setBounds(601, 324, 176, 88);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("GAMING");
		lblNewLabel_1_1.setForeground(new Color(171, 1, 14));
		lblNewLabel_1_1.setFont(new Font("Myanmar MN", Font.BOLD, 30));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(789, 324, 176, 88);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("ENTER NOW!");
		btnNewButton.addActionListener(actionListener);
		btnNewButton.setForeground(new Color(171, 1, 14));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		btnNewButton.setBounds(678, 400, 176, 57);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/gaming.jpg"));
		lblNewLabel.setBounds(0, 0, 1471, 823);
		contentPane.add(lblNewLabel);
		
		
		setSize(1650,1080);
		
		
		
	}
}
