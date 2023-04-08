package trail;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThankYou extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThankYou frame = new ThankYou();
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
	public ThankYou() {
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
		
		JLabel lblNewLabel_1 = new JLabel("HAPPY");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(254, 250, 253));
		lblNewLabel_1.setFont(new Font("Myanmar MN", Font.BOLD, 30));
		lblNewLabel_1.setBounds(658, 324, 119, 88);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("GAMING");
		lblNewLabel_1_1.setForeground(new Color(171, 1, 14));
		lblNewLabel_1_1.setFont(new Font("Myanmar MN", Font.BOLD, 30));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(789, 324, 176, 88);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Shop More!");
		btnNewButton.addActionListener(actionListener);
		
		JLabel lblNewLabel_1_2 = new JLabel("PURCHASE   ");
		lblNewLabel_1_2.setForeground(new Color(254, 250, 253));
		lblNewLabel_1_2.setFont(new Font("Myanmar MN", Font.BOLD, 30));
		lblNewLabel_1_2.setBackground(Color.BLACK);
		lblNewLabel_1_2.setBounds(581, 241, 196, 88);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("SUCCESSFULL!");
		lblNewLabel_1_2_1.setForeground(new Color(171, 1, 14));
		lblNewLabel_1_2_1.setFont(new Font("Myanmar MN", Font.BOLD, 30));
		lblNewLabel_1_2_1.setBackground(Color.BLACK);
		lblNewLabel_1_2_1.setBounds(789, 241, 259, 88);
		contentPane.add(lblNewLabel_1_2_1);
		btnNewButton.setForeground(new Color(171, 1, 14));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		btnNewButton.setBounds(694, 400, 176, 57);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/gaming.jpg"));
		lblNewLabel.setBounds(0, 0, 1471, 823);
		contentPane.add(lblNewLabel);
		
		setSize(1650,1080);
	}
}
