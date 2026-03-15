class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int water = 0;
        while(left<right){
            int height = Math.min(heights[left],heights[right]);
            int width = right - left;
            water = Math.max(water,(height * width));
            if(heights[left] > heights[right]) right--;
            else left++;
        }
        return water;
    }
}