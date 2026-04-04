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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode firstTreeNode = queue.poll();
            TreeNode secondTreeNode = queue.poll();
            if (firstTreeNode==null && secondTreeNode==null) continue;
            if (firstTreeNode==null || secondTreeNode==null) return false;
            if (firstTreeNode.val != secondTreeNode.val) return false;
            queue.add(firstTreeNode.left);
            queue.add(secondTreeNode.left);
            queue.add(firstTreeNode.right);
            queue.add(secondTreeNode.right);
        }
        return true;
    }
}