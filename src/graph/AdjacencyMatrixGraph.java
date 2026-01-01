package graph;

public class AdjacencyMatrixGraph {
    private static int[][] graph;
    private static int index = 0;

    public AdjacencyMatrixGraph(int size) {
        graph = new int[size][size];
        index = size;
    }

    public static void main(String[] args) {
        new AdjacencyMatrixGraph(4);
        printGraph(graph);
        decreaseMatrixSize();
        printGraph(graph);
    }

    private static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void addEdge(int i, int j) {
        i--;
        j--;
        graph[i][j] = 1;
        graph[j][i] = 1;
    }

    private static void removeEdge(int i, int j) {
        i--;
        j--;
        graph[i][j] = 0;
        graph[j][i] = 0;
    }

    private static void increaseMatrixSize() {
        int[][] newMatrix = new int[index + 1][index + 1];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                newMatrix[i][j] = graph[i][j];
            }
        }
        graph = newMatrix;
        index++;
    }

    private static void decreaseMatrixSize() {
        int[][] newMatrix = new int[index - 1][index - 1];
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][i] = graph[i][j];
            }
        }
        graph = newMatrix;
        index--;
    }
}
