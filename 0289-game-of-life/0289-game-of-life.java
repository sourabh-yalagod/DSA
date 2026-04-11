class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                sum(board, i, j);
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                if(board[i][j] == -1) board[i][j] = 1;
            }
        }
    }

    private void sum(int[][] board, int i, int j){
        int sum = 0;
        int row = board.length;
        int col = board[0].length;

        int[][] dirs = {
            {-1,0},{1,0},{0,-1},{0,1},
            {-1,-1},{-1,1},{1,-1},{1,1}
        };

        for(int[] d : dirs){
            int x = i + d[0];
            int y = j + d[1];

            if(x >= 0 && x < row && y >= 0 && y < col){
                if(board[x][y] == 1 || board[x][y] == 2){
                    sum++;
                }
            }
        }

        if(board[i][j] == 1){
            if(sum < 2 || sum > 3) board[i][j] = 2;
        } else {
            if(sum == 3) board[i][j] = -1;
        }
    }
}