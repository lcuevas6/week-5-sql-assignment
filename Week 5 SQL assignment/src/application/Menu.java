package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.SportDao;
import entity.Sport;

public class Menu {
	
	private SportDao sportDao = new SportDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Sports",
			"Display a Sport",
			"Create Sport",
			"Update Sport",
			"Delete Sport");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
		try {
			if (selection.equals("1")) {
				displaySports();
			} else if (selection.equals("2")) {
				displaySport();
			} else if (selection.equals("3")) {
				createSport();
			}  else if (selection.equals("4")) {
				updateSport();
			} else if (selection.equals("5")) {
				deleteSport();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
			System.out.println("Press enter to continue");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an option:\n---------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i+1+ ")" + options.get(i));
		}
	}
	
	private void displaySports() throws SQLException {
		List<Sport> sports = sportDao.getSports();
		for (Sport sport : sports) {
			System.out.println(sport.getId() + ": " + sport.getName());
		}
	}
	
	private void displaySport() throws SQLException {
		System.out.print("Enter sport id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Sport sport = sportDao.getSportById(id);
		System.out.println(sport.getId() + ": " + sport.getName());
	}

	private void createSport() throws SQLException {
		System.out.print("Enter new sport name:");
		String sportName = scanner.nextLine();
		sportDao.createNewSport(sportName);
}
	private void updateSport() throws SQLException {
		System.out.println("Enter sport id to update:");
		int id = Integer.parseInt(scanner.nextLine());
		String name = scanner.nextLine();
		sportDao.updateSportByID(id, name);
	}
	private void deleteSport() throws SQLException {
		System.out.println("Enter sport id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		sportDao.deleteSportByID(id);
		
	}
}