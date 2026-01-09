import java.text.MessageFormat;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BottleSong {

    private static final String GENERIC_LYRICS = """
            {0} hanging on the wall,
            {0} hanging on the wall,
            And if one green bottle should accidentally fall,
            There''ll be {1} hanging on the wall.
            """;

    String recite(int startBottles, int takeDown) {
        if ((startBottles <= 0 || startBottles > 10) || (takeDown <= 0 || takeDown > 10)) {
            throw new IllegalArgumentException("startBottles and takeDown should be between 1 and 10");
        }
        if (startBottles < takeDown) {
            throw new IllegalArgumentException("startBottles must be greater than takeDown");
        }

        int endBottles = startBottles - takeDown;

        return IntStream.iterate(startBottles, bottle -> bottle > endBottles, bottle -> --bottle)
                .mapToObj(bottle -> MessageFormat.format(GENERIC_LYRICS, numberOfBottles(bottle, true), numberOfBottles(bottle - 1, false)))
                .collect(Collectors.joining("\n"));
    }

    private String numberOfBottles(int bottles, boolean capitalize) {
        return switch (bottles) {
            case 1 -> capitalize ? "One green bottle" : "one green bottle";
            case 2 -> capitalize ? "Two green bottles" : "two green bottles";
            case 3 -> capitalize ? "Three green bottles" : "three green bottles";
            case 4 -> capitalize ? "Four green bottles" : "four green bottles";
            case 5 -> capitalize ? "Five green bottles" : "five green bottles";
            case 6 -> capitalize ? "Six green bottles" : "six green bottles";
            case 7 -> capitalize ? "Seven green bottles" : "seven green bottles";
            case 8 -> capitalize ? "Eight green bottles" : "eight green bottles";
            case 9 -> capitalize ? "Nine green bottles" : "nine green bottles";
            case 10 -> capitalize ? "Ten green bottles" : "ten green bottles";
            default -> capitalize ? "No green bottles" : "no green bottles";
        };
    }
}