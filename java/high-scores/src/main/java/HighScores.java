import java.util.List;
import java.util.Comparator;

class HighScores {

    private List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
      this.highScores = highScores;
    }

    List<Integer> scores() {
      return this.highScores;
    }

    Integer latest() {
      return this.highScores.getLast();
    }

    Integer personalBest() {
        return this.highScores.stream()
          .mapToInt(i -> i)
          .max()
          .getAsInt();
    }

    List<Integer> personalTopThree() {
      return this.highScores.stream()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .toList();
    }

}
