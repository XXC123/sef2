package Models;

public class Job {
	private String name, start, end, time;
	private int numOfStaff;
	private double payRate;

	public Job(String name, String start, String end, String time,
			int numOfStaff, double payRate) {
		this.name = name;
		this.start = start;
		this.end = end;
		this.time = time;
		this.numOfStaff = numOfStaff;

		this.payRate = payRate;
	}

	public String getName() {
		return name;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public String getTime() {
		return time;
	}

	public int getNumOfStaff() {
		return numOfStaff;
	}

	public double getPayRate() {
		return payRate;
	}
}
