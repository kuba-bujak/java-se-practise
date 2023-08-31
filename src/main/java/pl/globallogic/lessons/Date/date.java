package pl.globallogic.lessons.Date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class date {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalDate.of(2015, 02, 20);
        LocalDate.parse("2015-02-20");
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
        boolean leapYear = LocalDate.now().isLeapYear();

        boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
        boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));

        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());

        System.out.println(localDate);
        System.out.println(LocalDate.of(2015, 02, 20));
        System.out.println(LocalDate.parse("2015-02-20"));
        System.out.println(tomorrow);
        System.out.println(previousMonthSameDay);
        System.out.println(sunday);
        System.out.println(twelve);
        System.out.println(leapYear);
        System.out.println(notBefore);
        System.out.println(isAfter);
        System.out.println(beginningOfDay);
        System.out.println(firstDayOfMonth);
    }
}
