class Solution {
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }
    private void helper(char[] chars,int low,int high){
        if(low>=high) return;
        char temp = chars[low];
        chars[low] = chars[high];
        chars[high] = temp;
        helper(chars,low+1,high-1);
    }
}