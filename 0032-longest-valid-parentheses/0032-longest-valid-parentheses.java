class Solution {
    public int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int max = 0;
        int length = s.length();

        for(int i=0;i<length;i++){
            char ch = s.charAt(i);
            if(ch=='(')open++;
            else if(ch==')')close++;
            if(open==close){
                max = Math.max(open*2,max);
            }else if(close>open) close = open = 0;
        }
        open = 0;
        close = 0;
        for(int i=length-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch==')')close++;
            else if(ch=='(')open++;
            if(open==close){
                max = Math.max(open*2,max);
            }else if(open>close) close = open = 0;
        }
        return max;
    }
}