import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        if (birdsPerDay.length == 0) {
          throw new IllegalArgumentException("Array must have at least one element");
        }
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
      return birdsPerDay;
    }

    public int getToday() {
      return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
      int todayIdx = birdsPerDay.length - 1;
      birdsPerDay[todayIdx] = ++birdsPerDay[todayIdx];
    }

    public boolean hasDayWithoutBirds() {
      return Arrays.stream(this.birdsPerDay).anyMatch(count -> count == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
      return Arrays.stream(this.birdsPerDay).limit(numberOfDays).sum();
    }

    public int getBusyDays() {
      return (int) Arrays.stream(this.birdsPerDay).filter(count -> count >= 5).count();

    }
}
