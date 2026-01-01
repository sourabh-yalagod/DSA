package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    private static void addVertices(int vertices) {
        graph.put(vertices, new ArrayList<>());
    }

    private static void addEdges(int vertices, int value) {
        graph.get(vertices).add(value);
        graph.get(value).add(vertices);
    }

    private static void removeEdges(int vertices, int value) {
        graph.get(vertices).remove((Integer) value);
        graph.get(value).remove((Integer) vertices);
    }

    private static void removeVertex(int value) {
        graph.remove(value);
        for (List<Integer> list : graph.values()) {
            list.remove((Integer) value);
        }
    }

    public static void main(String[] args) {
        addVertices(1);
        addVertices(2);
        addVertices(3);
        addEdges(2, 3);
        addEdges(1, 3);
        addEdges(1, 2);
        System.out.println(graph);
        removeVertex(3);
        System.out.println(graph);
    }

}
