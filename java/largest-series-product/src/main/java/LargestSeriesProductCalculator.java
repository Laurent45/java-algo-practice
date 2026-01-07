class LargestSeriesProductCalculator {

    private String digits;

    LargestSeriesProductCalculator(String inputNumber) {
      if (!inputNumber.matches("\\d*")) {
        throw new IllegalArgumentException("String to search may only contain digits.");
      }
      this.digits = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
      if (numberOfDigits < 0) {
        throw new IllegalArgumentException("Series length must be non-negative.");
      }
      if (numberOfDigits > this.digits.length()) {
        throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
      }

      long largestProduct = 0;

      for (int i = 0, j = numberOfDigits; j <= this.digits.length(); i++, j = i + numberOfDigits) {
        long current = 1;
        for (char c : this.digits.substring(i, j).toCharArray()) {
          current *= c - '0';
        }
        largestProduct = Math.max(largestProduct, current);
      }

      return largestProduct;
    }
}
