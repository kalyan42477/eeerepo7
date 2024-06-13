package mysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mydb {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mydb window = new mydb();
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
	public mydb() {
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
		
		JLabel lblNewLabel = new JLabel("STUDENT REGISTRAION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(143, 11, 171, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel tb1 = new JLabel("ROLL NO");
		tb1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tb1.setBounds(26, 56, 46, 14);
		frame.getContentPane().add(tb1);
		
		JLabel tb2 = new JLabel("NAME");
		tb2.setFont(new Font("Tahoma", Font.BOLD, 11));
		tb2.setBounds(26, 103, 46, 14);
		frame.getContentPane().add(tb2);
		
		JLabel cb1 = new JLabel("BRANCH");
		cb1.setFont(new Font("Tahoma", Font.BOLD, 11));
		cb1.setBounds(26, 146, 46, 14);
		frame.getContentPane().add(cb1);
		
		JLabel tb3 = new JLabel("MARKS");
		tb3.setFont(new Font("Tahoma", Font.BOLD, 11));
		tb3.setBounds(26, 184, 46, 14);
		frame.getContentPane().add(tb3);
		
		textField = new JTextField();
		textField.setBounds(145, 53, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 100, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 181, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "EEE", "ECE", "CSE", "MECH"}));
		comboBox.setBounds(145, 142, 86, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rno=tb1.getText();
				String rollno=Integer.parseInt(rno);
				String name=tb2.getText();
				String branch=(String) cb1.getSelectedItem();
				string m=tb3.getText();
				int marks=Integer.parseInt(m);
				try
				{
					connection con=DriveManager.getConnection("jdc:mysql://Localhost:3306/mydb","root","mrec");
					String q="insert into student values('"+rollno+"','"+name+"','"+branch+"','"+marks+"');
				    Statement stn=con,createStatement();
					stn.executeUpdate(q);
					con.close();
					JOptionPane=showMessageDialog(btnNewButton,"inserted successfully");
				}
				catch(SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(162, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\online\\Desktop\\111111.jpg"));
		lblNewLabel_1.setBounds(120, 11, 434, 261);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
