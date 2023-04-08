package trail;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login1 l=new Login1();
		        l.setVisible(true);
		       // dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnNewButton.setBounds(533, 395, 204, 82);
		contentPane.add(btnNewButton);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setForeground(new Color(0, 0, 0));
		btnSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnSignUp.setBounds(809, 395, 204, 82);
		contentPane.add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/rohitupadhyay/Desktop/eclipse-workspace/Demo/images/gaming.jpg"));
		lblNewLabel.setBounds(0, 0, 1469, 812);
		contentPane.add(lblNewLabel);
		setSize(1650,1080);
		
		
	}
}
