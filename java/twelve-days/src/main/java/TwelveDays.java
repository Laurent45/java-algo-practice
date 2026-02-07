import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {

    private static final List<String> NUMBERS_NAME = List.of(
            "first",
            "second",
            "third",
            "fourth",
            "fifth",
            "sixth",
            "seventh",
            "eighth",
            "ninth",
            "tenth",
            "eleventh",
            "twelfth"
    );

    private static final List<String> VERSES = List.of(
            "a Partridge in a Pear Tree",
            "two Turtle Doves",
            "three French Hens",
            "four Calling Birds",
            "five Gold Rings",
            "six Geese-a-Laying",
            "seven Swans-a-Swimming",
            "eight Maids-a-Milking",
            "nine Ladies Dancing",
            "ten Lords-a-Leaping",
            "eleven Pipers Piping",
            "twelve Drummers Drumming"
            );

    String verse(int verseNumber) {
        if (verseNumber < 1 || verseNumber > 12) {
            throw new IllegalArgumentException();
        }

        StringBuilder verse = new StringBuilder();

        verse.append("On the ");
        verse.append(NUMBERS_NAME.get(verseNumber - 1));
        verse.append(" day of Christmas my true love gave to me: ");

        String verses = IntStream.iterate(verseNumber - 1, (i) -> i > 0, (i) -> --i)
                .mapToObj(VERSES::get)
                .collect(Collectors.joining(", "));

        if (!verses.isEmpty()) {
            verse.append(verses);
            verse.append(", and ");
        }

        verse.append(VERSES.getFirst());
        verse.append(".\n");

        return verse.toString();
    }

    String verses(int startVerse, int endVerse) {
        if (startVerse > endVerse || startVerse < 1 || startVerse > 12 || endVerse > 12) {
            throw new IllegalArgumentException();
        }

        return IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(this::verse)
                .collect(Collectors.joining("\n"));
    }

    String sing() {
        return verses(1, 12);
    }
}
