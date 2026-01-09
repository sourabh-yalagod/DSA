package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solutions {
    public static void main(String[] args) {
        Node parentNode = new Node(10);
        for (int i = 5; i <= 15; i++) {
            insertNode(parentNode, i);
        }
        printTree(parentNode);
        System.out.println(bfs(parentNode));
    }

    private static void insertNode(Node node, int value) {
        if (node == null) return;
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
                return;
            }
            insertNode(node.left, value);
        } else {
            if (node.right == null) {
                node.right = new Node(value);
                return;
            }
            insertNode(node.right, value);
        }
    }

    private static void printTree(Node node) {
        printTree(node, "", true);
    }

    private static void printTree(Node node, String prefix, boolean isTail) {
        if (node == null) return;

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value);

        // children
        if (node.left != null || node.right != null) {
            if (node.left != null)
                printTree(node.left, prefix + (isTail ? "    " : "│   "), node.right == null);

            if (node.right != null)
                printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    private static List<List<Integer>> bfs(Node parentNode) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(parentNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                innerList.add(node.value);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (!innerList.isEmpty()) list.add(innerList);
        }
        return list;
    }
}
