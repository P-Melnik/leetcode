package binary_tree_general;

public class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
