package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Solutions {
    public static void main(String[] args) {
        int[][] graph = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(rotaOranges(graph));
    }

    private static int rotaOranges(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        int max = 0;
        int fresh = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 2) queue.add(new int[]{i, j});
                if (graph[i][j] == 1) fresh++;
            }
        }
        if (fresh == 0) return 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            boolean isRotted = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < graph.length && ny >= 0 && ny < graph[0].length && graph[nx][ny] == 1) {
                        graph[nx][ny] = 2;
                        fresh--;
                        isRotted = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            if (isRotted) max++;
        }
        return fresh == 0 ? max : -1;
    }
}
