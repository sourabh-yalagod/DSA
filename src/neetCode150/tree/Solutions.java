package neetCode150.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solutions {
    public static void main(String[] args) {

    }

    private static TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }

    private static int maxDepth(TreeNode root) {
        Integer count = 0;
        count = helper(root, count);
        return (int) count;
    }

    private static Integer helper(TreeNode node, Integer count) {
        if (node == null) return count;
        int currentCount = 0;
        if (node.left != null) {
            currentCount += helper(node.left, count);
        }
        currentCount += helper(node.right, count);
        return Math.max(count, currentCount);
    }
}
