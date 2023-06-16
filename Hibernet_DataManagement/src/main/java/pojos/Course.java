package pojos;

public enum Course {

	DAC(100000),DBDA(115000),DITISS(135000);

	private int CourseFees;
	Course(int CourseFees) {
		this.CourseFees=CourseFees;
		
	}
}
