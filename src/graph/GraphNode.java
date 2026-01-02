package graph;

public class GraphNode {
    private final int source;
    private final int destination;
    private final int weight;

    public GraphNode(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return this.source;
    }

    public int getDestination() {
        return this.destination;
    }

    public int getWeight() {
        return this.weight;
    }
}
