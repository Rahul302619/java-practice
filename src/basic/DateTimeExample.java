package basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeExample {

    public static void main(String[] args) {
        LocalDate date = convertStringIntoDate("12/09/24", "dd/MM/yy");
        System.out.println(date);
        compareDate();
    }

    private static LocalDate convertStringIntoDate(String strDate, String pattern) {
        /*
        * here pattern is the input date(strDate) pattern and not the output date pattern
        * */
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(strDate, dateTimeFormatter);
    }

    private static void compareDate() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.now().minusDays(1);
        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate1.compareTo(localDate2));
        System.out.println(localDate1.isBefore(localDate2));
        System.out.println(localDate1.isAfter(localDate2));
    }
}
