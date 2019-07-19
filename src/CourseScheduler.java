import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.*;
import java.util.Scanner;
import java.awt.SystemColor;

public class CourseScheduler {

	private JFrame frmScheduler;
	private JTextField courseName;
	private JTable table;
	private people s;
	private Professor p;
	private JTextField profileName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CourseScheduler window = new CourseScheduler();
					profileWindow pWindow = new profileWindow();
					
					window.loadInto();
					window.frmScheduler.setVisible(true);
					pWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public CourseScheduler() {
		initialize();
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScheduler = new JFrame();
		frmScheduler.setTitle("Scheduler");
		frmScheduler.setBounds(100, 100, 808, 524);
		frmScheduler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScheduler.getContentPane().setLayout(null);

		courseName = new JTextField();
		courseName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				courseName.setText("");
			}
		});
		courseName.setHorizontalAlignment(SwingConstants.CENTER);
		courseName.setText("Enter Name");
		courseName.setBounds(665, 76, 98, 20);
		frmScheduler.getContentPane().add(courseName);
		courseName.setColumns(10);
		
		
		JLabel lblEnterName = new JLabel("WEEKLY COURSE SCHEDULE");
		lblEnterName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEnterName.setBounds(235, 63, 238, 33);
		frmScheduler.getContentPane().add(lblEnterName);
		
		JList list = new JList();
		list.setBounds(723, 181, -57, -29);
		frmScheduler.getContentPane().add(list);
		
		//Combo box that lists the hours you can select for the courses
		String[] courseHour = {"","08:00 AM","09:00 AM","10:00 AM","11:00 AM","12:00 PM","01:00 PM","02:00 PM","03:00 PM","04:00 PM","05:00 PM"};//Creating String array that holds the hours in a day
		JComboBox comboHour = new JComboBox(courseHour);
		comboHour.setBackground(SystemColor.menu);
		comboHour.setBounds(665, 132, 98, 20);
		frmScheduler.getContentPane().add(comboHour);
	
		//Combo box that lists the days you can select for the courses
		String[] courseDay = {"","Monday","Tuesday","Wendsday","Thursday","Friday"};	//Creating String array that holds days of the week
		JComboBox comboDay = new JComboBox(courseDay);
		comboDay.setBackground(SystemColor.menu);
		comboDay.setBounds(665, 188, 98, 20);
		frmScheduler.getContentPane().add(comboDay);
		
		//This button is to add a course to the JTable
		JButton btnOk = new JButton("Add");
		btnOk.setBackground(SystemColor.menu);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//If else statement that gives a 
				if(comboDay.getSelectedIndex() == -1 || comboHour.getSelectedIndex() == -1 || comboDay.getSelectedIndex() == 0 || comboHour.getSelectedIndex() == 0)
				{
					JOptionPane.showMessageDialog(btnOk, "All options must be selected, please try again...");
				}
				else
				{
					courseName.setText(courseName.getText().toUpperCase());
					//Setting the value at pertaining JTable cell to the course name entered
					table.setValueAt(courseName.getText(),(comboHour.getSelectedIndex()-1),(comboDay.getSelectedIndex()-1));
						
				}
			}
		});
		
		//Creating JTable
		table = new JTable(10,5);
		
		table.setRowSelectionAllowed(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		table.setBounds(86, 136, 540, 260);
		frmScheduler.getContentPane().add(table);
		btnOk.setBounds(661, 232, 106, 41);
		frmScheduler.getContentPane().add(btnOk);
		table.setRowHeight(table.getRowHeight()+10);
		
		
		//Button to exit the main program
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(SystemColor.menu);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		
		//Button to remove a course from the JTable
		JButton btnRemoveCourse = new JButton("Remove");
		btnRemoveCourse.setBackground(SystemColor.menu);
		btnRemoveCourse.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				String courseName = JOptionPane.showInputDialog("Enter name of course you want to remove");
				for(int i = 0;i<10;i++)
				{
					for(int j = 0;j<5;j++)
					{
						
						if(courseName.toUpperCase().equals(table.getValueAt(i, j)))
						{
							table.setValueAt(null, i, j);
						}
					}
				}
			}
		});
		btnRemoveCourse.setBounds(661, 284, 106, 41);
		frmScheduler.getContentPane().add(btnRemoveCourse);
		btnExit.setBounds(661, 432, 106, 31);
		frmScheduler.getContentPane().add(btnExit);
		
		//Adding a button to save and print the contents inserted from the user into a .txt file
		JButton btnSave = new JButton("Save Table");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					PrintWriter outputFile = new PrintWriter("C:\\Users\\Shervin\\eclipse-workspace\\GUIDemo2\\CourseSchedule.txt");
					outputFile.println(s.getFirstName());
					for(int i = 0;i<table.getRowCount();i++)
					{
						for (int j= 0;j<table.getColumnCount();j++)
						{	
							if(table.getValueAt(i,j) != null)
							{
								outputFile.print(table.getValueAt(i, j));
								outputFile.print(",");
							}
							else
							{
								outputFile.print("\t");
								outputFile.print(",");
							}
						}
						outputFile.println();
					}
					JOptionPane.showMessageDialog(null, "Schedule has been saved...");
					outputFile.close();
				} 
				catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnSave.setBackground(SystemColor.menu);
		btnSave.setBounds(661, 336, 106, 41);
		frmScheduler.getContentPane().add(btnSave);
		
		
		
		/*
		 * 
		 * Below is the code to add all the 
		 * labels 
		 * to the GUI
		 * 
		 * */

		JLabel lblCourseName = new JLabel("Course Name",SwingConstants.CENTER);
		lblCourseName.setBounds(665, 53, 98, 14);
		frmScheduler.getContentPane().add(lblCourseName);
		
		JLabel lblCourseHours = new JLabel("Course Hour",SwingConstants.CENTER);
		lblCourseHours.setBounds(665, 107, 98, 14);
		frmScheduler.getContentPane().add(lblCourseHours);
		
		JLabel lblCourseDays = new JLabel("Course Day",SwingConstants.CENTER);
		lblCourseDays.setBounds(665, 163, 98, 14);
		frmScheduler.getContentPane().add(lblCourseDays);
		
		JLabel lblMon = new JLabel("Mon");
		lblMon.setBounds(127, 116, 26, 14);
		frmScheduler.getContentPane().add(lblMon);
		
		JLabel lblTue = new JLabel("Tue");
		lblTue.setBounds(235, 116, 26, 14);
		frmScheduler.getContentPane().add(lblTue);
		
		JLabel lblWen = new JLabel("Wen");
		lblWen.setBounds(343, 116, 26, 14);
		frmScheduler.getContentPane().add(lblWen);
		
		JLabel lblThu = new JLabel("Thu");
		lblThu.setBounds(449, 116, 26, 14);
		frmScheduler.getContentPane().add(lblThu);
		
		JLabel lblFri = new JLabel("Fri");
		lblFri.setBounds(562, 116, 26, 14);
		frmScheduler.getContentPane().add(lblFri);
		
		JLabel label = new JLabel("08:00");
		label.setBounds(51, 137, 32, 14);
		frmScheduler.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("09:00");
		label_1.setBounds(51, 162, 32, 14);
		frmScheduler.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("10:00");
		label_2.setBounds(51, 187, 32, 14);
		frmScheduler.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("11:00");
		label_3.setBounds(51, 213, 32, 14);
		frmScheduler.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("12:00");
		label_4.setBounds(51, 240, 32, 14);
		frmScheduler.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("01:00");
		label_5.setBounds(51, 265, 32, 14);
		frmScheduler.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("02:00");
		label_6.setBounds(51, 292, 32, 14);
		frmScheduler.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("03:00");
		label_7.setBounds(51, 320, 32, 14);
		frmScheduler.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("04:00");
		label_8.setBounds(51, 345, 32, 14);
		frmScheduler.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("05:00");
		label_9.setBounds(51, 370, 32, 14);
		frmScheduler.getContentPane().add(label_9);
		
		JLabel lblCourseDetails = new JLabel("COURSE DETAILS");
		lblCourseDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCourseDetails.setBounds(661, 28, 106, 14);
		frmScheduler.getContentPane().add(lblCourseDetails);
		
		JButton btnClearTable = new JButton("Clear Table");
		btnClearTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0;i<table.getRowCount();i++)
				{
					for (int j = 0;j<table.getColumnCount();j++)
					{
						table.setValueAt(null, i, j);
					}
				}
			}
		});
		btnClearTable.setBackground(SystemColor.menu);
		btnClearTable.setBounds(661, 388, 106, 33);
		frmScheduler.getContentPane().add(btnClearTable);
		
		JLabel lblProfile = new JLabel("Profile:");
		lblProfile.setBounds(79, 440, 46, 14);
		frmScheduler.getContentPane().add(lblProfile);
		
		profileName = new JTextField();
		profileName.setBounds(127, 437, 86, 20);
		frmScheduler.getContentPane().add(profileName);
		profileName.setColumns(10);
				
	}
	//Method to load the Jtable with a previous schedule saved to a .txt file
	private void loadInto()
	{
		try {
			
			Scanner scanner = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Shervin\\eclipse-workspace\\GUIDemo2\\CourseSchedule.txt")));
			//while(scanner.nextLine() == s.getFirstName())
			//{
				while(scanner.hasNextLine())
				{
					for(int i = 0;i<table.getRowCount();i++) {
						String[] line = scanner.nextLine().trim().split(",");
						for (int j = 0;j<table.getColumnCount();j++)
						{		
							table.setValueAt(line[j], i, j);					
						}
					}
				}
			//}
			scanner.close();
		}catch (IOException ioexception) {}
	}
	
	public void setObject(people s)
	{
		this.s = s;
	}
	/*
	public void setProfessor(Professor p)
	{
		this.p = p;
	}*/
}
