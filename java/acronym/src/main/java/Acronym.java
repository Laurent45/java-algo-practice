import java.util.stream.Collectors;
import java.util.Arrays;

class Acronym {

  private final String acronym;

  Acronym(String phrase) {
    if (phrase == null) {
      throw new IllegalArgumentException("");
    }
    this.acronym = convertToAcronym(phrase);
  }

  String get() {
    return this.acronym;
  }

  private String convertToAcronym(String phrase) {
    StringBuilder sb = new StringBuilder();
    boolean startWord = true;

    for (char c : phrase.toCharArray()) {
      if (startWord && Character.isLetter(c)) {
        sb.append(Character.toUpperCase(c));
        startWord = false;
      }
      if (!startWord && (c == ' ' || c == '-')) {
        startWord = true;
      }
    }
    return sb.toString();
  }

}
