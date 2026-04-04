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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root,subRoot);
    }
    private boolean dfs(TreeNode root, TreeNode subRoot){
        if(root==null) return false;
        boolean result = false;
        if(root.val==subRoot.val){
            result = isSame(root,subRoot);
        }
        return result || dfs(root.left,subRoot) || dfs(root.right,subRoot); 
    }
    private boolean isSame(TreeNode root1, TreeNode root2){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if(first==null && second==null) continue;
            if(first==null || second==null) return false;
            if(first.val != second.val) return false;
            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);
        }
        return true;
    }
}