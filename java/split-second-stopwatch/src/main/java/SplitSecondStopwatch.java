import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class SplitSecondStopwatch {
    private static final long START_TIME = 0L;
    private static final String TIME_FORMAT = "%02d:%02d:%02d";
    private static final Pattern TIME_PATTERN = Pattern.compile("\\d{2}:\\d{2}:\\d{2}");

    private State state = State.READY;
    private long currentLap = START_TIME;
    private long cumulativeLap = START_TIME;
    private final List<Long> laps = new ArrayList<>();

    public void start() {
        if (this.state == State.RUNNING) {
            throw new IllegalStateException("cannot start an already running stopwatch");
        }
        this.state = State.RUNNING;
    }

    public void stop() {
        if (this.state != State.RUNNING) {
            throw new IllegalStateException("cannot stop a stopwatch that is not running");
        }
        this.state = State.STOPPED;
    }

    public void reset() {
        if (this.state != State.STOPPED) {
            throw new IllegalStateException("cannot reset a stopwatch that is not stopped");
        }
        this.state = State.READY;
        this.currentLap = START_TIME;
        this.cumulativeLap = START_TIME;
        this.laps.clear();
    }

    public void lap() {
        if (this.state != State.RUNNING) {
            throw new IllegalStateException("cannot lap a stopwatch that is not running");
        }
        this.laps.add(this.currentLap);
        this.cumulativeLap += this.currentLap;
        this.currentLap = START_TIME;
    }

    public String state() {
        return this.state.name;
    }

    public String currentLap() {
        return toTimeString(this.currentLap);
    }

    public String total() {
        return toTimeString(this.currentLap + this.cumulativeLap);
    }

    public java.util.List<String> previousLaps() {
        return this.laps.stream()
                .map(SplitSecondStopwatch::toTimeString)
                .toList();
    }

    public void advanceTime(String timeString) {
        if (!TIME_PATTERN.matcher(timeString).matches()) {
            throw new IllegalArgumentException("Invalid time string: " + timeString);
        }

        if (this.state == State.STOPPED) {
            return;
        }
        this.currentLap += toSeconds(timeString);
    }

    private static Long toSeconds(String timeString) {
        String[] time = timeString.split(":");

        long hours = Long.parseLong(time[0]);
        long minutes = Long.parseLong(time[1]);
        long seconds = Long.parseLong(time[2]);

        return TimeUnit.HOURS.toSeconds(hours) + TimeUnit.MINUTES.toSeconds(minutes) + seconds;
    }

    private static String toTimeString(Long seconds) {
        Duration duration = Duration.ofSeconds(seconds);
        return TIME_FORMAT.formatted(
                duration.toHours(),
                duration.toMinutesPart(),
                duration.toSecondsPart()
        );
    }

    private enum State {
        RUNNING("running"),
        STOPPED("stopped"),
        READY("ready");

        private final String name;
        State(String name) {
            this.name = name;
        }
    }
}