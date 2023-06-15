package Pojo;

import java.time.LocalDate;

import javax.persistence.*;


@Entity //to tell that hibernate that this is standalone class
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	@Column(name="Email",unique=true)
	private String Email;
	
	@Column(name="PassWord",nullable=false)
	private String Password;
	
	@Column(name="joiningDate")
	private LocalDate joiningDate;
	
	@Enumerated(EnumType.STRING)
	private EmpType type;
	
	@Column(name="Salary")
	private double Salary;
	
	
	public Employee(String firstName, String lastName, String email, String password, LocalDate joiningDate,EmpType type,
			double salary) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Password = password;
		this.joiningDate = joiningDate;
		this.type=type;
		Salary = salary;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String firstName) {
		FirstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public LocalDate getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}


	public EmpType getType() {
		return type;
	}


	public void setType(EmpType type) {
		this.type = type;
	}


	public double getSalary() {
		return Salary;
	}


	public void setSalary(double salary) {
		Salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
				+ ", Password=" + Password + ", joiningDate=" + joiningDate + ", type=" + type + ", Salary=" + Salary
				+ "]";
	}


	

}
