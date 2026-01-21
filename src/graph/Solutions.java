package graph;

public class Solutions {
    public static void main(String[] args) {
        String[][] graph = {
                {"0", "1", "1", "1", "0"},
                {"0", "1", "1", "", "0"},
                {"0", "0", "1", "1", "1"}
        };
        System.out.println(numIslands(graph));
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
}
