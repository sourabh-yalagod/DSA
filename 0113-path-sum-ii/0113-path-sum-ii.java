/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return result;
    }
    private void dfs(TreeNode node,int target){
        if(node==null) return;
        target-=node.val;
        list.add(node.val);
        if(node.left==null && node.right==null){
            if(target==0) result.add(new ArrayList<>(list));
        }else{
            dfs(node.left,target);
            dfs(node.right,target);
        }
        if(!list.isEmpty()) list.removeLast();
    }
}