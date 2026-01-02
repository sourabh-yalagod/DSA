package graph;

import java.util.*;

public class DFS {
    public static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void addVertex(int value) {
        graph.put(value, new ArrayList<>());
    }

    public static void addEdge(int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public static void main(String[] args) {
        addVertex(1);
        addVertex(2);
        addVertex(3);
        addVertex(4);
        addVertex(5);
        addEdge(1, 4);
        addEdge(2, 3);
        addEdge(1, 2);
        addEdge(3, 5);
        addEdge(3, 2);
        System.out.println(dfs(1));
    }

    private static List<Integer> dfs(int start) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(start);
        set.add(start);
        result.add(start);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            List<Integer> list = graph.get(vertex);
            list.forEach(ele -> {
                if (!set.contains(ele)) {
                    set.add(ele);
                    result.add(ele);
                    stack.push(ele);
                }
            });
        }
        return result;
    }
}
