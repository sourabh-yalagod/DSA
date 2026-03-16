class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dfs(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word,int i,int j,int index){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='#' || index>=word.length()) return false;
        char temp = board[i][j]; 
        if(temp!=word.charAt(index)) return false;
        if(index==word.length()-1) return true;
        board[i][j]='#';
        boolean isFound = 
            dfs(board,word,i,j+1,index+1)||
            dfs(board,word,i,j-1,index+1)||
            dfs(board,word,i-1,j,index+1)||
            dfs(board,word,i+1,j,index+1);

        board[i][j]= temp;
        return isFound;
    }
}