package tree;

public class Solutions {
    public static void main(String[] args) {

    }

    private static TreeNode buildTree(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (node.value > value) {
            node.left = buildTree(node.left, value);
        } else {
            node.right = buildTree(node.right, value);
        }
        return node;
    }

    private static TreeNode buildTreeNodeFromSortedArray(TreeNode node, int[] array, int low, int high) {
        if (low > high) return node;
        int mid = low + (high - low) / 2;
        if (node.left != null) {
            node.left = buildTreeNodeFromSortedArray(node.left, array, low, mid - 1);
        } else {
            node.left = new TreeNode(array[mid]);
        }
        if (node.right != null) {
            node.right = buildTreeNodeFromSortedArray(node.left, array, mid + 1, high);
        } else {
            node.right = new TreeNode(array[mid]);
        }
        return node;
    }
}
