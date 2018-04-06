package Models;

import java.util.ArrayList;

public class Database {

	private ArrayList<Staff> staffDatabase= new ArrayList<Staff>();
	ReadTXT read=new ReadTXT();
	
	public Database()
	{
		newStaff(read.readTXT("Database/StaffInfo.txt"));
	}
	
	
	
	//add staff object from reading arraylist form txt
	public void newStaff(ArrayList<String> staff)
	{
		for(int i=0;i<staff.size();i=i+8)
		{
			getStaffDatabase().add(new Staff(staff.get(i),staff.get(i+1),staff.get(i+2), staff.get(i+3), staff.get(i+4),staff.get(i+5),staff.get(i+6),staff.get(i+7)));
		}
	}



	public ArrayList<Staff> getStaffDatabase() {
		return staffDatabase;
	}



	public void setStaffDatabase(ArrayList<Staff> staffDatabase) {
		this.staffDatabase = staffDatabase;
	}
	
	
}
