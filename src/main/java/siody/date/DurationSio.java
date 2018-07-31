package siody.date;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DurationSio {
    public static void main(String[] args) {
        Duration oneDay = Duration.ofDays(1);
        oneDay = Duration.of(1, ChronoUnit.DAYS);

    }
}
