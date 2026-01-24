package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solutions {
    public static void main(String[] args) {
        String[][] graph = {
                {"1", "1", "1", "1"},
                {"1", "0", "0", "1"},
                {"0", "1", "0", "1"},
                {"1", "0", "1", "1"}
        };
    }

    public static int numIslands(String[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].equals("1")) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(String[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j].equals("0")) return;
        grid[i][j] = "0";
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        return;
    }

    public static int maxAreaOfIsland(String[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].equals("1")) {
                    count = Math.max(dfsForArea(grid, i, j), count);
                }
            }
        }
        return count;
    }

    private static int dfsForArea(String[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j].equals("0")) return 0;
        grid[i][j] = "0";
        int area = 1;
        area += dfsForArea(grid, i, j - 1);
        area += dfsForArea(grid, i, j + 1);
        area += dfsForArea(grid, i - 1, j);
        area += dfsForArea(grid, i + 1, j);
        return area;
    }

    private Node cloneGraph(Node root) {
        if (root == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        map.put(root, new Node(root.val));
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node neighbor : node.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(node).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(root);
    }

    public char[][] solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '0') {
                    dfsForBoard(board, i, j);
                }
            }
        }
        return board;
    }

    private void dfsForBoard(char[][] board, int i, int j) {
        if (i <= 0 || j <= 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == '0') return;
        board[i][j] = '0';
        dfsForBoard(board, i, j - 1);
        dfsForBoard(board, i, j + 1);
        dfsForBoard(board, i - 1, j);
        dfsForBoard(board, i + 1, j);
        return;
    }
}
