class Solution {
    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int length = intervals.length;
        if(length==0 || length==1) return intervals;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]); // O N(log n)
        int[] interval = intervals[0];
        for(int i=1;i<length;i++){
            if(interval[1]<intervals[i][0]){
                result.add(interval);
                interval = intervals[i];
            }else {
                interval[1] = Math.max(interval[1],intervals[i][1]);
            }
        }
        result.add(interval);
        return result.toArray(new int[result.size()][2]);
    }
}