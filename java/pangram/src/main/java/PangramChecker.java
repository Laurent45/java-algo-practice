import java.util.Set;
import java.util.HashSet;

public class PangramChecker {

    public boolean isPangram(String input) {
      Set<Character> alphabet = new HashSet<>();

      for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (Character.isLetter(c)) {
          alphabet.add(Character.toLowerCase(c));
        }
      }

      return alphabet.size() == 26; 
    }

}
