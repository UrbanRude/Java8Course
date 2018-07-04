/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import javax.script.ScriptEngineManager;

import java.util.Date;
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
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Java8{
 
    public static void main(String[] args) {   	
        
    	Java8 java8 = new Java8();
    	java8.testLocalDateTime();
    	System.out.println("####### Zoned Date-Time API #########");
    	java8.testZonaDateTime();
    	System.out.println("####### Chrono Units Enum   #########");
    	java8.testChromoUnits();
    	System.out.println("#######    Duration         #########");
    	java8.testDuration();
    	System.out.println("#######         Period      #########");
    	java8.testPeriod();
    	System.out.println("######   Temporal Adjusters #########");
    	java8.testAdjusters();
    	System.out.println("###### Backward Compatibility #######");
    	java8.testBackwardCompatibility();
    }
    
    public void testLocalDateTime(){
    	LocalDateTime currentTime = LocalDateTime.now();
    	System.out.println("Current DataTime >> "+currentTime);
    	
    	LocalDate date1 = LocalDate.now();
    	System.out.println("Date >> "+date1);
    	   	
    	Month month = currentTime.getMonth();
    	int day = currentTime.getDayOfMonth();
    	int seconds = currentTime.getSecond();
    	int year =currentTime.getYear();
    	
    	System.out.println("Year >> "+year+" Month >> "+month+" Day >> "+day+" Seconds >> "+seconds);
    	
    	LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2010);
    	System.out.println("Date 2 >> "+date2);
    	
    	LocalDate date3 = LocalDate.of(2014,Month.DECEMBER,17);
    	System.out.println("Date 4 >> "+date3);
    	
    	LocalTime date5 = LocalTime.parse("20:15:12");
    	System.out.println("Date 5 >> "+date5);
    }
    
    public void testZonaDateTime() {
    	ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
    	System.out.println("Date 1 >> "+date1);
    	
    	ZoneId id = ZoneId.of("Europe/Paris");
    	System.out.println("ZoneId >> "+id);
    	
    	ZoneId currentZoneId = ZoneId.systemDefault();
    	System.out.println("CurrentZone >> "+currentZoneId);
    }
        
    public void testChromoUnits() {
    	LocalDate today = LocalDate.now();
    	System.out.println("Current date >> "+ today);
    	
    	LocalDate nextDay = today.plus(1,ChronoUnit.DAYS);
    	System.out.println("Next day >> "+nextDay);
    	
    	LocalDate nextWeek = today.plus(1,ChronoUnit.WEEKS);
    	System.out.println("Next week >> "+ nextWeek);
    	
    	LocalDate nextYear = today.plus(1,ChronoUnit.YEARS);
    	System.out.println("Next year >> "+ nextYear);
    	
    	LocalDate nextMonth = today.plus(1,ChronoUnit.MONTHS);
    	System.out.println("Next Month >> "+ nextMonth);
    	
    	//add 10 years to the current date
    	LocalDate nextDecade = today.plus(1,ChronoUnit.DECADES);
    	System.out.println("Date after ten year >> "+ nextDecade);
    }
    
    public void testPeriod() {
    	LocalDate today = LocalDate.now();
    	System.out.println("Current date >> "+today);
    	
    	LocalDate nextMonth = today.plus(1,ChronoUnit.MONTHS);
    	System.out.println("Next Month >> "+nextMonth);
    	
    	Period period = Period.between(nextMonth,today);
    	System.out.println("Period >> "+period);
    }
    
    public void testDuration() {
    	LocalTime time = LocalTime.now();
    	Duration twoHours = Duration.ofHours(2);
    	
    	LocalTime time2 = time.plus(twoHours);
    	Duration duration = Duration.between(time,time2);
    	
    	System.out.println("Duration >> "+duration);
    }
    
    public void testAdjusters() {
    	LocalDate today = LocalDate.now();
    	System.out.println("Current date >> "+today);
    	
    	LocalDate nextTuesday = today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
    	System.out.println("Next Tuesday on >> "+nextTuesday);
    	
    	LocalDate firstInYear = LocalDate.of(today.getYear(), today.getMonth(), 1);
    	LocalDate secondSaturday = firstInYear.with(TemporalAdjusters
                                              		  .nextOrSame(DayOfWeek.SATURDAY))
    										  .with(TemporalAdjusters
    												  .next(DayOfWeek.SATURDAY));
    	System.out.println("Second Saturdar on >> "+secondSaturday);
    }
    
    public void testBackwardCompatibility() {
    	Date currentDate = new Date();
    	System.out.println("Current date >> "+currentDate);
    	
    	Instant now = currentDate.toInstant();
    	ZoneId currentZoneId = ZoneId.systemDefault();
    	
    	LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZoneId);
    	System.out.println("Local date >> "+localDateTime);
    	    	
    	ZonedDateTime zonedDateTime	= ZonedDateTime.ofInstant(now, currentZoneId);
    	System.out.println("Zone date >> "+ zonedDateTime);	
    }
    
}


