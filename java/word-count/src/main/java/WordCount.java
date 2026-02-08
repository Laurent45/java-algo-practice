import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordCount {

    private static final Pattern WORD_WITH_INTERNAL_APOSTROPHE = Pattern.compile("\\w+(?:'\\w+)*");

    public Map<String, Integer> phrase(String input) {
        if (input == null) {
            return Map.of();
        }

        HashMap<String, Integer> phraseCount = new HashMap<>();
        Matcher matcher = WORD_WITH_INTERNAL_APOSTROPHE.matcher(input);
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            phraseCount.put(word, phraseCount.getOrDefault(word, 0) + 1);
        }

        return phraseCount;
    }
}
