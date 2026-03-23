class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper("",n,n,list);
        return list;
    }
    public void helper(String processed, int open, int close,List<String> list) {
        if(open==0 && close==0){
            list.add(processed);
            return;
        }
        if(open > 0) helper(processed + "(",open-1,close,list);
        if(close > open) helper(processed + ")",open,close-1,list);
    }
}