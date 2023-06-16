package pojos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
public class Student {
	
	public Student(String email, String password) {
		
		Email = email;
		this.password = password;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int StudentId;
	
	@Column(name="firstName",nullable=false,length=20)
	private String FirstName;
	
	@Column(name="LastName",nullable=false,length=20)
	private String LastName;
	
	@Column(name="Email",nullable=false,unique=true,length=20)
	private String Email;
	
	@Column(name="password",nullable=false,length=8)
	private String password;
	
	@Enumerated(EnumType.STRING)
    private Course course;
	
	@Column(name="Date",nullable=false)
    private LocalDate dob;
    
    public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String firstName, String lastName, String email, String password, Course course, LocalDate dob) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		this.password = password;
		this.course = course;
		this.dob = dob;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
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
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
    
	
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email="
				+ Email + ", password=" + password + ", course=" + course + ", dob=" + dob + "]";
	}
    

}
