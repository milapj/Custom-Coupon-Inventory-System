import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ListPrice extends JFrame {

	private JPanel contentPane;
	Tesr_1 object = new Tesr_1();
	fucntions object_1 = new fucntions();
	String[] test = new String[object_1.list.mainArray.length];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPrice frame = new ListPrice();
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
	public ListPrice() {
		object_1.read();
		object_1.sortList();
		object_1.ExpirtySort();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 614);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Create the list to display the master list.
		JList list = new JList();
		list.setBounds(41, 124, 662, 462);
		contentPane.add(list);
		
		for (int j = 0;j<test.length;j++) {
			test[j] = object_1.list.mainArray[j];
			System.out.println(object_1.list.mainArray[j]);
		}
		// Create the back button
		JButton btnClear = new JButton("Back");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPrice frame = new ListPrice();
				frame.dispose();
				object.frame.setVisible(true);//Switches to the main frame.
				list.removeAll();
			}
		});
		btnClear.setBounds(615, 39, 117, 29);
		contentPane.add(btnClear);
		//Creates the Load button.
		JButton btnNewButton = new JButton("Load");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> DLM_Price = new DefaultListModel<String>();
				for (int i =0; i<test.length;i++) {
					DLM_Price.addElement(test[i]);//Populates the list with sorted masterlist.
				}
				list.setModel(DLM_Price);
			}
		});
		btnNewButton.setBounds(58, 39, 117, 29);
		contentPane.add(btnNewButton);
	}
}
