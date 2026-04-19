class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int[] row:matrix){
            for(int val:row){
                pq.offer(val);
                if(pq.size()>k) pq.poll();
            }
        }
        return pq.poll();
    }
}