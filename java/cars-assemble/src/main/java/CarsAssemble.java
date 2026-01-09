public class CarsAssemble {

    public static final int CARS_PRODUCED_BY_HOURS = 221;
    public static final double CARS_PRODUCED_BY_MINUTES = CARS_PRODUCED_BY_HOURS / 60.0;

    public double productionRatePerHour(int speed) {
        return CARS_PRODUCED_BY_HOURS * speed * getSuccessRate(speed);
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (CARS_PRODUCED_BY_MINUTES * speed * getSuccessRate(speed));
    }

    private double getSuccessRate(int speed) {
        if (speed >= 0 && speed <= 4) return 1.0;
        if (speed >= 5 && speed <= 8) return 0.9;
        if (speed == 9) return 0.8;
        return 0.77;
    }
}
