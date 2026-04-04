class Solution {
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(p);
    //     queue.add(q);
    //     while (!queue.isEmpty()) {
    //         TreeNode firstTreeNode = queue.poll();
    //         TreeNode secondTreeNode = queue.poll();
    //         if (firstTreeNode==null && secondTreeNode==null) continue;
    //         if (firstTreeNode==null || secondTreeNode==null) return false;
    //         if (firstTreeNode.val != secondTreeNode.val) return false;
    //         queue.add(firstTreeNode.left);
    //         queue.add(secondTreeNode.left);
    //         queue.add(firstTreeNode.right);
    //         queue.add(secondTreeNode.right);
    //     }
    //     return true;
    // }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}