package siody.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateSio {
    public static void main(String[] args) {
        LocalDate todayWithoutLocation = LocalDate.now();
        System.out.println(todayWithoutLocation.format(DateTimeFormatter.ofPattern("yy-MM-dd")));
        LocalDateTime nowWithoutLocation = LocalDateTime.now();
        System.out.println(nowWithoutLocation.format(DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss")));
        LocalTime clockWithoutLocation = LocalTime.now();
        System.out.println(clockWithoutLocation.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        ZonedDateTime nowWithLocation = ZonedDateTime.now();
        System.out.println(nowWithLocation.format(DateTimeFormatter.ofPattern("G e VV z")));

        Date now = new Date();
        Instant nowOf8 = now.toInstant();
        System.out.println(now);
        System.out.println(nowOf8);
        Instant instant = Instant.now();
        if (now.getTime()/1000 == nowOf8.getEpochSecond()) {
            System.out.println("OK");
        }
    }
}
