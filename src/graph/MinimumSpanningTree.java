package graph;

import java.util.*;

public class MinimumSpanningTree {
    private static Map<Integer, List<GraphNode>> graph = new HashMap<>();

    private static void addVertex(int value) {
        graph.put(value, new ArrayList<GraphNode>());
    }

    private static void addEdges(int source, int destination, int weight) {
        GraphNode graphNode = new GraphNode(source, destination, weight);
        graph.get(source).add(graphNode);
        graph.get(destination).add(graphNode);
    }

    public static void main(String[] args) {
        addVertex(1);
        addVertex(2);
        addVertex(3);
        addVertex(4);
        addEdges(1, 2, 1);
        addEdges(1, 3, 2);
        addEdges(2, 4, 4);
        addEdges(3, 4, 1);
        minSpanTreeUsingPrims(1);
    }

    private static void printGraph() {
        for (Map.Entry<Integer, List<GraphNode>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (GraphNode node : entry.getValue()) {
                System.out.print("(" + node.getSource() + "," + node.getDestination() + "," + node.getWeight() + ") ");
            }
        }
        System.out.println();
    }

    private static void minSpanTreeUsingPrims(int startVertex) {
        PriorityQueue<GraphNode> pq = new PriorityQueue<>(Comparator.comparingInt(GraphNode::getWeight));
        Set<Integer> visited = new HashSet<>();
        pq.addAll(graph.get(startVertex));
        visited.add(startVertex);
        int cost = 0;
        while (!pq.isEmpty()) {
            GraphNode node = pq.poll();
            int next = visited.contains(node.getSource()) ? node.getDestination() : node.getSource();
            if (visited.contains(next)) continue;
            visited.add(next);
            pq.addAll(graph.get(next));
            System.out.println(
                    node.getSource() + " - " +
                            node.getDestination() + " (w=" + node.getWeight() + ")"
            );
            cost += node.getWeight();
        }
        System.out.println("Minimum Cost : " + cost);
    }
}
