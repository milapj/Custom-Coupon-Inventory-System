import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;

public class Tesr_1 {

	public JFrame frame;
	private JTextField txtWelcomeToCis;
	fucntions object = new fucntions();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tesr_1 window = new Tesr_1();
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
	public Tesr_1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 738, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// Create Text Field Display.
		JTextPane txtpnWelcomeToCis = new JTextPane();
		txtpnWelcomeToCis.setText("Welcome to CIS by Milap Jhumkhawala");
		txtpnWelcomeToCis.setBounds(264, 570, 261, 16);
		frame.getContentPane().add(txtpnWelcomeToCis);
		
		// Create the Add Button.
		JButton btnAddCoupon = new JButton("Add Coupon");
		btnAddCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				object.read();
				txtpnWelcomeToCis.setText("Number of coupons imported: " + (object.elements));
				object.sortList();
			}
		});
		btnAddCoupon.setBounds(302, 33, 117, 29);
		frame.getContentPane().add(btnAddCoupon);
		
		//Create Text Input Field for search.
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(Color.WHITE);
		editorPane.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		editorPane.setBounds(6, 118, 190, 16);
		frame.getContentPane().add(editorPane);
		// Create Label.
		JLabel lblNewLabel = new JLabel("Enter Coupon name+ID to search");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 74, 270, 29);
		frame.getContentPane().add(lblNewLabel);
		//Create Label for Linear Search Result.
		JLabel lblsearchResult = new JLabel("");
		lblsearchResult.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblsearchResult.setBounds(6, 197, 270, 16);
		frame.getContentPane().add(lblsearchResult);
		//Create label for Binary Search Result.
		JLabel lblbinarySearch = new JLabel("");
		lblbinarySearch.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblbinarySearch.setBounds(6, 237, 270, 16);
		frame.getContentPane().add(lblbinarySearch);
		//Create Search Button.
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userIn = editorPane.getText();
				String first[] = userIn.split("\\s+");
				lblsearchResult.setText(object.linearSearch(first[0], first[1]));
				lblbinarySearch.setText(object.binarySearch(first[0], first[1]));
			}
		});
		btnSearch.setBounds(22, 33, 117, 29);
		frame.getContentPane().add(btnSearch);
		
		//Create List Button.
		JButton btnListCoupon = new JButton("List Price");
		btnListCoupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ListCoupon object = new ListCoupon(); // Switch to other Frame.
				object.setVisible(true);
			}
		});
		btnListCoupon.setBounds(574, 33, 117, 29);
		frame.getContentPane().add(btnListCoupon);
		//Create Clear Button.
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblbinarySearch.setText("");
				lblsearchResult.setText("");
				editorPane.setText("");
			}
		});
		btnClear.setBounds(22, 277, 117, 29);
		frame.getContentPane().add(btnClear);
		
		JButton btnListExpiry = new JButton("List Expiry");
		btnListExpiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ListPrice  abc = new ListPrice(); //Switch to other frame.
				abc.setVisible(true);
			}
		});
		btnListExpiry.setBounds(574, 118, 117, 29);
		frame.getContentPane().add(btnListExpiry);
		//Create Label
		JLabel lblEnterCouponnameidpricediscountexpirystatus = new JLabel("Enter Coupon(Name +ID+Product+Price+Discount%+Expiry+Status");
		lblEnterCouponnameidpricediscountexpirystatus.setBackground(Color.WHITE);
		lblEnterCouponnameidpricediscountexpirystatus.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblEnterCouponnameidpricediscountexpirystatus.setBounds(221, 118, 341, 16);
		frame.getContentPane().add(lblEnterCouponnameidpricediscountexpirystatus);
		//Create Input Text Field for Individual Coupon entry.
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBackground(Color.WHITE);
		editorPane_1.setBounds(221, 146, 275, 16);
		frame.getContentPane().add(editorPane_1);
		// Create "Enter" button.
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String one = editorPane_1.getText();
				try {
					object.write(one);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (object.elements == 30) {
					JOptionPane.showMessageDialog(null, "System Size Limit Reached, Increasing the size");
				}
				object.elements++;
				txtpnWelcomeToCis.setText("Number of coupons imported: " + (object.elements));
			}
		});
		btnEnter.setBounds(302, 184, 117, 29);
		frame.getContentPane().add(btnEnter);	
	}
}
