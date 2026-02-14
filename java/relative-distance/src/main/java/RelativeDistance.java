import java.util.*;

class RelativeDistance {

    private final Map<String, Set<String>> graphFamily;

    RelativeDistance(Map<String, List<String>> familyTree) {
        this.graphFamily = convertToGraph(familyTree);
    }

    private record Node(String label, int level) {}

    int degreeOfSeparation(String personA, String personB) {
        if (personA.equals(personB)) {
            return 0;
        }

        Set<String> visited =  new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();

        visited.add(personA);
        queue.add(new Node(personA, 0));

        while (!queue.isEmpty()) {
            Node from = queue.poll();
            String label = from.label;
            int level = from.level;

            Set<String> relations = graphFamily.getOrDefault(label, Collections.emptySet());

            for (String relation : relations) {
                if (visited.add(relation)) {
                    if (relation.equals(personB)) {
                        return level + 1;
                    }
                    queue.add(new Node(relation, level + 1));
                }
            }
        }

        return -1;
    }

    private static Map<String, Set<String>> convertToGraph(Map<String, List<String>> familyTree) {
        if (familyTree == null) {
            throw new IllegalArgumentException("familyTree must not be null");
        }

        Map<String, Set<String>> graph = new HashMap<>();

        for (Map.Entry<String, List<String>> parentChildren : familyTree.entrySet()) {
            String parent = parentChildren.getKey();
            List<String> children = parentChildren.getValue();

            List<String> family = new ArrayList<>(1 + children.size());
            family.add(parent);
            family.addAll(children);

            for (String memberA: family) {
                for (String memberB: family) {
                    if (!memberA.equals(memberB)) {
                        graph.computeIfAbsent(memberA, k -> new HashSet<>()).add(memberB);
                    }
                }
            }
        }
        return graph;
    }
}
