class Solution {
    public String longestPalindrome(String str) {
        int left = 0;
        int right = 0;
        int length = str.length();
        String result = "";
        for(int i=0;i<length;i++){
            left = i;
            right = i;
            while(left>=0 && right < length){
                if(str.charAt(left)==str.charAt(right)){
                    if(result.length() <= (right - left + 1)){
                        result = str.substring(left, right + 1);
                    }
                    left--;
                    right++;
                }else break;
            }
            left = i;
            right = i+1;
            while(left>=0 && right < length){
                if(str.charAt(left)==str.charAt(right)){
                    if(result.length() <= (right - left + 1)){
                        result = str.substring(left, right + 1);
                    }
                    left--;
                    right++;
                }else break;
            }
        }
        return result;
    }
}