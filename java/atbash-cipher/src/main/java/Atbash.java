import java.util.stream.Collectors;

class Atbash {

    String encode(String input) {
        StringBuilder encode = new StringBuilder();
        int count = 0;

        for (char c : input.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                continue;
            }

            encode.append(transform(c));
            if (++count % 5 == 0) {
                encode.append(' ');
            }
        }
        return encode.toString().trim();
    }

    String decode(String input) {
        return input.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(c -> transform((char) c))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static char transform(char c) {
        if (Character.isDigit(c)) {
            return c;
        }
        return (char) ('z' - (Character.toLowerCase(c) - 'a'));
    }

}
