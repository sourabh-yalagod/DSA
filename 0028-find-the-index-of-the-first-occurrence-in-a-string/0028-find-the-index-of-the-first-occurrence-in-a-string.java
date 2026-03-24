class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int substrlen = needle.length();
        while(substrlen<=haystack.length()){
            String substr = haystack.substring(i,substrlen++);
            if(substr.equals(needle)) return i;
            i++;
        }
        return -1;
    }
}