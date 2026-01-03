public class Lasagna {
    private static final int EXPECTED_MIN_IN_OVEN = 40;
    private static final int PREP_TIME_IN_MIN_PER_LAYER = 2;

    // TODO: define the 'expectedMinutesInOven()' method
    public int expectedMinutesInOven() {
      return EXPECTED_MIN_IN_OVEN;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    public int remainingMinutesInOven(int inOvenForMinutes) {
      return expectedMinutesInOven() - inOvenForMinutes;
    }

    // TODO: define the 'preparationTimeInMinutes()' method
    public int preparationTimeInMinutes(int layers) {
      return layers * PREP_TIME_IN_MIN_PER_LAYER;
    }

    // TODO: define the 'totalTimeInMinutes()' method
    public int totalTimeInMinutes(int layers, int inOvenForMinutes) {
      return preparationTimeInMinutes(layers) + inOvenForMinutes;
    }
}
