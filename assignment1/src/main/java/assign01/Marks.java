package assign01;

public class Marks {
	
	private double marks ; 
	private String subject ; 
	
	public Marks (double d , String  subject) {
		this.marks = d ; 
		this.subject = subject; 
	}
	
	public void setSubject (String subject) {
		this.subject = subject ; 
	}
	public String getSubject () {
		return this.subject ; 
	}
	public void setMarks (int marks) {
		this.marks = marks ; 
	}
	public double getMarks () {
		return this.marks ;
	}

}
