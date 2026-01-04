import java.util.List;
import java.util.Set;
import java.util.HashSet;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
      return Set.copyOf(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
      return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
      return !(myCollection.containsAll(theirCollection) || theirCollection.containsAll(myCollection));
    }

    static Set<String> commonCards(List<Set<String>> collections) {
      return collections.stream().reduce(new HashSet(collections.getFirst()), (acc, collection) -> {
        acc.retainAll(collection);
        return acc;
      });
    }

    static Set<String> allCards(List<Set<String>> collections) {
      return collections.stream().reduce(new HashSet<String>(), (acc, collection) -> {
        acc.addAll(collection);
        return acc;
      });
    }
}
