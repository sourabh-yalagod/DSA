class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(char ch:num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek() > ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        boolean isLeadingZeros = true;
        for(char ch:stack){
            if(ch=='0' && isLeadingZeros) continue;
            else isLeadingZeros = false;
            str.append(ch);
        }
        return str.isEmpty() ? "0" : str.toString();
    }
}   