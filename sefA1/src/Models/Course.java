package Models;

public class Course {

	
	
	private String name;
	private String courseCode;
	private Object start;
	private String end;
	private int numOfStaff;
	private double budget;

	public void Course(String name, String courseCode, String strat, String end, int numOfStaff, double budget)
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



