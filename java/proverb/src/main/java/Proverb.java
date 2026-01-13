import java.util.List;
import java.util.StringJoiner;

class Proverb {

    private static final String COMMON_SENTENCE = "For want of a %s the %s was lost.";
    private static final String END_SENTENCE = "And all for the want of a %s.";


    private final List<String> words;

    Proverb(String[] words) {
        if (words == null) {
            throw new IllegalArgumentException();
        }
        this.words = List.of(words);
    }

    String recite() {
        if (words.isEmpty()) {
            return "";
        }

        StringJoiner joiner = new StringJoiner("\n");

        for (int i = 0; i < words.size() - 1; i++) {
            joiner.add(String.format(COMMON_SENTENCE, words.get(i), words.get(i + 1)));
        }
        joiner.add(String.format(END_SENTENCE, words.getFirst()));

        return joiner.toString();
    }

}
