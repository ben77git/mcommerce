package testjava8.dateTimeApi;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Java8Tester {
	
	public static void main(String[] args) {

		Java8Tester tester = new Java8Tester();
		tester.testLocalDateTime();
		System.out.println("**********************************************************");
		tester.testZonedDateTime();
		System.out.println("**********************************************************");
		tester.testchronoUnits();
		System.out.println("**********************************************************");
		tester.testPeriod();
		tester.testDuration();
		System.out.println("**********************************************************");
		tester.testAdjust();
		System.out.println("**********************************************************");
		tester.testBackward();
		
	}

	private void testBackward() {
		// get current date
		Date currentDate = new Date();
		System.out.println("current date : " + currentDate);
		
		// get the instant of the current date in terms of milliseconds
		Instant now = currentDate.toInstant();
		ZoneId currentZone = ZoneId.systemDefault();
		
		LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
		System.out.println("local date : " + localDateTime);
		
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
		System.out.println("zoned date : " + zonedDateTime);
		
	}

	private void testAdjust() {
		// Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("date1 : " + date1);
		LocalDate  nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("The next tuesday on : " + nextTuesday);
		
		// get the second saturday of  next month
		// first of the month
		LocalDate firstOfMonth = LocalDate.of(date1.getYear(), date1.getMonth(), 1);
		LocalDate secondSaturday = firstOfMonth.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday on : " + secondSaturday);
		
	}

	private void testDuration() {
		// Get the current date
		LocalTime time1 = LocalTime.now();
		System.out.println("time1 : " + time1);
		
		Duration twoh = Duration.ofHours(2);
		
		// add 2h to the current time
		LocalTime time2 = time1.plus(twoh);
		
		Duration duration = Duration.between(time1, time2);
		
		System.out.println("Duration : " + duration);
		
	}

	private void testPeriod() {
		// Get the current date
		LocalDate date1 = LocalDate.now();
		System.out.println("date1 : " + date1);
		
		// add 1 month  to the current date
		LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
		
		Period period = Period.between(date2, date1);
		System.out.println("Period : " + period);
		
	}

	private void testchronoUnits() {
		// get current date
		LocalDate today = LocalDate.now();
		System.out.println("current date : " + today);
		
		// add 1 week  to the current date
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next week : " + nextWeek);
		
		// add 1 month to the current date
		System.out.println("Next month : " + today.plus(1, ChronoUnit.MONTHS));
		
		// add 1 year to the current date
		System.out.println("Next year : " + today.plus(1, ChronoUnit.YEARS));
		
		// add 10 years to the current date
		System.out.println("Next 10 years : " + today.plus(10, ChronoUnit.YEARS));
		
		
	}

	private void testZonedDateTime() {
		// get curent date and time
		ZonedDateTime date1 = ZonedDateTime.parse("2017-12-03T10:15:30+05:30[Asia/Karachi]");
		System.out.println("date1 : " + date1);
		
		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("ZoneId : "+ id);
		
		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("currentZone : " + currentZone);
	}

	private void testLocalDateTime() {
		// Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("current dateTime : " + currentTime);
		
		System.out.println("dateTime courant : " + currentTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm:ss.SSS")));
		
		
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("current date1 : " + date1);
		
		int year = currentTime.getYear();
		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int sec = currentTime.getSecond();
		
		System.out.println("nous sommes à " + sec + " secondes du " + day + "/" + month + "/" + year + ".");
		System.out.println("nous sommes à " + sec + " secondes du " + day + "/" + month.getValue() + "/" + year + ".");
		
		LocalDateTime date2 = currentTime.withDayOfMonth(29).withYear(2020);
		
		System.out.println("date2 : " + date2);
		
		// 13 december 2014
		LocalDateTime date3 = currentTime.withDayOfMonth(13).withMonth(12).withYear(2014);
		System.out.println("date 3 : " + date3);
		
		// 22h15
		LocalTime time1 = currentTime.withHour(22).withMinute(15).toLocalTime();
		System.out.println("Time1 : " + time1);
		
		// parse a string
		LocalTime time5 = LocalTime.parse("20:15:30");
		System.out.println("time5 : " + time5);
		
		LocalDateTime date6 = currentTime.with(time5);
		System.out.println("date6 : " + date6);
		
		System.out.println("current dateTime : " + currentTime);
		
		System.out.println("now : " + LocalDateTime.now());
		
		
	}

}
