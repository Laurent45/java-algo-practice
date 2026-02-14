package com.boarhat;

import java.util.*;

public class Main {

    private static final Map<String, List<String>> graph = Map.of(
            "A", List.of("B", "C"),
            "B", List.of("A", "D"),
            "C", List.of("E", "F")
    );

    public static void main(String[] args) {
        System.out.println("Depth first search:");
        depthFirstSearch("A", new HashSet<>());

        System.out.println("\nBreadth first search:");
        breadthFirstSearch();

    }

    private static void breadthFirstSearch() {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add("A");
        visited.add("A");

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            System.out.print(cur + " > ");
 
            for (String node : graph.getOrDefault(cur, Collections.emptyList())) {
                if (visited.add(node)) {
                    queue.add(node);
                }
            }
        }
    }

    private static void depthFirstSearch(String node, Set<String> visited) {
        visited.add(node);
        System.out.print(node + " > ");
        for (String edge : graph.getOrDefault(node, Collections.emptyList())) {
            if (visited.add(edge)) {
                depthFirstSearch(edge, visited);
            }
        }
    }
}