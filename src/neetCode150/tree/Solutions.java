package neetCode150.tree;

import java.util.*;

public class Solutions {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
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

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Integer re = 0;
        dfsForDiameter(root, re);
        return (int) re;
    }

    private int dfsForDiameter(TreeNode root, Integer val) {
        if (root == null) return 0;
        int left = dfsForDiameter(root.left, val);
        int right = dfsForDiameter(root.right, val);
        val = Math.max(left + right, val);
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = dfsForToCheckBalance(root.left);
        int right = dfsForToCheckBalance(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfsForToCheckBalance(TreeNode node) {
        if (node == null) return 0;
        int left = dfsForToCheckBalance(node.left);
        int right = dfsForToCheckBalance(node.right);
        return Math.max(left, right) + 1;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode firstTreeNode = queue.poll();
            TreeNode secondTreeNode = queue.poll();
            if (Objects.isNull(firstTreeNode) && Objects.isNull(secondTreeNode)) continue;
            if (Objects.isNull(firstTreeNode) || Objects.isNull(secondTreeNode)) return false;
            if (firstTreeNode.val != secondTreeNode.val) return false;
            queue.add(firstTreeNode.left);
            queue.add(secondTreeNode.left);
            queue.add(firstTreeNode.right);
            queue.add(secondTreeNode.right);
        }
        return true;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        TreeNode node = findSubTreeNode(root, subRoot);
        return isSameTree(node, subRoot);
    }

    private TreeNode findSubTreeNode(TreeNode node, TreeNode subRoot) {
        if (node == null) return null;
        if (node.val == subRoot.val) return node;
        TreeNode leftNode = findSubTreeNode(node.left, subRoot);
        if (leftNode != null) return leftNode;
        return findSubTreeNode(node.right, subRoot);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) return root;
        else return leftNode != null ? leftNode : rightNode;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            list.add(level);
        }
        return list;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (i == size - 1) list.add(node.val);
            }
        }
        return list;
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return dfsToValidateBST(list, root);
    }

    private boolean dfsToValidateBST(List<Integer> list, TreeNode root) {
        if (root == null) return true;
        boolean left = dfsToValidateBST(list, root.left);
        if (!list.isEmpty() && list.getLast() > root.val) return false;
        list.add(root.val);
        boolean right = dfsToValidateBST(list, root.right);
        return right && left;
    }

    public int kthSmallest(TreeNode root, int k) {
        return dfsForKthSmallestElement(root, k);
    }

    private int dfsForKthSmallestElement(TreeNode node, int k) {
        if (node == null) return 0;
        int left = dfsForKthSmallestElement(node.left, k);
        if (k == 0) return node.val;
        int right = dfsForKthSmallestElement(node.right, k);
        return left == 0 ? left : right;
    }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfsForMaxPath(root);
        return max;
    }
    private int dfsForMaxPath(TreeNode node) {
        if (node == null) return 0;
        int left = dfsForMaxPath(node.left);
        int right = dfsForMaxPath(node.right);
        this.max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
