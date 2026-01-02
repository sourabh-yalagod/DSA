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
//        minSpanTreeUsingPrims(1);
        kurshal();
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
        Stack<Integer> set = new Stack<>();
        pq.addAll(graph.get(startVertex));
        set.add(startVertex);
        int minCost = 0;
        while (!pq.isEmpty()) {
            GraphNode node = pq.poll();
            int nextNode = set.contains(node.getSource()) ? node.getDestination() : node.getSource();
            if (set.contains(nextNode)) continue;
            pq.addAll(graph.get(nextNode));
            set.add(nextNode);
            minCost += node.getWeight();
            System.out.println(nextNode + "->" + "[" + node.getSource() + " - " + node.getDestination() + "]");
        }
        System.out.println("MinCost : " + minCost);
    }

    private static void kurshal() {
        PriorityQueue<GraphNode> pq = new PriorityQueue<>(Comparator.comparingInt(GraphNode::getWeight));
        Set<Integer> set = new HashSet<>();
        for (int key : graph.keySet()) {
            pq.addAll(graph.get(key));
        }
        while (!pq.isEmpty()) {
            GraphNode node = pq.poll();
            if (!set.contains(node.getSource())) set.add(node.getSource());
            if (!set.contains(node.getDestination())) set.add(node.getDestination());
            if (set.contains(node.getDestination()) && set.contains(node.getSource()))
                System.out.println(node.getSource() + "->" + "[" + node.getSource() + " - " + node.getDestination() + "]");
        }
    }
}
