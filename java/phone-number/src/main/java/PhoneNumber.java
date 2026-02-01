class PhoneNumber {

    private final String number;

    PhoneNumber(String numberString) {
        this.number = convertToPhoneNumber(numberString);
    }

    String getNumber() {
        return this.number;
    }

    private String convertToPhoneNumber(String rawPhoneNumber) {
        if (rawPhoneNumber.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("letters not permitted");
        }
        if (rawPhoneNumber.matches(".*[^0-9\\s\\.\\-\\(\\)\\+].*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }

        String phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");

        if (phoneNumber.length() < 10) {
            throw new IllegalArgumentException("must not be fewer than 10 digits");
        }
        if (phoneNumber.length() > 11) {
            throw new IllegalArgumentException("must not be greater than 11 digits");
        }

        if (phoneNumber.length() == 11) {
            if (phoneNumber.startsWith("1")) {
                phoneNumber = phoneNumber.substring(1);
            } else {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
        }

        if (phoneNumber.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }
        if (phoneNumber.charAt(0) == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
        }

        if (phoneNumber.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }
        if (phoneNumber.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }

        return phoneNumber;
    }

}