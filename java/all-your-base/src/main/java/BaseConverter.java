import java.util.ArrayDeque;
import java.util.Deque;

class BaseConverter {

    private final int numberBase10;

    BaseConverter(int originalBase, int[] originalDigits) {
        numberBase10 = convertToBase10(originalBase, originalDigits);
    }

    int[] convertToBase(int newBase) {
        if (newBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        if (numberBase10 == 0) {
            return new int[]{0};
        }

        Deque<Integer> digits = new ArrayDeque<>();
        int numberToConvert = numberBase10;
        while (numberToConvert > 0) {
            digits.push(numberToConvert % newBase);
            numberToConvert /= newBase;
        }

        return digits.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int convertToBase10(int base, int[] digits) {
        if (base < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        if (digits == null) {
            return 0;
        }

        int result = 0;
        for (int digit : digits) {
            if (digit < 0) {
                throw new IllegalArgumentException("Digits may not be negative.");
            }
            if (digit >= base) {
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
            }
            result = result * base + digit;
        }
        return result;
    }

}