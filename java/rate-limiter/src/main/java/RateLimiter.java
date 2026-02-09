import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter<K> {

    private final int limit;
    private final Duration windowSize;
    private final TimeSource timeSource;
    private final Map<K, Tracking> clientRequests = new HashMap<>();

    public RateLimiter(int limit, Duration windowSize, TimeSource timeSource) {
        this.limit = limit;
        this.windowSize = windowSize;
        this.timeSource = timeSource;
    }

    public boolean allow(K clientId) {
        Tracking tracking = clientRequests.computeIfAbsent(clientId, k -> new Tracking(timeSource.now()));

        Duration currentWindow = Duration.between(tracking.getWindowStart(), timeSource.now());
        if (currentWindow.compareTo(windowSize) >= 0) {
            tracking.resetTracking(timeSource.now());
            return true;
        }

        tracking.incrementRequestCount();
        return tracking.getRequestCount() <= limit;
    }

    private static class Tracking {
        private int requestCount;
        private Instant windowStart;

        public Tracking(Instant windowStart) {
            this.requestCount = 0;
            this.windowStart = windowStart;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public Instant getWindowStart() {
            return windowStart;
        }

        public void incrementRequestCount() {
            requestCount++;
        }

        public void resetTracking(Instant windowStart) {
            requestCount = 1;
            this.windowStart = windowStart;
        }
    }
}
