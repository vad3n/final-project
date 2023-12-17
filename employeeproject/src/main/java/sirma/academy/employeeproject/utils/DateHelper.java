package sirma.academy.employeeproject.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class DateHelper {
    private static DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                                                //day-month-year format without leading zeros
                                                .appendOptional(DateTimeFormatter.ofPattern("d-M-yyyy"))
                                                .appendOptional(DateTimeFormatter.ofPattern("d/M/yyyy"))
                                                .appendOptional(DateTimeFormatter.ofPattern("d.M.yyyy"))
                                                //day-month-year format with leading zeros
                                                .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                                                .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                                .appendOptional(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                                                //month-day-year format without leading zeros
                                                .appendOptional(DateTimeFormatter.ofPattern("M-d-yyyy"))
                                                .appendOptional(DateTimeFormatter.ofPattern("M/d/yyyy"))
                                                .appendOptional(DateTimeFormatter.ofPattern("M.d.yyyy"))
                                                //month-day-year format with leading zeros
                                                .appendOptional(DateTimeFormatter.ofPattern("MM-dd-yyyy"))
                                                .appendOptional(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                                                .appendOptional(DateTimeFormatter.ofPattern("MM.dd.yyyy"))
                                                //year-month-day format without leading zeros
                                                .appendOptional(DateTimeFormatter.ofPattern("yyyy-M-d"))
                                                .appendOptional(DateTimeFormatter.ofPattern("yyyy/M/d"))
                                                .appendOptional(DateTimeFormatter.ofPattern("yyyy.M.d"))
                                                //year-month-day format with leading zeros
                                                .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                                                .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
                                                .appendOptional(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
                                                .toFormatter();

    public static LocalDate parseDate(String date) {
        return LocalDate.parse(date, formatter);
    }
}
