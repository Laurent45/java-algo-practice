import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        return phrase.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .allMatch(new HashSet<>()::add);

    }
}
