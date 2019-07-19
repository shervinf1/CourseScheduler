
public class people {
	private String firstName;
	private String lastName;
	private String email;
	private String university;
	
	/*
	 * Constructors
	 * 
	 * */
	
	//Default constructo
	people()
	{
	}
	people(String firstName, String lastName, String email, String university)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.university=university;
	}
	/*
	 * Setters(access modifiers) for the private variables for each person object
	 * 
	 * 
	 * */
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setUniversity(String university)
	{
		this.university=university;
	}
	/*
	 * Getters for the private variables for each person object
	 * 
	 * 
	 * */
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getEmail()
	{
		return email;
	}
	public String getUniversity()
	{
		return university;
	}	
}
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
class Student extends people
{
	private String studentNumber;
	private String degree;
	private String major;
	
	
	/*
	 * Constructors
	 * 
	 * */
	//Default Constructor
	Student()
	{
		super();
	}
	//Special Constructor
	Student(String studentNumber, String degree, String major)
	{
		super();
		this.studentNumber=studentNumber;
		this.degree=degree;
		this.major=major;
	}
	
	/*
	 * setters or access modifiers for the private fields
	 * 
	 * */
	public void setStudentNumber(String studentNumber)
	{
		this.studentNumber=studentNumber;
	}
	public void setDegree(String degree)
	{
		this.degree=degree;
	}
	public void setMajor(String major)
	{
		this.major=major;
	}
	/*
	 * getters for the private fields
	 * 
	 * */
	public String getStudentNumber()
	{
		return studentNumber;
	}
	public String getDegree()
	{
		return degree;
	}
	public String getMajor()
	{
		return major;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
}
class Professor extends people
	{
		private String employeeNumber;
		private String degreeObtained;
		
		
		/*
		 * Constructors
		 * 
		 * */
		//Default Constructor
		Professor()
		{
			super();
		}
		//Special Constructor
		Professor(String employeeNumber, String degreeObtained)
		{
			super();
			this.employeeNumber=employeeNumber;
			this.degreeObtained=degreeObtained;
		}
		
		/*
		 * setters or access modifiers for the private fields
		 * 
		 * */
		public void setEmployeeNumber(String employeeNumber)
		{
			this.employeeNumber=employeeNumber;
		}
		public void setDegreeObtained(String degreeObtained)
		{
			this.degreeObtained=degreeObtained;
		}
		/*
		 * getters for the private fields
		 * 
		 * */
		public String getEmployeeNumber()
		{
			return employeeNumber;
		}
		public String getDegreeObtained()
		{
			return degreeObtained;
		}
	}

