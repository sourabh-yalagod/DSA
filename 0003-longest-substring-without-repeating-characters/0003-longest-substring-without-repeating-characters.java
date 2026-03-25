class Solution {
    public int lengthOfLongestSubstring(String string) {
        int left = 0;
        int right = 0;
        int length = string.length();
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while(right<length){
            char rightChar = string.charAt(right);
            while(set.contains(rightChar)){
                char leftChar = string.charAt(left++);
                set.remove(leftChar);
            }
            set.add(rightChar);
            maxLength = Math.max(maxLength , right-left+1);
            right++;
        }
        return maxLength;
    }
}