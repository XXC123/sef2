package Controller;

import java.util.*;
import java.io.*;
import Models.*;

public class HRApplication {
	private static ArrayList<Job> jobs = new ArrayList<Job>();
	private static Scanner scanner = new Scanner(System.in);
	private static HashMap<String, Staff> staffMembers = importLoginInfo();

	// Imports all users' login information from loginInfo.txt
	public static HashMap<String, Staff> importLoginInfo() {
		HashMap<String, Staff> staffMembers = new HashMap<String, Staff>();
		File loginInfo = new File("Database/loginInfo.txt");

		if (loginInfo.exists()) {
			try {
				Scanner input = new Scanner(new FileReader(loginInfo));

				while (input.hasNextLine()) {
					StringTokenizer staffLoginInfo = new StringTokenizer(
							input.nextLine(), ",");
					//Gets user's info
					String staffType = staffLoginInfo.nextToken();
					String username = staffLoginInfo.nextToken();
					String password = staffLoginInfo.nextToken();

					// Creates user according to type
					if (staffType.equals("AD")) {
						staffMembers.put(username,
								new Admin(username, password));
					} else if (staffType.equals("AP")) {
						staffMembers.put(username,
								new Approval(username, password));
					} else if (staffType.equals("CC")) {
						staffMembers.put(username,
								new CourseCoordinator(username, password));
					} else if (staffType.equals("FS")) {
						staffMembers.put(username,
								new Staff(username, password));
					} else {
						staffMembers.put(username,
								new CasualStaff(username, password));
					}
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Cannot find file.");
		}

		return staffMembers;
	}

	public static Staff login() {
		Scanner scan = new Scanner(System.in);
		String inputUsername;
		String inputPassword;

		while (true) {
			// Gets user's input
			System.out.println("Log in");
			System.out.println("Username:");
			inputUsername = scan.next();
			System.out.println("Password:");
			inputPassword = scan.next();

			// Input validation
			if (staffMembers.containsKey(inputUsername)) {
				if (inputPassword.equals(
						staffMembers.get(inputUsername).getPassword())) {
					System.out.println("Welcome to the system.");
					return staffMembers.get(inputUsername);
				} else {
					System.out.println(
							"Incorrect password used for this account.");
				}
			} else {
				System.out.println("No account detected");
			}
		}
	}

	// Imports user's profile
	public static void importProfile(Staff user) {
		String username = user.getUsername();
		File profiles = new File("Database/profiles.txt");
		if (profiles.exists()) {
			try {
				Scanner input = new Scanner(new FileReader(profiles));

				while (input.hasNextLine()) {
					StringTokenizer staffProfile = new StringTokenizer(
							input.nextLine(), ",");
					String fileUsername = staffProfile.nextToken();

					// Finds the right username and imports their profile
					if (fileUsername.equals(username)) {
						String givenName = staffProfile.nextToken();
						String familyName = staffProfile.nextToken();
						String dob = staffProfile.nextToken();
						String phone = staffProfile.nextToken();
						String email = staffProfile.nextToken();

						user.setProfile(givenName, familyName, dob, phone,
								email);
						return;
					}
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	//Navigates to menu according to type of user
	public static void selectMenu(Staff user) {
		if (user instanceof Admin)
			adminUI(user);
		else if (user instanceof CourseCoordinator)
			coordinatorUI(user);
		else if (user instanceof CasualStaff || user instanceof Staff)
			casualUI(user);
		else if (user instanceof Approval)
			approvalUI(user);
	}

	public static void logout() {
		System.exit(0);
	}

	private static void adminUI(Staff user) {
		showStaffMenu();
		showAdminMenu();

		System.out.print("Please enter your selection: ");
		int selection = scanner.nextInt();
		switch (selection) {
		case 1:
			message();
			break;
		case 2:
			viewAnnouncements();
			break;
		case 3:
			checkPayrate();
			break;
		case 4:
			seeRoster();
			break;
		case 5:
			viewProfile(user);
			break;
		case 6:
			gatherPayroll();
			break;
		case 7:
			viewStaff();
			break;
		case 8:
			viewCourseStaffRequest();
			break;
		case 9:
			setRoster();
			break;
		case 10:
			allocateStaff();
			break;
		case 11:
			logout();
			break;
		}
	}

	private static void coordinatorUI(Staff user) {
		showStaffMenu();
		showCoordinatorMenu();

		System.out.print("Please enter your selection: ");
		int selection = scanner.nextInt();
		switch (selection) {
		case 1:
			message();
			break;
		case 2:
			viewAnnouncements();
			break;
		case 3:
			checkPayrate();
			break;
		case 4:
			seeRoster();
			break;
		case 5:
			viewProfile(user);
			break;
		case 6:
			seeCourseBudget();
			break;
		case 7:
			approveStaffPay();
			break;
		case 8:
			createCourseEvent();
			break;
		case 9:
			StaffForEvent();
			break;
		case 10:
			Announcement();
			break;
		case 11:
			logout();
			break;
		}
	}

	private static void casualUI(Staff user) {
		showStaffMenu();
		showCasualStaffMenu();

		System.out.print("Please enter your selection: ");
		int selection = scanner.nextInt();
		switch (selection) {
		case 1:
			message();
			break;
		case 2:
			viewAnnouncements();
			break;
		case 3:
			checkPayrate();
			break;
		case 4:
			seeRoster();
			break;
		case 5:
			viewProfile(user);
			break;
		case 6:
			user.getProfile().updateResume();
			break;
		case 7:
			applyPosition();
			break;
		case 8:
			logout();
			break;
		}

	}

	private static void approvalUI(Staff user) {
		showStaffMenu();
		showApprovalMenu();

		System.out.print("Please enter your selection: ");
		int selection = scanner.nextInt();
		switch (selection) {
		case 1:
			message();
			break;
		case 2:
			viewAnnouncements();
			break;
		case 3:
			checkPayrate();
			break;
		case 4:
			seeRoster();
			break;
		case 5:
			viewProfile(user);
			break;
		case 6:
			gatherPayroll();
			break;
		case 7:
			approveStaffPay();
			break;
		case 8:
			logout();
			break;
		}

	}

	private static void showStaffMenu() {
		System.out.println();
		System.out.println("-----------Menu-----------");
		System.out.println("1.Message other staff");
		System.out.println("2.Check announcements/ notifications");
		System.out.println("3.Check pay rates");
		System.out.println("4.See weekly roster");
		System.out.println("5.Update profile");
	}

	private static void showAdminMenu() {
		System.out.println("6.Gather report data");
		System.out.println("7.View all staff");
		System.out.println("8.View course staff jobs");
		System.out.println("9.Set rosters");
		System.out.println("10.Allocate staff");
		System.out.println("11.Log out");
	}

	private static void showCoordinatorMenu() {
		System.out.println("6.See course budget");
		System.out.println("7.Set payrate for event");
		System.out.println("8.Create a new job");
		System.out.println("9.Request staff for events");
		System.out.println("10.Make course anouncement");
		System.out.println("11.Log out");
	}

	private static void showCasualStaffMenu() {
		System.out.println("6.Update resume");
		System.out.println("7.Apply for positions");
		System.out.println("8.Log out");
	}

	private static void showApprovalMenu() {
		System.out.println("6.Gather weekly payroll data");
		System.out.println("7.Approve staff weekly pay");
		System.out.println("8.Log out");
	}

	public static void message() {
		// to-do
	}

	public static void viewAnnouncements() {
		// to-do
	}

	public static void checkPayrate() {
		// to-do
	}

	public static void seeRoster() {
		// to-do
	}

	public static void applyPosition() {
		// to-do
	}

	public static void viewStaff() {
		// to-do
	}

	public static void viewCourseStaffRequest() {
		// to-do
	}

	public static void setRoster() {
		// to-do
	}

	public static void allocateStaff() {
		// to-do
	}

	public static void gatherPayroll() {
		// to-do
		Report report = new Report();
		report.generateReport();
	}

	public static void approveStaffPay() {
		// to-do
	}

	public static void seeCourseBudget() {
		// to-do
	}

	public static void createCourseBudget() {
		// to-do
	}

	public static void createCourseEvent() {
		Scanner stdin = new Scanner(System.in);
		String name, start, end, time;
		int numOfStaff;
		double payRate;

		// Gets user's input
		System.out.println("Create a new job");
		System.out.print("Name of the job: ");
		name = stdin.next();
		System.out.print("Start date: ");
		start = stdin.next();
		System.out.print("End date: ");
		end = stdin.next();
		System.out.print("Time: ");
		time = stdin.next();
		System.out.print("Number of staff: ");
		numOfStaff = stdin.nextInt();

		// TO DO: show a list of payrates
		System.out.print("Payrate: ");
		payRate = stdin.nextDouble();

		// Creates new job
		Job j = new Job(name, start, end, time, numOfStaff, payRate);
		jobs.add(j);

		System.out.println("Request created successfully.");
	}

	public static void StaffForEvent() {
		// to-do
	}

	public static void Announcement() {
		// to-do
	}

	public static void viewProfile(Staff user) {

		user.getProfile().viewProfile();

		System.out.println("-------Modify your profile:-------");
		System.out.println("1.Modify whole profile");
		System.out.println("2.Modify one featrue");

		int selection = scanner.nextInt();
		switch (selection) {
		case 1:
			user.getProfile().modifyProfile();
			break;
		case 2:

			System.out.println("1.Modify given name");
			System.out.println("2.Modify faminly name");
			System.out.println("3.Modify dob");
			System.out.println("4.Modify phone");
			System.out.println("5.Modify email");

			selection = scanner.nextInt();
			switch (selection) {
			case 1:
				System.out.println("Input new given name");
				user.getProfile().setGivenName(scanner.next());
				break;
			case 2:
				System.out.println("Input new family name");
				user.getProfile().setFamilyName(scanner.next());
				break;
			case 3:
				System.out.println("Input new dob");
				user.getProfile().setDob(scanner.next());
				break;
			case 4:
				System.out.println("Input new phone");
				user.getProfile().setPhone(scanner.next());
				break;
			case 5:
				System.out.println("Input new email");
				user.getProfile().setEmail(scanner.next());
				break;
			}
			break;
		}
		// TO DO: prints changes to the file
		user.getProfile().viewProfile();
	}

}
