package Models;

public class Staff {

	//admin admin Admin Admin 01/01/1999 123456789 admin@hr.com admin	
	
	private String username;
	private String password;
	private String givenName;
	private String familyName;
	private String dob;
	private String phone;
	private String email;
	private String staffType;

	public  Staff(String username, String password, String givenName, String familyName,String dob,String phone,String email,String staffType)
	{
		this.setUsername(username);
		this.setPassword(password);
		this.setGivenName(givenName);
		this.setFamilyName(familyName);
		this.setDob(dob);
		this.setPhone(phone);
		this.setEmail(email);
		this.setStaffType(staffType);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
}
