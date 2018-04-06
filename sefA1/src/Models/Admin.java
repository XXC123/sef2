package Models;

public class Admin extends Staff {

	public Admin(String username, String password, String givenName,
			String familyName, String dob, String phone, String email,
			String staffType) {
		super(username, password, givenName, familyName, dob, phone, email, staffType);
	}
	
}
