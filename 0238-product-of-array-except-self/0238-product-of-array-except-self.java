class Solution {
    public int[] productExceptSelf(int[] array) {
        int length = array.length;
        int[] prefix = new int[length];
        int[] postfix = new int[length];
        int[] result = new int[length];
        int sum = 1;
        prefix[0] = sum; 
        for(int i=1;i<length;i++){
            prefix[i] = sum * array[i-1];
            sum = prefix[i];
        }
        sum = 1;
        postfix[length-1] = sum; 
        for(int i=length-2;i>=0;i--){
            postfix[i] = sum * array[i+1];
            sum = postfix[i];
        }
        for(int i=0;i<length;i++){
            result[i] = prefix[i] * postfix[i];
        }
        return result;
    }
}