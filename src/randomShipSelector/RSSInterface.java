package randomShipSelector;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

public class RSSInterface {

	private JFrame frame;
	private RSSAddShip addShip = new RSSAddShip();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RSSInterface window = new RSSInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RSSInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddShip = new JButton("Add Ship");
		btnAddShip.setBounds(10, 11, 89, 23);
		btnAddShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addShip.display();
			};
		});
		frame.getContentPane().add(btnAddShip);
	}
}
