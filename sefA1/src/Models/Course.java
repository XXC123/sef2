package Models;

public class Course {

	
	
	private String name;
	private String courseCode;
	private Object start;
	private String end;
	private int numOfStaff;
	private double budget;

	public Course(String name, String courseCode, String start, String end, int numOfStaff, double budget)
	{
		this.name=name;
		this.courseCode=courseCode;
		this.start=start;
		this.end=end;
		this.numOfStaff=numOfStaff;
		this.budget=budget;
	}
	
	public void viewCourseBudget()
	{
	//to-do	
	}
}



