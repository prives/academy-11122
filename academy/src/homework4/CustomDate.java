package homework4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CustomDate {
	Scanner scan = new Scanner(System.in);
	private String date;

	public CustomDate() {
		super();
	}

	public CustomDate(String date) {
		this.date = date;
		Year year = new Year();
		Month month = new Month();
		Day day = new Day();
	}

	class Year {
		public void bissextile() {

			Scanner input = new Scanner(System.in);
			System.out.println("Enter year:");
			int year = input.nextInt();
			if (year % 4 == 0) {
				if (year % 100 == 0) {
					if (year % 400 == 0) {
						System.out.println("Year bissextile.");
					}
				}
			} else {
				System.out.println("Year not bissextile.");
			}
			input.close();
		}
	}

	class Month {

	}

	class Day {

	}

	public String getDate() {
		return date;
	}

	public boolean verification(String date) {
		Pattern pattern = Pattern.compile("\\d{2}\\-\\d{2}\\-\\d{4}");
		Matcher matcher = pattern.matcher(date);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public void setDate() {
		while (true) {
			System.out.println("Enter date in format 'Day-Month-Year': ");
			String answ = scan.nextLine();
			if (verification(answ) == true) {
				this.date = answ;
				break;
			} else {
				System.out.println("Wrong date format,try again.");
			}

		}

	}

	public DayOfWeek getDayOfWeek() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate startDate = LocalDate.parse(date, formatter);
		DayOfWeek dayWeek = startDate.getDayOfWeek();
		return dayWeek;
	}

	public static void main(String[] args) {
		CustomDate date = new CustomDate();
		CustomDate date1 = new CustomDate();
		CustomDate.Year year=new CustomDate().new Year();
		date.setDate();
		date1.setDate();
		year.bissextile();
		System.out.println("Day of week(first date): " + date.getDayOfWeek() + ".");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate startDate = LocalDate.parse(date.getDate(), formatter);
		LocalDate endDate = LocalDate.parse(date1.getDate(), formatter);
		int days = (int) ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println("Number of days in a given time period: " + days + ".");
	}

}