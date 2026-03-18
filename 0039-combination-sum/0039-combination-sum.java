class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length==0)return result;
        List<Integer> list = new ArrayList<>();
        backtrack(candidates,target,0,list,result);
        return result;
    }
    private void backtrack(int[] array,int target,int index,List<Integer> list,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target<0)return;
        int length = array.length;
        for(int i=index;i<length;i++){
            list.add(array[i]);
            backtrack(array,target-array[i],i,list,result);
            list.removeLast();
        }
    }
}