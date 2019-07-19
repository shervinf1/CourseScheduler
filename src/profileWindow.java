import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class profileWindow extends JFrame {

	private JPanel contentPane;
	private JTextField firstField;
	private JTextField lastField;
	private JTextField sNumberField;
	private JTextField emailField;
	private JTextField universityField;
	private JTextField degreeField;
	private JTextField majorField;
	private JTextField firstProField;
	private JTextField lastProField;
	private JTextField eNumberProField;
	private JTextField emailProField;
	private JTextField degreeObtainedProField;
	private JTextField universityProField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profileWindow frame = new profileWindow();
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
	public profileWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ArrayList<String> prof = new ArrayList<String>();
		 DefaultListModel demoList = new DefaultListModel();
		JList list = new JList(demoList);
		list.setBounds(38, 170, 89, 168);
		contentPane.add(list);
		
		JLabel lblSelectAProfile = new JLabel("Select a Profile");
		lblSelectAProfile.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectAProfile.setBounds(38, 132, 104, 14);
		contentPane.add(lblSelectAProfile);
		
		JLabel lblAddAProfile = new JLabel("Add a Profile");
		lblAddAProfile.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddAProfile.setBounds(339, 72, 104, 14);
		contentPane.add(lblAddAProfile);
		
		JButton addStudent = new JButton("Student");
		addStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(firstField.getText() == "" || lastField.getText() == "" || sNumberField.getText() == "" || emailField.getText() == "" || universityField.getText() == "" || degreeField.getText() == "" || majorField.getText() == "")
				{
					JOptionPane.showMessageDialog(null, "Fill out all fields");
				}
				else
				{
					Student sObject = new Student(sNumberField.getText(),degreeField.getText(),majorField.getText());
					sObject.setFirstName(firstField.getText());
					sObject.setLastName(lastField.getText());
					sObject.setEmail(emailField.getText());
					sObject.setUniversity(universityField.getText());
					//prof.add(sObject.getFirstName());
					demoList.addElement(sObject.getFirstName());
					CourseScheduler csWindow = new CourseScheduler();
					csWindow.setObject(sObject);
					
				}
			}
		});
		addStudent.setBounds(220, 372, 89, 23);
		contentPane.add(addStudent);
		
		JButton addProfessor = new JButton("Professor");
		addProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(firstProField.getText() == "" || lastProField.getText() == "" || eNumberProField.getText() == "" || emailProField.getText() == "" || universityProField.getText() == "" || degreeObtainedProField.getText() == "")
				{
					JOptionPane.showMessageDialog(null, "Fill out all fields");
				}
				else
				{
					Professor pObject = new Professor(eNumberProField.getText(),degreeObtainedProField.getText());
					pObject.setFirstName(firstProField.getText());
					pObject.setLastName(lastProField.getText());
					pObject.setEmail(emailProField.getText());
					pObject.setUniversity(universityProField.getText());
					demoList.addElement(pObject.getFirstName());
					CourseScheduler csWindow = new CourseScheduler();
					csWindow.setObject(pObject);
					
				}
			}
		});
		addProfessor.setBounds(451, 372, 89, 23);
		contentPane.add(addProfessor);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("Ok")) {
		            String s = (String) list.getSelectedValue();
		        }
			}
		});
		btnOk.setBounds(38, 372, 89, 23);
		contentPane.add(btnOk);
		
		JLabel label = new JLabel("First Name");
		label.setBounds(196, 115, 60, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Last Name");
		label_1.setBounds(196, 151, 60, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Student Number");
		label_2.setBounds(173, 191, 83, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Email");
		label_3.setBounds(210, 233, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("University");
		label_4.setBounds(196, 268, 60, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Degree");
		label_5.setBounds(210, 309, 46, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Major");
		label_6.setBounds(210, 344, 46, 14);
		contentPane.add(label_6);
		
		firstField = new JTextField();
		firstField.setColumns(10);
		firstField.setBounds(268, 112, 86, 20);
		contentPane.add(firstField);
		
		lastField = new JTextField();
		lastField.setColumns(10);
		lastField.setBounds(268, 148, 86, 20);
		contentPane.add(lastField);
		
		sNumberField = new JTextField();
		sNumberField.setColumns(10);
		sNumberField.setBounds(268, 188, 86, 20);
		contentPane.add(sNumberField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(268, 230, 86, 20);
		contentPane.add(emailField);
		
		universityField = new JTextField();
		universityField.setColumns(10);
		universityField.setBounds(268, 265, 86, 20);
		contentPane.add(universityField);
		
		degreeField = new JTextField();
		degreeField.setColumns(10);
		degreeField.setBounds(268, 306, 86, 20);
		contentPane.add(degreeField);
		
		majorField = new JTextField();
		majorField.setColumns(10);
		majorField.setBounds(268, 341, 86, 20);
		contentPane.add(majorField);
		
		JLabel label_7 = new JLabel("First Name");
		label_7.setBounds(415, 133, 62, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Last Name");
		label_8.setBounds(415, 171, 62, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Email");
		label_9.setBounds(438, 243, 39, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Employee Number");
		label_10.setBounds(383, 209, 94, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("Degree Obtained");
		label_11.setBounds(383, 281, 94, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("University");
		label_12.setBounds(415, 322, 62, 14);
		contentPane.add(label_12);
		
		firstProField = new JTextField();
		firstProField.setColumns(10);
		firstProField.setBounds(487, 130, 86, 20);
		contentPane.add(firstProField);
		
		lastProField = new JTextField();
		lastProField.setColumns(10);
		lastProField.setBounds(487, 168, 86, 20);
		contentPane.add(lastProField);
		
		eNumberProField = new JTextField();
		eNumberProField.setColumns(10);
		eNumberProField.setBounds(487, 206, 86, 20);
		contentPane.add(eNumberProField);
		
		emailProField = new JTextField();
		emailProField.setColumns(10);
		emailProField.setBounds(487, 237, 86, 20);
		contentPane.add(emailProField);
		
		degreeObtainedProField = new JTextField();
		degreeObtainedProField.setColumns(10);
		degreeObtainedProField.setBounds(487, 275, 86, 20);
		contentPane.add(degreeObtainedProField);
		
		universityProField = new JTextField();
		universityProField.setColumns(10);
		universityProField.setBounds(487, 316, 86, 20);
		contentPane.add(universityProField);
		
	}
}
