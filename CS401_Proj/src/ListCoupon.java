import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JRadioButton;
import java.awt.Color;

public class ListCoupon extends JFrame {

	private JPanel contentPane;
	public JList<String> list = list = new JList<String>();
	fucntions object  = new fucntions();
	String[] test = new String[object.list.mainArray.length];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCoupon frame = new ListCoupon();
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
	public ListCoupon() {
		object.read();
		object.sortList();
		object.listPriceL2H();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 614);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Create the Back buttom
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCoupon object = new ListCoupon();
				object.dispose();
				Tesr_1 object_1 = new Tesr_1();
				object_1.frame.setVisible(true);//Switches to the main frame.
				list.removeAll();
			}
		});
		btnBack.setBounds(615, 34, 117, 29);
		contentPane.add(btnBack);
		
		
		list.setBounds(54, 161, 640, 388);
		contentPane.add(list);
		
		for (int j = 0;j<test.length;j++) {
			test[j] = object.list.mainArray[j];
			System.out.println(object.list.mainArray[j]);
		}
		//Create the Load button.
		JButton btnLoad = new JButton("Load Price");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel<String> DLM_Price = new DefaultListModel<String>();
				object.listPriceL2H();
				for (int i =0; i<test.length;i++) {
					DLM_Price.addElement(test[i]);//Populates the list with sorted output.
				}
				list.setModel(DLM_Price);
			}
		});
		btnLoad.setBounds(76, 34, 117, 29);
		contentPane.add(btnLoad);
	}
}
