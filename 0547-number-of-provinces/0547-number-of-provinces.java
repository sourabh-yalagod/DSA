class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i] && isConnected[i][j]==1){
                    dfs(isConnected,visited,i);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected,boolean[] visited,int j){
        if(visited[j]) return;
        visited[j] = true;
        int n = isConnected.length;
        for(int i=0;i<n;i++){
            if(isConnected[j][i]==1 && !visited[i]) dfs(isConnected,visited,i);
        }
    }
}