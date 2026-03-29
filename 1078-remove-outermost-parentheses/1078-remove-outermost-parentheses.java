class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        StringBuilder result = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(open>0){
                    result.append("(");
                }
                ++open;
            }
            else {
                --open;
                if(open>0){
                    result.append(")");
                }
            }
        }
        return result.toString();
    }
}